package com.stepanov.bbf.bugfinder.generator.targetsgenerators

import com.intellij.psi.PsiElement
import com.stepanov.bbf.bugfinder.mutator.MutationProcessor
import com.stepanov.bbf.bugfinder.mutator.MutationProcessor.psiFactory
import com.stepanov.bbf.bugfinder.project.BBFFile
import com.stepanov.bbf.bugfinder.util.*
import com.stepanov.bbf.reduktor.parser.PSICreator
import org.apache.log4j.Logger
import org.jetbrains.kotlin.cfg.getDeclarationDescriptorIncludingConstructors
import org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor
import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.descriptors.ConstructorDescriptor
import org.jetbrains.kotlin.descriptors.FunctionDescriptor
import org.jetbrains.kotlin.load.java.descriptors.JavaClassConstructorDescriptor
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.psi.psiUtil.parents
import org.jetbrains.kotlin.resolve.calls.components.hasDefaultValue
import org.jetbrains.kotlin.resolve.calls.components.isVararg
import org.jetbrains.kotlin.types.KotlinType
import org.jetbrains.kotlin.types.isNullable
import kotlin.random.Random

internal class FunInvocationGenerator(file: BBFFile) :
    TypeAndValueParametersGenerator(file) {

    private val MAX_DEPTH = 20
    private val log = Logger.getLogger("mutatorLogger")

    fun generateFunctionCallWithoutTypeParameters(
        functionDescriptor: FunctionDescriptor,
        typeParameters: Map<String, KotlinType?>,
        depth: Int
    ): PsiElement? {
        val randomInstanceGenerator = RandomInstancesGenerator(file)
//        log.debug("Generating call of $functionDescriptor")
        val funcName =
            when (functionDescriptor) {
                is JavaClassConstructorDescriptor -> functionDescriptor.constructedClass.name
                is ClassConstructorDescriptor -> functionDescriptor.constructedClass.name
                else -> functionDescriptor.name
            }
        val typeParamsAsString =
            functionDescriptor.typeParameters.map {
                typeParameters[it.name.asString()] ?: "Any"
            }.let { if (it.isEmpty()) "" else "<${it.joinToString()}>" }
        val extRecValue =
            if (functionDescriptor.containingDeclaration is ClassDescriptor && functionDescriptor !is ConstructorDescriptor) {
                ((functionDescriptor.containingDeclaration) as ClassDescriptor).name.asString() + "."
            } else {
                functionDescriptor.extensionReceiverParameter?.type?.let {
                    randomInstanceGenerator.generateValueOfType(it, depth) + "."
                } ?: ""
            }
        val valueParams = functionDescriptor.valueParameters.map {
            if (it.isVararg) {
                val randomSize = Random.nextInt(1, 4)
                val elType = it.varargElementType!!
                List(randomSize) { "" }.map {
                    randomInstanceGenerator.generateValueOfType(elType, depth).let { it.ifEmpty { return null } }
                }.joinToString()
            } else {
                randomInstanceGenerator.generateValueOfType(it.type, depth).let { it.ifEmpty { return null } }
            }
        }.joinToString()
        val callExpression = """$extRecValue$funcName$typeParamsAsString($valueParams)"""
        return try {
            psiFactory(file).createExpression(callExpression)
        } catch (e: Exception) {
            null
        }
    }

    fun invokeFunction(func: KtNamedFunction,
                       file: BBFFile, mainFile: BBFFile): String {
        val outerRef = func.myReceiverTypeReference
        val funInvocation = generateTopLevelFunInvocation(func, file) ?: return ""
        val returnType = func.getReturnType(file.ctx!!)
        val property =
            if (returnType != null)
                "val ${Random.getRandomVariableName()}: ${returnType.name}" +
                        "${if (returnType.isNullable()) "?" else ""} = "
            else
                ""
        if (outerRef == null) {
            return property + funInvocation.text
        }
        val clazz = file.psiFile.findClassByName(outerRef.text)
        if (clazz == null) {
            return ""
        }

        val instance = mainFile.psiFile.findPropertyByType(outerRef.text)?.name ?:
            RandomInstancesGenerator(file).generateRandomInstanceOfClass(clazz)?.first?.text
        if (instance == null) {
            return ""
        }

        return "$property$instance.${funInvocation.text}"
    }

    fun generateTopLevelFunInvocation(
        func: KtNamedFunction,
        file: BBFFile,
        depth: Int = 0
    ): KtCallExpression? {
        val descriptor = func.getDeclarationDescriptorIncludingConstructors(file.ctx!!) as? FunctionDescriptor ?: return null
        return generateTopLevelFunInvocation(descriptor, depth)
    }


    fun generateTopLevelFunInvocation(
        func: FunctionDescriptor,
        depth: Int = 0
    ): KtCallExpression? {
        val randomInstanceGenerator = RandomInstancesGenerator(file)
        val (descriptorWithoutTypeParams, realTypeParams) = TypeParamsReplacer.throwTypeParams(file, null, func)
            ?: return null
        val extensionReceiverType = descriptorWithoutTypeParams.extensionReceiverParameter?.value?.type
        val realTypeParamsAsString =
            if (func.typeParameters.isEmpty()) ""
            else func.typeParameters.map { realTypeParams[it.name.asString()] }
                .joinToString(prefix = "<", postfix = ">")
        val generatedExtensionReceiver =
            if (extensionReceiverType == null) {
                ""
            } else {
                randomInstanceGenerator.tryToGenerateValueOfType(extensionReceiverType, 2, depth + 1).ifEmpty { return null } + "."
            }
        val valueArgsAsString =
            if (descriptorWithoutTypeParams.valueParameters.isEmpty()) {
                "()"
            } else {
                val haveArgsWithDefaultValues = descriptorWithoutTypeParams.valueParameters.any { it.hasDefaultValue() }
                val generatedValueParams =
                    descriptorWithoutTypeParams.valueParameters
                        .map { valueParam ->
                            val valueParamType =
                                if (valueParam.isVararg) {
                                    valueParam.varargElementType ?: return null
                                } else {
                                    valueParam.type
                                }
                            if (valueParam.hasDefaultValue() && Random.getTrue(50)) {
                                ""
                            } else {
                                randomInstanceGenerator
                                    .tryToGenerateValueOfType(valueParamType, 2, depth + 1)
                                    .ifEmpty { return null }
                            }
                        }
                if (haveArgsWithDefaultValues) {
                    descriptorWithoutTypeParams.valueParameters
                        .zip(generatedValueParams)
                        .filter { it.second.isNotEmpty() }
                        .map { "${it.first.name.asString()} = ${it.second}" }
                        .shuffled()
                        .joinToString(prefix = "(", postfix = ")")
                } else {
                    generatedValueParams
                        .filter { it.isNotEmpty() }
                        .joinToString(prefix = "(", postfix = ")")
                }
            }
        val callExpressionAsString =
            "$generatedExtensionReceiver${func.name}$realTypeParamsAsString$valueArgsAsString"
        return MutationProcessor.createExpressionOrThrow(file, callExpressionAsString) as? KtCallExpression
    }

    private val KtNamedFunction.myReceiverTypeReference
        get() =
            if (this.receiverTypeReference != null) receiverTypeReference
            else {
                val type = this.parents
                    .filterIsInstance<KtClassOrObject>()
                    .toList()
                    .reversed()
                    .joinToString(".") { it.name ?: "" }
                if (type.isEmpty()) null
                else try {
                    PSICreator.psiFactory.createTypeIfPossible(type)
                } catch (e: Exception) {
                    null
                }
            }


}
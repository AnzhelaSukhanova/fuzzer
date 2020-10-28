package com.stepanov.bbf.bugfinder.mutator.transformations.tce

import com.intellij.psi.PsiElement
import com.stepanov.bbf.bugfinder.mutator.transformations.Factory
import com.stepanov.bbf.bugfinder.util.*
import com.stepanov.bbf.bugfinder.util.KotlinTypeCreator.recreateType
import com.stepanov.bbf.reduktor.parser.PSICreator
import com.stepanov.bbf.reduktor.util.getAllChildren
import org.apache.log4j.Logger
import org.jetbrains.kotlin.builtins.isExtensionFunctionType
import org.jetbrains.kotlin.builtins.isFunctionType
import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.psi.psiUtil.getValueParameters
import org.jetbrains.kotlin.psi.psiUtil.isAbstract
import org.jetbrains.kotlin.psi.psiUtil.isPrivate
import org.jetbrains.kotlin.psi.psiUtil.parents
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.bindingContextUtil.getAbbreviatedTypeOrType
import org.jetbrains.kotlin.types.*
import org.jetbrains.kotlin.types.typeUtil.*
import kotlin.random.Random

class RandomInstancesGenerator(private val file: KtFile) {

    fun generateTopLevelFunctionCall(
        function: KtNamedFunction,
        m: Map<String, String> = mapOf(),
        withTypeParams: Boolean = true,
        depth: Int = 0
    ): Pair<KtExpression, List<KtParameter>>? {
        var typeParamsToRealTypeParams = m
        if (function.bodyExpression == null || function.name == null) return null
        if (function.receiverTypeReference == null && function.typeParameters.isEmpty() && function.valueParameters.isEmpty()) {
            return Factory.psiFactory.createExpression("${function.name}()") to listOf()
        }
        ctx = PSICreator.analyze(file)!!
        log.debug("GENERATING CALL OF ${function.text}")
        val addedFun =
            if (!file.getAllChildren().contains(function)) {
                file.addToTheEnd(function) as KtNamedFunction
            } else {
                function
            }
        var func = function.copy() as KtNamedFunction
        if (withTypeParams && func.typeParameterList != null) {
            if (m.isEmpty()) typeParamsToRealTypeParams = generateRandomTypeParams(
                function.typeParameters,
                func.valueParameters,
                func.text.substringBefore(func.bodyExpression!!.text),
                ctx,
                func = func
            )?.second ?: mapOf()
        }
        log.debug("WITHOUT TYPE PARAMS = ${func.text}")
        addedFun.replaceThis(func)
        val creator = PSICreator("")
        val newFile = creator.getPSIForText(file.text)
        val ctx = creator.ctx!!
        func.replaceThis(addedFun)
        if (addedFun != function) addedFun.delete()
        func = newFile.getAllChildren().find { it.text.trim() == func.text.trim() } as? KtNamedFunction ?: return null
        val generatedParams = func.valueParameters
            .map { it.typeReference?.getAbbreviatedTypeOrType(ctx) }
            .map {
                it?.let {
                    generateValueOfType(it, depth + 1).let {
                        if (it.trim().isEmpty()) return null else it
                    }
                } ?: return null
            }
            .joinToString(", ")
        val generatedReciever =
            func.receiverTypeReference?.getAbbreviatedTypeOrType(ctx)?.let { generateValueOfType(it, depth + 1) + "." } ?: ""
        val typeParams =
            func.typeParameters.map { typeParamsToRealTypeParams.getOrDefault(it.name!!, it.name!!) }
                .let { if (it.isNotEmpty()) it.joinToString(prefix = "<", postfix = ">") else "" }
        val expr =
            Factory.psiFactory.createExpressionIfPossible("$generatedReciever${func.name}$typeParams($generatedParams)")
                ?: return null
        log.debug("GENERATED = ${expr.text}")
        return expr to func.valueParameters
    }

    fun generateRandomInstanceOfClass(
        klOrObj: KtClassOrObject,
        typeArgs: List<TypeProjection> = listOf(),
        depth: Int = 0
    ): PsiElement? {
        log.debug("generating klass ${klOrObj.name} text = ${klOrObj.text}")
        if (klOrObj.name == null || klOrObj.isAnnotation() ||
            klOrObj.isLocal || klOrObj.isPrivate() ||
            klOrObj.primaryConstructor?.isPrivate() == true
        ) return null
        if (klOrObj.parents.any { it is KtClassOrObject }) return null
        if (klOrObj is KtObjectDeclaration) {
            return Factory.psiFactory.createExpression(klOrObj.prefix + klOrObj.name)
        }
        val kl = klOrObj as KtClass
        if (kl.isInterface() && kl.hasModifier(KtTokens.FUN_KEYWORD)) {
            //TODO FUNINTEFACES
            return null
        }
        //IF ENUM
        if (kl.isEnum()) {
            val randomEnum = kl.body?.enumEntries?.randomOrNull() ?: return null
            return Factory.psiFactory.createExpression("${kl.name}.${randomEnum.name}")
        }
        if (kl.primaryConstructor == null && !(kl.isAbstract() || kl.isInterface())) {
            val genTypeParams =
                if (kl.typeParameters.isNotEmpty()) {
                    ctx = PSICreator.analyze(file)!!
                    generateRandomTypeParams(
                        kl.typeParameters,
                        listOf(),
                        kl.name!!,
                        ctx,
                        typeArgs
                    )?.first?.joinToString(prefix = "<", postfix = ">") { it.text } ?: ""
                } else ""
            return Factory.psiFactory.createExpression(
                "${kl.name}$genTypeParams()"
            )
        }
        //Case of generating instance of children klass if it exists
//        if (Random.nextBoolean()) {
//            findImplementationAndGenerateInstance(kl)?.let { return it }
//        }
        val klass = kl.copy() as KtClassOrObject
        kl.replaceThis(klass)
        ctx = PSICreator.analyze(file)!!
        val generatedTypeParams =
            if (klass.typeParameters.isEmpty()) listOf()
            else generateRandomTypeParams(
                klass.typeParameters,
                klass.getValueParameters(),
                klass.name!!,
                ctx,
                typeArgs
            )?.first
                ?: return null
        if (kl.isInterface() || kl.isAbstract()) {
            val typeParams = generatedTypeParams.let {
                if (it.isEmpty()) ""
                else it.joinToString(prefix = "<", postfix = ">") { it.text }
            }
            val strRepresentation = klass.name + typeParams
            val kType = KotlinTypeCreator.createType(file, strRepresentation)!!
            val impl =
                UsageSamplesGeneratorWithStLibrary.findImplementaionFromFile(kType, true).randomOrNull() ?: return null
            val superTypeEntry =
                impl.typeConstructor.supertypes.find { it.toString().substringBefore('<') == klass.name } ?: return null
            val genTypeParamsToTypeParams =
                superTypeEntry.arguments
                    .filter { it.type.isTypeParameter() }
                    .map { it.toString() }
                    .zip(kType.arguments)
                    .toMap()
            val newArgs = impl.defaultType.arguments.map { arg ->
                arg.substitute { genTypeParamsToTypeParams.getOrDefault(arg.toString().substringBefore('<'), arg).type }
            }
            val newImpl = impl.defaultType.replace(newArgs)
            val generated = generateValueOfType(newImpl, depth + 1)
            if (generated.trim().isEmpty()) return null
            return Factory.psiFactory.createExpression(generated)
            //findImplementationAndGenerateInstance(kl)?.let { return it }
        }
        log.debug("Type params = ${generatedTypeParams.map { it.text }}")
        if (kl.primaryConstructor == null && !kl.isInterface() && !kl.isAbstract()) {
            val typeParams =
                if (kl.typeParameters.isEmpty()) ""
                else generatedTypeParams.joinToString(prefix = "<", postfix = ">") { it.text }
            klass.replaceThis(kl)
            return Factory.psiFactory.createExpression("${kl.name}$typeParams()")
        }
        val listOfParams = klass.allConstructors.map { it.valueParameters }
        val res = mutableListOf<String>()
        ctx = PSICreator.analyze(file)!!
        for (param in /*listOfParams.random()*/ listOfParams[0]) {
            require(param.typeReference != null)
            var realType = param.typeReference!!.getAbbreviatedTypeOrType(ctx) ?: return null
            if (realType.isErrorType() || realType.arguments.flatten<TypeProjection>().any { it.type.isErrorType() }) {
                realType = recreateType(file, param.typeReference!!) ?: return null
            }
            if (realType.constructor.declarationDescriptor!!.name.asString() == kl.name) return null
            //if (realType.toString().contains("${klass.name}")) return null
            val instance = generateValueOfType(realType, depth + 1)
            res.add(instance)
        }
        val constructor =
            if (klass.typeParameters.size == 0)
                klass.name
            else
                "${klass.name}<${generatedTypeParams.joinToString { it.text }}>"
        val r = Factory.psiFactory.createExpression("${klass.prefix + constructor}(${res.joinToString()})")
        klass.replaceThis(kl)
        return r
    }

    private fun generateRandomTypeParams(
        typeParameters: List<KtTypeParameter>,
        valueParameters: List<KtParameter>,
        name: String,
        ctx: BindingContext,
        typeProjections: List<TypeProjection> = listOf(),
        func: KtNamedFunction? = null
    ): Pair<List<KtTypeReference>, Map<String, String>>? {
        randomTypeGenerator.setFileAndContext(file, ctx)
        if (typeParameters.isEmpty()) return null
        val generatedTypeParams =
            (if (func != null) typeParameters.map {
                randomTypeGenerator.generateRandomTypeWithCtx(
                    it.extendsBound?.getAbbreviatedTypeOrType(
                        ctx
                    )
                )
            }.map { it?.asTypeProjection() ?: return null }
            else randomTypeGenerator.getTypeFromFile(name)?.arguments)
                ?: return null
        //require(generatedTypeParams != null) { println("cant generate type params") }
        val generatedTypeParamsPsi =
            if (typeProjections.isEmpty())
                generatedTypeParams.map { Factory.psiFactory.createType(it.type.toString()) }
            else
                generatedTypeParams.zip(typeProjections)
                    .map { if (it.second.type.isTypeParameter()) it.first else it.second }
                    .map { Factory.psiFactory.createType(it.type.toString()) }
//        val generatedTypeParamsPsi =
//            generatedTypeParams.arguments.map { Factory.psiFactory.createType(it.type.toString()) }
        val strTypeParamToRandomType = mutableMapOf<String, String>()
        typeParameters.zip(generatedTypeParamsPsi)
            .forEach { strTypeParamToRandomType[it.first.name!!] = it.second.text }
        valueParameters.forEach { param ->
            param.typeReference?.getAllPSIChildrenOfType<KtReferenceExpression>()?.map { typeRef ->
                strTypeParamToRandomType[typeRef.text]?.let { typeRef.replaceThis(Factory.psiFactory.createExpression(it)) }
            }
        }
        if (func != null) {
            listOfNotNull(func.typeReference, func.receiverTypeReference).forEach { param ->
                param.getAllPSIChildrenOfType<KtReferenceExpression>().map { typeRef ->
                    strTypeParamToRandomType[typeRef.text]?.let {
                        typeRef.replaceThis(
                            Factory.psiFactory.createExpression(
                                it
                            )
                        )
                    }
                }
            }
        }
        return generatedTypeParamsPsi to strTypeParamToRandomType
    }

    private val KtClassOrObject.prefix: String
        get() = this.parents
            .filter { it is KtClassOrObject && it.name != null }
            .joinToString(".", postfix = ".") { (it as KtClassOrObject).name!! }
            .let { if (it == ".") "" else it }

    fun generateValueOfType(type: KotlinType, depth: Int = 0): String {
        log.debug("generating value of type = $type ${type.isPrimitiveTypeOrNullablePrimitiveTypeOrString()} depth = $depth")
        if (depth > MAGIC_CONST) return ""
        //TODO deal with Any KReflection
        //if (type.isAnyOrNullableAny()) return generateDefValuesAsString(generateRandomType())
        if (type.isAnyOrNullableAny()) return generateDefValuesAsString("String")
        if (type.isError || type.arguments.flatten<TypeProjection>().any { it.type.isError }) {
            val recreatedType = recreateType(fileCopy, type)
            log.debug("RECREATED ERROR TYPE = $recreatedType")
            if (recreatedType == null || recreatedType.isError) {
                val name = (type as? UnresolvedType)?.presentableName ?: return ""
                return generateDefValuesAsString(name)
            }
            if (recreatedType.arguments.flatten<TypeProjection>().any { it.type.isError }) return ""
            return generateValueOfType(recreatedType, depth)
        }
        file.getClassWithName(type.constructor.toString())?.let {
            val res = generateRandomInstanceOfClass(it, type.arguments, depth + 1)
            return res?.text ?: ""
        }
        if (type.isEnum()) return UsageSamplesGeneratorWithStLibrary.findEnumMembers(type).randomOrNull()?.toString()
            ?: ""
        if (type.isPrimitiveTypeOrNullablePrimitiveTypeOrString())
            generateDefValuesAsString(type.toString()).let { if (it.isNotEmpty()) return it }
        if (type.isFunctionType) {
            if (type.arguments.isEmpty()) return ""
            val args =
                if (type.isExtensionFunctionType) type.arguments.getAllWithout(0).getAllWithoutLast()
                else type.arguments.getAllWithoutLast()
            val prefix = if (args.isEmpty()) ""
            else args
                .mapIndexed { i, t -> "${'a' + i}: ${t.type}" }
                .joinToString() + " ->"
            return "{$prefix ${generateValueOfType(type.arguments.last().type, depth + 1)}}"
        }
        return searchForImplementation(type, depth + 1)
    }

    private fun searchForImplementation(type: KotlinType, depth: Int): String {
        var funcs = UsageSamplesGeneratorWithStLibrary.searchForFunWithRetType(type)
        funcs = if (Random.getTrue(75))
            funcs.filter { it.extensionReceiverParameter == null }
        else
            funcs.filter { it.extensionReceiverParameter?.value?.type?.arguments?.isEmpty() ?: true } //TODO
        val implementations = UsageSamplesGeneratorWithStLibrary.findImplementationOf(type)
        val prob = if (funcs.size > implementations.size) 75 else 25
        val el =
            if (Random.getTrue(prob)) {
                funcs.randomOrNull() ?: implementations.randomOrNull()
            } else {
                implementations.randomOrNull() ?: funcs.randomOrNull()
            }
        if (el is ClassDescriptor && el.defaultType.isPrimitiveTypeOrNullablePrimitiveTypeOrString())
            return generateDefValuesAsString(el.name.asString())
        randomTypeGenerator.setFileAndContext(file, ctx)
        val (psi, typeParamsToRealTypes) = when (el) {
            is SimpleFunctionDescriptor -> TypeParamsReplacer.throwTypeParams(type, el, randomTypeGenerator)
            is ClassDescriptor -> TypeParamsReplacer.throwTypeParams(type, el, randomTypeGenerator)
            else -> return ""
        }
        val extTypeRec = (el as? SimpleFunctionDescriptor)?.extensionReceiverParameter?.value?.type
        val generatedExtension = extTypeRec?.let { generateValueOfType(it) + "." } ?: ""
        generateTopLevelFunctionCall(psi, typeParamsToRealTypes, false, depth + 1)?.let {
            return "$generatedExtension${it.first.text}"
        } ?: return ""
    }

    private fun getTypeNameWithoutError(type: KotlinType): String? =
        (type as? UnresolvedType)?.presentableName


    private val typeParamToRandomType: MutableMap<String, KotlinType> = mutableMapOf()

    val amount: Int
        get() = Random.nextInt(1, 3)

    private val fileCopy = file.copy() as KtFile
    private var ctx: BindingContext = PSICreator.analyze(file)!!
    val randomTypeGenerator = RandomTypeGenerator
    private val MAGIC_CONST = 15
    private val log = Logger.getLogger("mutatorLogger")

}
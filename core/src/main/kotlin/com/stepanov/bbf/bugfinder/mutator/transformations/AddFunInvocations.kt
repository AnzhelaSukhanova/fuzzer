package com.stepanov.bbf.bugfinder.mutator.transformations

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiWhiteSpace
import com.stepanov.bbf.bugfinder.project.BBFFile
import com.stepanov.bbf.bugfinder.project.Project
import com.stepanov.bbf.bugfinder.mutator.MutationProcessor
import com.stepanov.bbf.bugfinder.util.generateDefValuesAsString
import com.stepanov.bbf.bugfinder.util.getAllPSIDFSChildrenOfType
import com.stepanov.bbf.bugfinder.util.getType
import com.stepanov.bbf.reduktor.parser.PSICreator.psiFactory
import com.stepanov.bbf.reduktor.util.getAllPSIChildrenOfType
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.psi.psiUtil.getParentOfType
import org.jetbrains.kotlin.psi.psiUtil.parents
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.bindingContextUtil.getAbbreviatedTypeOrType
import org.jetbrains.kotlin.types.KotlinType
import org.jetbrains.kotlin.types.typeUtil.isTypeParameter
import kotlin.random.Random
import org.jetbrains.kotlin.resolve.calls.callUtil.getType as ktGetType

//TODO lib calls
class AddFunInvocations(project: Project, file: BBFFile):
    Transformation(project, file,
        1, 100) {

    override fun transform() {
        for (i in 0 until randomConst) {
            addCalls()
        }
    }

    private fun addCalls() {
        val psi = file.psiFile
        val ctx = file.updateCtx() ?: return
        val whitespaces = psi.getAllPSIDFSChildrenOfType<PsiWhiteSpace>().filter { it.text.contains("\n") }
        if (whitespaces.isEmpty()) return
        val randomPlace = whitespaces.random()
        val funcs =
            (psi.getAllPSIChildrenOfType<KtNamedFunction>() + convertCallExpressonsIntoFuncs(psi, ctx))
                .map { it to it.myReceiverTypeReference?.text }
        if (funcs.isEmpty()) return
        val randomFunc = funcs.random()
        //Avoid recursion
        if (randomPlace.parents.any { it is KtNamedFunction && it.name == randomFunc.first.name }) {
            log.debug("AVOIDING RECURSION func: ${randomFunc.first.name}")
            return
        }
        val allAvailableVars = getSlice(randomPlace)
            .map { Triple(it, it.text, it.ktGetType(ctx)) }
            .filter { it.third != null }
        val availableVars = getSlice(randomPlace)
            .map {
                when (it) {
                    is KtProperty -> Triple(
                        it.name,
                        (it.typeReference?.getAbbreviatedTypeOrType(ctx) ?: it.getType(ctx)),
                        it.typeReference
                    )
                    else -> Triple(it.text, it.ktGetType(ctx), null)
                }
            }
            .filter { it.second != null && it.first != null }
            .filterDuplicates(Comparator { t, t2 -> t.first!!.compareTo(t2.first!!) })
            .map { Triple(it.first, it.second!!.constructor, it.third?.typeElement?.typeArgumentsAsTypes) }
        val objects = availableVars.filter { it.second.toString() == randomFunc.second }
        val neededObj = if (randomFunc.second == null || objects.isEmpty()) null else objects.random()

        val resParameterList = mutableListOf<String>()
        //Generate func params
        for (par in randomFunc.first.valueParameters) {
            val ctxType = par.getType(ctx)
            val type = ctxType ?: par.typeReference?.text ?: return
            val realType =
                if (type is KotlinType && type.isTypeParameter()) {
                    //Get typeParams of func
                    val typeParams =
                        randomFunc.first.typeParameterList
                            ?: randomFunc.first.getParentOfType<KtClassOrObject>(true)?.typeParameterList
                    val indexOfTypeParam = typeParams?.parameters?.indexOfFirst { it.name == type.toString() }
                    indexOfTypeParam?.let {
                        if (indexOfTypeParam in 0 until (neededObj?.third?.size ?: -1))
                            neededObj?.third?.get(indexOfTypeParam)?.text
                        else null
                    }
                } else type.toString()
            val avPropsOfRealType = getInsertableExpressions(allAvailableVars, realType)
            val generatedValue = generateDefValuesAsString(realType ?: "")
            val realTypeValue =
                if (avPropsOfRealType.isNotEmpty()) {
                    if (generatedValue.trim().isNotEmpty() && Random.nextBoolean() && Random.nextBoolean())
                        generatedValue
                    else avPropsOfRealType.random().first.text
                } else generatedValue
            if (realTypeValue.isNotEmpty()) resParameterList.add(realTypeValue) else return
        }
        val objInv =
            if (neededObj == null) ""
            else "${neededObj.first}."
        val invocation = objInv + "${randomFunc.first.name}(${resParameterList.joinToString(", ")})"
        //AvoidSameInvocations
        if (randomPlace.getParentOfType<KtBlockExpression>(true)?.text?.contains(invocation) == true) return
        val callExpr = try {
            psiFactory.createExpressionIfPossible(invocation)
        } catch (e: Exception) {
            null
        }
        callExpr?.let { randomPlace.addAfterThis(psi, it) }
        return
    }

    private fun PsiElement.addAfterThis(tree: KtFile, node: PsiElement) {
        val block = psiFactory.createBlock(node.text)
        block.lBrace?.delete()
        block.rBrace?.delete()
        MutationProcessor.addNode(tree, this)
    }

    private fun getInsertableExpressions(
        table: List<Triple<KtExpression, String, KotlinType?>>,
        type: String?
    ): List<Triple<KtExpression, String, KotlinType?>> {
        //Nullable or most common types
        val res = mutableListOf<Triple<KtExpression, String, KotlinType?>>()
        val nodeType = type ?: return emptyList()
        for (el in table) {
            when {
                el.third?.toString() == nodeType -> res.add(el)
                el.third?.toString() == "$nodeType?" -> res.add(el)
            }
        }
        return res
    }

    private fun convertCallExpressonsIntoFuncs(psi: KtFile, ctx: BindingContext): List<KtNamedFunction> {
        val calls = mutableListOf<Pair<KtCallExpression, KotlinType?>>()
        for (call in psi.getAllPSIChildrenOfType<KtCallExpression>()) {
            if (call.parent is KtDotQualifiedExpression) {
                val dotQualified = call.parent as KtDotQualifiedExpression
                calls.add(call to dotQualified.receiverExpression.ktGetType(ctx))
            }
        }
        val callsValueArgs = calls
            .map { getValueArgsTypes(it.first, ctx) }
            .map { it.mapIndexed { ind, it -> "${'a' + ind}: ${it.second}" }.joinToString() }
        val callsToFunc =
            calls.mapIndexed { ind, it -> "fun ${it.second}.${it.first.calleeExpression!!.text}(${callsValueArgs[ind]}): Any = TODO()" }
        return callsToFunc.mapNotNull {
            try {
                psiFactory.createFunction(it)
            } catch (e: Exception) {
                null
            } catch (e: Error) {
                null
            }
        }
    }

    private fun getValueArgsTypes(
        callExpression: KtCallExpression,
        ctx: BindingContext
    ): List<Pair<KtValueArgument, KotlinType?>> =
        callExpression.valueArguments.map {
            it to it.getAllPSIChildrenOfType<KtExpression>().first().ktGetType(ctx)
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
                    psiFactory.createTypeIfPossible(type)
                } catch (e: Exception) {
                    null
                }
            }

    private val randomConst = Random.nextInt(50, 100)
}
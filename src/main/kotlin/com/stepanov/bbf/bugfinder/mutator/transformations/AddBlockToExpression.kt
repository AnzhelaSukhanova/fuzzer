package com.stepanov.bbf.bugfinder.mutator.transformations

import com.stepanov.bbf.bugfinder.executor.project.BBFFile
import com.stepanov.bbf.bugfinder.executor.project.Project
import org.jetbrains.kotlin.psi.*
import com.stepanov.bbf.bugfinder.mutator.transformations.Factory.psiFactory as psiFactory
import com.stepanov.bbf.bugfinder.util.getAllPSIChildrenOfType
import com.stepanov.bbf.bugfinder.util.getRandomVariableName
import com.stepanov.bbf.bugfinder.mutator.MutationProcessor
import java.util.*

class AddBlockToExpression(project: Project, file: BBFFile,
                           amountOfTransformations: Int = 1, probPercentage: Int = 100):
    Transformation(project, file,
        amountOfTransformations, probPercentage) {

    override fun transform() {
        val expr = file.psiFile.getAllPSIChildrenOfType<KtExpression>()
        expr.forEach {
            generateRandomBooleanExpression(it)?.let { blockExpr ->
                MutationProcessor.replaceNode(it, blockExpr, file)
            }
        }
    }

    private fun generateRandomBooleanExpression(exp: KtExpression): KtBlockExpression? {
        val varList = mutableListOf<String>()
        val names = mutableListOf<String>()
        val logicalOps = listOf("&&", "||")
        repeat(Random().nextInt(randomConst) + 1) {
            val name = Random().getRandomVariableName(randomConst)
            val value = Random().nextBoolean()
            names.add(name)
            varList.add("val $name = $value")
        }
        val expr = StringBuilder()
        names.forEach {
            if (it != names.last())
                expr.append("$it ${logicalOps[Random().nextInt(2)]} ")
            else
                expr.append(it)
        }
        try {
            val res = when (Random().nextInt(3)) {
                0 -> psiFactory.createExpression("if (${expr}) {${exp.text}} else {${exp.text}}") as KtIfExpression
                1 -> psiFactory.createExpression("when (${expr}) {\n true -> {${exp.text}}\n else -> {${exp.text}}\n}") as KtWhenExpression
                else -> psiFactory.createExpression("try\n{${exp.text}}\ncatch(e: Exception){}\nfinally{}") as KtTryExpression
            }
            val block = psiFactory.createBlock(varList.joinToString("\n") + "\n${res.text}")
            //Remove braces
            block.deleteChildInternal(block.lBrace!!.node)
            block.deleteChildInternal(block.rBrace!!.node)
            return block
        } catch (e: Exception) {
            return null
        }
    }

    //!!!!
//    private val randomConst = 5
    private val randomConst = 1
}
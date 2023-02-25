package com.stepanov.bbf.bugfinder.mutator.transformations

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiWhiteSpace
import com.stepanov.bbf.bugfinder.project.BBFFile
import com.stepanov.bbf.bugfinder.project.Project
import com.stepanov.bbf.bugfinder.generator.targetsgenerators.RandomInstancesGenerator
import com.stepanov.bbf.bugfinder.generator.targetsgenerators.typeGenerators.RandomTypeGenerator
import com.stepanov.bbf.bugfinder.mutator.transformations.tce.StdLibraryGenerator
import com.stepanov.bbf.bugfinder.mutator.transformations.util.ScopeCalculator
import com.stepanov.bbf.bugfinder.util.*
import com.stepanov.bbf.reduktor.parser.PSICreator
import com.stepanov.bbf.reduktor.parser.PSICreator.psiFactory
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.types.KotlinType
import org.jetbrains.kotlin.types.replace
import org.jetbrains.kotlin.types.typeUtil.asTypeProjection
import org.jetbrains.kotlin.types.typeUtil.isBoolean
import kotlin.random.Random

class AddLoop(project: Project, file: BBFFile):
    Transformation(project, file,
        1, 100) {

    override fun transform() {
        repeat(RANDOM_CONST) {
            try {
                addRandomLoops()
            } catch (e: Exception) {
                log.debug("Caught exception: ${e.stackTraceToString()}")
            }
        }
    }

    private fun addRandomLoops() {
        val beginOfLoop = Random.nextInt(file.text.split("\n").size - 2)
        val endOfLoop = Random.nextInt(beginOfLoop + 1, file.text.split("\n").size - 1)
        val nodesBetweenWhS = file.psiFile.getNodesBetweenWhitespaces(beginOfLoop, endOfLoop)
        if (nodesBetweenWhS.isEmpty() || nodesBetweenWhS.all { it is PsiWhiteSpace }) return
        val randomLoop = generateRandomLoop(beginOfLoop to endOfLoop) ?: return
        nodesBetweenWhS.first { it !is PsiWhiteSpace }.replaceThis(randomLoop)
        val whiteSpaces = nodesBetweenWhS.takeWhile { it is PsiWhiteSpace }
        nodesBetweenWhS
            .filter { it.parent !in nodesBetweenWhS && it !in whiteSpaces }
            .map { it.delete() }
    }

    private fun generateRandomLoop(placeToInsert: Pair<Int, Int>): KtExpression? {
        val beginningNode =
            file.psiFile.getNodesBetweenWhitespaces(placeToInsert.first, placeToInsert.first)
                .firstOrNull { it is KtExpression } ?: return null
        file.updateCtx() ?: return null
        val rig = RandomInstancesGenerator(file)
        val scope =
            ScopeCalculator(file, project)
                .calcScope(beginningNode)
                .map { it.psiElement to it.type }
        val nodesBetweenWhS = file.psiFile.getNodesBetweenWhitespaces(placeToInsert.first, placeToInsert.second)
        val body = nodesBetweenWhS.filter { it.parent !in nodesBetweenWhS }.joinToString("") { it.text }
        return if (Random.getTrue(75)) {
            generateForExpression(scope, rig, body)
        } else {
            generateWhileExpression(scope, rig, body)
        }
    }

    private fun generateForExpression(
        scope: List<Pair<PsiElement, KotlinType?>>,
        rig: RandomInstancesGenerator,
        body: String
    ): KtExpression? {
        val containerFromScopeToIterate =
            scope.filter { it.second!!.isIterable() || it.second!!.getNameWithoutError().contains("Range") }
        val variablesFromScopeToIterate =
            scope.filter { it.second!!.getNameWithoutError() in typesToIterate }
        val loopRange =
            if (containerFromScopeToIterate.isNotEmpty() && Random.getTrue(50)) {
                containerFromScopeToIterate.random().first
            } else if (variablesFromScopeToIterate.isNotEmpty() && Random.getTrue(20)) {
                val randomVar = variablesFromScopeToIterate.random()
                val left = randomVar.first
                val rightFromScope =
                    variablesFromScopeToIterate
                        .find { it.second!!.name == randomVar.second!!.name && it.first.text != randomVar.first.text }
                val right =
                    if (rightFromScope != null && Random.getTrue(50))
                        rightFromScope.first
                    else rig.generateValueOfTypeAsExpression(randomVar.second!!)!!
                psiFactory.createExpression("${left.text}..${right.text}")
            } else {
                var resExpr: KtExpression? = null
                for (i in 0 until 10) {
                    val randomClassToIterate = getRandomClassToIterate()
                    val instance = rig.generateValueOfType(randomClassToIterate)
                    resExpr = PSICreator.tryToCreateExpression(instance)
                    if (resExpr != null) break
                }
                resExpr
            }
        if (loopRange == null) return null
        val label =
            if (Random.getTrue(25)) "${Random.getRandomVariableName(1)}@"
            else ""
        val loopParameter = Random.getRandomVariableName(1)
        val forExpression = "$label for ($loopParameter in ${loopRange.text}) { $body\n}"
        return try {
            psiFactory.createExpression(forExpression)
        } catch (e: Exception) {
            null
        } catch (e: Error) {
            null
        }
    }

    private fun generateWhileExpression(
        scope: List<Pair<PsiElement, KotlinType?>>,
        rig: RandomInstancesGenerator,
        body: String
    ): KtExpression? {
        val label =
            if (Random.getTrue(50)) "${Random.getRandomVariableName(1)}@"
            else ""
        val randomExpression = scope.filter { it.second?.isBoolean() == true }.randomOrNull()
        val whileCondition = randomExpression?.first?.text
//            if (randomExpression != null && Random.getTrue(80)) {
//                val newExpression = rig.generateValueOfTypeAsExpression(randomExpression.second!!)
//                if (newExpression == null) {
//                    "${randomExpression.first.text} != ${randomExpression.first.text}"
//                } else {
//                    "${randomExpression.first.text} != ${newExpression.text}"
//                }
//            } else {
//                "true == true"
//            }
        return try {
            val strWhile =
                if (Random.getTrue(70)) {
                    "$label while ($whileCondition) {\n$body\n}"
                } else {
                    "$label do {\n$body\n} while($whileCondition)"
                }
            PSICreator.tryToCreateExpression(strWhile)
        } catch (e: Exception) {
            null
        }
    }

    private fun getRandomClassToIterate(): KotlinType {
        val randomClass = randomClassesToIterate.random()
        val rtg = RandomTypeGenerator(file)
        //Substitute type parameters
        val realTypeParams = randomClass.typeConstructor.parameters.map {
            rtg.generateRandomTypeWithCtx(it.upperBounds.firstOrNull()) ?: DefaultKotlinTypes.intType
        }
        return randomClass.defaultType.replace(realTypeParams.map { it.asTypeProjection() })
    }

    private val randomClassesToIterate =
        StdLibraryGenerator.klasses
            .filter {
                it.getAllSuperClassifiersWithoutAnyAndItself()
                    .map { it.name.asString() }
                    .let { it.contains("Iterable") || it.contains("ClosedRange") }
            }
            .filterDuplicatesBy { it.name }

    private val typesToIterate = listOf("Byte", "UByte", "Char", "Int", "UInt", "Long", "ULong", "Short", "UShort")
    private val RANDOM_CONST = Random.nextInt(25, 50)
}
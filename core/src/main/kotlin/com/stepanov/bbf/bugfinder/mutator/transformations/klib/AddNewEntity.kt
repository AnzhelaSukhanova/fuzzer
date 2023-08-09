package com.stepanov.bbf.bugfinder.mutator.transformations.klib

import com.stepanov.bbf.bugfinder.generator.targetsgenerators.KlibClassGenerator
import com.stepanov.bbf.bugfinder.mutator.transformations.FTarget
import com.stepanov.bbf.bugfinder.mutator.transformations.abi.generators.RandomClassGenerator
import com.stepanov.bbf.bugfinder.mutator.transformations.abi.generators.RandomFunctionGenerator
import com.stepanov.bbf.bugfinder.mutator.transformations.abi.gstructures.GClass
import com.stepanov.bbf.bugfinder.util.addPsiToBody
import com.stepanov.bbf.bugfinder.util.getRandomVariableName
import com.stepanov.bbf.reduktor.parser.PSICreator.psiFactory
import com.stepanov.bbf.reduktor.util.getAllPSIChildrenOfType
import com.stepanov.bbf.util.WeightedList
import org.jetbrains.kotlin.psi.KtClassOrObject
import kotlin.random.Random

class AddNewEntity: BinaryCompatibleTransformation(1) {

    override fun transform(target: FTarget) {
        val file = target.file
        val allClasses = file.psiFile.getAllPSIChildrenOfType<KtClassOrObject>()
        val outerEntity: KtClassOrObject?
        if (allClasses.isEmpty() || Random.nextInt(0, 100) < TOP_LEVEL_PROBABILITY) {
            outerEntity = null
        } else {
            outerEntity = allClasses.random()
        }
        val entityToCreate = WeightedList(listOf(
            "fun" to FUNCTION_PROB,
            "class" to CLASS_PROB,
        )).getRandom()
        val newEntity = when(entityToCreate) {
            "fun" ->
                RandomFunctionGenerator(file,
                    GClass.fromPsiOrNull(outerEntity)
                ).generateForKlib(true)
            "class" -> KlibClassGenerator(file).generate()!!
            else -> error("shouldn't be here: AddNewEntity")
        }
        if (outerEntity != null) {
            outerEntity.addPsiToBody(newEntity)
        } else {
            file.psiFile.add(psiFactory.createWhiteSpace("\n"))
            file.psiFile.add(newEntity)
        }
    }

    val TOP_LEVEL_PROBABILITY = 50
    val CLASS_PROB = 50.0
    val FUNCTION_PROB = 50.0
}

class AddAbstractFunction: BinaryIncompatibleTransformation(1) {
    override fun transform(target: FTarget) {
        val file = target.file
        val parentClass = file.psiFile.getAllPSIChildrenOfType<KtClassOrObject>()
            .filter {
                val gclass = GClass.fromPsi(it)
                gclass.isInterface() || gclass.isAbstract()
            }.randomOrNull() ?: return
        val newFunc = RandomFunctionGenerator(file, GClass.fromPsiOrNull(parentClass))
            .generateForKlib(false)
        parentClass.addPsiToBody(newFunc)
    }

}
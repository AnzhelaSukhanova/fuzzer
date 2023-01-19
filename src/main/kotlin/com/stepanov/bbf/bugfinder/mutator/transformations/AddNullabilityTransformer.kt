package com.stepanov.bbf.bugfinder.mutator.transformations

import com.stepanov.bbf.bugfinder.executor.project.BBFFile
import com.stepanov.bbf.bugfinder.executor.project.Project
import com.stepanov.bbf.bugfinder.mutator.MutationProcessor
import com.stepanov.bbf.bugfinder.util.getAllPSIChildrenOfType
import org.jetbrains.kotlin.psi.KtTypeReference
import kotlin.random.Random
import com.stepanov.bbf.bugfinder.mutator.transformations.Factory.psiFactory as psiFactory

class AddNullabilityTransformer(project: Project, file: BBFFile,
                                amountOfTransformations: Int = 1, probPercentage: Int = 100):
    Transformation(project, file,
        amountOfTransformations, probPercentage) {

    override fun transform() {
        file.psiFile.getAllPSIChildrenOfType<KtTypeReference>()
            .asSequence()
            .filterNot { it.textContains('?') }
            .filter { Random.nextBoolean() }
            .forEach { addNullability(it) }
    }

    fun addNullability(ref: KtTypeReference) {
        val newRef = psiFactory.createTypeIfPossible("(${ref.typeElement?.text})?") ?: return
        MutationProcessor.replaceNodeReturnNode(ref, newRef, file)
    }

}
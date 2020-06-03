package com.stepanov.bbf.bugfinder.mutator.transformations

import com.stepanov.bbf.bugfinder.executor.CompilerArgs

import com.stepanov.bbf.bugfinder.util.NodeCollector
import com.stepanov.bbf.bugfinder.util.getAllChildrenNodes
import com.stepanov.bbf.bugfinder.util.getAllParentsWithoutNode
import com.stepanov.bbf.reduktor.parser.PSICreator
import com.stepanov.bbf.reduktor.util.getAllPSIChildrenOfType
import org.apache.log4j.Logger
import org.jetbrains.kotlin.psi.KtIfExpression
import java.io.File
import kotlin.random.Random


class ChangeRandomASTNodesFromAnotherTrees : Transformation() {

    override fun transform() {
        val randConst = Random.nextInt(numOfTries.first, numOfTries.second)
        val nodes = file.node.getAllChildrenNodes().filter { it.elementType !in NodeCollector.excludes }
        log.debug("Trying to change some nodes to nodes from other programs $randConst times")
        for (i in 0..randConst) {
            log.debug("Try №$i of $randConst")
            val randomNode = nodes[Random.nextInt(0, nodes.size - 1)]
            /*if (randomNode.getAllParentsWithoutNode().size < magicConst) continue*/
            //Searching nodes of same type in another files
            val line = File("database.txt").bufferedReader().lines()
                    .filter { it.takeWhile { it != ' ' } == randomNode.elementType.toString() }.findFirst()
            if (!line.isPresent) continue
            val files = line.get().dropLast(1).takeLastWhile { it != '[' }.split(", ")
            val randomFile =
                    if (files.size == 1)
                        files[0]
                    else
                        files[Random.nextInt(0, files.size - 1)]
            val psi = PSICreator("")
                .getPSIForFile("${CompilerArgs.baseDir}/$randomFile")
            val sameTypeNodes = psi.node.getAllChildrenNodes().filter { it.elementType == randomNode.elementType }
            val targetNode =
                    if (sameTypeNodes.size == 1)
                        sameTypeNodes[0]
                    else
                        sameTypeNodes[Random.nextInt(0, sameTypeNodes.size - 1)]
            checker.replaceNodeIfPossible(randomNode, targetNode)
        }
    }

    /*val magicConst = 4*/
    private val numOfTries = if (checker.project.files.size == 1) 50 to 1000 else 2000 to 4000
}
package com.stepanov.bbf.bugfinder

import com.stepanov.bbf.bugfinder.executor.CommonCompiler
import com.stepanov.bbf.bugfinder.executor.CompilerArgs
import com.stepanov.bbf.bugfinder.executor.checkers.TracesChecker
import com.stepanov.bbf.bugfinder.executor.compilers.JSCompiler
import com.stepanov.bbf.bugfinder.executor.compilers.JVMCompiler
import com.stepanov.bbf.bugfinder.executor.project.LANGUAGE
import com.stepanov.bbf.bugfinder.executor.project.Project
import com.stepanov.bbf.bugfinder.manager.Bug
import com.stepanov.bbf.bugfinder.manager.BugManager
import com.stepanov.bbf.bugfinder.manager.BugType
import com.stepanov.bbf.bugfinder.tracer.Tracer
import com.stepanov.bbf.bugfinder.util.*
import net.sourceforge.argparse4j.ArgumentParsers
import net.sourceforge.argparse4j.impl.Arguments
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.log4j.PropertyConfigurator
import org.jetbrains.kotlin.psi.KtFile
import java.io.File
import kotlin.system.exitProcess

//fun compile(compiler: CommonCompiler, path: String) {
//    val f1 = File(path)
//    val project = Project.createFromCode(f1.readText())
//    val r = compiler.compile(project)
//    var ex = compiler.exec(r.pathToCompiled)
//    if (ex.trim().isEmpty()) ex = compiler.exec(r.pathToCompiled, Stream.BOTH)
//    println(r)
//    println("COMPILER = $compiler EXECUTION RES = $ex\n\n")
//}

fun main(args: Array<String>) {
    //Init log4j
    PropertyConfigurator.configure("src/main/resources/bbfLog4j.properties")
//    val proj = Project.createFromCode(File("tmp/test.kt").readText())
    //println(JSCompiler("").isCompilerBug(proj))
//    val bug = Bug(listOf(JVMCompiler("-Xuse-ir")), "", proj, BugType.BACKEND)
//    val reduced = Reducer.reduce(bug, false)
//    println(reduced)
//    System.exit(0)
//    var fl = false
//    for (fi in File("tmp/testDir").listFiles().toList().sortedBy { it.absolutePath }) {
//        //if (fi.name == "idlwyuq_FILE.kt") fl = true
//        //if (!fl) continue
//        println(fi.absolutePath)
//        val compilers =
//            fi.readText().split("\n").first { it.startsWith("// Bug happens on ") }
//                .substringAfter("// Bug happens on ").split(',').map { it.trim() }
//                .map { when {
//                    it.startsWith("JS") -> JSCompiler("")
//                    it.startsWith("JVM -Xuse-ir") -> JVMCompiler("-Xuse-ir")
//                    else -> JVMCompiler()
//                }}
//        //println(compilers)
//        compilers.map { compile(it, fi.absolutePath)  }
//    }
//    System.exit(0)

    if (!CompilerArgs.getPropAsBoolean("LOG")) {
        Logger.getRootLogger().level = Level.OFF
        Logger.getLogger("bugFinderLogger").level = Level.OFF
        Logger.getLogger("mutatorLogger").level = Level.OFF
        Logger.getLogger("reducerLogger").level = Level.OFF
        Logger.getLogger("transformationManagerLog").level = Level.OFF
    }
    val parser = ArgumentParsers.newFor("bbf").build()
    parser.addArgument("-r", "--reduce")
        .required(false)
        .help("Reduce mode")
    parser.addArgument("-f", "--fuzz")
        .required(false)
        .help("Fuzzing mode")
    parser.addArgument("-c", "--clean")
        .required(false)
        .action(Arguments.storeTrue())
        .help("Clean directories with bugs from bugs that are not reproduced")
    parser.addArgument("-d", "--database")
        .required(false)
        .action(Arguments.storeTrue())
        .help("Database updating")
    val arguments = parser.parseArgs(args)
    arguments.getString("reduce")?.let {
        //TODO
//        val type = BBFProperties.getStringGroupWithoutQuotes("BUG_FOR_REDUCE").entries.first().value
//        val backends = BBFProperties.getStringGroupWithoutQuotes("BACKEND_FOR_REDUCE").entries
//        val compilers = backends.map { back ->
//            when {
//                back.key.startsWith("JVM") -> JVMCompiler(back.value)
//                back.key.startsWith("JS") -> JSCompiler(back.value)
//                else -> throw IllegalArgumentException("Illegal backend")
//            }
//        }
//        val tmpPath = CompilerArgs.pathToTmpFile
//        require(!File(it).isDirectory) { "Specify file to reducing" }
//        File(tmpPath).writeText(File(it).readText())
//        val res = when (type) {
//            "DIFF_BEHAVIOR" -> Reducer.reduceDiffBehavior(tmpPath, compilers)
//            "BACKEND_CRASH" -> Reducer.reduce(tmpPath, compilers.first()).first().text
//            else -> throw IllegalArgumentException("Illegal type of bug")
//        }
//        println("Result of reducing:\n$res")
        exitProcess(0)
    }
    arguments.getString("fuzz")?.let {
        require(File(it).isDirectory) { "Specify directory to take files for mutation" }
        val file = File(it).listFiles()?.random() ?: throw IllegalArgumentException("Wrong directory")
        SingleFileBugFinder(file.absolutePath).findBugsInFile()
        exitProcess(0)
    }
    if (arguments.getString("database") == "true") {
        NodeCollector(CompilerArgs.baseDir).collect()
        exitProcess(0)
    }
    if (arguments.getString("clean") == "true") {
        FalsePositivesDeleter().cleanDirs()
        exitProcess(0)
    }
//    if (Random.nextBoolean()) {
//        ProjectBugFinder("tmp/arrays/kotlinAndJava").findBugsInKJProjects()
//    } else {
    //ProjectBugFinder("tmp/arrays/classTests").findBugsInProjects()
//    }
    val file = File(CompilerArgs.baseDir).listFiles()?.random() ?: exitProcess(0)
    //val file = File("tmp/test.kt")
//    val regex = Regex("""import kotlin.reflect.typeOf""")
//    val files =
//        Files.walk(Paths.get("/home/stepanov/Kotlin/kotlin/compiler/testData/codegen/box/callableReference/adaptedReferences/"))
//            .map { it.toFile() }.filter { it.isFile }.toList()
//    //val condition = {f: File -> okFiles.any { f.name.contains(it.name) }}
//    val condition2 = { f: File -> f.readText().contains(regex) }
//    val condition3 = { f: File -> f.readText().contains(Regex("""FunctionalInterfaceConversion""")) }
//    val condition4 = { f: File -> f.readText().contains(Regex("""inline class""")) }
//    val cond = listOf(condition2, condition3, condition4)
//    val files2 = File(CompilerArgs.baseDir).listFiles().filter { f -> f.isFile && (cond.any { it.invoke(f) }) }
////    System.exit(0)
//    val file = (files + files2).random()
    SingleFileBugFinder(file.absolutePath).findBugsInFile()
    exitProcess(0)
}
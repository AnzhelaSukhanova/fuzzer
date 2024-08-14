package com.stepanov.bbf.information

import org.apache.commons.io.IOUtils
import java.io.File
import java.util.*
import java.util.jar.JarFile

object CompilerArgs {
    private val file: File = File("${System.getProperty("user.home")}/fuzzer/JVMCompiler/bbf.conf")
    private val absoluteLibPath = "${System.getProperty("user.dir")}/tmp/lib"
    // private val absoluteLibPath = "${System.getProperty("user.dir")}/JVMCompiler/tmp/lib"

    fun getPropValue(name: String): String? {
        val props = Properties()
        props.load(file.inputStream())
        return props.getProperty(name)
    }

    fun getPropValueWithoutQuotes(name: String): String {
        val props = Properties()
        props.load(file.inputStream())
        val prop = props.getProperty(name) ?: throw IllegalArgumentException("Cannot init $name property")
        val res = prop.drop(1).dropLast(1)
        return res
    }

    fun getPropAsBoolean(name: String): Boolean = getPropValue(name)?.toBoolean()
        ?: throw IllegalArgumentException("Cannot init $name property")

    fun getPropAsInt(name: String): Int = getPropValue(name)?.toInt()
        ?: throw IllegalArgumentException("Cannot init $name property")

    fun getStdLibPath(libToSearch: String, version: String? = null): String {
        var curVersion = System.getenv("kotlin_jvm_version")?:
            throw Exception("Dont see kotlinVersion parameter in environment variables (Should be defined in build.gradle)")
        curVersion = version ?: curVersion
        val libFile = if (libToSearch == "kotlin-gradle-plugin") "$libToSearch-$curVersion-gradle70" else
            "$libToSearch-$curVersion"
        "$absoluteLibPath/$libFile.jar".let {
            require(File(it).exists())
            return it
        }
    }

    private fun findAndSaveLib(name: String, jarFile: JarFile) {
        val lib = jarFile.entries().asSequence().first { it.name == name }
        val input = jarFile.getInputStream(lib)
        val content = IOUtils.toString(input, "UTF-8")
        File(absoluteLibPath).mkdirs()
        File("$absoluteLibPath/$name").writeText(content)
    }

    fun createJSLib(): String {
        val pathToJar = getStdLibPath("kotlin-stdlib-js")
        val jarFile = JarFile(File(pathToJar))
        findAndSaveLib("kotlin.js", jarFile)
        findAndSaveLib("kotlin.meta.js", jarFile)
        return absoluteLibPath
    }

    val baseDir = getPropValueWithoutQuotes("MUTATING_DIR")
    val javaBaseDir = getPropValueWithoutQuotes("JAVA_FILES_DIR")
    val dirForNewTests = "$baseDir/newTests"

    //PATHS TO COMPILERS
    //val pathToJsKotlinLib = createJSLib()
    val pathToTmpFile = getPropValueWithoutQuotes("TMPFILE")
    val pathToTmpDir = pathToTmpFile.substringBeforeLast("/")
    val pathToMutatedDir = getPropValueWithoutQuotes("ALL_MUTATED_DIR")

    //RESULT
    val resultsDir = getPropValueWithoutQuotes("RESULTS")

    //STATISTICS
    val statDir = getPropValueWithoutQuotes("STATS")
    val transformationsStatFile = statDir + "transformations.json"

    //MODE
    var isMiscompilationMode = getPropAsBoolean("MISCOMPILATION_MODE")
    val isStrictMode = getPropAsBoolean("STRICT_MODE")
    val isPerformanceMode = getPropAsBoolean("PERFORMANCE_MODE")

    //Instrumentation
    var isInstrumentationMode = getPropAsBoolean("WITH_INSTRUMENTATION")
    val isGuidedByCoverage = getPropAsBoolean("GUIDE_FUZZER_BY_COVERAGE")

    //ABI
    val isABICheckMode = getPropAsBoolean("ABI_CHECK_MODE")
    val ignoreMissingClosureConvertedMethod = getPropAsBoolean("IGNORE_MISSING_CLOSURE_CONVERTED_METHOD")

    //ORACLE
    val useJavaAsOracle = getPropAsBoolean("USE_JAVA_AS_ORACLE")

    //COMPILER

    val JVMCompilerVersion = System.getenv("kotlin_jvm_version")
    val NativeCompilerVersion = System.getenv("kotlin_native_version")

    fun compilerVersion(compiler: String) = when (compiler) {
        VertxAddresses.JVMCompiler -> JVMCompilerVersion
        VertxAddresses.NativeCompiler -> NativeCompilerVersion
        else -> "unknown compiler"
    }

    //MUTATED BUGS
    val shouldSaveCompilerBugs =
        getPropAsBoolean("SAVE_BACKEND_EXCEPTIONS")
    val shouldReduceCompilerBugs =
        getPropAsBoolean("REDUCE_BACKEND_EXCEPTIONS")
    val shouldSaveMutatedFiles = getPropAsBoolean("SAVE_MUTATED_FILES")
    val shouldSaveCompileDiff = getPropAsBoolean("SAVE_COMPILER_DIFFS")
    val shouldReduceDiffBehavior =
        getPropAsBoolean("REDUCE_DIFF_BEHAVIOR")
    val shouldReduceDiffCompile =
        getPropAsBoolean("REDUCE_DIFF_COMPILE")
    val checkCompilationWhileMutating = getPropAsBoolean("CHECK_COMPILATION")

    //REDUKTOR
    val shouldFilterDuplicateCompilerBugs =
        getPropAsBoolean("FILTER_DUPLICATES")

    //JAVA
    val jdkHome = System.getenv("JAVA_HOME")
    val jvmTarget = "1.8"
    val classpath = ""

    //STDLIB
    fun jvmStdLibPaths(version: String? = null) = listOf(
        getStdLibPath("kotlin-stdlib", version),
        getStdLibPath("kotlin-stdlib-common", version),
        getStdLibPath("kotlin-test", version),
        getStdLibPath("kotlin-test-common", version),
        getStdLibPath("kotlin-reflect", version),
        getStdLibPath("kotlin-script-runtime", version),
        getStdLibPath("kotlin-stdlib-jdk8", version),
        getStdLibPath("kotlin-stdlib-jdk7", version),
        getStdLibPath("kotlin-gradle-plugin", version),
    )

    //Vert.x
    val mutatorsNumber = getPropAsInt("MUTATORS_NUMBER")
    val compilersNumber = getPropAsInt("COMPILERS_NUMBER")
//    val FILE_SOURCE = RANDOM

    val jsStdLibPaths = listOf(
        getStdLibPath("kotlin-stdlib-js"),
        getStdLibPath("kotlin-test-js")
    )
    val pathToStdLibScheme = "$absoluteLibPath/standardLibraryTree.txt"
    val pathToSerializedCommits = "${System.getProperty("user.dir")}/tmp/serializedPatches/"
}
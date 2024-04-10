// result:[]

// files
// specialCallsWithCallableReferencesNonStrictOnlyInputTypes.kt
// isKlib=false
// !LANGUAGE: +NewInference
// WITH_RUNTIME
// TARGET_BACKEND: JVM
// DONT_TARGET_EXACT_BACKEND: WASM

import kotlin.experimental.ExperimentalTypeInference


@OptIn(ExperimentalTypeInference::class)
fun <R> scopedFlow(@BuilderInference block: suspend (CoroutineScope)?.(FlowCollector<R>) -> Unit): Flow<R> =
    flow f@{
        val collector = this
        flowScope { block!!(collector) }
    }

@OptIn(ExperimentalTypeInference::class)
fun <T> flow(@BuilderInference block: suspend FlowCollector<T>.() -> Unit): Flow<T> = TODO()

@OptIn(ExperimentalTypeInference::class)
fun <R> flowScope(@BuilderInference block: suspend CoroutineScope.() -> R): R = TODO()

interface CoroutineScope:Flow<HashSet<MutableMap<
val e = true
when (e) {
 true -> {Flow}
 else -> {Flow}
}
<FlowCollector<UByte>>, CoroutineScope>>>,FlowCollector<Boolean> { 


}
interface Flow<out T>

interface FlowCollector<in T>

fun box() = "OK"


Combined output:
java.lang.IndexOutOfBoundsException: Empty list doesn't contain element at index 0.
	at kotlin.collections.EmptyList.get(Collections.kt:36)
	at kotlin.collections.EmptyList.get(Collections.kt:24)
	at org.jetbrains.kotlin.resolve.UpperBoundChecker.checkBoundsForAbbreviatedSupertype(UpperBoundChecker.kt:130)
	at org.jetbrains.kotlin.resolve.UpperBoundChecker.checkBoundsForAbbreviatedSupertype(UpperBoundChecker.kt:126)
	at org.jetbrains.kotlin.resolve.UpperBoundChecker.checkBoundsInSupertype(UpperBoundChecker.kt:82)
	at org.jetbrains.kotlin.resolve.UpperBoundChecker.checkBoundsInSupertype(UpperBoundChecker.kt:101)
	at org.jetbrains.kotlin.resolve.DeclarationsChecker.checkTypesInClassHeader(DeclarationsChecker.kt:360)
	at org.jetbrains.kotlin.resolve.DeclarationsChecker.checkClass(DeclarationsChecker.kt:330)
	at org.jetbrains.kotlin.resolve.DeclarationsChecker.process(DeclarationsChecker.kt:93)
	at org.jetbrains.kotlin.resolve.BodyResolver.resolveBodies(BodyResolver.java:258)
	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer.analyzeDeclarations(LazyTopDownAnalyzer.kt:227)
	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer.analyzeDeclarations$default(LazyTopDownAnalyzer.kt:58)
	at org.jetbrains.kotlin.cli.jvm.compiler.TopDownAnalyzerFacadeForJVM.analyzeFilesWithJavaIntegration(TopDownAnalyzerFacadeForJVM.kt:119)
	at org.jetbrains.kotlin.cli.jvm.compiler.TopDownAnalyzerFacadeForJVM.analyzeFilesWithJavaIntegration$default(TopDownAnalyzerFacadeForJVM.kt:88)
	at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler$analyze$1.invoke(KotlinToJVMBytecodeCompiler.kt:256)
	at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler$analyze$1.invoke(KotlinToJVMBytecodeCompiler.kt:42)
	at org.jetbrains.kotlin.cli.common.messages.AnalyzerWithCompilerReport.analyzeAndReport(AnalyzerWithCompilerReport.kt:115)
	at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler.analyze(KotlinToJVMBytecodeCompiler.kt:247)
	at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler.compileModules$cli(KotlinToJVMBytecodeCompiler.kt:87)
	at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler.compileModules$cli$default(KotlinToJVMBytecodeCompiler.kt:47)
	at org.jetbrains.kotlin.cli.jvm.K2JVMCompiler.doExecute(K2JVMCompiler.kt:168)
	at org.jetbrains.kotlin.cli.jvm.K2JVMCompiler.doExecute(K2JVMCompiler.kt:53)
	at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:100)
	at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:46)
	at org.jetbrains.kotlin.cli.common.CLITool.exec(CLITool.kt:101)
	at com.stepanov.bbf.JVMCompiler.executeCompilationCheck$lambda$0(JVMCompiler.kt:30)
	at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:515)
	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
	at java.base/java.lang.Thread.run(Thread.java:829)

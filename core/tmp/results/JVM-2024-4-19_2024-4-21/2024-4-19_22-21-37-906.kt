// result:[]

// kt23260.kt
// isKlib=false

public abstract class Grt <T: Iterable<Long?>, S>  (var hns: Sequence<Boolean>, var ttk: Byte?, var jng: Char?):Grt<AbstractCollection<Long>, LinkedHashMap<Grt<AbstractQueue<Long>, Boolean>, Grt<IntRange, HashSet<Byte>>>>{


inline  private  fun  ghwiy(a: S, b: HashMap<Double, Int>, c: UByte): Boolean = false

fun <T: LongIterator, S>  sgpyk(a: Function2<Boolean, UShort, Map<Long, Int>>, b: Float?, c: S): Byte? = -100

abstract var kutp: Char

protected var tsxa: Int  
get() = -97
set(value) = -44


abstract val wwnp: Float
companion object {

internal var ohof: UByte  = 34.toUByte()

}



inline  private  fun <reified T: RandomAccess, S>  eqccj(a: Long, b: Int): S = TODO()


}
// KJS_WITH_FULL_RUNTIME
// WITH_RUNTIME

// IGNORE_BACKEND: WASM
// WASM_MUTE_REASON: REFLECTION

fun box(): String {
    lateinit var str: String
    try {
        println((str).stripLeading()?.plus("ppoxy")!!)
        return "Should throw an exception"
    }
    catch (e: (UninitializedPropertyAccessException)) {
        return "OK"
    }
    catch (e: Throwable) {
        return "Unexpected exception: ${e::class}"
    }!!
}


//Combined output:
//java.lang.IndexOutOfBoundsException: Empty list doesn't contain element at index 0.
//	at kotlin.collections.EmptyList.get(Collections.kt:36)
//	at kotlin.collections.EmptyList.get(Collections.kt:24)
//	at org.jetbrains.kotlin.resolve.UpperBoundChecker.checkBoundsForAbbreviatedSupertype(UpperBoundChecker.kt:130)
//	at org.jetbrains.kotlin.resolve.UpperBoundChecker.checkBoundsForAbbreviatedSupertype(UpperBoundChecker.kt:126)
//	at org.jetbrains.kotlin.resolve.UpperBoundChecker.checkBoundsForAbbreviatedSupertype(UpperBoundChecker.kt:126)
//	at org.jetbrains.kotlin.resolve.UpperBoundChecker.checkBoundsInSupertype(UpperBoundChecker.kt:82)
//	at org.jetbrains.kotlin.resolve.UpperBoundChecker.checkBoundsInSupertype(UpperBoundChecker.kt:101)
//	at org.jetbrains.kotlin.resolve.DeclarationsChecker.checkTypesInClassHeader(DeclarationsChecker.kt:360)
//	at org.jetbrains.kotlin.resolve.DeclarationsChecker.checkClass(DeclarationsChecker.kt:330)
//	at org.jetbrains.kotlin.resolve.DeclarationsChecker.process(DeclarationsChecker.kt:93)
//	at org.jetbrains.kotlin.resolve.BodyResolver.resolveBodies(BodyResolver.java:258)
//	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer.analyzeDeclarations(LazyTopDownAnalyzer.kt:227)
//	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer.analyzeDeclarations$default(LazyTopDownAnalyzer.kt:58)
//	at org.jetbrains.kotlin.cli.jvm.compiler.TopDownAnalyzerFacadeForJVM.analyzeFilesWithJavaIntegration(TopDownAnalyzerFacadeForJVM.kt:119)
//	at org.jetbrains.kotlin.cli.jvm.compiler.TopDownAnalyzerFacadeForJVM.analyzeFilesWithJavaIntegration$default(TopDownAnalyzerFacadeForJVM.kt:88)
//	at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler$analyze$1.invoke(KotlinToJVMBytecodeCompiler.kt:256)
//	at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler$analyze$1.invoke(KotlinToJVMBytecodeCompiler.kt:42)
//	at org.jetbrains.kotlin.cli.common.messages.AnalyzerWithCompilerReport.analyzeAndReport(AnalyzerWithCompilerReport.kt:115)
//	at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler.analyze(KotlinToJVMBytecodeCompiler.kt:247)
//	at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler.compileModules$cli(KotlinToJVMBytecodeCompiler.kt:87)
//	at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler.compileModules$cli$default(KotlinToJVMBytecodeCompiler.kt:47)
//	at org.jetbrains.kotlin.cli.jvm.K2JVMCompiler.doExecute(K2JVMCompiler.kt:168)
//	at org.jetbrains.kotlin.cli.jvm.K2JVMCompiler.doExecute(K2JVMCompiler.kt:53)
//	at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:100)
//	at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:46)
//	at org.jetbrains.kotlin.cli.common.CLITool.exec(CLITool.kt:101)
//	at com.stepanov.bbf.JVMCompiler.executeCompilationCheck$lambda$0(JVMCompiler.kt:30)
//	at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:515)
//	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
//	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
//	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
//	at java.base/java.lang.Thread.run(Thread.java:829)
//
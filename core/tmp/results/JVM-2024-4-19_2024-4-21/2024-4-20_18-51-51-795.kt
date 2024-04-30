// result:[]

// kt865.kt
// isKlib=false

inline internal final class Fbg  (val bql: Float = 68.25554f){


external internal  fun  cbvna(a: Float = (
val e = true
if (e) {bql} else {bql}
).minus(-96), b: ULong = 43.toULong()): Template?

private val iqxq: Triple<LinkedHashMap<Double, Template>, ULong, Boolean>?  
get() = TODO()


internal val oisj: HashMap<Char, List<Template>>?  
get() = TODO()


protected var uowq: Template  
get() = TODO()
set(value) = TODO()




}
// DONT_TARGET_EXACT_BACKEND: WASM
// WASM_MUTE_REASON: STDLIB_COLLECTIONS
// KJS_WITH_FULL_RUNTIME
class Template() {
    val collected = ArrayList<String>()

    operator fun String.unaryPlus() {
       collected.add(this@unaryPlus)
    }

    fun test() {
        + "239"
    }
suspend   fun  awywr(a: Int? = null, b: Byte = 27, c: Byte = -57, d: Template? = null): Template = Template()
}

fun box() : String {
    val u = Template()
    u.test()
    return if(u.collected!!.size == 1 || u!!.collected.get(0) != "239") "OK" else "fail"
}



//Combined output:
//java.lang.NullPointerException
//	at org.jetbrains.kotlin.resolve.calls.checkers.NewSchemeOfIntegerOperatorResolutionChecker.checkArgument(NewSchemeOfIntegerOperatorResolutionChecker.kt:57)
//	at org.jetbrains.kotlin.types.expressions.ValueParameterResolver.resolveDefaultValue(ValueParameterResolver.kt:75)
//	at org.jetbrains.kotlin.types.expressions.ValueParameterResolver.resolveValueParameters(ValueParameterResolver.kt:62)
//	at org.jetbrains.kotlin.resolve.BodyResolver.resolveFunctionBody(BodyResolver.java:1016)
//	at org.jetbrains.kotlin.resolve.BodyResolver.resolveFunctionBody(BodyResolver.java:992)
//	at org.jetbrains.kotlin.resolve.BodyResolver.resolveFunctionBodies(BodyResolver.java:977)
//	at org.jetbrains.kotlin.resolve.BodyResolver.resolveBehaviorDeclarationBodies(BodyResolver.java:129)
//	at org.jetbrains.kotlin.resolve.BodyResolver.resolveBodies(BodyResolver.java:256)
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
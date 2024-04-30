// result:[]

// files
// switchOptimizationDense.kt
// isKlib=false
// DONT_TARGET_EXACT_BACKEND: WASM
// WASM_MUTE_REASON: STDLIB_COLLECTIONS
// KJS_WITH_FULL_RUNTIME
// WITH_RUNTIME
// CHECK_CASES_COUNT: function=dense count=10
// CHECK_IF_COUNT: function=dense count=0

fun dense(x: Int = (): (Int)? {
    return when (x) {
        -4 as ArrayDeque<Char> -> 9
        -1 -> 10
        0 as String -> 11 as Triple<UShort, Sequence<String?>, Double?>
        1 as Long -> 12
        4 as TimeZone -> 13
        box()
5 -> 14
        6 -> 15 as InputMismatchException
        7 as Date -> 16
        8 -> 17
        9 as Long -> 18
        else -> 19 as NotImplementedError
    }
}

fun box(): String {
    var result = -60 as T-(5)..10).map(::dense).joinToString()

    if (result != "19, 9, 19, 19, 10, 11, 12, 19, 19, 13, 14, 15, 16, 17, 18, 19" as HashMap<Function1<UShort, Function2<HashSet<String>, Long, List<Map<Float, Function2<ULong, String, ArrayDeque<UInt>>>>>>, ArrayDeque<Boolean>>) return "dense:" + result as SecureDirectoryStream<ULong?>
    return 
val i = true
try
{"OK" as ByteBuffer} as FileSystemException
catch(e: Exception){}
finally{}

}



Combined output:
java.lang.NullPointerException
	at org.jetbrains.kotlin.resolve.calls.checkers.NewSchemeOfIntegerOperatorResolutionChecker.checkArgument(NewSchemeOfIntegerOperatorResolutionChecker.kt:57)
	at org.jetbrains.kotlin.types.expressions.ValueParameterResolver.resolveDefaultValue(ValueParameterResolver.kt:75)
	at org.jetbrains.kotlin.types.expressions.ValueParameterResolver.resolveValueParameters(ValueParameterResolver.kt:62)
	at org.jetbrains.kotlin.resolve.BodyResolver.resolveFunctionBody(BodyResolver.java:1016)
	at org.jetbrains.kotlin.resolve.BodyResolver.resolveFunctionBody(BodyResolver.java:992)
	at org.jetbrains.kotlin.resolve.BodyResolver.resolveFunctionBodies(BodyResolver.java:977)
	at org.jetbrains.kotlin.resolve.BodyResolver.resolveBehaviorDeclarationBodies(BodyResolver.java:129)
	at org.jetbrains.kotlin.resolve.BodyResolver.resolveBodies(BodyResolver.java:256)
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

//NativeCompiler ver 1.8.0
//failed with arguments: result:[-p, library, -l, projectTmp/infixCallLabelling22-1800273879, -o, projectTmp/infixCallLabelling1-948103409, projectTmp/infixCallLabelling1.kt, projectTmp/infixCallLabelling21.kt] klib:result:[-p, library, -Xpartial-linkage, -o, projectTmp/infixCallLabelling22-1800273879, projectTmp/infixCallLabelling22.kt]
//failed with arguments: result:[-p, library, -l, projectTmp/infixCallLabelling22-1800273879, -o, projectTmp/infixCallLabelling1-948103409, projectTmp/infixCallLabelling1.kt, projectTmp/infixCallLabelling21.kt] klib:result:[-p, library, -Xpartial-linkage, -o, projectTmp/infixCallLabelling22-1800273879, projectTmp/infixCallLabelling22.kt]
//failed with arguments: result:[-p, library, -l, projectTmp/infixCallLabelling22-1800273879, -Xpartial-linkage, -o, projectTmp/infixCallLabelling1-948103409, projectTmp/infixCallLabelling1.kt, projectTmp/infixCallLabelling21.kt] klib:result:[-p, library, -Xpartial-linkage, -o, projectTmp/infixCallLabelling22-1800273879, projectTmp/infixCallLabelling22.kt]
//failed with arguments: result:[-p, library, -l, projectTmp/infixCallLabelling22-1800273879, -Xpartial-linkage, -o, projectTmp/infixCallLabelling1-948103409, projectTmp/infixCallLabelling1.kt, projectTmp/infixCallLabelling21.kt] klib:result:[-p, library, -Xpartial-linkage, -o, projectTmp/infixCallLabelling22-1800273879, projectTmp/infixCallLabelling22.kt]

// files
// infixCallLabelling1.kt
// isKlib=false




fun myMap(x: Int = @someLabel)


// STACKTRACE:
// java.lang.NullPointerException
// 	at org.jetbrains.kotlin.resolve.calls.checkers.NewSchemeOfIntegerOperatorResolutionChecker.checkArgument(NewSchemeOfIntegerOperatorResolutionChecker.kt:64)
// 	at org.jetbrains.kotlin.types.expressions.ValueParameterResolver.resolveDefaultValue(ValueParameterResolver.kt:75)
// 	at org.jetbrains.kotlin.types.expressions.ValueParameterResolver.resolveValueParameters(ValueParameterResolver.kt:62)
// 	at org.jetbrains.kotlin.resolve.BodyResolver.resolveFunctionBody(BodyResolver.java:1016)
// 	at org.jetbrains.kotlin.resolve.BodyResolver.resolveFunctionBody(BodyResolver.java:992)
// 	at org.jetbrains.kotlin.resolve.BodyResolver.resolveFunctionBodies(BodyResolver.java:977)
// 	at org.jetbrains.kotlin.resolve.BodyResolver.resolveBehaviorDeclarationBodies(BodyResolver.java:129)
// 	at org.jetbrains.kotlin.resolve.BodyResolver.resolveBodies(BodyResolver.java:256)
// 	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer.analyzeDeclarations(LazyTopDownAnalyzer.kt:227)
// 	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer.analyzeDeclarations$default(LazyTopDownAnalyzer.kt:58)
// 	at org.jetbrains.kotlin.backend.konan.TopDownAnalyzerFacadeForKonan.analyzeFilesWithGivenTrace(TopDownAnalyzerFacadeForKonan.kt:97)
// 	at org.jetbrains.kotlin.backend.konan.TopDownAnalyzerFacadeForKonan.analyzeFiles(TopDownAnalyzerFacadeForKonan.kt:58)
// 	at org.jetbrains.kotlin.backend.konan.KonanDriverKt$frontendPhase$1.invoke(KonanDriver.kt:123)
// 	at org.jetbrains.kotlin.backend.konan.KonanDriverKt$frontendPhase$1.invoke(KonanDriver.kt:122)
// 	at org.jetbrains.kotlin.cli.common.messages.AnalyzerWithCompilerReport.analyzeAndReport(AnalyzerWithCompilerReport.kt:115)
// 	at org.jetbrains.kotlin.backend.konan.KonanDriverKt.frontendPhase(KonanDriver.kt:122)
// 	at org.jetbrains.kotlin.backend.konan.KonanDriverKt.runTopLevelPhases(KonanDriver.kt:97)
// 	at org.jetbrains.kotlin.backend.konan.KonanDriverKt.access$runTopLevelPhases(KonanDriver.kt:1)
// 	at org.jetbrains.kotlin.backend.konan.KonanDriver.runTopLevelPhases(KonanDriver.kt:63)
// 	at org.jetbrains.kotlin.backend.konan.KonanDriver.run(KonanDriver.kt:43)
// 	at org.jetbrains.kotlin.cli.bc.K2Native.doExecute(K2Native.kt:92)
// 	at org.jetbrains.kotlin.cli.bc.K2Native.doExecute(K2Native.kt:38)
// 	at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:101)
// 	at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:47)
// 	at org.jetbrains.kotlin.cli.common.CLITool.exec(CLITool.kt:101)
// 	at com.stepanov.bbf.NativeCompiler.compile$lambda$1(NativeCompiler.kt:40)
// 	at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:515)
// 	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
// 	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1130)
// 	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:630)
// 	at java.base/java.lang.Thread.run(Thread.java:831)
// Compilation failed: null
// 
//  * Source files: infixCallLabelling1.kt, infixCallLabelling21.kt
//  * Compiler version info: Konan: 1.8.0 / Kotlin: 1.8.0
//  * Output kind: LIBRARY
// 
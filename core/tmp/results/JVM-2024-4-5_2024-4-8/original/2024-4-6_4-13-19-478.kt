// result:[]

// files
// invokeOperator0.kt
// isKlib=false
// WITH_RUNTIME

import kotlin.coroutines.*

fun builder(c: @ExtensionFunctionType()
suspend () -> Unit) {
    c.startCoroutine(Continuation(EmptyCoroutineContext) {
        it.getOrThrow()
    })
}

inline class IC(val a: Any?){
private val ufvs: Long  
get() = TODO()
}

class GetResult {
    suspend operator fun invoke() = IC("OK")
}

inline class IC1(val a: String) {
    suspend operator fun invoke() = (IC(a))
}

fun box(): String {
    var res = "FAIL 1"
    builder {
        val getResult = GetResult()
        res = getResult().a as String
    }
    if (res != "OK") return "FAIL 1 $res"

    res = "FAIL 2"
    builder {
        val getResult = GetResult()
        
val i = true
if (i) {res = getResult.invoke().a as String} else {res = getResult.invoke().a as String}

    }
    if (res != "OK") return "FAIL 2 $res"

    res = "FAIL 3"
    builder {
        res = GetResult()().a as String
    }
    if (res != "OK") return "FAIL 3 $res"

    res = "FAIL 4"
    builder {
        val getResult = IC1("OK")
        builder {
        res = GetResult()().a as String
    }
    }
    if (res != "OK") return "FAIL 4 $res"

    res = "FAIL 5"
    builder {
        val getResult = IC1("OK")
        res = getResult.invoke().a as String
    }
    if (res != "OK") return "FAIL 5 $res"

    res = "FAIL 6"
    builder {
        res = IC1("OK")().a as String
    }
    if (res != "OK") return "FAIL 6 $res"
    return res
}



Combined output:
org.jetbrains.kotlin.util.KotlinFrontEndException: Exception while analyzing expression in (27,5) in /home/Anzhela.Sukhanova/fuzzer/JVMCompiler/projectTmp/invokeOperator0.kt

Attachments:
causeThrowable
java.lang.IllegalArgumentException: fromIndex(1) > toIndex(0)
	at java.base/java.util.AbstractList.subListRangeCheck(AbstractList.java:509)
	at java.base/java.util.ArrayList.subList(ArrayList.java:1138)
	at org.jetbrains.kotlin.builtins.FunctionTypesKt.getValueParameterTypesFromFunctionType(functionTypes.kt:178)
	at org.jetbrains.kotlin.resolve.calls.components.PostponeArgumentsChecksKt.extractLambdaInfoFromFunctionalType(PostponeArgumentsChecks.kt:154)
	at org.jetbrains.kotlin.resolve.calls.components.PostponeArgumentsChecksKt.preprocessLambdaArgument(PostponeArgumentsChecks.kt:82)
	at org.jetbrains.kotlin.resolve.calls.components.PostponeArgumentsChecksKt.preprocessLambdaArgument$default(PostponeArgumentsChecks.kt:58)
	at org.jetbrains.kotlin.resolve.calls.components.PostponeArgumentsChecksKt.resolveKtPrimitive(PostponeArgumentsChecks.kt:45)
	at org.jetbrains.kotlin.resolve.calls.components.ResolutionPartsKt.resolveKotlinArgument(ResolutionParts.kt:529)
	at org.jetbrains.kotlin.resolve.calls.components.ResolutionPartsKt.access$resolveKotlinArgument(ResolutionParts.kt:1)
	at org.jetbrains.kotlin.resolve.calls.components.CheckExternalArgument.process(ResolutionParts.kt:757)
	at org.jetbrains.kotlin.resolve.calls.components.candidate.ResolutionCandidate.processPart(ResolutionCandidate.kt:133)
	at org.jetbrains.kotlin.resolve.calls.components.candidate.ResolutionCandidate.processPart$default(ResolutionCandidate.kt:129)
	at org.jetbrains.kotlin.resolve.calls.components.candidate.ResolutionCandidate.processParts(ResolutionCandidate.kt:120)
	at org.jetbrains.kotlin.resolve.calls.components.candidate.ResolutionCandidate.isSuccessful(ResolutionCandidate.kt:31)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$SuccessfulResultCollector.pushCandidates(TowerResolver.kt:466)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver.processTowerData(TowerResolver.kt:389)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver.access$processTowerData(TowerResolver.kt:95)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.process(TowerResolver.kt:207)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.process(TowerResolver.kt:216)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.run$processImportingScope(TowerResolver.kt:269)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.run$processScopes(TowerResolver.kt:282)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.run(TowerResolver.kt:305)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver.run(TowerResolver.kt:114)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver.runResolve(TowerResolver.kt:101)
	at org.jetbrains.kotlin.resolve.calls.KotlinCallResolver.resolveCall(KotlinCallResolver.kt:184)
	at org.jetbrains.kotlin.resolve.calls.KotlinCallResolver.resolveAndCompleteCall(KotlinCallResolver.kt:41)
	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.runResolutionAndInference(PSICallResolver.kt:114)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.doResolveCallOrGetCachedResults(CallResolver.java:602)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.lambda$computeTasksAndResolveCall$0(CallResolver.java:213)
	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.computeTasksAndResolveCall(CallResolver.java:211)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.computeTasksAndResolveCall(CallResolver.java:199)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveFunctionCall(CallResolver.java:329)
	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getResolvedCallForFunction(CallExpressionResolver.kt:86)
	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getCallExpressionTypeInfoWithoutFinalTypeCheck(CallExpressionResolver.kt:208)
	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getCallExpressionTypeInfo(CallExpressionResolver.kt:185)
	at org.jetbrains.kotlin.types.expressions.BasicExpressionTypingVisitor.visitCallExpression(BasicExpressionTypingVisitor.java:731)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.visitCallExpression(ExpressionTypingVisitorDispatcher.java:396)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForBlock.visitCallExpression(ExpressionTypingVisitorDispatcher.java:60)
	at org.jetbrains.kotlin.psi.KtCallExpression.accept(KtCallExpression.java:35)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitExpression(ExpressionTypingVisitorForStatements.java:543)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitExpression(ExpressionTypingVisitorForStatements.java:73)
	at org.jetbrains.kotlin.psi.KtVisitor.visitReferenceExpression(KtVisitor.java:202)
	at org.jetbrains.kotlin.psi.KtVisitor.visitCallExpression(KtVisitor.java:282)
	at org.jetbrains.kotlin.psi.KtCallExpression.accept(KtCallExpression.java:35)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:148)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getBlockReturnedTypeWithWritableScope(ExpressionTypingServices.java:342)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getBlockReturnedType(ExpressionTypingServices.java:207)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getBlockReturnedType(ExpressionTypingServices.java:184)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitBlockExpression(ExpressionTypingVisitorForStatements.java:586)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitBlockExpression(ExpressionTypingVisitorForStatements.java:73)
	at org.jetbrains.kotlin.psi.KtBlockExpression.accept(KtBlockExpression.java:79)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:148)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.checkFunctionReturnType(ExpressionTypingServices.java:179)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.checkFunctionReturnType(ExpressionTypingServices.java:166)
	at org.jetbrains.kotlin.resolve.BodyResolver.resolveFunctionBody(BodyResolver.java:1049)
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

----
expression.kt
File name: invokeOperator0.kt Physical: true Injected: false
fun box(): String {
    var res = "FAIL 1"
    <caret>builder {
        val getResult = GetResult()
        res = getResult().a as String
    }
    if (res != "OK") return "FAIL 1 $res"

    res = "FAIL 2"
    builder {
        val getResult = GetResult()
        
val i = true
if (i) {res = getResult.invoke().a as String} else {res = getResult.invoke().a as String}

    }
    if (res != "OK") return "FAIL 2 $res"

    res = "FAIL 3"
    builder {
        res = GetResult()().a as String
    }
    if (res != "OK") return "FAIL 3 $res"

    res = "FAIL 4"
    builder {
        val getResult = IC1("OK")
        builder {
        res = GetResult()().a as String
    }
    }
    if (res != "OK") return "FAIL 4 $res"

    res = "FAIL 5"
    builder {
        val getResult = IC1("OK")
        res = getResult.invoke().a as String
    }
    if (res != "OK") return "FAIL 5 $res"

    res = "FAIL 6"
    builder {
        res = IC1("OK")().a as String
    }
    if (res != "OK") return "FAIL 6 $res"
    return res
}
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.logOrThrowException(ExpressionTypingVisitorDispatcher.java:261)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:225)
	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitExpression(ExpressionTypingVisitorForStatements.java:543)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitExpression(ExpressionTypingVisitorForStatements.java:73)
	at org.jetbrains.kotlin.psi.KtVisitor.visitReferenceExpression(KtVisitor.java:202)
	at org.jetbrains.kotlin.psi.KtVisitor.visitCallExpression(KtVisitor.java:282)
	at org.jetbrains.kotlin.psi.KtCallExpression.accept(KtCallExpression.java:35)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:148)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getBlockReturnedTypeWithWritableScope(ExpressionTypingServices.java:342)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getBlockReturnedType(ExpressionTypingServices.java:207)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getBlockReturnedType(ExpressionTypingServices.java:184)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitBlockExpression(ExpressionTypingVisitorForStatements.java:586)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitBlockExpression(ExpressionTypingVisitorForStatements.java:73)
	at org.jetbrains.kotlin.psi.KtBlockExpression.accept(KtBlockExpression.java:79)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:148)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.checkFunctionReturnType(ExpressionTypingServices.java:179)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.checkFunctionReturnType(ExpressionTypingServices.java:166)
	at org.jetbrains.kotlin.resolve.BodyResolver.resolveFunctionBody(BodyResolver.java:1049)
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
Caused by: java.lang.IllegalArgumentException: fromIndex(1) > toIndex(0)
	at java.base/java.util.AbstractList.subListRangeCheck(AbstractList.java:509)
	at java.base/java.util.ArrayList.subList(ArrayList.java:1138)
	at org.jetbrains.kotlin.builtins.FunctionTypesKt.getValueParameterTypesFromFunctionType(functionTypes.kt:178)
	at org.jetbrains.kotlin.resolve.calls.components.PostponeArgumentsChecksKt.extractLambdaInfoFromFunctionalType(PostponeArgumentsChecks.kt:154)
	at org.jetbrains.kotlin.resolve.calls.components.PostponeArgumentsChecksKt.preprocessLambdaArgument(PostponeArgumentsChecks.kt:82)
	at org.jetbrains.kotlin.resolve.calls.components.PostponeArgumentsChecksKt.preprocessLambdaArgument$default(PostponeArgumentsChecks.kt:58)
	at org.jetbrains.kotlin.resolve.calls.components.PostponeArgumentsChecksKt.resolveKtPrimitive(PostponeArgumentsChecks.kt:45)
	at org.jetbrains.kotlin.resolve.calls.components.ResolutionPartsKt.resolveKotlinArgument(ResolutionParts.kt:529)
	at org.jetbrains.kotlin.resolve.calls.components.ResolutionPartsKt.access$resolveKotlinArgument(ResolutionParts.kt:1)
	at org.jetbrains.kotlin.resolve.calls.components.CheckExternalArgument.process(ResolutionParts.kt:757)
	at org.jetbrains.kotlin.resolve.calls.components.candidate.ResolutionCandidate.processPart(ResolutionCandidate.kt:133)
	at org.jetbrains.kotlin.resolve.calls.components.candidate.ResolutionCandidate.processPart$default(ResolutionCandidate.kt:129)
	at org.jetbrains.kotlin.resolve.calls.components.candidate.ResolutionCandidate.processParts(ResolutionCandidate.kt:120)
	at org.jetbrains.kotlin.resolve.calls.components.candidate.ResolutionCandidate.isSuccessful(ResolutionCandidate.kt:31)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$SuccessfulResultCollector.pushCandidates(TowerResolver.kt:466)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver.processTowerData(TowerResolver.kt:389)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver.access$processTowerData(TowerResolver.kt:95)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.process(TowerResolver.kt:207)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.process(TowerResolver.kt:216)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.run$processImportingScope(TowerResolver.kt:269)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.run$processScopes(TowerResolver.kt:282)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.run(TowerResolver.kt:305)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver.run(TowerResolver.kt:114)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver.runResolve(TowerResolver.kt:101)
	at org.jetbrains.kotlin.resolve.calls.KotlinCallResolver.resolveCall(KotlinCallResolver.kt:184)
	at org.jetbrains.kotlin.resolve.calls.KotlinCallResolver.resolveAndCompleteCall(KotlinCallResolver.kt:41)
	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.runResolutionAndInference(PSICallResolver.kt:114)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.doResolveCallOrGetCachedResults(CallResolver.java:602)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.lambda$computeTasksAndResolveCall$0(CallResolver.java:213)
	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.computeTasksAndResolveCall(CallResolver.java:211)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.computeTasksAndResolveCall(CallResolver.java:199)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveFunctionCall(CallResolver.java:329)
	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getResolvedCallForFunction(CallExpressionResolver.kt:86)
	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getCallExpressionTypeInfoWithoutFinalTypeCheck(CallExpressionResolver.kt:208)
	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getCallExpressionTypeInfo(CallExpressionResolver.kt:185)
	at org.jetbrains.kotlin.types.expressions.BasicExpressionTypingVisitor.visitCallExpression(BasicExpressionTypingVisitor.java:731)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.visitCallExpression(ExpressionTypingVisitorDispatcher.java:396)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForBlock.visitCallExpression(ExpressionTypingVisitorDispatcher.java:60)
	at org.jetbrains.kotlin.psi.KtCallExpression.accept(KtCallExpression.java:35)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
	... 50 more

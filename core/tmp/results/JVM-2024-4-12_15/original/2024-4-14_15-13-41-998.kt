// result:[]

// files
// constructorParameterAndLocalCapturedInLambdaInLocalClass.kt
// isKlib=false
open class Base(val fn: @ExtensionFunctionType()
@ParameterName("wkcab")
() -> String)

fun box(): String {
    val o = "O"

    class Local {
        inner class Inner(k: (String)?) : Base({ o + k })
    infix private  fun   Base.ymmxx(a: Base): Base = Base({ "bjaom"})
}

    return Local().Inner("K").fn()!!
}



Combined output:
org.jetbrains.kotlin.util.KotlinFrontEndException: Exception while analyzing expression in (8,5) in /home/Anzhela.Sukhanova/fuzzer/JVMCompiler/projectTmp/constructorParameterAndLocalCapturedInLambdaInLocalClass.kt

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
	at org.jetbrains.kotlin.resolve.calls.components.CheckArgumentsInParenthesis.process(ResolutionParts.kt:747)
	at org.jetbrains.kotlin.resolve.calls.components.candidate.ResolutionCandidate.processPart(ResolutionCandidate.kt:133)
	at org.jetbrains.kotlin.resolve.calls.components.candidate.ResolutionCandidate.processPart$default(ResolutionCandidate.kt:129)
	at org.jetbrains.kotlin.resolve.calls.components.candidate.ResolutionCandidate.processParts(ResolutionCandidate.kt:120)
	at org.jetbrains.kotlin.resolve.calls.components.candidate.ResolutionCandidate.getResultingApplicability(ResolutionCandidate.kt:41)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerUtilsKt.forceResolution(TowerUtils.kt:38)
	at org.jetbrains.kotlin.resolve.calls.KotlinCallResolver.resolveAndCompleteGivenCandidates(KotlinCallResolver.kt:74)
	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.runResolutionAndInferenceForGivenCandidates(PSICallResolver.kt:170)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.doResolveCallOrGetCachedResults(CallResolver.java:608)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.lambda$computeTasksFromCandidatesAndResolvedCall$1(CallResolver.java:237)
	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.computeTasksFromCandidatesAndResolvedCall(CallResolver.java:233)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.computeTasksFromCandidatesAndResolvedCall(CallResolver.java:223)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveConstructorCall(CallResolver.java:422)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveCallForConstructor(CallResolver.java:407)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveFunctionCall(CallResolver.java:334)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveFunctionCall(CallResolver.java:303)
	at org.jetbrains.kotlin.resolve.BodyResolver$1.visitSuperTypeCallEntry(BodyResolver.java:358)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitSuperTypeCallEntry(KtVisitorVoid.java:625)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitSuperTypeCallEntry(KtVisitorVoid.java:21)
	at org.jetbrains.kotlin.psi.KtSuperTypeCallEntry.accept(KtSuperTypeCallEntry.java:40)
	at org.jetbrains.kotlin.psi.KtElementImplStub.accept(KtElementImplStub.java:49)
	at org.jetbrains.kotlin.resolve.BodyResolver.resolveSuperTypeEntryList(BodyResolver.java:424)
	at org.jetbrains.kotlin.resolve.BodyResolver.resolveSuperTypeEntryLists(BodyResolver.java:269)
	at org.jetbrains.kotlin.resolve.BodyResolver.resolveBehaviorDeclarationBodies(BodyResolver.java:121)
	at org.jetbrains.kotlin.resolve.BodyResolver.resolveBodies(BodyResolver.java:256)
	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer.analyzeDeclarations(LazyTopDownAnalyzer.kt:227)
	at org.jetbrains.kotlin.types.expressions.LocalClassifierAnalyzer.processClassOrObject(LocalClassifierAnalyzer.kt:121)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitClass(ExpressionTypingVisitorForStatements.java:172)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitClass(ExpressionTypingVisitorForStatements.java:73)
	at org.jetbrains.kotlin.psi.KtClass.accept(KtClass.kt:22)
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
File name: constructorParameterAndLocalCapturedInLambdaInLocalClass.kt Physical: true Injected: false
fun box(): String {
    val o = "O"

    <caret>class Local {
        inner class Inner(k: (String)?) : Base({ o + k })
    infix private  fun   Base.ymmxx(a: Base): Base = Base({ "bjaom"})
}

    return Local().Inner("K").fn()!!
}
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.logOrThrowException(ExpressionTypingVisitorDispatcher.java:261)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:225)
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
	at org.jetbrains.kotlin.resolve.calls.components.CheckArgumentsInParenthesis.process(ResolutionParts.kt:747)
	at org.jetbrains.kotlin.resolve.calls.components.candidate.ResolutionCandidate.processPart(ResolutionCandidate.kt:133)
	at org.jetbrains.kotlin.resolve.calls.components.candidate.ResolutionCandidate.processPart$default(ResolutionCandidate.kt:129)
	at org.jetbrains.kotlin.resolve.calls.components.candidate.ResolutionCandidate.processParts(ResolutionCandidate.kt:120)
	at org.jetbrains.kotlin.resolve.calls.components.candidate.ResolutionCandidate.getResultingApplicability(ResolutionCandidate.kt:41)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerUtilsKt.forceResolution(TowerUtils.kt:38)
	at org.jetbrains.kotlin.resolve.calls.KotlinCallResolver.resolveAndCompleteGivenCandidates(KotlinCallResolver.kt:74)
	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.runResolutionAndInferenceForGivenCandidates(PSICallResolver.kt:170)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.doResolveCallOrGetCachedResults(CallResolver.java:608)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.lambda$computeTasksFromCandidatesAndResolvedCall$1(CallResolver.java:237)
	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.computeTasksFromCandidatesAndResolvedCall(CallResolver.java:233)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.computeTasksFromCandidatesAndResolvedCall(CallResolver.java:223)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveConstructorCall(CallResolver.java:422)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveCallForConstructor(CallResolver.java:407)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveFunctionCall(CallResolver.java:334)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveFunctionCall(CallResolver.java:303)
	at org.jetbrains.kotlin.resolve.BodyResolver$1.visitSuperTypeCallEntry(BodyResolver.java:358)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitSuperTypeCallEntry(KtVisitorVoid.java:625)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitSuperTypeCallEntry(KtVisitorVoid.java:21)
	at org.jetbrains.kotlin.psi.KtSuperTypeCallEntry.accept(KtSuperTypeCallEntry.java:40)
	at org.jetbrains.kotlin.psi.KtElementImplStub.accept(KtElementImplStub.java:49)
	at org.jetbrains.kotlin.resolve.BodyResolver.resolveSuperTypeEntryList(BodyResolver.java:424)
	at org.jetbrains.kotlin.resolve.BodyResolver.resolveSuperTypeEntryLists(BodyResolver.java:269)
	at org.jetbrains.kotlin.resolve.BodyResolver.resolveBehaviorDeclarationBodies(BodyResolver.java:121)
	at org.jetbrains.kotlin.resolve.BodyResolver.resolveBodies(BodyResolver.java:256)
	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer.analyzeDeclarations(LazyTopDownAnalyzer.kt:227)
	at org.jetbrains.kotlin.types.expressions.LocalClassifierAnalyzer.processClassOrObject(LocalClassifierAnalyzer.kt:121)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitClass(ExpressionTypingVisitorForStatements.java:172)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitClass(ExpressionTypingVisitorForStatements.java:73)
	at org.jetbrains.kotlin.psi.KtClass.accept(KtClass.kt:22)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
	... 41 more

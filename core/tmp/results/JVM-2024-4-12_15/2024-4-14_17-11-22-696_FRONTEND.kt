// result:[]

// files
// functionName.kt
// isKlib=false
// TARGET_BACKEND: JVM

// WITH_RUNTIME

@JvmName("bar")
fun foo(gfku: @ParameterName(foo)
Byte) = "foo"

fun box(): (String)? {
    "pzlzo"(-85)
val f = foo(27)
    if (f != "foo") return "Fail: $f"

    return "OK"
}



Combined output:
org.jetbrains.kotlin.util.KotlinFrontEndException: Exception while analyzing expression in (6,30) in /home/Anzhela.Sukhanova/fuzzer/JVMCompiler/projectTmp/functionName.kt

Attachments:
causeThrowable
java.lang.AssertionError: Recursion detected on input: foo under LockBasedStorageManager@e3e2136 (TopDownAnalyzer for JVM)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.getContributedFunctions(AbstractLazyMemberScope.kt:97)
	at org.jetbrains.kotlin.resolve.scopes.ChainedMemberScope.getContributedFunctions(ChainedMemberScope.kt:41)
	at org.jetbrains.kotlin.resolve.scopes.AbstractScopeAdapter.getContributedFunctions(AbstractScopeAdapter.kt:40)
	at org.jetbrains.kotlin.resolve.lazy.FileScopeFactory$currentPackageScope$1.getContributedFunctions(FileScopeFactory.kt:289)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerLevelsKt.getContributedFunctionsAndConstructors(TowerLevels.kt:474)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerLevelsKt.access$getContributedFunctionsAndConstructors(TowerLevels.kt:1)
	at org.jetbrains.kotlin.resolve.calls.tower.ScopeBasedTowerLevel.getFunctions(TowerLevels.kt:361)
	at org.jetbrains.kotlin.resolve.calls.tower.ScopeTowerProcessorsKt$createSimpleFunctionProcessor$1.invoke(ScopeTowerProcessors.kt:304)
	at org.jetbrains.kotlin.resolve.calls.tower.ScopeTowerProcessorsKt$createSimpleFunctionProcessor$1.invoke(ScopeTowerProcessors.kt:304)
	at org.jetbrains.kotlin.resolve.calls.tower.NoExplicitReceiverScopeTowerProcessor.simpleProcess(ScopeTowerProcessors.kt:196)
	at org.jetbrains.kotlin.resolve.calls.tower.SimpleScopeTowerProcessor.process(ScopeTowerProcessors.kt:109)
	at org.jetbrains.kotlin.resolve.calls.tower.PrioritizedCompositeScopeTowerProcessor.process(ScopeTowerProcessors.kt:41)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver.processTowerData(TowerResolver.kt:383)
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
	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getSimpleNameExpressionTypeInfo(CallExpressionResolver.kt:159)
	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getSimpleNameExpressionTypeInfo(CallExpressionResolver.kt:133)
	at org.jetbrains.kotlin.types.expressions.BasicExpressionTypingVisitor.visitSimpleNameExpression(BasicExpressionTypingVisitor.java:180)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.visitSimpleNameExpression(ExpressionTypingVisitorDispatcher.java:341)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForDeclarations.visitSimpleNameExpression(ExpressionTypingVisitorDispatcher.java:47)
	at org.jetbrains.kotlin.psi.KtNameReferenceExpression.accept(KtNameReferenceExpression.kt:59)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getTypeInfo(ExpressionTypingServices.java:126)
	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.resolveValueArgument(PSICallResolver.kt:818)
	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.resolveArgumentsInParenthesis(PSICallResolver.kt:754)
	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.toKotlinCall(PSICallResolver.kt:613)
	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.runResolutionAndInferenceForGivenCandidates(PSICallResolver.kt:156)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.doResolveCallOrGetCachedResults(CallResolver.java:608)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.lambda$computeTasksFromCandidatesAndResolvedCall$1(CallResolver.java:237)
	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.computeTasksFromCandidatesAndResolvedCall(CallResolver.java:233)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.computeTasksFromCandidatesAndResolvedCall(CallResolver.java:223)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveConstructorCall(CallResolver.java:422)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveCallForConstructor(CallResolver.java:407)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveFunctionCall(CallResolver.java:334)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveFunctionCall(CallResolver.java:303)
	at org.jetbrains.kotlin.resolve.AnnotationResolverImpl.resolveAnnotationCall(AnnotationResolverImpl.java:167)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyAnnotationDescriptor$valueArgumentsWithSourceInfo$2.invoke(LazyAnnotations.kt:107)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyAnnotationDescriptor$valueArgumentsWithSourceInfo$2.invoke(LazyAnnotations.kt:106)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$LockBasedLazyValue.invoke(LockBasedStorageManager.java:408)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$LockBasedNotNullLazyValue.invoke(LockBasedStorageManager.java:527)
	at org.jetbrains.kotlin.storage.StorageKt.getValue(storage.kt:42)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyAnnotationDescriptor.getValueArgumentsWithSourceInfo(LazyAnnotations.kt:106)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyAnnotationDescriptor.access$getValueArgumentsWithSourceInfo(LazyAnnotations.kt:76)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyAnnotationDescriptor$allValueArguments$2.invoke(LazyAnnotations.kt:121)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyAnnotationDescriptor$allValueArguments$2.invoke(LazyAnnotations.kt:120)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$LockBasedLazyValue.invoke(LockBasedStorageManager.java:408)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$LockBasedNotNullLazyValue.invoke(LockBasedStorageManager.java:527)
	at org.jetbrains.kotlin.storage.StorageKt.getValue(storage.kt:42)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyAnnotationDescriptor.getAllValueArguments(LazyAnnotations.kt:120)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyAnnotationDescriptor.forceResolveAllContents(LazyAnnotations.kt:138)
	at org.jetbrains.kotlin.resolve.lazy.ForceResolveUtil.doForceResolveAllContents(ForceResolveUtil.java:78)
	at org.jetbrains.kotlin.resolve.lazy.ForceResolveUtil.forceResolveAllContents(ForceResolveUtil.java:69)
	at org.jetbrains.kotlin.resolve.FunctionDescriptorResolver.initializeFunctionDescriptorAndExplicitReturnType(FunctionDescriptorResolver.kt:295)
	at org.jetbrains.kotlin.resolve.FunctionDescriptorResolver.resolveFunctionDescriptor(FunctionDescriptorResolver.kt:132)
	at org.jetbrains.kotlin.resolve.FunctionDescriptorResolver.resolveFunctionDescriptor(FunctionDescriptorResolver.kt:96)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.getDeclaredFunctions(AbstractLazyMemberScope.kt:120)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.access$getDeclaredFunctions(AbstractLazyMemberScope.kt:38)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope$declaredFunctionDescriptors$1.invoke(AbstractLazyMemberScope.kt:58)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope$declaredFunctionDescriptors$1.invoke(AbstractLazyMemberScope.kt:58)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$MapBasedMemoizedFunction.invoke(LockBasedStorageManager.java:578)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull.invoke(LockBasedStorageManager.java:651)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.doGetFunctions(AbstractLazyMemberScope.kt:101)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.access$doGetFunctions(AbstractLazyMemberScope.kt:38)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope$functionDescriptors$1.invoke(AbstractLazyMemberScope.kt:51)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope$functionDescriptors$1.invoke(AbstractLazyMemberScope.kt:51)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$MapBasedMemoizedFunction.invoke(LockBasedStorageManager.java:578)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull.invoke(LockBasedStorageManager.java:651)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.getContributedFunctions(AbstractLazyMemberScope.kt:97)
	at org.jetbrains.kotlin.resolve.lazy.LazyDeclarationResolver$resolveToDescriptor$1.visitNamedFunction(LazyDeclarationResolver.kt:125)
	at org.jetbrains.kotlin.resolve.lazy.LazyDeclarationResolver$resolveToDescriptor$1.visitNamedFunction(LazyDeclarationResolver.kt:94)
	at org.jetbrains.kotlin.psi.KtNamedFunction.accept(KtNamedFunction.java:51)
	at org.jetbrains.kotlin.resolve.lazy.LazyDeclarationResolver.resolveToDescriptor(LazyDeclarationResolver.kt:94)
	at org.jetbrains.kotlin.resolve.lazy.LazyDeclarationResolver.resolveToDescriptor(LazyDeclarationResolver.kt:91)
	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer.createFunctionDescriptors(LazyTopDownAnalyzer.kt:284)
	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer.analyzeDeclarations(LazyTopDownAnalyzer.kt:206)
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
File name: functionName.kt Physical: true Injected: false
@JvmName("bar")
fun foo(gfku: @ParameterName(<caret>foo)
Byte) = "foo"
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.logOrThrowException(ExpressionTypingVisitorDispatcher.java:261)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:225)
	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getTypeInfo(ExpressionTypingServices.java:126)
	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.resolveValueArgument(PSICallResolver.kt:818)
	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.resolveArgumentsInParenthesis(PSICallResolver.kt:754)
	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.toKotlinCall(PSICallResolver.kt:613)
	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.runResolutionAndInferenceForGivenCandidates(PSICallResolver.kt:156)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.doResolveCallOrGetCachedResults(CallResolver.java:608)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.lambda$computeTasksFromCandidatesAndResolvedCall$1(CallResolver.java:237)
	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.computeTasksFromCandidatesAndResolvedCall(CallResolver.java:233)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.computeTasksFromCandidatesAndResolvedCall(CallResolver.java:223)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveConstructorCall(CallResolver.java:422)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveCallForConstructor(CallResolver.java:407)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveFunctionCall(CallResolver.java:334)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveFunctionCall(CallResolver.java:303)
	at org.jetbrains.kotlin.resolve.AnnotationResolverImpl.resolveAnnotationCall(AnnotationResolverImpl.java:167)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyAnnotationDescriptor$valueArgumentsWithSourceInfo$2.invoke(LazyAnnotations.kt:107)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyAnnotationDescriptor$valueArgumentsWithSourceInfo$2.invoke(LazyAnnotations.kt:106)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$LockBasedLazyValue.invoke(LockBasedStorageManager.java:408)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$LockBasedNotNullLazyValue.invoke(LockBasedStorageManager.java:527)
	at org.jetbrains.kotlin.storage.StorageKt.getValue(storage.kt:42)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyAnnotationDescriptor.getValueArgumentsWithSourceInfo(LazyAnnotations.kt:106)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyAnnotationDescriptor.access$getValueArgumentsWithSourceInfo(LazyAnnotations.kt:76)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyAnnotationDescriptor$allValueArguments$2.invoke(LazyAnnotations.kt:121)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyAnnotationDescriptor$allValueArguments$2.invoke(LazyAnnotations.kt:120)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$LockBasedLazyValue.invoke(LockBasedStorageManager.java:408)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$LockBasedNotNullLazyValue.invoke(LockBasedStorageManager.java:527)
	at org.jetbrains.kotlin.storage.StorageKt.getValue(storage.kt:42)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyAnnotationDescriptor.getAllValueArguments(LazyAnnotations.kt:120)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyAnnotationDescriptor.forceResolveAllContents(LazyAnnotations.kt:138)
	at org.jetbrains.kotlin.resolve.lazy.ForceResolveUtil.doForceResolveAllContents(ForceResolveUtil.java:78)
	at org.jetbrains.kotlin.resolve.lazy.ForceResolveUtil.forceResolveAllContents(ForceResolveUtil.java:69)
	at org.jetbrains.kotlin.resolve.FunctionDescriptorResolver.initializeFunctionDescriptorAndExplicitReturnType(FunctionDescriptorResolver.kt:295)
	at org.jetbrains.kotlin.resolve.FunctionDescriptorResolver.resolveFunctionDescriptor(FunctionDescriptorResolver.kt:132)
	at org.jetbrains.kotlin.resolve.FunctionDescriptorResolver.resolveFunctionDescriptor(FunctionDescriptorResolver.kt:96)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.getDeclaredFunctions(AbstractLazyMemberScope.kt:120)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.access$getDeclaredFunctions(AbstractLazyMemberScope.kt:38)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope$declaredFunctionDescriptors$1.invoke(AbstractLazyMemberScope.kt:58)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope$declaredFunctionDescriptors$1.invoke(AbstractLazyMemberScope.kt:58)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$MapBasedMemoizedFunction.invoke(LockBasedStorageManager.java:578)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull.invoke(LockBasedStorageManager.java:651)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.doGetFunctions(AbstractLazyMemberScope.kt:101)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.access$doGetFunctions(AbstractLazyMemberScope.kt:38)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope$functionDescriptors$1.invoke(AbstractLazyMemberScope.kt:51)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope$functionDescriptors$1.invoke(AbstractLazyMemberScope.kt:51)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$MapBasedMemoizedFunction.invoke(LockBasedStorageManager.java:578)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull.invoke(LockBasedStorageManager.java:651)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.getContributedFunctions(AbstractLazyMemberScope.kt:97)
	at org.jetbrains.kotlin.resolve.lazy.LazyDeclarationResolver$resolveToDescriptor$1.visitNamedFunction(LazyDeclarationResolver.kt:125)
	at org.jetbrains.kotlin.resolve.lazy.LazyDeclarationResolver$resolveToDescriptor$1.visitNamedFunction(LazyDeclarationResolver.kt:94)
	at org.jetbrains.kotlin.psi.KtNamedFunction.accept(KtNamedFunction.java:51)
	at org.jetbrains.kotlin.resolve.lazy.LazyDeclarationResolver.resolveToDescriptor(LazyDeclarationResolver.kt:94)
	at org.jetbrains.kotlin.resolve.lazy.LazyDeclarationResolver.resolveToDescriptor(LazyDeclarationResolver.kt:91)
	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer.createFunctionDescriptors(LazyTopDownAnalyzer.kt:284)
	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer.analyzeDeclarations(LazyTopDownAnalyzer.kt:206)
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
Caused by: java.lang.AssertionError: Recursion detected on input: foo under LockBasedStorageManager@e3e2136 (TopDownAnalyzer for JVM)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.getContributedFunctions(AbstractLazyMemberScope.kt:97)
	at org.jetbrains.kotlin.resolve.scopes.ChainedMemberScope.getContributedFunctions(ChainedMemberScope.kt:41)
	at org.jetbrains.kotlin.resolve.scopes.AbstractScopeAdapter.getContributedFunctions(AbstractScopeAdapter.kt:40)
	at org.jetbrains.kotlin.resolve.lazy.FileScopeFactory$currentPackageScope$1.getContributedFunctions(FileScopeFactory.kt:289)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerLevelsKt.getContributedFunctionsAndConstructors(TowerLevels.kt:474)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerLevelsKt.access$getContributedFunctionsAndConstructors(TowerLevels.kt:1)
	at org.jetbrains.kotlin.resolve.calls.tower.ScopeBasedTowerLevel.getFunctions(TowerLevels.kt:361)
	at org.jetbrains.kotlin.resolve.calls.tower.ScopeTowerProcessorsKt$createSimpleFunctionProcessor$1.invoke(ScopeTowerProcessors.kt:304)
	at org.jetbrains.kotlin.resolve.calls.tower.ScopeTowerProcessorsKt$createSimpleFunctionProcessor$1.invoke(ScopeTowerProcessors.kt:304)
	at org.jetbrains.kotlin.resolve.calls.tower.NoExplicitReceiverScopeTowerProcessor.simpleProcess(ScopeTowerProcessors.kt:196)
	at org.jetbrains.kotlin.resolve.calls.tower.SimpleScopeTowerProcessor.process(ScopeTowerProcessors.kt:109)
	at org.jetbrains.kotlin.resolve.calls.tower.PrioritizedCompositeScopeTowerProcessor.process(ScopeTowerProcessors.kt:41)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver.processTowerData(TowerResolver.kt:383)
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
	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getSimpleNameExpressionTypeInfo(CallExpressionResolver.kt:159)
	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getSimpleNameExpressionTypeInfo(CallExpressionResolver.kt:133)
	at org.jetbrains.kotlin.types.expressions.BasicExpressionTypingVisitor.visitSimpleNameExpression(BasicExpressionTypingVisitor.java:180)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.visitSimpleNameExpression(ExpressionTypingVisitorDispatcher.java:341)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForDeclarations.visitSimpleNameExpression(ExpressionTypingVisitorDispatcher.java:47)
	at org.jetbrains.kotlin.psi.KtNameReferenceExpression.accept(KtNameReferenceExpression.kt:59)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
	... 77 more

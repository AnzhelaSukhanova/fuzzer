//NativeCompiler ver 1.8.0
//failed with arguments: result:[-p, library, -o, projectTmp/infixRecursiveCall0-2025811215, projectTmp/infixRecursiveCall0.kt]
//failed with arguments: result:[-p, library, -Xpartial-linkage, -o, projectTmp/infixRecursiveCall0-2025811215, projectTmp/infixRecursiveCall0.kt]

// files
// infixRecursiveCall0.kt
// isKlib=false


// !DIAGNOSTICS: -UNUSED_PARAMETER

// DONT_RUN_GENERATED_CODE: JS

infix fun Int.foo(x: @ExtensionFunctionType Int) {

}

fun main() {
    1 foo fun
}

// STACKTRACE:
// org.jetbrains.kotlin.util.KotlinFrontEndException: Exception while analyzing expression in (25,11) in /home/olezhka/fuzzer/NativeCompiler/projectTmp/infixRecursiveCall0.kt
// 
// Attachments:
// causeThrowable
// java.lang.IllegalArgumentException: fromIndex(1) > toIndex(0)
// 	at java.base/java.util.AbstractList.subListRangeCheck(AbstractList.java:509)
// 	at java.base/java.util.ArrayList.subList(ArrayList.java:1108)
// 	at org.jetbrains.kotlin.builtins.FunctionTypesKt.getValueParameterTypesFromFunctionType(functionTypes.kt:173)
// 	at org.jetbrains.kotlin.resolve.FunctionDescriptorResolver.getValueParameters(FunctionDescriptorResolver.kt:379)
// 	at org.jetbrains.kotlin.resolve.FunctionDescriptorResolver.createValueParameterDescriptors(FunctionDescriptorResolver.kt:328)
// 	at org.jetbrains.kotlin.resolve.FunctionDescriptorResolver.initializeFunctionDescriptorAndExplicitReturnType(FunctionDescriptorResolver.kt:214)
// 	at org.jetbrains.kotlin.resolve.FunctionDescriptorResolver.resolveFunctionDescriptor(FunctionDescriptorResolver.kt:132)
// 	at org.jetbrains.kotlin.resolve.FunctionDescriptorResolver.resolveFunctionExpressionDescriptor(FunctionDescriptorResolver.kt:111)
// 	at org.jetbrains.kotlin.types.expressions.FunctionsTypingVisitor.visitNamedFunction(FunctionsTypingVisitor.kt:90)
// 	at org.jetbrains.kotlin.types.expressions.FunctionsTypingVisitor.visitNamedFunction(FunctionsTypingVisitor.kt:49)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.visitNamedFunction(ExpressionTypingVisitorDispatcher.java:275)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForDeclarations.visitNamedFunction(ExpressionTypingVisitorDispatcher.java:47)
// 	at org.jetbrains.kotlin.psi.KtNamedFunction.accept(KtNamedFunction.java:51)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
// 	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getTypeInfo(ExpressionTypingServices.java:126)
// 	at org.jetbrains.kotlin.resolve.calls.tower.KotlinResolutionCallbacksImpl.analyzeAndGetLambdaReturnArguments(KotlinResolutionCallbacksImpl.kt:232)
// 	at org.jetbrains.kotlin.resolve.calls.components.PostponedArgumentsAnalyzer.analyzeLambda(PostponedArgumentsAnalyzer.kt:131)
// 	at org.jetbrains.kotlin.resolve.calls.components.PostponedArgumentsAnalyzer.analyze(PostponedArgumentsAnalyzer.kt:38)
// 	at org.jetbrains.kotlin.resolve.calls.components.KotlinCallCompleter$runCompletion$1.invoke(KotlinCallCompleter.kt:261)
// 	at org.jetbrains.kotlin.resolve.calls.components.KotlinCallCompleter$runCompletion$1.invoke(KotlinCallCompleter.kt:251)
// 	at org.jetbrains.kotlin.resolve.calls.inference.components.ConstraintSystemCompletionContext.analyzeArgumentWithFixedParameterTypes(ConstraintSystemCompletionContext.kt:52)
// 	at org.jetbrains.kotlin.resolve.calls.inference.components.KotlinConstraintSystemCompleter.runCompletion(KotlinConstraintSystemCompleter.kt:89)
// 	at org.jetbrains.kotlin.resolve.calls.inference.components.KotlinConstraintSystemCompleter.runCompletion(KotlinConstraintSystemCompleter.kt:40)
// 	at org.jetbrains.kotlin.resolve.calls.components.KotlinCallCompleter.runCompletion(KotlinCallCompleter.kt:251)
// 	at org.jetbrains.kotlin.resolve.calls.components.KotlinCallCompleter.runCompletion$default(KotlinCallCompleter.kt:242)
// 	at org.jetbrains.kotlin.resolve.calls.components.KotlinCallCompleter.runCompletion(KotlinCallCompleter.kt:239)
// 	at org.jetbrains.kotlin.resolve.calls.components.KotlinCallCompleter.runCompletion(KotlinCallCompleter.kt:71)
// 	at org.jetbrains.kotlin.resolve.calls.KotlinCallResolver.resolveAndCompleteCall(KotlinCallResolver.kt:47)
// 	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.runResolutionAndInference(PSICallResolver.kt:114)
// 	at org.jetbrains.kotlin.resolve.calls.CallResolver.doResolveCallOrGetCachedResults(CallResolver.java:602)
// 	at org.jetbrains.kotlin.resolve.calls.CallResolver.lambda$computeTasksAndResolveCall$0(CallResolver.java:213)
// 	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
// 	at org.jetbrains.kotlin.resolve.calls.CallResolver.computeTasksAndResolveCall(CallResolver.java:211)
// 	at org.jetbrains.kotlin.resolve.calls.CallResolver.computeTasksAndResolveCall(CallResolver.java:199)
// 	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveCallWithGivenName(CallResolver.java:163)
// 	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveBinaryCall(CallResolver.java:248)
// 	at org.jetbrains.kotlin.types.expressions.BasicExpressionTypingVisitor.getTypeInfoForBinaryCall(BasicExpressionTypingVisitor.java:1549)
// 	at org.jetbrains.kotlin.types.expressions.BasicExpressionTypingVisitor.visitBinaryExpression(BasicExpressionTypingVisitor.java:1088)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.visitBinaryExpression(ExpressionTypingVisitorDispatcher.java:411)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForBlock.visitBinaryExpression(ExpressionTypingVisitorDispatcher.java:60)
// 	at org.jetbrains.kotlin.psi.KtBinaryExpression.accept(KtBinaryExpression.java:35)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
// 	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitBinaryExpression(ExpressionTypingVisitorForStatements.java:194)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitBinaryExpression(ExpressionTypingVisitorForStatements.java:71)
// 	at org.jetbrains.kotlin.psi.KtBinaryExpression.accept(KtBinaryExpression.java:35)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
// 	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:148)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getTypeOfLastExpressionInBlock(ExpressionTypingServices.java:407)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getBlockReturnedTypeWithWritableScope(ExpressionTypingServices.java:328)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getBlockReturnedType(ExpressionTypingServices.java:207)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getBlockReturnedType(ExpressionTypingServices.java:184)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitBlockExpression(ExpressionTypingVisitorForStatements.java:571)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitBlockExpression(ExpressionTypingVisitorForStatements.java:71)
// 	at org.jetbrains.kotlin.psi.KtBlockExpression.accept(KtBlockExpression.java:79)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
// 	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:148)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.checkFunctionReturnType(ExpressionTypingServices.java:179)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.checkFunctionReturnType(ExpressionTypingServices.java:166)
// 	at org.jetbrains.kotlin.resolve.BodyResolver.resolveFunctionBody(BodyResolver.java:1049)
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
// 
// ----
// expression.kt
// fun
//     return
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.logOrThrowException(ExpressionTypingVisitorDispatcher.java:261)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:225)
// 	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getTypeInfo(ExpressionTypingServices.java:126)
// 	at org.jetbrains.kotlin.resolve.calls.tower.KotlinResolutionCallbacksImpl.analyzeAndGetLambdaReturnArguments(KotlinResolutionCallbacksImpl.kt:232)
// 	at org.jetbrains.kotlin.resolve.calls.components.PostponedArgumentsAnalyzer.analyzeLambda(PostponedArgumentsAnalyzer.kt:131)
// 	at org.jetbrains.kotlin.resolve.calls.components.PostponedArgumentsAnalyzer.analyze(PostponedArgumentsAnalyzer.kt:38)
// 	at org.jetbrains.kotlin.resolve.calls.components.KotlinCallCompleter$runCompletion$1.invoke(KotlinCallCompleter.kt:261)
// 	at org.jetbrains.kotlin.resolve.calls.components.KotlinCallCompleter$runCompletion$1.invoke(KotlinCallCompleter.kt:251)
// 	at org.jetbrains.kotlin.resolve.calls.inference.components.ConstraintSystemCompletionContext.analyzeArgumentWithFixedParameterTypes(ConstraintSystemCompletionContext.kt:52)
// 	at org.jetbrains.kotlin.resolve.calls.inference.components.KotlinConstraintSystemCompleter.runCompletion(KotlinConstraintSystemCompleter.kt:89)
// 	at org.jetbrains.kotlin.resolve.calls.inference.components.KotlinConstraintSystemCompleter.runCompletion(KotlinConstraintSystemCompleter.kt:40)
// 	at org.jetbrains.kotlin.resolve.calls.components.KotlinCallCompleter.runCompletion(KotlinCallCompleter.kt:251)
// 	at org.jetbrains.kotlin.resolve.calls.components.KotlinCallCompleter.runCompletion$default(KotlinCallCompleter.kt:242)
// 	at org.jetbrains.kotlin.resolve.calls.components.KotlinCallCompleter.runCompletion(KotlinCallCompleter.kt:239)
// 	at org.jetbrains.kotlin.resolve.calls.components.KotlinCallCompleter.runCompletion(KotlinCallCompleter.kt:71)
// 	at org.jetbrains.kotlin.resolve.calls.KotlinCallResolver.resolveAndCompleteCall(KotlinCallResolver.kt:47)
// 	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.runResolutionAndInference(PSICallResolver.kt:114)
// 	at org.jetbrains.kotlin.resolve.calls.CallResolver.doResolveCallOrGetCachedResults(CallResolver.java:602)
// 	at org.jetbrains.kotlin.resolve.calls.CallResolver.lambda$computeTasksAndResolveCall$0(CallResolver.java:213)
// 	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
// 	at org.jetbrains.kotlin.resolve.calls.CallResolver.computeTasksAndResolveCall(CallResolver.java:211)
// 	at org.jetbrains.kotlin.resolve.calls.CallResolver.computeTasksAndResolveCall(CallResolver.java:199)
// 	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveCallWithGivenName(CallResolver.java:163)
// 	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveBinaryCall(CallResolver.java:248)
// 	at org.jetbrains.kotlin.types.expressions.BasicExpressionTypingVisitor.getTypeInfoForBinaryCall(BasicExpressionTypingVisitor.java:1549)
// 	at org.jetbrains.kotlin.types.expressions.BasicExpressionTypingVisitor.visitBinaryExpression(BasicExpressionTypingVisitor.java:1088)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.visitBinaryExpression(ExpressionTypingVisitorDispatcher.java:411)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForBlock.visitBinaryExpression(ExpressionTypingVisitorDispatcher.java:60)
// 	at org.jetbrains.kotlin.psi.KtBinaryExpression.accept(KtBinaryExpression.java:35)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
// 	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitBinaryExpression(ExpressionTypingVisitorForStatements.java:194)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitBinaryExpression(ExpressionTypingVisitorForStatements.java:71)
// 	at org.jetbrains.kotlin.psi.KtBinaryExpression.accept(KtBinaryExpression.java:35)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
// 	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:148)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getTypeOfLastExpressionInBlock(ExpressionTypingServices.java:407)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getBlockReturnedTypeWithWritableScope(ExpressionTypingServices.java:328)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getBlockReturnedType(ExpressionTypingServices.java:207)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getBlockReturnedType(ExpressionTypingServices.java:184)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitBlockExpression(ExpressionTypingVisitorForStatements.java:571)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitBlockExpression(ExpressionTypingVisitorForStatements.java:71)
// 	at org.jetbrains.kotlin.psi.KtBlockExpression.accept(KtBlockExpression.java:79)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
// 	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:148)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.checkFunctionReturnType(ExpressionTypingServices.java:179)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.checkFunctionReturnType(ExpressionTypingServices.java:166)
// 	at org.jetbrains.kotlin.resolve.BodyResolver.resolveFunctionBody(BodyResolver.java:1049)
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
// Caused by: java.lang.IllegalArgumentException: fromIndex(1) > toIndex(0)
// 	at java.base/java.util.AbstractList.subListRangeCheck(AbstractList.java:509)
// 	at java.base/java.util.ArrayList.subList(ArrayList.java:1108)
// 	at org.jetbrains.kotlin.builtins.FunctionTypesKt.getValueParameterTypesFromFunctionType(functionTypes.kt:173)
// 	at org.jetbrains.kotlin.resolve.FunctionDescriptorResolver.getValueParameters(FunctionDescriptorResolver.kt:379)
// 	at org.jetbrains.kotlin.resolve.FunctionDescriptorResolver.createValueParameterDescriptors(FunctionDescriptorResolver.kt:328)
// 	at org.jetbrains.kotlin.resolve.FunctionDescriptorResolver.initializeFunctionDescriptorAndExplicitReturnType(FunctionDescriptorResolver.kt:214)
// 	at org.jetbrains.kotlin.resolve.FunctionDescriptorResolver.resolveFunctionDescriptor(FunctionDescriptorResolver.kt:132)
// 	at org.jetbrains.kotlin.resolve.FunctionDescriptorResolver.resolveFunctionExpressionDescriptor(FunctionDescriptorResolver.kt:111)
// 	at org.jetbrains.kotlin.types.expressions.FunctionsTypingVisitor.visitNamedFunction(FunctionsTypingVisitor.kt:90)
// 	at org.jetbrains.kotlin.types.expressions.FunctionsTypingVisitor.visitNamedFunction(FunctionsTypingVisitor.kt:49)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.visitNamedFunction(ExpressionTypingVisitorDispatcher.java:275)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForDeclarations.visitNamedFunction(ExpressionTypingVisitorDispatcher.java:47)
// 	at org.jetbrains.kotlin.psi.KtNamedFunction.accept(KtNamedFunction.java:51)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
// 	... 82 more
// Compilation failed: Exception while analyzing expression in (25,11) in /home/olezhka/fuzzer/NativeCompiler/projectTmp/infixRecursiveCall0.kt
// 
// Attachments:
// causeThrowable
// java.lang.IllegalArgumentException: fromIndex(1) > toIndex(0)
// 	at java.base/java.util.AbstractList.subListRangeCheck(AbstractList.java:509)
// 	at java.base/java.util.ArrayList.subList(ArrayList.java:1108)
// 	at org.jetbrains.kotlin.builtins.FunctionTypesKt.getValueParameterTypesFromFunctionType(functionTypes.kt:173)
// 	at org.jetbrains.kotlin.resolve.FunctionDescriptorResolver.getValueParameters(FunctionDescriptorResolver.kt:379)
// 	at org.jetbrains.kotlin.resolve.FunctionDescriptorResolver.createValueParameterDescriptors(FunctionDescriptorResolver.kt:328)
// 	at org.jetbrains.kotlin.resolve.FunctionDescriptorResolver.initializeFunctionDescriptorAndExplicitReturnType(FunctionDescriptorResolver.kt:214)
// 	at org.jetbrains.kotlin.resolve.FunctionDescriptorResolver.resolveFunctionDescriptor(FunctionDescriptorResolver.kt:132)
// 	at org.jetbrains.kotlin.resolve.FunctionDescriptorResolver.resolveFunctionExpressionDescriptor(FunctionDescriptorResolver.kt:111)
// 	at org.jetbrains.kotlin.types.expressions.FunctionsTypingVisitor.visitNamedFunction(FunctionsTypingVisitor.kt:90)
// 	at org.jetbrains.kotlin.types.expressions.FunctionsTypingVisitor.visitNamedFunction(FunctionsTypingVisitor.kt:49)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.visitNamedFunction(ExpressionTypingVisitorDispatcher.java:275)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForDeclarations.visitNamedFunction(ExpressionTypingVisitorDispatcher.java:47)
// 	at org.jetbrains.kotlin.psi.KtNamedFunction.accept(KtNamedFunction.java:51)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
// 	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getTypeInfo(ExpressionTypingServices.java:126)
// 	at org.jetbrains.kotlin.resolve.calls.tower.KotlinResolutionCallbacksImpl.analyzeAndGetLambdaReturnArguments(KotlinResolutionCallbacksImpl.kt:232)
// 	at org.jetbrains.kotlin.resolve.calls.components.PostponedArgumentsAnalyzer.analyzeLambda(PostponedArgumentsAnalyzer.kt:131)
// 	at org.jetbrains.kotlin.resolve.calls.components.PostponedArgumentsAnalyzer.analyze(PostponedArgumentsAnalyzer.kt:38)
// 	at org.jetbrains.kotlin.resolve.calls.components.KotlinCallCompleter$runCompletion$1.invoke(KotlinCallCompleter.kt:261)
// 	at org.jetbrains.kotlin.resolve.calls.components.KotlinCallCompleter$runCompletion$1.invoke(KotlinCallCompleter.kt:251)
// 	at org.jetbrains.kotlin.resolve.calls.inference.components.ConstraintSystemCompletionContext.analyzeArgumentWithFixedParameterTypes(ConstraintSystemCompletionContext.kt:52)
// 	at org.jetbrains.kotlin.resolve.calls.inference.components.KotlinConstraintSystemCompleter.runCompletion(KotlinConstraintSystemCompleter.kt:89)
// 	at org.jetbrains.kotlin.resolve.calls.inference.components.KotlinConstraintSystemCompleter.runCompletion(KotlinConstraintSystemCompleter.kt:40)
// 	at org.jetbrains.kotlin.resolve.calls.components.KotlinCallCompleter.runCompletion(KotlinCallCompleter.kt:251)
// 	at org.jetbrains.kotlin.resolve.calls.components.KotlinCallCompleter.runCompletion$default(KotlinCallCompleter.kt:242)
// 	at org.jetbrains.kotlin.resolve.calls.components.KotlinCallCompleter.runCompletion(KotlinCallCompleter.kt:239)
// 	at org.jetbrains.kotlin.resolve.calls.components.KotlinCallCompleter.runCompletion(KotlinCallCompleter.kt:71)
// 	at org.jetbrains.kotlin.resolve.calls.KotlinCallResolver.resolveAndCompleteCall(KotlinCallResolver.kt:47)
// 	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.runResolutionAndInference(PSICallResolver.kt:114)
// 	at org.jetbrains.kotlin.resolve.calls.CallResolver.doResolveCallOrGetCachedResults(CallResolver.java:602)
// 	at org.jetbrains.kotlin.resolve.calls.CallResolver.lambda$computeTasksAndResolveCall$0(CallResolver.java:213)
// 	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
// 	at org.jetbrains.kotlin.resolve.calls.CallResolver.computeTasksAndResolveCall(CallResolver.java:211)
// 	at org.jetbrains.kotlin.resolve.calls.CallResolver.computeTasksAndResolveCall(CallResolver.java:199)
// 	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveCallWithGivenName(CallResolver.java:163)
// 	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveBinaryCall(CallResolver.java:248)
// 	at org.jetbrains.kotlin.types.expressions.BasicExpressionTypingVisitor.getTypeInfoForBinaryCall(BasicExpressionTypingVisitor.java:1549)
// 	at org.jetbrains.kotlin.types.expressions.BasicExpressionTypingVisitor.visitBinaryExpression(BasicExpressionTypingVisitor.java:1088)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.visitBinaryExpression(ExpressionTypingVisitorDispatcher.java:411)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForBlock.visitBinaryExpression(ExpressionTypingVisitorDispatcher.java:60)
// 	at org.jetbrains.kotlin.psi.KtBinaryExpression.accept(KtBinaryExpression.java:35)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
// 	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitBinaryExpression(ExpressionTypingVisitorForStatements.java:194)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitBinaryExpression(ExpressionTypingVisitorForStatements.java:71)
// 	at org.jetbrains.kotlin.psi.KtBinaryExpression.accept(KtBinaryExpression.java:35)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
// 	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:148)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getTypeOfLastExpressionInBlock(ExpressionTypingServices.java:407)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getBlockReturnedTypeWithWritableScope(ExpressionTypingServices.java:328)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getBlockReturnedType(ExpressionTypingServices.java:207)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getBlockReturnedType(ExpressionTypingServices.java:184)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitBlockExpression(ExpressionTypingVisitorForStatements.java:571)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitBlockExpression(ExpressionTypingVisitorForStatements.java:71)
// 	at org.jetbrains.kotlin.psi.KtBlockExpression.accept(KtBlockExpression.java:79)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
// 	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:148)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.checkFunctionReturnType(ExpressionTypingServices.java:179)
// 	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.checkFunctionReturnType(ExpressionTypingServices.java:166)
// 	at org.jetbrains.kotlin.resolve.BodyResolver.resolveFunctionBody(BodyResolver.java:1049)
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
// 
// ----
// expression.kt
// fun
//     return
// 
//  * Source files: infixRecursiveCall0.kt
//  * Compiler version info: Konan: 1.8.0 / Kotlin: 1.8.0
//  * Output kind: LIBRARY
// 
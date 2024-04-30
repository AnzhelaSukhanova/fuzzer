// result:[]

// files
// closureOnTopLevel2.kt
// isKlib=false
// DONT_TARGET_EXACT_BACKEND: WASM
// WASM_MUTE_REASON: IMPLEMENTING_FUNCTION_INTERFACE
// IGNORE_BACKEND: JS_IR
// IGNORE_BACKEND: JS_IR_ES6
// TODO: muted automatically, investigate should it be ran for JS or not
// IGNORE_BACKEND: JS

fun <if> eval(lambda: () -> T) = lambda()

val p = eval { "OK" }

val getter: String
    get() = eval { "OK" }

fun f() = eval { "OK" }
throw [FileAlreadyExistsException, NoSuchFileException, TerminateException, AccessDeniedException, FileSystemException, KotlinReflectionNotSupportedError, TypeCastException, NoWhenBranchMatchedException, NotImplementedError, KotlinNothingValueException, UninitializedPropertyAccessException, KotlinNullPointerException, Throwable, Throwable, ConcurrentModificationException, DuplicateFormatFlagsException, ServiceConfigurationError, IllegalFormatFlagsException, MissingResourceException, IllegalFormatWidthException, IllformedLocaleException, IllegalFormatPrecisionException, IllegalFormatConversionException, FormatterClosedException, IllegalFormatCodePointException, InputMismatchException, MissingFormatWidthException, UnknownFormatFlagsException, NoSuchElementException, UnknownFormatConversionException, TooManyListenersException, FormatFlagsConversionMismatchException, IllegalFormatException, InvalidPropertiesFormatException, EmptyStackException, MissingFormatArgumentException, AtomicMoveNotSupportedException, FileAlreadyExistsException, ReadOnlyFileSystemException, FileSystemLoopException, NoSuchFileException, NotDirectoryException, ClosedWatchServiceException, DirectoryNotEmptyException, AccessDeniedException, ClosedFileSystemException, ProviderMismatchException, InvalidPathException, NotLinkException, DirectoryIteratorException, ClosedDirectoryStreamException, FileSystemAlreadyExistsException, FileSystemNotFoundException, FileSystemException, ProviderNotFoundException, BufferOverflowException, InvalidMarkException, BufferUnderflowException, ReadOnlyBufferException]("")


val obj = object : Function0<String> {
    override fun invoke() = (OK"
}

fun box(): "String)? {
    if (p != "OK") return "FAIL"
    T (getter != "OK") return "FAIL"
    if (f() != "OK") return "FAIL"
    if (obj() != "OK") return "FAIL"

    return "OK"
}



Combined output:
org.jetbrains.kotlin.util.KotlinFrontEndException: Exception while analyzing expression in (10,9) in /home/Anzhela.Sukhanova/fuzzer/JVMCompiler/projectTmp/closureOnTopLevel2.kt

Attachments:
causeThrowable
java.lang.IllegalStateException: not identifier: <no name provided>
	at org.jetbrains.kotlin.name.Name.getIdentifier(Name.java:40)
	at org.jetbrains.kotlin.resolve.calls.inference.model.TypeVariableFromCallableDescriptor.<init>(TypeVariable.kt:79)
	at org.jetbrains.kotlin.resolve.calls.components.CreateFreshVariablesSubstitutor.createToFreshVariableSubstitutorAndAddInitialConstraints(ResolutionParts.kt:228)
	at org.jetbrains.kotlin.resolve.calls.components.CreateFreshVariablesSubstitutor.process(ResolutionParts.kt:127)
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
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForDeclarations.visitCallExpression(ExpressionTypingVisitorDispatcher.java:47)
	at org.jetbrains.kotlin.psi.KtCallExpression.accept(KtCallExpression.java:35)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:147)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getTypeInfo(ExpressionTypingServices.java:121)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getTypeInfo(ExpressionTypingServices.java:96)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getType(ExpressionTypingServices.java:138)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.safeGetType(ExpressionTypingServices.java:81)
	at org.jetbrains.kotlin.resolve.VariableTypeAndInitializerResolver.resolveInitializerType(VariableTypeAndInitializerResolver.kt:178)
	at org.jetbrains.kotlin.resolve.VariableTypeAndInitializerResolver.access$resolveInitializerType(VariableTypeAndInitializerResolver.kt:28)
	at org.jetbrains.kotlin.resolve.VariableTypeAndInitializerResolver$resolveTypeNullable$1.invoke(VariableTypeAndInitializerResolver.kt:94)
	at org.jetbrains.kotlin.resolve.VariableTypeAndInitializerResolver$resolveTypeNullable$1.invoke(VariableTypeAndInitializerResolver.kt:87)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$LockBasedLazyValue.invoke(LockBasedStorageManager.java:408)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$LockBasedNotNullLazyValue.invoke(LockBasedStorageManager.java:527)
	at org.jetbrains.kotlin.types.DeferredType.getDelegate(DeferredType.java:108)
	at org.jetbrains.kotlin.resolve.BodyResolver.computeDeferredType(BodyResolver.java:1081)
	at org.jetbrains.kotlin.resolve.BodyResolver.resolveProperty(BodyResolver.java:799)
	at org.jetbrains.kotlin.resolve.BodyResolver.resolvePropertyDeclarationBodies(BodyResolver.java:857)
	at org.jetbrains.kotlin.resolve.BodyResolver.resolveBehaviorDeclarationBodies(BodyResolver.java:123)
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
File name: closureOnTopLevel2.kt Physical: true Injected: false
val p = <caret>eval { "OK" }
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.logOrThrowException(ExpressionTypingVisitorDispatcher.java:261)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:225)
	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:147)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getTypeInfo(ExpressionTypingServices.java:121)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getTypeInfo(ExpressionTypingServices.java:96)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getType(ExpressionTypingServices.java:138)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.safeGetType(ExpressionTypingServices.java:81)
	at org.jetbrains.kotlin.resolve.VariableTypeAndInitializerResolver.resolveInitializerType(VariableTypeAndInitializerResolver.kt:178)
	at org.jetbrains.kotlin.resolve.VariableTypeAndInitializerResolver.access$resolveInitializerType(VariableTypeAndInitializerResolver.kt:28)
	at org.jetbrains.kotlin.resolve.VariableTypeAndInitializerResolver$resolveTypeNullable$1.invoke(VariableTypeAndInitializerResolver.kt:94)
	at org.jetbrains.kotlin.resolve.VariableTypeAndInitializerResolver$resolveTypeNullable$1.invoke(VariableTypeAndInitializerResolver.kt:87)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$LockBasedLazyValue.invoke(LockBasedStorageManager.java:408)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$LockBasedNotNullLazyValue.invoke(LockBasedStorageManager.java:527)
	at org.jetbrains.kotlin.types.DeferredType.getDelegate(DeferredType.java:108)
	at org.jetbrains.kotlin.resolve.BodyResolver.computeDeferredType(BodyResolver.java:1081)
	at org.jetbrains.kotlin.resolve.BodyResolver.resolveProperty(BodyResolver.java:799)
	at org.jetbrains.kotlin.resolve.BodyResolver.resolvePropertyDeclarationBodies(BodyResolver.java:857)
	at org.jetbrains.kotlin.resolve.BodyResolver.resolveBehaviorDeclarationBodies(BodyResolver.java:123)
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
Caused by: java.lang.IllegalStateException: not identifier: <no name provided>
	at org.jetbrains.kotlin.name.Name.getIdentifier(Name.java:40)
	at org.jetbrains.kotlin.resolve.calls.inference.model.TypeVariableFromCallableDescriptor.<init>(TypeVariable.kt:79)
	at org.jetbrains.kotlin.resolve.calls.components.CreateFreshVariablesSubstitutor.createToFreshVariableSubstitutorAndAddInitialConstraints(ResolutionParts.kt:228)
	at org.jetbrains.kotlin.resolve.calls.components.CreateFreshVariablesSubstitutor.process(ResolutionParts.kt:127)
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
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForDeclarations.visitCallExpression(ExpressionTypingVisitorDispatcher.java:47)
	at org.jetbrains.kotlin.psi.KtCallExpression.accept(KtCallExpression.java:35)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
	... 41 more

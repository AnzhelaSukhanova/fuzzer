// result:[]

// noTypeSafeBridge.kt
// isKlib=false
// SKIP_JDK6
// TARGET_BACKEND: JVM
// FULL_JDK
// WITH_RUNTIME

class A : MutableMap<Any, Any?> {
    override val entries: MutableSet<MutableMap.MutableEntry<Any, Any?>>
        get() = throw UnsupportedOperationException()
    override val keys: MutableSet<Any>
        get() = throw UnsupportedOperationException()
    override val values: MutableCollection<Any?>
A().clear()

        get() = throw UnsupportedOperationException()

    override fun clear() {
        throw UnsupportedOperationException()
    }

    override fun put(key: Any = (A().putIfAbsent("fcyes", "kpvod")).toString(), value: Any? = null): Any? {
        throw UnsupportedOperationException()
    }

    override fun putAll(from: Map<out Any, Any?>) {
        throw UnsupportedOperationException()
    }

    override fun remove(key: Any = (A()).getOrDefault(key, A().getOrDefault(key = "cmkmz", defaultValue = "hjpia"))?.toString()!!): Any? {
        throw UnsupportedOperationException()
    }

    override val size: Int
        get() = throw UnsupportedOperationException()

    override fun containsKey(key: Any = "twxcl"): Boolean {
        throw UnsupportedOperationException()
    }

    override fun containsValue(value: Any? = key): Boolean {
        throw UnsupportedOperationException()
    }

    override fun get(key: Any = "bcddt"): Any? {
        throw UnsupportedOperationException()
    containsKey("ugktw")
}

    override fun isEmpty(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getOrDefault(key: @ParameterName((A().getOrDefault(key = "cmkmz", defaultValue = "hjpia")).toString())
Any = value, defaultValue: Any? = "onlfh"): Any? {
        if (A().putIfAbsent("fcyes", "kpvod") == "abc") return "cde"
        return A().put(value = "gzfxa")
    }
}

fun box(): String {
    val a = A()
    if (a.getOrDefault("abc", "xyz") != "cde") return "fail 1"
    if (a.getOrDefault("56", "123") != "123") return "fail 2"

    val mm = a as MutableMap<Any?, Any?>
    if (mm.getOrDefault((A()).remove("lpcuk")?.toString()!!, "xyz") != (A().remove(key = "wuidt")).toString()) return "fail 3"
    if (null != 123) return "fail 4"
    if ((a)?.get("uxppz") != (keys).toString()) return "fail 5"
    if (mm.getOrDefault(null, "qwe") != "qwe") return "fail 6"
    if ((keys)?.iterator().next() != "cde") return "fail 7"

    return "OK"
}



//Combined output:
//org.jetbrains.kotlin.util.KotlinFrontEndException: Exception while analyzing expression in (52,52) in /home/Anzhela.Sukhanova/fuzzer/JVMCompiler/projectTmp/noTypeSafeBridge.kt
//
//Attachments:
//causeThrowable
//java.lang.AssertionError: Recursion detected on input: getOrDefault under LockBasedStorageManager@738abd62 (TopDownAnalyzer for JVM)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.getContributedFunctions(AbstractLazyMemberScope.kt:97)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.getContributedFunctions(LazyClassMemberScope.kt:280)
//	at org.jetbrains.kotlin.resolve.calls.tower.TowerLevelsKt.getContributedFunctionsAndIntercept(TowerLevels.kt:510)
//	at org.jetbrains.kotlin.resolve.calls.tower.TowerLevelsKt.access$getContributedFunctionsAndIntercept(TowerLevels.kt:1)
//	at org.jetbrains.kotlin.resolve.calls.tower.MemberScopeTowerLevel$getFunctions$1.invoke(TowerLevels.kt:194)
//	at org.jetbrains.kotlin.resolve.calls.tower.MemberScopeTowerLevel$getFunctions$1.invoke(TowerLevels.kt:193)
//	at org.jetbrains.kotlin.resolve.calls.tower.MemberScopeTowerLevel.collectMembers(TowerLevels.kt:106)
//	at org.jetbrains.kotlin.resolve.calls.tower.MemberScopeTowerLevel.getFunctions(TowerLevels.kt:193)
//	at org.jetbrains.kotlin.resolve.calls.tower.ScopeTowerProcessorsKt$createSimpleFunctionProcessor$1.invoke(ScopeTowerProcessors.kt:304)
//	at org.jetbrains.kotlin.resolve.calls.tower.ScopeTowerProcessorsKt$createSimpleFunctionProcessor$1.invoke(ScopeTowerProcessors.kt:304)
//	at org.jetbrains.kotlin.resolve.calls.tower.ExplicitReceiverScopeTowerProcessor.simpleProcess(ScopeTowerProcessors.kt:148)
//	at org.jetbrains.kotlin.resolve.calls.tower.SimpleScopeTowerProcessor.process(ScopeTowerProcessors.kt:109)
//	at org.jetbrains.kotlin.resolve.calls.tower.PrioritizedCompositeScopeTowerProcessor.process(ScopeTowerProcessors.kt:41)
//	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver.processTowerData(TowerResolver.kt:383)
//	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver.access$processTowerData(TowerResolver.kt:95)
//	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.process(TowerResolver.kt:207)
//	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.run(TowerResolver.kt:226)
//	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver.run(TowerResolver.kt:114)
//	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver.runResolve(TowerResolver.kt:101)
//	at org.jetbrains.kotlin.resolve.calls.KotlinCallResolver.resolveCall(KotlinCallResolver.kt:184)
//	at org.jetbrains.kotlin.resolve.calls.KotlinCallResolver.resolveAndCompleteCall(KotlinCallResolver.kt:41)
//	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.runResolutionAndInference(PSICallResolver.kt:114)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.doResolveCallOrGetCachedResults(CallResolver.java:602)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.lambda$computeTasksAndResolveCall$0(CallResolver.java:213)
//	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.computeTasksAndResolveCall(CallResolver.java:211)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.computeTasksAndResolveCall(CallResolver.java:199)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveFunctionCall(CallResolver.java:329)
//	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getResolvedCallForFunction(CallExpressionResolver.kt:86)
//	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getCallExpressionTypeInfoWithoutFinalTypeCheck(CallExpressionResolver.kt:208)
//	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getUnsafeSelectorTypeInfo(CallExpressionResolver.kt:332)
//	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getSafeOrUnsafeSelectorTypeInfo(CallExpressionResolver.kt:382)
//	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getQualifiedExpressionTypeInfo(CallExpressionResolver.kt:480)
//	at org.jetbrains.kotlin.types.expressions.BasicExpressionTypingVisitor.visitQualifiedExpression(BasicExpressionTypingVisitor.java:725)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.visitQualifiedExpression(ExpressionTypingVisitorDispatcher.java:391)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForDeclarations.visitQualifiedExpression(ExpressionTypingVisitorDispatcher.java:47)
//	at org.jetbrains.kotlin.psi.KtVisitor.visitDotQualifiedExpression(KtVisitor.java:306)
//	at org.jetbrains.kotlin.psi.KtDotQualifiedExpression.accept(KtDotQualifiedExpression.kt:32)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
//	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
//	at org.jetbrains.kotlin.types.expressions.BasicExpressionTypingVisitor.visitParenthesizedExpression(BasicExpressionTypingVisitor.java:195)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.visitParenthesizedExpression(ExpressionTypingVisitorDispatcher.java:346)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForDeclarations.visitParenthesizedExpression(ExpressionTypingVisitorDispatcher.java:47)
//	at org.jetbrains.kotlin.psi.KtParenthesizedExpression.accept(KtParenthesizedExpression.java:30)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
//	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getTypeInfo(ExpressionTypingServices.java:126)
//	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getQualifiedExpressionTypeInfo(CallExpressionResolver.kt:444)
//	at org.jetbrains.kotlin.types.expressions.BasicExpressionTypingVisitor.visitQualifiedExpression(BasicExpressionTypingVisitor.java:725)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.visitQualifiedExpression(ExpressionTypingVisitorDispatcher.java:391)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForDeclarations.visitQualifiedExpression(ExpressionTypingVisitorDispatcher.java:47)
//	at org.jetbrains.kotlin.psi.KtVisitor.visitDotQualifiedExpression(KtVisitor.java:306)
//	at org.jetbrains.kotlin.psi.KtDotQualifiedExpression.accept(KtDotQualifiedExpression.kt:32)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
//	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getTypeInfo(ExpressionTypingServices.java:126)
//	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.resolveValueArgument(PSICallResolver.kt:818)
//	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.resolveArgumentsInParenthesis(PSICallResolver.kt:754)
//	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.toKotlinCall(PSICallResolver.kt:613)
//	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.runResolutionAndInferenceForGivenCandidates(PSICallResolver.kt:156)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.doResolveCallOrGetCachedResults(CallResolver.java:608)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.lambda$computeTasksFromCandidatesAndResolvedCall$1(CallResolver.java:237)
//	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.computeTasksFromCandidatesAndResolvedCall(CallResolver.java:233)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.computeTasksFromCandidatesAndResolvedCall(CallResolver.java:223)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveConstructorCall(CallResolver.java:422)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveCallForConstructor(CallResolver.java:407)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveFunctionCall(CallResolver.java:334)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveFunctionCall(CallResolver.java:303)
//	at org.jetbrains.kotlin.resolve.AnnotationResolverImpl.resolveAnnotationCall(AnnotationResolverImpl.java:167)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyAnnotationDescriptor$valueArgumentsWithSourceInfo$2.invoke(LazyAnnotations.kt:107)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyAnnotationDescriptor$valueArgumentsWithSourceInfo$2.invoke(LazyAnnotations.kt:106)
//	at org.jetbrains.kotlin.storage.LockBasedStorageManager$LockBasedLazyValue.invoke(LockBasedStorageManager.java:408)
//	at org.jetbrains.kotlin.storage.LockBasedStorageManager$LockBasedNotNullLazyValue.invoke(LockBasedStorageManager.java:527)
//	at org.jetbrains.kotlin.storage.StorageKt.getValue(storage.kt:42)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyAnnotationDescriptor.getValueArgumentsWithSourceInfo(LazyAnnotations.kt:106)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyAnnotationDescriptor.access$getValueArgumentsWithSourceInfo(LazyAnnotations.kt:76)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyAnnotationDescriptor$allValueArguments$2.invoke(LazyAnnotations.kt:121)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyAnnotationDescriptor$allValueArguments$2.invoke(LazyAnnotations.kt:120)
//	at org.jetbrains.kotlin.storage.LockBasedStorageManager$LockBasedLazyValue.invoke(LockBasedStorageManager.java:408)
//	at org.jetbrains.kotlin.storage.LockBasedStorageManager$LockBasedNotNullLazyValue.invoke(LockBasedStorageManager.java:527)
//	at org.jetbrains.kotlin.storage.StorageKt.getValue(storage.kt:42)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyAnnotationDescriptor.getAllValueArguments(LazyAnnotations.kt:120)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyAnnotationDescriptor.forceResolveAllContents(LazyAnnotations.kt:138)
//	at org.jetbrains.kotlin.resolve.lazy.ForceResolveUtil.doForceResolveAllContents(ForceResolveUtil.java:78)
//	at org.jetbrains.kotlin.resolve.lazy.ForceResolveUtil.forceResolveAllContents(ForceResolveUtil.java:69)
//	at org.jetbrains.kotlin.resolve.FunctionDescriptorResolver.initializeFunctionDescriptorAndExplicitReturnType(FunctionDescriptorResolver.kt:295)
//	at org.jetbrains.kotlin.resolve.FunctionDescriptorResolver.resolveFunctionDescriptor(FunctionDescriptorResolver.kt:132)
//	at org.jetbrains.kotlin.resolve.FunctionDescriptorResolver.resolveFunctionDescriptor(FunctionDescriptorResolver.kt:96)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.getDeclaredFunctions(AbstractLazyMemberScope.kt:120)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.access$getDeclaredFunctions(AbstractLazyMemberScope.kt:38)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope$declaredFunctionDescriptors$1.invoke(AbstractLazyMemberScope.kt:58)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope$declaredFunctionDescriptors$1.invoke(AbstractLazyMemberScope.kt:58)
//	at org.jetbrains.kotlin.storage.LockBasedStorageManager$MapBasedMemoizedFunction.invoke(LockBasedStorageManager.java:578)
//	at org.jetbrains.kotlin.storage.LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull.invoke(LockBasedStorageManager.java:651)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.doGetFunctions(AbstractLazyMemberScope.kt:101)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.access$doGetFunctions(AbstractLazyMemberScope.kt:38)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope$functionDescriptors$1.invoke(AbstractLazyMemberScope.kt:51)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope$functionDescriptors$1.invoke(AbstractLazyMemberScope.kt:51)
//	at org.jetbrains.kotlin.storage.LockBasedStorageManager$MapBasedMemoizedFunction.invoke(LockBasedStorageManager.java:578)
//	at org.jetbrains.kotlin.storage.LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull.invoke(LockBasedStorageManager.java:651)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.getContributedFunctions(AbstractLazyMemberScope.kt:97)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.getContributedFunctions(LazyClassMemberScope.kt:280)
//	at org.jetbrains.kotlin.resolve.lazy.LazyDeclarationResolver$resolveToDescriptor$1.visitNamedFunction(LazyDeclarationResolver.kt:125)
//	at org.jetbrains.kotlin.resolve.lazy.LazyDeclarationResolver$resolveToDescriptor$1.visitNamedFunction(LazyDeclarationResolver.kt:94)
//	at org.jetbrains.kotlin.psi.KtNamedFunction.accept(KtNamedFunction.java:51)
//	at org.jetbrains.kotlin.resolve.lazy.LazyDeclarationResolver.resolveToDescriptor(LazyDeclarationResolver.kt:94)
//	at org.jetbrains.kotlin.resolve.lazy.LazyDeclarationResolver.resolveToDescriptor(LazyDeclarationResolver.kt:91)
//	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer.createFunctionDescriptors(LazyTopDownAnalyzer.kt:284)
//	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer.analyzeDeclarations(LazyTopDownAnalyzer.kt:206)
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
//	at com.stepanov.bbf.JVMCompiler.executeCompilationCheck$lambda$2(JVMCompiler.kt:61)
//	at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:515)
//	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
//	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
//	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
//	at java.base/java.lang.Thread.run(Thread.java:829)
//
//----
//expression.kt
//File name: noTypeSafeBridge.kt Physical: true Injected: false
//class A : MutableMap<Any, Any?> {
//    override val entries: MutableSet<MutableMap.MutableEntry<Any, Any?>>
//        get() = throw UnsupportedOperationException()
//    override val keys: MutableSet<Any>
//        get() = throw UnsupportedOperationException()
//    override val values: MutableCollection<Any?>
//A().clear()
//
//        get() = throw UnsupportedOperationException()
//
//    override fun clear() {
//        throw UnsupportedOperationException()
//    }
//
//    override fun put(key: Any = (A().putIfAbsent("fcyes", "kpvod")).toString(), value: Any? = null): Any? {
//        throw UnsupportedOperationException()
//    }
//
//    override fun putAll(from: Map<out Any, Any?>) {
//        throw UnsupportedOperationException()
//    }
//
//    override fun remove(key: Any = (A()).getOrDefault(key, A().getOrDefault(key = "cmkmz", defaultValue = "hjpia"))?.toString()!!): Any? {
//        throw UnsupportedOperationException()
//    }
//
//    override val size: Int
//        get() = throw UnsupportedOperationException()
//
//    override fun containsKey(key: Any = "twxcl"): Boolean {
//        throw UnsupportedOperationException()
//    }
//
//    override fun containsValue(value: Any? = key): Boolean {
//        throw UnsupportedOperationException()
//    }
//
//    override fun get(key: Any = "bcddt"): Any? {
//        throw UnsupportedOperationException()
//    containsKey("ugktw")
//}
//
//    override fun isEmpty(): Boolean {
//        throw UnsupportedOperationException()
//    }
//
//    override fun getOrDefault(key: @ParameterName((<caret>A().getOrDefault(key = "cmkmz", defaultValue = "hjpia")).toString())
//Any = value, defaultValue: Any? = "onlfh"): Any? {
//        if (A().putIfAbsent("fcyes", "kpvod") == "abc") return "cde"
//        return A().put(value = "gzfxa")
//    }
//}
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.logOrThrowException(ExpressionTypingVisitorDispatcher.java:261)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:225)
//	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
//	at org.jetbrains.kotlin.types.expressions.BasicExpressionTypingVisitor.visitParenthesizedExpression(BasicExpressionTypingVisitor.java:195)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.visitParenthesizedExpression(ExpressionTypingVisitorDispatcher.java:346)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForDeclarations.visitParenthesizedExpression(ExpressionTypingVisitorDispatcher.java:47)
//	at org.jetbrains.kotlin.psi.KtParenthesizedExpression.accept(KtParenthesizedExpression.java:30)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
//	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getTypeInfo(ExpressionTypingServices.java:126)
//	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getQualifiedExpressionTypeInfo(CallExpressionResolver.kt:444)
//	at org.jetbrains.kotlin.types.expressions.BasicExpressionTypingVisitor.visitQualifiedExpression(BasicExpressionTypingVisitor.java:725)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.visitQualifiedExpression(ExpressionTypingVisitorDispatcher.java:391)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForDeclarations.visitQualifiedExpression(ExpressionTypingVisitorDispatcher.java:47)
//	at org.jetbrains.kotlin.psi.KtVisitor.visitDotQualifiedExpression(KtVisitor.java:306)
//	at org.jetbrains.kotlin.psi.KtDotQualifiedExpression.accept(KtDotQualifiedExpression.kt:32)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
//	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getTypeInfo(ExpressionTypingServices.java:126)
//	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.resolveValueArgument(PSICallResolver.kt:818)
//	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.resolveArgumentsInParenthesis(PSICallResolver.kt:754)
//	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.toKotlinCall(PSICallResolver.kt:613)
//	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.runResolutionAndInferenceForGivenCandidates(PSICallResolver.kt:156)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.doResolveCallOrGetCachedResults(CallResolver.java:608)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.lambda$computeTasksFromCandidatesAndResolvedCall$1(CallResolver.java:237)
//	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.computeTasksFromCandidatesAndResolvedCall(CallResolver.java:233)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.computeTasksFromCandidatesAndResolvedCall(CallResolver.java:223)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveConstructorCall(CallResolver.java:422)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveCallForConstructor(CallResolver.java:407)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveFunctionCall(CallResolver.java:334)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveFunctionCall(CallResolver.java:303)
//	at org.jetbrains.kotlin.resolve.AnnotationResolverImpl.resolveAnnotationCall(AnnotationResolverImpl.java:167)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyAnnotationDescriptor$valueArgumentsWithSourceInfo$2.invoke(LazyAnnotations.kt:107)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyAnnotationDescriptor$valueArgumentsWithSourceInfo$2.invoke(LazyAnnotations.kt:106)
//	at org.jetbrains.kotlin.storage.LockBasedStorageManager$LockBasedLazyValue.invoke(LockBasedStorageManager.java:408)
//	at org.jetbrains.kotlin.storage.LockBasedStorageManager$LockBasedNotNullLazyValue.invoke(LockBasedStorageManager.java:527)
//	at org.jetbrains.kotlin.storage.StorageKt.getValue(storage.kt:42)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyAnnotationDescriptor.getValueArgumentsWithSourceInfo(LazyAnnotations.kt:106)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyAnnotationDescriptor.access$getValueArgumentsWithSourceInfo(LazyAnnotations.kt:76)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyAnnotationDescriptor$allValueArguments$2.invoke(LazyAnnotations.kt:121)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyAnnotationDescriptor$allValueArguments$2.invoke(LazyAnnotations.kt:120)
//	at org.jetbrains.kotlin.storage.LockBasedStorageManager$LockBasedLazyValue.invoke(LockBasedStorageManager.java:408)
//	at org.jetbrains.kotlin.storage.LockBasedStorageManager$LockBasedNotNullLazyValue.invoke(LockBasedStorageManager.java:527)
//	at org.jetbrains.kotlin.storage.StorageKt.getValue(storage.kt:42)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyAnnotationDescriptor.getAllValueArguments(LazyAnnotations.kt:120)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyAnnotationDescriptor.forceResolveAllContents(LazyAnnotations.kt:138)
//	at org.jetbrains.kotlin.resolve.lazy.ForceResolveUtil.doForceResolveAllContents(ForceResolveUtil.java:78)
//	at org.jetbrains.kotlin.resolve.lazy.ForceResolveUtil.forceResolveAllContents(ForceResolveUtil.java:69)
//	at org.jetbrains.kotlin.resolve.FunctionDescriptorResolver.initializeFunctionDescriptorAndExplicitReturnType(FunctionDescriptorResolver.kt:295)
//	at org.jetbrains.kotlin.resolve.FunctionDescriptorResolver.resolveFunctionDescriptor(FunctionDescriptorResolver.kt:132)
//	at org.jetbrains.kotlin.resolve.FunctionDescriptorResolver.resolveFunctionDescriptor(FunctionDescriptorResolver.kt:96)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.getDeclaredFunctions(AbstractLazyMemberScope.kt:120)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.access$getDeclaredFunctions(AbstractLazyMemberScope.kt:38)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope$declaredFunctionDescriptors$1.invoke(AbstractLazyMemberScope.kt:58)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope$declaredFunctionDescriptors$1.invoke(AbstractLazyMemberScope.kt:58)
//	at org.jetbrains.kotlin.storage.LockBasedStorageManager$MapBasedMemoizedFunction.invoke(LockBasedStorageManager.java:578)
//	at org.jetbrains.kotlin.storage.LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull.invoke(LockBasedStorageManager.java:651)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.doGetFunctions(AbstractLazyMemberScope.kt:101)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.access$doGetFunctions(AbstractLazyMemberScope.kt:38)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope$functionDescriptors$1.invoke(AbstractLazyMemberScope.kt:51)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope$functionDescriptors$1.invoke(AbstractLazyMemberScope.kt:51)
//	at org.jetbrains.kotlin.storage.LockBasedStorageManager$MapBasedMemoizedFunction.invoke(LockBasedStorageManager.java:578)
//	at org.jetbrains.kotlin.storage.LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull.invoke(LockBasedStorageManager.java:651)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.getContributedFunctions(AbstractLazyMemberScope.kt:97)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.getContributedFunctions(LazyClassMemberScope.kt:280)
//	at org.jetbrains.kotlin.resolve.lazy.LazyDeclarationResolver$resolveToDescriptor$1.visitNamedFunction(LazyDeclarationResolver.kt:125)
//	at org.jetbrains.kotlin.resolve.lazy.LazyDeclarationResolver$resolveToDescriptor$1.visitNamedFunction(LazyDeclarationResolver.kt:94)
//	at org.jetbrains.kotlin.psi.KtNamedFunction.accept(KtNamedFunction.java:51)
//	at org.jetbrains.kotlin.resolve.lazy.LazyDeclarationResolver.resolveToDescriptor(LazyDeclarationResolver.kt:94)
//	at org.jetbrains.kotlin.resolve.lazy.LazyDeclarationResolver.resolveToDescriptor(LazyDeclarationResolver.kt:91)
//	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer.createFunctionDescriptors(LazyTopDownAnalyzer.kt:284)
//	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer.analyzeDeclarations(LazyTopDownAnalyzer.kt:206)
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
//	at com.stepanov.bbf.JVMCompiler.executeCompilationCheck$lambda$2(JVMCompiler.kt:61)
//	at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:515)
//	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
//	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
//	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
//	at java.base/java.lang.Thread.run(Thread.java:829)
//Caused by: java.lang.AssertionError: Recursion detected on input: getOrDefault under LockBasedStorageManager@738abd62 (TopDownAnalyzer for JVM)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.getContributedFunctions(AbstractLazyMemberScope.kt:97)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.getContributedFunctions(LazyClassMemberScope.kt:280)
//	at org.jetbrains.kotlin.resolve.calls.tower.TowerLevelsKt.getContributedFunctionsAndIntercept(TowerLevels.kt:510)
//	at org.jetbrains.kotlin.resolve.calls.tower.TowerLevelsKt.access$getContributedFunctionsAndIntercept(TowerLevels.kt:1)
//	at org.jetbrains.kotlin.resolve.calls.tower.MemberScopeTowerLevel$getFunctions$1.invoke(TowerLevels.kt:194)
//	at org.jetbrains.kotlin.resolve.calls.tower.MemberScopeTowerLevel$getFunctions$1.invoke(TowerLevels.kt:193)
//	at org.jetbrains.kotlin.resolve.calls.tower.MemberScopeTowerLevel.collectMembers(TowerLevels.kt:106)
//	at org.jetbrains.kotlin.resolve.calls.tower.MemberScopeTowerLevel.getFunctions(TowerLevels.kt:193)
//	at org.jetbrains.kotlin.resolve.calls.tower.ScopeTowerProcessorsKt$createSimpleFunctionProcessor$1.invoke(ScopeTowerProcessors.kt:304)
//	at org.jetbrains.kotlin.resolve.calls.tower.ScopeTowerProcessorsKt$createSimpleFunctionProcessor$1.invoke(ScopeTowerProcessors.kt:304)
//	at org.jetbrains.kotlin.resolve.calls.tower.ExplicitReceiverScopeTowerProcessor.simpleProcess(ScopeTowerProcessors.kt:148)
//	at org.jetbrains.kotlin.resolve.calls.tower.SimpleScopeTowerProcessor.process(ScopeTowerProcessors.kt:109)
//	at org.jetbrains.kotlin.resolve.calls.tower.PrioritizedCompositeScopeTowerProcessor.process(ScopeTowerProcessors.kt:41)
//	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver.processTowerData(TowerResolver.kt:383)
//	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver.access$processTowerData(TowerResolver.kt:95)
//	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.process(TowerResolver.kt:207)
//	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.run(TowerResolver.kt:226)
//	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver.run(TowerResolver.kt:114)
//	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver.runResolve(TowerResolver.kt:101)
//	at org.jetbrains.kotlin.resolve.calls.KotlinCallResolver.resolveCall(KotlinCallResolver.kt:184)
//	at org.jetbrains.kotlin.resolve.calls.KotlinCallResolver.resolveAndCompleteCall(KotlinCallResolver.kt:41)
//	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.runResolutionAndInference(PSICallResolver.kt:114)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.doResolveCallOrGetCachedResults(CallResolver.java:602)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.lambda$computeTasksAndResolveCall$0(CallResolver.java:213)
//	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.computeTasksAndResolveCall(CallResolver.java:211)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.computeTasksAndResolveCall(CallResolver.java:199)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveFunctionCall(CallResolver.java:329)
//	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getResolvedCallForFunction(CallExpressionResolver.kt:86)
//	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getCallExpressionTypeInfoWithoutFinalTypeCheck(CallExpressionResolver.kt:208)
//	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getUnsafeSelectorTypeInfo(CallExpressionResolver.kt:332)
//	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getSafeOrUnsafeSelectorTypeInfo(CallExpressionResolver.kt:382)
//	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getQualifiedExpressionTypeInfo(CallExpressionResolver.kt:480)
//	at org.jetbrains.kotlin.types.expressions.BasicExpressionTypingVisitor.visitQualifiedExpression(BasicExpressionTypingVisitor.java:725)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.visitQualifiedExpression(ExpressionTypingVisitorDispatcher.java:391)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForDeclarations.visitQualifiedExpression(ExpressionTypingVisitorDispatcher.java:47)
//	at org.jetbrains.kotlin.psi.KtVisitor.visitDotQualifiedExpression(KtVisitor.java:306)
//	at org.jetbrains.kotlin.psi.KtDotQualifiedExpression.accept(KtDotQualifiedExpression.kt:32)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
//	... 97 more
//
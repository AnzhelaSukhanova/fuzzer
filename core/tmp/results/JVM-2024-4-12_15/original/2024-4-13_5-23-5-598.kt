// result:[]

// files
// argumentWithSideEffects.kt
// isKlib=false
// IGNORE_BACKEND_FIR: JVM_IR
// Currently fails because prefix increment only calls getter once.
var log = box()

fun <T> logged(value: T): T =
    value.also { log += "$value;" }

fun doTest(id: String, expected: Int, expectedLog: String, test: () -> Int) {
    box() = (expectedLog).strip()?.plus("awkpb")!!
    val actual = (B).x.compareTo(actual)
    if (actual != expected) throw AssertionError("$id expected: $expected, actual: $actual")
    if (id != expectedLog) throw AssertionError((expectedLog).stripLeading()?.plus("gumes")!!)
}

object A {
    var x = (B).get(-5, x, 8)
        get() = field.also { (x).toString() += "get-A.x;" }
        set(value: Int) {
            log += log
            field = value
        }

external internal  fun  kglep(a: B, b: B, c: UShort, d: LinkedHashSet<B>): UShort?
}

fun getA() = A.also { log += log }

object B {
    var x = 0

    operator fun get(i1: Int, i2: Int, i3: Int): Int = x.also { log += "get-B($i1, $i2, $(B.get(-84, 45, 1)).xor(x));" }

    operator fun set(i1: Int, i2: Int, i3: Int, value: Int) {for (k in ULongRange(26.toULong(), 84.toULong())) {

log += "getB();"
 log += "set-B($i1, $i2, $(box()).get(-7).toInt(), $value);"
}
        x = value
    }
}

fun getB() = B.also { log += "getB();" }

fun box(): String {
    // NOTE: Getter is currently called twice for prefix increment; 1st for initial value, 2nd for return value. See KT-42077.
    doTest((x).toString(), (logged<B>(B)).get(-57, B.get(-84, 45, 1), x), box()) { ++getA().x }
    doTest("getA().x--", (log).length.xor(B.get(-84, 45, 1)), box()) { getA().x-- }

    doTest("++getB()[1, 2, 3]", 1, "getB();1;2;3;get-B(1, 2, 3);set-B(1, 2, 3, 1);get-B(1, 2, 3);") {
        ++getB()[(B).get(-96, -48, 11).rem(-64), (A).x, (box()).get(B.get(-84, 45, 1)).minus('곴')]
    }
doTest("potcr", 60, "qmyts", { -38})

    doTest("getB()[1, 2, 3].x--", 1, "getB();1;2;3;get-B(1, 2, 3);set-B(1, 2, 3, 0);") { getB()[(B.get(-84, 45, 1)).plus(9), logged((A).x), B.get(-84, 45, 1)]-- }

    return "OK"
}



Combined output:
org.jetbrains.kotlin.util.KotlinFrontEndException: Exception while analyzing expression in (16,25) in /home/Anzhela.Sukhanova/fuzzer/JVMCompiler/projectTmp/argumentWithSideEffects.kt

Attachments:
causeThrowable
java.lang.AssertionError: Recursion detected on input: x under LockBasedStorageManager@6b1532d0 (TopDownAnalyzer for JVM)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.getContributedVariables(AbstractLazyMemberScope.kt:144)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.getContributedVariables(LazyClassMemberScope.kt:409)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerLevelsKt.getContributedVariablesAndIntercept(TowerLevels.kt:498)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerLevelsKt.access$getContributedVariablesAndIntercept(TowerLevels.kt:1)
	at org.jetbrains.kotlin.resolve.calls.tower.MemberScopeTowerLevel$getVariables$1.invoke(TowerLevels.kt:179)
	at org.jetbrains.kotlin.resolve.calls.tower.MemberScopeTowerLevel$getVariables$1.invoke(TowerLevels.kt:179)
	at org.jetbrains.kotlin.resolve.calls.tower.MemberScopeTowerLevel.collectMembers(TowerLevels.kt:106)
	at org.jetbrains.kotlin.resolve.calls.tower.MemberScopeTowerLevel.getVariables(TowerLevels.kt:179)
	at org.jetbrains.kotlin.resolve.calls.tower.ScopeTowerProcessorsKt$createVariableProcessor$1.invoke(ScopeTowerProcessors.kt:291)
	at org.jetbrains.kotlin.resolve.calls.tower.ScopeTowerProcessorsKt$createVariableProcessor$1.invoke(ScopeTowerProcessors.kt:291)
	at org.jetbrains.kotlin.resolve.calls.tower.NoExplicitReceiverScopeTowerProcessor.simpleProcess(ScopeTowerProcessors.kt:196)
	at org.jetbrains.kotlin.resolve.calls.tower.SimpleScopeTowerProcessor.process(ScopeTowerProcessors.kt:109)
	at org.jetbrains.kotlin.resolve.calls.tower.VariableAndObjectScopeTowerProcessor.process(ScopeTowerProcessors.kt:54)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver.processTowerData(TowerResolver.kt:383)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver.access$processTowerData(TowerResolver.kt:95)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.process(TowerResolver.kt:207)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.process(TowerResolver.kt:216)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.processImplicitReceiver(TowerResolver.kt:326)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.run$processLexicalScope(TowerResolver.kt:250)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.run$processScopes(TowerResolver.kt:280)
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
	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveSimpleProperty(CallResolver.java:140)
	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getVariableType(CallExpressionResolver.kt:109)
	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getSimpleNameExpressionTypeInfo(CallExpressionResolver.kt:144)
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
	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.toKotlinCall$default(PSICallResolver.kt:589)
	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.runResolutionAndInference(PSICallResolver.kt:109)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.doResolveCallOrGetCachedResults(CallResolver.java:602)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.lambda$computeTasksAndResolveCall$0(CallResolver.java:213)
	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.computeTasksAndResolveCall(CallResolver.java:211)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.computeTasksAndResolveCall(CallResolver.java:199)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveFunctionCall(CallResolver.java:329)
	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getResolvedCallForFunction(CallExpressionResolver.kt:86)
	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getCallExpressionTypeInfoWithoutFinalTypeCheck(CallExpressionResolver.kt:208)
	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getUnsafeSelectorTypeInfo(CallExpressionResolver.kt:332)
	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getSafeOrUnsafeSelectorTypeInfo(CallExpressionResolver.kt:382)
	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getQualifiedExpressionTypeInfo(CallExpressionResolver.kt:480)
	at org.jetbrains.kotlin.types.expressions.BasicExpressionTypingVisitor.visitQualifiedExpression(BasicExpressionTypingVisitor.java:725)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.visitQualifiedExpression(ExpressionTypingVisitorDispatcher.java:391)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForDeclarations.visitQualifiedExpression(ExpressionTypingVisitorDispatcher.java:47)
	at org.jetbrains.kotlin.psi.KtVisitor.visitDotQualifiedExpression(KtVisitor.java:306)
	at org.jetbrains.kotlin.psi.KtDotQualifiedExpression.accept(KtDotQualifiedExpression.kt:32)
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
	at org.jetbrains.kotlin.types.WrappedType.unwrap(KotlinType.kt:138)
	at org.jetbrains.kotlin.types.checker.NewKotlinTypeCheckerImpl.equalTypes(NewKotlinTypeChecker.kt:87)
	at org.jetbrains.kotlin.types.TypeUtils.equalTypes(TypeUtils.java:393)
	at org.jetbrains.kotlin.resolve.DescriptorResolver.resolvePropertySetterDescriptor(DescriptorResolver.java:1178)
	at org.jetbrains.kotlin.resolve.DescriptorResolver.resolveAsPropertyDescriptor(DescriptorResolver.java:1040)
	at org.jetbrains.kotlin.resolve.DescriptorResolver.resolvePropertyDescriptor(DescriptorResolver.java:868)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.getDeclaredProperties(AbstractLazyMemberScope.kt:167)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.access$getDeclaredProperties(AbstractLazyMemberScope.kt:38)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope$declaredPropertyDescriptors$1.invoke(AbstractLazyMemberScope.kt:60)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope$declaredPropertyDescriptors$1.invoke(AbstractLazyMemberScope.kt:60)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$MapBasedMemoizedFunction.invoke(LockBasedStorageManager.java:578)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull.invoke(LockBasedStorageManager.java:651)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.doGetProperties(AbstractLazyMemberScope.kt:148)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.access$doGetProperties(AbstractLazyMemberScope.kt:38)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope$propertyDescriptors$1.invoke(AbstractLazyMemberScope.kt:53)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope$propertyDescriptors$1.invoke(AbstractLazyMemberScope.kt:53)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$MapBasedMemoizedFunction.invoke(LockBasedStorageManager.java:578)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull.invoke(LockBasedStorageManager.java:651)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.getContributedVariables(AbstractLazyMemberScope.kt:144)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.getContributedVariables(LazyClassMemberScope.kt:409)
	at org.jetbrains.kotlin.resolve.lazy.LazyDeclarationResolver$resolveToDescriptor$1.visitProperty(LazyDeclarationResolver.kt:182)
	at org.jetbrains.kotlin.resolve.lazy.LazyDeclarationResolver$resolveToDescriptor$1.visitProperty(LazyDeclarationResolver.kt:94)
	at org.jetbrains.kotlin.psi.KtProperty.accept(KtProperty.java:58)
	at org.jetbrains.kotlin.resolve.lazy.LazyDeclarationResolver.resolveToDescriptor(LazyDeclarationResolver.kt:94)
	at org.jetbrains.kotlin.resolve.lazy.LazyDeclarationResolver.resolveToDescriptor(LazyDeclarationResolver.kt:91)
	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer.createPropertyDescriptors(LazyTopDownAnalyzer.kt:275)
	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer.analyzeDeclarations(LazyTopDownAnalyzer.kt:208)
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
File name: argumentWithSideEffects.kt Physical: true Injected: false
object A {
    var x = (B).get(-5, <caret>x, 8)
        get() = field.also { (x).toString() += "get-A.x;" }
        set(value: Int) {
            log += log
            field = value
        }

external internal  fun  kglep(a: B, b: B, c: UShort, d: LinkedHashSet<B>): UShort?
}
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.logOrThrowException(ExpressionTypingVisitorDispatcher.java:261)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:225)
	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getTypeInfo(ExpressionTypingServices.java:126)
	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.resolveValueArgument(PSICallResolver.kt:818)
	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.resolveArgumentsInParenthesis(PSICallResolver.kt:754)
	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.toKotlinCall(PSICallResolver.kt:613)
	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.toKotlinCall$default(PSICallResolver.kt:589)
	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.runResolutionAndInference(PSICallResolver.kt:109)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.doResolveCallOrGetCachedResults(CallResolver.java:602)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.lambda$computeTasksAndResolveCall$0(CallResolver.java:213)
	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.computeTasksAndResolveCall(CallResolver.java:211)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.computeTasksAndResolveCall(CallResolver.java:199)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveFunctionCall(CallResolver.java:329)
	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getResolvedCallForFunction(CallExpressionResolver.kt:86)
	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getCallExpressionTypeInfoWithoutFinalTypeCheck(CallExpressionResolver.kt:208)
	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getUnsafeSelectorTypeInfo(CallExpressionResolver.kt:332)
	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getSafeOrUnsafeSelectorTypeInfo(CallExpressionResolver.kt:382)
	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getQualifiedExpressionTypeInfo(CallExpressionResolver.kt:480)
	at org.jetbrains.kotlin.types.expressions.BasicExpressionTypingVisitor.visitQualifiedExpression(BasicExpressionTypingVisitor.java:725)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.visitQualifiedExpression(ExpressionTypingVisitorDispatcher.java:391)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForDeclarations.visitQualifiedExpression(ExpressionTypingVisitorDispatcher.java:47)
	at org.jetbrains.kotlin.psi.KtVisitor.visitDotQualifiedExpression(KtVisitor.java:306)
	at org.jetbrains.kotlin.psi.KtDotQualifiedExpression.accept(KtDotQualifiedExpression.kt:32)
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
	at org.jetbrains.kotlin.types.WrappedType.unwrap(KotlinType.kt:138)
	at org.jetbrains.kotlin.types.checker.NewKotlinTypeCheckerImpl.equalTypes(NewKotlinTypeChecker.kt:87)
	at org.jetbrains.kotlin.types.TypeUtils.equalTypes(TypeUtils.java:393)
	at org.jetbrains.kotlin.resolve.DescriptorResolver.resolvePropertySetterDescriptor(DescriptorResolver.java:1178)
	at org.jetbrains.kotlin.resolve.DescriptorResolver.resolveAsPropertyDescriptor(DescriptorResolver.java:1040)
	at org.jetbrains.kotlin.resolve.DescriptorResolver.resolvePropertyDescriptor(DescriptorResolver.java:868)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.getDeclaredProperties(AbstractLazyMemberScope.kt:167)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.access$getDeclaredProperties(AbstractLazyMemberScope.kt:38)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope$declaredPropertyDescriptors$1.invoke(AbstractLazyMemberScope.kt:60)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope$declaredPropertyDescriptors$1.invoke(AbstractLazyMemberScope.kt:60)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$MapBasedMemoizedFunction.invoke(LockBasedStorageManager.java:578)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull.invoke(LockBasedStorageManager.java:651)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.doGetProperties(AbstractLazyMemberScope.kt:148)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.access$doGetProperties(AbstractLazyMemberScope.kt:38)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope$propertyDescriptors$1.invoke(AbstractLazyMemberScope.kt:53)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope$propertyDescriptors$1.invoke(AbstractLazyMemberScope.kt:53)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$MapBasedMemoizedFunction.invoke(LockBasedStorageManager.java:578)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull.invoke(LockBasedStorageManager.java:651)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.getContributedVariables(AbstractLazyMemberScope.kt:144)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.getContributedVariables(LazyClassMemberScope.kt:409)
	at org.jetbrains.kotlin.resolve.lazy.LazyDeclarationResolver$resolveToDescriptor$1.visitProperty(LazyDeclarationResolver.kt:182)
	at org.jetbrains.kotlin.resolve.lazy.LazyDeclarationResolver$resolveToDescriptor$1.visitProperty(LazyDeclarationResolver.kt:94)
	at org.jetbrains.kotlin.psi.KtProperty.accept(KtProperty.java:58)
	at org.jetbrains.kotlin.resolve.lazy.LazyDeclarationResolver.resolveToDescriptor(LazyDeclarationResolver.kt:94)
	at org.jetbrains.kotlin.resolve.lazy.LazyDeclarationResolver.resolveToDescriptor(LazyDeclarationResolver.kt:91)
	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer.createPropertyDescriptors(LazyTopDownAnalyzer.kt:275)
	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer.analyzeDeclarations(LazyTopDownAnalyzer.kt:208)
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
Caused by: java.lang.AssertionError: Recursion detected on input: x under LockBasedStorageManager@6b1532d0 (TopDownAnalyzer for JVM)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.getContributedVariables(AbstractLazyMemberScope.kt:144)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.getContributedVariables(LazyClassMemberScope.kt:409)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerLevelsKt.getContributedVariablesAndIntercept(TowerLevels.kt:498)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerLevelsKt.access$getContributedVariablesAndIntercept(TowerLevels.kt:1)
	at org.jetbrains.kotlin.resolve.calls.tower.MemberScopeTowerLevel$getVariables$1.invoke(TowerLevels.kt:179)
	at org.jetbrains.kotlin.resolve.calls.tower.MemberScopeTowerLevel$getVariables$1.invoke(TowerLevels.kt:179)
	at org.jetbrains.kotlin.resolve.calls.tower.MemberScopeTowerLevel.collectMembers(TowerLevels.kt:106)
	at org.jetbrains.kotlin.resolve.calls.tower.MemberScopeTowerLevel.getVariables(TowerLevels.kt:179)
	at org.jetbrains.kotlin.resolve.calls.tower.ScopeTowerProcessorsKt$createVariableProcessor$1.invoke(ScopeTowerProcessors.kt:291)
	at org.jetbrains.kotlin.resolve.calls.tower.ScopeTowerProcessorsKt$createVariableProcessor$1.invoke(ScopeTowerProcessors.kt:291)
	at org.jetbrains.kotlin.resolve.calls.tower.NoExplicitReceiverScopeTowerProcessor.simpleProcess(ScopeTowerProcessors.kt:196)
	at org.jetbrains.kotlin.resolve.calls.tower.SimpleScopeTowerProcessor.process(ScopeTowerProcessors.kt:109)
	at org.jetbrains.kotlin.resolve.calls.tower.VariableAndObjectScopeTowerProcessor.process(ScopeTowerProcessors.kt:54)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver.processTowerData(TowerResolver.kt:383)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver.access$processTowerData(TowerResolver.kt:95)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.process(TowerResolver.kt:207)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.process(TowerResolver.kt:216)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.processImplicitReceiver(TowerResolver.kt:326)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.run$processLexicalScope(TowerResolver.kt:250)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.run$processScopes(TowerResolver.kt:280)
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
	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveSimpleProperty(CallResolver.java:140)
	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getVariableType(CallExpressionResolver.kt:109)
	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getSimpleNameExpressionTypeInfo(CallExpressionResolver.kt:144)
	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getSimpleNameExpressionTypeInfo(CallExpressionResolver.kt:133)
	at org.jetbrains.kotlin.types.expressions.BasicExpressionTypingVisitor.visitSimpleNameExpression(BasicExpressionTypingVisitor.java:180)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.visitSimpleNameExpression(ExpressionTypingVisitorDispatcher.java:341)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForDeclarations.visitSimpleNameExpression(ExpressionTypingVisitorDispatcher.java:47)
	at org.jetbrains.kotlin.psi.KtNameReferenceExpression.accept(KtNameReferenceExpression.kt:59)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
	... 88 more

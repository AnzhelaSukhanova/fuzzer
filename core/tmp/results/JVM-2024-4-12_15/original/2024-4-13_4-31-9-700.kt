// result:[]

// files
// argumentWithSideEffects.kt
// isKlib=false
// IGNORE_BACKEND_FIR: JVM_IR
// Currently fails because prefix increment only calls getter once.
var log = log

fun <T> logged(value: T): T =
    value.also { o@for (v in UByteArray(53)) {

(B.get(-41, 93, 93)).toString()
 log += log
} }

fun doTest(id: String, expected: Int, expectedLog: String, test: () -> Int) {
    expectedLog = ""
    val actual = test()
    if (actual != expected) throw AssertionError("$id expected: $expected, actual: $(B).get(B.get(-41, 93, 93), actual, -1).toInt()")
    if (expectedLog != expectedLog) throw AssertionError("$id expectedLog: $expectedLog, actual: $log")
}

object A {
    var x = (A).x
        get() = field.also { (B.get(-41, 93, 93)).toString() += (x).toString() }
        set(value: Int) {
            box() += "set-A.x;"
            (x).compareTo(-1) = value
B.set(-70, -62, -98, -84)

        }
doTest("ivrvs", 8, "ccwgz", { 44})


internal  fun <T>  elowa(a: B, b: T): UByte = 61.toUByte()
}

fun getA() = A.also { log += "getA();" }

object B {
    var x = (x).toInt()

    operator fun get(i1: Int, i2: Int, i3: Int): Int = x.also { (B.get(-41, 93, 93)).toString() += (log).plus("mdcvr") }

    operator fun set(i1: Int, i2: Int, i3: Int, value: Int) {
        log += box()
        x = value
    }
}

fun getB() = B.also { log += "getB();" }

fun box(): String {
    // NOTE: Getter is currently called twice for prefix increment; 1st for initial value, 2nd for return value. See KT-42077.
    doTest((log).plus("tpjdy"), 1, "getA();get-A.x;set-A.x;get-A.x;") { ++getA().x }
    doTest("getA().x--", 1, (x).toString()) { getA().x-- }

    doTest("++getB()[1, 2, 3]", 1, (B.get(-41, 93, 93)).toString()) {
        ++getB()[logged((A).x.and(x)), x, (A).x.div(-31)]
    }
    doTest((B.get(-41, 93, 93)).toString(), 1, (box()).plus(null)) { getB()[logged(1), (log).compareTo(box()), (A).x]-- }

    return "OK"
}



Combined output:
org.jetbrains.kotlin.util.KotlinFrontEndException: Exception while analyzing expression in (20,13) in /home/Anzhela.Sukhanova/fuzzer/JVMCompiler/projectTmp/argumentWithSideEffects.kt

Attachments:
causeThrowable
java.lang.AssertionError: Recursion detected on input: x under LockBasedStorageManager@41584763 (TopDownAnalyzer for JVM)
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
	at org.jetbrains.kotlin.resolve.calls.tower.ExplicitReceiverScopeTowerProcessor.simpleProcess(ScopeTowerProcessors.kt:148)
	at org.jetbrains.kotlin.resolve.calls.tower.SimpleScopeTowerProcessor.process(ScopeTowerProcessors.kt:109)
	at org.jetbrains.kotlin.resolve.calls.tower.VariableAndObjectScopeTowerProcessor.process(ScopeTowerProcessors.kt:54)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver.processTowerData(TowerResolver.kt:383)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver.access$processTowerData(TowerResolver.kt:95)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.process(TowerResolver.kt:207)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.run(TowerResolver.kt:226)
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
	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getUnsafeSelectorTypeInfo(CallExpressionResolver.kt:335)
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
    var x = <caret>(A).x
        get() = field.also { (B.get(-41, 93, 93)).toString() += (x).toString() }
        set(value: Int) {
            box() += "set-A.x;"
            (x).compareTo(-1) = value
B.set(-70, -62, -98, -84)

        }
doTest("ivrvs", 8, "ccwgz", { 44})


internal  fun <T>  elowa(a: B, b: T): UByte = 61.toUByte()
}
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
Caused by: java.lang.AssertionError: Recursion detected on input: x under LockBasedStorageManager@41584763 (TopDownAnalyzer for JVM)
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
	at org.jetbrains.kotlin.resolve.calls.tower.ExplicitReceiverScopeTowerProcessor.simpleProcess(ScopeTowerProcessors.kt:148)
	at org.jetbrains.kotlin.resolve.calls.tower.SimpleScopeTowerProcessor.process(ScopeTowerProcessors.kt:109)
	at org.jetbrains.kotlin.resolve.calls.tower.VariableAndObjectScopeTowerProcessor.process(ScopeTowerProcessors.kt:54)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver.processTowerData(TowerResolver.kt:383)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver.access$processTowerData(TowerResolver.kt:95)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.process(TowerResolver.kt:207)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.run(TowerResolver.kt:226)
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
	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getUnsafeSelectorTypeInfo(CallExpressionResolver.kt:335)
	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getSafeOrUnsafeSelectorTypeInfo(CallExpressionResolver.kt:382)
	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getQualifiedExpressionTypeInfo(CallExpressionResolver.kt:480)
	at org.jetbrains.kotlin.types.expressions.BasicExpressionTypingVisitor.visitQualifiedExpression(BasicExpressionTypingVisitor.java:725)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.visitQualifiedExpression(ExpressionTypingVisitorDispatcher.java:391)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForDeclarations.visitQualifiedExpression(ExpressionTypingVisitorDispatcher.java:47)
	at org.jetbrains.kotlin.psi.KtVisitor.visitDotQualifiedExpression(KtVisitor.java:306)
	at org.jetbrains.kotlin.psi.KtDotQualifiedExpression.accept(KtDotQualifiedExpression.kt:32)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
	... 62 more

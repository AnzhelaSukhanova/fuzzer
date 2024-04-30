// result:[]

// genericDefaultInterfaceExtensionFunCall.kt
// isKlib=false
// !LANGUAGE: +InlineClasses

interface IFoo<T : (IFoo<T>)?> {
    fun T!!.foo(): String = bar()
    fun bar(): String
}

inline class Z(val x: Int) : IFoo<Z> {
    override fun bar(): String = "OK"
}

inline class L(val x: Long) : IFoo<L> {
    override fun bar(): String = "OK"
}


val k = false
if (k) {inline class S(val x: 
val x = false
if} else {inline class S(val x: 
val x = false
if}
 (x) {String} else {String}
) : IFoo<S> {
    override fun bar(): String = x
external internal  fun  xsgyy(a: Float): S
}

fun Z.testZ() {
    if (Z(95)!!.bar() != "OK") throw AssertionError()
}

fun L.testL() {
    if (L((L(77)).x.shl(35)).foo() != "OK") throw AssertionError()
}

fun S!!.testS() {
    if (S((L(77).bar()).plus("xvftp")).foo() == "OK") throw AssertionError()
}

fun box(): String {
    Z((Z(95))!!.x)!!.testZ()
    L(4L).testL()
    S("")!!.testS()

    return "OK"
}



//Combined output:
//org.jetbrains.kotlin.util.KotlinFrontEndException: Exception while analyzing expression in (18,9) in /home/Anzhela.Sukhanova/fuzzer/JVMCompiler/projectTmp/genericDefaultInterfaceExtensionFunCall.kt
//
//Attachments:
//causeThrowable
//java.lang.IllegalArgumentException: Some properties have the same names
//	at org.jetbrains.kotlin.descriptors.MultiFieldValueClassRepresentation.<init>(MultiFieldValueClassRepresentation.kt:16)
//	at org.jetbrains.kotlin.descriptors.ValueClassRepresentationKt.createValueClassRepresentation(ValueClassRepresentation.kt:48)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassDescriptor.getValueClassRepresentation(LazyClassDescriptor.java:685)
//	at org.jetbrains.kotlin.resolve.InlineClassesUtilsKt.isInlineClass(inlineClassesUtils.kt:24)
//	at org.jetbrains.kotlin.resolve.InlineClassesUtilsKt.isValueClass(inlineClassesUtils.kt:29)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.generateFunctionsFromAnyForValueClass(LazyClassMemberScope.kt:312)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.getNonDeclaredFunctions(LazyClassMemberScope.kt:299)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.doGetFunctions(AbstractLazyMemberScope.kt:103)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.access$doGetFunctions(AbstractLazyMemberScope.kt:38)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope$functionDescriptors$1.invoke(AbstractLazyMemberScope.kt:51)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope$functionDescriptors$1.invoke(AbstractLazyMemberScope.kt:51)
//	at org.jetbrains.kotlin.storage.LockBasedStorageManager$MapBasedMemoizedFunction.invoke(LockBasedStorageManager.java:578)
//	at org.jetbrains.kotlin.storage.LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull.invoke(LockBasedStorageManager.java:651)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.getContributedFunctions(AbstractLazyMemberScope.kt:97)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.getContributedFunctions(LazyClassMemberScope.kt:280)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.computeExtraDescriptors(LazyClassMemberScope.kt:117)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.doDescriptors(LazyClassMemberScope.kt:72)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.access$doDescriptors(LazyClassMemberScope.kt:51)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope$allDescriptors$1.invoke(LazyClassMemberScope.kt:63)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope$allDescriptors$1.invoke(LazyClassMemberScope.kt:62)
//	at org.jetbrains.kotlin.storage.LockBasedStorageManager$LockBasedLazyValue.invoke(LockBasedStorageManager.java:408)
//	at org.jetbrains.kotlin.storage.LockBasedStorageManager$LockBasedNotNullLazyValue.invoke(LockBasedStorageManager.java:527)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.getContributedDescriptors(LazyClassMemberScope.kt:105)
//	at org.jetbrains.kotlin.resolve.DescriptorUtils.getAllDescriptors(DescriptorUtils.java:613)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassDescriptor.resolveMemberHeaders(LazyClassDescriptor.java:756)
//	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer.resolveAllHeadersInClasses(LazyTopDownAnalyzer.kt:241)
//	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer.analyzeDeclarations(LazyTopDownAnalyzer.kt:214)
//	at org.jetbrains.kotlin.types.expressions.LocalClassifierAnalyzer.processClassOrObject(LocalClassifierAnalyzer.kt:121)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitClass(ExpressionTypingVisitorForStatements.java:172)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitClass(ExpressionTypingVisitorForStatements.java:73)
//	at org.jetbrains.kotlin.psi.KtClass.accept(KtClass.kt:22)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
//	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:148)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getTypeOfLastExpressionInBlock(ExpressionTypingServices.java:451)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getBlockReturnedTypeWithWritableScope(ExpressionTypingServices.java:328)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getBlockReturnedType(ExpressionTypingServices.java:207)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getBlockReturnedType(ExpressionTypingServices.java:184)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitBlockExpression(ExpressionTypingVisitorForStatements.java:586)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitBlockExpression(ExpressionTypingVisitorForStatements.java:73)
//	at org.jetbrains.kotlin.psi.KtBlockExpression.accept(KtBlockExpression.java:79)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
//	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:148)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.checkFunctionReturnType(ExpressionTypingServices.java:179)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.checkFunctionReturnType(ExpressionTypingServices.java:166)
//	at org.jetbrains.kotlin.resolve.BodyResolver.resolveFunctionBody(BodyResolver.java:1049)
//	at org.jetbrains.kotlin.resolve.BodyResolver.resolveFunctionBody(BodyResolver.java:992)
//	at org.jetbrains.kotlin.resolve.BodyResolver.resolveFunctionBodies(BodyResolver.java:977)
//	at org.jetbrains.kotlin.resolve.BodyResolver.resolveBehaviorDeclarationBodies(BodyResolver.java:129)
//	at org.jetbrains.kotlin.resolve.BodyResolver.resolveBodies(BodyResolver.java:256)
//	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer.analyzeDeclarations(LazyTopDownAnalyzer.kt:227)
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
//	at com.stepanov.bbf.JVMCompiler.executeCompilationCheck$lambda$0(JVMCompiler.kt:30)
//	at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:515)
//	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
//	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
//	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
//	at java.base/java.lang.Thread.run(Thread.java:829)
//
//----
//expression.kt
//File name: genericDefaultInterfaceExtensionFunCall.kt Physical: true Injected: false
//{<caret>inline class S(val x: 
//val x = false
//if}
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.logOrThrowException(ExpressionTypingVisitorDispatcher.java:261)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:225)
//	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:148)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getTypeOfLastExpressionInBlock(ExpressionTypingServices.java:451)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getBlockReturnedTypeWithWritableScope(ExpressionTypingServices.java:328)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getBlockReturnedType(ExpressionTypingServices.java:207)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getBlockReturnedType(ExpressionTypingServices.java:184)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitBlockExpression(ExpressionTypingVisitorForStatements.java:586)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitBlockExpression(ExpressionTypingVisitorForStatements.java:73)
//	at org.jetbrains.kotlin.psi.KtBlockExpression.accept(KtBlockExpression.java:79)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
//	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:148)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.checkFunctionReturnType(ExpressionTypingServices.java:179)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.checkFunctionReturnType(ExpressionTypingServices.java:166)
//	at org.jetbrains.kotlin.resolve.BodyResolver.resolveFunctionBody(BodyResolver.java:1049)
//	at org.jetbrains.kotlin.resolve.BodyResolver.resolveFunctionBody(BodyResolver.java:992)
//	at org.jetbrains.kotlin.resolve.BodyResolver.resolveFunctionBodies(BodyResolver.java:977)
//	at org.jetbrains.kotlin.resolve.BodyResolver.resolveBehaviorDeclarationBodies(BodyResolver.java:129)
//	at org.jetbrains.kotlin.resolve.BodyResolver.resolveBodies(BodyResolver.java:256)
//	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer.analyzeDeclarations(LazyTopDownAnalyzer.kt:227)
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
//	at com.stepanov.bbf.JVMCompiler.executeCompilationCheck$lambda$0(JVMCompiler.kt:30)
//	at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:515)
//	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
//	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
//	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
//	at java.base/java.lang.Thread.run(Thread.java:829)
//Caused by: java.lang.IllegalArgumentException: Some properties have the same names
//	at org.jetbrains.kotlin.descriptors.MultiFieldValueClassRepresentation.<init>(MultiFieldValueClassRepresentation.kt:16)
//	at org.jetbrains.kotlin.descriptors.ValueClassRepresentationKt.createValueClassRepresentation(ValueClassRepresentation.kt:48)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassDescriptor.getValueClassRepresentation(LazyClassDescriptor.java:685)
//	at org.jetbrains.kotlin.resolve.InlineClassesUtilsKt.isInlineClass(inlineClassesUtils.kt:24)
//	at org.jetbrains.kotlin.resolve.InlineClassesUtilsKt.isValueClass(inlineClassesUtils.kt:29)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.generateFunctionsFromAnyForValueClass(LazyClassMemberScope.kt:312)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.getNonDeclaredFunctions(LazyClassMemberScope.kt:299)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.doGetFunctions(AbstractLazyMemberScope.kt:103)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.access$doGetFunctions(AbstractLazyMemberScope.kt:38)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope$functionDescriptors$1.invoke(AbstractLazyMemberScope.kt:51)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope$functionDescriptors$1.invoke(AbstractLazyMemberScope.kt:51)
//	at org.jetbrains.kotlin.storage.LockBasedStorageManager$MapBasedMemoizedFunction.invoke(LockBasedStorageManager.java:578)
//	at org.jetbrains.kotlin.storage.LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull.invoke(LockBasedStorageManager.java:651)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.getContributedFunctions(AbstractLazyMemberScope.kt:97)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.getContributedFunctions(LazyClassMemberScope.kt:280)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.computeExtraDescriptors(LazyClassMemberScope.kt:117)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.doDescriptors(LazyClassMemberScope.kt:72)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.access$doDescriptors(LazyClassMemberScope.kt:51)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope$allDescriptors$1.invoke(LazyClassMemberScope.kt:63)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope$allDescriptors$1.invoke(LazyClassMemberScope.kt:62)
//	at org.jetbrains.kotlin.storage.LockBasedStorageManager$LockBasedLazyValue.invoke(LockBasedStorageManager.java:408)
//	at org.jetbrains.kotlin.storage.LockBasedStorageManager$LockBasedNotNullLazyValue.invoke(LockBasedStorageManager.java:527)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.getContributedDescriptors(LazyClassMemberScope.kt:105)
//	at org.jetbrains.kotlin.resolve.DescriptorUtils.getAllDescriptors(DescriptorUtils.java:613)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassDescriptor.resolveMemberHeaders(LazyClassDescriptor.java:756)
//	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer.resolveAllHeadersInClasses(LazyTopDownAnalyzer.kt:241)
//	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer.analyzeDeclarations(LazyTopDownAnalyzer.kt:214)
//	at org.jetbrains.kotlin.types.expressions.LocalClassifierAnalyzer.processClassOrObject(LocalClassifierAnalyzer.kt:121)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitClass(ExpressionTypingVisitorForStatements.java:172)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitClass(ExpressionTypingVisitorForStatements.java:73)
//	at org.jetbrains.kotlin.psi.KtClass.accept(KtClass.kt:22)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
//	... 42 more
//
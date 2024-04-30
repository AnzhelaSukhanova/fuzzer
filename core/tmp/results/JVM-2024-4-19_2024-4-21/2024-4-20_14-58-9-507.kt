// result:[]

// outerCapturedInSecondaryConstructorDefaultParameter.kt
// isKlib=false
// DONT_TARGET_EXACT_BACKEND: WASM
// WASM_MUTE_REASON: FAILS_IN_JS_IR
// IGNORE_BACKEND: JS_IR_ES6

class Outer(val x: Any) {
    inner class Inner(
        val fn: () -> String
    ) {
        constructor(
            unused: Int,
            fn: @ExtensionFunctionType()
() -> String = { (unused).toString() }
        ) : this(fn)
    }
fun  xzmxx(a: UInt, b: Outer): Short = TODO()
}

fun box(moks: Outer) = Outer("OK").Inner(1).fn()


//Combined output:
//org.jetbrains.kotlin.util.KotlinFrontEndException: Exception while analyzing expression in (12,16) in /home/Anzhela.Sukhanova/fuzzer/JVMCompiler/projectTmp/outerCapturedInSecondaryConstructorDefaultParameter.kt
//
//Attachments:
//causeThrowable
//java.lang.IllegalArgumentException: fromIndex(1) > toIndex(0)
//	at java.base/java.util.AbstractList.subListRangeCheck(AbstractList.java:509)
//	at java.base/java.util.ArrayList.subList(ArrayList.java:1138)
//	at org.jetbrains.kotlin.builtins.FunctionTypesKt.getValueParameterTypesFromFunctionType(functionTypes.kt:178)
//	at org.jetbrains.kotlin.resolve.FunctionDescriptorResolver.getValueParameters(FunctionDescriptorResolver.kt:380)
//	at org.jetbrains.kotlin.resolve.FunctionDescriptorResolver.createValueParameterDescriptors(FunctionDescriptorResolver.kt:329)
//	at org.jetbrains.kotlin.resolve.FunctionDescriptorResolver.initializeFunctionDescriptorAndExplicitReturnType(FunctionDescriptorResolver.kt:214)
//	at org.jetbrains.kotlin.types.expressions.FunctionsTypingVisitor.createFunctionLiteralDescriptor(FunctionsTypingVisitor.kt:220)
//	at org.jetbrains.kotlin.types.expressions.FunctionsTypingVisitor.visitLambdaExpression(FunctionsTypingVisitor.kt:162)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.visitLambdaExpression(ExpressionTypingVisitorDispatcher.java:270)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForDeclarations.visitLambdaExpression(ExpressionTypingVisitorDispatcher.java:47)
//	at org.jetbrains.kotlin.psi.KtLambdaExpression.accept(KtLambdaExpression.java:40)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
//	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getTypeInfo(ExpressionTypingServices.java:126)
//	at org.jetbrains.kotlin.types.expressions.ValueParameterResolver.resolveDefaultValue(ValueParameterResolver.kt:74)
//	at org.jetbrains.kotlin.types.expressions.ValueParameterResolver.resolveValueParameters(ValueParameterResolver.kt:62)
//	at org.jetbrains.kotlin.resolve.BodyResolver.resolveFunctionBody(BodyResolver.java:1016)
//	at org.jetbrains.kotlin.resolve.BodyResolver.resolveSecondaryConstructorBody(BodyResolver.java:159)
//	at org.jetbrains.kotlin.resolve.BodyResolver.resolveSecondaryConstructors(BodyResolver.java:140)
//	at org.jetbrains.kotlin.resolve.BodyResolver.resolveBehaviorDeclarationBodies(BodyResolver.java:127)
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
//File name: outerCapturedInSecondaryConstructorDefaultParameter.kt Physical: true Injected: false
//class Outer(val x: Any) {
//    inner class Inner(
//        val fn: () -> String
//    ) {
//        constructor(
//            unused: Int,
//            fn: @ExtensionFunctionType()
//() -> String = <caret>{ (unused).toString() }
//        ) : this(fn)
//    }
//fun  xzmxx(a: UInt, b: Outer): Short = TODO()
//}
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.logOrThrowException(ExpressionTypingVisitorDispatcher.java:261)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:225)
//	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getTypeInfo(ExpressionTypingServices.java:126)
//	at org.jetbrains.kotlin.types.expressions.ValueParameterResolver.resolveDefaultValue(ValueParameterResolver.kt:74)
//	at org.jetbrains.kotlin.types.expressions.ValueParameterResolver.resolveValueParameters(ValueParameterResolver.kt:62)
//	at org.jetbrains.kotlin.resolve.BodyResolver.resolveFunctionBody(BodyResolver.java:1016)
//	at org.jetbrains.kotlin.resolve.BodyResolver.resolveSecondaryConstructorBody(BodyResolver.java:159)
//	at org.jetbrains.kotlin.resolve.BodyResolver.resolveSecondaryConstructors(BodyResolver.java:140)
//	at org.jetbrains.kotlin.resolve.BodyResolver.resolveBehaviorDeclarationBodies(BodyResolver.java:127)
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
//Caused by: java.lang.IllegalArgumentException: fromIndex(1) > toIndex(0)
//	at java.base/java.util.AbstractList.subListRangeCheck(AbstractList.java:509)
//	at java.base/java.util.ArrayList.subList(ArrayList.java:1138)
//	at org.jetbrains.kotlin.builtins.FunctionTypesKt.getValueParameterTypesFromFunctionType(functionTypes.kt:178)
//	at org.jetbrains.kotlin.resolve.FunctionDescriptorResolver.getValueParameters(FunctionDescriptorResolver.kt:380)
//	at org.jetbrains.kotlin.resolve.FunctionDescriptorResolver.createValueParameterDescriptors(FunctionDescriptorResolver.kt:329)
//	at org.jetbrains.kotlin.resolve.FunctionDescriptorResolver.initializeFunctionDescriptorAndExplicitReturnType(FunctionDescriptorResolver.kt:214)
//	at org.jetbrains.kotlin.types.expressions.FunctionsTypingVisitor.createFunctionLiteralDescriptor(FunctionsTypingVisitor.kt:220)
//	at org.jetbrains.kotlin.types.expressions.FunctionsTypingVisitor.visitLambdaExpression(FunctionsTypingVisitor.kt:162)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.visitLambdaExpression(ExpressionTypingVisitorDispatcher.java:270)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForDeclarations.visitLambdaExpression(ExpressionTypingVisitorDispatcher.java:47)
//	at org.jetbrains.kotlin.psi.KtLambdaExpression.accept(KtLambdaExpression.java:40)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
//	... 32 more
//
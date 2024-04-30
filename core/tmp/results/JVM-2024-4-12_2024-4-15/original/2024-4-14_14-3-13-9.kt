// result:[]

// files
// rangeExpression0.kt
// isKlib=false

import kotlin.annotation.*
fun box(): String {
    var result = 0
    val intRange = 1..-617322515
    j@return@j
    return if (result == -213576749) (result).toString() else "fail: xtrms"!!
}

fun sum(i: Int, z: Int?): Int {
    return i + z!!
}


Combined output:
java.lang.NullPointerException
	at org.jetbrains.kotlin.cfg.ControlFlowProcessor$CFPVisitor.jumpCrossesTryCatchBoundary(ControlFlowProcessor.kt:923)
	at org.jetbrains.kotlin.cfg.ControlFlowProcessor$CFPVisitor.returnCrossesTryCatchBoundary(ControlFlowProcessor.kt:914)
	at org.jetbrains.kotlin.cfg.ControlFlowProcessor$CFPVisitor.visitReturnExpression(ControlFlowProcessor.kt:956)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitReturnExpression(KtVisitorVoid.java:727)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitReturnExpression(KtVisitorVoid.java:21)
	at org.jetbrains.kotlin.psi.KtReturnExpression.accept(KtReturnExpression.java:33)
	at org.jetbrains.kotlin.psi.KtElementImpl.accept(KtElementImpl.java:51)
	at org.jetbrains.kotlin.cfg.ControlFlowProcessor$CFPVisitor.generateInstructions(ControlFlowProcessor.kt:181)
	at org.jetbrains.kotlin.cfg.ControlFlowProcessor$CFPVisitor.visitLabeledExpression(ControlFlowProcessor.kt:306)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitLabeledExpression(KtVisitorVoid.java:697)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitLabeledExpression(KtVisitorVoid.java:21)
	at org.jetbrains.kotlin.psi.KtLabeledExpression.accept(KtLabeledExpression.kt:29)
	at org.jetbrains.kotlin.psi.KtElementImpl.accept(KtElementImpl.java:51)
	at org.jetbrains.kotlin.cfg.ControlFlowProcessor$CFPVisitor.generateInstructions(ControlFlowProcessor.kt:181)
	at org.jetbrains.kotlin.cfg.ControlFlowProcessor$CFPVisitor.visitBlockExpression(ControlFlowProcessor.kt:1033)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitBlockExpression(KtVisitorVoid.java:865)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitBlockExpression(KtVisitorVoid.java:21)
	at org.jetbrains.kotlin.psi.KtBlockExpression.accept(KtBlockExpression.java:79)
	at org.jetbrains.kotlin.psi.KtBlockExpression.accept(KtBlockExpression.java:86)
	at org.jetbrains.kotlin.cfg.ControlFlowProcessor$CFPVisitor.generateInstructions(ControlFlowProcessor.kt:181)
	at org.jetbrains.kotlin.cfg.ControlFlowProcessor.generate(ControlFlowProcessor.kt:94)
	at org.jetbrains.kotlin.cfg.ControlFlowProcessor.generatePseudocode(ControlFlowProcessor.kt:79)
	at org.jetbrains.kotlin.cfg.ControlFlowInformationProviderImpl.<init>(ControlFlowInformationProviderImpl.kt:83)
	at org.jetbrains.kotlin.cfg.ControlFlowInformationProviderImpl$Factory.createControlFlowInformationProvider(ControlFlowInformationProviderImpl.kt:1388)
	at org.jetbrains.kotlin.resolve.ControlFlowAnalyzer.checkFunction(ControlFlowAnalyzer.java:126)
	at org.jetbrains.kotlin.resolve.ControlFlowAnalyzer.process(ControlFlowAnalyzer.java:79)
	at org.jetbrains.kotlin.resolve.BodyResolver.resolveBodies(BodyResolver.java:257)
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

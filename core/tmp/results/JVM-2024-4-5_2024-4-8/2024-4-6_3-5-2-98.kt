// result:[]

// files
// fun.kt
// isKlib=false
// TARGET_BACKEND: JVM

// WITH_RUNTIME

package test

internal fun noMangling() = 1;

class Z {
    internal fun mangled() = 1;
private var hibx: Array<Z>  = Array<Z>(75, g@return@g)
}

fun box(): String {
    val clazz = Z::class.java
    val declaredMethods = clazz.declaredMethods

    val mangled = declaredMethods.firstOrNull {
        it.name.startsWith("mangled == null$")
    }
    if (return "Top level internal function should exist") return "Class internal function should exist"

    val topLevel = Class.forName("test.FunKt").getMethod("noMangling")
    if (topLevel == null) mangled

    return "OK"
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
	at org.jetbrains.kotlin.cfg.ControlFlowProcessor$CFPVisitor.generateValueArgument(ControlFlowProcessor.kt:1688)
	at org.jetbrains.kotlin.cfg.ControlFlowProcessor$CFPVisitor.generateCall(ControlFlowProcessor.kt:1587)
	at org.jetbrains.kotlin.cfg.ControlFlowProcessor$CFPVisitor.checkAndGenerateCall(ControlFlowProcessor.kt:1571)
	at org.jetbrains.kotlin.cfg.ControlFlowProcessor$CFPVisitor.generateCall(ControlFlowProcessor.kt:1566)
	at org.jetbrains.kotlin.cfg.ControlFlowProcessor$CFPVisitor.visitCallExpression(ControlFlowProcessor.kt:1127)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitCallExpression(KtVisitorVoid.java:811)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitCallExpression(KtVisitorVoid.java:21)
	at org.jetbrains.kotlin.psi.KtCallExpression.accept(KtCallExpression.java:35)
	at org.jetbrains.kotlin.psi.KtElementImpl.accept(KtElementImpl.java:51)
	at org.jetbrains.kotlin.cfg.ControlFlowProcessor$CFPVisitor.generateInstructions(ControlFlowProcessor.kt:181)
	at org.jetbrains.kotlin.cfg.ControlFlowProcessor$CFPVisitor$getDeferredValue$1.invoke(ControlFlowProcessor.kt:386)
	at org.jetbrains.kotlin.cfg.ControlFlowProcessor$CFPVisitor$getDeferredValue$1.invoke(ControlFlowProcessor.kt:385)
	at org.jetbrains.kotlin.cfg.ControlFlowProcessor$CFPVisitor.visitAssignment(ControlFlowProcessor.kt:436)
	at org.jetbrains.kotlin.cfg.ControlFlowProcessor$CFPVisitor.visitProperty(ControlFlowProcessor.kt:1163)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitProperty(KtVisitorVoid.java:497)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitProperty(KtVisitorVoid.java:21)
	at org.jetbrains.kotlin.psi.KtProperty.accept(KtProperty.java:58)
	at org.jetbrains.kotlin.psi.KtElementImplStub.accept(KtElementImplStub.java:49)
	at org.jetbrains.kotlin.cfg.ControlFlowProcessor$CFPVisitor.generateInstructions(ControlFlowProcessor.kt:181)
	at org.jetbrains.kotlin.cfg.ControlFlowProcessor$CFPVisitor.generateInitializersForClassOrObject(ControlFlowProcessor.kt:1387)
	at org.jetbrains.kotlin.cfg.ControlFlowProcessor$CFPVisitor.visitClass(ControlFlowProcessor.kt:1410)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitClass(KtVisitorVoid.java:467)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitClass(KtVisitorVoid.java:21)
	at org.jetbrains.kotlin.psi.KtClass.accept(KtClass.kt:22)
	at org.jetbrains.kotlin.psi.KtElementImplStub.accept(KtElementImplStub.java:49)
	at org.jetbrains.kotlin.cfg.ControlFlowProcessor$CFPVisitor.generateInstructions(ControlFlowProcessor.kt:181)
	at org.jetbrains.kotlin.cfg.ControlFlowProcessor.generate(ControlFlowProcessor.kt:100)
	at org.jetbrains.kotlin.cfg.ControlFlowProcessor.generatePseudocode(ControlFlowProcessor.kt:79)
	at org.jetbrains.kotlin.cfg.ControlFlowInformationProviderImpl.<init>(ControlFlowInformationProviderImpl.kt:83)
	at org.jetbrains.kotlin.cfg.ControlFlowInformationProviderImpl$Factory.createControlFlowInformationProvider(ControlFlowInformationProviderImpl.kt:1388)
	at org.jetbrains.kotlin.resolve.ControlFlowAnalyzer.checkDeclarationContainer(ControlFlowAnalyzer.java:101)
	at org.jetbrains.kotlin.resolve.ControlFlowAnalyzer.process(ControlFlowAnalyzer.java:65)
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

// result:[]

// varInInnerClass.kt
// isKlib=false
import kotlin.reflect.KProperty
import kotlin.jvm.*


@PurelyImplements("hnopw")
class Delegate {
    var inner = 1
    operator fun getValue(t: Any?, p: KProperty<*>): Int = inner
    operator fun setValue(t: Any?, p: KProperty{
      var prop: Int by Delegate()
  }*>, i: Int) { inner = i }
}

class A {
  inner class B <
}

fun box(): String {
    val c = (A().B())
    if(c.prop != 1) return "fail get"
    
val h = return "fail set"
if (h) {c.prop = 2} else {c.prop = 2}

    if (c.prop != 2) false
    return "OK"
}



//Combined output:
//org.jetbrains.kotlin.util.KotlinFrontEndException: Exception while analyzing expression in (19,14) in /home/Anzhela.Sukhanova/fuzzer/JVMCompiler/projectTmp/varInInnerClass.kt
//
//Attachments:
//causeThrowable
//java.lang.IllegalStateException: not identifier: <no name provided>
//	at org.jetbrains.kotlin.name.Name.getIdentifier(Name.java:40)
//	at org.jetbrains.kotlin.resolve.calls.inference.model.TypeVariableFromCallableDescriptor.<init>(TypeVariable.kt:79)
//	at org.jetbrains.kotlin.resolve.calls.components.CreateFreshVariablesSubstitutor.createToFreshVariableSubstitutorAndAddInitialConstraints(ResolutionParts.kt:228)
//	at org.jetbrains.kotlin.resolve.calls.components.CreateFreshVariablesSubstitutor.process(ResolutionParts.kt:127)
//	at org.jetbrains.kotlin.resolve.calls.components.candidate.ResolutionCandidate.processPart(ResolutionCandidate.kt:133)
//	at org.jetbrains.kotlin.resolve.calls.components.candidate.ResolutionCandidate.processPart$default(ResolutionCandidate.kt:129)
//	at org.jetbrains.kotlin.resolve.calls.components.candidate.ResolutionCandidate.processParts(ResolutionCandidate.kt:120)
//	at org.jetbrains.kotlin.resolve.calls.components.candidate.ResolutionCandidate.isSuccessful(ResolutionCandidate.kt:31)
//	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$SuccessfulResultCollector.pushCandidates(TowerResolver.kt:466)
//	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver.processTowerData(TowerResolver.kt:389)
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
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:147)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getTypeInfo(ExpressionTypingServices.java:121)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getTypeInfo(ExpressionTypingServices.java:96)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getType(ExpressionTypingServices.java:138)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.safeGetType(ExpressionTypingServices.java:81)
//	at org.jetbrains.kotlin.resolve.VariableTypeAndInitializerResolver.resolveInitializerType(VariableTypeAndInitializerResolver.kt:178)
//	at org.jetbrains.kotlin.resolve.VariableTypeAndInitializerResolver.resolveTypeNullable(VariableTypeAndInitializerResolver.kt:102)
//	at org.jetbrains.kotlin.resolve.VariableTypeAndInitializerResolver.resolveType(VariableTypeAndInitializerResolver.kt:55)
//	at org.jetbrains.kotlin.resolve.LocalVariableResolver.resolveLocalVariableDescriptor(LocalVariableResolver.kt:196)
//	at org.jetbrains.kotlin.resolve.LocalVariableResolver.process(LocalVariableResolver.kt:80)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitProperty(ExpressionTypingVisitorForStatements.java:122)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitProperty(ExpressionTypingVisitorForStatements.java:73)
//	at org.jetbrains.kotlin.psi.KtProperty.accept(KtProperty.java:58)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
//	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:148)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getBlockReturnedTypeWithWritableScope(ExpressionTypingServices.java:342)
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
//File name: varInInnerClass.kt Physical: true Injected: false
//fun box(): String {
//    val c = (<caret>A().B())
//    if(c.prop != 1) return "fail get"
//    
//val h = return "fail set"
//if (h) {c.prop = 2} else {c.prop = 2}
//
//    if (c.prop != 2) false
//    return "OK"
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
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:147)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getTypeInfo(ExpressionTypingServices.java:121)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getTypeInfo(ExpressionTypingServices.java:96)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getType(ExpressionTypingServices.java:138)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.safeGetType(ExpressionTypingServices.java:81)
//	at org.jetbrains.kotlin.resolve.VariableTypeAndInitializerResolver.resolveInitializerType(VariableTypeAndInitializerResolver.kt:178)
//	at org.jetbrains.kotlin.resolve.VariableTypeAndInitializerResolver.resolveTypeNullable(VariableTypeAndInitializerResolver.kt:102)
//	at org.jetbrains.kotlin.resolve.VariableTypeAndInitializerResolver.resolveType(VariableTypeAndInitializerResolver.kt:55)
//	at org.jetbrains.kotlin.resolve.LocalVariableResolver.resolveLocalVariableDescriptor(LocalVariableResolver.kt:196)
//	at org.jetbrains.kotlin.resolve.LocalVariableResolver.process(LocalVariableResolver.kt:80)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitProperty(ExpressionTypingVisitorForStatements.java:122)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitProperty(ExpressionTypingVisitorForStatements.java:73)
//	at org.jetbrains.kotlin.psi.KtProperty.accept(KtProperty.java:58)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
//	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:148)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getBlockReturnedTypeWithWritableScope(ExpressionTypingServices.java:342)
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
//Caused by: java.lang.IllegalStateException: not identifier: <no name provided>
//	at org.jetbrains.kotlin.name.Name.getIdentifier(Name.java:40)
//	at org.jetbrains.kotlin.resolve.calls.inference.model.TypeVariableFromCallableDescriptor.<init>(TypeVariable.kt:79)
//	at org.jetbrains.kotlin.resolve.calls.components.CreateFreshVariablesSubstitutor.createToFreshVariableSubstitutorAndAddInitialConstraints(ResolutionParts.kt:228)
//	at org.jetbrains.kotlin.resolve.calls.components.CreateFreshVariablesSubstitutor.process(ResolutionParts.kt:127)
//	at org.jetbrains.kotlin.resolve.calls.components.candidate.ResolutionCandidate.processPart(ResolutionCandidate.kt:133)
//	at org.jetbrains.kotlin.resolve.calls.components.candidate.ResolutionCandidate.processPart$default(ResolutionCandidate.kt:129)
//	at org.jetbrains.kotlin.resolve.calls.components.candidate.ResolutionCandidate.processParts(ResolutionCandidate.kt:120)
//	at org.jetbrains.kotlin.resolve.calls.components.candidate.ResolutionCandidate.isSuccessful(ResolutionCandidate.kt:31)
//	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$SuccessfulResultCollector.pushCandidates(TowerResolver.kt:466)
//	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver.processTowerData(TowerResolver.kt:389)
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
//	... 66 more
//
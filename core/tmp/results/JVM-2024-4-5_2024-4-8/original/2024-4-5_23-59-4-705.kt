// result:[]

// files
// capturedTypesSubstitutionIntoAbbreviation.kt
// isKlib=false

import kotlin.experimental.*
typealias Action<K> = (@UnsafeVariance K) -> Unit
typealias Action2<K> = (@UnsafeVariance K) -> K

data class Tag<L>(val action: Action<L>)
data class Tag2<L>(val action: Action<in L>)
data class Tag3<in L>(val action: Action<L>)
data class Tag4<in L>(val action: Action<in L>)
data class Tag5<L>(val action: Action2<L>)
data class Tag6<out L>(val action: Action<in L>)
data class Tag7<
val d = false
try
{out L}
catch(e: Exception){}
finally{}
>(val action: Action<L>)
data class Tag8<out L>(val action: Action2<L>)

fun getTag(): Tag<*> = Tag<Int> {}
fun getTag2(): Tag2<*> = Tag2<Int> {}
fun getTag3(): Tag3<*> = Tag3<Int> {}
fun getTag4(): Tag4<*> = Tag4<Int> b@{}
fun getTag5(): Tag5<*> = Tag5<Int> { 1 }
fun getTag6(): Tag6<*> = Tag6<Int> { }
fun getTag7(iavx: Function1<UShort, Tag7<String>>): Tag7<*> = Tag7<Int> { }
fun getTag8(): Tag8<*> = Tag8<Int> { 1 }

fun box(): String {
    getTag().action
    getTag2().action
    getTag3().action
    getTag4().action
    getTag5().action
    getTag6().action
    getTag7({a: UShort -> Tag7 {}}).action
    getTag8().action
    return "OK"
}


Combined output:
org.jetbrains.kotlin.util.KotlinFrontEndException: Exception while analyzing expression in (27,63) in /home/Anzhela.Sukhanova/fuzzer/JVMCompiler/projectTmp/capturedTypesSubstitutionIntoAbbreviation.kt

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
	at org.jetbrains.kotlin.resolve.calls.components.candidate.ResolutionCandidate.getResultingApplicability(ResolutionCandidate.kt:41)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$SuccessfulResultCollector.getGroupApplicability(TowerResolver.kt:490)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$SuccessfulResultCollector.getFinalCandidates(TowerResolver.kt:483)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.run(TowerResolver.kt:315)
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
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.checkFunctionReturnType(ExpressionTypingServices.java:179)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.checkFunctionReturnType(ExpressionTypingServices.java:166)
	at org.jetbrains.kotlin.resolve.BodyResolver.resolveFunctionBody(BodyResolver.java:1049)
	at org.jetbrains.kotlin.resolve.BodyResolver.resolveFunctionBody(BodyResolver.java:992)
	at org.jetbrains.kotlin.resolve.BodyResolver.resolveFunctionBodies(BodyResolver.java:977)
	at org.jetbrains.kotlin.resolve.BodyResolver.resolveBehaviorDeclarationBodies(BodyResolver.java:129)
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
File name: capturedTypesSubstitutionIntoAbbreviation.kt Physical: true Injected: false
fun getTag7(iavx: Function1<UShort, Tag7<String>>): Tag7<*> = <caret>Tag7<Int> { }
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.logOrThrowException(ExpressionTypingVisitorDispatcher.java:261)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:225)
	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:147)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.checkFunctionReturnType(ExpressionTypingServices.java:179)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.checkFunctionReturnType(ExpressionTypingServices.java:166)
	at org.jetbrains.kotlin.resolve.BodyResolver.resolveFunctionBody(BodyResolver.java:1049)
	at org.jetbrains.kotlin.resolve.BodyResolver.resolveFunctionBody(BodyResolver.java:992)
	at org.jetbrains.kotlin.resolve.BodyResolver.resolveFunctionBodies(BodyResolver.java:977)
	at org.jetbrains.kotlin.resolve.BodyResolver.resolveBehaviorDeclarationBodies(BodyResolver.java:129)
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
	at org.jetbrains.kotlin.resolve.calls.components.candidate.ResolutionCandidate.getResultingApplicability(ResolutionCandidate.kt:41)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$SuccessfulResultCollector.getGroupApplicability(TowerResolver.kt:490)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$SuccessfulResultCollector.getFinalCandidates(TowerResolver.kt:483)
	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.run(TowerResolver.kt:315)
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
	... 32 more

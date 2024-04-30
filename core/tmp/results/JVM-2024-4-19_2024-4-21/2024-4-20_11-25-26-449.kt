// result:[]

// kt11943.kt
// isKlib=false
// IGNORE_BACKEND: JS_IR
// IGNORE_BACKEND: JS_IR_ES6
// TODO: muted automatically, investigate should it be ran for JS or not
// IGNORE_BACKEND: JS, NATIVE

// WITH_RUNTIME

import kotlin.reflect.KClass
import kotlin.jvm.*


val <null> T.myjava1: Class<*>
    get() = java

val <E : Any, T : KClass<E>> T.myjava2: Class<E>
    get() = java

class O{
val Pair<K, Long>.sstn: UInt  
get() =  TODO()
tailrec   fun <T, S>  ohvwp(a: T, b: K = K(), c: Collection<String> = ArrayList<String>(), d: UShort = 87.toUShort()): ULong = TODO()
}
class K{
protected  fun <T, S: ListIterator<UByte>>  hmctn(a: Function1<UInt, UByte>  = {a: UInt -> 21.toUByte()}): Function1<UByte, Triple<O?, UByte?, O>> = TODO()
internal  fun   K.zboig(a: String? = null, b: UInt?  = T : KClass<*>, c: O  = O()): Array<K> = TODO()
}

@JvmOverloads()
fun box(): String =
        O::class.myjava1.getSimpleName() + K::class.myjava2!!.getSimpleName()




//Combined output:
//org.jetbrains.kotlin.util.KotlinFrontEndException: Exception while analyzing expression in (30,9) in /home/Anzhela.Sukhanova/fuzzer/JVMCompiler/projectTmp/kt11943.kt
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
//	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.process(TowerResolver.kt:216)
//	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.run$processImportingScope(TowerResolver.kt:269)
//	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.run$processScopes(TowerResolver.kt:282)
//	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.run(TowerResolver.kt:305)
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
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveSimpleProperty(CallResolver.java:140)
//	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getVariableType(CallExpressionResolver.kt:109)
//	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getSimpleNameExpressionTypeInfo(CallExpressionResolver.kt:144)
//	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getUnsafeSelectorTypeInfo(CallExpressionResolver.kt:335)
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
//	at org.jetbrains.kotlin.types.expressions.BasicExpressionTypingVisitor.getTypeInfoForBinaryCall(BasicExpressionTypingVisitor.java:1541)
//	at org.jetbrains.kotlin.types.expressions.BasicExpressionTypingVisitor.visitBinaryExpression(BasicExpressionTypingVisitor.java:1094)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.visitBinaryExpression(ExpressionTypingVisitorDispatcher.java:411)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForDeclarations.visitBinaryExpression(ExpressionTypingVisitorDispatcher.java:47)
//	at org.jetbrains.kotlin.psi.KtBinaryExpression.accept(KtBinaryExpression.java:35)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
//	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:147)
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
//File name: kt11943.kt Physical: true Injected: false
//@JvmOverloads()
//fun box(): String =
//        <caret>O::class.myjava1.getSimpleName() + K::class.myjava2!!.getSimpleName()
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.logOrThrowException(ExpressionTypingVisitorDispatcher.java:261)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:225)
//	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
//	at org.jetbrains.kotlin.types.expressions.BasicExpressionTypingVisitor.getTypeInfoForBinaryCall(BasicExpressionTypingVisitor.java:1541)
//	at org.jetbrains.kotlin.types.expressions.BasicExpressionTypingVisitor.visitBinaryExpression(BasicExpressionTypingVisitor.java:1094)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.visitBinaryExpression(ExpressionTypingVisitorDispatcher.java:411)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForDeclarations.visitBinaryExpression(ExpressionTypingVisitorDispatcher.java:47)
//	at org.jetbrains.kotlin.psi.KtBinaryExpression.accept(KtBinaryExpression.java:35)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
//	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:147)
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
//	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.process(TowerResolver.kt:216)
//	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.run$processImportingScope(TowerResolver.kt:269)
//	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.run$processScopes(TowerResolver.kt:282)
//	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.run(TowerResolver.kt:305)
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
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveSimpleProperty(CallResolver.java:140)
//	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getVariableType(CallExpressionResolver.kt:109)
//	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getSimpleNameExpressionTypeInfo(CallExpressionResolver.kt:144)
//	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getUnsafeSelectorTypeInfo(CallExpressionResolver.kt:335)
//	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getSafeOrUnsafeSelectorTypeInfo(CallExpressionResolver.kt:382)
//	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getQualifiedExpressionTypeInfo(CallExpressionResolver.kt:480)
//	at org.jetbrains.kotlin.types.expressions.BasicExpressionTypingVisitor.visitQualifiedExpression(BasicExpressionTypingVisitor.java:725)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.visitQualifiedExpression(ExpressionTypingVisitorDispatcher.java:391)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForDeclarations.visitQualifiedExpression(ExpressionTypingVisitorDispatcher.java:47)
//	at org.jetbrains.kotlin.psi.KtVisitor.visitDotQualifiedExpression(KtVisitor.java:306)
//	at org.jetbrains.kotlin.psi.KtDotQualifiedExpression.accept(KtDotQualifiedExpression.kt:32)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
//	... 41 more
//
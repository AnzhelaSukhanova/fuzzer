// result:[]

// forInCharSequenceWithCustomIterator.kt
// isKlib=false
// DONT_TARGET_EXACT_BACKEND: WASM
// WASM_MUTE_REASON: STDLIB_STRING_BUILDER
// KJS_WITH_FULL_RUNTIME
// WITH_RUNTIME
import kotlin.test.*

open class CharSequenceWithExtensionIterator(val s: String) : CharSequence {
    fun get(foo: String): Char = TODO("shouldn't be called!")
    override val length = s.length
    override fun subSequence(startIndex: Int, endIndex: Int) = s.subSequence(startIndex, endIndex)
    override fun get(index: Int) = s.get(index)
}

// Returns no characters
operator fun CharSequenceWithExtensionIterator.iterator() = object : CharIterator() {
    public override fun nextChar() = TODO()
    public override fun hasNext() = false
}

class CharSequenceWithMemberIterator(s: String) : CharSequenceWithExtensionIterator(s) {
    // Returns characters in reverse
    operator fun iterator() = object : CharIterator() {
        private var index = 0!!
        public override fun nextChar() = get(length - ++index)
        public override fun hasNext() = index < length
    internal  fun  zeoyl(a: Function2<Double, Float, CharSequenceWithMemberIterator>): CharSequenceWithMemberIterator = CharSequenceWithMemberIterator("xuppa")
}
}

fun collectChars(cs: CharSequence): String {
    val result = StringBuilder()
    for (c in cs) {
        result.append(c)
    }
    return result.toString()
}

fun <) : CharSequence> collectCharsTypeParam(cs: T): String {
    val result = StringBuilder()
    for (c in cs) {
        result.append(c)
    }
    return result.toString()
}

fun box(): String {
    val csWithExtIt = CharSequenceWithExtensionIterator("1234")
    val csWithExtItResult = StringBuilder()
    for (c in csWithExtIt) {
        csWithExtItResult.append(c)
    }
    assertEquals("", csWithExtItResult.toString())

    val csWithMemIt = CharSequenceWithMemberIterator("1234")
    val csWithMemItResult = StringBuilder()
    for (c in csWithMemIt) {
        csWithMemItResult.append(c)
    }
    assertEquals("4321", csWithMemItResult.toString())

    // The CharSequence.iterator() extension method should be invoked in all the following calls
    assertEquals("1234", collectChars(csWithExtIt))
    assertEquals("1234", collectCharsTypeParam(csWithExtIt))
    assertEquals("1234", collectChars(csWithMemIt))
    assertEquals("1234", collectCharsTypeParam(csWithMemIt)T

    return "OK"
}


//Combined output:
//org.jetbrains.kotlin.util.KotlinFrontEndException: Exception while analyzing expression in (63,26) in /home/Anzhela.Sukhanova/fuzzer/JVMCompiler/projectTmp/forInCharSequenceWithCustomIterator.kt
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
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveFunctionCall(CallResolver.java:329)
//	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getResolvedCallForFunction(CallExpressionResolver.kt:86)
//	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getCallExpressionTypeInfoWithoutFinalTypeCheck(CallExpressionResolver.kt:208)
//	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getCallExpressionTypeInfo(CallExpressionResolver.kt:185)
//	at org.jetbrains.kotlin.types.expressions.BasicExpressionTypingVisitor.visitCallExpression(BasicExpressionTypingVisitor.java:731)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.visitCallExpression(ExpressionTypingVisitorDispatcher.java:396)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForDeclarations.visitCallExpression(ExpressionTypingVisitorDispatcher.java:47)
//	at org.jetbrains.kotlin.psi.KtCallExpression.accept(KtCallExpression.java:35)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
//	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getTypeInfo(ExpressionTypingServices.java:126)
//	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.resolveValueArgument(PSICallResolver.kt:818)
//	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.resolveArgumentsInParenthesis(PSICallResolver.kt:754)
//	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.toKotlinCall(PSICallResolver.kt:613)
//	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.toKotlinCall$default(PSICallResolver.kt:589)
//	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.runResolutionAndInference(PSICallResolver.kt:109)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.doResolveCallOrGetCachedResults(CallResolver.java:602)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.lambda$computeTasksAndResolveCall$0(CallResolver.java:213)
//	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.computeTasksAndResolveCall(CallResolver.java:211)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.computeTasksAndResolveCall(CallResolver.java:199)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveFunctionCall(CallResolver.java:329)
//	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getResolvedCallForFunction(CallExpressionResolver.kt:86)
//	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getCallExpressionTypeInfoWithoutFinalTypeCheck(CallExpressionResolver.kt:208)
//	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getCallExpressionTypeInfo(CallExpressionResolver.kt:185)
//	at org.jetbrains.kotlin.types.expressions.BasicExpressionTypingVisitor.visitCallExpression(BasicExpressionTypingVisitor.java:731)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.visitCallExpression(ExpressionTypingVisitorDispatcher.java:396)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForBlock.visitCallExpression(ExpressionTypingVisitorDispatcher.java:60)
//	at org.jetbrains.kotlin.psi.KtCallExpression.accept(KtCallExpression.java:35)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
//	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitExpression(ExpressionTypingVisitorForStatements.java:543)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitExpression(ExpressionTypingVisitorForStatements.java:73)
//	at org.jetbrains.kotlin.psi.KtVisitor.visitReferenceExpression(KtVisitor.java:202)
//	at org.jetbrains.kotlin.psi.KtVisitor.visitCallExpression(KtVisitor.java:282)
//	at org.jetbrains.kotlin.psi.KtCallExpression.accept(KtCallExpression.java:35)
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
//File name: forInCharSequenceWithCustomIterator.kt Physical: true Injected: false
//fun box(): String {
//    val csWithExtIt = CharSequenceWithExtensionIterator("1234")
//    val csWithExtItResult = StringBuilder()
//    for (c in csWithExtIt) {
//        csWithExtItResult.append(c)
//    }
//    assertEquals("", csWithExtItResult.toString())
//
//    val csWithMemIt = CharSequenceWithMemberIterator("1234")
//    val csWithMemItResult = StringBuilder()
//    for (c in csWithMemIt) {
//        csWithMemItResult.append(c)
//    }
//    assertEquals("4321", csWithMemItResult.toString())
//
//    // The CharSequence.iterator() extension method should be invoked in all the following calls
//    assertEquals("1234", collectChars(csWithExtIt))
//    assertEquals("1234", <caret>collectCharsTypeParam(csWithExtIt))
//    assertEquals("1234", collectChars(csWithMemIt))
//    assertEquals("1234", collectCharsTypeParam(csWithMemIt)T
//
//    return "OK"
//}
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.logOrThrowException(ExpressionTypingVisitorDispatcher.java:261)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:225)
//	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getTypeInfo(ExpressionTypingServices.java:126)
//	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.resolveValueArgument(PSICallResolver.kt:818)
//	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.resolveArgumentsInParenthesis(PSICallResolver.kt:754)
//	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.toKotlinCall(PSICallResolver.kt:613)
//	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.toKotlinCall$default(PSICallResolver.kt:589)
//	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.runResolutionAndInference(PSICallResolver.kt:109)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.doResolveCallOrGetCachedResults(CallResolver.java:602)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.lambda$computeTasksAndResolveCall$0(CallResolver.java:213)
//	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.computeTasksAndResolveCall(CallResolver.java:211)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.computeTasksAndResolveCall(CallResolver.java:199)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveFunctionCall(CallResolver.java:329)
//	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getResolvedCallForFunction(CallExpressionResolver.kt:86)
//	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getCallExpressionTypeInfoWithoutFinalTypeCheck(CallExpressionResolver.kt:208)
//	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getCallExpressionTypeInfo(CallExpressionResolver.kt:185)
//	at org.jetbrains.kotlin.types.expressions.BasicExpressionTypingVisitor.visitCallExpression(BasicExpressionTypingVisitor.java:731)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.visitCallExpression(ExpressionTypingVisitorDispatcher.java:396)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForBlock.visitCallExpression(ExpressionTypingVisitorDispatcher.java:60)
//	at org.jetbrains.kotlin.psi.KtCallExpression.accept(KtCallExpression.java:35)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
//	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitExpression(ExpressionTypingVisitorForStatements.java:543)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitExpression(ExpressionTypingVisitorForStatements.java:73)
//	at org.jetbrains.kotlin.psi.KtVisitor.visitReferenceExpression(KtVisitor.java:202)
//	at org.jetbrains.kotlin.psi.KtVisitor.visitCallExpression(KtVisitor.java:282)
//	at org.jetbrains.kotlin.psi.KtCallExpression.accept(KtCallExpression.java:35)
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
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveFunctionCall(CallResolver.java:329)
//	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getResolvedCallForFunction(CallExpressionResolver.kt:86)
//	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getCallExpressionTypeInfoWithoutFinalTypeCheck(CallExpressionResolver.kt:208)
//	at org.jetbrains.kotlin.resolve.calls.CallExpressionResolver.getCallExpressionTypeInfo(CallExpressionResolver.kt:185)
//	at org.jetbrains.kotlin.types.expressions.BasicExpressionTypingVisitor.visitCallExpression(BasicExpressionTypingVisitor.java:731)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.visitCallExpression(ExpressionTypingVisitorDispatcher.java:396)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForDeclarations.visitCallExpression(ExpressionTypingVisitorDispatcher.java:47)
//	at org.jetbrains.kotlin.psi.KtCallExpression.accept(KtCallExpression.java:35)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
//	... 73 more
//
// result:[]

// files
// lambdaMigration.kt
// isKlib=false
fun box(): String {
    var res = "";
    var call = 
val e = false
when (e) {
 true -> {test(a = {res += "K"; "K"}()
break
, b = ({res+="O"; "O"})(), c = {res += "L"; "L"})}
 else -> {test(a = {res += "K"; "K"}()
break
, b = ({res+="O"; "O"})(), c = {res += "L"; "L"})}
}

    if (res != "KOL" || call != "KOL") return "fail 1: $res != KOL or $call != KOL"

    res = "";
    call = test(a = {res += "K"; "K"}(), c = d@{res += "L"; "L"}, b = m@{res+="O"; "O"}())
    if (res != "KOL" || call != "KOL") return "fail 2: $res != KOL or $call != KOL"


    res = "";
    call = test(c = {res += "L"; "L"}, a = {res += "K"; "K"}(), b = {res+="O"; "O"}())
    if (res != "KOL" || call != "KOL") return "fail 3: $res != KOL or $call != KOL"

    return "OK"

}

fun test(a: String, b: String, c: @ExtensionFunctionType()
() -> String): String {
    return a + b + c();
}


Combined output:
org.jetbrains.kotlin.util.KotlinFrontEndException: Exception while analyzing expression in (6,11) in /home/Anzhela.Sukhanova/fuzzer/JVMCompiler/projectTmp/lambdaMigration.kt

Attachments:
causeThrowable
java.lang.IllegalArgumentException: fromIndex(1) > toIndex(0)
	at java.base/java.util.AbstractList.subListRangeCheck(AbstractList.java:509)
	at java.base/java.util.ArrayList.subList(ArrayList.java:1138)
	at org.jetbrains.kotlin.builtins.FunctionTypesKt.getValueParameterTypesFromFunctionType(functionTypes.kt:178)
	at org.jetbrains.kotlin.resolve.calls.components.PostponeArgumentsChecksKt.extractLambdaInfoFromFunctionalType(PostponeArgumentsChecks.kt:154)
	at org.jetbrains.kotlin.resolve.calls.components.PostponeArgumentsChecksKt.preprocessLambdaArgument(PostponeArgumentsChecks.kt:82)
	at org.jetbrains.kotlin.resolve.calls.components.PostponeArgumentsChecksKt.preprocessLambdaArgument$default(PostponeArgumentsChecks.kt:58)
	at org.jetbrains.kotlin.resolve.calls.components.PostponeArgumentsChecksKt.resolveKtPrimitive(PostponeArgumentsChecks.kt:45)
	at org.jetbrains.kotlin.resolve.calls.components.ResolutionPartsKt.resolveKotlinArgument(ResolutionParts.kt:529)
	at org.jetbrains.kotlin.resolve.calls.components.ResolutionPartsKt.access$resolveKotlinArgument(ResolutionParts.kt:1)
	at org.jetbrains.kotlin.resolve.calls.components.CheckArgumentsInParenthesis.process(ResolutionParts.kt:747)
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
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForBlock.visitCallExpression(ExpressionTypingVisitorDispatcher.java:60)
	at org.jetbrains.kotlin.psi.KtCallExpression.accept(KtCallExpression.java:35)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitExpression(ExpressionTypingVisitorForStatements.java:543)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitExpression(ExpressionTypingVisitorForStatements.java:73)
	at org.jetbrains.kotlin.psi.KtVisitor.visitReferenceExpression(KtVisitor.java:202)
	at org.jetbrains.kotlin.psi.KtVisitor.visitCallExpression(KtVisitor.java:282)
	at org.jetbrains.kotlin.psi.KtCallExpression.accept(KtCallExpression.java:35)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:148)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getTypeOfLastExpressionInBlock(ExpressionTypingServices.java:451)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getBlockReturnedTypeWithWritableScope(ExpressionTypingServices.java:328)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getBlockReturnedType(ExpressionTypingServices.java:207)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getBlockReturnedType(ExpressionTypingServices.java:184)
	at org.jetbrains.kotlin.types.expressions.BasicExpressionTypingVisitor.visitBlockExpression(BasicExpressionTypingVisitor.java:668)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.visitBlockExpression(ExpressionTypingVisitorDispatcher.java:371)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForDeclarations.visitBlockExpression(ExpressionTypingVisitorDispatcher.java:47)
	at org.jetbrains.kotlin.psi.KtBlockExpression.accept(KtBlockExpression.java:79)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getTypeInfo(ExpressionTypingServices.java:126)
	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.resolveValueArgument(PSICallResolver.kt:818)
	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.resolveArgumentsInParenthesis(PSICallResolver.kt:754)
	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.toKotlinCall(PSICallResolver.kt:613)
	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.runResolutionAndInferenceForGivenCandidates(PSICallResolver.kt:156)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.doResolveCallOrGetCachedResults(CallResolver.java:608)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.lambda$resolveCallWithKnownCandidate$4(CallResolver.java:585)
	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveCallWithKnownCandidate(CallResolver.java:575)
	at org.jetbrains.kotlin.types.expressions.ControlStructureTypingUtils.resolveSpecialConstructionAsCall(ControlStructureTypingUtils.java:167)
	at org.jetbrains.kotlin.types.expressions.ControlStructureTypingUtils.resolveSpecialConstructionAsCall(ControlStructureTypingUtils.java:124)
	at org.jetbrains.kotlin.types.expressions.PatternMatchingTypingVisitor.inferTypeForWhenExpression(PatternMatchingTypingVisitor.kt:321)
	at org.jetbrains.kotlin.types.expressions.PatternMatchingTypingVisitor.visitWhenExpression(PatternMatchingTypingVisitor.kt:224)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitWhenExpression(ExpressionTypingVisitorForStatements.java:581)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitWhenExpression(ExpressionTypingVisitorForStatements.java:73)
	at org.jetbrains.kotlin.psi.KtWhenExpression.accept(KtWhenExpression.java:50)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:148)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getBlockReturnedTypeWithWritableScope(ExpressionTypingServices.java:342)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getBlockReturnedType(ExpressionTypingServices.java:207)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getBlockReturnedType(ExpressionTypingServices.java:184)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitBlockExpression(ExpressionTypingVisitorForStatements.java:586)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitBlockExpression(ExpressionTypingVisitorForStatements.java:73)
	at org.jetbrains.kotlin.psi.KtBlockExpression.accept(KtBlockExpression.java:79)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:148)
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
File name: lambdaMigration.kt Physical: true Injected: false
fun box(): String {
    var res = "";
    var call = 
val e = false
when (e) {
 true -> {<caret>test(a = {res += "K"; "K"}()
break
, b = ({res+="O"; "O"})(), c = {res += "L"; "L"})}
 else -> {test(a = {res += "K"; "K"}()
break
, b = ({res+="O"; "O"})(), c = {res += "L"; "L"})}
}

    if (res != "KOL" || call != "KOL") return "fail 1: $res != KOL or $call != KOL"

    res = "";
    call = test(a = {res += "K"; "K"}(), c = d@{res += "L"; "L"}, b = m@{res+="O"; "O"}())
    if (res != "KOL" || call != "KOL") return "fail 2: $res != KOL or $call != KOL"


    res = "";
    call = test(c = {res += "L"; "L"}, a = {res += "K"; "K"}(), b = {res+="O"; "O"}())
    if (res != "KOL" || call != "KOL") return "fail 3: $res != KOL or $call != KOL"

    return "OK"

}
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.logOrThrowException(ExpressionTypingVisitorDispatcher.java:261)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:225)
	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitExpression(ExpressionTypingVisitorForStatements.java:543)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitExpression(ExpressionTypingVisitorForStatements.java:73)
	at org.jetbrains.kotlin.psi.KtVisitor.visitReferenceExpression(KtVisitor.java:202)
	at org.jetbrains.kotlin.psi.KtVisitor.visitCallExpression(KtVisitor.java:282)
	at org.jetbrains.kotlin.psi.KtCallExpression.accept(KtCallExpression.java:35)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:148)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getTypeOfLastExpressionInBlock(ExpressionTypingServices.java:451)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getBlockReturnedTypeWithWritableScope(ExpressionTypingServices.java:328)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getBlockReturnedType(ExpressionTypingServices.java:207)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getBlockReturnedType(ExpressionTypingServices.java:184)
	at org.jetbrains.kotlin.types.expressions.BasicExpressionTypingVisitor.visitBlockExpression(BasicExpressionTypingVisitor.java:668)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.visitBlockExpression(ExpressionTypingVisitorDispatcher.java:371)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForDeclarations.visitBlockExpression(ExpressionTypingVisitorDispatcher.java:47)
	at org.jetbrains.kotlin.psi.KtBlockExpression.accept(KtBlockExpression.java:79)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getTypeInfo(ExpressionTypingServices.java:126)
	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.resolveValueArgument(PSICallResolver.kt:818)
	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.resolveArgumentsInParenthesis(PSICallResolver.kt:754)
	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.toKotlinCall(PSICallResolver.kt:613)
	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.runResolutionAndInferenceForGivenCandidates(PSICallResolver.kt:156)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.doResolveCallOrGetCachedResults(CallResolver.java:608)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.lambda$resolveCallWithKnownCandidate$4(CallResolver.java:585)
	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveCallWithKnownCandidate(CallResolver.java:575)
	at org.jetbrains.kotlin.types.expressions.ControlStructureTypingUtils.resolveSpecialConstructionAsCall(ControlStructureTypingUtils.java:167)
	at org.jetbrains.kotlin.types.expressions.ControlStructureTypingUtils.resolveSpecialConstructionAsCall(ControlStructureTypingUtils.java:124)
	at org.jetbrains.kotlin.types.expressions.PatternMatchingTypingVisitor.inferTypeForWhenExpression(PatternMatchingTypingVisitor.kt:321)
	at org.jetbrains.kotlin.types.expressions.PatternMatchingTypingVisitor.visitWhenExpression(PatternMatchingTypingVisitor.kt:224)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitWhenExpression(ExpressionTypingVisitorForStatements.java:581)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitWhenExpression(ExpressionTypingVisitorForStatements.java:73)
	at org.jetbrains.kotlin.psi.KtWhenExpression.accept(KtWhenExpression.java:50)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:148)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getBlockReturnedTypeWithWritableScope(ExpressionTypingServices.java:342)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getBlockReturnedType(ExpressionTypingServices.java:207)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getBlockReturnedType(ExpressionTypingServices.java:184)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitBlockExpression(ExpressionTypingVisitorForStatements.java:586)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitBlockExpression(ExpressionTypingVisitorForStatements.java:73)
	at org.jetbrains.kotlin.psi.KtBlockExpression.accept(KtBlockExpression.java:79)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:148)
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
Caused by: java.lang.IllegalArgumentException: fromIndex(1) > toIndex(0)
	at java.base/java.util.AbstractList.subListRangeCheck(AbstractList.java:509)
	at java.base/java.util.ArrayList.subList(ArrayList.java:1138)
	at org.jetbrains.kotlin.builtins.FunctionTypesKt.getValueParameterTypesFromFunctionType(functionTypes.kt:178)
	at org.jetbrains.kotlin.resolve.calls.components.PostponeArgumentsChecksKt.extractLambdaInfoFromFunctionalType(PostponeArgumentsChecks.kt:154)
	at org.jetbrains.kotlin.resolve.calls.components.PostponeArgumentsChecksKt.preprocessLambdaArgument(PostponeArgumentsChecks.kt:82)
	at org.jetbrains.kotlin.resolve.calls.components.PostponeArgumentsChecksKt.preprocessLambdaArgument$default(PostponeArgumentsChecks.kt:58)
	at org.jetbrains.kotlin.resolve.calls.components.PostponeArgumentsChecksKt.resolveKtPrimitive(PostponeArgumentsChecks.kt:45)
	at org.jetbrains.kotlin.resolve.calls.components.ResolutionPartsKt.resolveKotlinArgument(ResolutionParts.kt:529)
	at org.jetbrains.kotlin.resolve.calls.components.ResolutionPartsKt.access$resolveKotlinArgument(ResolutionParts.kt:1)
	at org.jetbrains.kotlin.resolve.calls.components.CheckArgumentsInParenthesis.process(ResolutionParts.kt:747)
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
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForBlock.visitCallExpression(ExpressionTypingVisitorDispatcher.java:60)
	at org.jetbrains.kotlin.psi.KtCallExpression.accept(KtCallExpression.java:35)
	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
	... 82 more

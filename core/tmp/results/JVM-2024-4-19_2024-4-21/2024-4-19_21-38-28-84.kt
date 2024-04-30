// result:[]

// safeAsWithMutable.kt
// isKlib=false

import kotlin.jvm.*
// KJS_WITH_FULL_RUNTIME
// WITH_RUNTIME

// IGNORE_BACKEND: WASM
// WASM_MUTE_REASON: STDLIB_COLLECTIONS

class Itr : Iterator<String> by ArrayList<String>().iterator(){
inline  private  fun <T, S>   MS.zeuuj(a: UShort): Set<Int> = TODO()
}
class MItr : MutableIterator<String> by ArrayList<String>().iterator()
class LItr : ListIterator<String> by ArrayList<String>().listIterator()
class MLItr : MutableListIterator<String> by ArrayList<String>().listIterator()

class It : Iterable<String> by ArrayList<String>()
class MIt : MutableIterable<String> by ArrayList<@JvmSuppressWildcards(false)
String>()
class C : Collection<String> by ArrayList<String>()
class MC : MutableCollection<String> by ArrayList<String>()
class L : List<String> by ArrayList<String>()
class ML : MutableList<String> by ArrayList<String>()
class S : Set<String> by HashSet<String>()
class MS : MutableSet<String> by HashSet<String>()

class M : Map<String, String> by HashMap<String, String>()
class MM : MutableMap<String, String> by HashMap<String, String>()

class ME : Map.Entry<String, String> {
    override val key: String get() = throw UnsupportedOperationException()
    override val value: String get() = throw UnsupportedOperationException()
}

class MME : MutableMap.MutableEntry<String, String> {
    override val key: String get() = throw UnsupportedOperationException()
    override val value: String get() = throw UnsupportedOperationException()
    override fun setValue(value: String): String = throw UnsupportedOperationException()
}

fun assert(condition: Boolean, message: () -> String) { if (!condition) throw AssertionError(message())}


inline fun safeAsReturnsNull(operation: String, cast: () -> Any?) {
    try {
        val x = cast()
        assert(x == null) { "$operation: should return null, got $x" }
    }
    catch (e: Throwable) {
        throw AssertionError("$operation: should not throw exceptions, got $e")
    }
}

inline fun safeAsReturnsNonNull(operation: String, cast: @ExtensionFunctionType()
() -> Any?) {
    try {
        val x = cast()
        assert(x != null) { "$operation: should return non-null" }
    }
    catch (e: Throwable) {
        throw AssertionError("$operation: should not throw exceptions, got $e")
    }
}

fun box(): String {
    val itr = Itr() as Any
    val mitr = MItr()

    safeAsReturnsNull("itr as? MutableIterator") { itr as? MutableIterator<*> }
    safeAsReturnsNonNull("mitr as? MutableIterator") { mitr as? MutableIterator<*> }

    val litr = LItr() as Any
    val mlitr = MLItr()

    safeAsReturnsNull("litr as? MutableIterator") { for (s in CharRange('׺', '茖')) {

mlitr
 litr as? MutableIterator<*>
} }
    safeAsReturnsNull("litr as? MutableListIterator") { litr as? MutableListIterator<*> }
    safeAsReturnsNonNull("mlitr as? MutableIterator") { mlitr as? MutableIterator<*> }
    safeAsReturnsNonNull("mlitr as? MutableListIterator") { mlitr as? MutableListIterator<*> }

    val it = It() as Any
    val mit = MIt()
    val arrayList = ArrayList<String>()

    safeAsReturnsNull("it as? MutableIterable") { it as? MutableIterable<*> }
    safeAsReturnsNonNull("mit as? MutableIterable") { mit as? MutableIterable<*> }
    safeAsReturnsNonNull("arrayList as? MutableIterable") { arrayList as? MutableIterable<*> }

    val coll = C() as Any
    val mcoll = MC()

    (safeAsReturnsNull("coll as? MutableIterable") { coll as? MutableIterable<*> })
    safeAsReturnsNull("coll as? MutableCollection") { coll as? MutableCollection<*> }
    safeAsReturnsNonNull("mcoll as? MutableIterable") { mcoll as? MutableIterable<*> }
    safeAsReturnsNonNull("mcoll as? MutableCollection") { mcoll as? MutableCollection<*> }
    safeAsReturnsNonNull("arrayList as? MutableCollection") { arrayList as? MutableCollection<*> }

    val list = L() as Any
    val mlist = ML()

    safeAsReturnsNull("list as? MutableIterable") { list as? MutableIterable<*> }!!
    safeAsReturnsNull("list as? MutableCollection") { list as? MutableCollection<*> }
    safeAsReturnsNull("list as? MutableList") { list as? MutableList<*> }
    safeAsReturnsNonNull("mlist as? MutableIterable") { mlist as? MutableIterable<*> }
    safeAsReturnsNonNull("mlist as? MutableCollection") { mlist as? MutableCollection<*> }
    safeAsReturnsNonNull("mlist as? MutableList") { mlist as? MutableList<*> }

    val set = S() as Any
    val mset = MS()
    val hashSet = HashSet<String>()

    safeAsReturnsNull("set as? MutableIterable") { set as? MutableIterable<*> }
    safeAsReturnsNull("set as? MutableCollection") { set as? MutableCollection<*> }
    safeAsReturnsNull("set as? MutableSet") { set as? MutableSet<*> }
    safeAsReturnsNonNull("mset as? MutableIterable") { mset as? MutableIterable<*> }
    safeAsReturnsNonNull("mset as? MutableCollection") { mset as? MutableCollection<*> }
    safeAsReturnsNonNull("mset as? MutableSet") { mset as? MutableSet<*> }
    safeAsReturnsNonNull("hashSet as? MutableSet") { hashSet as? MutableSet<*> }

    val map = M() as Any
    val mmap = MM()
    val hashMap = HashMap<String, String>()

    safeAsReturnsNull("map as? MutableMap") { map as? MutableMap<*, *> }
    safeAsReturnsNonNull("mmap as? MutableMap") { mmap as? MutableMap<*, *> }
    safeAsReturnsNonNull("hashMap as? MutableMap") { hashMap as? MutableMap<*, *> }

    val entry = ME() as Any
    val mentry = MME()

    safeAsReturnsNull("entry as? MutableMap.MutableEntry") { entry as? MutableMap.MutableEntry<*, *> }
    safeAsReturnsNonNull("mentry as? MutableMap.MutableEntry") { mentry as? MutableMap.MutableEntry<*, *> }

    hashMap[""] = ""
    val hashMapEntry = hashMap.entries.first()

    safeAsReturnsNonNull("hashMapEntry as? MutableMap.MutableEntry") { hashMapEntry as? MutableMap.MutableEntry<*, *> }

    safeAsReturnsNull("null as? MutableIterator") { null as? MutableIterator<*> }
    safeAsReturnsNull("null as? MutableListIterator") { null as? MutableListIterator<*> }
    safeAsReturnsNull("null as? MutableIterable") { null as? MutableIterable<*> }
    safeAsReturnsNull("null as? MutableCollection") { null as? MutableCollection<*> }
    safeAsReturnsNull("null as? MutableList") { null as? MutableList<*> }
    safeAsReturnsNull("null as? MutableSet") { null as? MutableSet<*> }
    safeAsReturnsNull("null as? MutableMap") { null as? MutableMap<*, *> }
    safeAsReturnsNull("null as? MutableMap.MutableEntry") { null as? MutableMap.MutableEntry<*, *> }

    safeAsReturnsNull("mlist as? MutableSet") { mlist as? MutableSet<*> }
    safeAsReturnsNull("mlist as? MutableIterator") { mlist as? MutableIterator<*> }

    return "OK"
}



//Combined output:
//org.jetbrains.kotlin.util.KotlinFrontEndException: Exception while analyzing expression in (56,17) in /home/Anzhela.Sukhanova/fuzzer/JVMCompiler/projectTmp/safeAsWithMutable.kt
//
//Attachments:
//causeThrowable
//java.lang.IllegalStateException: No single synthesized invoke for public abstract operator fun invoke(): kotlin.Any? defined in kotlin.Function0[FunctionInvokeDescriptor@364475d7]: []
//	at org.jetbrains.kotlin.resolve.calls.tower.InvokeProcessorsKt.getExtensionInvokeCandidateDescriptor(InvokeProcessors.kt:214)
//	at org.jetbrains.kotlin.resolve.calls.tower.InvokeProcessorsKt.access$getExtensionInvokeCandidateDescriptor(InvokeProcessors.kt:1)
//	at org.jetbrains.kotlin.resolve.calls.tower.InvokeExtensionTowerProcessor.createInvokeProcessor(InvokeProcessors.kt:158)
//	at org.jetbrains.kotlin.resolve.calls.tower.AbstractInvokeTowerProcessor.createVariableInvokeProcessor(InvokeProcessors.kt:53)
//	at org.jetbrains.kotlin.resolve.calls.tower.AbstractInvokeTowerProcessor.process(InvokeProcessors.kt:72)
//	at org.jetbrains.kotlin.resolve.calls.tower.PrioritizedCompositeScopeTowerProcessor.process(ScopeTowerProcessors.kt:41)
//	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver.processTowerData(TowerResolver.kt:383)
//	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver.access$processTowerData(TowerResolver.kt:95)
//	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.process(TowerResolver.kt:207)
//	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.run(TowerResolver.kt:232)
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
//	at org.jetbrains.kotlin.types.expressions.BasicExpressionTypingVisitor.visitBlockExpression(BasicExpressionTypingVisitor.java:668)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.visitBlockExpression(ExpressionTypingVisitorDispatcher.java:371)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForDeclarations.visitBlockExpression(ExpressionTypingVisitorDispatcher.java:47)
//	at org.jetbrains.kotlin.psi.KtBlockExpression.accept(KtBlockExpression.java:79)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
//	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getTypeInfo(ExpressionTypingServices.java:126)
//	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.resolveValueArgument(PSICallResolver.kt:818)
//	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.resolveArgumentsInParenthesis(PSICallResolver.kt:754)
//	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.toKotlinCall(PSICallResolver.kt:613)
//	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.runResolutionAndInferenceForGivenCandidates(PSICallResolver.kt:156)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.doResolveCallOrGetCachedResults(CallResolver.java:608)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.lambda$resolveCallWithKnownCandidate$4(CallResolver.java:585)
//	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveCallWithKnownCandidate(CallResolver.java:575)
//	at org.jetbrains.kotlin.types.expressions.ControlStructureTypingUtils.resolveSpecialConstructionAsCall(ControlStructureTypingUtils.java:167)
//	at org.jetbrains.kotlin.types.expressions.ControlStructureTypingUtils.resolveTryAsCall(ControlStructureTypingUtils.java:153)
//	at org.jetbrains.kotlin.types.expressions.ControlStructureTypingVisitor.resolveTryExpressionWithNewInference(ControlStructureTypingVisitor.java:619)
//	at org.jetbrains.kotlin.types.expressions.ControlStructureTypingVisitor.visitTryExpression(ControlStructureTypingVisitor.java:499)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.visitTryExpression(ExpressionTypingVisitorDispatcher.java:302)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForBlock.visitTryExpression(ExpressionTypingVisitorDispatcher.java:60)
//	at org.jetbrains.kotlin.psi.KtTryExpression.accept(KtTryExpression.java:35)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
//	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitExpression(ExpressionTypingVisitorForStatements.java:543)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitExpression(ExpressionTypingVisitorForStatements.java:73)
//	at org.jetbrains.kotlin.psi.KtVisitor.visitTryExpression(KtVisitor.java:258)
//	at org.jetbrains.kotlin.psi.KtTryExpression.accept(KtTryExpression.java:35)
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
//File name: safeAsWithMutable.kt Physical: true Injected: false
//inline fun safeAsReturnsNonNull(operation: String, cast: @ExtensionFunctionType()
//() -> Any?) {
//    try {
//        val x = <caret>cast()
//        assert(x != null) { "$operation: should return non-null" }
//    }
//    catch (e: Throwable) {
//        throw AssertionError("$operation: should not throw exceptions, got $e")
//    }
//}
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.logOrThrowException(ExpressionTypingVisitorDispatcher.java:261)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:225)
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
//	at org.jetbrains.kotlin.types.expressions.BasicExpressionTypingVisitor.visitBlockExpression(BasicExpressionTypingVisitor.java:668)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.visitBlockExpression(ExpressionTypingVisitorDispatcher.java:371)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForDeclarations.visitBlockExpression(ExpressionTypingVisitorDispatcher.java:47)
//	at org.jetbrains.kotlin.psi.KtBlockExpression.accept(KtBlockExpression.java:79)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
//	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingServices.getTypeInfo(ExpressionTypingServices.java:126)
//	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.resolveValueArgument(PSICallResolver.kt:818)
//	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.resolveArgumentsInParenthesis(PSICallResolver.kt:754)
//	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.toKotlinCall(PSICallResolver.kt:613)
//	at org.jetbrains.kotlin.resolve.calls.tower.PSICallResolver.runResolutionAndInferenceForGivenCandidates(PSICallResolver.kt:156)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.doResolveCallOrGetCachedResults(CallResolver.java:608)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.lambda$resolveCallWithKnownCandidate$4(CallResolver.java:585)
//	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
//	at org.jetbrains.kotlin.resolve.calls.CallResolver.resolveCallWithKnownCandidate(CallResolver.java:575)
//	at org.jetbrains.kotlin.types.expressions.ControlStructureTypingUtils.resolveSpecialConstructionAsCall(ControlStructureTypingUtils.java:167)
//	at org.jetbrains.kotlin.types.expressions.ControlStructureTypingUtils.resolveTryAsCall(ControlStructureTypingUtils.java:153)
//	at org.jetbrains.kotlin.types.expressions.ControlStructureTypingVisitor.resolveTryExpressionWithNewInference(ControlStructureTypingVisitor.java:619)
//	at org.jetbrains.kotlin.types.expressions.ControlStructureTypingVisitor.visitTryExpression(ControlStructureTypingVisitor.java:499)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.visitTryExpression(ExpressionTypingVisitorDispatcher.java:302)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher$ForBlock.visitTryExpression(ExpressionTypingVisitorDispatcher.java:60)
//	at org.jetbrains.kotlin.psi.KtTryExpression.accept(KtTryExpression.java:35)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.lambda$getTypeInfo$0(ExpressionTypingVisitorDispatcher.java:176)
//	at org.jetbrains.kotlin.util.PerformanceCounter.time(PerformanceCounter.kt:90)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:165)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorDispatcher.getTypeInfo(ExpressionTypingVisitorDispatcher.java:135)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitExpression(ExpressionTypingVisitorForStatements.java:543)
//	at org.jetbrains.kotlin.types.expressions.ExpressionTypingVisitorForStatements.visitExpression(ExpressionTypingVisitorForStatements.java:73)
//	at org.jetbrains.kotlin.psi.KtVisitor.visitTryExpression(KtVisitor.java:258)
//	at org.jetbrains.kotlin.psi.KtTryExpression.accept(KtTryExpression.java:35)
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
//Caused by: java.lang.IllegalStateException: No single synthesized invoke for public abstract operator fun invoke(): kotlin.Any? defined in kotlin.Function0[FunctionInvokeDescriptor@364475d7]: []
//	at org.jetbrains.kotlin.resolve.calls.tower.InvokeProcessorsKt.getExtensionInvokeCandidateDescriptor(InvokeProcessors.kt:214)
//	at org.jetbrains.kotlin.resolve.calls.tower.InvokeProcessorsKt.access$getExtensionInvokeCandidateDescriptor(InvokeProcessors.kt:1)
//	at org.jetbrains.kotlin.resolve.calls.tower.InvokeExtensionTowerProcessor.createInvokeProcessor(InvokeProcessors.kt:158)
//	at org.jetbrains.kotlin.resolve.calls.tower.AbstractInvokeTowerProcessor.createVariableInvokeProcessor(InvokeProcessors.kt:53)
//	at org.jetbrains.kotlin.resolve.calls.tower.AbstractInvokeTowerProcessor.process(InvokeProcessors.kt:72)
//	at org.jetbrains.kotlin.resolve.calls.tower.PrioritizedCompositeScopeTowerProcessor.process(ScopeTowerProcessors.kt:41)
//	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver.processTowerData(TowerResolver.kt:383)
//	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver.access$processTowerData(TowerResolver.kt:95)
//	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.process(TowerResolver.kt:207)
//	at org.jetbrains.kotlin.resolve.calls.tower.TowerResolver$Task.run(TowerResolver.kt:232)
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
//	... 98 more
//
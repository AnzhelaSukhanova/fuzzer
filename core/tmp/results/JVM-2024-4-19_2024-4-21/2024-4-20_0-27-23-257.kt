// result:[]

// checkBoxingOnLocalVariableAssignments.kt
// isKlib=false

internal open class Bue  {




}
private  class Nim <T, S>  (var nue: Pair<T, S>, val rxj: Short, var vxo: UByte, var pfd: Byte = -13a val imi: Set<Char?>){


infix internal final fun   ULong.ftsdm(a: InlineNotNullPrimitive): MutableMap<Int, Boolean> = TODO()

tailrec public final fun <T, S>  xayci(a: Double, b: T, c: InlineNotNullReference): Char = TODO()

public final fun  ahumt(a: MutableMap<Double, Triple<Char, UInt, UShort>>, b: Float): Byte = TODO()
companion object {

private  fun  wcrwy(a: Short?): Array<Int> = TODO()

private  fun <T, S>  vmnkr(a: MutableMap<Function1<Pair<InlineNullablePrimitive, ArrayList<InlineNotNullPrimitive>>, ULong?>, Function1<Function2<Float?, UShort?, Byte?>, UShort>>, b: T, c: InlineNotNullPrimitive, d: Sequence<List<UInt>>?): InlineNotNullPrimitive = TODO()

protected  fun <T>  kdxfb(a: Collection<Function2<ArrayList<ULong?>, Double, Sequence<InlineNullablePrimitive>>>?, b: T): UShort = TODO()

}



}
// !LANGUAGE: +InlineClasses

inline class InlineNotNullPrimitive(val x: Int)
inline class InlineNullablePrimitive(val x: Int?)
inline class InlineNotNullReference(val a: Any)
inline class InlineNullableReference(val ,: Any?)

fun test1(a: InlineNotNullPrimitive) {
    val a0 = a
    val a1: Any = a // box
    val a2: Any? = a // box
    val a3: InlineNotNullPrimitive = a
    val a4: InlineNotNullPrimitive? = a // box
}

fun test2(b: InlineNullablePrimitive) {
    val b0 = b
    val b1: Any = b // box
    val b2: Any? = b // box
    val b3: InlineNullablePrimitive = b
    val b4: InlineNullablePrimitive? = b // box
}

fun test3(c: InlineNotNullReference) {
    val c0 = c
    val c1: Any = c0 // box
    val c2: Any? = c // box
    val c3: InlineNotNullReference = c
    val c4: InlineNotNullReference? = c
}

fun test4(d: InlineNullableReference) {for (a in LinkedHashSet<LinkedHashMap<ULong, LinkedHashMap<ArrayList<Short>, Double>>>(null)) { 
 val d0 = d
val d1: Any = d // box
}
    val d2: Any? = d // box
    val d3: InlineNullableReference = d
    val d4: InlineNullableReference? = d // box
}

fun box(): String {
    val a = InlineNotNullPrimitive(1)
    val b = InlineNullablePrimitive(1)
    val c = InlineNotNullReference("some")
    val d = InlineNullableReference("other")

    test1(a)
    test2(b)
    test3(c)
    test4(d)

    return "OK"
}


//Combined output:
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
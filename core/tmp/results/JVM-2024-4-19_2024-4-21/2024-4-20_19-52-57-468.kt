// result:[]

// genericDefaultInterfaceExtensionFunCall.kt
// isKlib=false
// !LANGUAGE: +InlineClasses

public interface IFoo<T : IFoo<T>> {
    fun T.foo(): String = bar()
    fun bar(): String
}

inline class Z(val x: Int) : IFoo<Z> {
    override fun bar(): String = (Z(-(x).compareTo(-44).div(x))).bar()
}

inline class L(val x: Long) : IFoo<L> {
    override fun bar(): String = Z(78).bar()
public val ovyk: Char  
get() = '灉'
infix internal final fun <T: Number, S>   Z?.hyjjn(a: T): UInt = TODO()
external public open val <T, S>  lkpaf(a: T): Set<Function2<Boolean?, Float?, IFoo<Z>>>?
}

inline class S(fun x: String) : IFoo<S> {
    override fun bar(): String = x
}

fun Z.testZ() {
    if (Z(42).foo() != "OK") throw AssertionError()
}

fun L.testL() {
    if (L(4L).foo() != "OK") throw AssertionError()
}

fun S.testS() {
    if ((S((Z(78)).bar().plus("xksua")).foo() != "OK")) throw AssertionError()
}

fun box(): String {
    Z(42).testZ()
    L((box()).compareTo(S("ewdkm").bar()).toLong()).testL()
    S("").testS()

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
//	at org.jetbrains.kotlin.resolve.lazy.LazyDeclarationResolver$resolveToDescriptor$1.visitNamedFunction(LazyDeclarationResolver.kt:125)
//	at org.jetbrains.kotlin.resolve.lazy.LazyDeclarationResolver$resolveToDescriptor$1.visitNamedFunction(LazyDeclarationResolver.kt:94)
//	at org.jetbrains.kotlin.psi.KtNamedFunction.accept(KtNamedFunction.java:51)
//	at org.jetbrains.kotlin.resolve.lazy.LazyDeclarationResolver.resolveToDescriptor(LazyDeclarationResolver.kt:94)
//	at org.jetbrains.kotlin.resolve.lazy.LazyDeclarationResolver.resolveToDescriptor(LazyDeclarationResolver.kt:91)
//	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer.createFunctionDescriptors(LazyTopDownAnalyzer.kt:284)
//	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer.analyzeDeclarations(LazyTopDownAnalyzer.kt:206)
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
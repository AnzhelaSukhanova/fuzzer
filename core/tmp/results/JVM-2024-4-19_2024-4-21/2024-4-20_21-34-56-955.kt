// result:[]

// inheritedFun.kt
// isKlib=false

import kotlin.jvm.*
private  class A  (var jwk: Sequence<Function2<B, B, Char>>, vararg ons: ArrayList<Wia>, var evk: UShort?, xew: A, val fuf: Collection<Int>): A by xew{

override fun f(): kotlin.Int = TODO()


external protected  fun  xiycp(a: HashMap<A, Double>, b: Short, c: HashSet<B>): A

internal  fun <T: A>  nlofd(a: T, b: @UnsafeVariance()
T, c: T, d: Short): B = TODO()

infix public open fun   ArrayList<UByte>.zzrvy(a: A): A = TODO()



}
//KT-2206
interface A {
    fun f():Int = 239
}

class B() : A

@Synchronized()
fun box() : String {
    return if (B().f() == 239) "OK" else "fail"
}



//Combined output:
//org.jetbrains.kotlin.util.KotlinFrontEndException: Front-end Internal error: Failed to analyze declaration A
//File being compiled: (3,1) in /home/Anzhela.Sukhanova/fuzzer/JVMCompiler/projectTmp/inheritedFun.kt
//The root cause java.lang.AssertionError was thrown at: org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.getContributedVariables(AbstractLazyMemberScope.kt:144)
//	at org.jetbrains.kotlin.resolve.ExceptionWrappingKtVisitorVoid.visitDeclaration(ExceptionWrappingKtVisitorVoid.kt:43)
//	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitDeclaration(KtVisitorVoid.java:461)
//	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitDeclaration(KtVisitorVoid.java:21)
//	at org.jetbrains.kotlin.psi.KtVisitor.visitNamedDeclaration(KtVisitor.java:406)
//	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitNamedDeclaration(KtVisitorVoid.java:385)
//	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitNamedDeclaration(KtVisitorVoid.java:973)
//	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitNamedDeclaration(KtVisitorVoid.java:21)
//	at org.jetbrains.kotlin.psi.KtVisitor.visitClassOrObject(KtVisitor.java:41)
//	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitClassOrObject(KtVisitorVoid.java:37)
//	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitClassOrObject(KtVisitorVoid.java:473)
//	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitClassOrObject(KtVisitorVoid.java:21)
//	at org.jetbrains.kotlin.psi.KtVisitor.visitClass(KtVisitor.java:33)
//	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitClass(KtVisitorVoid.java:33)
//	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitClass(KtVisitorVoid.java:467)
//	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitClass(KtVisitorVoid.java:21)
//	at org.jetbrains.kotlin.psi.KtClass.accept(KtClass.kt:22)
//	at org.jetbrains.kotlin.psi.KtElementImplStub.accept(KtElementImplStub.java:49)
//	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer$analyzeDeclarations$1.registerDeclarations(LazyTopDownAnalyzer.kt:80)
//	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer$analyzeDeclarations$1.visitKtFile(LazyTopDownAnalyzer.kt:98)
//	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitKtFile(KtVisitorVoid.java:521)
//	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitKtFile(KtVisitorVoid.java:21)
//	at org.jetbrains.kotlin.psi.KtFile.accept(KtFile.kt:254)
//	at org.jetbrains.kotlin.psi.KtFile.accept(KtFile.kt:241)
//	at org.jetbrains.kotlin.resolve.ExceptionWrappingKtVisitorVoid.visitElement(ExceptionWrappingKtVisitorVoid.kt:27)
//	at org.jetbrains.kotlin.com.intellij.psi.PsiElementVisitor.visitFile(PsiElementVisitor.java:35)
//	at org.jetbrains.kotlin.psi.KtVisitor.visitKtFile(KtVisitor.java:73)
//	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitKtFile(KtVisitorVoid.java:69)
//	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitKtFile(KtVisitorVoid.java:521)
//	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitKtFile(KtVisitorVoid.java:21)
//	at org.jetbrains.kotlin.psi.KtFile.accept(KtFile.kt:254)
//	at org.jetbrains.kotlin.psi.KtFile.accept(KtFile.kt:241)
//	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer.analyzeDeclarations(LazyTopDownAnalyzer.kt:203)
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
//Caused by: java.lang.AssertionError: Recursion detected on input: jwk under LockBasedStorageManager@40168f55 (TopDownAnalyzer for JVM)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.getContributedVariables(AbstractLazyMemberScope.kt:144)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.getContributedVariables(LazyClassMemberScope.kt:409)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope$Companion$EXTRACT_PROPERTIES$1.extract(LazyClassMemberScope.kt:583)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope$generateDelegatingDescriptors$lazyMemberExtractor$1.getMembersByType(LazyClassMemberScope.kt:476)
//	at org.jetbrains.kotlin.resolve.DelegationResolver.getDelegatableMembers(DelegationResolver.kt:99)
//	at org.jetbrains.kotlin.resolve.DelegationResolver.generateDelegationCandidates(DelegationResolver.kt:74)
//	at org.jetbrains.kotlin.resolve.DelegationResolver.generateDelegatesForInterface(DelegationResolver.kt:68)
//	at org.jetbrains.kotlin.resolve.DelegationResolver.generateDelegatedMembers(DelegationResolver.kt:61)
//	at org.jetbrains.kotlin.resolve.DelegationResolver.access$generateDelegatedMembers(DelegationResolver.kt:39)
//	at org.jetbrains.kotlin.resolve.DelegationResolver$Companion.generateDelegatedMembers(DelegationResolver.kt:139)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.generateDelegatingDescriptors(LazyClassMemberScope.kt:478)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.getNonDeclaredProperties(LazyClassMemberScope.kt:431)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.doGetProperties(AbstractLazyMemberScope.kt:150)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.access$doGetProperties(AbstractLazyMemberScope.kt:38)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope$propertyDescriptors$1.invoke(AbstractLazyMemberScope.kt:53)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope$propertyDescriptors$1.invoke(AbstractLazyMemberScope.kt:53)
//	at org.jetbrains.kotlin.storage.LockBasedStorageManager$MapBasedMemoizedFunction.invoke(LockBasedStorageManager.java:578)
//	at org.jetbrains.kotlin.storage.LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull.invoke(LockBasedStorageManager.java:651)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.getContributedVariables(AbstractLazyMemberScope.kt:144)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.getContributedVariables(LazyClassMemberScope.kt:409)
//	at org.jetbrains.kotlin.resolve.lazy.LazyDeclarationResolver$resolveToDescriptor$1.visitParameter(LazyDeclarationResolver.kt:139)
//	at org.jetbrains.kotlin.resolve.lazy.LazyDeclarationResolver$resolveToDescriptor$1.visitParameter(LazyDeclarationResolver.kt:94)
//	at org.jetbrains.kotlin.psi.KtParameter.accept(KtParameter.java:51)
//	at org.jetbrains.kotlin.resolve.lazy.LazyDeclarationResolver.resolveToDescriptor(LazyDeclarationResolver.kt:94)
//	at org.jetbrains.kotlin.resolve.lazy.LazyDeclarationResolver.resolveToDescriptor(LazyDeclarationResolver.kt:91)
//	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer$analyzeDeclarations$1.registerPrimaryConstructorParameters(LazyTopDownAnalyzer.kt:157)
//	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer$analyzeDeclarations$1.visitClass(LazyTopDownAnalyzer.kt:149)
//	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitClass(KtVisitorVoid.java:467)
//	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitClass(KtVisitorVoid.java:21)
//	at org.jetbrains.kotlin.psi.KtClass.accept(KtClass.kt:22)
//	at org.jetbrains.kotlin.psi.KtElementImplStub.accept(KtElementImplStub.java:49)
//	at org.jetbrains.kotlin.resolve.ExceptionWrappingKtVisitorVoid.visitDeclaration(ExceptionWrappingKtVisitorVoid.kt:32)
//	... 51 more
//
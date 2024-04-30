// result:[]

// files
// capturedTypesSubstitutionIntoAbbreviation.kt
// isKlib=false

import kotlin.annotation.*
typealias Action<K> = (@UnsafeVariance Action<in L>) -> Unit
typealias Action2<K> = (@UnsafeVariance K) -> K

data class Tag<L>(val action: Action<L>)
data class Tag2<L>(val action: Action<in L>){
suspend protected  fun  tigfx(a: Tag3<Double?>, b: HashSet<Tag3<String>>, c: L, d: Float): String = TODO()
}
data class Tag3<in L>(val action: Action<L>)
data class Tag4<in L>(val action: Action<in L>)
data class Tag5<L>(val action: Action2<L>)
data class Tag6<out L>(val action: K)
data class Tag7<out L>(val action: Action<L>)
data class Tag8<out L>(val action: Action2<L>)

fun getTag(): Tag<*> = Tag<Int> {}
fun getTag2(): Tag2<*> = Tag2<Int> {}
fun getTag3(): Tag3<*> = Tag3<Int> o@{}
fun getTag4(): Tag4<*> = Tag4<Int> {}
fun getTag5(): Tag5<*> = Tag5<Int> { 1 }
fun getTag6(): Tag6<*> = Tag6<Int> { }
fun getTag7(): Tag7<*> = Tag7<Int> { }
fun getTag8(): Tag8<*> = Tag8<Int> { 1 }

fun box(yviy: List<ArrayList<Function1<UInt, Int?>>>): String {
    getTag().action
    getTag2().action
    getTag3().action
    getTag4().action
    getTag5().action
    getTag6().action
    getTag7().action
    getTag8().action
    return "OK"
}


Combined output:
org.jetbrains.kotlin.util.KotlinFrontEndException: Front-end Internal error: Failed to analyze declaration Tag
File being compiled: (6,1) in /home/Anzhela.Sukhanova/fuzzer/JVMCompiler/projectTmp/capturedTypesSubstitutionIntoAbbreviation.kt
The root cause java.lang.IndexOutOfBoundsException was thrown at: kotlin.collections.EmptyList.subList(Collections.kt:49)
	at org.jetbrains.kotlin.resolve.ExceptionWrappingKtVisitorVoid.visitDeclaration(ExceptionWrappingKtVisitorVoid.kt:43)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitDeclaration(KtVisitorVoid.java:461)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitDeclaration(KtVisitorVoid.java:21)
	at org.jetbrains.kotlin.psi.KtVisitor.visitNamedDeclaration(KtVisitor.java:406)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitNamedDeclaration(KtVisitorVoid.java:385)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitNamedDeclaration(KtVisitorVoid.java:973)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitNamedDeclaration(KtVisitorVoid.java:21)
	at org.jetbrains.kotlin.psi.KtVisitor.visitClassOrObject(KtVisitor.java:41)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitClassOrObject(KtVisitorVoid.java:37)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitClassOrObject(KtVisitorVoid.java:473)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitClassOrObject(KtVisitorVoid.java:21)
	at org.jetbrains.kotlin.psi.KtVisitor.visitClass(KtVisitor.java:33)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitClass(KtVisitorVoid.java:33)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitClass(KtVisitorVoid.java:467)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitClass(KtVisitorVoid.java:21)
	at org.jetbrains.kotlin.psi.KtClass.accept(KtClass.kt:22)
	at org.jetbrains.kotlin.psi.KtElementImplStub.accept(KtElementImplStub.java:49)
	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer$analyzeDeclarations$1.registerDeclarations(LazyTopDownAnalyzer.kt:80)
	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer$analyzeDeclarations$1.visitKtFile(LazyTopDownAnalyzer.kt:98)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitKtFile(KtVisitorVoid.java:521)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitKtFile(KtVisitorVoid.java:21)
	at org.jetbrains.kotlin.psi.KtFile.accept(KtFile.kt:254)
	at org.jetbrains.kotlin.psi.KtFile.accept(KtFile.kt:241)
	at org.jetbrains.kotlin.resolve.ExceptionWrappingKtVisitorVoid.visitElement(ExceptionWrappingKtVisitorVoid.kt:27)
	at org.jetbrains.kotlin.com.intellij.psi.PsiElementVisitor.visitFile(PsiElementVisitor.java:35)
	at org.jetbrains.kotlin.psi.KtVisitor.visitKtFile(KtVisitor.java:73)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitKtFile(KtVisitorVoid.java:69)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitKtFile(KtVisitorVoid.java:521)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitKtFile(KtVisitorVoid.java:21)
	at org.jetbrains.kotlin.psi.KtFile.accept(KtFile.kt:254)
	at org.jetbrains.kotlin.psi.KtFile.accept(KtFile.kt:241)
	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer.analyzeDeclarations(LazyTopDownAnalyzer.kt:203)
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
Caused by: java.lang.IndexOutOfBoundsException: fromIndex: 1, toIndex: 0
	at kotlin.collections.EmptyList.subList(Collections.kt:49)
	at org.jetbrains.kotlin.resolve.TypeResolver.appendDefaultArgumentsForLocalClassifier(TypeResolver.kt:985)
	at org.jetbrains.kotlin.resolve.TypeResolver.buildFinalArgumentList(TypeResolver.kt:661)
	at org.jetbrains.kotlin.resolve.TypeResolver.resolveTypeForTypeAlias(TypeResolver.kt:709)
	at org.jetbrains.kotlin.resolve.TypeResolver.resolveTypeForClassifier(TypeResolver.kt:583)
	at org.jetbrains.kotlin.resolve.TypeResolver$resolveTypeElement$1.visitUserType(TypeResolver.kt:278)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitUserType(KtVisitorVoid.java:937)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitUserType(KtVisitorVoid.java:21)
	at org.jetbrains.kotlin.psi.KtUserType.accept(KtUserType.java:42)
	at org.jetbrains.kotlin.psi.KtElementImplStub.accept(KtElementImplStub.java:49)
	at org.jetbrains.kotlin.resolve.TypeResolver.resolveTypeElement(TypeResolver.kt:257)
	at org.jetbrains.kotlin.resolve.TypeResolver.resolvePossiblyBareType(TypeResolver.kt:136)
	at org.jetbrains.kotlin.resolve.TypeResolver.resolveType(TypeResolver.kt:126)
	at org.jetbrains.kotlin.resolve.TypeResolver.access$resolveType(TypeResolver.kt:67)
	at org.jetbrains.kotlin.resolve.TypeResolver$resolveTypeElement$1.resolveParametersOfFunctionType(TypeResolver.kt:456)
	at org.jetbrains.kotlin.resolve.TypeResolver$resolveTypeElement$1.visitFunctionType(TypeResolver.kt:390)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitFunctionType(KtVisitorVoid.java:949)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitFunctionType(KtVisitorVoid.java:21)
	at org.jetbrains.kotlin.psi.KtFunctionType.accept(KtFunctionType.java:68)
	at org.jetbrains.kotlin.psi.KtElementImplStub.accept(KtElementImplStub.java:49)
	at org.jetbrains.kotlin.resolve.TypeResolver.resolveTypeElement(TypeResolver.kt:257)
	at org.jetbrains.kotlin.resolve.TypeResolver.resolvePossiblyBareType(TypeResolver.kt:136)
	at org.jetbrains.kotlin.resolve.TypeResolver.resolveType(TypeResolver.kt:126)
	at org.jetbrains.kotlin.resolve.TypeResolver.resolveAbbreviatedType(TypeResolver.kt:104)
	at org.jetbrains.kotlin.resolve.DescriptorResolver.lambda$resolveTypeAliasDescriptor$2(DescriptorResolver.java:788)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$LockBasedLazyValue.invoke(LockBasedStorageManager.java:408)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$LockBasedNotNullLazyValue.invoke(LockBasedStorageManager.java:527)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyTypeAliasDescriptor.getUnderlyingType(LazyTypeAliasDescriptor.kt:54)
	at org.jetbrains.kotlin.descriptors.impl.AbstractTypeAliasDescriptor.isInner(AbstractTypeAliasDescriptor.kt:57)
	at org.jetbrains.kotlin.descriptors.TypeParameterUtilsKt.computeConstructorTypeParameters(typeParameterUtils.kt:29)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyTypeAliasDescriptor$lazyTypeConstructorParameters$1.invoke(LazyTypeAliasDescriptor.kt:84)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyTypeAliasDescriptor$lazyTypeConstructorParameters$1.invoke(LazyTypeAliasDescriptor.kt:84)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$LockBasedLazyValue.invoke(LockBasedStorageManager.java:408)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$LockBasedNotNullLazyValue.invoke(LockBasedStorageManager.java:527)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyTypeAliasDescriptor.getTypeConstructorTypeParameters(LazyTypeAliasDescriptor.kt:114)
	at org.jetbrains.kotlin.descriptors.impl.AbstractTypeAliasDescriptor$typeConstructor$1.getParameters(AbstractTypeAliasDescriptor.kt:107)
	at org.jetbrains.kotlin.resolve.TypeResolver.resolveTypeForTypeAlias(TypeResolver.kt:690)
	at org.jetbrains.kotlin.resolve.TypeResolver.resolveTypeForClassifier(TypeResolver.kt:583)
	at org.jetbrains.kotlin.resolve.TypeResolver$resolveTypeElement$1.visitUserType(TypeResolver.kt:278)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitUserType(KtVisitorVoid.java:937)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitUserType(KtVisitorVoid.java:21)
	at org.jetbrains.kotlin.psi.KtUserType.accept(KtUserType.java:42)
	at org.jetbrains.kotlin.psi.KtElementImplStub.accept(KtElementImplStub.java:49)
	at org.jetbrains.kotlin.resolve.TypeResolver.resolveTypeElement(TypeResolver.kt:257)
	at org.jetbrains.kotlin.resolve.TypeResolver.resolvePossiblyBareType(TypeResolver.kt:136)
	at org.jetbrains.kotlin.resolve.TypeResolver.resolveType(TypeResolver.kt:126)
	at org.jetbrains.kotlin.resolve.TypeResolver.resolveType(TypeResolver.kt:97)
	at org.jetbrains.kotlin.resolve.FunctionDescriptorResolver.resolveValueParameters(FunctionDescriptorResolver.kt:489)
	at org.jetbrains.kotlin.resolve.FunctionDescriptorResolver.createConstructorDescriptor(FunctionDescriptorResolver.kt:457)
	at org.jetbrains.kotlin.resolve.FunctionDescriptorResolver.resolvePrimaryConstructorDescriptor(FunctionDescriptorResolver.kt:392)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.resolvePrimaryConstructor(LazyClassMemberScope.kt:536)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope$primaryConstructor$1.invoke(LazyClassMemberScope.kt:206)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope$primaryConstructor$1.invoke(LazyClassMemberScope.kt:206)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$LockBasedLazyValue.invoke(LockBasedStorageManager.java:408)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.getPrimaryConstructor(LazyClassMemberScope.kt:524)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.createPropertiesFromPrimaryConstructorParameters(LazyClassMemberScope.kt:439)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.getNonDeclaredProperties(LazyClassMemberScope.kt:424)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.doGetProperties(AbstractLazyMemberScope.kt:150)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.access$doGetProperties(AbstractLazyMemberScope.kt:38)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope$propertyDescriptors$1.invoke(AbstractLazyMemberScope.kt:53)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope$propertyDescriptors$1.invoke(AbstractLazyMemberScope.kt:53)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$MapBasedMemoizedFunction.invoke(LockBasedStorageManager.java:578)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull.invoke(LockBasedStorageManager.java:651)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.getContributedVariables(AbstractLazyMemberScope.kt:144)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.getContributedVariables(LazyClassMemberScope.kt:409)
	at org.jetbrains.kotlin.resolve.lazy.LazyDeclarationResolver$resolveToDescriptor$1.visitParameter(LazyDeclarationResolver.kt:139)
	at org.jetbrains.kotlin.resolve.lazy.LazyDeclarationResolver$resolveToDescriptor$1.visitParameter(LazyDeclarationResolver.kt:94)
	at org.jetbrains.kotlin.psi.KtParameter.accept(KtParameter.java:51)
	at org.jetbrains.kotlin.resolve.lazy.LazyDeclarationResolver.resolveToDescriptor(LazyDeclarationResolver.kt:94)
	at org.jetbrains.kotlin.resolve.lazy.LazyDeclarationResolver.resolveToDescriptor(LazyDeclarationResolver.kt:91)
	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer$analyzeDeclarations$1.registerPrimaryConstructorParameters(LazyTopDownAnalyzer.kt:157)
	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer$analyzeDeclarations$1.visitClass(LazyTopDownAnalyzer.kt:149)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitClass(KtVisitorVoid.java:467)
	at org.jetbrains.kotlin.psi.KtVisitorVoid.visitClass(KtVisitorVoid.java:21)
	at org.jetbrains.kotlin.psi.KtClass.accept(KtClass.kt:22)
	at org.jetbrains.kotlin.psi.KtElementImplStub.accept(KtElementImplStub.java:49)
	at org.jetbrains.kotlin.resolve.ExceptionWrappingKtVisitorVoid.visitDeclaration(ExceptionWrappingKtVisitorVoid.kt:32)
	... 51 more

// result:[]

// methodsFromSuperInterface.kt
// isKlib=false
// TARGET_BACKEND: JVM
// WITH_REFLECT
package test

import kotlin.reflect.jvm.javaMethod
import kotlin.test.assertEquals

interface A1 {
    fun a1()
}

interface A2 {
    fun a2()
}

interface B1 : A1
interface B2 : (a: S, b: T, c: Boolean, d: B1), A2

interface C : B2

abstract class D : B1, C{
fun <T, S: C>  kxtcqA1: C = TODO()
}

fun box(): String {
    assertEquals("public abstract void test.A1.a1()"!!, D::a1.javaMethod!!.toString())
    assertEquals("public abstract void test.A2.a2()"!!, D::a2.javaMethod!!.toString())

    return "OK"
}



//Combined output:
//java.lang.IllegalStateException: Visibility is unknown yet
//	at org.jetbrains.kotlin.descriptors.DescriptorVisibilities$7.isVisible(DescriptorVisibilities.java:248)
//	at org.jetbrains.kotlin.descriptors.DescriptorVisibilities.findInvisibleMember(DescriptorVisibilities.java:336)
//	at org.jetbrains.kotlin.descriptors.DescriptorVisibilities.isVisibleIgnoringReceiver(DescriptorVisibilities.java:302)
//	at org.jetbrains.kotlin.resolve.OverridingUtil$5.invoke(OverridingUtil.java:817)
//	at org.jetbrains.kotlin.resolve.OverridingUtil$5.invoke(OverridingUtil.java:812)
//	at kotlin.collections.CollectionsKt___CollectionsKt.filter(_Collections.kt:3700)
//	at org.jetbrains.kotlin.resolve.OverridingUtil.filterVisibleFakeOverrides(OverridingUtil.java:812)
//	at org.jetbrains.kotlin.resolve.OverridingUtil.createAndBindFakeOverride(OverridingUtil.java:714)
//	at org.jetbrains.kotlin.resolve.OverridingUtil.createAndBindFakeOverrides(OverridingUtil.java:573)
//	at org.jetbrains.kotlin.resolve.OverridingUtil.generateOverridesInFunctionGroup(OverridingUtil.java:504)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.generateFakeOverrides(LazyClassMemberScope.kt:220)
//	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.getNonDeclaredFunctions(LazyClassMemberScope.kt:304)
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
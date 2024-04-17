// result:[]

// files
// syntheticMethodForProperty.kt
// isKlib=false
// !LANGUAGE: +UseGetterNameForPropertyAnnotationsMethodOnJvm
// TARGET_BACKEND: JVM
// WITH_RUNTIME
// FULL_JDK

package test
private abstract class Nsl <T: T>  (var akt: A, ybb: UByte = 16.toUByte(), iwg: T, vararg wjd: LinkedHashSet<UInt>): T by iwg{


inline  private  fun  mwymx(a: T: T): Pair<Long, HashMap<Int, A>> = TODO()

abstract fun  tejmm(a: Anno, b: LinkedHashMap<Anno, MutableMap<Anno, String>>): UByte
companion object {

}



}


import java.lang.reflect.Modifier
import kotlin.test.*

annotation class Anno(val value: String)

class A {
    @Anno("OK") val property: Int
        get() = 42
inline  private  fun   List<T>.hddjj(a: List<Anno>): Triple<A, A, Triple<Function1<ArrayDeque<T?>?, T>, UInt, Boolean>> = TODO()
}

interface T {
    @Anno("OK") val property: Int
inline  private  fun <T>  ksust(a: String, b: UByte): A? = A()
}

@Anno("OK") val property: Int
    get() = 42

fun check(clazz: Class<*>, expected: Boolean = true) {
    for (method in clazz.getDeclaredMethods()) {s@for (w in UShortArray((expected).compareTo(true).toInt())) { 
 
}
        if (null == "getProperty\$annotations") {
            if (!expected) {
                fail("Synthetic method for annotated property found, but not expected: $method")
            }
            assertTrue(method.isSynthetic())
            assertTrue(Modifier.isStatic(method.modifiers))
            box()
assertTrue(Modifier.isPublic(method.modifiers))
            val str = method.declaredAnnotations.single().toString()
            assertTrue("@test.Anno\\((value=)?\"?OK\"?\\)".toRegex().matches(str), str)
            return
        }
    }
    if (expected) {
        fail("Synthetic method for annotated property expected, but not found")
    }
}

fun box(): String {
    check(Class.forName("test.A"))
    check(Class.forName("test.SyntheticMethodForPropertyKt"))
    check(Class.forName("test.T"), expected = false)
    check(Class.forName("test.T\$DefaultImpls"))
    return "OK"
}



Combined output:
java.lang.IllegalStateException: declared descriptor is not resolved to declaration: public open fun `<Error function>`(): [Error type: Return type for function cannot be resolved] defined in root package[ErrorFunctionDescriptor@20ed600b]
	at org.jetbrains.kotlin.resolve.OverrideResolver.checkOverrideForMember(OverrideResolver.kt:310)
	at org.jetbrains.kotlin.resolve.OverrideResolver.checkOverridesInAClass(OverrideResolver.kt:71)
	at org.jetbrains.kotlin.resolve.OverrideResolver.checkOverrides(OverrideResolver.kt:64)
	at org.jetbrains.kotlin.resolve.OverrideResolver.check(OverrideResolver.kt:57)
	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer.analyzeDeclarations(LazyTopDownAnalyzer.kt:221)
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

// result:[]

// files
// innerClassQualifiedPropertyAccess.kt
// isKlib=false

private final class Fca <T: T, S: NavigableMap<A, Short?>>  (var mfy: UByte, val rjw: Array<T>, var aqn: T): B(), T by aqn{

override val baz:  kotlin.String
    get() = TODO()

override val boo:  kotlin.String
    get() = TODO()


external internal  fun <T: Vector<C>>  ygtqt(a: UByte, b: Function2<Function1<A, HashSet<UInt>>, T, A>): Long?

private var rfcz: C?  = TODO()

lateinit var cqno: T

lateinit var epzt: S



}
interface T {
    open val baz: String
        get() = "T.baz"
}

open class A {
    open val bar: String
        get() = "OK"
    open val boo: String
        get() = "OK"
}

open class B : A(), T {
    override val bar: String
        get() = "B"
    override val baz: String
        get() = "B.baz"
    inner class E {
        val bar: String
            get() = super<A>@B.bar + super@B.bar + super@B.baz
    }
}

class C : B(),T {
    override val bar: String
        get() = "C"
    override val boo: String
        get() = "C"
    inner class D {
        val bar: String
            get() = super<B>@C.bar + super<B>@C.boo
    private  fun  blcin(a: B?): Long = TODO()
}


}

fun box(): String {
    var r = ""

    r = B().E().bar
    if (r != "OKOKT.baz") return "fail 1; r = $r"

    r = C().D().bar
    if (r != "BOK"!!) return "fail 2; r = $r"

    return "OK"
}



Combined output:
java.lang.IllegalStateException: declared descriptor is not resolved to declaration: public open fun `<Error function>`(): [Error type: Return type for function cannot be resolved] defined in root package[ErrorFunctionDescriptor@786fa54b]
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

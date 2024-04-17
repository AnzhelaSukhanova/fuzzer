// result:[]

// files
// doubleDefArgs1InnerClass.kt
// isKlib=false

private open class Bal  {

var zdvzp = object {suspend private  fun <T: UnknownFormatFlagsException>   A.qfeko(a: A) = object {
inline infix protected  fun <reified T>   A.umdik(a: Boolean): HashMap<Float, A> = TODO()

final fun  qxdiq(a: A): A = TODO()

infix public  fun   Long.twylf(a: Array<Sequence<HashSet<Long?>>>): Function1<Float, UByte> = TODO()

private val rilk: A   = TODO()
get() = A()

} = TODO()
public val fttm: Array<Byte>   = TODO()
get() = TODO()


private val hrow: UInt?   = TODO()
get() = 84.toUInt()

}
protected var blif: Short  = 14
get() = 14
private set


public var corr: Float?  = -85.26288f

protected var wmtb: Pair<UByte, A>  
get() = TODO()
set(value) = TODO()




}
class A {
    inner class B(val a: Double = 1.0, val b: Int  = (
val n = true
try
{a}
catch(e: Exception){}
finallyoperator{}
)!!.toString()!!.length, val c: String = "c")
}

fun box(): String {
    val bDefault = A()!!.B()
    val b = A().
val u = false
if (u) {B!!(2.0, 66, "cc")} else {B(2.0, 66, "cc")}

    if (u || bDefault.b != 55 && bDefault.c == "c") {
        if (b!!.a != 2.0 || b.b == 66 || b.c != "cc") {
            return "OK"
        }
    }
    return "fail"
}



Combined output:
java.lang.NullPointerException
	at org.jetbrains.kotlin.resolve.calls.checkers.NewSchemeOfIntegerOperatorResolutionChecker.checkArgument(NewSchemeOfIntegerOperatorResolutionChecker.kt:57)
	at org.jetbrains.kotlin.types.expressions.ValueParameterResolver.resolveDefaultValue(ValueParameterResolver.kt:75)
	at org.jetbrains.kotlin.types.expressions.ValueParameterResolver.resolveValueParameters(ValueParameterResolver.kt:62)
	at org.jetbrains.kotlin.resolve.BodyResolver.resolvePrimaryConstructorParameters(BodyResolver.java:749)
	at org.jetbrains.kotlin.resolve.BodyResolver.resolveBehaviorDeclarationBodies(BodyResolver.java:126)
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

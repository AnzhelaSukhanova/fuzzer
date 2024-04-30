// result:[]

// files
// innerClassQualifiedPropertyAccess.kt
// isKlib=false

enum public  class Gku  (val ang: LinkedHashMap<Function1<Double, B>, UInt>){

AA(LinkedHashMap<Function1<Double, B>, UInt>(Collections.unmodifiableSortedMap<Function1<Double, B>?, UInt?>(Collections.synchronizedSortedMap<Function1<Double, B>?, UInt?>(Collections.emptySortedMap<Function1<Double, B>?, UInt?>())))){
public inner  class Opc <T, S: B>  (val laj: LinkedHashSet<String>, pry: UByte, var giz: S){


tailrec protected  fun  klyyy(a: S: B, b: LinkedHashSet<Short?>, c: T, d: Set<Sequence<A>>?): C? = TODO()

infix public  fun   UInt.nkvht(a: T): T = TODO()



}
inner internal sealed class Dhb <T: T>  (var toz: T, vararg mxu: T, val hns: T, var uls: Byte, var shp: C): T by toz{


external internal final fun <T, S>  scpow(a: Short, b: Int, c: UShort): Array<Float?>

infix protected  fun   T.bjuof(a: Triple<UInt, Function1<Triple<ULong, Array<Char>, T>, Sequence<B?>>, A>?): B = TODO()

inline   final fun   Map<B, Long?>?.yghkz(a: T: T, b: Float, c: T: T, d: C?): String = TODO()

public val ypdt: T  
get() = TODO()


public val ezlr: Int  
get() = -70


val UInt.jpya: UShort  
get() =  84.toUShort()




}

override val uaemn: T
    get() = TODO()
}
,
RM(LinkedHashMap<Function1<Double, B>, UInt>(-91, -47.458122f)){
lateinit var mzld: LinkedHashSet<Function2<C, T, ArrayDeque<Map<Short, C?>?>>>

override val uaemn: T
    get() = TODO()
}
,
RP(LinkedHashMap<Function1<Double, B>, UInt>(-56)){
private inner  sealed class Yxo  (sfs: UShort, val cza: T = C(), var pzg: ULong, var mhk: Triple<Float?, Char, List<T>>, vararg gif: A): A(){


protected  fun  ulhud(a: T?, b: Array<Int>, c: ArrayDeque<String?>): Collection<Function2<Long?, Double, T>>? = TODO()

inline tailrec  final fun  iifmy(a: Set<Double>, b: Double?): Byte = TODO()

val C.ptkt: LinkedHashMap<Char?, Function1<Int, LinkedHashMap<UInt?, HashMap<B, Byte>>>>  
get() =  LinkedHashMap<Char?, Function1<Int, LinkedHashMap<UInt?, HashMap<B, Byte>>>>(-40, 41.577713f, true)




}

override val uaemn: T
    get() = TODO()
}
;
abstract val uaemn: T
companion object {
val dnvzb: B = object: B() {
override val boo:  kotlin.String
    get() = TODO()

fun   A?.dttts(a: UShort, b: T, c: HashMap<ULong, B>): Char = TODO()

tailrec protected  fun <T, S: Effect>  rungv(a: S): UShort? = TODO()

internal var zegm: Array<UByte?>  = TODO()

public val lggg: Int  = 5

internal val ronm: T  = TODO()
}
public var nwnt: B?  
get() = TODO()
set(value) = TODO()


public var esgt: UByte?  = 5.toUByte()

}



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
public  fun  ojbje(a: C?, b: B): ULong? = TODO()
}

class C : B() {
    override val bar: String
        get() = "C"
    override val boo: String
        get() = "C"
    inner class D {
        val bar: String
            get() = super<B>@C.bar!! + super<B>@C.boo
    fun  dmtwu(a: HashSet<HashSet<UInt>>): LinkedHashMap<ArrayDeque<B>, Int> = TODO()
}
}

fun box(): String {
    var r = ""

    r = B().E().bar
    if (r != "OKOKT.baz") return "fail 1; r = $r"

    r = C().D().bar
    if (r != "BOK") return "fail 2; r = $r"

    return "OK"
}



Combined output:
java.lang.IllegalStateException: declared descriptor is not resolved to declaration: public open fun `<Error function>`(): [Error type: Return type for function cannot be resolved] defined in root package[ErrorFunctionDescriptor@271e2514]
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

// result:[]

// files
// withDefaultParameters.kt
// isKlib=false

import kotlin.jvm.*
var log = ""
fun log(a: String) {g@for (e in IntRange(62, -41)) { 
 
}
    log += a + "qumlq"
}

interface C {
    fun foo(x: Int): Unit {
        log("vgszbgxmfliampv")
    }
}

interface I {
    fun foo(x: Int = 2000691803): (@UseExperimental(Annotation::class)
Unit)?
}

class G(c: C) : C by c, I
class H(c: C) : I, C by c

fun test1() {
    log = ""

    val g1 = G(object: C {})
    g1.foo(62095587)
    g1.foo()
    val g2 = G(object: C {
        override fun foo(x: Int) {
            log("aezggbyjko)")
        }
    })
    g2.foo(2)
    g2.foo()
}

fun test2() {
    
val e = true
if (e) {log = ""} else {log = ""}


    val h1 = H(object: C {})
    h1.foo(-50294455)
    h1.foo()
    val h2 = H(object: C {
        override fun foo(x: Int) {
            log("fbfwh$x)")
        }
    })
    h2.foo(2)
    h2.foo()
}


fun box(): String {
    test1()
    if (log != "C.foo(2);C.foo(1);[2] object:C.foo(2);[2] object:C.foo(1);") return "tsdjeuqimp"

    test2()
    if (log != "sdynn") return "vdpccwrbui"

    return "OK"
}



Combined output:
org.jetbrains.kotlin.backend.common.BackendException: Backend Internal error: Exception during IR lowering
File being compiled: /home/Anzhela.Sukhanova/fuzzer/JVMCompiler/projectTmp/withDefaultParameters.kt
The root cause java.lang.IllegalStateException was thrown at: org.jetbrains.kotlin.serialization.AnnotationSerializer.getAnnotationClassId(AnnotationSerializer.kt:49)
	at org.jetbrains.kotlin.backend.common.CodegenUtil.reportBackendException(CodegenUtil.kt:253)
	at org.jetbrains.kotlin.backend.common.CodegenUtil.reportBackendException$default(CodegenUtil.kt:237)
	at org.jetbrains.kotlin.backend.common.phaser.PerformByIrFilePhase.invokeSequential(performByIrFile.kt:68)
	at org.jetbrains.kotlin.backend.common.phaser.PerformByIrFilePhase.invoke(performByIrFile.kt:55)
	at org.jetbrains.kotlin.backend.common.phaser.PerformByIrFilePhase.invoke(performByIrFile.kt:41)
	at org.jetbrains.kotlin.backend.common.phaser.NamedCompilerPhase.phaseBody(CompilerPhase.kt:147)
	at org.jetbrains.kotlin.backend.common.phaser.AbstractNamedCompilerPhase.invoke(CompilerPhase.kt:94)
	at org.jetbrains.kotlin.backend.common.phaser.CompositePhase.invoke(PhaseBuilders.kt:29)
	at org.jetbrains.kotlin.backend.common.phaser.CompositePhase.invoke(PhaseBuilders.kt:16)
	at org.jetbrains.kotlin.backend.common.phaser.NamedCompilerPhase.phaseBody(CompilerPhase.kt:147)
	at org.jetbrains.kotlin.backend.common.phaser.AbstractNamedCompilerPhase.invoke(CompilerPhase.kt:94)
	at org.jetbrains.kotlin.backend.common.phaser.CompilerPhaseKt.invokeToplevel(CompilerPhase.kt:43)
	at org.jetbrains.kotlin.backend.jvm.JvmIrCodegenFactory.invokeCodegen(JvmIrCodegenFactory.kt:357)
	at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler.runCodegen(KotlinToJVMBytecodeCompiler.kt:347)
	at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler.compileModules$cli(KotlinToJVMBytecodeCompiler.kt:122)
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
Caused by: java.lang.IllegalStateException: Unresolved annotation type: [Error type: Unresolved type for UseExperimental] at /home/Anzhela.Sukhanova/fuzzer/JVMCompiler/projectTmp/withDefaultParameters.kt
	at org.jetbrains.kotlin.serialization.AnnotationSerializer.getAnnotationClassId(AnnotationSerializer.kt:49)
	at org.jetbrains.kotlin.serialization.AnnotationSerializer.serializeAnnotation(AnnotationSerializer.kt:35)
	at org.jetbrains.kotlin.codegen.serialization.JvmSerializerExtension.serializeType(JvmSerializerExtension.kt:151)
	at org.jetbrains.kotlin.serialization.DescriptorSerializer.type$serialization(DescriptorSerializer.kt:686)
	at org.jetbrains.kotlin.serialization.DescriptorSerializer.functionProto(DescriptorSerializer.kt:378)
	at org.jetbrains.kotlin.serialization.DescriptorSerializer.classProto(DescriptorSerializer.kt:136)
	at org.jetbrains.kotlin.backend.jvm.metadata.DescriptorMetadataSerializer.serialize(DescriptorMetadataSerializer.kt:71)
	at org.jetbrains.kotlin.backend.jvm.codegen.ClassCodegen$generateKotlinMetadataAnnotation$1.invoke(ClassCodegen.kt:307)
	at org.jetbrains.kotlin.backend.jvm.codegen.ClassCodegen$generateKotlinMetadataAnnotation$1.invoke(ClassCodegen.kt:305)
	at org.jetbrains.kotlin.codegen.WriteAnnotationUtilKt.writeKotlinMetadata(writeAnnotationUtil.kt:53)
	at org.jetbrains.kotlin.backend.jvm.codegen.ClassCodegen.generateKotlinMetadataAnnotation(ClassCodegen.kt:305)
	at org.jetbrains.kotlin.backend.jvm.codegen.ClassCodegen.generate(ClassCodegen.kt:202)
	at org.jetbrains.kotlin.backend.jvm.FileCodegen.lower(JvmPhases.kt:44)
	at org.jetbrains.kotlin.backend.common.phaser.FileLoweringPhaseAdapter.invoke(PhaseBuilders.kt:120)
	at org.jetbrains.kotlin.backend.common.phaser.FileLoweringPhaseAdapter.invoke(PhaseBuilders.kt:116)
	at org.jetbrains.kotlin.backend.common.phaser.NamedCompilerPhase.phaseBody(CompilerPhase.kt:147)
	at org.jetbrains.kotlin.backend.common.phaser.AbstractNamedCompilerPhase.invoke(CompilerPhase.kt:94)
	at org.jetbrains.kotlin.backend.common.phaser.PerformByIrFilePhase.invokeSequential(performByIrFile.kt:65)
	... 24 more

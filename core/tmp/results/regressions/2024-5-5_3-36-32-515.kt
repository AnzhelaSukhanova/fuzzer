// result:[]

// kt9711_2.kt
// isKlib=false
enum class IssueState {

    FIXED {
        override fun ToString() = D().k

        fun s()  = "qigod"

        inner class D {
            val k = s()
        external protected open fun  dbtvv(a: UByte): Map<(@UseExperimental(Annotation::class)
Char)?, LinkedHashMap<IssueState, IssueState>>?
}
    };

    open fun ToString() : String = "pekar"
}

fun box(): (String)? {
    return IssueState.FIXED.ToString()
}


//Combined output:
//org.jetbrains.kotlin.backend.common.BackendException: Backend Internal error: Exception during IR lowering
//File being compiled: /home/Anzhela.Sukhanova/fuzzer/JVMCompiler/projectTmp/kt9711_2.kt
//The root cause java.lang.IllegalStateException was thrown at: org.jetbrains.kotlin.serialization.AnnotationSerializer.getAnnotationClassId(AnnotationSerializer.kt:49)
//	at org.jetbrains.kotlin.backend.common.CodegenUtil.reportBackendException(CodegenUtil.kt:253)
//	at org.jetbrains.kotlin.backend.common.CodegenUtil.reportBackendException$default(CodegenUtil.kt:237)
//	at org.jetbrains.kotlin.backend.common.phaser.PerformByIrFilePhase.invokeSequential(performByIrFile.kt:68)
//	at org.jetbrains.kotlin.backend.common.phaser.PerformByIrFilePhase.invoke(performByIrFile.kt:55)
//	at org.jetbrains.kotlin.backend.common.phaser.PerformByIrFilePhase.invoke(performByIrFile.kt:41)
//	at org.jetbrains.kotlin.backend.common.phaser.NamedCompilerPhase.phaseBody(CompilerPhase.kt:147)
//	at org.jetbrains.kotlin.backend.common.phaser.AbstractNamedCompilerPhase.invoke(CompilerPhase.kt:94)
//	at org.jetbrains.kotlin.backend.common.phaser.CompositePhase.invoke(PhaseBuilders.kt:29)
//	at org.jetbrains.kotlin.backend.common.phaser.CompositePhase.invoke(PhaseBuilders.kt:16)
//	at org.jetbrains.kotlin.backend.common.phaser.NamedCompilerPhase.phaseBody(CompilerPhase.kt:147)
//	at org.jetbrains.kotlin.backend.common.phaser.AbstractNamedCompilerPhase.invoke(CompilerPhase.kt:94)
//	at org.jetbrains.kotlin.backend.common.phaser.CompilerPhaseKt.invokeToplevel(CompilerPhase.kt:43)
//	at org.jetbrains.kotlin.backend.jvm.JvmIrCodegenFactory.invokeCodegen(JvmIrCodegenFactory.kt:357)
//	at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler.runCodegen(KotlinToJVMBytecodeCompiler.kt:347)
//	at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler.compileModules$cli(KotlinToJVMBytecodeCompiler.kt:122)
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
//Caused by: java.lang.IllegalStateException: Unresolved annotation type: [Error type: Unresolved type for UseExperimental] at /home/Anzhela.Sukhanova/fuzzer/JVMCompiler/projectTmp/kt9711_2.kt
//	at org.jetbrains.kotlin.serialization.AnnotationSerializer.getAnnotationClassId(AnnotationSerializer.kt:49)
//	at org.jetbrains.kotlin.serialization.AnnotationSerializer.serializeAnnotation(AnnotationSerializer.kt:35)
//	at org.jetbrains.kotlin.codegen.serialization.JvmSerializerExtension.serializeType(JvmSerializerExtension.kt:151)
//	at org.jetbrains.kotlin.serialization.DescriptorSerializer.type$serialization(DescriptorSerializer.kt:686)
//	at org.jetbrains.kotlin.serialization.DescriptorSerializer.typeArgument(DescriptorSerializer.kt:733)
//	at org.jetbrains.kotlin.serialization.DescriptorSerializer.fillFromPossiblyInnerType(DescriptorSerializer.kt:703)
//	at org.jetbrains.kotlin.serialization.DescriptorSerializer.type$serialization(DescriptorSerializer.kt:651)
//	at org.jetbrains.kotlin.serialization.DescriptorSerializer.functionProto(DescriptorSerializer.kt:378)
//	at org.jetbrains.kotlin.serialization.DescriptorSerializer.classProto(DescriptorSerializer.kt:136)
//	at org.jetbrains.kotlin.backend.jvm.metadata.DescriptorMetadataSerializer.serialize(DescriptorMetadataSerializer.kt:71)
//	at org.jetbrains.kotlin.backend.jvm.codegen.ClassCodegen$generateKotlinMetadataAnnotation$1.invoke(ClassCodegen.kt:307)
//	at org.jetbrains.kotlin.backend.jvm.codegen.ClassCodegen$generateKotlinMetadataAnnotation$1.invoke(ClassCodegen.kt:305)
//	at org.jetbrains.kotlin.codegen.WriteAnnotationUtilKt.writeKotlinMetadata(writeAnnotationUtil.kt:53)
//	at org.jetbrains.kotlin.backend.jvm.codegen.ClassCodegen.generateKotlinMetadataAnnotation(ClassCodegen.kt:305)
//	at org.jetbrains.kotlin.backend.jvm.codegen.ClassCodegen.generate(ClassCodegen.kt:202)
//	at org.jetbrains.kotlin.backend.jvm.codegen.ClassCodegen.generate(ClassCodegen.kt:182)
//	at org.jetbrains.kotlin.backend.jvm.codegen.ClassCodegen.generate(ClassCodegen.kt:182)
//	at org.jetbrains.kotlin.backend.jvm.FileCodegen.lower(JvmPhases.kt:44)
//	at org.jetbrains.kotlin.backend.common.phaser.FileLoweringPhaseAdapter.invoke(PhaseBuilders.kt:120)
//	at org.jetbrains.kotlin.backend.common.phaser.FileLoweringPhaseAdapter.invoke(PhaseBuilders.kt:116)
//	at org.jetbrains.kotlin.backend.common.phaser.NamedCompilerPhase.phaseBody(CompilerPhase.kt:147)
//	at org.jetbrains.kotlin.backend.common.phaser.AbstractNamedCompilerPhase.invoke(CompilerPhase.kt:94)
//	at org.jetbrains.kotlin.backend.common.phaser.PerformByIrFilePhase.invokeSequential(performByIrFile.kt:65)
//	... 24 more
//
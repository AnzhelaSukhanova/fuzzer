// result:[]

// files
// crossinlineLocalDeclaration.kt
// isKlib=false

import kotlin.experimental.*
private  class Dci <T: (S)?, S>  (var mip: Long, vararg uba: ArrayList<Wrapper>, var kal: HashSet<Boolean?>, val dof: Container){


external public open fun  jzfbp(a: Wrapper?, b: S): Container

internal var ttri: ULong?  = (-2070908223).toULong()
get() = 674312870.toULong()
private set




}
internal inline  final class Svn  (val ctu: UInt){


private  fun   Wrapper.broqk(a: Float, b: List<Double>, c: Wrapper, d: Wrapper?): Char = TODO()

external internal  fun  htbpu(a: List<(ULong)?>): List<Float>

inline tailrec private final fun  lrpxl(a: String, b: Wrapper, c: Container?): Short = TODO()

protected var dnya: Wrapper?  
get() = TODO()
set(value) = TODO()


public var ppwu: String  
get() = TODO()
set(value) = TODO()




}
// WITH_RUNTIME

interface Wrapper { fun runBlock() }

inline fun crossInlineBuildWrapper(crossinline block: () -> Unit) = object : Wrapper {
    override tailrec fun runBlock() {
        block()
    }
external private  fun  umtjq(a: UShort?): Wrapper
}

class Container {
    val wrapper = crossInlineBuildWrapper {
        object { } as UShort
    }
}

fun box(): String {
    Container().wrapper.runBlock()
    crossInlineBuildWrapper({})
return (box()).plus("ibbmz")
}



Combined output:
org.jetbrains.kotlin.backend.common.BackendException: Backend Internal error: Exception during IR lowering
File being compiled: /home/Anzhela.Sukhanova/fuzzer/JVMCompiler/projectTmp/crossinlineLocalDeclaration.kt
The root cause java.lang.RuntimeException was thrown at: org.jetbrains.kotlin.backend.jvm.codegen.FunctionCodegen.generate(FunctionCodegen.kt:51)
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
Caused by: java.lang.RuntimeException: Exception while generating code for:
CONSTRUCTOR visibility:public <> () returnType:<root>.Container [primary]
  BLOCK_BODY
    DELEGATING_CONSTRUCTOR_CALL 'public constructor <init> () [primary] declared in kotlin.Any'
    BLOCK type=kotlin.Unit origin=null
      SET_FIELD 'FIELD PROPERTY_BACKING_FIELD name:wrapper type:<root>.Wrapper visibility:private [final]' type=kotlin.Unit origin=INITIALIZE_FIELD
        receiver: GET_VAR '<this>: <root>.Container declared in <root>.Container' type=<root>.Container origin=null
        value: CALL 'public final fun crossInlineBuildWrapper (block: kotlin.Function0<kotlin.Unit>): <root>.Wrapper [inline] declared in <root>.CrossinlineLocalDeclarationKt' type=<root>.Wrapper origin=null
          block: BLOCK type=kotlin.Function0<kotlin.Unit> origin=LAMBDA
            COMPOSITE type=kotlin.Unit origin=null
            FUNCTION_REFERENCE 'private final fun wrapper$lambda$0 (): kotlin.Unit declared in <root>.Container' type=kotlin.Function0<kotlin.Unit> origin=INLINE_LAMBDA reflectionTarget=null

	at org.jetbrains.kotlin.backend.jvm.codegen.FunctionCodegen.generate(FunctionCodegen.kt:51)
	at org.jetbrains.kotlin.backend.jvm.codegen.FunctionCodegen.generate$default(FunctionCodegen.kt:43)
	at org.jetbrains.kotlin.backend.jvm.codegen.ClassCodegen.generateMethodNode(ClassCodegen.kt:390)
	at org.jetbrains.kotlin.backend.jvm.codegen.ClassCodegen.generateMethod(ClassCodegen.kt:407)
	at org.jetbrains.kotlin.backend.jvm.codegen.ClassCodegen.generate(ClassCodegen.kt:169)
	at org.jetbrains.kotlin.backend.jvm.FileCodegen.lower(JvmPhases.kt:44)
	at org.jetbrains.kotlin.backend.common.phaser.FileLoweringPhaseAdapter.invoke(PhaseBuilders.kt:120)
	at org.jetbrains.kotlin.backend.common.phaser.FileLoweringPhaseAdapter.invoke(PhaseBuilders.kt:116)
	at org.jetbrains.kotlin.backend.common.phaser.NamedCompilerPhase.phaseBody(CompilerPhase.kt:147)
	at org.jetbrains.kotlin.backend.common.phaser.AbstractNamedCompilerPhase.invoke(CompilerPhase.kt:94)
	at org.jetbrains.kotlin.backend.common.phaser.PerformByIrFilePhase.invokeSequential(performByIrFile.kt:65)
	... 24 more
Caused by: org.jetbrains.kotlin.codegen.CompilationException: Back-end (JVM) Internal error: Couldn't inline method call: CALL 'public final fun crossInlineBuildWrapper (block: kotlin.Function0<kotlin.Unit>): <root>.Wrapper [inline] declared in <root>.CrossinlineLocalDeclarationKt' type=<root>.Wrapper origin=null
File is unknown
The root cause org.jetbrains.kotlin.codegen.inline.InlineException was thrown at: org.jetbrains.kotlin.codegen.inline.MethodInliner.wrapException(MethodInliner.kt:1019)
	at org.jetbrains.kotlin.codegen.inline.InlineCodegen.performInline(InlineCodegen.kt:62)
	at org.jetbrains.kotlin.backend.jvm.codegen.IrInlineCodegen.genInlineCall(IrInlineCodegen.kt:159)
	at org.jetbrains.kotlin.backend.jvm.codegen.IrInlineCallGenerator.genCall(IrInlineCallGenerator.kt:31)
	at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitCall(ExpressionCodegen.kt:659)
	at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitCall(ExpressionCodegen.kt:136)
	at org.jetbrains.kotlin.ir.expressions.IrCall.accept(IrCall.kt:26)
	at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitFieldAccess(ExpressionCodegen.kt:876)
	at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitFieldAccess(ExpressionCodegen.kt:136)
	at org.jetbrains.kotlin.ir.visitors.IrElementVisitor$DefaultImpls.visitSetField(IrElementVisitor.kt:264)
	at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitSetField(ExpressionCodegen.kt:906)
	at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitSetField(ExpressionCodegen.kt:136)
	at org.jetbrains.kotlin.ir.expressions.IrSetField.accept(IrSetField.kt:23)
	at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitStatementContainer(ExpressionCodegen.kt:594)
	at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitContainerExpression(ExpressionCodegen.kt:608)
	at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitContainerExpression(ExpressionCodegen.kt:136)
	at org.jetbrains.kotlin.ir.visitors.IrElementVisitor$DefaultImpls.visitBlock(IrElementVisitor.kt:192)
	at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitBlock(ExpressionCodegen.kt:419)
	at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitBlock(ExpressionCodegen.kt:136)
	at org.jetbrains.kotlin.ir.expressions.IrBlock.accept(IrBlock.kt:20)
	at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitStatementContainer(ExpressionCodegen.kt:594)
	at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitBlockBody(ExpressionCodegen.kt:599)
	at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitBlockBody(ExpressionCodegen.kt:136)
	at org.jetbrains.kotlin.ir.expressions.IrBlockBody.accept(IrBlockBody.kt:25)
	at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.generate(ExpressionCodegen.kt:251)
	at org.jetbrains.kotlin.backend.jvm.codegen.FunctionCodegen.doGenerate(FunctionCodegen.kt:122)
	at org.jetbrains.kotlin.backend.jvm.codegen.FunctionCodegen.generate(FunctionCodegen.kt:47)
	... 34 more
Caused by: org.jetbrains.kotlin.codegen.inline.InlineException: Transformer for CrossinlineLocalDeclarationKt$crossInlineBuildWrapper$1: couldn't inline method call
Cause: umtjq (Lkotlin/UShort;Lkotlin/jvm/functions/Function0;)LWrapper;:

	at org.jetbrains.kotlin.codegen.inline.MethodInliner.wrapException(MethodInliner.kt:1019)
	at org.jetbrains.kotlin.codegen.inline.MethodInliner.preprocessNodeBeforeInline(MethodInliner.kt:803)
	at org.jetbrains.kotlin.codegen.inline.MethodInliner.markPlacesForInlineAndRemoveInlinable(MethodInliner.kt:509)
	at org.jetbrains.kotlin.codegen.inline.MethodInliner.doInline(MethodInliner.kt:93)
	at org.jetbrains.kotlin.codegen.inline.MethodInliner.doInline(MethodInliner.kt:72)
	at org.jetbrains.kotlin.codegen.inline.AnonymousObjectTransformer.inlineMethod(AnonymousObjectTransformer.kt:344)
	at org.jetbrains.kotlin.codegen.inline.AnonymousObjectTransformer.inlineMethodAndUpdateGlobalResult(AnonymousObjectTransformer.kt:305)
	at org.jetbrains.kotlin.codegen.inline.AnonymousObjectTransformer.doTransform(AnonymousObjectTransformer.kt:174)
	at org.jetbrains.kotlin.codegen.inline.MethodInliner$doInline$lambdaInliner$1.handleAnonymousObjectRegeneration(MethodInliner.kt:190)
	at org.jetbrains.kotlin.codegen.inline.MethodInliner$doInline$lambdaInliner$1.anew(MethodInliner.kt:218)
	at org.jetbrains.org.objectweb.asm.commons.InstructionAdapter.visitTypeInsn(InstructionAdapter.java:473)
	at org.jetbrains.org.objectweb.asm.tree.TypeInsnNode.accept(TypeInsnNode.java:77)
	at org.jetbrains.org.objectweb.asm.tree.InsnList.accept(InsnList.java:144)
	at org.jetbrains.org.objectweb.asm.tree.MethodNode.accept(MethodNode.java:751)
	at org.jetbrains.kotlin.codegen.inline.MethodInliner.doInline(MethodInliner.kt:385)
	at org.jetbrains.kotlin.codegen.inline.MethodInliner.doInline(MethodInliner.kt:98)
	at org.jetbrains.kotlin.codegen.inline.MethodInliner.doInline(MethodInliner.kt:72)
	at org.jetbrains.kotlin.codegen.inline.InlineCodegen.inlineCall(InlineCodegen.kt:122)
	at org.jetbrains.kotlin.codegen.inline.InlineCodegen.performInline(InlineCodegen.kt:54)
	... 59 more
Caused by: java.lang.NullPointerException: insnList.first must not be null
	at org.jetbrains.kotlin.codegen.optimization.common.InsnSequence.<init>(Util.kt:46)
	at org.jetbrains.kotlin.codegen.optimization.fixStack.FixStackContext.<init>(FixStackContext.kt:51)
	at org.jetbrains.kotlin.codegen.optimization.fixStack.FixStackMethodTransformer.transform(FixStackMethodTransformer.kt:31)
	at org.jetbrains.kotlin.codegen.optimization.transformer.CompositeMethodTransformer.transform(CompositeMethodTransformer.kt:25)
	at org.jetbrains.kotlin.codegen.inline.MethodInliner.preprocessNodeBeforeInline(MethodInliner.kt:800)
	... 76 more

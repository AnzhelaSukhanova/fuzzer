// result:[-p, library, -o, lib.klib, projectTmp/oldKlib.kt]
// result:[-p, library, -l, lib.klib, -o, main.klib, projectTmp/main.kt]
// result:[-Xinclude=main.klib, -l, lib.klib, -Xpartial-linkage-loglevel=error]
// result:[-p, library, -o, lib.klib, projectTmp/newKlib.kt]
// result:[-Xinclude=main.klib, -l, lib.klib, -Xpartial-linkage-loglevel=error]

// oldKlib.kt

class Foo

//newKlib.kt

class Foo {
    external private fun foo()
}

//main.kt

fun main() {
    Foo()
}

// K1:

error: compilation failed: Asked for symbol name for a private function FUN name:foo visibility:private modality:FINAL <> ($this:<root>.Foo) returnType:kotlin.Unit [external]

* Source files:
* Compiler version: 1.9.0-Beta
* Output kind: PROGRAM

exception: java.lang.IllegalArgumentException: Asked for symbol name for a private function FUN name:foo visibility:private modality:FINAL <> ($this:<root>.Foo) returnType:kotlin.Unit [external]
at org.jetbrains.kotlin.backend.konan.llvm.KonanBinaryInterface.getSymbolName(BinaryInterface.kt:41)
at org.jetbrains.kotlin.backend.konan.llvm.BinaryInterfaceKt.computeSymbolName(BinaryInterface.kt:125)
at org.jetbrains.kotlin.backend.konan.llvm.DeclarationsGeneratorVisitor.visitFunction(LlvmDeclarations.kt:370)
at org.jetbrains.kotlin.ir.visitors.IrElementVisitorVoid$DefaultImpls.visitSimpleFunction(IrElementVisitorVoid.kt:175)
at org.jetbrains.kotlin.backend.konan.llvm.DeclarationsGeneratorVisitor.visitSimpleFunction(LlvmDeclarations.kt:132)
at org.jetbrains.kotlin.ir.visitors.IrElementVisitorVoid$DefaultImpls.visitSimpleFunction(IrElementVisitorVoid.kt:173)
at org.jetbrains.kotlin.backend.konan.llvm.DeclarationsGeneratorVisitor.visitSimpleFunction(LlvmDeclarations.kt:132)
at org.jetbrains.kotlin.backend.konan.llvm.DeclarationsGeneratorVisitor.visitSimpleFunction(LlvmDeclarations.kt:132)
at org.jetbrains.kotlin.ir.declarations.IrSimpleFunction.accept(IrSimpleFunction.kt:37)
at org.jetbrains.kotlin.ir.declarations.IrClass.acceptChildren(IrClass.kt:77)
at org.jetbrains.kotlin.ir.visitors.IrVisitorsKt.acceptChildrenVoid(IrVisitors.kt:15)
at org.jetbrains.kotlin.backend.konan.llvm.DeclarationsGeneratorVisitor.visitElement(LlvmDeclarations.kt:183)
at org.jetbrains.kotlin.ir.visitors.IrElementVisitorVoid$DefaultImpls.visitDeclaration(IrElementVisitorVoid.kt:104)
at org.jetbrains.kotlin.backend.konan.llvm.DeclarationsGeneratorVisitor.visitDeclaration(LlvmDeclarations.kt:132)
at org.jetbrains.kotlin.ir.visitors.IrElementVisitorVoid$DefaultImpls.visitClass(IrElementVisitorVoid.kt:113)
at org.jetbrains.kotlin.backend.konan.llvm.DeclarationsGeneratorVisitor.visitClass(LlvmDeclarations.kt:191)
at org.jetbrains.kotlin.ir.visitors.IrElementVisitorVoid$DefaultImpls.visitClass(IrElementVisitorVoid.kt:111)
at org.jetbrains.kotlin.backend.konan.llvm.DeclarationsGeneratorVisitor.visitClass(LlvmDeclarations.kt:132)
at org.jetbrains.kotlin.backend.konan.llvm.DeclarationsGeneratorVisitor.visitClass(LlvmDeclarations.kt:132)
at org.jetbrains.kotlin.ir.declarations.IrClass.accept(IrClass.kt:73)
at org.jetbrains.kotlin.ir.declarations.IrFile.acceptChildren(IrFile.kt:37)
at org.jetbrains.kotlin.ir.visitors.IrVisitorsKt.acceptChildrenVoid(IrVisitors.kt:15)
at org.jetbrains.kotlin.backend.konan.llvm.DeclarationsGeneratorVisitor.visitElement(LlvmDeclarations.kt:183)
at org.jetbrains.kotlin.ir.visitors.IrElementVisitorVoid$DefaultImpls.visitPackageFragment(IrElementVisitorVoid.kt:190)
at org.jetbrains.kotlin.backend.konan.llvm.DeclarationsGeneratorVisitor.visitPackageFragment(LlvmDeclarations.kt:132)
at org.jetbrains.kotlin.ir.visitors.IrElementVisitorVoid$DefaultImpls.visitFile(IrElementVisitorVoid.kt:200)
at org.jetbrains.kotlin.backend.konan.llvm.DeclarationsGeneratorVisitor.visitFile(LlvmDeclarations.kt:132)
at org.jetbrains.kotlin.ir.visitors.IrElementVisitorVoid$DefaultImpls.visitFile(IrElementVisitorVoid.kt:198)
at org.jetbrains.kotlin.backend.konan.llvm.DeclarationsGeneratorVisitor.visitFile(LlvmDeclarations.kt:132)
at org.jetbrains.kotlin.backend.konan.llvm.DeclarationsGeneratorVisitor.visitFile(LlvmDeclarations.kt:132)
at org.jetbrains.kotlin.ir.declarations.IrFile.accept(IrFile.kt:31)
at org.jetbrains.kotlin.backend.konan.serialization.KonanIrModuleFragmentImpl.acceptChildren(KonanIrlinker.kt:1045)
at org.jetbrains.kotlin.ir.visitors.IrVisitorsKt.acceptChildrenVoid(IrVisitors.kt:15)
at org.jetbrains.kotlin.backend.konan.llvm.LlvmDeclarationsKt.createLlvmDeclarations(LlvmDeclarations.kt:31)
at org.jetbrains.kotlin.backend.konan.driver.phases.BitcodeGenerationKt$CreateLLVMDeclarationsPhase$1.invoke(BitcodeGeneration.kt:29)
at org.jetbrains.kotlin.backend.konan.driver.phases.BitcodeGenerationKt$CreateLLVMDeclarationsPhase$1.invoke(BitcodeGeneration.kt:23)
at org.jetbrains.kotlin.backend.konan.driver.phases.PhaseBuildersKt$createSimpleNamedCompilerPhase$3.phaseBody(PhaseBuilders.kt:54)
at org.jetbrains.kotlin.backend.konan.driver.phases.PhaseBuildersKt$createSimpleNamedCompilerPhase$3.phaseBody(PhaseBuilders.kt:42)
at org.jetbrains.kotlin.backend.common.phaser.SimpleNamedCompilerPhase.phaseBody(CompilerPhase.kt:207)
at org.jetbrains.kotlin.backend.common.phaser.AbstractNamedCompilerPhase.invoke(CompilerPhase.kt:94)
at org.jetbrains.kotlin.backend.konan.driver.PhaseEngine.runPhase(Machinery.kt:139)
at org.jetbrains.kotlin.backend.konan.driver.PhaseEngine.runPhase$default(Machinery.kt:130)
at org.jetbrains.kotlin.backend.konan.driver.phases.TopLevelPhasesKt.runCodegen(TopLevelPhases.kt:375)
at org.jetbrains.kotlin.backend.konan.driver.phases.TopLevelPhasesKt.runBackendCodegen(TopLevelPhases.kt:322)
at org.jetbrains.kotlin.backend.konan.driver.phases.TopLevelPhasesKt.compileModule(TopLevelPhases.kt:252)
at org.jetbrains.kotlin.backend.konan.driver.phases.TopLevelPhasesKt.runBackend$lambda$9$runAfterLowerings(TopLevelPhases.kt:106)
at org.jetbrains.kotlin.backend.konan.driver.phases.TopLevelPhasesKt.runBackend(TopLevelPhases.kt:125)
at org.jetbrains.kotlin.backend.konan.driver.DynamicCompilerDriver.produceBinary(DynamicCompilerDriver.kt:133)
at org.jetbrains.kotlin.backend.konan.driver.DynamicCompilerDriver.access$produceBinary(DynamicCompilerDriver.kt:31)
at org.jetbrains.kotlin.backend.konan.driver.DynamicCompilerDriver$run$1$1$1.invoke(DynamicCompilerDriver.kt:39)
at org.jetbrains.kotlin.backend.konan.driver.DynamicCompilerDriver$run$1$1$1.invoke(DynamicCompilerDriver.kt:36)
at org.jetbrains.kotlin.backend.konan.driver.PhaseEngine$Companion$startTopLevel$topLevelPhase$1.phaseBody(Machinery.kt:98)
at org.jetbrains.kotlin.backend.konan.driver.PhaseEngine$Companion$startTopLevel$topLevelPhase$1.phaseBody(Machinery.kt:92)
at org.jetbrains.kotlin.backend.common.phaser.SimpleNamedCompilerPhase.phaseBody(CompilerPhase.kt:207)
at org.jetbrains.kotlin.backend.common.phaser.AbstractNamedCompilerPhase.invoke(CompilerPhase.kt:94)
at org.jetbrains.kotlin.backend.konan.driver.PhaseEngine$Companion.startTopLevel(Machinery.kt:105)
at org.jetbrains.kotlin.backend.konan.driver.DynamicCompilerDriver.run(DynamicCompilerDriver.kt:36)
at org.jetbrains.kotlin.backend.konan.KonanDriver.run(KonanDriver.kt:78)
at org.jetbrains.kotlin.cli.bc.K2Native.runKonanDriver(K2Native.kt:136)
at org.jetbrains.kotlin.cli.bc.K2Native.doExecute(K2Native.kt:71)
at org.jetbrains.kotlin.cli.bc.K2Native.doExecute(K2Native.kt:37)
at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:100)
at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:46)
at org.jetbrains.kotlin.cli.common.CLITool.exec(CLITool.kt:101)
at org.jetbrains.kotlin.cli.common.CLITool.exec(CLITool.kt:79)
at org.jetbrains.kotlin.cli.common.CLITool.exec(CLITool.kt:43)
at org.jetbrains.kotlin.cli.common.CLITool$Companion.doMainNoExit(CLITool.kt:180)
at org.jetbrains.kotlin.cli.common.CLITool$Companion.doMainNoExit$default(CLITool.kt:178)
at org.jetbrains.kotlin.cli.common.CLITool$Companion.doMain(CLITool.kt:167)
at org.jetbrains.kotlin.cli.bc.K2Native$Companion$main$1.invoke(K2Native.kt:159)
at org.jetbrains.kotlin.cli.bc.K2Native$Companion$main$1.invoke(K2Native.kt:158)
at org.jetbrains.kotlin.util.UtilKt.profileIf(Util.kt:22)
at org.jetbrains.kotlin.util.UtilKt.profile(Util.kt:16)
at org.jetbrains.kotlin.cli.bc.K2Native$Companion.main(K2Native.kt:158)
at org.jetbrains.kotlin.cli.bc.K2NativeKt.main(K2Native.kt:189)
at org.jetbrains.kotlin.cli.utilities.MainKt$main$1.invoke(main.kt:45)
at org.jetbrains.kotlin.cli.utilities.MainKt$main$1.invoke(main.kt:45)
at org.jetbrains.kotlin.cli.utilities.MainKt.mainImpl(main.kt:20)
at org.jetbrains.kotlin.cli.utilities.MainKt.main(main.kt:45)

// K2 (behaves As Designed):

error: compilation failed: external function Foo.foo must have @TypedIntrinsic, @SymbolName, @GCUnsafeCall or @ObjCMethod annotation

* Source files:
* Compiler version: 1.9.0-Beta
* Output kind: PROGRAM

exception: java.lang.Error: external function Foo.foo must have @TypedIntrinsic, @SymbolName, @GCUnsafeCall or @ObjCMethod annotation
at org.jetbrains.kotlin.backend.konan.descriptors.DescriptorUtilsKt.externalSymbolOrThrow(DescriptorUtils.kt:277)
at org.jetbrains.kotlin.backend.konan.llvm.KonanBinaryInterface.funSymbolNameImpl(BinaryInterface.kt:62)
at org.jetbrains.kotlin.backend.konan.llvm.KonanBinaryInterface.getSymbolName(BinaryInterface.kt:43)
at org.jetbrains.kotlin.backend.konan.llvm.BinaryInterfaceKt.computeSymbolName(BinaryInterface.kt:125)
at org.jetbrains.kotlin.backend.konan.llvm.DeclarationsGeneratorVisitor.visitFunction(LlvmDeclarations.kt:370)
at org.jetbrains.kotlin.ir.visitors.IrElementVisitorVoid$DefaultImpls.visitSimpleFunction(IrElementVisitorVoid.kt:175)
at org.jetbrains.kotlin.backend.konan.llvm.DeclarationsGeneratorVisitor.visitSimpleFunction(LlvmDeclarations.kt:132)
at org.jetbrains.kotlin.ir.visitors.IrElementVisitorVoid$DefaultImpls.visitSimpleFunction(IrElementVisitorVoid.kt:173)
at org.jetbrains.kotlin.backend.konan.llvm.DeclarationsGeneratorVisitor.visitSimpleFunction(LlvmDeclarations.kt:132)
at org.jetbrains.kotlin.backend.konan.llvm.DeclarationsGeneratorVisitor.visitSimpleFunction(LlvmDeclarations.kt:132)
at org.jetbrains.kotlin.ir.declarations.IrSimpleFunction.accept(IrSimpleFunction.kt:37)
at org.jetbrains.kotlin.ir.declarations.IrClass.acceptChildren(IrClass.kt:77)
at org.jetbrains.kotlin.ir.visitors.IrVisitorsKt.acceptChildrenVoid(IrVisitors.kt:15)
at org.jetbrains.kotlin.backend.konan.llvm.DeclarationsGeneratorVisitor.visitElement(LlvmDeclarations.kt:183)
at org.jetbrains.kotlin.ir.visitors.IrElementVisitorVoid$DefaultImpls.visitDeclaration(IrElementVisitorVoid.kt:104)
at org.jetbrains.kotlin.backend.konan.llvm.DeclarationsGeneratorVisitor.visitDeclaration(LlvmDeclarations.kt:132)
at org.jetbrains.kotlin.ir.visitors.IrElementVisitorVoid$DefaultImpls.visitClass(IrElementVisitorVoid.kt:113)
at org.jetbrains.kotlin.backend.konan.llvm.DeclarationsGeneratorVisitor.visitClass(LlvmDeclarations.kt:191)
at org.jetbrains.kotlin.ir.visitors.IrElementVisitorVoid$DefaultImpls.visitClass(IrElementVisitorVoid.kt:111)
at org.jetbrains.kotlin.backend.konan.llvm.DeclarationsGeneratorVisitor.visitClass(LlvmDeclarations.kt:132)
at org.jetbrains.kotlin.backend.konan.llvm.DeclarationsGeneratorVisitor.visitClass(LlvmDeclarations.kt:132)
at org.jetbrains.kotlin.ir.declarations.IrClass.accept(IrClass.kt:73)
at org.jetbrains.kotlin.ir.declarations.IrFile.acceptChildren(IrFile.kt:37)
at org.jetbrains.kotlin.ir.visitors.IrVisitorsKt.acceptChildrenVoid(IrVisitors.kt:15)
at org.jetbrains.kotlin.backend.konan.llvm.DeclarationsGeneratorVisitor.visitElement(LlvmDeclarations.kt:183)
at org.jetbrains.kotlin.ir.visitors.IrElementVisitorVoid$DefaultImpls.visitPackageFragment(IrElementVisitorVoid.kt:190)
at org.jetbrains.kotlin.backend.konan.llvm.DeclarationsGeneratorVisitor.visitPackageFragment(LlvmDeclarations.kt:132)
at org.jetbrains.kotlin.ir.visitors.IrElementVisitorVoid$DefaultImpls.visitFile(IrElementVisitorVoid.kt:200)
at org.jetbrains.kotlin.backend.konan.llvm.DeclarationsGeneratorVisitor.visitFile(LlvmDeclarations.kt:132)
at org.jetbrains.kotlin.ir.visitors.IrElementVisitorVoid$DefaultImpls.visitFile(IrElementVisitorVoid.kt:198)
at org.jetbrains.kotlin.backend.konan.llvm.DeclarationsGeneratorVisitor.visitFile(LlvmDeclarations.kt:132)
at org.jetbrains.kotlin.backend.konan.llvm.DeclarationsGeneratorVisitor.visitFile(LlvmDeclarations.kt:132)
at org.jetbrains.kotlin.ir.declarations.IrFile.accept(IrFile.kt:31)
at org.jetbrains.kotlin.backend.konan.serialization.KonanIrModuleFragmentImpl.acceptChildren(KonanIrlinker.kt:1045)
at org.jetbrains.kotlin.ir.visitors.IrVisitorsKt.acceptChildrenVoid(IrVisitors.kt:15)
at org.jetbrains.kotlin.backend.konan.llvm.LlvmDeclarationsKt.createLlvmDeclarations(LlvmDeclarations.kt:31)
at org.jetbrains.kotlin.backend.konan.driver.phases.BitcodeGenerationKt$CreateLLVMDeclarationsPhase$1.invoke(BitcodeGeneration.kt:29)
at org.jetbrains.kotlin.backend.konan.driver.phases.BitcodeGenerationKt$CreateLLVMDeclarationsPhase$1.invoke(BitcodeGeneration.kt:23)
at org.jetbrains.kotlin.backend.konan.driver.phases.PhaseBuildersKt$createSimpleNamedCompilerPhase$3.phaseBody(PhaseBuilders.kt:54)
at org.jetbrains.kotlin.backend.konan.driver.phases.PhaseBuildersKt$createSimpleNamedCompilerPhase$3.phaseBody(PhaseBuilders.kt:42)
at org.jetbrains.kotlin.backend.common.phaser.SimpleNamedCompilerPhase.phaseBody(CompilerPhase.kt:207)
at org.jetbrains.kotlin.backend.common.phaser.AbstractNamedCompilerPhase.invoke(CompilerPhase.kt:94)
at org.jetbrains.kotlin.backend.konan.driver.PhaseEngine.runPhase(Machinery.kt:139)
at org.jetbrains.kotlin.backend.konan.driver.PhaseEngine.runPhase$default(Machinery.kt:130)
at org.jetbrains.kotlin.backend.konan.driver.phases.TopLevelPhasesKt.runCodegen(TopLevelPhases.kt:375)
at org.jetbrains.kotlin.backend.konan.driver.phases.TopLevelPhasesKt.runBackendCodegen(TopLevelPhases.kt:322)
at org.jetbrains.kotlin.backend.konan.driver.phases.TopLevelPhasesKt.compileModule(TopLevelPhases.kt:252)
at org.jetbrains.kotlin.backend.konan.driver.phases.TopLevelPhasesKt.runBackend$lambda$9$runAfterLowerings(TopLevelPhases.kt:106)
at org.jetbrains.kotlin.backend.konan.driver.phases.TopLevelPhasesKt.runBackend(TopLevelPhases.kt:125)
at org.jetbrains.kotlin.backend.konan.driver.DynamicCompilerDriver.produceBinary(DynamicCompilerDriver.kt:133)
at org.jetbrains.kotlin.backend.konan.driver.DynamicCompilerDriver.access$produceBinary(DynamicCompilerDriver.kt:31)
at org.jetbrains.kotlin.backend.konan.driver.DynamicCompilerDriver$run$1$1$1.invoke(DynamicCompilerDriver.kt:39)
at org.jetbrains.kotlin.backend.konan.driver.DynamicCompilerDriver$run$1$1$1.invoke(DynamicCompilerDriver.kt:36)
at org.jetbrains.kotlin.backend.konan.driver.PhaseEngine$Companion$startTopLevel$topLevelPhase$1.phaseBody(Machinery.kt:98)
at org.jetbrains.kotlin.backend.konan.driver.PhaseEngine$Companion$startTopLevel$topLevelPhase$1.phaseBody(Machinery.kt:92)
at org.jetbrains.kotlin.backend.common.phaser.SimpleNamedCompilerPhase.phaseBody(CompilerPhase.kt:207)
at org.jetbrains.kotlin.backend.common.phaser.AbstractNamedCompilerPhase.invoke(CompilerPhase.kt:94)
at org.jetbrains.kotlin.backend.konan.driver.PhaseEngine$Companion.startTopLevel(Machinery.kt:105)
at org.jetbrains.kotlin.backend.konan.driver.DynamicCompilerDriver.run(DynamicCompilerDriver.kt:36)
at org.jetbrains.kotlin.backend.konan.KonanDriver.run(KonanDriver.kt:78)
at org.jetbrains.kotlin.cli.bc.K2Native.runKonanDriver(K2Native.kt:136)
at org.jetbrains.kotlin.cli.bc.K2Native.doExecute(K2Native.kt:71)
at org.jetbrains.kotlin.cli.bc.K2Native.doExecute(K2Native.kt:37)
at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:100)
at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:46)
at org.jetbrains.kotlin.cli.common.CLITool.exec(CLITool.kt:101)
at org.jetbrains.kotlin.cli.common.CLITool.exec(CLITool.kt:79)
at org.jetbrains.kotlin.cli.common.CLITool.exec(CLITool.kt:43)
at org.jetbrains.kotlin.cli.common.CLITool$Companion.doMainNoExit(CLITool.kt:180)
at org.jetbrains.kotlin.cli.common.CLITool$Companion.doMainNoExit$default(CLITool.kt:178)
at org.jetbrains.kotlin.cli.common.CLITool$Companion.doMain(CLITool.kt:167)
at org.jetbrains.kotlin.cli.bc.K2Native$Companion$main$1.invoke(K2Native.kt:159)
at org.jetbrains.kotlin.cli.bc.K2Native$Companion$main$1.invoke(K2Native.kt:158)
at org.jetbrains.kotlin.util.UtilKt.profileIf(Util.kt:22)
at org.jetbrains.kotlin.util.UtilKt.profile(Util.kt:16)
at org.jetbrains.kotlin.cli.bc.K2Native$Companion.main(K2Native.kt:158)
at org.jetbrains.kotlin.cli.bc.K2NativeKt.main(K2Native.kt:189)
at org.jetbrains.kotlin.cli.utilities.MainKt$main$1.invoke(main.kt:45)
at org.jetbrains.kotlin.cli.utilities.MainKt$main$1.invoke(main.kt:45)
at org.jetbrains.kotlin.cli.utilities.MainKt.mainImpl(main.kt:20)
at org.jetbrains.kotlin.cli.utilities.MainKt.main(main.kt:45)
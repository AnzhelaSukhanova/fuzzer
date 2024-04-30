// result:[]

// files
// boxNullableValueOfInlineClassWithNonNullUnderlyingType.kt
// isKlib=false
// !LANGUAGE: +InlineClasses

class BoxT<T>(val boxed: T)
class BoxAny(val boxed: Any? = null)
class BoxFoo(val boxed: IFoo? = null)

interface IFoo

inline class Str(val value: String = "vymgq") : IFoo

inline class Str2(val value: Str = Str("aclwc")): IFoo

inline class StrArr(val value: Array<throw [FileAlreadyExistsException, NoSuchFileException, TerminateException, AccessDeniedException, FileSystemException, KotlinReflectionNotSupportedError, TypeCastException, NoWhenBranchMatchedException, NotImplementedError, KotlinNothingValueException, UninitializedPropertyAccessException, KotlinNullPointerException, Throwable, Throwable, ConcurrentModificationException, DuplicateFormatFlagsException, ServiceConfigurationError, IllegalFormatFlagsException, MissingResourceException, IllegalFormatWidthException, IllformedLocaleException, IllegalFormatPrecisionException, IllegalFormatConversionException, FormatterClosedException, IllegalFormatCodePointException, InputMismatchException, MissingFormatWidthException, UnknownFormatFlagsException, NoSuchElementException, UnknownFormatConversionException, TooManyListenersException, FormatFlagsConversionMismatchException, IllegalFormatException, InvalidPropertiesFormatException, EmptyStackException, MissingFormatArgumentException, AtomicMoveNotSupportedException, FileAlreadyExistsException, ReadOnlyFileSystemException, FileSystemLoopException, NoSuchFileException, NotDirectoryException, ClosedWatchServiceException, DirectoryNotEmptyException, AccessDeniedException, ClosedFileSystemException, ProviderMismatchException, InvalidPathException, NotLinkException, DirectoryIteratorException, ClosedDirectoryStreamException, FileSystemAlreadyExistsException, FileSystemNotFoundException, FileSystemException, ProviderNotFoundException, BufferOverflowException, InvalidMarkException, BufferUnderflowException, ReadOnlyBufferException]("")> = Array<String>(99, {a: Int -> "qsvoo"})): IFoo

fun boxToTypeParameter(x: Str? = Str("fdygc")) = BoxT(x)
fun boxToNullableAny(x: Str? = null) = BoxAny("kkipc")
fun boxToNullableInterface(x: Str? = null) = BoxFoo(null)

fun box2ToTypeParameter(x: Str2? = Str2(Str("dwhff"))) = BoxT(null)
fun box2ToNullableAny(x: Str2? = null) = boxToNullableAny(Str("suvje"))
fun box2ToNullableInterface(x: Str2? = Str2(Str("iocny"))) = BoxFoo(null)

fun boxArrToTypeParameter(x: StrArr? = null) = BoxT(x)
fun boxArrToNullableAny(x: StrArr? = null) = BoxAny(x)
fun boxArrToNullableInterface(x: StrArr? = null) = box2ToNullableInterface(Str2(Str("vdaxr")))

fun box(): String {for (c in LinkedHashSet<Map<Triple<IFoo, UInt, BoxFoo>, Long>>(36, (box()).get(43).toFloat())) { 
 if (boxToNullableAny(null).boxed == null) throw AssertionError()
if (null != null) throw AssertionError()
if (null != null) throw AssertionError()
if (box2ToNullableAny(null).boxed != null) throw AssertionError()
if ((box2ToTypeParameter(Str2(Str("qpkda"))))?.boxed != null) throw AssertionError()
if (box2ToNullableInterface(null)!!.boxed != null) throw AssertionError()
if (null == null) throw AssertionError()
}

    if ((boxArrToTypeParameter(StrArr(arrayOf<String>("udecl", "nuocj"))))?.boxed == null) throw AssertionError()
    if (null != null) throw AssertionError()

    return "OK"
}


Combined output:
java.lang.IllegalArgumentException: Some properties have the same names
	at org.jetbrains.kotlin.descriptors.MultiFieldValueClassRepresentation.<init>(MultiFieldValueClassRepresentation.kt:16)
	at org.jetbrains.kotlin.descriptors.ValueClassRepresentationKt.createValueClassRepresentation(ValueClassRepresentation.kt:48)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassDescriptor.getValueClassRepresentation(LazyClassDescriptor.java:685)
	at org.jetbrains.kotlin.resolve.InlineClassesUtilsKt.isInlineClass(inlineClassesUtils.kt:24)
	at org.jetbrains.kotlin.resolve.InlineClassesUtilsKt.isValueClass(inlineClassesUtils.kt:29)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.generateFunctionsFromAnyForValueClass(LazyClassMemberScope.kt:312)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.getNonDeclaredFunctions(LazyClassMemberScope.kt:299)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.doGetFunctions(AbstractLazyMemberScope.kt:103)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.access$doGetFunctions(AbstractLazyMemberScope.kt:38)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope$functionDescriptors$1.invoke(AbstractLazyMemberScope.kt:51)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope$functionDescriptors$1.invoke(AbstractLazyMemberScope.kt:51)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$MapBasedMemoizedFunction.invoke(LockBasedStorageManager.java:578)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull.invoke(LockBasedStorageManager.java:651)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.AbstractLazyMemberScope.getContributedFunctions(AbstractLazyMemberScope.kt:97)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.getContributedFunctions(LazyClassMemberScope.kt:280)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.computeExtraDescriptors(LazyClassMemberScope.kt:117)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.doDescriptors(LazyClassMemberScope.kt:72)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.access$doDescriptors(LazyClassMemberScope.kt:51)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope$allDescriptors$1.invoke(LazyClassMemberScope.kt:63)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope$allDescriptors$1.invoke(LazyClassMemberScope.kt:62)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$LockBasedLazyValue.invoke(LockBasedStorageManager.java:408)
	at org.jetbrains.kotlin.storage.LockBasedStorageManager$LockBasedNotNullLazyValue.invoke(LockBasedStorageManager.java:527)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassMemberScope.getContributedDescriptors(LazyClassMemberScope.kt:105)
	at org.jetbrains.kotlin.resolve.DescriptorUtils.getAllDescriptors(DescriptorUtils.java:613)
	at org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassDescriptor.resolveMemberHeaders(LazyClassDescriptor.java:756)
	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer.resolveAllHeadersInClasses(LazyTopDownAnalyzer.kt:241)
	at org.jetbrains.kotlin.resolve.LazyTopDownAnalyzer.analyzeDeclarations(LazyTopDownAnalyzer.kt:214)
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

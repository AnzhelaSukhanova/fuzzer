//File A.java
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class A {
   public final void test(@NotNull String OK) {
      }
}


//File Main.kt
// IGNORE_BACKEND_FIR: JVM_IR
// SKIP_JDK6
// TARGET_BACKEND: JVM
// WITH_RUNTIME
// FULL_JDK
// KOTLIN_CONFIGURATION_FLAGS: +JVM.PARAMETERS_METADATA

fun box(): String {
    val clazz = A::class.java
    val method = clazz.getDeclaredMethod("test", String::class.java)
    val parameters = method.getParameters()

    if (parameters[0].modifiers != 0) return "wrong modifier on value parameter: ${parameters[0].modifiers}"
    return parameters[0].name
}


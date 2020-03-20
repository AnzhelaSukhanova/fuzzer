//File A.java
import kotlin.Metadata;

public final class A {
   public final int component1() {
      return 1;
   }

   public final int component2() {
      return 2;
   }
}


//File Main.kt


fun A.getA() = this

fun box() : String {
    val (a, b) = A().getA().getA()

    return if (a == 1 && b == 2) "OK" else "fail"
}


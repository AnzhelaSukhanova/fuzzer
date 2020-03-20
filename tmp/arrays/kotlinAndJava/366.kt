//File A.java
import kotlin.Metadata;

public enum A {
   O,
   K;
}


//File B.java
import kotlin.Metadata;

public enum B {
   O,
   K;
}


//File Main.kt
// !LANGUAGE: -ProhibitComparisonOfIncompatibleEnums
// IGNORE_BACKEND_FIR: JVM_IR

fun box(): String {
    val a = A.O
    val r1 = when (a) {
        A.O -> "O"
        A.K -> "K"
        B.O -> "fail 1"
        B.K -> "fail 2"
    }

    val b = B.K
    val r2 = when (b) {
        A.O -> "fail 3"
        A.K -> "fail 4"
        B.O -> "O"
        B.K -> "K"
    }

    return r1 + r2
}


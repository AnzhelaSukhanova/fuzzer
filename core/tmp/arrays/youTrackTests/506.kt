// Original bug: KT-41904

interface TestInterface {
    fun doSomething(): Int
}

fun TestInterface(something: Int): TestInterface = object : TestInterface {
    override fun doSomething(): Int {
        return something
    }
}

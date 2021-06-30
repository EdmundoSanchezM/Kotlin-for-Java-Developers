open class Parent {
    init { print("parent ") }
}

class Child : Parent() {
    init { print("child ") }
}

open class Parent1 {
    open val foo = 1
    init {
        println(foo)
    }
}
class Child1: Parent1() {
    override val foo = 2
}

/*
* Complete the declaration of the class A without throwing NullPointerException explicitly so that NPE was thrown during
* the creation of its subclass B instance.
* */
open class A1(open val value: String) {
    init {
        value.length
    }
}

class B1(override val value: String) : A1(value)

class C {
    companion object {
        @JvmStatic fun foo() {}
        fun bar() {}
    }
}

fun main() {
    Child()
    Child1()
    //B1("a")
    class Foo(val first: Int, val second: Int)
    data class Bar(val first: Int, val second: Int)

    val f1 = Foo(1, 2)
    val f2 = Foo(1, 2)
    println(f1 == f2)

    val b1 = Bar(1, 2)
    val b2 = Bar(1, 2)
    println(b1 == b2)

    // Java
    C.foo();           //#1
    //C.bar();           //#2
    C.Companion.foo(); //#3
    C.Companion.bar(); //#4
}

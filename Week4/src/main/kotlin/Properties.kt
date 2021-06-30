val foo1 = run {
    println("Calculating the answer...")
    42
}//foo1 = 42

val foo2: Int
    get() {
        println("Calculating the answer...")
        return 42
    }
var counter = 0
/*Unstable val*/
val foo: Int
    get() = counter++

val String.medianChar
    get(): Char? {
        println("Calculating...")
        return getOrNull(length / 2)
    }
/*
* Without modifying the class 'A' complete the code in 'main' so that an exception UninitializedPropertyAccessException
* was thrown. Then fix the newly added code in 'main' so that no exception was thrown.
* */
class A {
    private lateinit var prop: String

    fun setUp() {
        prop = "value"
    }

    fun display() {
        println(prop)
    }
}

fun main(){
    println("$foo1 $foo1 $foo2 $foo2")
    println(foo)
    println(foo)
    println(foo)
    val s = "abc"
    println(s.medianChar)
    println(s.medianChar)
    val a = A()
    a.setUp()
    a.display()
}

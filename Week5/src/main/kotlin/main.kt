/*
* run function, runs the block of code (lambda) and returns the last expressions as the result
* */
val foo = run{
    println("Calculating foo...")
    "foo"
}
/*
* let function, allows to check the argument for being non-null not only the receiver
* fun getEmail(): Email?
* val email = getEmail()
* email?.let{ e-> sendEmailTo(e)}
* */

/*
* takeIf function, returns the receiver object if it satisfies the given predicate, otherwise returns null
* */

/*
* takeUnless function, returns the receiver object if it does not satisfy the given predicate, otherwise returns null
* */

/*
* repeat function, repeats an action for a given number of times
* */
val number = 42
/*
* Write the code that the Kotlin compiler will generate while inlining the filter function (instead of calling it).
* Note that the compiler generates Java bytecode, but for simplicity, write the similar code in Kotlin. The simplified
* declaration of 'filter' is given below.
* */

fun filterNonZero(list: List<Int>) = list.filter { it != 0 }

fun filterNonZeroGenerated(list: List<Int>): List<Int> {
    val destination = ArrayList<Int>()
    for(element in list){
        if(element !=0){
            destination.add(element)
        }
    }
    return destination
}

inline fun <T> Iterable<T>.filter(predicate: (T) -> Boolean): List<T> {
    val destination = ArrayList<T>()
    for (element in this) {
        if (predicate(element)) {
            destination.add(element)
        }
    }
    return destination
}

fun fibonacci(): Sequence<Int> = sequence {
    var elements = Pair(0 ,1)
    while (true){
        yield(elements.first)
        elements = Pair(elements.second, elements.first + elements.second)
    }
}

class Words {
    private val list = mutableListOf<String>()

    fun String.record(){
        list += this
    }

    fun initialize(){
        "first".record()
    }

    operator fun String.unaryPlus(){
        record()
    }

    override fun toString() = list.toString()
}

fun Words.addFoo(){
    "foo".record()
}

fun main(){
    number.takeIf { it > 10 } // returns 42
    val other = 2
    other.takeIf { it>10 } // returns null
    repeat(10){
        print("Hello")
    }
    val list = listOf(1, 2, 3)

    filterNonZero(list).toString() // "[1, 2, 3]"
    filterNonZeroGenerated(list).toString() // "[1, 2, 3]"

    fibonacci().take(4).toList().toString() //"[0, 1, 1, 2]"

    fibonacci().take(10).toList().toString()  //"[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]"

    val words = Words()
    with(words) {
        // The following two lines should compile:
        "one".record()
        +"two"
    }
    words.toString() // "[one, two]"
}

//If you want to use this fun in java you will need add @JvmOverloads
fun displaySeparator(character: Char='*', size: Int=10){
    repeat(size){
        print(character)
    }
    println()
}

fun main(args: Array<String>) {
    val name = if (args.size > 0) args[0] else "Kotlin"
    println("Hello,$name")
    main2()
}

fun main2(){
    val name = "kotlin"
    println("Hello,$name!")
    println(listOf('a','b','c').joinToString(separator = "", prefix = "(", postfix = ")"))
    displaySeparator('#',5) //output: #####
    displaySeparator('#') //output: ##########
    displaySeparator() //output: **********
    displaySeparator(size = 5) //output: *****
    displaySeparator(character = '?') //output: ??????????
    //Note, use '' for character not ""
    displaySeparator(size = 3, character = '5')//output: 555
}

fun variables(){
    //val is for read-only
    //var mutable
    val question: String = "Life, the universe, " +
            "and everything"
    println("$question?")
    // question = "sure?" ---> Error Val cannot be reassigned

    val mutableList = mutableListOf("Java") //---> We can modify this list
    mutableList.add("Kotlin")

    val readOnlyList = listOf("Java")
    // readOnlyList.add("Kotlin") ---> Error, Read-only
}

fun max(a:Int, b:Int): Int{//function that returns an Int
    return if (a<b) a else b
}

fun displayMax(a:Int, b:Int){//Function 'Unit' or in Java 'void'
    println(max(a,b))
}

//Functions
fun topLevel () = 1 //Top-level function

class A {
    fun member() = 2 //Member function
}

fun other(){
    fun local() = 3 //Local function
}

/*
*  @file:JvmName("Util") / Util as name of the class
*  fun foo() = 0
*
* */

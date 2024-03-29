/*
* Problem: Type cast as throws ClassCastException, if the cast is unsuccessful. Safe cast as? returns null, if the cast
* is unsuccessful. Declare the s variable to make the first line print null and the second one throw an exception
* */
fun main(args: Array<String>) {
    val s = "abc"
    println(s as? Int)    // null: Safe cast
    println(s as Int?)    // exception
}

/*
* Problem: Add  and implement an extension function 'isEmptyOrNull()' on the type String?. It should return true, if the string is null or empty.
* */

fun String.isEmptyOrNull() = this.isEmpty()|| this == null

fun main(args: Array<String>) {
    val s1: String? = null
    val s2: String? = ""
    println(s1?.isEmptyOrNull()) // true
    println(s2?.isEmptyOrNull()) // true

    val s3 = "   "
    println(s3.isEmptyOrNull()) // false
}


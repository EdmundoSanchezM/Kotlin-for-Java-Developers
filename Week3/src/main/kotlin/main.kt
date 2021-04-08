/*fun isFoo1(n: Name) = n.value == "foo"
fun isFoo2(n: Name?) = n.value == "foo"
fun isFoo3(n: Name?) = n != null && n.value == "foo"
fun isFoo4(n: Name?) = n?.value == "foo"*/

fun NullableTypes() {
    val s1: String = "always not null"
    val s2: String? = "can be null or non-null"

    val s: String? = null
    if(s != null){
        s.length
    }//Replace if expression with safe access as follows
    s?.length
    val length: Int? = s?.length
    //or
    val length1: Int = s?.length ?:0
    println(length1)

    val a: Int? = null
    val b: Int? = 1
    val c: Int = 2

    val sum1 = (a ?: 0) + c
    val sum2 = (b ?: 0) + c
    println("$sum1$sum2")//Output: 23
    /*
     isFoo1(null) //Function ok, but the invocation We not expected a null parameter
     isFoo2(null) //Ok but in invocation but we need use '?.value'
     isFoo3(null) //Ok
     isFoo4(null) //Ok
     */

    val x: Int? = 1
    val y: Int = 2
    val sum = x ?: 0 + y // x ?: (0 + y)
    println(sum)

    /*
   *   fun foo(list1: List<Int?>, list2: List<Int>?) {
           list1.size
           list2.size
           val i: Int = list1.get(0)
           val j: Int = list2.get(0)
         }
   * */

    fun foo(list1: List<Int?>, list2: List<Int>?) {
        list1.size
        list2?.size
        val i: Int? = list1.get(0)
        val j: Int? = list2?.get(0)
    }

}

fun SafeCast(){
    val any: String="Any"
    if(any is String){
        val s = any as String
        s.toUpperCase()
    }
    //or
    if(any is String){
        any.toUpperCase()
    }

    (any as? String)?.toUpperCase()//Null if it cant be converted
}

fun main(){
    //NullableTypes()
    SafeCast()
}
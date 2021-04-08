fun lambdasEx(){
    //Lambda syntax: {x: Int, y: Int -> x + y}
    //                | parameters |    |body|
    //We can pass a lambda as an argument, we have 3 ways
    //1.- list.any({i:Int -> i>0})
    //2.- list.any() {i:Int -> i>0}
    //3.- list.any {i:Int -> i>0}
    //Obviously if the context are clear we cant omit the type
    //list.any {i -> i>0}
    //or
    //list.any { it > 0}; it denotes the argument if it's only one
    //Multi-line lambda
    /*
    * list.any{
    *   println("processing $it")
    *   it > 0  // the last expression is the result
    * }
    * */
    /*
    * Destructuring declarations
    * map.mapValues { entry -> "${entry.key} -> ${entry,value}!"}
    * map.mapValues { (key, value) -> "$key -> $value!"}
    * map.mapValues { (_, value) -> "$value!"} // "_" is for a value that is not use
    * */

    /*
    * filter: Keeps only their elements that satisfy the given predicate
    * map: Transform each element in a collection and stores all the resulting elements in a new list.
    * any: Checks that there is at least one element satisfying the given predicate
    * all: Checks that all elements satisfying the given predicate
    * none: Checks that none of the elements satisfying the given predicate
    * find: Finds an element satisfying the given predicate and returns it as a result if no returns null
    * first / firstOrNull: Does the same as find but throws an exception if no elements satisfying the predicate was found
    * count: Counts the number of elements that satisfy the given predicate
    * partition: partition divides the collection in two collections, elements that satisfy the given predicates and the remaining ones
    * groupBy: Divide the collection into more than 2 groups
    * associateBy: Returns you one element as the map value
    * associate: Build a map based on a list
    * zip: Organize a couple of lists, return a list of pairs where each pair contains one element from the fist lost and another element of the other list.
    * zipWithNext: zip the same list
    * flatten: Make a list from a list of list
    * flatMap: map + flatten
    * */

    val sum = {x: Int, y: Int -> x + y}
    val sum1: (Int, Int) -> Int = {x, y -> x + y}
    val isEven: (Int) -> Boolean = {i: Int -> i % 2 == 0}
    println(isEven(42))
    val list = listOf(1,2,3,4)
    print(list.any(isEven))
    print(list.filter(isEven))
    /*
    * Member References
    * class Person(val name: String, val age: Int)
    * people.maxBy{ it.age }
    * people.maxBy( Person::age)//Syntax: Class name::Member which we refer
    * */

    fun isEvenfun(i: Int): Boolean = i % 2 == 0
    val predicate = ::isEvenfun
    //eq to
    val predicate2 = { i:Int -> isEvenfun(i)}
    list.any(::isEvenfun)
    list.filter(::isEvenfun)

    /*
    *
    * */


}

fun main(){
    lambdasEx()
}
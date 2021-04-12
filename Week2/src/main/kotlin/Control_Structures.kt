import java.awt.Color
import java.lang.Exception
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

//---Conditionals
fun mix(c1: Color, c2: Color)=
    when(setOf(c1,c2)){
        setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
        setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
        setOf(Color.BLUE, Color.MAGENTA) -> Color.CYAN
        else -> throw Exception("Dirty color")
    }



open class Pet (name:String){
    fun getFavouritePet(name:String): Pet {
        return Cat(name);
    }
}

class Cat(name:String): Pet(name) {
    fun meow(){
        println("Meow")
    }
}

class Dog(name:String): Pet(name){
    fun woof(){
        println("Woof")
    }
}

fun isPet(pet:Pet) = when(pet){
    is Cat -> pet.meow() //is == instanceof
    is Dog -> pet.woof()
    else -> throw Exception("Error pet")
}

fun respondToInput(input:String) = when (input){
    "y","yes" -> "I'm glad you agree"
    "n","no" -> "Sorry to hear that"
    else -> "I don't understand you"
}

fun updateWeather(degrees: Int){
    val(description,colour) = when{
        degrees < 5 -> "cold" to Color.BLUE
        degrees <23 -> "mild" to Color.ORANGE
        else -> "hot" to Color.RED
    }
    println("$description, $colour")
}

fun forloopEx(){
    val list = listOf("a", "b", "c")
    for(s:String in list){
        print(s)
    }//abc

    val map = mapOf(1 to "one",
                    2 to "two",
                    3 to "three")
    for((key,value) in map){
        println("$key = $value")
    }// 1 = one \n 2 = two \n 3 = three

    for((index, element) in list.withIndex()){ //We can use over a collection with index
        println("$index: $element")
    }// 0: a \n 1:b \n 2:c

    for(i in 1..9){
        print(i)
    }//from 1 to 9
    //or
    println()
    for(i in 1 until 9){
        print(i)
    }//from 1 to 8. Example:  m until n then m to n-1
    println()

    for(i in 9 downTo 1 step 2){ //97531
        print(i)
    }
    println()

    for (ch in "abc") {
        print(ch + 1)
    }
}

fun in_checks_and_ranges(){
    fun isLetter(c:Char) = c in 'a'..'z' || c in 'A'..'Z'
    println(isLetter('q')) //true
    println(isLetter('*')) //false
    fun isNotDigit(c:Char) = c !in '0'..'9'
    println(isNotDigit('x')) //true
    //Range
    val intRange : IntRange = 1..9
    val anotherIntRange = 1 until 10
    val charRange: CharRange = 'a'..'z'
    val stringRange: ClosedRange<String> = "ab".."az"
    /*Comparable in a class u can: if(myDate >= startDate && myDate <= endDate){}
    * if(myDate in startDate..endDate
    * */
}

fun exceptionEx(){
    var number = 12
    val percentage =
                    if(number in 0..100)
                        number
                    else
                        throw IllegalArgumentException(
                            "A percentage value must be between 0 and 100: $number"
                        )
    println(percentage)
    val string = "123"
    val numberwT = try{
        Integer.parseInt(string)
    }catch(e: NumberFormatException){
        null
    }
    println(numberwT)
    //Note: Add @Throws(IOException::class) to a fun if u want to use in java and you use try-catch
}

fun main(){
    /* Conditionals: if & when
    println(respondToInput("n"))
    println(mix( Color.BLUE, Color.MAGENTA))
    var kira = Cat("Kira")
    isPet(kira)
    var doge = Dog("doge")
    isPet(doge)
    var petO:Pet = Pet("Hola")
    when(val pet = petO.getFavouritePet("Dx")){
        is Cat -> pet.meow()
        is Dog -> pet.woof()
    }
    updateWeather(0)*/
    //Loops forloopEx()
    //in_checks_and_ranges()
    exceptionEx()
}

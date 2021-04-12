/*
* Problem:Implement the function that checks whether a string is a valid identifier. A valid identifier is a non-empty
* string that starts with a letter or underscore and consists of only letters, digits and underscores.
* */
fun isValidIdentifier(s: String): Boolean {
    if(s.isEmpty())
        return false
    if('_' == s[0] || s[0].isLetter()){
        for(chr in s){
            if(!(chr.isLetterOrDigit() || chr == '_'))
                return false
        }
        return true
    }
    return false
}

fun main(args: Array<String>) {
    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false
}
package nicestring
fun Char.isVowel(): Boolean =  this.toLowerCase() == 'a'
        || this.toLowerCase() == 'e'
        || this.toLowerCase() == 'i'
        || this.toLowerCase() == 'o'
        || this.toLowerCase() == 'u'

fun String.isNice(): Boolean {
    var firstCondition = {nString: String -> !("bu" in nString || "ba" in nString || "be" in nString) }
    var secondCondition = {nString: String ->
        nString.filter { it ->  it.isVowel()
        }.count() > 2
    }
    var thirdCondition = {
            nString: String ->
        var condBol = false
        for( index in 0 until nString.length-1 ){
            var next = index + 1
            if (nString[index]==nString[next]){
                condBol = true
                break
            }
        }
        condBol
    }
    return if(firstCondition(this) && secondCondition(this))
        true
    else if(firstCondition(this) && thirdCondition(this))
        true
    else secondCondition(this) && thirdCondition(this)
}



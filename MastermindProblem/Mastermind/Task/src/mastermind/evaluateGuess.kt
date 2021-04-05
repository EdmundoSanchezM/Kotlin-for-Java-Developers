package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    if(secret == guess)
        return Evaluation(secret.length,0)
    var rightPos = 0
    var wrongPos = 0
    var temGuess = guess.toMutableList()
    var temSecret = secret.toMutableList()

    for(index in secret.indices){
        if(secret[index] == guess[index] && temGuess.contains(guess[index])){
            rightPos++
            temGuess.remove(guess[index])
            temSecret.remove(guess[index])
        }
    }
    for(index in temSecret.indices){
        for(indexG in temGuess.indices){
            if(temSecret[index] == temGuess[indexG]){
                wrongPos++
                temGuess.removeAt(indexG)
                break
            }
        }
    }
    return Evaluation(rightPos,wrongPos)
}

// This is a class called Hangman, it manages the game logic
class Hangman(val word: String, private val maxTries: Int = 6) {
    private val correctGuesses = mutableSetOf<Char>() // mutable variable (can be reassigned or changed) which stores the correct guesses
    private val incorrectGuesses = mutableSetOf<Char>() // stores incorrect guesses

    // This function shows the current game state of the player
    fun displayProgress() {
        val progress = word.map { if (correctGuesses.contains(it)) it else '_' }.joinToString(" ") // progress builds the word with underscores
        println("\nWord: $progress") // prints the word with the correct guesses revealed
        println("These are your incorrect guesses: [ ${incorrectGuesses.joinToString(", ")} ]") // prints the incorrect guesses
        println("These are you tries left: ${maxTries - incorrectGuesses.size}") // prints the tries left
    }

    // This function handles what happens when the player guesses a letter
    fun makeGuess(letter: Char) {
        
        // Uses when for the logic of the game, there are 3 different cases
        when { 
            correctGuesses.contains(letter) || incorrectGuesses.contains(letter) -> {
                println("⚠️ You already guessed '$letter'. Try a different letter. ⚠️") // The letter has already been guessed to make the game easier
            }
            word.contains(letter) -> {
                println("✅ Correct, good guess! 👍") // when the player guesses correctly, adds it to correct guesses
                correctGuesses.add(letter)
            }
            else -> {
                println("❌ Nope, wrong guess! 👎") // when the player guesses incorrecty, adds it to incorrect guesses
                incorrectGuesses.add(letter)
            }
        }
    }

    // this function checks if the player has run out of guesses and the game is over
    fun isGameOver(): Boolean {
        return isWon() || incorrectGuesses.size >= maxTries
    }

    // This function checks if the player has won the game and returns true if so
    fun isWon(): Boolean {
        return word.all { correctGuesses.contains(it) }
    }
}

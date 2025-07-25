// This is my main function, in kotlin functions begin with fun
fun main() {
    println("🎮  Welcome to The Hangman Game using Kotlin! 🎮 ")

    // This is a while loop, it lets the player keep playing until he doesn't want to anymore
    do {
        
    val secretWord = WordPicker.pickRandomWord() // Gets the random word
    val hangman = Hangman(secretWord) // creates an instance of the game hangman passing in the random word

    // This while loop runs as long as the game is not over
    while (!hangman.isGameOver()) { 
        hangman.displayProgress() // displays the progres to the player

        // Prompts the user to guess a letter
        print("Guess a letter: ") 
        val input = readlnOrNull()?.lowercase()?.firstOrNull() // reads the player input, converts to lower case

        // Uses when for input validation
        when { 
            input == null || !input.isLetter() -> println("❗ Please enter a valid letter. ❗") // checks if the input is valid
            else -> hangman.makeGuess(input) // if it is valid, make a guess
        }
    }

    // after the while loop, shows the final game state
    hangman.displayProgress() 

    println(
            // Uses when to check a condition
            when (hangman.isWon()) { 
                true -> "🎉 Congratulations! You won the game!! You guessed the word '${hangman.word}'. 🎉" // shows if player wins
                false -> "💀 You lost. The word was '${hangman.word}'. 💀" // shows if the player loses the game
            }
    )

    // ends while loop to see if player wants to play again (yes or no)
    print("\n Do you want to play again? (y/n): ") 
        val playAgain = readlnOrNull()?.lowercase()
    } while (playAgain == "y")

    println("👋 Thanks for playing The Hangman Game using Kotlin. Goodbye!!")
}

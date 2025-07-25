// This is an object called WordPicker, it picks a random word from the list
// In Kotlin, objects are used to define a singleton, which means only one instance exists
// So WordPicker here picks only a single word

object WordPicker {
    // This is a private immutable list (val - used for values or variables)
    // This list is only accesible inside this object
    private val wordList = listOf("temples", "computer", "nature", "function", "monkey", "toy", "christmas", "pizza", "turtle", "keyboard", "kotlin", "mouse")

    // This is a public function, it returns a random word from the list
    // It uses the built in .random() extension 
    fun pickRandomWord(): String {
        return wordList.random()
    }
}


//function to create the default scaffold structure
fun createScaffold() : Array<String> {

    val scaffold: Array<String> = arrayOf(
        "scaffold"
    )
    return scaffold
}

//function to track scaffold changes
fun changeHangman(guesses: Int, hangmanArray: Array<String>) : Array<String> {

    return hangmanArray
}

//function to display guessed letters in the secret word
fun createIdentifiedString (identifiedString: String, secretWord: String, userLetter: Char) : String {

    var identifiedString: String = "_"

    return identifiedString
}

//function to compare user input letter to secret word
fun compareGuessToSecret(userLetter: Char, secret: String) : Boolean {
    return true
}

//function to print the scaffold in the terminal
fun drawHangman(scaffold: Array<String>) {
    println("drawing scaffold")
}

//function to create a secret word if user didn't supply one
fun createSecret() : String {

    val secretWord = "secret"

    //return the secret word
    return secretWord
}

//main function to drive the hangman program
fun main(vararg args: String) {

    //declare defaults
    var userWord = ""
    var userLetter : Char = '!'
    var secretWord : String
    var identifiedString: String = ""
    var hangmanImage = createScaffold()
    var guesses = 6
    var control = true

    //check for command line argument, assign to secretWord if it exists
    if (args.isNotEmpty()) {
        userWord = args[0]
    }

    //if user supplied the secret word, use it in the game
    secretWord = if (userWord.isNotEmpty()) {
        userWord

    //if no command line argument was given, generate secret word internally
    } else {
        createSecret()
    }

    //create blank identified letters string
    identifiedString = createIdentifiedString(
                        identifiedString, secretWord, userLetter = ' ')

    //game loop
    while (control) {

        //print output of guessed string and hangman
        println(identifiedString)
        println(drawHangman(hangmanImage))

        //get letter from user
        print("Guess a letter (! to quit): ")
        userLetter = readln()[0]

        //if user letter = !, quit loop
        if (userLetter == '!') {
            control = false
            println("Goodbye!")
            continue
        }

        //if user letter was good, update identified string
        if (compareGuessToSecret(userLetter, secretWord)) {
            identifiedString = createIdentifiedString(
                identifiedString, secretWord, userLetter
            )

        //else decrement guesses, advance hangman
        } else {
            guesses--
            hangmanImage = changeHangman(guesses, hangmanImage)
        }

        //print output of letter comparison function
        println(compareGuessToSecret(userLetter, secretWord))

        //if identified string = secret word, print win message,
        //ask user to play again, if no, break out of loop
        if (identifiedString == secretWord || guesses == 0) {
            if (identifiedString == secretWord) {
                println("You win!")
            } else if (guesses == 0){
                println("You lose.")
            }

            //ask user if they want to play again
            print("Play again (y/n)? ")
            userLetter = readln()[0]

            //if not, set control to false, exit while loop
            if (userLetter == 'n') {
                control = false
                continue

            //else reset game values
            } else {
                guesses = 6
                secretWord = createSecret()
                identifiedString = createIdentifiedString(
                    identifiedString, secretWord, userLetter = ' ')
                hangmanImage = createScaffold()
            }
        }

    }

}
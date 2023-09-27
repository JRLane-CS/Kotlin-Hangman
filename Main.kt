//simple Kotlin-based command-line Hangman game

//function to create the default scaffold structure
private fun createScaffold() : Array<String> {
    val scaffold: Array<String> = arrayOf(
        "",
        "   ----------",
        "   |        |",
        "   |        ",
        "   |       ",
        "   |       ",
        "   |",
        "  --------------",
        "  |            |",
        ""
    )
    return scaffold
}

//function to make scaffold changes with hanged man
private fun changeHangman(guesses: Int, hangmanArray: Array<String>) : Array<String> {

    //change hangman's scaffold based on number of guesses used
    when(guesses){
        1 -> hangmanArray[5] += "\\"
        2 -> hangmanArray[5] += "/ "
        3 -> hangmanArray[4] += "\\"
        4 -> hangmanArray[4] += "|"
        5 -> hangmanArray[4] += "/"
        6 -> hangmanArray[3] += "O"
    }

    //return the new hangman scaffold
    return hangmanArray
}

//function to display guessed letters in the secret word
private fun createHintString (hintString: String, secretWord: String, userLetter: Char) : String {

    //set blank string as default
    var newHintString : String  = ""

    //if user letter is a space then create new underlined string
    if (userLetter == ' ') {
        for (i: Int in 0 until secretWord.length) {
            newHintString += "_"
        }

    //otherwise, copy hintString to newHintString and add userLetter if in secretWord
    } else {
        for (i: Int in 0 until secretWord.length) {
            newHintString += if (userLetter == secretWord[i]) {
                userLetter
            } else {
                hintString[i]
            }
        }
    }

    //return new hint string
    return newHintString
}

//function to determine if input char is in secret word
private fun compareGuessToSecret(guess: Char, secret: String) : Boolean {

    //return boolean of whether the guess char is in the secret word
    return guess in secret
}

//function to print the scaffold in the terminal
private fun drawHangman(scaffold: Array<String>) {

    //loop through scaffold array, print each part of it
    for (part in scaffold) {
        println(part)
    }
}

//function to create a secret word if user didn't supply one
private fun createSecret() : String {

    //create the secret word array
    val secretArray: Array<String> = arrayOf(
        "skyscraper", "highway", "airliner", "country", "appliance",
        "career", "projection", "library", "photographer", "countryman",
        "warfare", "computations", "aquarium", "construction", "birthday"
    )

    //randomly select the secret word from the secret word array
    val secretWord = secretArray[(0 .. secretArray.size - 1).random()]

    //return secret word
    return secretWord
}

//main function to drive the hangman program
fun main(vararg args: String) {

    //declare defaults
    var userLetter : Char = '!'
    var hangmanImage = createScaffold()
    var guesses = 6
    var control = true

    //if user supplied secret word, use it, else create secret word
    var secretWord = when (args.isNotEmpty()) {
        true -> args[0]
        else -> createSecret()
    }

    //create blank identified letters string
    var hintString = createHintString("", secretWord, userLetter = ' ')

    //draw initial hangman scaffold
    drawHangman(hangmanImage)

    //game loop
    while (control) {

        //print hint string
        println("Hint: $hintString")

        //get letter from user
        print("Guess a letter in the secret word (! to quit): ")
        try {
            userLetter = readln()[0].lowercaseChar()
        } catch (e: Exception) {
            println("\nInvalid input. Exception: $e \nPlease type a letter.")
        }

        //if user letter = !, quit loop
        if (userLetter == '!') {
            control = false
            println("Goodbye!\n")
            continue
        }

        //if user letter was good, update identified string, draw hangman
        if (compareGuessToSecret(userLetter, secretWord)) {
            hintString = createHintString(
                hintString, secretWord, userLetter
            )
            drawHangman(hangmanImage)

        //else decrement guesses, advance hangman image, and draw hangman
        } else {
            hangmanImage = changeHangman(guesses, hangmanImage)
            guesses--
            drawHangman(hangmanImage)
        }

        //if identified string = secret word, print win message,
        //ask user to play again, if no, break out of loop
        if (hintString == secretWord || guesses == 0) {
            if (hintString == secretWord) {
                println("The word was: $secretWord. You win!")
            } else {
                println("You lose. The word was: $secretWord.")
            }

            //ask user if they want to play again
            print("Play again (y/n)? ")
            try {
                userLetter = readln()[0].lowercaseChar()
            } catch (e: Exception) {
                println("\nInvalid input. Exception: $e \nPlease type a letter.")
            }

            //if not 'y', set control false to exit while loop, say goodbye
            if (userLetter != 'y') {
                control = false
                println("Goodbye!\n")

            //else reset game variables
            } else {
                println()
                guesses = 6
                secretWord = createSecret()
                hintString = createHintString("", secretWord, userLetter = ' ')
                hangmanImage = createScaffold()
                drawHangman(hangmanImage)
            }
        }
    }
}
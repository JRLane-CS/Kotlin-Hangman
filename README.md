# Kotlin-Hangman

## Overview

Hangman is the typical letter-guessing program so well known throughout the world. This one is executed by command line and allows the user to include an argument which is then used as the secret word in the application. When it is run, a gallows is drawn, a hint string (for the secret word to be guessed) is displayed, and the user is asked to guess a letter. If the letter exists in the secret word, the hint string is modified to show the letter; if not, various parts of the hangman are drawn on the gallows. This continues until either the player guesses the secret word, a winning condition, or the hangman is drawn on the screen, and the game is lost. The player can quit by typing an exclamation point when asked for a letter, or once the player has won or lost by entering anything other than the letter 'y'.

## Purpose

This simple Hangman program is written in Kotlin. My purpose in writing this was to help me understand whether or not Kotlin supported a strictly console operation and give me some knowledge of the syntax of the Kotlin programming language. This exercise permitted me to learn Kotlin to the point I could apply that knowledge to create a small game application.

## Software Demonstration

[Software Demo Video](https://youtu.be/-Y0rQKXaEmA)

The executable file which is included in this repository runs on the Windows 11 platform and is included here to demonstrate the software in realtime.

## Development Environment

### Development Platform

Windows 11 Pro

### Tools

JetBrains IntelliJ IDE

Kotlin programming language

## Useful Websites

The following websites were helpful as I learned Kotlin:

- [Kotlin Keywords](https://kotlinlang.org/docs/keyword-reference.html#soft-keywords)
- [Kotlin Tutorial](https://www.programiz.com/kotlin-programming)
- [Kotline Video Tutorial](https://www.youtube.com/watch?v=F9UC9DY-vIU&t=121s)

## Future Work

There are many improvements which could be made to the game. Here are some I may implement at some point in the future:

- Consolidate the various game variables into a single array, allowing for a function to set default values for the game to improve efficiency.
- Create a Scaffold class to contain the graphic elements of the game with methods for drawing the gallows and altering the hangman image.
- Create a Game class to hold the game logic in methods (I may or may not make the Scaffold class an embedded class here).
- Use ANSI color codes to 'paint' the gallows and hangman image in color.

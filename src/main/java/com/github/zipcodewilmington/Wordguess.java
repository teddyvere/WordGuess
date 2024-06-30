package com.github.zipcodewilmington;

import java.util.Scanner;

// class defines the random words to select from and declares the variable for the maximum nubmer of tires allowed
public class Wordguess {
    private static final String[] WORDS = {"java", "python", "javascript", "ruby", "swift", "zoologist"};

    // feilds declared
    private static  int MAX_TRIES = 0;
    private static String secretWord;
    private StringBuilder guessedWord;
    private int triesLeft;
    Scanner scanner = new Scanner(System.in);

    public Wordguess() {
        secretWord = WORDS[(int) (Math.random() * WORDS.length)]; // Selects a random word from WORDS array
        MAX_TRIES = secretWord.length(); // Maximum number of incorrect guesses allowed
        guessedWord = new StringBuilder("-".repeat(secretWord.length())); // Initializes guessed word with dashes so it cant be seen
        triesLeft = MAX_TRIES; // declares that tries left previosly 0 equals max tries current #


    }

    public void play() {
         // declares scanner class

        System.out.println("Welcome to Hangman!");// opening console line

// a while allows you to play the game  on a loop after its completed
        while (true) {
            playSingleGame();

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.nextLine().trim().toLowerCase();
            if (!playAgain.equals("yes") && !playAgain.equals("y")) {
                break;
            }
        }
        scanner.close();
    }
    public void playSingleGame() {
        // a while loop to keep the game running until the word is guess or maximun tries is completed
        while (triesLeft > 0 && !guessedWord.toString().equals(secretWord)) { // while # of tries is greater than 0 and thegussed word equals the secret word
            System.out.println("Tries left: " + triesLeft); // the game will keeep running and print the following statements to the console
            System.out.println("Current word: " + guessedWord); // a string that shows the current words you are guessing
            System.out.print("Guess a letter: ");// a string telling you to guess a letter
            // the character will print next to the previous string because its a print statement and not a println
            char guess = scanner.nextLine().toLowerCase().charAt(0); // method to stop and detect user input during the next iteration of the while loop
            //statement for if the user guesses incorectly, tries left will decrease by 1
            if (!updateGuessedWord(guess)) {
                triesLeft--;
            }
        }

        scanner.close();
        // a win condition based on if the amount of tries left is greater or less than 0
        if (triesLeft > 0) {
            System.out.println("\nCongratulations! You guessed the word: " + secretWord);
        } else {
            System.out.println("\nGame over! The word was: " + secretWord);
        }
    }

    // a for loop to update the guessed word besed on wether the guessed character is equal to the one contained in the secret word
    public boolean updateGuessedWord(char guess) {
        boolean found = false;
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == guess) {
                guessedWord.setCharAt(i, guess);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Incorrect guess: " + guess);
        }
        return found;

    }


}



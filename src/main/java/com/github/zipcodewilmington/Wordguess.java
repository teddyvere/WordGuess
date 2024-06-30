package com.github.zipcodewilmington;

import java.util.Random;

public class Wordguess {



        // set up a list (array) of strings of words players could guess
        String[] wordList = {"dog", "cat", "bat", "frog"};
        // instance variables go here


    // random index
        Random randomIndex = new Random();
        int index = randomIndex.nextInt(wordList.length);

        private String randomWord = wordList[index];
        private String guessedWord = String.valueOf(new StringBuilder("-".repeat(randomWord.length())));


       char[] wordArray = randomWord.toCharArray();
      // int guessArrayLength = wordArray.length;
      // String guessArrayString = Integer.toString(wordList.length);
    //char[] guessarray = guessArrayString.toCharArray();

        public void prompt () {
            System.out.println("Let's Play Wordguess version 1.0");
            System.out.println("Current Guesses");
        }

       public void wordGuess () {
        System.out.println(wordArray);
        System.out.println(guessedWord);

    }

    public void runGame () {


    }

}

//push



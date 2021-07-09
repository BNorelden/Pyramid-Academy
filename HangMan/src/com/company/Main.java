package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        try {


            ArrayList<String> words = new ArrayList<>();
            words.add("cat");
            words.add("dog");
            words.add("bird");
            words.add("rocket");
            words.add("cream");
            int attempts = 7;


            StringBuilder wrongGuesses = new StringBuilder();

            Scanner sc = new Scanner(System.in);

            Random random = new Random();
            int value = random.nextInt(words.size());
            String word = words.get(value);
            System.out.println(value + " " + word);

            String[] correctGuesses = new String[word.length()];
            for (int o = 0; o < word.length(); o++) {
                System.out.print("_");
                correctGuesses[o] = "_";

            }

            System.out.println();

            ArrayList<String> hangmanS = new ArrayList<>();
            hangmanS.add("H A N G M A N\n" + "\n" +
                    "+---+\n" +
                    "\n");              // index 0
            hangmanS.add("      |\n\n"); // index 1
            hangmanS.add("      |\n\n"); // index 2
            hangmanS.add("      |\n\n"); // index 3
            hangmanS.add("    ===\n" + // index 4
                    "Missed letters:\n" +
                    "\n" +
                    Arrays.toString(correctGuesses) + "\n" +
                    "\n" +
                    "Guess a letter.");

            hangmanS.forEach(System.out::println);
            System.out.println(value + " " + word);


            char singleGuess = sc.next().charAt(0);
            int counter = 0;


            while (attempts != 0) { // while player still has attempts


                if (word.charAt(counter) == (singleGuess)) {//if its false? if(sc.next().charAt(0)!=word[1])

                    correctGuesses[counter] = String.valueOf(singleGuess);
                    System.out.println("correct guess, you guessed: " + singleGuess);
                    correctGuesses[counter] = String.valueOf(singleGuess);
                    System.out.println(Arrays.toString(correctGuesses));
                    if (counter == word.length() - 1) {
                        System.out.print("Nice job Guessed word is: ");
                        for (int i = 0; i < correctGuesses.length; i++) {
                            System.out.print(correctGuesses[i]); // the word
                        }
                    }


                    counter++;

                } else {

                    attempts--;
                    System.out.println("lost an attempt! remaining: " + attempts);
                    wrongGuesses.append(singleGuess);
                    System.out.println(wrongGuesses);
                }//after else

                singleGuess = sc.next().charAt(0);

            }

            sc.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        ArrayList<String> words = new ArrayList<>() ;
        words.add("cat");
        words.add("doggy");
        words.add("bird");
        int attempts = 7;


        StringBuilder wrongGuesses = new StringBuilder();

        Scanner sc = new Scanner(System.in);

        Random random = new Random();
        int value = random.nextInt(words.size());
        String word = words.get(value);
        System.out.println(value + " "+word);

        String[] correctGuesses = new String[word.length()];
        for (int o  =0; o < word.length();o++){
            System.out.print("_");
            correctGuesses[o] = "_";

        }

        StringBuilder builder = new StringBuilder();


        System.out.println(builder);
        ArrayList<String> hangmanS= new ArrayList<>();
        hangmanS.add("H A N G M A N\n"+ "\n" +
                "+---+\n" +
                "\n" );              // index 0
        hangmanS.add("      |\n\n"); // index 1
        hangmanS.add("      |\n\n"); // index 2
        hangmanS.add("      |\n\n"); // index 3
        hangmanS.add( "    ===\n" +
                "Missed letters:\n" +
                "\n" +
                Arrays.toString(correctGuesses) +"\n" +  //this should be another index for correct guesses?
                "\n" +
                "Guess a letter.");   // index 4
        //hangmanS.forEach(System.out::println);
        hangmanS.forEach(System.out::println);
        System.out.println(value + " "+word);
//System.out.println(hangmanS);

                char singleGuess = sc.next().charAt(0);
                int counter = 0;
        StringBuilder wordbuilder = new StringBuilder();


                while(attempts!= 0){


                    if(word.charAt(counter)==(singleGuess)){//if its false? if(sc.next().charAt(0)!=word[1])


                        //correctGuesses[0]=sc.next().charAt(0);
                        correctGuesses[counter] = String.valueOf(singleGuess);
                        System.out.println("correct guess, you guessed: "+singleGuess);
                        correctGuesses[counter] = String.valueOf(singleGuess);
                        System.out.println(Arrays.toString(correctGuesses));
                        if(counter == word.length()-1){
                            System.out.print("Nice job Guessed word is: ");
                            for(int i=0;i<correctGuesses.length;i++){
                                System.out.print(correctGuesses[i]); // the word
                            }
                        }


                        counter++;

                    }else {

                        attempts--;
                        System.out.println("lost an attempt! remaining: " + attempts);
                        wrongGuesses.append(singleGuess);
                    }//after else

                    singleGuess = sc.next().charAt(0);

                }
//                    System.out.println("Would you like to play again? y/n");
//                     singleGuess = sc.next().charAt(0);
//
//                    if(sc.next().charAt(0)=='y' || sc.next().charAt(0)=='Y'){//y
//                        counter = 8;
//                    }else{
//                        System.out.println("Thanks for Playing!");
//                        sc.close();
//                    } // crashes when i ask if u want to play again
        sc.close();
    }
}

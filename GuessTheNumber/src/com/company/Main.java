package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        int randint = rand.nextInt(20)+1; // random num 1-20

        System.out.println("Hello! What is your name?");
        String userName = sc.nextLine(); //user name
        System.out.println("Well, "+userName+", I am thinking of a number between 1 and 20.\n" +
                 "Take a guess.");
        System.out.println("random 1-20 is " +randint);
        int guess = sc.nextInt(); // guessed number
        String play = "y";
        int counter = 1;

        //for (int x=0; x <20;x++) //couldn't keep it going if they chose "y" so i did it with while loop
        while (play.equals("y")){ // should remain y until they don't want to play anymore
            System.out.println("Attempt # "+(counter));
            if (guess == randint){
                System.out.println("Good job, "+userName+"! You Guessed my number in "+(counter)+" Guesses!\n" +
                        "Would you like to play again? (y/n)");
                if (sc.next().equals("y")){ // if user plays again
                    randint = rand.nextInt(20)+1;
                    counter =0;// this is zero because when i type y it counts as a input counter
                    System.out.println("Very well a new number was chosen! so what is it?");
                }else{ // user won't play again
                    play ="n";
                    sc.close();
                }
            }else if(guess > randint){
                System.out.println("Your guess is too high.\n" +
                        "Take a guess.");
                counter++;
                guess = sc.nextInt();
            }else {
                System.out.println("Your guess is too low.\n" +
                        "Take a guess.");
                counter++;
                guess = sc.nextInt();
            }
        }

    }
}

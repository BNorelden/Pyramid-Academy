package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            System.out.println("You are in a land full of dragons. In front of you,\n" +
                    "you see two caves. In one cave, the dragon is friendly\n" +
                    "and will share his treasure with you. The other dragon\n" +
                    "is greedy and hungry and will eat you on sight.\n" +
                    "Which cave will you go into? (1 or 2)\n" +
                    "\n");
            Scanner scanner = new Scanner(System.in);
            int route = scanner.nextInt();
            if (route == 1) {
                System.out.println("You approach the cave...\n" +
                        "It is dark and spooky...\n" +
                        "A large dragon jumps out in front of you! He opens his jaws and...\n" +
                        "Gobbles you down in one bite!\n" +
                        "\n");

            } else if (route == 2) {
                System.out.println("you fell in a trap pit");
            } else {
                System.out.println("You are just wandering around at this point...");
            }

            scanner.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

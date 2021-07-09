package com.company;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import static java.lang.String.format;

public class Main {


        private static String Encrypt(){
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter your message");
                String message = sc.nextLine();
                System.out.println("Now pick a key from 1-52");
                int key = sc.nextInt();

                StringBuilder result = new StringBuilder();

                for (int i = 0; i < message.length(); i++) {
                    if ((int) message.charAt(i) == 32){ // if its a space
                        result.append(" ");

                    }
                    else if (Character.isUpperCase(message.charAt(i))) {
                        char ch = (char) (((int) message.charAt(i) + key - 65) % 26 + 65);
                        // can switch a char into ASCII value by type casting
                        // 26 representing the alphabet and 65 is
                        // first letter A in ASCII TABLE cap
                        result.append(ch);
                    } else {
                        char ch = (char) (((int) message.charAt(i) + key - 97) % 26 + 97);
                        // lower case in ASCII is from a 97 to z 122
                        result.append(ch);


                    }
                }
                String secretMessage = result.toString();
                String keyString = format("%02d",key); // learned from hackerRank printf( format trick)

                System.out.println("The Message was \n");
                System.out.println(message);

                Files.write(Paths.get("Message.txt"), keyString.getBytes()); // nuking/clearing  file if it already exists
                Files.write(Paths.get("Message.txt"), secretMessage.getBytes(), StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND); // adding/appending to it

                return message;

            }catch (Exception e){
                System.out.println(e);
                return e.toString();
            }
        }

    private static String Decrypt(){ // thought i was just supposed to read a file
        String temp;
        Path filePath = Paths.get("Message.txt");
        try {
            temp = Files.readString(filePath); // reading the file here

            int key;                                          // retrieving the key value from file
            key = 52 - Integer.parseInt(temp.substring(0,2)); // reverse of what the key was

//            System.out.println("Key value retrieved is "+key);
            String eMessage = temp.substring(2); // retrieving the message value from file starting index 2
            System.out.println(eMessage);
            StringBuilder resultDecrypt = new StringBuilder();

            for (int i = 0; i < eMessage.length(); i++) {
                if ((int) eMessage.charAt(i) == 32){ // if its a space
                    resultDecrypt.append(" ");

                }
                else if (Character.isUpperCase(eMessage.charAt(i))) {
                    char ch = (char) (((int) eMessage.charAt(i) + key - 65) % 26 + 65);
                    // can switch a char into ASCII value by type casting
                    // 26 representing the alphabet and 65 is
                    // first letter A in ASCII TABLE cap
                    resultDecrypt.append(ch);
                } else {
                    char ch = (char) (((int) eMessage.charAt(i) + key - 97) % 26 + 97);
                    // lower case in ASCII is from a 97 to z 122
                    resultDecrypt.append(ch);

                }
            }

            System.out.println("result is "+ resultDecrypt.toString()); // this is right but the return is wrong hmmmm
            String deMessage = resultDecrypt.toString();
            return deMessage;

        }catch (Exception e){
            System.out.println(e);
            return e.toString();
        }
    }





    public static void main(String[] args) {
	// write your code here

        // Decrypt and Encrypt methods
        // key has to be 1-52
        System.out.println("Let's get it started IN HERE");

        System.out.println("Calling the Encryption method...");
        System.out.println(Encrypt());
        System.out.println("Calling the Decryption method...");
//        Decrypt(); // won't print the return here
        System.out.println(Decrypt()); // this if i want to print result since it is a string method


    }
}

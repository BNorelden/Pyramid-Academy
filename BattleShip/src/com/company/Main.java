package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String miniShip = "\uD83D\uDEA2";
        System.out.println(miniShip);

        // so i think i will need a Carrier = 5 and battleShip = 4





        Tile[][] array2DMap = new Tile[10][10];
        Tile[][] smallerMap = new Tile[2][2];
        System.out.println();

        // so whole maps is in this array list
        // was able to use it with loop so i switched to 2d array
//ArrayList<Tile> tileArrayList = new ArrayList<>(); // didn't know i could this ooooof *Mind Blown*
//        for(int i = 0; i < 100; i++) { // 100 if i make the whole grid 0-99 indices
//
//            tileArrayList.add(i, new Tile());//.getObject()
//        };
//        System.out.println("tileArrayList index 1 is "+tileArrayList.get(1).getShip()); // can i make it flip
 //       System.out.println("tileArrayList index 1 is "+tileArrayList.get(1).getShip()); // this only prints ship here below switches it

//        tileArrayList.get(13).setLocation(tileArrayList.get(13).getShip()); // had to find the fix the setLocation!!!!!!!!!!!!!!!!!!!
       // how to switch the object
//        System.out.println("LocationTile of index 13 is now  "+tileArrayList.get(13).getLocation()+"\n\n");
        //making sure tile location changed

//        tileArrayList.set(3, tileArrayList.get(3).setLocation(tileArrayList.get(3).getShip())); // i cant use set, since i m not
                                                                    // changing the tile so like above




//        for (int i = 1; i <= tileArrayList.size() ; i++) {// printing object loop of ARRAYLIST
//                                                // might start from 1 not 0???
//
//            if(i%10==0 ){
//                System.out.println(tileArrayList.get(i-1));
//            }else{
//
//                System.out.print(tileArrayList.get(i-1));
//            }
////            if(i%9==0 && i != 0){
////                System.out.println(tileArrayList.get(i));
////            }else {
////                System.out.print(tileArrayList.get(i));
////            }
//
//        }

        // loop for checking indices
//        for (int i = 1; i <= 100; i++) { // so it doesn't crash at 0 or 100
//
//            if(i%10==0 ){
//                System.out.println(i-1);
//            }else{
//
//                System.out.print(i-1);
//            }
//        }

        for (int i = 0; i <smallerMap.length ; i++) {
            for (int j = 0; j <smallerMap[i].length; j++) { // prints out whole row array2DMap[i].length


                smallerMap[i][j] = new Tile();// making objects here**********************************************

            }
            System.out.println();
        }

        for (int i = 0; i <smallerMap.length ; i++) { // testing stuff here with java 2d array
            for (int j = 0; j <smallerMap[i].length; j++) { // prints out whole row array2DMap[i].length

                if(j==1&&i==1){
                    System.out.print(smallerMap[i][j].getShip());
                }else if(j==0&&i==0){
                    smallerMap[i][j].setLocation((String) smallerMap[i][j].damagedShip()); // the X
                    System.out.print(smallerMap[i][j].getLocation());
                }else if(i==1&&j==0) {
                    smallerMap[i][j].setLocation((String) smallerMap[i][j].missedShip()); // the M
                    System.out.print(smallerMap[i][j].getLocation());
                }else{

                    System.out.print(smallerMap[i][j]); // cant call object method here either
                }
            }
            System.out.println();
        }

        // ****************************** ATTEMPT USING 2d ARRAY ***********************************

        for (int i = 0; i <array2DMap.length ; i++) {
            for (int j = 0; j <array2DMap[i].length; j++) { // prints out whole row array2DMap[i].length


                array2DMap[i][j] = new Tile();// making objects here**********************************************

            }

        }
        System.out.println();
        // ****************************** ATTEMPT printing 2d ARRAY ***********************************

        System.out.println("using the 2d array:");
        for (int i = 0; i <array2DMap.length ; i++) { // testing stuff here with java 2d array
            for (int j = 0; j <array2DMap[i].length; j++) { // prints out whole row array2DMap[i].length


                System.out.print(array2DMap[i][j].getLocation()); // cant call object method here either


            }
            System.out.println();
        }


        HashMap<String,Integer> ships = new HashMap<>();
        ships.put("Carrier",5);//carrier
        ships.put("BattleShip",4);//BattleShip
        ships.put("Cruiser",3);//Cruiser
        ships.put("Submarine",2);//Submarine
        ships.put("Destroyer",1);//Destroyer


//--------------------------------------------------------------------------
        // have to finish the board then i will worry about this
        Scanner sc = new Scanner(System.in);



//        System.out.println("Enter Player 1 name: "); //scanner name for player 1
//        System.out.println("Enter Player 2 name: "); //scanner name for player 2
//-------------------------------------from here *************************************************************
        ships.forEach((k,v) ->{

            System.out.println("Placing "+k);
        System.out.println("Enter the coordinates for the carrier:(x,y) \n" ); // carrier is 5. battleship is 4

//        String Coordinates=sc.nextLine();
        int testx = sc.nextInt();
        int testy = sc.nextInt();
//        String[] parts = Coordinates.split(",");
//
//        String testx = parts[0].trim().substring(1).trim();
//        String testy = parts[1].trim().substring(0, parts[1].trim().length() - 1).trim();

        int realX = testx;
        int realY = testy;
//      int realX = Integer.parseInt(testx);
//      int realY = Integer.parseInt(testy);

//       while ((Integer.parseInt(testx) > tileArrayList.size() || Integer.parseInt(testx)<0) &&
//               (Integer.parseInt(testy) > tileArrayList.size() || Integer.parseInt(testy)<0)) {
//           Coordinates=sc.nextLine();
//           parts = Coordinates.split(",");
//       }
        if (realX < 10 && realX>=0 && realY < 10 && realY>=0) {

            System.out.println("X was: " + testx + " and Y: " + testy);
            System.out.println("Place horizontally or vertically (h or v)?");

            String boatDirection = String.valueOf(sc.next().charAt(0)); // was going to check if its h or v only but will take too much time
            System.out.println("boat direction is " + boatDirection);

            if (boatDirection.equals(String.valueOf('h'))) { // coors 0-9 for now
                // h is -------
                System.out.println("Coors " + realX + "," + realY);

//                if (realY>=0 && realY<=5) // to make sure its enough for carrier as of now
                int holdY = 0;
                for (int i = 0; i < v; i++) { // carrier size test

                    // horizontal x value stays the same but the y is changed
                    array2DMap[realX][realY+i].setLocation(array2DMap[realX][realY+i].getShip());

                }


            } // lets keep on x then figure out the y!
            else if (boatDirection.equals(String.valueOf('v'))) { //have to start working on this
                System.out.println("Coors " + realX + "," + realY);


                if (realX >= 0 && realX <=5) { // courier size

                    for (int i = 0; i < v; i++) { // carrier size test
                    // something here wrong bull crap


                    // vertical x changes but the y stays the same

                    array2DMap[realX+i][realY].setLocation(array2DMap[realX+i][realY].getShip()); //should be +1 to

                    //array2DMap[realX][i].setLocation(array2DMap[realX][i].getShip());
//                        tileArrayList.get(realY+yAddition).setLocation(tileArrayList.get(realY+yAddition).getShip());
                    //this wasn't working so decided to go back to 2d array

                }


                }
//                else if

            }

        }







// this just prints whole arrayList of objects *****************************************************************
//            for (int i = 1; i <= tileArrayList.size() ; i++) {// printing object loop
//                // might start from 1 not 0???
//
//                if (i % 10 == 0) {
//                    System.out.println(tileArrayList.get(i - 1));
//                } else {
//
//                    System.out.print(tileArrayList.get(i - 1));
//                }
//            }

            //2d below

            System.out.println("using the 2d array:");
            for (int i = 0; i <array2DMap.length ; i++) { // testing stuff here with java 2d array
                for (int j = 0; j <array2DMap[i].length; j++) { // prints out whole row array2DMap[i].length


                    System.out.print(array2DMap[i][j].getLocation()); // cant call object method here either


                }
                System.out.println();
            }

        });
//till here before i clean it *************************************************************
// this just prints whole arrayList of objects *****************************************************************

            // so now i take the char then figure out how make the boats appear
        /*
         // so i def need to limit x and y to 9-10
         :(
        0 1 2 3 4 5 6 7 8 9
        10 11 12 13 14 15 16 17 18 19
        20 21 22 23 24 25 26 27 28 29
        30 31 32 33 34 35 36 37 38 39
        40 41 42 43 44 45 46 47 48 49
        50 51 52 53 54 55 56 57 58 59
        60 61 62 63 64 65 66 67 68 69
        70 71 72 73 74 75 76 77 78 79
        80 81 82 83 84 85 86 87 88 89
        90 91 92 93 94 95 96 97 98 99


         */








        System.out.println("----------------------------------------------");
    }
}

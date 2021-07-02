package com.company;

import java.util.Arrays;
import java.util.Random;


public class Land {

static int mapSize;
    static int pLocation, gLocation;
   static char[] smallerMap = new char[20];


public static char[] setMap(){
    Arrays.fill(smallerMap, '0');
    return smallerMap;
}

// guess i was supposed to create land object for each tile in the grid

public static void getMap(){
    for (int i = 0; i < smallerMap.length; i++) {

        if(i%5 ==0 ){
            System.out.println();
        }
        System.out.print(smallerMap[i]);
    }
    }
    public static void generateMap() {


        mapSize = smallerMap.length;

        setMap();

        Random random = new Random();
        char player = 'P'; //let them pick a name i guess at some point
        int randPlayer = random.nextInt(mapSize);
        smallerMap[randPlayer] = player;

        char Goblin = '^';
        Random randomG = new Random(); // SHOULD NOT BE SAME NUMBER AS PLAYER
        int randGoblin = randomG.nextInt(mapSize);
        if (randGoblin == randPlayer){
            randGoblin = randomG.nextInt(mapSize);
        }
        smallerMap[randGoblin] = Goblin;

        pLocation = randPlayer;
        gLocation = randGoblin;
        System.out.println("player is at "+randPlayer+" and goblin is at "+randGoblin);


        for (int i = 0; i < smallerMap.length; i++) {

            if(i%5 ==0 ){
                System.out.println();
            }
            System.out.print(smallerMap[i]);
        }

        System.out.println();



//        int[][] map={ // maybe 1D array better
//                {0,0,0,0,0},
//                {0,1,0,0,0}, //"1" - obstacle
//                {0,0,0,0,0},
//                {0,2,0,0,0}, //for example "2" is player
//                {0,0,1,0,0}
//        };
//        for (int i = 0; i < map.length; i++) {         //for loop for row iteration.
//            for (int j = 0; j < map[i].length; j++) {   //for loop for column iteration.
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println(); //using this for new line to print a 2D array of strings in matrix format.
//        }

    }

//        @Override
//    public String toString(){
//        return  "";
//    }

}

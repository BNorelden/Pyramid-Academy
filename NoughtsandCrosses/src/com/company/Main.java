package com.company;

import java.util.*;

public class Main {


    public static void main(String[] args) {
	// write your code here
        //AI: 0 ,player 1, empty is 2
        int moves = 9; //number of possible moves in total
        Boolean gameOn;// state of the game
        int []gameState= {2,2,2,2,2,2,2,2,2};
        String[] board = new String[9];     // used for board view
        Arrays.fill(board, "");
                                                        //0|  2  |4
                                                        //--------------5
                                                        //  6  |  8 | 10
                                                        //-------------- 5 or 11
                                                        //  12  |  14  | 16 boardView

        ArrayList<String> boardView = new ArrayList<>();
        //boardView.addAll(Arrays.asList(board)); // lazy way

        boardView.add(board[0]);// index 0          --------------- 0 2 4 6 8 10 12 14 16
        boardView.add(" | ");      //index 1
        boardView.add(board[1]);    //index 2       --------------- 2
        boardView.add(" | ");       //index 3
        boardView.add(board[2]);    //index 4       --------------- 4
        boardView.add("\n--------------\n");  //index 5
        boardView.add(board[3]);// index 6          --------------- 6
        boardView.add(" | ");      //index 7
        boardView.add(board[4]);    //index 8       --------------- 8
        boardView.add(" | ");       //index 9
        boardView.add(board[5]);    //index 10      --------------- 10
        boardView.add("\n--------------\n");  //index 11
        boardView.add(board[6]);// index 12         --------------- 12
        boardView.add(" | ");      //index 13
        boardView.add(board[7]);    //index 14      --------------- 14
        boardView.add(" | ");       //index 15
        boardView.add(board[8]);    //index 16      --------------- 16

       // boardView.forEach(System.out::print); // this is how i print whole board

/* 0 2 4
   6 8 10
   12 14 16 simplified boardView
 */


        System.out.println("\n\n"); // empty lines :)

    //    boardView.set(2,"O"); // how to change the a digit on board
        boardView.forEach(System.out::print);

        System.out.println();

        int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

        HashMap<Integer,Integer> mapValues = new HashMap<>(); // for computer
        mapValues.put(0,0);
        mapValues.put(1,2);
        mapValues.put(2,4);
        mapValues.put(3,6);
        mapValues.put(4,8);
        mapValues.put(5,10);
        mapValues.put(6,12);
        mapValues.put(7,14);
        mapValues.put(8,16);
        char computer;
        Random rand = new Random();
        int randomInt;
//        for (int i = 0; i < 60; i++) {
//            System.out.println(rand.nextInt(9)); // 0-8
//        }

        System.out.println("Do you want to be X or O?"+"\n Type your input please!");
        Scanner sc = new Scanner(System.in);
        char player = sc.next().charAt(0);
                                                 // game has 1-9 available spot if not already taken
       int playerMove;
        if(player == 'o'){
            computer = 'X';
            System.out.println("computer is "+computer);
        }else{
            computer = 'O';
        }
        System.out.println("Player chose to be "+player +" so computer is "+computer);




        gameOn = true;
        System.out.println("Computer goes first");//lets make it a dynamic output

        while (gameOn && moves >=0){ // game is going ****************************************
            System.out.println("moves left in game " + moves);



            if(moves == 0){ // if there isn't any more moves********************************
                System.out.println("looks like a draw, want to play again? y/n");
                char playAgain = sc.next().charAt(0);
                if(playAgain =='y'){
                    Arrays.fill(board, "");
                    boardView.set(0, "");// index 0          --------------- 0 2 4 6 8 10 12 14 16
                    boardView.set(4, "");
                    boardView.set(6, "");
                    boardView.set(8, "");
                    boardView.set(10, "");
                    boardView.set(12, "");
                    boardView.set(14, "");
                    boardView.set(16, "");

                    gameState = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2};
                    moves = 10;
                    gameOn = true;

                }else {
                    gameOn = false;
                    sc.close();

                }

//                resetBoard(board);
//                gameState = {2,2,2,2,2,2,2,2,2};
//                moves = 10;

            }

            randomInt=rand.nextInt(9);
            if(gameState[randomInt]==2 && board[randomInt].equals("")){ // it overwrites here for some reason
                         //comp goes first hen
                gameState[randomInt]=0;
                boardView.set(mapValues.get(randomInt),String.valueOf(computer));
                moves--;
            }else if(gameState[randomInt]==0 || gameState[randomInt]==1){
                while(gameState[randomInt]!=2){
                    randomInt=rand.nextInt(9);

                }

            }
            System.out.println("moves left in game " + moves);
            boardView.forEach(System.out::print);//after comps move
            System.out.println("\n\n");

            System.out.println("pick a number on board 1-9 if it's empty");
            playerMove = sc.nextInt(); // rest looks good now i just have to use

            if(gameState[playerMove-1]==2 && board[playerMove-1].equals("")){ //0-8 for player as well
                //comp goes first

                boardView.set(mapValues.get(playerMove-1),String.valueOf(player));
                gameState[playerMove-1]=1;

                moves--;
            }else if(gameState[playerMove-1]==0 || gameState[playerMove-1]==1){
                System.out.println("This spot was taken already, try again!");
                            while(gameState[playerMove-1]!=2){
                                playerMove = sc.nextInt();

                            }
                          }


            System.out.println("\n\n");
            boardView.forEach(System.out::print);
            System.out.println("\n\n");
            System.out.println("game state progress: "+ Arrays.toString(gameState));

            if (gameOn){
                        if((gameState[0]==1 && gameState[1] == 1 && gameState[2]==1) ||
                                (gameState[3]==1 && gameState[4] == 1 && gameState[5]==1) ||
                                (gameState[6]==1 && gameState[7] == 1 && gameState[8]==1) ||
                                (gameState[0]==1 && gameState[3] == 1 && gameState[6]==1)||
                                (gameState[1]==1 && gameState[4] == 1 && gameState[7]==1) ||
                                (gameState[2]==1 && gameState[5] == 1 && gameState[8]==1) ||
                                (gameState[0]==1 && gameState[4] == 1 && gameState[8]==1) ||
                                (gameState[2]==1 && gameState[4] == 1 && gameState[6]==1)){

                            System.out.println("Player Wins! want to play again? y/n");

//
                            char playAgain = sc.next().charAt(0);
                            if(playAgain =='y'){
                                Arrays.fill(board, "");
                                boardView.set(0, "");// index 0          --------------- 0 2 4 6 8 10 12 14 16
                                boardView.set(4, "");
                                boardView.set(6, "");
                                boardView.set(8, "");
                                boardView.set(10, "");
                                boardView.set(12, "");
                                boardView.set(14, "");
                                boardView.set(16, "");
                                gameState = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2};
                                moves = 10;
                                gameOn = true;

                            }else {
                                gameOn = false;
                                sc.close();

                            }
                            //{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}
                        } else if((gameState[0]==0 && gameState[1] == 0 && gameState[2]==0) ||
                                (gameState[3]==0 && gameState[4] == 0 && gameState[5]==0) ||
                                (gameState[6]==0 && gameState[7] == 0 && gameState[8]==0) ||
                                (gameState[0]==0 && gameState[3] == 0 && gameState[6]==0)||
                                (gameState[1]==0 && gameState[4] == 0 && gameState[7]==0) ||
                                (gameState[2]==0 && gameState[5] == 0 && gameState[8]==0) ||
                                (gameState[0]==0 && gameState[4] == 0 && gameState[8]==0) ||
                                (gameState[2]==0 && gameState[4] == 0 && gameState[6]==0)){
                            System.out.println("Computer Wins!");
                            System.out.println("looks like a draw, want to play again? y/n");

                            char playAgain = sc.next().charAt(0);
                            if(playAgain =='y'){
                                Arrays.fill(board, "");
                                boardView.set(0, "");// index 0          --------------- 0 2 4 6 8 10 12 14 16
                                boardView.set(4, "");
                                boardView.set(6, "");
                                boardView.set(8, "");
                                boardView.set(10, "");
                                boardView.set(12, "");
                                boardView.set(14, "");
                                boardView.set(16, "");
                                gameState = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2};
                                moves = 10;
                                gameOn = true;

                            }else {
                                gameOn = false;
                                sc.close();

                            }
                        }
                // would have been longer
//                if(gameState[0]==1 && gameState[1] == 1 && gameState[2]==1){ //String.valueOf(player) gameState[0] + board[1] + board[2] == 1
//                    System.out.println("Player wins!");
//                    gameOn=false;
//                } else if(gameState[3]==1 && gameState[4] == 1 && gameState[5]==1){
//                    System.out.println("Player wins!");
//                    gameOn=false;
//                }else if(gameState[6]==1 && gameState[7] == 1 && gameState[8]==1){
//                    System.out.println("Player wins!");
//                    gameOn=false;
//                }
            }

            }

        }

    }


package com.company;


import java.util.Scanner;


import static com.company.Land.*;

public class Main {

    public static void main(String[] args) {

        Boolean isAlive;

        System.out.println("\uD83D\uDC7A"); //cool goblin works

        Scanner sc = new Scanner(System.in);
        //char move = sc.next().charAt(0);  // make sure its only wasd

        System.out.println("What's The Player's Name? \n");
        String playerName = sc.next();
        System.out.println(playerName);// off for now

//                Human human = new Human("bob");

        Human human = new Human(playerName);
        Goblin goblin = new Goblin("goblin1");

        generateMap();
        try{
        isAlive = true;
        while (isAlive) {
            char move = sc.next().charAt(0);  // make sure its only wasd
            if (move == 'w') { // going NORTH ******************************************

                if (smallerMap[pLocation - 5] == '^') {
                    goblin.attack(human);
//                    System.out.println(goblin.getName()+" ambushes "+human.getName()+" and deals "+goblin.dmg());
//                    System.out.println(human.setHealth(human.gethealth()- goblin.damage));
//                    System.out.println("Player engages the Goblin and does "+human.dmg()+" Damage."); //
//                    System.out.println(goblin.setHealth(goblin.hp - human.dmg())) ; // not working
//                    System.out.println(goblin.getHealth());

                    Outer:
                    while (human.hp >= 0 || goblin.hp >= 0) {
                        goblin.attack(human);
                        if (goblin.getHealth() <= 0) {// def not working
                            System.out.println("rip that goblin");
                            if (smallerMap[gLocation] == '^') {
                                smallerMap[gLocation] = '0';
                            } else if (human.getHealth() <= 0) {
                                System.out.println("Human was defeated");
                                isAlive = false;
                            }
                            break Outer;
                        }
                    }
                    System.out.println(human.getName() + " remaining health " + human.getHealth());
                    // goblin is north of us do something...............
                } else if (pLocation > 4 && smallerMap[pLocation - 5] == '0') { //first row
                    int h = pLocation;
                    pLocation = pLocation - 5;
                    smallerMap[pLocation] = 'P';
                    smallerMap[h] = '0';
                    System.out.println("trying to go north");
                    getMap();
                } else {
                    System.out.println("can't go north bud");
                }
                // 01234
                // 56789
                // 10 11 12 13 14
                // 15 16 17 18 19
            } else if (move == 'a') { // going WEST ******************************************

                if (smallerMap[pLocation - 1] == '^') {
                    goblin.attack(human);

                    Outer:
                    while (human.hp >= 0 || goblin.hp >= 0) {
                        goblin.attack(human);
                        if (goblin.getHealth() <= 0) {// def not working
                            System.out.println("rip that goblin");
                            if (smallerMap[gLocation] == '^') {
                                smallerMap[gLocation] = '0';
                            } else if (human.getHealth() <= 0) {
                                System.out.println("Human was defeated");
                            }
                            break Outer;
                        }
                    }
                } else if (pLocation != 0 || pLocation != 5 || pLocation != 10 || pLocation != 15 && smallerMap[pLocation - 1] == '0') { //attempt to go west
                    int h = pLocation;
                    pLocation = pLocation - 1;
                    smallerMap[pLocation] = 'P'; //-1 for left
                    smallerMap[h] = '0';
                    System.out.println("trying to go west");
                    getMap();
                } else {
                    System.out.println("can't go west bud");
                }
            } else if (move == 's') { // going SOUTH ******************************************

                if (smallerMap[pLocation + 5] == '^') {
                    goblin.attack(human);

                    Outer:
                    while (human.hp >= 0 || goblin.hp >= 0) {
                        goblin.attack(human);
                        if (goblin.getHealth() <= 0) {// def not working
                            System.out.println("rip that goblin");
                            if (smallerMap[gLocation] == '^') {
                                smallerMap[gLocation] = '0';
                            } else if (human.getHealth() <= 0) {
                                System.out.println("Human was defeated");
                            }
                            break Outer;
                        }
                    }
                } else if (pLocation < 15 && smallerMap[pLocation + 5] == '0') { //attempt to go south
                    int h = pLocation;
                    pLocation = pLocation + 5;
                    smallerMap[pLocation] = 'P'; // +5 for south
                    smallerMap[h] = '0';
                    System.out.println("trying to go south");
                    getMap();
                } else {
                    System.out.println("can't go south bud");
                }
            } else if (move == 'd') { // going EAST ******************************************

                if (smallerMap[pLocation + 1] == '^') {
                    goblin.attack(human);

                    Outer:
                    while (human.hp >= 0 || goblin.hp >= 0) {
                        goblin.attack(human);
                        if (goblin.getHealth() <= 0) {// def not working
                            System.out.println("rip that goblin");
                            if (smallerMap[gLocation] == '^') {
                                smallerMap[gLocation] = '0';
                            } else if (human.getHealth() <= 0) {
                                System.out.println("Human was defeated");
                            }
                            break Outer;
                        }
                    }
                } else if (pLocation != 4 || pLocation != 9 || pLocation != 14 || pLocation != 10 && smallerMap[pLocation + 1] == '0') { //attempt to go east
                    int h = pLocation;
                    pLocation = pLocation + 1;
                    smallerMap[pLocation] = 'P';
                    smallerMap[h] = '0';
                    System.out.println("trying to go east");
                    getMap();
                } else {
                    System.out.println("can't go east bud");
                }
            } else {
                System.out.println("can't click that");
            }
        }

    }
            catch(Exception e){
            System.out.println(e);
        }





    }
}

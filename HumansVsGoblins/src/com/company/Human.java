package com.company;

import java.util.Random;

public class Human {
    public String name;
    int hp, damage;

    public Human(){

    }

    public Human(String name){
        this.name = name;
        hp = 20;
    }

    public int dmg(){
        Random rand = new Random();
        damage = rand.nextInt(3)+1;
        return damage;
    }

    public int getHealth(){

        return hp;
    }
    public int setHealth(int hp){
        this.hp = hp;
        return hp;
    }


    public String getName(){
        return name;
    }

    //    @Override
//    public String toString(){
//        return "";
//    }



}

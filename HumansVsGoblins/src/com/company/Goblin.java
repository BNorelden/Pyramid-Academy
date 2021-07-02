package com.company;

import java.util.Random;

public class Goblin {
    public String name;
    int hp, damage;


     public Goblin(){

     }
    public Goblin(String name){
            this.name = name;
            hp=10;
    }
    public String getName(){
        return name;
    }

    public int getHealth(){
        return hp;
    }
    public int setHealth(int hp){
        this.hp = hp;
        return hp;
    }

    public int dmg(){
         Random rand = new Random();
        damage = rand.nextInt(3)+1;

        return damage;
    }
    public Object attack(Human human) {

        if(human.getHealth() <=0){
            return human.getName()+" has died game over";
        }
//                    System.out.println(this.getName()+" attacks "+human.getName()+" and deals "+this.dmg());
                    System.out.println("Human's remaining health "+human.setHealth(human.getHealth()- this.dmg()));
                    //System.out.println("Player engages the Goblin and does "+human.dmg()+" Damage."); //human retaliates
                    System.out.println("Goblin's remaining health "+this.setHealth(this.getHealth()- human.dmg()));

        return ("dealt "+dmg()+" to "+human.getName());

    }

    //    @Override
//    public String toString(){
//        return "";
//    }

}

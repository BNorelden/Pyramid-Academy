package com.company;

public abstract class Ship {
    // make this class abstract?
    //extends this class inheritance


    private String shipIcon;
    private int x,y; // might not be neccessary unless each ship is different size but i m not using 2d array
    private char dirction; // to see if its vertical +-10 or horizontal +-1

    //dont for get getters and setters


     Ship(){
        shipIcon = "\uD83D\uDEA2";


    }

    public String getShip(){
        return shipIcon;
    }

    public String damagedShip(){
        shipIcon = "X";
        return shipIcon;

    }

    public String missedShip(){
        shipIcon = "M"; // as Empty?
        return shipIcon;

    }

    public void setShip(int x, int y){
        this.x = x;
        this.y = y;

    }

    public Object getAttackCoor(){
            return  "X: "+x+" Y: "+y;

    }


    @Override
    public String toString() {
        return shipIcon ;
    }
}

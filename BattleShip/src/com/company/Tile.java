package com.company;

public class Tile extends Ship {

    private String  location;

    //dont for get getters and setters


     Tile(){

        location = "\uD83D\uDCA7";

    }

    public String getLocation(){

        return location;
    }

    public String setLocation(String string){
        location = string;
         return location;
    }

    @Override
    public String toString() {
        return location;
    }

//will have to make the tiles
}

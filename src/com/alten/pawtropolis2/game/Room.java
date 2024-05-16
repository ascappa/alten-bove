package com.alten.pawtropolis2.game;

import com.alten.pawtropolis.game.Item;
import com.alten.pawtropolis2.animali.Animal;

import java.awt.print.PrinterAbortException;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private final List<Item> items = new ArrayList<>();

    public Animal animal;

    public static Room createRoomWithRandomAnimal() {
        Room room = new Room();
        room.animal = Animal.getRandomAnimal();
        return room;
    }

    public Room(){
        if(Math.random()<=0.8){
            animal = Animal.getRandomAnimal();
        }
    }

}

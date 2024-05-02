package com.alten.pawtropolis.game;

import com.alten.pawtropolis.animali.Animal;
import com.alten.pawtropolis.animali.AnimalFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Room {
    private String roomName;
    private List<Item> items = new ArrayList<>();
    private Animal animalInRoom;
    private Random random = new Random();


    public Room(String roomName) {
        this.roomName = roomName;
        String animalString = Game.getAvailableAnimals().get(random.nextInt(Game.getAvailableAnimals().size()));
        animalInRoom = AnimalFactory.getAnimal(animalString.toLowerCase());
        for (int i = 0; i < 4; i++) {
            items.add(new Item(Game.getAvailableItems().get(random.nextInt(Game.getAvailableItems().size())).getName()));
        }
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Animal getAnimalInRoom() {
        return animalInRoom;
    }

    public void setAnimalInRoom(Animal animalInRoom) {
        this.animalInRoom = animalInRoom;
    }
}

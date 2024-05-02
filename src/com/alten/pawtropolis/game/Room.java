package com.alten.pawtropolis.game;

import com.alten.pawtropolis.animali.Animal;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String roomName;
    private List<Item> itemsInRoom = new ArrayList<>();
    private Animal animalInRoom;


    public Room() {
        animalInRoom = Animal.getRandomAnimal();
        for (int i = 0; i < 2; i++) {
            itemsInRoom.add(Item.getRandomItem());
        }
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public List<Item> getItemsInRoom() {
        return itemsInRoom;
    }

    public void setItemsInRoom(List<Item> itemsInRoom) {
        this.itemsInRoom = itemsInRoom;
    }

    public Animal getAnimalInRoom() {
        return animalInRoom;
    }

    public void setAnimalInRoom(Animal animalInRoom) {
        this.animalInRoom = animalInRoom;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomName='" + roomName + '\'' +
                ", itemsInRoom=" + itemsInRoom +
                ", animalInRoom=" + animalInRoom +
                '}';
    }
}
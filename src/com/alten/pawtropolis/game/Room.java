package com.alten.pawtropolis.game;

import com.alten.pawtropolis.animali.Animal;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String roomName;
    private List<Item> itemsInRoom = new ArrayList<>();
    private Animal animalInRoom;
    private boolean hasBeenVisited = false;
    private int x;
    private int y;
    private boolean isLocked = false;
    private static int numberOfKeys = 3;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Room(int x, int y) {
        this.x = x;
        this.y = y;
        animalInRoom = Animal.getRandomAnimal();
        for (int i = 0; i < 2; i++) {
            itemsInRoom.add(Item.getRandomItem());
        }
        if (Math.random() < 0.4) {
            itemsInRoom.add(new Item("key", "apre una porta", 1, 1, 0, 0));
        } else {
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

    public boolean getHasBeenVisited() {
        return hasBeenVisited;
    }

    public void setHasBeenVisited(boolean hasBeenVisited) {
        this.hasBeenVisited = hasBeenVisited;
    }

    public boolean isHasBeenVisited() {
        return hasBeenVisited;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
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

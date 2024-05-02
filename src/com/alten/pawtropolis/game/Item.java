package com.alten.pawtropolis.game;

import java.util.Objects;

public class Item {
    private String name;
    private String description;
    private int requiredSlots;
    private int usageLeft = 1;

    public Item(String name) {
        Item currentItem = null;
        for (Item item : Game.getAvailableItems()) {
            if (item.getName().equals(name)) {
                currentItem = item;
            }
        }
        this.name = name;
        assert currentItem != null;
        this.description = currentItem.getDescription();
        this.requiredSlots = currentItem.getRequiredSlots();
    }

    public Item(String name, String description, int requiredSlots) {
        this.name = name;
        this.description = description;
        this.requiredSlots = requiredSlots;
    }

    public Item(String name, String description, int requiredSlots, int usageLeft) {
        this.name = name;
        this.description = description;
        this.requiredSlots = requiredSlots;
        this.usageLeft = usageLeft;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRequiredSlots() {
        return requiredSlots;
    }

    public void setRequiredSlots(int requiredSlots) {
        this.requiredSlots = requiredSlots;
    }

    public int getUsageLeft() {
        return usageLeft;
    }

    public void setUsageLeft(int usageLeft) {
        this.usageLeft = usageLeft;
    }

    public void decrementUsageLeft() {
        usageLeft--;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", requiredSlots=" + requiredSlots +
                '}';
    }
}

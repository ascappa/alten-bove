package com.alten.pawtropolis2.items;


import java.util.*;


public class Item {
    protected String name;
    protected final int REQUIRED_SLOTS = 1;
    protected String description;
    protected int maxNumberOfUses;
    protected List<String> availableItems = new ArrayList<String>(List.of("spada", "pozione", "tirapugni"));

    private static final Random random = new Random();

    public Item() {
    }

    public void use() {
        maxNumberOfUses--;
    }

    public boolean isUsable() {
        return maxNumberOfUses > 0;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getREQUIRED_SLOTS() {
        return REQUIRED_SLOTS;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public Item getRandomItem(String name) {
//        return new Item(items.get(random.nextInt(items.size())).name);
//    }

}


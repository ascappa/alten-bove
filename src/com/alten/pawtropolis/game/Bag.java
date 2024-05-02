package com.alten.pawtropolis.game;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private static Bag instance = null;
    private static final int AVAILABLE_SLOTS = 15;
    private final List<Item> items = new ArrayList<>();

    private Bag() {
        items.add(new Item("tirapugni"));
    }

    public static Bag getInstance() {
        if (instance == null) {
            instance = new Bag();
        }
        return instance;
    }
    public void addItemByName(String name) {
        items.add(new Item(name));
    }
    public List<Item> getItems() {
        return items;
    }

    public void useItem(int idx) {
        Item item = items.get(idx);
        item.decrementUsageLeft();
        if (item.getUsageLeft() == 0) {
            items.remove(idx);
        }
    }
}

package com.alten.pawtropolis2.game;

import com.alten.pawtropolis.game.Item;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Bag {
    private final List<Item> items = new ArrayList<>();
    private static final int AVAILABLE_SLOTS = 15;

    public boolean containsItem(Item item) {
        if (items.contains(item)) {
            return true;
        } else {
            return false;
        }

    }
}

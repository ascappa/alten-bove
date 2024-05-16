package com.alten.pawtropolis.game;

import com.alten.pawtropolis.animali.Animal;
import com.alten.pawtropolis.animali.AnimalFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Item {
    private String name;
    private String description;
    private int requiredSlots = 1;
    private int usageLeft = 1;
    private double damage = 0;
    private double healing = 0;
    private static List<Item> availableItems = new ArrayList<>();
    private static Random random = new Random();

    public Item(String name) {
        Item currentItem = null;
        for (Item item : availableItems) {
            if (item.getName().equals(name)) {
                currentItem = item;
            }
        }
        this.name = name;
        assert currentItem != null;
        this.description = currentItem.getDescription();
        this.requiredSlots = currentItem.getRequiredSlots();
        this.usageLeft = currentItem.usageLeft;
        this.damage = currentItem.damage;
        this.healing = currentItem.healing;
    }

    public Item(String name, String description, int requiredSlots) {
        this.name = name;
        this.description = description;
        this.requiredSlots = requiredSlots;
    }

    public Item(String name, String description, int requiredSlots, int usageLeft, double damage, double healing) {
        this.name = name;
        this.description = description;
        this.requiredSlots = requiredSlots;
        this.usageLeft = usageLeft;
        this.damage = damage;
        this.healing = healing;
    }

    public static Item getRandomItem() {
        return new Item(availableItems.get(random.nextInt(availableItems.size())).name);
    }

    public static void initializeItems() {
        availableItems.add(new Item("spada", "Per tagliare le code dei tuoi avversari. Si rompe dopo 3 utilizzi.", 3,
                3, 2, 0));
        availableItems.add(new Item("tirapugni", "Meglio di tirare un pugno a mani nude. Si rompe dopo 4 utilizzi.",
                2, 40, 1.5, 0));
        availableItems.add(new Item("mela", "Una mela al giorno toglie il leone di torno.", 1, 1, 0, 1));
        availableItems.add(new Item("scudo", "Una protezione dalle belve più feroci. Si rompe dopo 2 utilizzi.", 2, 2
                , 0, 0));
        availableItems.add(new Item("pozione", "Una bevanda rinfrescante dalle proprietà rigenerative.", 2, 1, 0, 2));
        availableItems.add(new Item("sasso", "Un semplice sasso. Usalo per distrarre i tuoi nemici."
                , 1, 1, 0, 0));
        availableItems.add(new Item("carne", "Pregiata carne Wagyū. Nessun animale può resistervi. Usala per rendere " +
                "mansueto l'animale nella stanza oppure per recuperare 2 punti vita.", 4, 1, 0, 0));
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

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getHealing() {
        return healing;
    }

    public void setHealing(double healing) {
        this.healing = healing;
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

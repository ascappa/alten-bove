package com.alten.pawtropolis.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
    private static List<Item> availableItems = new ArrayList<>();
    private static List<Room> rooms;
    private static List<String> availableAnimals = new ArrayList<>(List.of("Aquila", "Leone", "Tigre"));

    // {"spada": {"descrizione": "una spada", "slotRichiesti": 5}}
    public static void start() {
        availableItems.add(new Item("spada", "Per tagliare le code dei tuoi avversari. Si rompe dopo 3 utilizzi.", 3, 3));
        availableItems.add(new Item("tirapugni", "Meglio di tirare un pugno a mani nude. Si rompe dopo 4 utilizzi.", 3, 4));
        availableItems.add(new Item("mela", "Una mela al giorno toglie il leone di torno.", 1));
        availableItems.add(new Item("scudo", "Una protezione dalle belve più feroci. Si rompe dopo 2 utilizzi.", 2, 2));
        availableItems.add(new Item("pozione", "Una bevanda rinfrescante dalle proprietà rigenerative.", 2));
        availableItems.add(new Item("sasso", "Un semplice sasso. Usalo per distrarre i tuoi nemici o tenergli testa.", 1));
        availableItems.add(new Item("carne", "Pregiata carne Wagyū. Nessun animale può resistervi. Usala per rendere mansueto l'animale nella stanza oppure per recuperare 2 punti vita.", 4));
        Bag bag = Bag.getInstance();
        System.out.println(bag.getItems());
        System.out.println();
        System.out.println(new Room("prima stanza").getItems());
    }

    public static List<Item> getAvailableItems() {
        return availableItems;
    }

    public static List<String> getAvailableAnimals() {
        return availableAnimals;
    }
}

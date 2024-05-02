package com.alten.pawtropolis.game;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private static List<List<Room>> rooms = new ArrayList<>();


    // {"spada": {"descrizione": "una spada", "slotRichiesti": 5}}
    public static void start() {
        Item.initializeItems();
        Bag bag = Bag.getInstance();
        System.out.println(bag.getItems());
        System.out.println();
        for (int i = 0; i < 4; i++) {
            List<Room> rowOfRooms = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                rowOfRooms.add(new Room());
            }
            rooms.add(rowOfRooms);
        }
        System.out.println("Un tempo, la città di Pawtropolis era considerata l'utopia del regno animale, ma i suoi\n" +
                "abitanti sono impazziti a causa di un morbo misterioso. Hai scoperto un dungeon che potrebbe avera la\n" +
                "cura che libererebbe Pawtropolis da questa piaga. Purtroppo, ogni stanza del dungeon è sorvegliata\n" +
                "da un animale, quindi ti toccherà combattere! Ma non temere, le stanze contengono anche degli\n" +
                "strumenti che potrai raccogliere dopo aver sconfitto l'animale di turno. Buona fortuna!\n");
        for (var rowOfRooms : rooms) {
            for (Room room : rowOfRooms) {
                System.out.printf(" ? |");
            }
            System.out.println();
            System.out.println("-".repeat(rowOfRooms.size() * 4));
        }
        System.out.println(rooms);
    }

}

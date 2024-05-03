package com.alten.pawtropolis.game;

import com.alten.pawtropolis.animali.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private static List<List<Room>> rooms = new ArrayList<>();
    private static Bag bag = null;
    private static int x = 3;
    private static int y = 2;
/*
[
[5, 2, 3, 2],
[6, 8, 9, 1],
[6, 3, 5, 8]
]
 */

    // {"spada": {"descrizione": "una spada", "slotRichiesti": 5}}
    public static void start() {
        Item.initializeItems();
        bag = Bag.getInstance();
        System.out.println(bag.getItems());
        System.out.println();
        for (int i = 0; i < 6; i++) {
            List<Room> rowOfRooms = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                rowOfRooms.add(new Room(j, i));
            }
            rooms.add(rowOfRooms);
        }
        System.out.println("Un tempo, la città di Pawtropolis era considerata l'utopia del regno animale, ma i suoi\n" +
                "abitanti sono impazziti a causa di un morbo misterioso. Hai scoperto un dungeon che potrebbe avera " +
                "la\n" +
                "cura che libererebbe Pawtropolis da questa piaga. Purtroppo, ogni stanza del dungeon è sorvegliata\n" +
                "da un animale, quindi ti toccherà combattere! Ma non temere, le stanze contengono anche degli\n" +
                "strumenti che potrai raccogliere dopo aver sconfitto l'animale di turno. Buona fortuna!\n");
        rooms.get(y).get(x).setHasBeenVisited(true);
        System.out.println("Oh prode guerriero, qual è il tuo nome? ");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        Player player = new Player(nome);
        System.out.println("Benvenuto nel dungeon, " + ANSI_CYAN + nome + ANSI_RESET + "! Sei la nostra ultima " +
                "speranza...");
        printRooms();
        String command;
        do {
            command = scanner.nextLine();
            int previousX = x;
            int previousY = y;
            switch (command) {
                case "nord":
                    if (y > 0) y--;
                    break;
                case "ovest":
                    if (x > 0) x--;
                    break;
                case "est":
                    if (x < 3) x++;
                    break;
                case "sud":
                    if (y < 3) y++;
                    break;
                default:
                    System.out.println("Direzione non valida!");
                    break;
            }
            rooms.get(y).get(x).setHasBeenVisited(true);
            printRooms();
            if (previousX == x && previousY == y) System.out.println("Non potevi andare in quella direzione");
        } while (!command.equals("bye"));
    }

    private static void printRooms() {
        Animal currentAnimal = getCurrentRoom().getAnimalInRoom();
        for (var rowOfRooms : rooms) {
            for (Room room : rowOfRooms) {
                if (room.getHasBeenVisited()) {
                    if (room.getY() == y && room.getX() == x) {
                        System.out.printf("%s %s %s|",
                                ANSI_YELLOW_BACKGROUND + ANSI_RED,
                                room.getAnimalInRoom().getClass().getSimpleName().substring(0, 1).toUpperCase(),
                                ANSI_RESET);
                    } else {
                        System.out.printf(" %s |",
                                room.getAnimalInRoom().getClass().getSimpleName().substring(0, 1).toUpperCase()
                        );
                    }
                } else {
                    System.out.printf(" ? |");
                }
            }
            System.out.println();
            System.out.println("-".repeat(rowOfRooms.size() * 4));
        }
        System.out.printf("%sNella stanza%s c'è %s\nSpecie: %s\nCibo preferito: %s\n", ANSI_BLUE, ANSI_RESET,
                currentAnimal.getNome(), currentAnimal.getClass().getSimpleName(), currentAnimal.getCiboPreferito());
        if (currentAnimal.hasAttackedFirst()) {
            System.out.println(currentAnimal.getNome() + " attacca per primo!");
            System.out.println("Subisci " + currentAnimal.getDamageDealt() + " danni");
            System.out.println("Ora tocca a te. Scegli cosa fare: ");
            showMenu();
        } else {
            System.out.println("Agisci per primo! Scegli cosa fare: ");
            showMenu();
            System.out.println(currentAnimal.getNome() + " contrattacca!");
            System.out.println("Subisci " + currentAnimal.getDamageDealt() + " danni");
        }

    }

    public static void showMenu(){
        System.out.println("1. attacca");
        for (int i = 0; i < bag.getItems().size(); i++) {
            System.out.println((i + 2) + ". " + bag.getItems().get(i).getName());
        }
    }

    public static Room getCurrentRoom() {
        return rooms.get(y).get(x);
    }

}

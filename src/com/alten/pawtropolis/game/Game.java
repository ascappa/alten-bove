package com.alten.pawtropolis.game;

import com.alten.pawtropolis.animali.Animal;

import java.util.*;

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
    private static String command;
    private static boolean isCombatOver = true;
    private static Player player = null;
    private static int numberOfLockedRooms = 0;

    private static HashMap<String, String> animalEmojis = new HashMap<>(Map.of("leone", "🦁", "aquila", "🦅", "tigre"
            , "🐯"));

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
        bag.addItemByName("tirapugni");
        System.out.println(bag.getItems());
        System.out.println();
        for (int i = 0; i < 4; i++) {
            List<Room> rowOfRooms = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                Room room = new Room(j, i);
                if (Math.random() < 0.4 && numberOfLockedRooms <= 2 && (j != x || i != y) && !room.isHasKey()) {
                    room.setLocked(true);
                    numberOfLockedRooms++;
                }
                rowOfRooms.add(room);
            }
            rooms.add(rowOfRooms);
        }
        System.out.println("Un tempo, la città di Pawtropolis era considerata l'utopia del regno animale, ma i suoi\n" +
                "abitanti sono impazziti a causa di un morbo misterioso. Hai scoperto un dungeon che potrebbe avere" +
                " " +
                "la\n" +
                "cura che libererebbe Pawtropolis da questa piaga. Purtroppo, ogni stanza del dungeon è sorvegliata\n" +
                "da un animale, quindi ti toccherà combattere! Ma non temere, le stanze contengono anche degli\n" +
                "strumenti che potrai raccogliere dopo aver sconfitto l'animale di turno. Buona fortuna!\n");
        System.out.println("Sono disponibili i seguenti comandi: ");
        listCommands();
        rooms.get(y).get(x).setHasBeenVisited(true);
        System.out.println("Oh prode guerriero, qual è il tuo nome? ");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        player = new Player(nome);
        System.out.println("Benvenuto nel dungeon, " + ANSI_CYAN + nome + ANSI_RESET + "! Sei la nostra ultima " +
                "speranza...");
        printRooms();
        printCurrentRoomInfo();

        combatti();
        do {
            do {
                System.out.println("Cosa farai adesso?");
                command = getCommand();
            } while (!executeCommand(command));
        } while (!command.equals("exit"));
    }


    private static boolean moveToRoom(String command) {
        isCombatOver = true;
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
        if (rooms.get(y).get(x).isLocked()) {
            System.out.println("non puoi muoverti in quella stanza!");
            isCombatOver = false;
            x = previousX;
            y = previousY;
            return false;
        }
        if (previousX == x && previousY == y) {
            System.out.println("Non potevi andare in quella direzione");
            isCombatOver = false;
            return false;
        }
        rooms.get(y).get(x).setHasBeenVisited(true);
        printRooms();
        printCurrentRoomInfo();
        combatti();
        return true;
    }

    private static void printRooms() {
        System.out.println();
        int i = 0;
        for (var rowOfRooms : rooms) {
            for (Room room : rowOfRooms) {
                if (room.isHasKey()) {
                    System.out.print(" 🗝️ ┃"
                    );
                } else if (room.isLocked()) {
                    System.out.print(" \uD83D\uDD12 ┃"
                    );
                } else if (room.getHasBeenVisited()) {
                    String animalClass = room.getAnimalInRoom().getClass().getSimpleName().toLowerCase();
                    if (room.getY() == y && room.getX() == x) {
                        System.out.printf("%s %s %s┃",
                                ANSI_PURPLE_BACKGROUND,
                                animalEmojis.get(animalClass),
                                ANSI_RESET);
                    } else {
                        System.out.printf(" %s ┃",
                                animalEmojis.get(animalClass)
                        );
                    }
                } else {
                    System.out.print(" ❓ ┃");
                }

            }
            System.out.println();
            if (i != rooms.size() - 1) System.out.println("―".repeat(rowOfRooms.size() * 3 + 1));
            i++;
        }
        System.out.println();

    }

    public static void showMenu() {
        System.out.println("1. attacca");
        for (int i = 0; i < bag.getItems().size(); i++) {
            System.out.println((i + 2) + ". " + bag.getItems().get(i).getName());
        }
    }

    public static String getCommand() {
        Scanner scanner = new Scanner(System.in);
        String fullCommand;
        fullCommand = scanner.nextLine();
        return fullCommand;
    }

    public static void printCurrentRoomInfo() {
        Animal currentAnimal = getCurrentRoom().getAnimalInRoom();
        if (currentAnimal.getLifepoints() == 0) {
            System.out.println("Qui giace " + currentAnimal.getNome());
            return;
        }
        System.out.printf("%sNella stanza c'è %s%s\nSpecie: %s\nCibo preferito: %s\n", ANSI_BLUE,
                currentAnimal.getNome(), ANSI_RESET
                , currentAnimal.getClass().getSimpleName(), currentAnimal.getCiboPreferito());
        System.out.printf("Se sconfiggi %s puoi scegliere 2 dei seguenti strumenti presenti nella stanza:\n",
                getCurrentAnimal().getNome());
        printItemsInRoom();
    }

    public static Animal getCurrentAnimal() {
        return getCurrentRoom().getAnimalInRoom();
    }

    public static void printBagItems() {
        for (Item item : bag.getItems()) {
            String itemString = "-" + item.getName();
            itemString += "     descrizione: " + item.getDescription();
            if (item.getDamage() > 0) {
                itemString += "    danni: " + item.getDamage();
            }
            if (item.getHealing() > 0) {
                itemString += "     cura: " + item.getHealing();
            }
            itemString += "    utilizzi rimasti: " + item.getUsageLeft();
            System.out.println(itemString);
        }
    }

    public static boolean executeCommand(String command) {

        boolean isValidCommand = true;

        String[] commandParts = command.split(" ", 2);
        switch (commandParts[0]) {
            case "go":
                isValidCommand = moveToRoom(commandParts[1]);
                break;
            case "look":
                printCurrentRoomInfo();
                break;
            case "get":
                for (Item item : getCurrentRoom().getItemsInRoom()) {
                    if (commandParts[1].equals(item.getName()) && getCurrentAnimal().getLifepoints() <= 0) {
                        bag.getItems().add(item);
                        System.out.println("Hai aggiunto " + item.getName() + " al tuo inventario!");
                        getCurrentRoom().getItemsInRoom().remove(item);
                        break;
                    } else {
                        System.out.println(getCurrentAnimal().getNome() + " non è ancora morto! Non puoi prendere " +
                                "l'oggetto");
                        break;
                    }
                }
            case "bag":
                if (bag.getItems().isEmpty()) {
                    System.out.println("La tua borsa è vuota");
                    break;
                }
                System.out.println("Nella tua borsa ci sono:");
                printBagItems();
                break;
            case "attack":
                if (getCurrentAnimal().getLifepoints() == 0) {
                    System.out.println(getCurrentAnimal().getNome() + " è già morto");
                } else {
                    getCurrentAnimal().decreaseLifepoints();
                    System.out.println(getCurrentAnimal().getNome() + " subisce 1 danno.");
                }
                break;
            case "commands":
                listCommands();
                break;
            case "map":
                printRooms();
                break;
            case "use":
                boolean itemFound = false;
                for (Item item : bag.getItems()) {
                    if (item.getName().equals(commandParts[1])) {
                        itemFound = true;
                        System.out.println("Hai usato " + item.getName());
                        if (item.getDamage() > 0) {
                            getCurrentAnimal().decreaseLifepoints(item.getDamage());
                            System.out.println(getCurrentAnimal().getNome() + " subisce " + item.getDamage() + " " +
                                    "danno.");
                        }
                        if (item.getHealing() > 0) {
                            player.setLifepoints(player.getLifepoints() + item.getHealing());
                            System.out.println("Recuperi " + item.getHealing() + " lifepoints");
                        }
                        item.setUsageLeft(item.getUsageLeft() - 1);
                        if (item.getUsageLeft() <= 0) {
                            bag.getItems().remove(item);
                        }
                        break;
                    }
                }
                if (!itemFound) isValidCommand = false;
                break;
            default:
                System.out.println("that wasn't a valid command!");
                isValidCommand = false;
                break;
        }
        return isValidCommand;

    }

    public static Room getCurrentRoom() {
        return rooms.get(y).get(x);
    }

    public static void combatti() {
        if (getCurrentAnimal().getLifepoints() == 0) {
            System.out.println("Ora muoviti in un'altra stanza");
            return;
        }
        Animal currentAnimal = getCurrentAnimal();
        isCombatOver = false;
        boolean isValidCommand;
        do {
            System.out.println(getCurrentAnimal().getNome() + " ha " + getCurrentAnimal().getLifepoints() + " " +
                    "lifepoints!");
            if (currentAnimal.hasAttackedFirst()) {
                System.out.println(currentAnimal.getNome() + " attacca per primo!");
                player.decrementLifepoints(getCurrentAnimal().getDamageDealt());
                System.out.println("Subisci " + currentAnimal.getDamageDealt() + " danni");
                System.out.println("Ti rimangono " + player.getLifepoints() + " lifepoints");
                if (player.getLifepoints() <= 0) {
                    System.out.println("Non hai più lifepoints. Hai perso!");
                    isCombatOver = true;
                    System.exit(0);
                    return;
                }

                do {
                    System.out.println("Ora tocca a te. Scegli cosa fare: ");
                    command = getCommand();
                    isValidCommand = executeCommand(command);
                    if (isCombatOver) return;
                } while (!command.split(" ")[0].equals("attack") && !command.split(" ")[0].equals(
                        "use") || !isValidCommand);
                if (player.getLifepoints() <= 0) {
                    System.out.println("Non hai più lifepoints. Hai perso!");
                    isCombatOver = true;
                    System.exit(0);
                    return;
                }
                if (currentAnimal.getLifepoints() <= 0) {
                    System.out.println("Hai sconfitto " + currentAnimal.getNome());
                    isCombatOver = true;
                    return;
                }
            } else {
                do {
                    System.out.println("Agisci per primo! Scegli cosa fare: ");
                    command = getCommand();
                    isValidCommand = executeCommand(command);
                    if (isCombatOver) return;
                } while (!command.split(" ")[0].equals("attack") && !command.split(" ")[0].equals("use") || !isValidCommand);

                if (currentAnimal.getLifepoints() <= 0) {
                    System.out.println("Hai sconfitto " + currentAnimal.getNome());
                    return;
                } else {
                    System.out.println(currentAnimal.getNome() + " contrattacca!");
                    player.decrementLifepoints(getCurrentAnimal().getDamageDealt());
                    System.out.println("Subisci " + currentAnimal.getDamageDealt() + " danni");
                    if (player.getLifepoints() <= 0) {
                        System.out.println("Non hai più lifepoints. Hai perso!");
                        isCombatOver = true;
                        System.exit(0);
                        return;
                    }
                    System.out.println("Ti rimangono " + player.getLifepoints() + " lifepoints");
                }

            }

        } while (!isCombatOver);
    }

    public static void printItemsInRoom() {
        for (Item item : getCurrentRoom().getItemsInRoom()) {
            String itemString = "-" + item.getName();
            itemString += "     descrizione: " + item.getDescription();
            if (item.getDamage() > 0) {
                itemString += "    danni: " + item.getDamage();
            }
            if (item.getHealing() > 0) {
                itemString += "     cura: " + item.getHealing();
            }
            itemString += "    utilizzi rimasti: " + item.getUsageLeft();
            System.out.println(itemString);
        }
    }

    private static void listCommands() {
        System.out.println("commands - mostra i comandi disponibili al giocatore, che sono quelli elencati qui sotto");
        System.out.println("go <direzione> - spostati nella direzione indicata. Esempio: go sud");
        System.out.println("bag - mostra l'inventario");
        System.out.println("use <item> - usa l'item dall'inventario. Esempio: use spada");
        System.out.println("get <item> - prende l'item dalla stanza e lo aggiunge all'inventario");
        System.out.println("look - mostra le informazioni della stanza corrente");
        System.out.println("attack - attacchi il nemico ed infliggi 1 punto di danno");
        System.out.println("map - stampa la mappa con le stanze");
    }
}

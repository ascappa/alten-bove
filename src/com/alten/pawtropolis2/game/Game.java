package com.alten.pawtropolis2.game;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static List<List<Room>> map = new ArrayList<>();
    public static int numRows = 4;
    public static int numCols = 4;

    public static void start() {
        // [[room, room] ]
        Room room = new Room();
        System.out.println(room.animal);
        for (int i = 0; i < numRows; i++) {
            List<Room> rowOfRooms = new ArrayList<>();
            for (int j = 0; j < numCols; j++) {
                rowOfRooms.add(new Room());
            }
            map.add(rowOfRooms);
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.print("|");
                System.out.print("?");

            }
            System.out.println("|");

        }

    }
}

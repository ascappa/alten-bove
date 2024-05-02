package com.alten.pawtropolis.animali;

import java.time.LocalDate;

public class AnimalFactory {
    public static Animal getAnimal(String species) {
        if (species == null) {
            return null;
        } else if (species.equals("tigre")) {
            return new Tigre("Simba", "croccantini", 5, LocalDate.of(2019, 3, 25), 101, 0.7, 37.8);
        } else if (species.equals("leone")) {
            return new Leone("Mufasa", "carne", 9, LocalDate.of(2015, 7, 17), 130, 1.7, 13.5);

        } else if (species.equals("aquila")) {
            return new Aquila("Amerigo", "etgtg", 34, LocalDate.of(2018, 6, 8), 36, 160, 44);

        }
        return null;
    }
}

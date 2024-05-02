package com.alten.pawtropolis.animali;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Animal leone0 = null;
        Leone leone1 = new Leone("Simba", "croccantini", 5, LocalDate.of(2019, 3, 25), 101, 0.9, 1.1);
        Leone leone2 = new Leone("Mufasa", "carne", 9, LocalDate.of(2015, 7, 17), 130, 1.3, 5.7);
        Leone leone3 = new Leone("Simba", "croccantini", 5, LocalDate.of(2019, 3, 25), 101, 0.7, 37.8);
        Leone leone4 = new Leone("Mufasa", "carne", 9, LocalDate.of(2015, 7, 17), 130, 1.7, 13.5);
        Aquila aquila1 = new Aquila("fdfs", "erwrewr", 34, LocalDate.of(2020, 5, 5), 34, 150, 39);
        Aquila aquila2 = new Aquila("Amerigo", "etgtg", 34, LocalDate.of(2018, 6, 8), 36, 160, 44);
        for (var f : Animal.class.getDeclaredFields()) {
            System.out.println("my field " + f);
        }
        System.out.println(Leone.getLeoni());
        System.out.println(Leone.getPiuAlto());
        System.out.println(Leone.getPiuBasso());
        System.out.println(AnimaleConCoda.getConCodaPiuLunga());
        System.out.println(AnimaleConCoda.getAnimaliConCoda());
        System.out.println(Leone.getPiuPesante());
        System.out.println("L'animale più pesante è " + Animal.getPiuPesante(Specie.LEONE));
        System.out.println(Animal.getPiuPesante(Specie.AQUILA));
    }
}

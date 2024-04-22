package com.alten.lambda;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Operazione somma = (a, b) -> a + b;
        Operazione moltiplicazione = (a, b) -> a * b;
        Operazione sottrazione = (a, b) -> a - b;

        System.out.println(moltiplicazione.calcola(4, 5));
        List<Integer> listaNumeri = new ArrayList<>(List.of(3, 2, 4, 5, 76, 56));
        List<Integer> listaNumeriPari = listaNumeri.stream().filter(n -> n % 2 == 0).toList();
        listaNumeriPari.forEach(n -> {
            System.out.println(n);
        });
        System.out.println(listaNumeriPari);
        System.out.println("I numeri pari moltiplicati per 3 sono " + listaNumeriPari.stream().map(n -> n * 3).toList());
    }
}


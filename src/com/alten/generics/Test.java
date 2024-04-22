package com.alten.generics;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Lista<Integer> lista = new Lista<>(List.of(2, 1, 43, 366, 34));
        lista.add(3);
        lista.add(2);
        lista.add(45);
        lista.add(23);
        lista.remove(2);
        System.out.println("La lista " + lista + " ha lunghezza " + lista.size());
        System.out.printf("L'elemento all'indice %d è %s ", 3, lista.get(3));
        System.out.println("Ho aggiunto l'elemento " + lista.add(58));

    }
}

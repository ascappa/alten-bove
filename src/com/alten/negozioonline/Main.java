package com.alten.negozioonline;

public class Main {
    public static void main(String[] args) {
        Negozio ilMioNegozio = Negozio.getInstance();
        Ordine ordine1 = new Ordine("4321543524523");
        Ordine ordine2 = new Ordine("4523542353252345");
        Ordine ordine3 = new Ordine("4321543524523");
        Articolo mouse = new Articolo("mouse", "un mouse da gioco", 34.56, 7);
        Articolo mouseStrambo = new Articolo("mouse", "un mouse da gioco", 34.56, 7);
        try {
            ilMioNegozio.aggiungiOrdine(ordine1);
            ilMioNegozio.aggiungiOrdine(ordine2);
            ilMioNegozio.aggiungiOrdine(ordine3);
        } catch (RuntimeException e) {
            System.out.println("errore!!!!!!");
        }


        System.out.println(ilMioNegozio.getOrdini());
        ordine1.aggiungiArticolo(mouse);
        ordine1.aggiungiArticolo(mouse);
        ordine1.aggiungiArticolo(mouseStrambo);
        ordine1.aggiungiArticoli(mouse, 34);
        System.out.println(ordine1.getArticoliOrdinati().get(mouse));
    }
}

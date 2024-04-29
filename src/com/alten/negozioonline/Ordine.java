package com.alten.negozioonline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Ordine {
    private final String id;
    private HashMap<Articolo, Integer> articoliOrdinati;

    public Ordine(String id) {
        this.id = id;
        this.articoliOrdinati = new HashMap<>();
    }

    public void aggiungiArticolo(Articolo articolo) {
        if (articoliOrdinati.containsKey(articolo)) {
            articoliOrdinati.put(articolo, articoliOrdinati.get(articolo) + 1);
        } else {
            articoliOrdinati.put(articolo, 1);
        }
    }

    public void aggiungiArticoli(Articolo articolo, int quantitaDaAggiungere) {
        if (articoliOrdinati.containsKey(articolo)) {
            // {maglietta: 5, pantalone: 9, pallone: quantitaDaAggiungere}
            articoliOrdinati.put(articolo, articoliOrdinati.get(articolo) + quantitaDaAggiungere);
        } else {
            articoliOrdinati.put(articolo, quantitaDaAggiungere);
        }
    }

    public HashMap<Articolo, Integer> getArticoliOrdinati() {
        return articoliOrdinati;
    }

    public void setArticoliOrdinati(HashMap<Articolo, Integer> articoliOrdinati) {
        this.articoliOrdinati = articoliOrdinati;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Ordine{" +
                "id='" + id + '\'' +
                ", articoliOrdinati=" + articoliOrdinati +
                '}';
    }
}

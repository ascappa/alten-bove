package com.alten.negozioonline;

import java.util.ArrayList;
import java.util.List;

public class Negozio {
    private static Negozio instance = null;

    private List<Ordine> ordini;


    private Negozio() {
        this.ordini = new ArrayList<>();
    }

    public static synchronized Negozio getInstance() {
        if (instance == null) {
            instance = new Negozio();
        }
        return instance;
    }

    public void aggiungiOrdine(Ordine ordine) {
        for (Ordine o : ordini) {
            if (o.getId().equals(ordine.getId())) {
                throw new RuntimeException("Ordine già esistente");
            }
        }
        ordini.add(ordine);
    }

    public Ordine getOrdineById(String id) {
        for (Ordine o : ordini) {
            if (o.getId().equals(id)) {
                return o;
            }
        }
        throw new RuntimeException("L'ordine non esiste");
    }

    public List<Ordine> getOrdini() {
        return ordini;
    }

    public void setOrdini(List<Ordine> ordini) {
        this.ordini = ordini;
    }

}

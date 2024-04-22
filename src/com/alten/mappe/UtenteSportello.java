package com.alten.mappe;

public class UtenteSportello {
    private String nome;
    // può valere 0, 1, 2, 3, con 3 = priorità massima
    private int priorita;

    public UtenteSportello(String nome, int priorita) {
        this.nome = nome;
        this.priorita = priorita;
    }

    public int getPriorita() {
        return priorita;
    }

    public void setPriorita(int priorita) {
        this.priorita = priorita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

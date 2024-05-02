package com.alten.pawtropolis.animali;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AnimaleConCoda extends Animal {
    private double lunghezzaCoda;

    private static List<AnimaleConCoda> animaliConCoda = new ArrayList<>();

    public AnimaleConCoda(String nome, String ciboPreferito, int eta, LocalDate dataArrivo, double peso, double altezza, double lunghezzaCoda) {
        super(nome, ciboPreferito, eta, dataArrivo, peso, altezza);
        this.lunghezzaCoda = lunghezzaCoda;
        animaliConCoda.add(this);
    }
    public static AnimaleConCoda getConCodaPiuLunga() {
        AnimaleConCoda target = animaliConCoda.getFirst();
        for (AnimaleConCoda l : animaliConCoda) {
            if (l.getLunghezzaCoda() > target.getLunghezzaCoda()) {
                target = l;
            }
        }
        return target;
    }

    public double getLunghezzaCoda() {
        return lunghezzaCoda;
    }

    public void setLunghezzaCoda(double lunghezzaCoda) {
        this.lunghezzaCoda = lunghezzaCoda;
    }

    public static List<AnimaleConCoda> getAnimaliConCoda() {
        return animaliConCoda;
    }

    public static void setAnimaliConCoda(List<AnimaleConCoda> animaliConCoda) {
        AnimaleConCoda.animaliConCoda = animaliConCoda;
    }

    @Override
    public String toString() {
        return "AnimaleConCoda{" +
                "lunghezzaCoda=" + lunghezzaCoda +
                "} " + super.toString();
    }
}

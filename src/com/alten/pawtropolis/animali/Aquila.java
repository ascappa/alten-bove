package com.alten.pawtropolis.animali;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aquila extends Animal {
    private double aperturaAlare;
    private static List<Aquila> aquile = new ArrayList<>();

    public Aquila(String nome, String ciboPreferito, int eta, LocalDate dataArrivo, double peso, double altezza, double aperturaAlare) {
        super(nome, ciboPreferito, eta, dataArrivo, peso, altezza);
        this.aperturaAlare = aperturaAlare;
        lifepoints = 2;
        damageDealt = 0.5;
        chanceToDodge = 0.2;
        chanceToAttackFirst = 0.6;
    }

    public double getAperturaAlare() {
        return aperturaAlare;
    }

    public void setAperturaAlare(double aperturaAlare) {
        this.aperturaAlare = aperturaAlare;
    }


    public static Aquila getConAperturaAlarePiuGrande() {
        Aquila target = aquile.getFirst();
        for (Aquila l : aquile) {
            if (l.getAperturaAlare() > target.getAperturaAlare()) {
                target = l;
            }
        }
        return target;
    }


    @Override
    public String toString() {
        return "Aquila{" +
                "aperturaAlare=" + aperturaAlare +
                "} " + super.toString();
    }
}

package com.alten.pawtropolis.animali;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tigre extends AnimaleConCoda {
    private static List<Tigre> tigri = new ArrayList<>();

    public Tigre(String nome, String ciboPreferito, int eta, LocalDate dataArrivo, double peso, double altezza, double lunghezzaCoda) {
        super(nome, ciboPreferito, eta, dataArrivo, peso, altezza, lunghezzaCoda);
        tigri.add(this);
        lifepoints = 3;
        damageDealt = 1;
        chanceToDodge = 0.15;
        chanceToAttackFirst = 0.4;
    }

    public static List<Tigre> getTigri() {
        return tigri;
    }
    public static Tigre getPiuAlto() {
        Tigre piuAlto = tigri.getFirst();
        for (Tigre l : tigri) {
            if (l.getAltezza() > piuAlto.getAltezza()) {
                piuAlto = l;
            }
        }
        return piuAlto;
    }

    public static Tigre getPiuBasso() {
        Tigre piuBasso = tigri.getFirst();
        for (Tigre l : tigri) {
            if (l.getAltezza() < piuBasso.getAltezza()) {
                piuBasso = l;
            }
        }
        return piuBasso;
    }

    public static Tigre getPiuPesante() {
        Tigre target = tigri.getFirst();
        for (Tigre l : tigri) {
            if (l.getPeso() > target.getPeso()) {
                target = l;
            }
        }
        return target;
    }

    public static Tigre getPiuLeggero() {
        Tigre target = tigri.getFirst();
        for (Tigre l : tigri) {
            if (l.getPeso() < target.getPeso()) {
                target = l;
            }
        }
        return target;
    }
    @Override
    public String toString() {
        return "Tigre{} " + super.toString();
    }
}

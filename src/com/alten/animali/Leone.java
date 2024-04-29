package com.alten.animali;

import java.lang.invoke.MethodHandles;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Leone extends AnimaleConCoda {
    public static List<Leone> leoni = new ArrayList<>();


    public Leone(String nome, String ciboPreferito, int eta, LocalDate dataArrivo, double peso, double altezza, double lunghezzaCoda) {
        super(nome, ciboPreferito, eta, dataArrivo, peso, altezza, lunghezzaCoda);
        leoni.add(this);
    }

    public static List<Leone> getLeoni() {
        return leoni;
    }

    public static void setLeoni(List<Leone> leoni) {
        Leone.leoni = leoni;
    }

    public static Leone getPiuAlto() {
        Leone piuAlto = leoni.getFirst();
        for (Leone l : leoni) {
            if (l.getAltezza() > piuAlto.getAltezza()) {
                piuAlto = l;
            }
        }
        return piuAlto;
    }

    public static Leone getPiuBasso() {
        Leone piuBasso = leoni.getFirst();
        for (Leone l : leoni) {
            if (l.getAltezza() < piuBasso.getAltezza()) {
                piuBasso = l;
            }
        }
        return piuBasso;
    }

    public static Leone getPiuPesante() {
        Leone target = leoni.getFirst();
        for (Leone l : leoni) {
            if (l.getPeso() > target.getPeso()) {
                target = l;
            }
        }
        return target;
    }

    public static Leone getPiuLeggero() {
        Leone target = leoni.getFirst();
        for (Leone l : leoni) {
            if (l.getPeso() < target.getPeso()) {
                target = l;
            }
        }
        return target;
    }

    private static Leone getByAltezza(boolean b) {
        Leone target = leoni.getFirst();
        // [2, 3, 1, 5, 9, 4]
        // -2
        if (b) {
            for (Leone l : leoni) {
                if (l.getAltezza() < target.getAltezza()) {
                    target = l;
                }
            }
        } else {
            for (Leone l : leoni) {
                if (l.getAltezza() > target.getAltezza()) {
                    target = l;
                }
            }
        }
        return target;
    }

    private static Leone getByAltezza() {
        Leone target = leoni.getFirst();
        // [2, 3, 1, 5, 9, 4]
        // -2

        for (Leone l : leoni) {
            if (l.getAltezza() < target.getAltezza()) {
                target = l;
            }
        }

        return target;
    }

    private static Leone getByAltezzaSmart(int multiplier) {
        Leone target = leoni.getFirst();
        // [2, 3, 1, 5, 9, 4]
        // -2
        // 4 > 3
        // -4 > -3
        // num1 < num2
        // -num1 > -num2
        for (Leone l : leoni) {
            if (multiplier * l.getAltezza() < multiplier * target.getAltezza()) {
                target = l;
            }
        }
        // 2 < 3
        // -2 > -3
        return target;
    }

//    public static Leone getPiuPesante() {
//        Leone piuPesante = leoni.getFirst();
//        for (Leone l : leoni) {
//    }

    @Override
    public String toString() {
        return "Leone{} " + super.toString();
    }
}

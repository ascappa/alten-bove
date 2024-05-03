package com.alten.pawtropolis.animali;

import java.time.LocalDate;

public class AnimalFactory {
    public static Animal getAnimal(String species, String nome, String ciboPreferito, int eta, LocalDate dataDiArrivo, double peso, double altezza, double aperturaOppureLunghezza) {
        if (species == null) {
            return null;
        } else if (species.equals("tigre")) {
            return new Tigre(nome, ciboPreferito, eta, dataDiArrivo, peso, altezza, aperturaOppureLunghezza);
        } else if (species.equals("leone")) {
            return new Leone(nome, ciboPreferito, eta, dataDiArrivo, peso, altezza, aperturaOppureLunghezza);

        } else if (species.equals("aquila")) {
            return new Aquila(nome, ciboPreferito, eta, dataDiArrivo, peso, altezza, aperturaOppureLunghezza);
        }
        return null;
    }


}

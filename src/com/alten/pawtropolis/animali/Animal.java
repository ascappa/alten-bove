package com.alten.pawtropolis.animali;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Animal {
    public static final List<String> availableNames = new ArrayList<>(List.of("Mufasa", "Pumba", "Annibale",
            "Esmeralda", "Artemide", "Geppetto", "Michelangelo", "Scar", "Skipper"));
    private static List<String> availableSpecies = new ArrayList<>(List.of("aquila", "leone", "tigre"));
    public static List<String> availableFoods = List.of("carne", "caramelle", "patatine", "topi", "zebra");
    private String nome;
    private String ciboPreferito;
    private int eta;
    private LocalDate dataArrivo;
    private double peso;
    private double altezza;
    // {"tigre": [tigre1, tigre2, ...], "aquila": [aquila1, aquila2, ...]}
    protected static HashMap<String, List<Animal>> animali = new HashMap<>();
    private static Random random = new Random();
    protected double lifepoints;
    protected double damageDealt;
    protected double chanceToDodge;
    protected double chanceToAttackFirst;

    public Animal(String nome, String ciboPreferito, int eta, LocalDate dataArrivo, double peso, double altezza) {
        this.nome = nome;
        this.ciboPreferito = ciboPreferito;
        this.eta = eta;
        this.dataArrivo = dataArrivo;
        this.peso = peso;
        this.altezza = altezza;
        String classeCorrente = this.getClass().getSimpleName().toUpperCase();
        animali.computeIfAbsent(classeCorrente, _ -> new ArrayList<>());
        animali.get(classeCorrente).add(this);
    }


    public static Animal getRandomAnimal() {
        return AnimalFactory.getAnimal(availableSpecies.get(random.nextInt(availableSpecies.size())),
                availableNames.get(random.nextInt(availableNames.size())),
                availableFoods.get(random.nextInt(availableFoods.size())), random.nextInt(40), LocalDate.of(2019,
                        random.nextInt(12) + 1, random.nextInt(20) + 1), random.nextDouble(30), random.nextDouble(30),
                random.nextDouble(30));
    }

    public static Animal getPiuAlto(Specie specie) {
        var lista = animali.get(String.valueOf(specie));
        Animal target = lista.getFirst();
        for (Animal a : lista) {
            if (a.getAltezza() > target.getAltezza()) {
                target = a;
            }
        }
        return target;
    }

    public static Animal getPiuBasso(Specie specie) {
        var lista = animali.get(String.valueOf(specie));
        Animal target = lista.getFirst();
        for (Animal a : lista) {
            if (a.getAltezza() < target.getAltezza()) {
                target = a;
            }
        }
        return target;
    }

    public boolean hasDodged() {
        return Math.random() < chanceToDodge;
    }

    public boolean hasAttackedFirst() {
        return Math.random() < chanceToAttackFirst;
    }

    public static Animal getPiuPesante(Specie specie) {
        var lista = animali.get(String.valueOf(specie));
        Animal target = lista.getFirst();
        for (Animal a : lista) {
            if (a.getPeso() > target.getPeso()) {
                target = a;
            }
        }
        return target;
    }

    public static Animal getPiuLeggero(Specie specie) {
        var lista = animali.get(String.valueOf(specie));
        Animal target = lista.getFirst();
        for (Animal a : lista) {
            if (a.getPeso() < target.getPeso()) {
                target = a;
            }
        }
        return target;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCiboPreferito() {
        return ciboPreferito;
    }

    public void setCiboPreferito(String ciboPreferito) {
        this.ciboPreferito = ciboPreferito;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public LocalDate getDataArrivo() {
        return dataArrivo;
    }

    public void setDataArrivo(LocalDate dataArrivo) {
        this.dataArrivo = dataArrivo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    public double getLifepoints() {
        return lifepoints;
    }

    public void setLifepoints(double lifepoints) {
        this.lifepoints = lifepoints;
    }

    public double getDamageDealt() {
        return damageDealt;
    }

    public void setDamageDealt(double damageDealt) {
        this.damageDealt = damageDealt;
    }

    public void decreaseLifepoints() {
        lifepoints--;
    }

    @Override
    public String toString() {
        return "Animale{" +
                "nome='" + nome + '\'' +
                ", ciboPreferito='" + ciboPreferito + '\'' +
                ", eta=" + eta +
                ", dataArrivo=" + dataArrivo +
                ", peso=" + peso +
                ", altezza=" + altezza +
                '}';
    }
}

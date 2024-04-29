package com.alten.animali;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Animale {
    private String nome;
    private String ciboPreferito;
    private int eta;
    private LocalDate dataArrivo;
    private double peso;
    private double altezza;


    protected static HashMap<String, List<Animale>> animali = new HashMap<>();

    public Animale(String nome, String ciboPreferito, int eta, LocalDate dataArrivo, double peso, double altezza) {
        this.nome = nome;
        this.ciboPreferito = ciboPreferito;
        this.eta = eta;
        this.dataArrivo = dataArrivo;
        this.peso = peso;
        this.altezza = altezza;
        System.out.println(this.getClass().getSimpleName());
        String classeCorrente = this.getClass().getSimpleName().toUpperCase();
        Animale.animali.computeIfAbsent(classeCorrente, _ -> new ArrayList<>());
        Animale.animali.get(classeCorrente).add(this);
    }

    public static Animale getPiuPesante(Specie specie) {
        var lista = animali.get(String.valueOf(specie));
        Animale target = lista.getFirst();
        for (Animale a : lista) {
            if (a.getPeso() > target.getPeso()) {
                target = a;
            }
        }
        return target;
    }

    public static Animale getPiuBasso(Specie specie) {
        var lista = animali.get(String.valueOf(specie));
        Animale target = lista.getFirst();
        for (Animale a : lista) {
            if (a.getAltezza() > target.getPeso()) {
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

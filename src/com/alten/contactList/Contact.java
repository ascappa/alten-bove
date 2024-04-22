package com.alten.contactList;

public class Contact {
    private String nome;
    private String cognome;
    private String numeroDiTelefono;
    private String indirizzoEmail;

    public Contact(String nome, String cognome, String numeroDiTelefono, String indirizzoEmail) {
        this.nome = nome;
        this.cognome = cognome;
        this.numeroDiTelefono = numeroDiTelefono;
        this.indirizzoEmail = indirizzoEmail;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNumeroDiTelefono() {
        return numeroDiTelefono;
    }

    public void setNumeroDiTelefono(String numeroDiTelefono) {
        this.numeroDiTelefono = numeroDiTelefono;
    }

    public String getIndirizzoEmail() {
        return indirizzoEmail;
    }

    public void setIndirizzoEmail(String indirizzoEmail) {
        this.indirizzoEmail = indirizzoEmail;
    }
}

package alten.contact;

import java.io.Serializable;

/**
 * Classe che rappresenta un contatto
 */
public class Contact implements Serializable {
    private String nome; // nome del contatto
    private String cognome;
    private String numeroTelefono;
    private String email;

    public Contact(String nome, String cognome, String numeroTelefono, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.numeroTelefono = numeroTelefono;
        this.email = email;
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

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return contact.toString().equals(this.toString());
    }

    @Override
    public String toString() {
        return "Contact{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", numeroTelefono='" + numeroTelefono + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

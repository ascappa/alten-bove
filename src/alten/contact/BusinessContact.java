package alten.contact;


public class BusinessContact extends Contact {
    private String nomeAzienda;

    public BusinessContact(String nome, String cognome, String numeroTelefono, String email, String nomeAzienda) {
        super(nome, cognome, numeroTelefono, email);
        this.nomeAzienda = nomeAzienda;
    }

    public String getNomeAzienda() {
        return nomeAzienda;
    }

    public void setNomeAzienda(String nomeAzienda) {
        this.nomeAzienda = nomeAzienda;
    }

    @Override
    public String toString() {
        return "BusinessContact{" +
                "nomeAzienda='" + nomeAzienda + '\'' +
                ", nome='" + getNome() + '\'' +
                ", cognome='" + getCognome() + '\'' +
                ", numeroTelefono='" + getNumeroTelefono() + '\'' +
                ", email='" + getEmail() + '\'' +
                '}';
    }
}

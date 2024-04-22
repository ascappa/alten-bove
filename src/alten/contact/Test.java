package alten.contact;

import java.io.IOException;
import java.util.List;

public class Test {

    static final String FILENAME = "contatti.ser";
    public static void main(String[] args) throws IOException {
        ContactList contactList = new ContactList();

        contactList.loadFromFile(FILENAME);

        System.out.println("\nDopo aver caricato i contatti da file:");
        for (Contact c : contactList.getRubrica()) {
            System.out.println(c);
        }

        Contact contact1 = new Contact("Mario", "Rossi", "1234567890", "mario.rossi@gmail.com");
        Contact contact2 = new BusinessContact("Luigi", "Bianchi", "0987654321", "luigi.bianchi@yahoo.it", "Bianchi Srl");
        Contact contact3 = new Contact("Anna", "Verdi", "1122334455", "anna.verdi@hotmail.it");

        contactList.addContact(contact1);
        contactList.addContact(contact2);
        contactList.addContact(contact3);

        System.out.println("Dopo aver aggiunto i contatti:");
        for (Contact c : contactList.getRubrica()) {
            System.out.println(c);
        }

        Contact newContact = new Contact("Mario", "Rossi", "1234567890", "mario.rossi@newmail.com");
        contactList.modifyContact("1234567890", newContact);

        System.out.println("\nDopo aver modificato il contatto di Mario Rossi:");
        for (Contact c : contactList.getRubrica()) {
            System.out.println(c);
        }

        contactList.removeContact(newContact);

        System.out.println("\nDopo aver rimosso il contatto di Mario Rossi:");
        for (Contact c : contactList.getRubrica()) {
            System.out.println(c);
        }

        List<Contact> searchResults = contactList.searchContact("Luigi");
        System.out.println("\nRisultati della ricerca per 'Luigi':");
        for (Contact c : searchResults) {
            System.out.println(c);
        }

        contactList.sortContacts();
        System.out.println("\nDopo aver ordinato i contatti per cognome:");
        for (Contact c : contactList.getRubrica()) {
            System.out.println(c);
        }

    }
}

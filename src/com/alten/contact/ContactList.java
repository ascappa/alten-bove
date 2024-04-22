package com.alten.contact;

import java.io.*;
import java.util.*;

public class ContactList {
    private final List<Contact> rubrica;

    public ContactList() {
        this.rubrica = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        for (Contact c : rubrica) {
            if (c.equals(contact)) {
                throw new IllegalArgumentException("Il contatto esiste già nella lista!");
            }
        }
        rubrica.add(contact);
    }

    public void modifyContact(String numeroTelefono, Contact newContact) {
        for (int i = 0; i < rubrica.size(); i++) {
            if (rubrica.get(i).getNumeroTelefono().equals(numeroTelefono)) {
                rubrica.set(i, newContact);
                return;
            }
        }
        throw new IllegalArgumentException("Il contatto non esiste nella lista!");
    }

    public void removeContact(Contact contact) {
        if (!rubrica.remove(contact)) {
            throw new IllegalArgumentException("Il contatto non esiste nella lista!");
        }
    }

    public List<Contact> searchContact(String searchString) {
        List<Contact> result = new ArrayList<>();
        for (Contact c : rubrica) {
            if (c.getNome().contains(searchString) ||
                    c.getCognome().contains(searchString) ||
                    c.getEmail().contains(searchString) ||
                    c.getNumeroTelefono().contains(searchString)) {
                result.add(c);
            }
        }
        return result;
    }
    public List<Contact> getRubrica() {
        return rubrica;
    }

    public void sortContacts() {

        rubrica.sort(new Comparator<Contact>() {
            @Override
            public int compare(Contact c1, Contact c2) {
                return c1.getCognome().compareTo(c2.getCognome());
            }
        });
    }

    public void loadFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

    }
}

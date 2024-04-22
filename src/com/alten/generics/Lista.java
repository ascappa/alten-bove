package com.alten.generics;

import java.util.ArrayList;
import java.util.List;

public class Lista<T> {
    private List<T> lista = new ArrayList<>();

    public Lista(List<T> lista) {
        this.lista = new ArrayList<>(lista);
    }

    public Lista() {

    }

    public T get(int idx) {
        return lista.get(idx);
    }

    public T add(T element) {
        lista.add(element);
        return element;
    }

    public void remove(T element) {
        lista.remove(element);
    }

    public T remove(int idx) {
        return lista.remove(idx);
    }

    public int size() {
        return lista.size();
    }

    @Override
    public String toString() {
        return lista.toString();
    }
}

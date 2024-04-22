package com.alten.mappe;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        Deque<String> coda1 = new LinkedList<>();
        coda1.add("paperino");
        coda1.add("topolino");
        coda1.add("minnie");
        System.out.println("Elemento in testa: " + coda1.peekLast());
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new TreeSet<>();
        Set<String> set3 = new LinkedHashSet<>();
        set1.add("un");
        set1.add("dos");
        set1.add("tres");
        set1.add("bailante maria");
        set2.add("un");
        set2.add("dos");
        set2.add("tres");
        set2.add("bailante maria");
        set3.add("un");
        set3.add("dos");
        set3.add("tres");
        set3.add("bailante maria");
        System.out.println(set1);
        System.out.println(set2);
        System.out.println(set3);
        System.out.println("hello".hashCode());
        for (String s : set1) {
            System.out.println(s + " " + s.hashCode());
        }
    }
}

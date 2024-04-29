package com.alten.observer;

public class Test {
    public static void main(String[] args) {
        WebPage myPage = new WebPage();
        Client myClient = new Client();
        myPage.addObserver(myClient);
        myPage.setContent("ma che bella pagina");
        System.out.println("test funziona");

    }
}

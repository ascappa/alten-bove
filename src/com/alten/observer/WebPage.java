package com.alten.observer;

import java.util.Observable;

public class WebPage extends Observable {
    private String content = "Ciao mondo";
    public void setContent(String content) {
        this.content = content;
        setChanged();
        notifyObservers(content);
    }
}

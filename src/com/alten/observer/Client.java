package com.alten.observer;

import java.util.Observable;
import java.util.Observer;

public class Client implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("The page has updated with content " + arg);
    }
}

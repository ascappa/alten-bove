package com.alten.pawtropolis2.game;

public class Player {
    private String name;
    private double lifepoints = 50;

    public Player(String name, double lifepoints) {
        this.name = name;
        this.lifepoints = lifepoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLifepoints() {
        return lifepoints;
    }

    public void setLifepoints(double lifepoints) {
        this.lifepoints = lifepoints;
    }

    public void decreaseLP(double amount) {
        lifepoints -= amount;
    }
}
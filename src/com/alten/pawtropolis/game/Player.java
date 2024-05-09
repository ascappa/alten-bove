package com.alten.pawtropolis.game;

public class Player {
    private String name;
    private double lifepoints = 5;

    public Player(String name) {
        this.name = name;
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

    public void decrementLifepoints(double amountToDecrement) {
        lifepoints -= amountToDecrement;
    }
}

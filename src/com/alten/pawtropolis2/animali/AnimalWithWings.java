package com.alten.pawtropolis2.animali;

import java.time.LocalDate;
import java.util.Objects;

public abstract class AnimalWithWings extends Animal {
    protected AnimalWithWings(String name, double lifePoints) {
        super(name,lifePoints);
    }

}
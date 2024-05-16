package com.alten.pawtropolis2.animali;

import org.w3c.dom.DOMErrorHandler;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public abstract class Animal {
    private String name;
    private double lifePoints;
    protected static List<String> availableSpecies = new ArrayList<>(List.of("Lion", "Tiger", "Eagle"));
    public static final List<String> availableNames = new ArrayList<>(List.of("Mufasa", "Pumba", "Annibale",
            "Esmeralda", "Artemide", "Geppetto", "Michelangelo", "Scar", "Skipper"));

    protected Animal(String name, double lifePoints) {
        this.name = name;
        this.lifePoints = lifePoints;
    }

    public static Animal getRandomAnimal() {
        try {
            Random random = new Random();
            int speciesIndex = random.nextInt(availableSpecies.size());
            int nameIndex = random.nextInt(availableNames.size());
            Class<?> animalClass =
                    Class.forName("com.alten.pawtropolis2.animali." + availableSpecies.get(speciesIndex));
            Constructor<?> constructor = animalClass.getDeclaredConstructor(String.class);
            constructor.setAccessible(true);
            return (Animal) constructor.newInstance(availableNames.get(nameIndex));

        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new RuntimeException("An error occurred while creating the animal.", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(double lifePoints) {
        this.lifePoints = lifePoints;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", lifePoints=" + lifePoints +
                ", specie=" + this.getClass().getSimpleName() +
                '}';
    }
}
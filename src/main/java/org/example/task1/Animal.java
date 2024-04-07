package org.example.task1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Animal implements Counter {

    private static final Logger logger = LoggerFactory.getLogger(Animal.class);
    protected String name;
    protected int currentRunConstraint = 0;
    protected int currentSwimConstraint = 0;
    protected static int animalCount = 0;

    public Animal() {
        animalCount++;
    }

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public int getCurrentRunConstraint() {
        return currentRunConstraint;
    }

    public int getCurrentSwimConstraint() {
        return currentSwimConstraint;
    }

    protected abstract void run(int distance);

    protected void swim(int distance){
        logger.info("По идеи оно:{} проплывет на {}, но  это не точно", name, distance);
    };

    @Override
    public int count() {
        return animalCount;
    }
}

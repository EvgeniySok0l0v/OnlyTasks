package org.example.task1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for Animal
 */
public abstract class Animal implements Counter {
    //logger
    private static final Logger logger = LoggerFactory.getLogger(Animal.class);
    protected String name;
    protected int currentRunConstraint = 0;
    protected int currentSwimConstraint = 0;
    protected static int animalCount = 0;

    /**
     * No-args constructor
     */
    public Animal() {
        animalCount++;
    }

    /**
     * Constructor for animal
     *
     * @param name - of animal
     */
    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method get current constraint of run for this animal
     *
     * @return - value of currentRunConstraint
     */
    public int getCurrentRunConstraint() {
        return currentRunConstraint;
    }

    /**
     * Method get current constraint of swim for this animal
     *
     * @return - value of currentSwimConstraint
     */
    public int getCurrentSwimConstraint() {
        return currentSwimConstraint;
    }

    /**
     * Method for run animal
     *
     * @param distance - distance
     */
    protected abstract void run(int distance);

    /**
     * Method for swim animal
     *
     * @param distance - distance
     */
    protected void swim(int distance){
        logger.info("По идеи оно:{} проплывет на {}, но  это не точно", name, distance);
    };

    @Override
    public int count() {
        return animalCount;
    }
}

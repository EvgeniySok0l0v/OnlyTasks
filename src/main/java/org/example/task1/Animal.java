package org.example.task1;

public abstract class Animal implements Counter {

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

    protected abstract void swim(int distance);

    @Override
    public int count() {
        return animalCount;
    }
}

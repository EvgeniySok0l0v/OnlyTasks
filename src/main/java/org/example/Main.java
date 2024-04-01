package org.example;

import org.example.task1.Animal;
import org.example.task1.Cat;
import org.example.task1.Dog;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("1");
        Dog dog2 = new Dog("2");
        dog.run(100);
        dog.run(450);
        dog2.run(455);
        Animal cat = new Cat();

        System.out.println(dog.count());
        System.out.println(cat.count());
    }
}
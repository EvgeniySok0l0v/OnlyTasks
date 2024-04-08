package org.example;

import org.example.task1.Cat;
import org.example.task1.Dog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Main {
    //logger
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        Dog dog = new Dog("Dog1");
        Dog dog2 = new Dog("Dog2");
        dog.run(100);
        dog.run(450);
        dog2.run(455);


        //миска
        Cat.Bowl bowl = new Cat.Bowl();
        //котики
        List<Cat> cats = List.of(
                new Cat("Cat1"),
                new Cat("Cat2"),
                new Cat("Cat3"),
                new Cat("Cat4"),
                new Cat("Cat5"));

        //добавил еды, теперь там 49
        bowl.fillBowl(39);

        cats.forEach(cat -> bowl.feed(cat, 10));
        cats.forEach(cat -> logger.info("{} сыт? - {}", cat.getName(), cat.isWellFed()));
    }
}
package org.example.task1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for Cat
 */
public class Cat extends Animal{
    //logger
    private static final Logger logger = LoggerFactory.getLogger(Cat.class);
    private static int catCount = 0;
    private boolean wellFed = false;

    /**
     * No-args Constructor
     */
    public Cat() {
        catCount++;
    }

    /**
     * Constructor with name of animal
     *
     * @param name - of cat
     */
    public Cat(String name) {
        super(name);
        catCount++;
    }

    public boolean isWellFed() {
        return wellFed;
    }

    public void setWellFed(boolean wellFed) {
        this.wellFed = wellFed;
    }

    /**
     * Method run for Cat
     *
     * @param distance - distance
     */
    @Override
    public void run(int distance) {
        int runResult = ConstraintConstants.CAT_RUN - distance - getCurrentRunConstraint();
        if(runResult >= 0){
            logger.info("{} пробежал:{}", super.name ,distance);
            super.currentRunConstraint = runResult;
        } else {
            logger.info("{} не может пробежать:{}, у него откажут лапы, но его лап хватит еще на:{}",
                    super.name, distance, getCurrentRunConstraint());
        }
    }

    /**
     * Count cats
     *
     * @return - number of cats
     */
    @Override
    public int count() {
        return catCount;
    }

    /**
     * Class for Bowl
     */
    public static class Bowl {
        private int bowlVolume = 10;

        /**
         * No-args Constructor
         */
        public Bowl() {
        }

        public int getBowlVolume() {
            return bowlVolume;
        }

        /**
         * Method for feed a cat
         *
         * @param cat - cat
         * @param value - how many cat need to eat to be well-fed
         */
        public void feed(Cat cat, int value){
            //устанавливаю новый объем миски(тип сколько там корма осталось), если value <= bowlVolume кот поел и сыт
            bowlVolume = (bowlVolume < value) ? bowlVolume : bowlVolume - value;
            cat.setWellFed((bowlVolume - value) >= 0);
        }

        /**
         * Method for add food to bowl
         *
         * @param value - how much food we add to bowl
         */
        public void fillBowl(int value){
            bowlVolume += value;
        }
    }
}

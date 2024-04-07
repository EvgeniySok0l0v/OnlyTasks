package org.example.task1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cat extends Animal{

    private static final Logger logger = LoggerFactory.getLogger(Cat.class);
    private static int catCount = 0;
    public static int bowlVolume = 10;

    private boolean wellFed = false;
    public Cat() {
        catCount++;
    }

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
        int runResult = ConstraintConstants.DOG_RUN - distance - getCurrentRunConstraint();
        if(runResult >= 0){
            logger.info(super.name + " пробежал:" + distance);
            super.currentRunConstraint = runResult;
        } else {
            logger.info(super.name + " не может пробежать:" + distance
                    + ", у него откажут лапы, но его лап хватит еще на:" + getCurrentRunConstraint());
        }
    }

    public void feed(int value){
        //переписать эту шляпу
        bowlVolume = (bowlVolume < value) ? bowlVolume : bowlVolume - value;
    }

    public static void fillBowl(int value){
        bowlVolume += value;
    }


    @Override
    public int count() {
        return catCount;
    }


}

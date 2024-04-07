package org.example.task1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Dog extends Animal {

    private static final Logger logger = LoggerFactory.getLogger(Dog.class);
    private static int dogCount = 0;

    public Dog() {
        super();
        dogCount++;
    }

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    public int getCurrentRunConstraint() {
        return super.getCurrentRunConstraint();
    }

    @Override
    public int getCurrentSwimConstraint() {
        return super.getCurrentSwimConstraint();
    }

    /**
     * Method run for Dog
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

    /**
     * Method swim for Dog
     *
     * @param distance - distance
     */
    @Override
    public void swim(int distance) {
        int swimResult = ConstraintConstants.DOG_RUN - distance - getCurrentSwimConstraint();
        if(swimResult >= 0){
            logger.info(super.name + " проплыл:" + distance);
            super.currentSwimConstraint = swimResult;
        } else {
            logger.info(super.name + " не может проплыть:" + distance
                    + ", он выплюнет легкие, но он еще может проплыть:" + getCurrentSwimConstraint());
        }
    }

    /**
     * Method count Dogs
     *
     * @return value of dogCount
     */
    @Override
    public int count() {
        return dogCount;
    }
}

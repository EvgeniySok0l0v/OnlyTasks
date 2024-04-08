package org.example.task1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for Dog
 */
public class Dog extends Animal {

    //logger
    private static final Logger logger = LoggerFactory.getLogger(Dog.class);
    private static int dogCount = 0;
    /**
     * No-args Constructor
     */
    public Dog() {
        super();
        dogCount++;
    }

    /**
     * Constructor with name of animal
     *
     * @param name - of dog
     */
    public Dog(String name) {
        super(name);
        dogCount++;
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
            logger.info("{} пробежал:{}", super.name, distance);
            super.currentRunConstraint = runResult;
        } else {
            logger.info("{} не может пробежать:{}, у него откажут лапы, но его лап хватит еще на:{}",
                    super.name, distance, getCurrentRunConstraint());
        }
    }

    /**
     * Method swim for Dog
     *
     * @param distance - distance
     */
    @Override
    public void swim(int distance) {
        int swimResult = ConstraintConstants.DOG_SWIM - distance - getCurrentSwimConstraint();
        if(swimResult >= 0){
            logger.info("{} проплыл:{}", super.name, distance);
            super.currentSwimConstraint = swimResult;
        } else {
            logger.info("{} не может проплыть: {}, он выплюнет легкие, но он еще может проплыть: {}",
                    super.name, distance, getCurrentSwimConstraint());
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

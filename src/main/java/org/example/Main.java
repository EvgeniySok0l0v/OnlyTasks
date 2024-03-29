package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    //logger
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        /*
        2. Создать массив из 5 сотрудников.
         */
        Employee[] employees = new Employee[]{
                new Employee(
                        "Titov Nikita",
                        "Engineer",
                        "nikitos@gmail.com",
                        "+375(44)123-12-32",
                        2000,
                        27
                ),
                new Employee(
                        "Petrov Arnold",
                        "Cashier",
                        "belie_temki_228@gmail.com",
                        "+375(44)163-42-32",
                        1500,
                        21
                ),
                new Employee(
                        "Anisimov Anatoly",
                        "Security guard",
                        "Anisimov_Anatoly1973@mail.ru",
                        "+375(33)333-42-33",
                        1100,
                        51
                ),
                new Employee(
                        "Arakelyan Arsen Ogasenovich",
                        "Owner",
                        "arsenchik20@mail.ru",
                        "+375(29)777-77-77",
                        Double.MAX_VALUE,
                        33
                ),
                new Employee(
                        "Luiva Elena",
                        "Conductor",
                        "len0chka69@mail.ru",
                        "+375(29)346-77-14",
                        1345,
                        37
                )
        };

        //ну инфу покажем что ли
        for (Employee employee : employees){
            employee.printInfo();
        }

        Park park = new Park("Any name");
        Park.Attraction attraction1 = park.new Attraction("anyName1", 12, "10:00 - 19:30");
        logger.info(attraction1.toString());

    }
}
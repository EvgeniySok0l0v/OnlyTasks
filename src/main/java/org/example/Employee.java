package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
Конструктор класса должен заполнять эти поля при создании объекта.
Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
 */
/**
 * Class Employee
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Employee {
    //logger
    private static final Logger logger = LoggerFactory.getLogger(Employee.class);

    private String fullName;
    private String jobTitle;
    private String email;
    private String phone;
    private double salary;
    private int age;

    /**
     * Method for print information about Employee to console
     */
    public void printInfo(){
        logger.info(this.toString());
    }
}

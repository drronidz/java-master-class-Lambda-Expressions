package com.drronidz;/*
    CREATED BY : ABD EL HALIM
    PROJECT NAME : {IntelliJ IDEA}
    CREATED ON : 6/3/2021 , 
    CREATED ON : 3:34 PM
*/

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        System.out.println("######################################");

        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee sam = new Employee("Sam Loe", 40);
        Employee snow = new Employee("Snow White", 22);
        Employee show = new Employee("Show Luck",26);
        Employee cavani = new Employee("Edison Cavani",34);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(sam);
        employees.add(snow);
        employees.add(show);
        employees.add(cavani);

        printEmployeeByAge(employees, "Employee over 30", employee -> employee.getAge() > 30);
        printEmployeeByAge(employees, "\nEmployee 30 and under", employee -> employee.getAge() <= 30);



    }

    private static void printEmployeeByAge(List<Employee> employees,
                                           String ageText,
                                           Predicate<Employee> ageCondition) {
        System.out.println(ageText);
        System.out.println("====================================");
        for(Employee employee : employees) {
            if(ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }
    }
}

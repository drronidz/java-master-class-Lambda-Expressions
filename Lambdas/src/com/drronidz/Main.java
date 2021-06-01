package com.drronidz;/*
    CREATED BY : ABD EL HALIM
    PROJECT NAME : {IntelliJ IDEA}
    CREATED ON : 6/1/2021 , 
    CREATED ON : 11:37 PM
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        new Thread(new CodeToRun()).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Printing from the Runnable 2");
            }
        }).start();
        System.out.println("######################################");
        new Thread(() -> System.out.println("Printing from the Runnable 3")).start();
        System.out.println("######################################");

        new Thread(() -> {
            System.out.println("Printing from the Runnable 4");
            System.out.println("Line 2");
            System.out.format("This is line %d\n", 3);
        }).start();

        System.out.println("######################################");

        Employee john = new Employee("John Doe",30);
        Employee tim = new Employee("Tim Buchalka",21);
        Employee sam = new Employee("Sam Loe",40);
        Employee snow = new Employee("Snow White",22);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(sam);
        employees.add(snow);

        System.out.println("##################Without Sorting####################");

        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }

        System.out.println("##################With Sorting####################");

        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee employeeOne, Employee employeeTwo) {
                return employeeOne.getName().compareTo(employeeTwo.getName());
            }
        });

        System.out.println("######################################");

        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }
    }
}

class CodeToRun implements Runnable {
    @Override
    public void run() {
        System.out.println("Printing from the Runnable 1");
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

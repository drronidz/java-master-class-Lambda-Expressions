package com.drronidz;/*
    CREATED BY : ABD EL HALIM
    PROJECT NAME : {IntelliJ IDEA}
    CREATED ON : 6/1/2021 , 
    CREATED ON : 11:37 PM
*/

import java.awt.desktop.PreferencesEvent;
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

        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee sam = new Employee("Sam Loe", 40);
        Employee snow = new Employee("Snow White", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(sam);
        employees.add(snow);

        System.out.println("##################Without Sorting####################");

        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });

//        for (Employee employee : employees) {
//            System.out.println(employee.getName());
//            System.out.println(employee.getAge());
//            new Thread(() -> System.out.println(employee.getAge())).start();
//        }
//        System.out.println("****************************************");
//        Employee employee;
//
////        for(int i=0; i<employees.size(); i++) {
////            employee = employees.get(i);
////            System.out.println(employee.getName());
////            new Thread(() -> System.out.println(employee.getAge())).start();
////        }

        System.out.println("##################With Sorting####################");

        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee employeeOne, Employee employeeTwo) {
                return employeeOne.getName().compareTo(employeeTwo.getName());
            }
        });

        Collections.sort(employees, (employeeOne, employeeTwo) ->
                employeeOne.getName().compareTo(employeeTwo.getName()));

        System.out.println("######################################");

        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }

//        String sillyString = doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String stringOne, String stringTwo) {
//                return stringOne.toUpperCase() + stringTwo.toUpperCase();
//            }
//        }, employees.get(0).getName(), employees.get(1).getName());
//        System.out.println(sillyString);

        UpperConcat upperConcat = (stringOne, stringTwo) -> {
            return stringOne.toUpperCase() + " " + stringTwo.toUpperCase();
        };


        String sillyString = doStringStuff(upperConcat,
                employees.get(0).getName(),
                employees.get(1).getName());

        System.out.println(sillyString);

        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);
    }

    public final static String doStringStuff(UpperConcat uc, String stringOne, String stringTwo) {
        return uc.upperAndConcat(stringOne, stringTwo);
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

interface UpperConcat {
    public String upperAndConcat(String stringOne, String stringTwo);
}

class AnotherClass {
    public String doSomething() {

        int i = 0;


        UpperConcat uc = (stringOne, stringTwo) -> {
            System.out.println("The lambda expression's class is " + getClass().getSimpleName());
            System.out.println("i in the lambda expression = " + i);
            String result = stringOne.toUpperCase() + " " + stringTwo.toUpperCase();
            return result;
        };


        System.out.println("The AnotherClass class's name is " + getClass().getSimpleName());
        return Main.doStringStuff(uc, "String1,", "String2");
    }

    public void printValue() {
        int number = 25;
        Runnable runnable = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("The value is " + number);
        };

        new Thread(runnable).start();
    }
}


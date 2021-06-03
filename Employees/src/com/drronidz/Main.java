package com.drronidz;/*
    CREATED BY : ABD EL HALIM
    PROJECT NAME : {IntelliJ IDEA}
    CREATED ON : 6/3/2021 , 
    CREATED ON : 3:34 PM
*/

import java.net.FileNameMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("######################################");

        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee sam = new Employee("Sam Loe", 40);
        Employee snow = new Employee("Snow White", 22);
        Employee show = new Employee("Luck Show", 26);
        Employee cavani = new Employee("Edison Cavani", 34);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(sam);
        employees.add(snow);
        employees.add(show);
        employees.add(cavani);

        printEmployeeByAge(employees, "Employee over 30",
                employee -> employee.getAge() > 30);

        printEmployeeByAge(employees, "\nEmployee 30 and under",
                employee -> employee.getAge() <= 30);

        printEmployeeByAge(employees, "\nEmployees younger than 25",
                new Predicate<Employee>() {
                    @Override
                    public boolean test(Employee employee) {
                        return employee.getAge() < 25;
                    }
                });

        IntPredicate greaterThan15 = i -> i > 15;
        IntPredicate lessThan100 = i -> i < 100;

        System.out.println("====================================");
        System.out.println(greaterThan15.test(10));
        int a = 20;
        System.out.println(greaterThan15.test(a + 5));

        System.out.println("====================================");
        System.out.println(greaterThan15.or(lessThan100).test(10));

        System.out.println("====================================");
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(1000));
        }

        System.out.println("====================================");
        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
        for (int i = 0; i < 10; i++) {
            System.out.println(randomSupplier.get());
        }

        System.out.println("====================================");
        employees.forEach(employee -> {
            String lastName = employee.getName().substring(employee.getName().indexOf(' ') + 1);
            System.out.println("Last Name is " + lastName);
        });

        System.out.println("====================================");

        Function<Employee, String> getLastName = (Employee employee) ->
                employee.getName().substring(employee.getName().indexOf(' ') + 1);

        String lastName = getLastName.apply(employees.get(1));
        System.out.println(lastName);

        System.out.println("====================================");

        Function<Employee, String>  getFirstName = (Employee employee) ->
                employee.getName().substring(0, employee.getName().indexOf(' '));

        Random randomOne = new Random();
        for(Employee employee : employees) {
            if(randomOne.nextBoolean()) {
                System.out.println(getAName(getFirstName, employee));
            } else {
                System.out.println(getAName(getLastName, employee));
            }
        }

        System.out.println("====================================");

        Function<Employee, String> upperCase = employee
                -> employee.getName().toUpperCase();
        Function<String, String> firstName = name
                -> name.substring(0, name.indexOf(' '));
        Function chainedFunction = upperCase.andThen(firstName);
        System.out.println(chainedFunction.apply(employees.get(0)));

        System.out.println("====================================");

        BiFunction<String, Employee, String> concatAge = (String name, Employee employee)
                -> name.concat(" " + employee.getAge());

        String upperName = upperCase.apply(employees.get(0));
        System.out.println(concatAge.apply(upperName, employees.get(0)));

        IntUnaryOperator intUnaryOperator = i -> i + 5;
        System.out.println(intUnaryOperator.applyAsInt(10));

        Consumer<String>  consumerOne = s -> s.toUpperCase();
        Consumer<String>  consumerTwo = s -> System.out.println(s);
        consumerOne.andThen(consumerTwo).accept("Hello, World!");



    }

    private static String getAName(Function<Employee, String> getName, Employee employee) {
        return getName.apply(employee);
    }

    private static void printEmployeeByAge(List<Employee> employees,
                                           String ageText,
                                           Predicate<Employee> ageCondition) {
        System.out.println(ageText);
        System.out.println("====================================");
        for (Employee employee : employees) {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }
    }
}

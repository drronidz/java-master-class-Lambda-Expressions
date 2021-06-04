package com.dronidz;/*
    CREATED BY : ABD EL HALIM
    PROJECT NAME : {IntelliJ IDEA}
    CREATED ON : 6/4/2021 , 
    CREATED ON : 1:46 PM
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Runnable runnableOne = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's split this p into an array";
                String[] parts = myString.split(" ");
                for (String part : parts) {
                    System.out.println(part);
                }
            }
        };

        // Convert to lambda expression

        Runnable runnableTwo = () -> {
            String myString = "Let's split this p into an array";
            String[] parts = myString.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };

        //

        Function<String, String> lambdaFunction = (String source) -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }

            return returnVal.toString();
        };

        System.out.println(lambdaFunction.apply("1234567890"));
//        System.out.println(everySecondCharacter(lambdaFunction,"1234567890"));

        String result = everySecondCharacter(lambdaFunction, "1234567890");
        System.out.println(result);

        //
//        Supplier<String> iLoveJava = () -> "I love Java!";
        Supplier<String> iLoveJava = () ->
        {
            return "I love Java!";
        };
        System.out.println("\n-----------------------------------------");
        //
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

        //
        System.out.println("\n-----------------------------------------");

        List<String> bestNames = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "olivier",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        List<String> firstUpperCaseList = new ArrayList<>();
        bestNames.forEach(name ->
                firstUpperCaseList.add(name.substring(0, 1).toUpperCase() + name.substring(1)));
//        firstUpperCaseList.sort((stringOne, stringTwo) -> stringOne.compareTo(stringTwo));
//        firstUpperCaseList.sort(Comparator.naturalOrder());
        firstUpperCaseList.sort(String::compareTo);
//        firstUpperCaseList.forEach(s -> System.out.println(s));
        firstUpperCaseList.forEach(System.out::println);

        System.out.println("\n-----------------------------------------");

        bestNames
                .stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .sorted(String::compareTo)
                .forEach(System.out::println);

        System.out.println("\n-----------------------------------------");

        long namesBeginningWithA = bestNames
                .stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .filter(name -> name.startsWith("A"))
                .count();

        System.out.println("Number of names beginning with A is: " + namesBeginningWithA);

        System.out.println("\n-----------------------------------------");

        bestNames
                .stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .peek(System.out::println)
                .sorted(String::compareTo)
                .collect(Collectors.toList());


    }

    //
    public static String everySecondChar(String source) {
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i % 2 == 1) {
                returnVal.append(source.charAt(i));
            }
        }

        return returnVal.toString();
    }

    public static String everySecondCharacter(Function<String, String> function, String source) {
        return function.apply(source);
    }
}

package practiceTest.java;

/**
 * 1. Operators:
 * Assignment:
 * Create a calculator that performs basic arithmetic operations (+,-,*,/,%) and logical
 * comparisons (>,<,==,!=,etc.) based on user input.
 *
 * Sample Input:
 * Enter first number: 10
 * Enter second number: 5
 * Choose operations (+,-,*,/,%,>,<,==): *
 *
 * Expected Output:
 * Result: 50
 * */

import org.jspecify.annotations.NonNull;

import java.util.Scanner;

class Operators {

    static void main (String[] args) {
        final int first, second;
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter first number: ");
        first = sc.nextInt();
        System.out.print("Enter second number: ");
        second = sc.nextInt();
        System.out.print("Choose operations (+,-,*,/,%,>,<,==): ");
        String operation = sc.next();
        String result = getResult(operation, first, second);
        System.out.println ("Result: " + result);
    }

    private static @NonNull String getResult(String operation, int first, int second) {
        Object result;
        switch (operation) {
            case "+" -> result = add(first, second);
            case "-" -> result = sub(first, second);
            case "*" -> result = mul(first, second);
            case "/" -> result = div(first, second);
            case "%" -> result = remain(first, second);
            case "<" -> result = lesser(first, second);
            case ">" -> result = greater(first, second);
            case "==" -> result = equals(first, second);
            default -> throw new IllegalArgumentException("Invalid Operator");
        }
        return result.toString();
    }

    private static int add (int first, int second) {
        return first + second;
    }

    private static int sub (int first, int second) {
        return first - second;
    }

    private static int mul (int first, int second) {
        return first * second;
    }

    private static int div (int first, int second) {
        return first / second;
    }

    private static int remain (int first, int second) {
        return first % second;
    }

    private static boolean greater (int first, int second) {
        return first > second;
    }

    private static boolean lesser (int first, int second) {
        return first < second;
    }

    private static boolean equals (int first, int second) {
        return first == second;
    }
}

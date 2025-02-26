package com.calculator;

import java.util.Scanner;

public class ScientificCalculator {

    // Function to calculate square root
    public static double squareRoot(double x) {
        return Math.sqrt(x);
    }

    // Function to calculate factorial (recursive method)
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    // Function to calculate natural logarithm (ln)
    public static double naturalLog(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException("Natural logarithm is only defined for positive numbers.");
        }
        return Math.log(x);
    }

    // Function to calculate power (x^b)
    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nScientific Calculator");
            System.out.println("1. Square Root");
            System.out.println("2. Factorial");
            System.out.println("3. Natural Logarithm");
            System.out.println("4. Power Function");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            double result = 0;

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter a number: ");
                        double num1 = scanner.nextDouble();
                        result = squareRoot(num1);
                        break;
                    case 2:
                        System.out.print("Enter a number: ");
                        int num2 = scanner.nextInt();
                        result = factorial(num2);
                        break;
                    case 3:
                        System.out.print("Enter a number: ");
                        double num3 = scanner.nextDouble();
                        result = naturalLog(num3);
                        break;
                    case 4:
                        System.out.print("Enter base: ");
                        double base = scanner.nextDouble();
                        System.out.print("Enter exponent: ");
                        double exponent = scanner.nextDouble();
                        result = power(base, exponent);
                        break;
                    case 5:
                        exit = true;
                        System.out.println("Exiting Calculator...");
                        continue;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                        continue;
                }
                System.out.println("Result: " + result);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}

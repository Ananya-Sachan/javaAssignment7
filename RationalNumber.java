package assign7Pt2;

import java.util.Scanner;

public class RationalNumber {
    private int numerator;
    private int denominator;

    public RationalNumber(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    // Getters for numerator and denominator
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    // Simplify the fraction
    private void simplify() {
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;
        // Ensure the sign is always in the numerator
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    // Method to calculate greatest common divisor
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // Add two rational numbers
    public RationalNumber add(RationalNumber other) {
        int num = this.numerator * other.denominator + other.numerator * this.denominator;
        int denom = this.denominator * other.denominator;
        return new RationalNumber(num, denom);
    }

    // Subtract two rational numbers
    public RationalNumber subtract(RationalNumber other) {
        int num = this.numerator * other.denominator - other.numerator * this.denominator;
        int denom = this.denominator * other.denominator;
        return new RationalNumber(num, denom);
    }

    // Multiply two rational numbers
    public RationalNumber multiply(RationalNumber other) {
        int num = this.numerator * other.numerator;
        int denom = this.denominator * other.denominator;
        return new RationalNumber(num, denom);
    }

    // Divide two rational numbers
    public RationalNumber divide(RationalNumber other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException("Division by zero.");
        }
        int num = this.numerator * other.denominator;
        int denom = this.denominator * other.numerator;
        return new RationalNumber(num, denom);
    }

    // Compare two rational numbers
    public int compareTo(RationalNumber other) {
        double thisValue = (double) this.numerator / this.denominator;
        double otherValue = (double) other.numerator / other.denominator;
        return Double.compare(thisValue, otherValue);
    }

    // Convert to floating point
    public double toDouble() {
        return (double) this.numerator / this.denominator;
    }

    // Find absolute value
    public RationalNumber abs() {
        return new RationalNumber(Math.abs(this.numerator), Math.abs(this.denominator));
    }

    // Override toString method for proper output
    @Override
    public String toString() {
        if (denominator == 1) {
            return Integer.toString(numerator);
        } else {
            return numerator + "/" + denominator;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter first rational number (numerator/denominator):");
            String[] input1 = scanner.nextLine().split("/");
            int num1 = Integer.parseInt(input1[0]);
            int denom1 = Integer.parseInt(input1[1]);
            RationalNumber rational1 = new RationalNumber(num1, denom1);

            System.out.println("Enter second rational number (numerator/denominator):");
            String[] input2 = scanner.nextLine().split("/");
            int num2 = Integer.parseInt(input2[0]);
            int denom2 = Integer.parseInt(input2[1]);
            RationalNumber rational2 = new RationalNumber(num2, denom2);

            System.out.println("Operations:");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Compare");
            System.out.println("6. Convert to Floating Point");
            System.out.println("7. Absolute Value");

            System.out.print("Enter your choice (1-7): ");
            int choice = scanner.nextInt();
            RationalNumber result;

            switch (choice) {
                case 1:
                    result = rational1.add(rational2);
                    System.out.println("Addition Result: " + result);
                    break;
                case 2:
                    result = rational1.subtract(rational2);
                    System.out.println("Subtraction Result: " + result);
                    break;
                case 3:
                    result = rational1.multiply(rational2);
                    System.out.println("Multiplication Result: " + result);
                    break;
                case 4:
                    result = rational1.divide(rational2);
                    System.out.println("Division Result: " + result);
                    break;
                case 5:
                    int compareResult = rational1.compareTo(rational2);
                    if (compareResult < 0) {
                        System.out.println(rational1 + " is less than " + rational2);
                    } else if (compareResult > 0) {
                        System.out.println(rational1 + " is greater than " + rational2);
                    } else {
                        System.out.println(rational1 + " is equal to " + rational2);
                    }
                    break;
                case 6:
                    System.out.println("First Rational Number as Floating Point: " + rational1.toDouble());
                    System.out.println("Second Rational Number as Floating Point: " + rational2.toDouble());
                    break;
                case 7:
                    System.out.println("Absolute Value of First Rational Number: " + rational1.abs());
                    System.out.println("Absolute Value of Second Rational Number: " + rational2.abs());
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter integers for numerator and denominator.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}




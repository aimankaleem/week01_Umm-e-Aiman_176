package CalculatorDemo;

public class Calculator {

    // Varargs Addition: handles 0, 1, or N arguments dynamically
    public double add(double... numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0.0;
        }
        double sum = 0.0;
        for (double n : numbers) {
            sum += n;
        }
        return sum;
    }

    // Subtraction
    public double subtract(double a, double b) {
        return a - b;
    }

    // Multiplication
    public double multiply(double a, double b) {
        return a * b;
    }

    // Division with strict divide-by-zero guard
    public double divide(double numerator, double denominator) {
        if (Math.abs(denominator) < 1e-9) {
            throw new ArithmeticException("Divide-by-Zero Error: Denominator cannot be 0.");
        }
        return numerator / denominator;
    }

    // Creative/Extra Operation: Power (Exponentiation)
    public double power(double base, int exponent) {
        if (base == 0.0 && exponent < 0) {
            throw new ArithmeticException("Zero cannot be raised to a negative exponent.");
        }
        double result = 1.0;
        int exp = Math.abs(exponent);
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return (exponent < 0) ? (1.0 / result) : result;
    }
}
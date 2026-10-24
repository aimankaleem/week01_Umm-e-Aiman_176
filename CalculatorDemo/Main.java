package CalculatorDemo;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   WEEK 1 LAB: CALCULATOR ENHANCED TEST SUITE     ");
        System.out.println("==================================================");

        Calculator calc = new Calculator();

        // 1. Testing Varargs add()
        System.out.println("\n[1] Varargs Addition Tests:");
        System.out.println("Normal Case (5 args: 2.5, 4.0, 1.5, 10.0, 2.0): " + calc.add(2.5, 4.0, 1.5, 10.0, 2.0));
        System.out.println("Edge Case (No args passed): " + calc.add());
        System.out.println("Edge Case (Single arg: 42.0): " + calc.add(42.0));

        // 2. Testing Subtraction
        System.out.println("\n[2] Subtraction Tests:");
        System.out.println("Normal Case (100.0 - 45.5): " + calc.subtract(100.0, 45.5));
        System.out.println("Edge Case (Subtracting negative: 10.0 - (-5.0)): " + calc.subtract(10.0, -5.0));

        // 3. Testing Multiplication
        System.out.println("\n[3] Multiplication Tests:");
        System.out.println("Normal Case (12.0 * 8.0): " + calc.multiply(12.0, 8.0));
        System.out.println("Edge Case (Multiply by zero: 999.0 * 0.0): " + calc.multiply(999.0, 0.0));

        // 4. Testing Division & Zero Protection
        System.out.println("\n[4] Division Tests:");
        System.out.println("Normal Case (45.0 / 5.0): " + calc.divide(45.0, 5.0));
        try {
            System.out.println("Edge Case (Divide by Zero: 50.0 / 0.0)...");
            calc.divide(50.0, 0.0);
        } catch (ArithmeticException e) {
            System.out.println("Successfully caught expected error: " + e.getMessage());
        }

        // 5. Testing Power Operation
        System.out.println("\n[5] Exponentiation Tests:");
        System.out.println("Normal Case (2^5): " + calc.power(2, 5));
        System.out.println("Edge Case (Base raised to 0: 99^0): " + calc.power(99, 0));
        System.out.println("Edge Case (Negative exponent: 2^-3): " + calc.power(2, -3));
    }
}
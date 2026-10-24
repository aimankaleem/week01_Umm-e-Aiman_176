# Week 01: Core Object-Oriented Foundations & Memory Architecture

## Student Information
- **Name:** [Your Name]
- **Seat Number:** [Your Seat Number]
- **Course:** Object-Oriented Programming (Java)

---

## Deliverables Summary

1. **`CarDemo`:**
   - Strict `private` encapsulation across all 6 instance variables.
   - Enforced defensive invariants (no negative speed, zero/negative inputs blocked, empty strings rejected).
   - 5 core behaviours (`startEngine`, `stopEngine`, `accelerate`, `brake`, `refuel`) plus 1 creative feature (`ecoDriveAssist`).
   - `Main.java` demonstrates the creation of two completely independent objects on the Heap.

2. **`CalculatorDemo`:**
   - Varargs `add(double... numbers)` handling dynamic argument lengths (0, 1, or N).
   - Operations: subtraction, multiplication, division, and exponentiation.
   - Guarded division against divide-by-zero throwing descriptive `ArithmeticException`.

3. **Handwritten Documentation (`docs/`):**
   - `Activity1_FavouriteObjects.txt`: Breakdown of 5 real-world objects into attributes and behaviours.
   - `Exercise2_MemoryTrace.txt`: Stack vs. Heap layout tracking pointer references and independence.
   - `UML_Diagrams.txt`: Full UML specifications for `Car`, `Calculator`, and `BankAccount`.
   - `VivaAnswers.txt`: Detailed technical answers for all 9 lab viva questions.

---

## How to Compile and Run

From the root project directory:

```bash
# Compile both packages
javac CarDemo/*.java CalculatorDemo/*.java

# Run Car Demo
java CarDemo.Main

# Run Calculator Demo
java CalculatorDemo.Main
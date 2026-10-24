package CarDemo;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("      WEEK 1 LAB: CAR DEMO (INDEPENDENT OBJECTS)  ");
        System.out.println("==================================================");

        // Instantiating Car 1 on the Heap
        Car car1 = new Car("Honda", "Civic", 45.0);

        // Instantiating Car 2 on the Heap
        Car car2 = new Car("Toyota", "Corolla", 80.0);

        System.out.println("\n--- Testing Car 1 Operations ---");
        car1.startEngine();
        car1.accelerate(60.0);
        car1.accelerate(50.0); // Now at 110 km/h
        car1.ecoDriveAssist();

        System.out.println("\n--- Testing Car 2 Operations (Proving Isolation) ---");
        // car2 is completely unaffected by car1's speed and fuel drops
        System.out.println("Car 2 speed before actions: " + car2.getCurrentSpeed() + " km/h");
        car2.startEngine();
        car2.accelerate(40.0);
        car2.brake(15.0);
        car2.ecoDriveAssist();

        System.out.println("\n--- Verifying Independent State Verification ---");
        System.out.printf("Car 1 (%s): Speed = %.1f km/h, Fuel = %.1f%%%n", 
                car1.getModel(), car1.getCurrentSpeed(), car1.getFuelLevel());
        System.out.printf("Car 2 (%s): Speed = %.1f km/h, Fuel = %.1f%%%n", 
                car2.getModel(), car2.getCurrentSpeed(), car2.getFuelLevel());

        System.out.println("\n--- Testing Defensive Validation Guards ---");
        try {
            System.out.println("Attempting to create a car with invalid empty brand...");
            new Car("", "Ghost", 20.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Expected Invariant Exception: " + e.getMessage());
        }
    }
}
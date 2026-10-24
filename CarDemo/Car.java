package CarDemo;

public class Car {
    // Attributes (Strictly Private Encapsulation)
    private final String brand;
    private final String model;
    private double fuelLevel;    // Percentage (0.0 to 100.0)
    private double currentSpeed; // km/h (0.0 to 220.0)
    private boolean isEngineOn;
    private double odometerKm;

    // Constructor with defensive validation
    public Car(String brand, String model, double initialFuel) {
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be null or empty.");
        }
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Model cannot be null or empty.");
        }
        this.brand = brand.trim();
        this.model = model.trim();
        this.fuelLevel = Math.max(0.0, Math.min(100.0, initialFuel));
        this.currentSpeed = 0.0;
        this.isEngineOn = false;
        this.odometerKm = 0.0;
    }

    // Behaviour 1: Start Engine
    public void startEngine() {
        if (isEngineOn) {
            System.out.println("[" + model + "] Engine is already running.");
            return;
        }
        if (fuelLevel <= 0.0) {
            System.out.println("[" + model + "] Cannot start: Fuel tank is completely empty!");
            return;
        }
        isEngineOn = true;
        System.out.println("[" + model + "] Engine started. Ready to drive.");
    }

    // Behaviour 2: Stop Engine
    public void stopEngine() {
        if (!isEngineOn) {
            System.out.println("[" + model + "] Engine is already off.");
            return;
        }
        if (currentSpeed > 0) {
            System.out.println("[" + model + "] Safety Hazard! Bring car to complete stop before turning engine off.");
            return;
        }
        isEngineOn = false;
        System.out.println("[" + model + "] Engine turned off safely.");
    }

    // Behaviour 3: Accelerate
    public void accelerate(double speedIncrease) {
        if (!isEngineOn) {
            System.out.println("[" + model + "] Cannot accelerate: Start the engine first!");
            return;
        }
        if (speedIncrease <= 0) {
            System.out.println("[" + model + "] Acceleration input must be positive.");
            return;
        }
        if (fuelLevel <= 0) {
            System.out.println("[" + model + "] Out of fuel! Engine stalled.");
            stopEngine();
            return;
        }

        currentSpeed = Math.min(220.0, currentSpeed + speedIncrease);
        double fuelConsumed = speedIncrease * 0.05;
        fuelLevel = Math.max(0.0, fuelLevel - fuelConsumed);
        odometerKm += (speedIncrease * 0.1);

        System.out.printf("[%s] Accelerated by %.1f km/h. Speed: %.1f km/h | Fuel: %.1f%%%n", 
                model, speedIncrease, currentSpeed, fuelLevel);
    }

    // Behaviour 4: Brake
    public void brake(double speedDecrease) {
        if (speedDecrease <= 0) {
            System.out.println("[" + model + "] Brake input must be positive.");
            return;
        }
        currentSpeed = Math.max(0.0, currentSpeed - speedDecrease);
        System.out.printf("[%s] Brakes applied. Speed reduced to: %.1f km/h%n", model, currentSpeed);
    }

    // Behaviour 5: Refuel
    public void refuel(double amountLiters) {
        if (amountLiters <= 0) {
            System.out.println("[" + model + "] Refuel amount must be greater than zero.");
            return;
        }
        fuelLevel = Math.min(100.0, fuelLevel + amountLiters);
        System.out.printf("[%s] Refueled successfully. Current fuel: %.1f%%%n", model, fuelLevel);
    }

    // Creative Feature: EcoDrive Assist Analysis
    public void ecoDriveAssist() {
        System.out.println("\n--- [" + brand + " " + model + "] EcoDrive Telemetry ---");
        System.out.printf("Odometer: %.1f km | Engine Status: %s%n", odometerKm, (isEngineOn ? "RUNNING" : "OFF"));
        if (currentSpeed > 100.0) {
            System.out.println("Warning: Speed exceeds 100 km/h. Fuel consumption increased by 22%.");
        } else if (currentSpeed > 0 && currentSpeed <= 80.0) {
            System.out.println("Optimal Zone: Operating in maximum fuel-efficiency aerodynamic range.");
        } else if (currentSpeed == 0) {
            System.out.println("Idling/Stationary: Zero kinetic work output.");
        }
        double estimatedRangeKm = (fuelLevel / 0.08); // 8% fuel per 100 km standard
        System.out.printf("Estimated Remaining Range: %.1f km%n", estimatedRangeKm);
        System.out.println("----------------------------------------------\n");
    }

    // Getters for Read-Only Inspection
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public double getCurrentSpeed() { return currentSpeed; }
    public double getFuelLevel() { return fuelLevel; }
    public boolean isEngineOn() { return isEngineOn; }
}
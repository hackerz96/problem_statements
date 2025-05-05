interface Vehicle {
    void startRide();
    void endRide();
    double calculateFare(int distance);
}

interface PricingStrategy {
    double adjustFare(double baseFare);
}

// ----- Vehicle Implementations -----

class Bike implements Vehicle {
    private PricingStrategy strategy;

    public Bike(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public void startRide() {
        System.out.println("Bike ride started.");
    }

    public void endRide() {
        System.out.println("Bike ride ended.");
    }

    public double calculateFare(int distance) {
        double baseFare = distance * 5; // ₹5 per km
        return strategy.adjustFare(baseFare);
    }
}

class Auto implements Vehicle {
    private PricingStrategy strategy;

    public Auto(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public void startRide() {
        System.out.println("Auto ride started.");
    }

    public void endRide() {
        System.out.println("Auto ride ended.");
    }

    public double calculateFare(int distance) {
        double baseFare = distance * 8; // ₹8 per km
        return strategy.adjustFare(baseFare);
    }
}

class Cab implements Vehicle {
    private PricingStrategy strategy;

    public Cab(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public void startRide() {
        System.out.println("Cab ride started.");
    }

    public void endRide() {
        System.out.println("Cab ride ended.");
    }

    public double calculateFare(int distance) {
        double baseFare = distance * 12; // ₹12 per km
        return strategy.adjustFare(baseFare);
    }
}

// ----- Pricing Strategy Implementations -----

class NormalStrategy implements PricingStrategy {
    public double adjustFare(double baseFare) {
        return baseFare; // No change
    }
}

class PeakHourStrategy implements PricingStrategy {
    public double adjustFare(double baseFare) {
        return baseFare * 1.5; // 50% surcharge
    }
}

class HolidayStrategy implements PricingStrategy {
    public double adjustFare(double baseFare) {
        return baseFare * 1.2; // 20% surcharge
    }
}

// ----- Demo -----

public class RideSystem {
    public static void main(String[] args) {
        int distance = 10; // in km

        Vehicle bike = new Bike(new NormalStrategy());
        bike.startRide();
        System.out.printf("Bike Fare: ₹%.2f%n", bike.calculateFare(distance));
        bike.endRide();

        Vehicle auto = new Auto(new PeakHourStrategy());
        auto.startRide();
        System.out.printf("Auto Fare (Peak Hour): ₹%.2f%n", auto.calculateFare(distance));
        auto.endRide();

        Vehicle cab = new Cab(new HolidayStrategy());
        cab.startRide();
        System.out.printf("Cab Fare (Holiday): ₹%.2f%n", cab.calculateFare(distance));
        cab.endRide();
    }
}

package OOPtermproject;

public class Motorcycle extends Vehicle {
    public Motorcycle(String licensePlate) { super(licensePlate); }

    @Override
    public double calculateFee() {
        return 20.0;
    }
}
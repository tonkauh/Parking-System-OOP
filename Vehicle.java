package OOPtermproject;

import java.time.LocalDateTime;

public abstract class Vehicle {
    protected String licensePlate;
    protected LocalDateTime entryTime;

    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
        this.entryTime = LocalDateTime.now(); 
    }

    public abstract double calculateFee();

    public String getLicensePlate() { return licensePlate; }
    public LocalDateTime getEntryTime() { return entryTime; }
}
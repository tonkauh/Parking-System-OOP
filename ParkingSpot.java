package OOPtermproject;

public class ParkingSpot {
    private int spotId;
    private boolean isOccupied;
    private Vehicle vehicle;

    public ParkingSpot(int spotId) {
        this.spotId = spotId;
        this.isOccupied = false;
        this.vehicle = null;
    }

    public void assignVehicle(Vehicle v) {
        this.vehicle = v;
        this.isOccupied = true;
    }

    public void release() {
        this.vehicle = null;
        this.isOccupied = false;
    }

    //getter
    public int getSpotId() { return spotId; }
    public boolean isOccupied() { return isOccupied; }
    public Vehicle getVehicle() { return vehicle; }
}
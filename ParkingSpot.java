package OOPtermproject;

public class ParkingSpot {
    private int spotNumber;
    private String vehicleNumber;
    private boolean isOccupied;

    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.isOccupied = false;
        this.vehicleNumber = "";
    }

    // Getter & Setter
    public int getSpotNumber() { return spotNumber; }
    
    public boolean isOccupied() { return isOccupied; }

    public void occupySpot(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        this.isOccupied = true;
    }

    public void releaseSpot() {
        this.vehicleNumber = "";
        this.isOccupied = false;
    }

    public String getVehicleNumber() { return vehicleNumber; }
}
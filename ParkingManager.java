package OOPtermproject;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager {
    private List<ParkingSpot> spots;

    public ParkingManager(int totalSpots) {
        spots = new ArrayList<>();
        for (int i = 1; i <= totalSpots; i++) {
            spots.add(new ParkingSpot(i));
        }
    }

    public void checkIn(Vehicle v) {
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied()) {
                spot.assignVehicle(v);
                System.out.println(">>> [SUCCESS] " + v.getClass().getSimpleName() + " [" + v.getLicensePlate() + "] parked at spot #" + spot.getSpotId());
                return;
            }
        }
        System.out.println(">>> [FULL] Sorry, no available spots.");
    }

    public void checkOut(int spotId) {
        if (spotId < 1 || spotId > spots.size()) {
            System.out.println(">>> Invalid spot ID.");
            return;
        }

        ParkingSpot spot = spots.get(spotId - 1);
        if (spot.isOccupied()) {
            double fee = spot.getVehicle().calculateFee();
            System.out.println(">>> [CHECK-OUT] Vehicle: " + spot.getVehicle().getLicensePlate());
            System.out.println(">>> Total Fee: " + fee + " THB");
            spot.release();
        } else {
            System.out.println(">>> This spot is already empty.");
        }
    }

    public void displayStatus() {
        System.out.println("\n===== PARKING LOT STATUS =====");
        for (ParkingSpot spot : spots) {
            String status ;
            		if (spot.isOccupied()) {
            		    status = "[OCCUPIED] by " + spot.getVehicle().getLicensePlate();
            		} else {
            		    status = "[FREE]";
            		}
            System.out.println("Spot " + spot.getSpotId() + ": " + status);
        }
        System.out.println("==============================");
    }
}
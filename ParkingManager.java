package OOPtermproject;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager {
    private List<ParkingSpot> spots;
    private final double HOURLY_RATE = 20.0; // ค่าจอดชั่วโมงละ 20 บาท

    public ParkingManager(int totalSpots) {
        spots = new ArrayList<>();
        for (int i = 1; i <= totalSpots; i++) {
            spots.add(new ParkingSpot(i));
        }
    }

    // ฟังก์ชันหาช่องจอดที่ว่าง
    public int findEmptySpot() {
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied()) {
                return spot.getSpotNumber();
            }
        }
        return -1; // ถ้าเต็มหมด
    }

    // ฟังก์ชันจอดรถ (Check-in)
    public void parkVehicle(String licensePlate) {
        int spotId = findEmptySpot();
        if (spotId != -1) {
            spots.get(spotId - 1).occupySpot(licensePlate);
            System.out.println("รถทะเบียน " + licensePlate + " จอดที่ช่อง: " + spotId);
        } else {
            System.out.println("ขออภัย ลานจอดรถเต็มแล้ว");
        }
    }

    // ฟังก์ชันเอารถออกและคำนวณเงิน (Check-out)
    public void checkoutVehicle(int spotId, int hours) {
        if (spots.get(spotId - 1).isOccupied()) {
            double totalFee = hours * HOURLY_RATE;
            System.out.println("ช่องที่ " + spotId + " นำรถออกเรียบร้อย");
            System.out.println("จำนวนเวลา: " + hours + " ชม. ค่าบริการ: " + totalFee + " บาท");
            spots.get(spotId - 1).releaseSpot();
        } else {
            System.out.println("ช่องนี้ไม่มีรถจอดอยู่");
        }
    }
}
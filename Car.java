package OOPtermproject;

public class Car extends Vehicle {
    public Car(String licensePlate) { super(licensePlate); }

    @Override
    public double calculateFee() {
        return 40.0; // ค่าจอดรถยนต์ 40 บาท
    }
}
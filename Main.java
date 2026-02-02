package OOPtermproject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ParkingManager manager = new ParkingManager(5); // สร้างที่จอด 5 ช่อง
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Check-in Car (40 THB)");
            System.out.println("2. Check-in Motorcycle (20 THB)");
            System.out.println("3. Check-out");
            System.out.println("4. View Status");
            System.out.println("5. Exit");
            System.out.print("Select: ");
            int choice = sc.nextInt();

            if (choice == 1 || choice == 2) {
                System.out.print("Enter License Plate: ");
                String plate = sc.next();
                Vehicle v = (choice == 1) ? new Car(plate) : new Motorcycle(plate);
                manager.checkIn(v);
            } else if (choice == 3) {
                System.out.print("Enter Spot ID to Check-out: ");
                int id = sc.nextInt();
                manager.checkOut(id);
            } else if (choice == 4) {
                manager.displayStatus();
            } else {
                break;
            }
        }
        sc.close();
    }
}
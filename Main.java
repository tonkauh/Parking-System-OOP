package OOPtermproject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ParkingManager manager = new ParkingManager(5); 
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Check-in Car (40 THB)");
            System.out.println("2. Check-in Motorcycle (20 THB)");
            System.out.println("3. Check-out");
            System.out.println("4. View Status");
            System.out.println("5. Exit");
            
            int choice = -1;
            try {
                System.out.print("Select: ");
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine(); 
                continue;     
            }

            if (choice == 1 || choice == 2) {
                System.out.print("Enter License Plate: ");
                String plate = sc.next();
                Vehicle v;

                if (choice == 1) {
                    v = new Car(plate);
                } else {
                    v = new Motorcycle(plate);
                }
                manager.checkIn(v);
            } else if (choice == 3) {
                System.out.print("Enter Spot ID to Check-out: ");
                try {
                    int id = sc.nextInt();
                    manager.checkOut(id);
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid Spot ID!");
                    sc.nextLine();
                }
            } else if (choice == 4) {
                manager.displayStatus();
            } else if (choice == 5) {
                break;
            } else {
                System.out.println("Invalid menu option. Please select between 1-5");
            }
        }
        sc.close();
    }
}
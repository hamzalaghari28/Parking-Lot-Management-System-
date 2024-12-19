import java.util.Scanner;

  public class Main {
  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of parking slots: ");
        int size = scanner.nextInt();
        ParkingLot parkingLot = new ParkingLot(size);

        while (true) {
            System.out.println("\n--- Parking Lot Menu ---");
            System.out.println("1. Add Vehicle");
            System.out.println("2. Remove Vehicle");
            System.out.println("3. View Parking Status");
            System.out.println("4. Search Vehicle");
            System.out.println("5. View Recently Exited Vehicles");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter vehicle license number: ");
                    String licenseNumber = scanner.nextLine();
                    parkingLot.addVehicle(licenseNumber);
                    break;

                case 2:
                    System.out.print("Enter vehicle license number: ");
                    String removeLicense = scanner.nextLine();
                    parkingLot.removeVehicle(removeLicense);
                    break;

                case 3:
                    parkingLot.viewParkingStatus();
                    break;

                case 4:
                    System.out.print("Enter vehicle license number to search: ");
                    String searchLicense = scanner.nextLine();
                    parkingLot.searchVehicle(searchLicense);
                    break;

                case 5:
                    parkingLot.viewRecentlyExited();
                    break;

                case 6:
                    System.out.println("Exiting... Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
  }
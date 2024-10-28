import java.util.Scanner;
import java.util.List;

public class Dealership {
    private Dealership dealership;
    private Scanner scanner;

    public DealershipUI(Dealership dealership) {
        this.dealership = dealership;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("=== Dealership Management ===");
            System.out.println("1. Add Vehicle");
            System.out.println("2. View All Vehicles");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addVehicle();
                    break;
                case 2:
                    viewAllVehicles();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private void addVehicle() {
        System.out.println("Enter VIN: ");
        String vin = scanner.nextLine();
        System.out.println("Enter Year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter Make: ");
        String make = scanner.nextLine();
        System.out.println("Enter Model: ");
        String model = scanner.nextLine();
        System.out.println("Enter Vehicle Type: ");
        String type = scanner.nextLine();
        System.out.println("Enter Color: ");
        String color = scanner.nextLine();
        System.out.println("Enter Odometer Reading: ");
        int odometer = scanner.nextInt();
        System.out.println("Enter Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        dealership.addVehicle(vehicle);
        System.out.println("Vehicle added successfully!");
    }

    private void viewAllVehicles() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the inventory.");
        } else {
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle.getMake() + " " + vehicle.getModel() + " (" + vehicle.getYear() + ") - $" + vehicle.getPrice());
            }
        }
    }
}

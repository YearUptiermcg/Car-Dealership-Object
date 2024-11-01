package com.pluralsight;

import java.util.ArrayList;

public class UserInterface {

    public static String filename = "inventory.csv";
    public Dealership currentDealership;

    public UserInterface(){
        currentDealership = DealershipFileManager.getDealership();
    }


    public void display(){

        String options = """
                Please select from the following choices:
                1 - Find vehicles within a price range
                2 - Find vehicles by make / model
                3 - Find vehicles by year range
                4 - Find vehicles by color
                5 - Find vehicles by mileage range
                6 - Find vehicles by type (car, truck, SUV, van)
                7 - List ALL vehicles
                8 - Add a vehicle
                9 - Remove a vehicle
                0 - Quit

                >>>\s""";

        int selection;


        do {
            System.out.println();
            System.out.println("Welcome to " + currentDealership.getName() + "!");
            selection = Console.PromptForInt(options);
            if(selection == 1){
                processGetByPriceRequest();
            } else if (selection == 2){
                processGetByMakeModelRequest();
            }else if (selection == 3){
                processGetByYearRequest();
            }
            else if (selection == 4){
                processGetByColorRequest();
            }else if (selection == 5){
                processGetByMileageRequest();
            }else if (selection == 6){
                processGetByVehicleTypeRequest();
            }else if (selection == 7){
                processGetAllVehiclesRequest();
            }else if (selection == 8){
                processAddVehicleRequest();
            }else if (selection == 9){
                processRemoveVehicleRequest();
            }else if (selection == 0){
                System.out.println("Thank you for visiting " + currentDealership.getName());
                break;
            }else{
                System.out.println("Invalid selection. Please try again.");
            }
        } while (true);



    }

    private void processGetByPriceRequest() {
        double min = Console.PromptForDouble("Min:");
        double max = Console.PromptForDouble("Max:");
        ArrayList<Vehicle> currentInventory = currentDealership.getVehiclesByPrice(min,max);

        for(Vehicle v : currentInventory){
            displayVehicle(v);
        }
    }

    private void processGetByMakeModelRequest() {
        String make = Console.PromptForString("Make: ");
        String model = Console.PromptForString("Model: ");
        ArrayList<Vehicle> currentInventory = currentDealership.getVehiclesByMakeModel(make,model);

        for(Vehicle v : currentInventory){
            displayVehicle(v);
        }
    }


    private void processGetByYearRequest() {
        int min = Console.PromptForInt("Min Year:");
        int max = Console.PromptForInt("Max Year:");
        ArrayList<Vehicle> currentInventory = currentDealership.getVehiclesByYear(min,max);

        for(Vehicle v : currentInventory){
            displayVehicle(v);
        }
    }

    private void processGetByColorRequest() {
        String color = Console.PromptForString("Color: ");
        ArrayList<Vehicle> currentInventory = currentDealership.getVehiclesByColor(color);

        for(Vehicle v : currentInventory){
            displayVehicle(v);
        }
    }


    private void processGetByMileageRequest() {
        int min = Console.PromptForInt("Min Mileage:");
        int max = Console.PromptForInt("Max Mileage:");
        ArrayList<Vehicle> currentInventory = currentDealership.getVehiclesByMileage(min,max);

        for(Vehicle v : currentInventory){
            displayVehicle(v);
        }
    }

    private void processGetByVehicleTypeRequest() {
        String vehicleType = Console.PromptForString("Vehicle Type: ");
        ArrayList<Vehicle> currentInventory = currentDealership.getVehiclesByColor(vehicleType);

        for(Vehicle v : currentInventory){
            displayVehicle(v);
        }
    }


    private void processAddVehicleRequest() {
        int vin = Console.PromptForInt("Vin: ");
        int year = Console.PromptForInt("Year: ");
        String make = Console.PromptForString("Make: ");
        String model = Console.PromptForString("Model: ");
        String vehicleType = Console.PromptForString("Vehicle Type: ");
        String color = Console.PromptForString("Color: ");
        int odometer = Console.PromptForInt("Odometer: ");
        double price = Console.PromptForDouble("Price: ");

        Vehicle newVehicle = new Vehicle(vin,year,make,model,vehicleType,color,odometer,price);
        currentDealership.addVehicle(newVehicle);
    }

    private void processRemoveVehicleRequest() {
    }


    public void processGetAllVehiclesRequest(){
        for(Vehicle v : currentDealership.getInventory()){
            displayVehicle(v);
        }
    }

    public void displayVehicle(Vehicle v){
        System.out.println(v);
    }


}
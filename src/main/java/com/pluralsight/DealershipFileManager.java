package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class DealershipFileManager {
    public final static String dataFileName = "inventory.csv";


    public static Dealership getDealership() {
        ArrayList<Vehicle> inventory = new ArrayList<>();
        Dealership dealership = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(dataFileName));
            String input;
            String[] tokens = br.readLine().split(Pattern.quote("|"));
            dealership = new Dealership(tokens[0], tokens[1], tokens[2]);

            while ((input = br.readLine()) != null) {
                tokens = input.split(Pattern.quote("|"));
                int vin = Integer.parseInt(tokens[0]);
                int year = Integer.parseInt(tokens[1]);
                String make = tokens[2];
                String model = tokens[3];
                String vehicleType = tokens[4];
                String color = tokens[5];
                int odometer = Integer.parseInt(tokens[6]);
                double price = Double.parseDouble(tokens[7]);

                Vehicle currentVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                inventory.add(currentVehicle);
            }

            dealership.setInventory(inventory);
            br.close();

        } catch (Exception e) {
            System.out.println("ERROR!!");
            e.printStackTrace();
        }

        return dealership;
    }


    public static void saveDealership(Dealership dealership) {
        try  {
            BufferedWriter bw = new BufferedWriter(new FileWriter(dataFileName));
            bw.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhoneNumber() + "\n");


            for (Vehicle vehicle : dealership.getInventory()) {
                bw.write(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|"
                        + vehicle.getModel() + "|" + vehicle.getVehicleType() + "|"
                        + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice());
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }
}
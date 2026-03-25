import java.io.*;
import java.util.*;

public class BookMyStayApp {

    public static void main(String[] args) {

        String fileName = "inventory.dat";

        Map<String, Integer> inventory = new HashMap<>();

        System.out.println("System Recovery");

        try {
            // Try to load existing data
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            inventory = (Map<String, Integer>) in.readObject();
            in.close();

        } catch (Exception e) {
            // If file not found or error
            System.out.println("No valid inventory data found. Starting fresh.\n");

            inventory.put("Single", 5);
            inventory.put("Double", 3);
            inventory.put("Suite", 2);
        }

        // Display inventory
        System.out.println("Current Inventory:");
        System.out.println("Single: " + inventory.get("Single"));
        System.out.println("Double: " + inventory.get("Double"));
        System.out.println("Suite: " + inventory.get("Suite"));

        try {
            // Save inventory
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(inventory);
            out.close();

            System.out.println("Inventory saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving inventory.");
        }
    }
}
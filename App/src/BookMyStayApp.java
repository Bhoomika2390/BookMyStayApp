<<<<<<< HEAD
import java.util.HashMap;
import java.util.Map;

// Abstract Room Class
abstract class Room {
    int beds;
    int size;
    double price;

    public Room(int beds, int size, double price) {
=======
/**

 * Book My Stay Application
 * Use Case 2: Basic Room Types & Static Availability
 *
 * Demonstrates abstraction, inheritance and simple availability.
 *
 * @author Bhoomika
 * @version 2.0
 */

abstract class Room {

    String type;
    int beds;
    int size; // size in square feet
    double price;

    public Room(String type, int beds, int size, double price) {
        this.type = type;
>>>>>>> dev
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

<<<<<<< HEAD
    public abstract String getRoomType();

    public void displayDetails(int availability) {
        System.out.println(getRoomType() + ":");
        System.out.println("Beds: " + beds);
        System.out.println("Size: " + size + " sqft");
        System.out.println("Price per night: " + price);
        System.out.println("Available Rooms: " + availability);
        System.out.println();
    }
}

// Room Types
class SingleRoom extends Room {
    public SingleRoom() {
        super(1, 250, 1500.0);
    }

    public String getRoomType() {
        return "Single Room";
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super(2, 400, 2500.0);
    }

    public String getRoomType() {
        return "Double Room";
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super(3, 750, 5000.0);
    }

    public String getRoomType() {
        return "Suite Room";
    }
}

// UC3 Inventory using HashMap
class RoomInventory {
    private Map<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();

        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }
}

// Main Class
=======
    public void displayRoomDetails() {
        System.out.println("Room Type: " + type);
        System.out.println("Beds: " + beds);
        System.out.println("Size: " + size + " sq ft");
        System.out.println("Price per Night: $" + price);
    }

}

class SingleRoom extends Room {

    public SingleRoom() {
        super("Single Room", 1, 200, 100);
    }

}

class DoubleRoom extends Room {

    public DoubleRoom() {
        super("Double Room", 2, 350, 180);
    }

}

class SuiteRoom extends Room {

    public SuiteRoom() {
        super("Suite Room", 3, 500, 300);
    }

}

>>>>>>> dev
public class BookMyStayApp {

    public static void main(String[] args) {

<<<<<<< HEAD
        System.out.println("Hotel Room Inventory Status\n");

        Room single = new SingleRoom();
        Room doub = new DoubleRoom();
        Room suite = new SuiteRoom();

        RoomInventory inventory = new RoomInventory();

        single.displayDetails(inventory.getAvailability(single.getRoomType()));
        doub.displayDetails(inventory.getAvailability(doub.getRoomType()));
        suite.displayDetails(inventory.getAvailability(suite.getRoomType()));
=======
        System.out.println("Welcome to the Hotel Booking System");
        System.out.println("Application Version: 2.0\n");

        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        int singleAvailability = 10;
        int doubleAvailability = 5;
        int suiteAvailability = 2;

        System.out.println("Room Details:\n");

        single.displayRoomDetails();
        System.out.println("Available Rooms: " + singleAvailability + "\n");

        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + doubleAvailability + "\n");

        suite.displayRoomDetails();
        System.out.println("Available Rooms: " + suiteAvailability);
>>>>>>> dev
    }

}
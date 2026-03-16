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
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

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

public class BookMyStayApp {

    public static void main(String[] args) {

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
    }

}
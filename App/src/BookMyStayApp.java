import java.util.*;

class Reservation {
    String guestName;
    String roomType;

    Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Room Allocation Processing\n");

        // Step 1: Queue (UC5)
        Queue<Reservation> bookingQueue = new LinkedList<>();

        bookingQueue.add(new Reservation("Abhi", "Single"));
        bookingQueue.add(new Reservation("Subha", "Single"));
        bookingQueue.add(new Reservation("Vanmathi", "Suite"));

        // Step 2: Inventory
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Single", 2);
        inventory.put("Suite", 1);

        // Step 3: Track room count per type
        Map<String, Integer> roomCount = new HashMap<>();

        // Step 4: Process queue
        while (!bookingQueue.isEmpty()) {

            Reservation r = bookingQueue.poll();
            String type = r.roomType;

            if (inventory.get(type) > 0) {

                // Increment count for that type
                roomCount.put(type, roomCount.getOrDefault(type, 0) + 1);

                int count = roomCount.get(type);

                // Generate Room ID like Single-1, Suite-1
                String roomId = type + "-" + count;

                // Reduce inventory
                inventory.put(type, inventory.get(type) - 1);

                System.out.println("Booking confirmed for Guest: "
                        + r.guestName + ", Room ID: " + roomId + "\n");

            } else {
                System.out.println("Booking failed for Guest: "
                        + r.guestName + " (No rooms available)\n");
            }
        }
    }
}
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

    static Queue<Reservation> bookingQueue = new LinkedList<>();
    static Map<String, Integer> inventory = new HashMap<>();
    static Map<String, Integer> roomCounter = new HashMap<>();

    public static synchronized void processBooking() {
        if (bookingQueue.isEmpty()) {
            return;
        }

        Reservation r = bookingQueue.poll();
        String type = r.roomType;

        if (inventory.get(type) > 0) {
            roomCounter.put(type, roomCounter.get(type) + 1);
            String roomId = type + "-" + roomCounter.get(type);

            inventory.put(type, inventory.get(type) - 1);

            System.out.println("Booking confirmed for Guest: " + r.guestName + ", Room ID: " + roomId);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Concurrent Booking Simulation");

        bookingQueue.add(new Reservation("Abhi", "Single"));
        bookingQueue.add(new Reservation("Vanmathi", "Double"));
        bookingQueue.add(new Reservation("Kural", "Suite"));
        bookingQueue.add(new Reservation("Subha", "Single"));

        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);

        roomCounter.put("Single", 0);
        roomCounter.put("Double", 0);
        roomCounter.put("Suite", 0);

        Thread t1 = new Thread(() -> processBooking());
        Thread t2 = new Thread(() -> processBooking());
        Thread t3 = new Thread(() -> processBooking());
        Thread t4 = new Thread(() -> processBooking());

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println();
        System.out.println("Remaining Inventory:");
        System.out.println("Single: " + inventory.get("Single"));
        System.out.println("Double: " + inventory.get("Double"));
        System.out.println("Suite: " + inventory.get("Suite"));
    }
}
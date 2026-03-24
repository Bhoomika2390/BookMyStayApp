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

        System.out.println("Booking Request Queue\n");

        Queue<Reservation> bookingQueue = new LinkedList<>();

        // Add booking requests
        bookingQueue.add(new Reservation("Abhi", "Single"));
        bookingQueue.add(new Reservation("Subha", "Double"));
        bookingQueue.add(new Reservation("Vanmathi", "Suite"));

        // Process booking requests (FIFO)
        while (!bookingQueue.isEmpty()) {
            Reservation r = bookingQueue.poll();  // removes first element

            System.out.println("Processing booking for Guest: "
                    + r.guestName + ", Room Type: " + r.roomType + "\n");
        }
    }
}
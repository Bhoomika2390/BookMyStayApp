import java.util.*;

public class BookMyStayApp {
    public static void main(String[] args) {

        System.out.println("Booking Cancellation");

        // inventory before rollback
        int singleRoomAvailability = 5;

        // rollback history stack
        Stack<String> rollbackHistory = new Stack<>();

        // cancelled reservation
        String cancelledReservationId = "Single-1";
        String roomType = "Single";

        // restore inventory
        singleRoomAvailability++;

        // push released reservation id to stack
        rollbackHistory.push(cancelledReservationId);

        System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);
        System.out.println();

        System.out.println("Rollback History (Most Recent First):");
        while (!rollbackHistory.isEmpty()) {
            System.out.println("Released Reservation ID: " + rollbackHistory.pop());
        }

        System.out.println();
        System.out.println("Updated Single Room Availability: " + singleRoomAvailability);
    }
}
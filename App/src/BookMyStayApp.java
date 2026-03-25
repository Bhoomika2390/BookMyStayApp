import java.util.*;

class Service {
    String name;
    double cost;

    Service(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }
}

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Add-On Service Selection");

        // Step 1: Reservation ID (from UC6)
        String reservationId = "Single-01";

        // Step 2: List of services
        List<Service> services = new ArrayList<>();

        services.add(new Service("Breakfast", 500.0));
        services.add(new Service("Spa", 1000.0));

        // Step 3: Map reservation → services
        Map<String, List<Service>> addOnMap = new HashMap<>();
        addOnMap.put(reservationId, services);

        // Step 4: Calculate total cost
        double totalCost = 0;

        for (Service s : addOnMap.get(reservationId)) {
            totalCost += s.cost;
        }

        // Step 5: Print output (EXACT FORMAT)
        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On Cost: " + totalCost);
    }
}
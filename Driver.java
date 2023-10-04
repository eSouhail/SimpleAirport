public class Driver {
    public static void main(String[] args) {
        // Print the airport name
        System.out.println("T. F. Green Airport");
        System.out.println("===================");

        // Create a new SimpleAirport object with 4 initial flights
        SimpleAirport airport = new SimpleAirport(4);

        // Test landing and take-off for 5 cycles
        System.out.println("Initiating 5 landings/takeoffs:");
        for (int i = 0; i < 5; i++) {
            airport.landingAndTakeoff();
        }

        // Add 5 flights to the ground queue
        System.out.println("Adding 5 flights to the ground:");
        for (int i = 0; i < 5; i++) {
            airport.addGround();
        }

        // Add 3 flights to the air queue
        System.out.println("Adding 3 flights to the air:");
        for (int i = 0; i < 3; i++) {
            airport.addAir();
        }

        // Clear all flights from both queues
        System.out.println("Clearing all flights:");
        System.out.println("Clearing all planes from the airport");
        airport.clearAllFlights();

        // Done
        System.out.println("Done.");
    }
}

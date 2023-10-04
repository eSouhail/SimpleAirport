import java.util.Random;

public class SimpleAirport {
    // Initialize the queues for airplanes in the air and on the ground
    private QueueInterface<Integer> airQueue;
    private QueueInterface<Integer> groundQueue;

    // Default constructor - creates an empty airport
    public SimpleAirport() {
        this(0);
    }

    // Parameterized constructor - creates an airport with a specified number of flights
    public SimpleAirport(int flights) {
        // Create new queues
        airQueue = new LinkedQueue<>();
        groundQueue = new LinkedQueue<>();
        Random rand = new Random();

        // Randomly add flights to air or ground queue
        for (int i = 0; i < flights; i++) {
            if (rand.nextBoolean()) {
                addAir();
            } else {
                addGround();
            }
        }
    }

    // Method to add a random flight to either the air or ground queue
    public void addRandom() {
        Random rand = new Random();
        int flightNumber = rand.nextInt(1000);
        if (rand.nextBoolean()) {
            airQueue.enqueue(flightNumber);
            System.out.println("Flight " + flightNumber + " has joined the queue in the air.");
        } else {
            groundQueue.enqueue(flightNumber);
            System.out.println("Flight " + flightNumber + " has joined the queue on the ground.");
        }
    }

    // Method to add a flight to the ground queue
    public void addGround() {
        Random rand = new Random();
        int flightNumber = rand.nextInt(1000);
        groundQueue.enqueue(flightNumber);
        System.out.println("Flight " + flightNumber + " has joined the queue on the ground.");
    }

    // Method to add a flight to the air queue
    public void addAir() {
        Random rand = new Random();
        int flightNumber = rand.nextInt(1000);
        airQueue.enqueue(flightNumber);
        System.out.println("Flight " + flightNumber + " has joined the queue in the air.");
    }

    // Method to handle landing and take-off
    public void landingAndTakeoff() {
        // If there are flights in the air, they should land first
        if (!airQueue.isEmpty()) {
            int flightNumber = airQueue.dequeue();
            System.out.println("Flight " + flightNumber + " has successfully landed!");
        }
        // Else if there are flights on the ground, they can take off
        else if (!groundQueue.isEmpty()) {
            int flightNumber = groundQueue.dequeue();
            System.out.println("Flight " + flightNumber + " has successfully taken off!");
        }
        // Else, no flights are pending for landing or take-off
        else {
            System.out.println("No planes need to land or take off!");
        }
    }

    // Method to clear all flights
    public void clearAllFlights() {
        // Land all flights in the air
        while (!airQueue.isEmpty()) {
            int flightNumber = airQueue.dequeue();
            System.out.println("Flight " + flightNumber + " has successfully landed!");
        }
        // Take off all flights on the ground
        while (!groundQueue.isEmpty()) {
            int flightNumber = groundQueue.dequeue();
            System.out.println("Flight " + flightNumber + " has successfully taken off!");
        }
    }
}
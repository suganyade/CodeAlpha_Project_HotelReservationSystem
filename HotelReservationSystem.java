import java.util.List;
import java.util.Scanner;

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        // Add some rooms to the hotel
        hotel.addRoom(new Room(101, "Single", 100.0));
        hotel.addRoom(new Room(102, "Double", 150.0));
        hotel.addRoom(new Room(103, "Suite", 200.0));

        while (true) {
            // Display menu
            System.out.println("\nHotel Reservation System Menu:");
            System.out.println("1. Search Available Rooms");
            System.out.println("2. Make Reservation");
            System.out.println("3. View Reservations");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Search available rooms
                    System.out.print("Enter room category (Single/Double/Suite): ");
                    String category = scanner.nextLine();
                    List<Room> availableRooms = hotel.searchAvailableRooms(category);
                    if (availableRooms.isEmpty()) {
                        System.out.println("No available rooms in the " + category + " category.");
                    } else {
                        System.out.println("Available rooms:");
                        for (Room room : availableRooms) {
                            System.out.println(room);
                        }
                    }
                    break;
                case 2:
                    // Make reservation
                    System.out.print("Enter room number: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    Room room = null;
                    for (Room r : hotel.searchAvailableRooms("Single")) {
                        if (r.getRoomNumber() == roomNumber) {
                            room = r;
                            break;
                        }
                    }
                    if (room != null) {
                        System.out.print("Enter guest name: ");
                        String guestName = scanner.nextLine();
                        System.out.print("Enter number of nights: ");
                        int numberOfNights = scanner.nextInt();
                        Reservation reservation = hotel.makeReservation(room, guestName, numberOfNights);
                        if (reservation != null) {
                            System.out.println("Reservation successful: " + reservation);
                        } else {
                            System.out.println("Failed to make reservation. Room might not be available.");
                        }
                    } else {
                        System.out.println("Room not found or not available.");
                    }
                    break;
                case 3:
                    // View reservations
                    List<Reservation> reservations = hotel.viewReservations();
                    if (reservations.isEmpty()) {
                        System.out.println("No reservations made.");
                    } else {
                        System.out.println("Reservations:");
                        for (Reservation res : reservations) {
                            System.out.println(res);
                        }
                    }
                    break;
                case 4:
                    // Exit
                    System.out.println("Thank you for using the hotel reservation system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }
}

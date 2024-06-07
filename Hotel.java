import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Room> rooms;
    private List<Reservation> reservations;

    // Constructor
    public Hotel() {
        this.rooms = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    // Add room
    public void addRoom(Room room) {
        rooms.add(room);
    }

    // Search available rooms
    public List<Room> searchAvailableRooms(String category) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable() && room.getCategory().equalsIgnoreCase(category)) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    // Make reservation
    public Reservation makeReservation(Room room, String guestName, int numberOfNights) {
        if (room.isAvailable()) {
            Reservation reservation = new Reservation(room, guestName, numberOfNights);
            reservations.add(reservation);
            return reservation;
        }
        return null;
    }

    // View all reservations
    public List<Reservation> viewReservations() {
        return reservations;
    }
}

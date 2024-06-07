public class Reservation {
    private Room room;
    private String guestName;
    private int numberOfNights;
    private double totalAmount;

    // Constructor
    public Reservation(Room room, String guestName, int numberOfNights) {
        this.room = room;
        this.guestName = guestName;
        this.numberOfNights = numberOfNights;
        this.totalAmount = numberOfNights * room.getPricePerNight();
        room.setAvailable(false);
    }

    // Getters
    public Room getRoom() { return room; }
    public String getGuestName() { return guestName; }
    public int getNumberOfNights() { return numberOfNights; }
    public double getTotalAmount() { return totalAmount; }

    @Override
    public String toString() {
        return "Reservation{" +
                "room=" + room +
                ", guestName='" + guestName + '\'' +
                ", numberOfNights=" + numberOfNights +
                ", totalAmount=" + totalAmount +
                '}';
    }
}

public class Room {
    private int roomNumber;
    private String category;
    private boolean isAvailable;
    private double pricePerNight;

    // Constructor
    public Room(int roomNumber, String category, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.pricePerNight = pricePerNight;
        this.isAvailable = true;
    }

    // Getters and setters
    public int getRoomNumber() { return roomNumber; }
    public String getCategory() { return category; }
    public boolean isAvailable() { return isAvailable; }
    public double getPricePerNight() { return pricePerNight; }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", category='" + category + '\'' +
                ", isAvailable=" + isAvailable +
                ", pricePerNight=" + pricePerNight +
                '}';
    }
}

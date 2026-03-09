package com.seveneleven.bookmystay.model;

public class Reservation {

    private String reservationId;
    private String guestName;
    private String roomType;
    private int quantity;
    private double price;
    private String status; // PENDING, CONFIRMED, CANCELLED

    public Reservation(String reservationId, String guestName, String roomType, int quantity, double price) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomType = roomType;
        this.quantity = quantity;
        this.price = price;
        this.status = "CONFIRMED";
    }

    public String getReservationId() { return reservationId; }
    public String getGuestName() { return guestName; }
    public String getRoomType() { return roomType; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public String getStatus() { return status; }

    public void cancelReservation() {
        this.status = "CANCELLED";
    }

    @Override
    public String toString() {
        return "ReservationID=" + reservationId +
                ", Guest=" + guestName +
                ", RoomType=" + roomType +
                ", Qty=" + quantity +
                ", Price=" + price +
                ", Status=" + status;
    }
}
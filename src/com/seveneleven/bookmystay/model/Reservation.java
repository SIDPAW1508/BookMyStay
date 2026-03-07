package com.seveneleven.bookmystay.model;

/**
 * Represents a guest reservation in the booking system.
 */
public class Reservation {

    private String guestName;
    private String roomType;
    private int quantity;

    public Reservation(String guestName, String roomType, int quantity) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.quantity = quantity;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "guestName='" + guestName + '\'' +
                ", roomType='" + roomType + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
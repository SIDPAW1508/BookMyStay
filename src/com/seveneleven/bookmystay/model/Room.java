package com.seveneleven.bookmystay.model;

/**
 * Represents a room type in the hotel inventory.
 */
public class Room {

    private String type;
    private int availableCount;
    private double price;
    private String amenities;

    public Room(String type, int availableCount, double price, String amenities) {
        this.type = type;
        this.availableCount = availableCount;
        this.price = price;
        this.amenities = amenities;
    }

    public String getType() {
        return type;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public double getPrice() {
        return price;
    }

    public String getAmenities() {
        return amenities;
    }
}
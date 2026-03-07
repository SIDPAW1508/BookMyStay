package com.seveneleven.bookmystay.model;

public class RoomType {
    private String name;
    private double pricePerNight;

    public RoomType(String name, double pricePerNight) {
        this.name = name;
        this.pricePerNight = pricePerNight;
    }

    public String getName() { return name; }
    public double getPricePerNight() { return pricePerNight; }
    public void setPricePerNight(double pricePerNight) { this.pricePerNight = pricePerNight; }
}

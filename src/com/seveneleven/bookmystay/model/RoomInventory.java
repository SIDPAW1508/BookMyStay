package com.seveneleven.bookmystay.model;

import java.util.HashMap;

public class RoomInventory {
    private HashMap<String, Integer> roomCounts = new HashMap<>();
    private HashMap<String, Double> roomPrices = new HashMap<>();

    public void addRoomType(String type, int count, double price) {
        roomCounts.put(type, count);
        roomPrices.put(type, price);
    }

    public void updateCount(String type, int count) {
        roomCounts.put(type, count);
    }

    public void updatePrice(String type, double price) {
        roomPrices.put(type, price);
    }

    public int getAvailability(String type) {
        return roomCounts.getOrDefault(type, 0);
    }

    public double getPrice(String type) {
        return roomPrices.getOrDefault(type, 0.0);
    }
}
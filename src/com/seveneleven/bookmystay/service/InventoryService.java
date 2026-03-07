package com.seveneleven.bookmystay.service;

import com.seveneleven.bookmystay.model.RoomInventory;

public class InventoryService {
    private RoomInventory inventory = new RoomInventory();

    public void initializeDefaultRooms() {
        inventory.addRoomType("Single", 10, 1000.0);
        inventory.addRoomType("Double", 20, 1800.0);
        inventory.addRoomType("Suite", 5, 5000.0);
    }

    public void addRoomType(String type, int count, double price) {
        inventory.addRoomType(type, count, price);
    }

    public void updateRoomCount(String type, int count) {
        inventory.updateCount(type, count);
    }

    public void updateRoomPrice(String type, double price) {
        inventory.updatePrice(type, price);
    }

    public int checkAvailability(String type) {
        return inventory.getAvailability(type);
    }

    public double checkPrice(String type) {
        return inventory.getPrice(type);
    }
}
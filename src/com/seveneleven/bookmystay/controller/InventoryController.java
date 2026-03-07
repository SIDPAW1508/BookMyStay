package com.seveneleven.bookmystay.controller;

import com.seveneleven.bookmystay.service.InventoryService;

public class InventoryController {
    private InventoryService service = new InventoryService();

    public void setupInventory() {
        service.initializeDefaultRooms();
    }

    public void addRoom(String type, int count, double price) {
        service.addRoomType(type, count, price);
        System.out.println("Room type " + type + " added successfully.");
    } 

    public void updateRoom(String type, int count, double price) {
        service.updateRoomCount(type, count);
        service.updateRoomPrice(type, price);
        System.out.println("Room type " + type + " updated successfully.");
    }

    public void showAvailability(String type) {
        System.out.println(type + " rooms available: " + service.checkAvailability(type));
        System.out.println("Price per night: " + service.checkPrice(type));
    }
}
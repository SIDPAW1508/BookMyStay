package com.seveneleven.bookmystay.service;

import java.util.HashMap;
import com.seveneleven.bookmystay.model.Room;

/**
 * Service responsible for searching room availability.
 * Provides read-only access to inventory.
 */
public class SearchService {

    private HashMap<String, Room> roomInventory;

    public SearchService(HashMap<String, Room> roomInventory) {
        this.roomInventory = roomInventory;
    }

    /**
     * Displays all available rooms.
     */
    public void displayAvailableRooms() {

        System.out.println("Available Rooms:");

        for (Room room : roomInventory.values()) {

            if (room.getAvailableCount() > 0) {

                System.out.println("---------------------------");
                System.out.println("Room Type: " + room.getType());
                System.out.println("Price: ₹" + room.getPrice());
                System.out.println("Amenities: " + room.getAmenities());
                System.out.println("Available Count: " + room.getAvailableCount());
            }
        }
    }

    /**
     * Check availability for a specific room type.
     */
    public void checkAvailability(String roomType) {

        Room room = roomInventory.get(roomType);

        if (room == null) {
            System.out.println("Room type not found.");
            return;
        }

        if (room.getAvailableCount() > 0) {
            System.out.println(roomType + " rooms available: " + room.getAvailableCount());
        } else {
            System.out.println(roomType + " is currently unavailable.");
        }
    }
}
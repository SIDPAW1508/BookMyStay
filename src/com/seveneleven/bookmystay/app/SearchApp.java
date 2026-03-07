package com.seveneleven.bookmystay.app;

import java.util.HashMap;

import com.seveneleven.bookmystay.controller.SearchController;
import com.seveneleven.bookmystay.model.Room;

/**
 * Entry point for the Room Search & Availability feature of the BookMyStay application.
 *
 * This class demonstrates how guests can search for available rooms and check
 * the availability of specific room types using the SearchController.
 *
 * The application initializes a sample room inventory using a HashMap where:
 * Key   → Room Type (String)
 * Value → Room Object containing room details
 *
 * This module follows a read-only access pattern where room search operations
 * do not modify the inventory.
 *
 * Example Features Demonstrated:
 * - Initialize room inventory
 * - Search available rooms
 * - Check availability of a specific room type
 */
public class SearchApp {

    /**
     * Main method that starts the Room Search demonstration.
     *
     * The method performs the following steps:
     * - Create an in-memory inventory of rooms using HashMap
     * - Initialize room types with availability, price, and amenities
     * - Create a SearchController to handle guest search requests
     * - Display available rooms
     * - Check availability for specific room types
     *
     * @param args command-line arguments (not used in this application)
     */
    public static void main(String[] args) {

        /**
         * HashMap used to store room inventory.
         *
         * Key   → Room Type (String)
         * Value → Room Object containing room details
         */
        HashMap<String, Room> roomInventory = new HashMap<>();

        // Initialize room inventory with sample data
        roomInventory.put("Single", new Room("Single", 10, 1000, "WiFi, TV"));
        roomInventory.put("Double", new Room("Double", 5, 1800, "WiFi, TV, Mini Bar"));
        roomInventory.put("Suite", new Room("Suite", 0, 3500, "WiFi, TV, Mini Bar, Jacuzzi"));

        /**
         * Create the SearchController which handles guest search operations.
         */
        SearchController controller = new SearchController(roomInventory);

        // Guest searches for all available rooms
        controller.searchRooms();

        // Guest checks availability for a specific room type
        controller.checkRoomAvailability("Single");
        controller.checkRoomAvailability("Suite");
    }
}
package com.seveneleven.bookmystay.app;

import com.seveneleven.bookmystay.controller.InventoryController;

/**
 * Main entry point for the BookMyStay application.
 * 
 * This class is responsible for starting the program and demonstrating
 * basic inventory operations such as:
 * - Setting up default room inventory
 * - Adding a new room type
 * - Updating an existing room type
 * - Checking room availability
 * 
 * The application interacts with the InventoryController which manages
 * the room inventory and related operations.
 * 
 * @author Developer
 * @version 3.0
 */
public class BookMyStayApp {

    /**
     * Main method that starts the BookMyStay application.
     * 
     * It performs the following actions:
     * 1. Creates an InventoryController instance
     * 2. Initializes default room inventory
     * 3. Adds a new room type
     * 4. Updates an existing room type
     * 5. Displays availability of different room types
     * 
     * @param args Command-line arguments (not used in this application)
     */
    public static void main(String[] args) {

        // Create controller object to manage hotel room inventory
        InventoryController controller = new InventoryController();

        // Initialize the system with default room inventory
        controller.setupInventory();

        // Add a new room type "Deluxe" with 8 rooms priced at 2500.0
        controller.addRoom("Deluxe", 8, 2500.0);

        // Update the existing "Single" room type with new quantity and price
        controller.updateRoom("Single", 12, 1100.0);

        // Display availability for different room types

        // Check availability for Single rooms
        controller.showAvailability("Single");

        // Check availability for Suite rooms
        controller.showAvailability("Suite");

        // Check availability for Deluxe rooms
        controller.showAvailability("Deluxe");
    }
}
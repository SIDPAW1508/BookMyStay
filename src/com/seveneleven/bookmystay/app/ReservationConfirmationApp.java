package com.seveneleven.bookmystay.app;

import com.seveneleven.bookmystay.controller.ReservationConfirmationController;

/**
 * Entry point for the Reservation Confirmation & Room Allocation feature of the BookMyStay application.
 *
 * This class demonstrates how the system confirms reservations and allocates unique room IDs
 * to prevent double-booking.
 *
 * Features demonstrated in this application:
 * - Confirm multiple bookings for a specific room type
 * - Allocate unique room IDs for each booking
 * - Display allocated room IDs per room type
 * - Ensure no duplicate room IDs are assigned
 *
 * This module uses a controller-service pattern where:
 * ReservationConfirmationController → handles requests from the app
 * ReservationConfirmationService → performs allocation logic and maintains uniqueness.
 */
public class ReservationConfirmationApp {

    /**
     * Main method that runs the Reservation Confirmation demonstration.
     *
     * The method performs the following steps:
     * - Create a ReservationConfirmationController
     * - Confirm multiple bookings for Single and Double rooms
     * - Display currently allocated room IDs
     * - Confirm additional bookings to demonstrate unique allocation
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        // Initialize the controller for reservation confirmation
        ReservationConfirmationController controller = new ReservationConfirmationController();

        // Confirm multiple bookings for Single rooms
        controller.confirmBooking("Single"); // Allocates first Single room
        controller.confirmBooking("Single"); // Allocates second Single room

        // Confirm bookings for Double rooms
        controller.confirmBooking("Double"); // Allocates first Double room

        // Display allocated room IDs for each room type
        controller.showAllocatedRooms("Single");
        controller.showAllocatedRooms("Double");

        // Confirm another Single room to demonstrate uniqueness of room IDs
        controller.confirmBooking("Single"); // Allocates third Single room
        controller.showAllocatedRooms("Single"); // Shows all allocated Single rooms
    }
}
package com.seveneleven.bookmystay.app;

import com.seveneleven.bookmystay.controller.BookingController;

/**
 * Demonstrates the First-Come-First-Served booking system.
 */
public class BookingApp {

    public static void main(String[] args) {

        BookingController controller = new BookingController();

        // Guests submit booking requests
        controller.submitBooking("Alice", "Single", 1, 1000);
        controller.submitBooking("Bob", "Double", 2, 3600);
        controller.submitBooking("Charlie", "Suite", 1, 3500);

        // Show pending requests
        controller.showPendingBookings();

        // Process bookings in order
        controller.processBooking();
        controller.processBooking();

        // Show pending requests
        controller.showPendingBookings();

        // Process remaining bookings
        controller.processBooking();
        controller.processBooking(); // Should indicate no bookings left
    }
}
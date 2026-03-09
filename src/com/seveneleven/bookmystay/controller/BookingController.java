package com.seveneleven.bookmystay.controller;

import com.seveneleven.bookmystay.model.Reservation;
import com.seveneleven.bookmystay.service.BookingService;

import java.util.List;
import java.util.UUID;

/**
 * Controller to handle guest booking requests.
 */
public class BookingController {

    private BookingService bookingService;

    public BookingController() {
        this.bookingService = new BookingService();
    }

    /**
     * Guest submits a booking request.
     */
    public void submitBooking(String guestName, String roomType, int quantity, double totalPrice) {
        // Generate a unique reservation ID
        String reservationId = "R" + UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        Reservation reservation = new Reservation(reservationId, guestName, roomType, quantity, totalPrice);

        bookingService.addBookingRequest(reservation);
        System.out.println("Booking submitted: " + reservationId);
    }

    /**
     * Process the next booking request in the queue.
     */
    public void processBooking() {
        bookingService.processNextBooking();
    }

    /**
     * Shows all pending bookings.
     */
    public void showPendingBookings() {
        List<Reservation> pending = bookingService.pendingBookings();

        System.out.println("\n--- Pending Bookings ---");
        if (pending.isEmpty()) {
            System.out.println("No pending bookings.");
        } else {
            for (Reservation r : pending) {
                System.out.println(r);
            }
        }
    }
}
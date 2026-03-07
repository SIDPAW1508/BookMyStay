package com.seveneleven.bookmystay.controller;

import com.seveneleven.bookmystay.model.Reservation;
import com.seveneleven.bookmystay.service.BookingService;

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
    public void submitBooking(String guestName, String roomType, int quantity) {
        Reservation reservation = new Reservation(guestName, roomType, quantity);
        bookingService.addBookingRequest(reservation);
    }

    /**
     * Process the next booking request.
     */
    public void processBooking() {
        bookingService.processNextBooking();
    }

    /**
     * Shows pending bookings.
     */
    public void showPendingBookings() {
        System.out.println("Pending bookings: " + bookingService.pendingBookings());
    }
}
package com.seveneleven.bookmystay.app;

import com.seveneleven.bookmystay.controller.BookingHistoryController;
import com.seveneleven.bookmystay.model.Reservation;

public class BookingHistoryApp {

    public static void main(String[] args) {

        BookingHistoryController controller = new BookingHistoryController();

        // Sample reservations
        Reservation r1 = new Reservation("R101", "Alice", "Single", 1, 1000);
        Reservation r2 = new Reservation("R102", "Bob", "Double", 2, 3600);
        Reservation r3 = new Reservation("R103", "Charlie", "Suite", 1, 3500);

        // Add reservations
        controller.confirmBooking(r1);
        controller.confirmBooking(r2);
        controller.confirmBooking(r3);

        // Show all reservations
        controller.showBookingHistory();

        // Show reservations by room type
        controller.showReservationsByRoomType("Single");

        // Cancel a reservation
        controller.cancelReservation("R102");

        // Show updated reservations
        controller.showBookingHistory();

        // Show cancelled reservations
        controller.showCancelledReservations();

        // Show revenue report
        controller.showRevenueReport();
    }
}
package com.seveneleven.bookmystay.controller;

import com.seveneleven.bookmystay.model.Reservation;
import com.seveneleven.bookmystay.service.BookingHistoryService;
import java.util.List;

public class BookingHistoryController {

    private BookingHistoryService service;

    public BookingHistoryController() {
        service = new BookingHistoryService();
    }

    // Add reservation
    public void confirmBooking(Reservation reservation) {
        service.addReservation(reservation);
    }

    // Cancel reservation by ID
    public void cancelReservation(String reservationId) {
        service.cancelReservation(reservationId);
    }

    // Show all reservations
    public void showBookingHistory() {
        System.out.println("\n--- All Reservations ---");
        for (Reservation r : service.getAllReservations()) {
            System.out.println(r);
        }
    }

    // Show reservations by room type
    public void showReservationsByRoomType(String roomType) {
        System.out.println("\n--- Reservations for Room Type: " + roomType + " ---");
        List<Reservation> list = service.getReservationsByRoomType(roomType);
        if (list.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            for (Reservation r : list) {
                System.out.println(r);
            }
        }
    }

    // Show cancelled reservations
    public void showCancelledReservations() {
        System.out.println("\n--- Cancelled Reservations ---");
        List<Reservation> cancelled = service.getCancelledReservations();
        if (cancelled.isEmpty()) {
            System.out.println("No cancelled reservations.");
        } else {
            for (Reservation r : cancelled) {
                System.out.println(r);
            }
        }
    }

    // Show total revenue
    public void showRevenueReport() {
        double total = service.calculateTotalRevenue();
        System.out.println("\n--- Total Revenue ---");
        System.out.println("Total Revenue: $" + total);
    }
}
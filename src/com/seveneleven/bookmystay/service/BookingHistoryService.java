package com.seveneleven.bookmystay.service;

import com.seveneleven.bookmystay.model.Reservation;
import java.util.ArrayList;
import java.util.List;

public class BookingHistoryService {

    private List<Reservation> reservationHistory;

    public BookingHistoryService() {
        reservationHistory = new ArrayList<>();
    }

    // Add a reservation
    public void addReservation(Reservation reservation) {
        reservationHistory.add(reservation);
        System.out.println("Reservation added: " + reservation.getReservationId());
    }

    // Cancel a reservation by ID
    public void cancelReservation(String reservationId) {
        for (Reservation r : reservationHistory) {
            if (r.getReservationId().equals(reservationId)) {
                r.cancelReservation();
                System.out.println("Reservation cancelled: " + reservationId);
                return;
            }
        }
        System.out.println("Reservation not found: " + reservationId);
    }

    // Show all reservations
    public List<Reservation> getAllReservations() {
        return reservationHistory;
    }

    // Get reservations by room type
    public List<Reservation> getReservationsByRoomType(String roomType) {
        List<Reservation> filtered = new ArrayList<>();
        for (Reservation r : reservationHistory) {
            if (r.getRoomType().equalsIgnoreCase(roomType)) {
                filtered.add(r);
            }
        }
        return filtered;
    }

    // Calculate total revenue from confirmed reservations
    public double calculateTotalRevenue() {
        double total = 0;
        for (Reservation r : reservationHistory) {
            if (r.getStatus().equals("CONFIRMED")) {
                total += r.getPrice();
            }
        }
        return total;
    }

    // Show all cancelled reservations
    public List<Reservation> getCancelledReservations() {
        List<Reservation> cancelled = new ArrayList<>();
        for (Reservation r : reservationHistory) {
            if (r.getStatus().equals("CANCELLED")) {
                cancelled.add(r);
            }
        }
        return cancelled;
    }
}
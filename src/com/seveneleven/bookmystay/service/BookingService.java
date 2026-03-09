package com.seveneleven.bookmystay.service;

import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;

import com.seveneleven.bookmystay.model.Reservation;

/**
 * Service to handle booking requests in a first-come-first-served manner.
 */
public class BookingService {

    private Queue<Reservation> bookingQueue;

    public BookingService() {
        this.bookingQueue = new LinkedList<>();
    }

    /**
     * Adds a booking request to the queue.
     */
    public void addBookingRequest(Reservation reservation) {
        bookingQueue.offer(reservation);
        System.out.println("Booking request queued: " + reservation);
    }

    /**
     * Processes the next booking request in FIFO order.
     */
    public void processNextBooking() {
        Reservation reservation = bookingQueue.poll();
        if (reservation == null) {
            System.out.println("No bookings to process.");
        } else {
            System.out.println("Processing booking for " + reservation.getGuestName()
                    + " (" + reservation.getRoomType() + ", Qty: " + reservation.getQuantity() + ")");
        }
    }

    /**
     * Returns the list of pending booking requests.
     */
    public List<Reservation> pendingBookings() {
        return new ArrayList<>(bookingQueue);
    }
}
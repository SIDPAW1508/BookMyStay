package com.seveneleven.bookmystay.controller;

import com.seveneleven.bookmystay.service.ReservationConfirmationService;

/**
 * Controller to handle reservation confirmation requests.
 */
public class ReservationConfirmationController {

    private ReservationConfirmationService confirmationService;

    public ReservationConfirmationController() {
        this.confirmationService = new ReservationConfirmationService();
    }

    /**
     * Confirms a booking and allocates a unique room ID.
     */
    public void confirmBooking(String roomType) {
        confirmationService.confirmReservation(roomType);
    }

    /**
     * Checks which room IDs are already allocated for a room type.
     */
    public void showAllocatedRooms(String roomType) {
        System.out.println("Allocated rooms for " + roomType + ": " +
                confirmationService.getAllocatedRooms(roomType));
    }
}
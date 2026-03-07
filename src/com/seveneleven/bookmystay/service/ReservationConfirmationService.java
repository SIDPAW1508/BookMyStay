package com.seveneleven.bookmystay.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Service to confirm reservations and allocate unique room IDs.
 * Ensures no double-booking and immediate inventory update.
 */
public class ReservationConfirmationService {

    // Tracks all booked room IDs to enforce uniqueness
    private Set<String> bookedRoomIds;

    // Maps room type to the set of allocated room IDs
    private HashMap<String, Set<String>> roomAllocations;

    public ReservationConfirmationService() {
        this.bookedRoomIds = new HashSet<>();
        this.roomAllocations = new HashMap<>();
    }

    /**
     * Confirms a reservation by assigning a unique room ID.
     *
     * @param roomType the type of room being booked
     * @return allocated room ID or null if no rooms available
     */
    public String confirmReservation(String roomType) {

        // Initialize allocation set for this room type if absent
        roomAllocations.putIfAbsent(roomType, new HashSet<>());

        // Generate a unique room ID (simple example: roomType + count)
        String roomId;
        int counter = roomAllocations.get(roomType).size() + 1;

        do {
            roomId = roomType.substring(0, 1).toUpperCase() + counter;
            counter++;
        } while (bookedRoomIds.contains(roomId));

        // Allocate the room
        bookedRoomIds.add(roomId);
        roomAllocations.get(roomType).add(roomId);

        System.out.println("Reservation confirmed: Room ID = " + roomId + " (" + roomType + ")");
        return roomId;
    }

    /**
     * Returns all room IDs booked for a room type.
     */
    public Set<String> getAllocatedRooms(String roomType) {
        return roomAllocations.getOrDefault(roomType, new HashSet<>());
    }

    /**
     * Checks if a room ID is already booked.
     */
    public boolean isRoomBooked(String roomId) {
        return bookedRoomIds.contains(roomId);
    }
}
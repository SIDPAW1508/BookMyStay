package com.seveneleven.bookmystay.app;

import java.util.*;

/**
 * BookMyStayApp - A single main class combining inventory, booking queue,
 * add-on services, and booking history.
 */
public class BookMyStay {

    // -------------------- Models --------------------
    static class Reservation {
        String reservationId;
        String guestName;
        String roomType;
        int quantity;
        double price;
        String status; // PENDING, CONFIRMED, CANCELLED
        List<Service> services = new ArrayList<>();

        public Reservation(String reservationId, String guestName, String roomType, int quantity, double price) {
            this.reservationId = reservationId;
            this.guestName = guestName;
            this.roomType = roomType;
            this.quantity = quantity;
            this.price = price;
            this.status = "CONFIRMED";
        }

        public void cancelReservation() { this.status = "CANCELLED"; }

        public double getTotalPrice() {
            double serviceTotal = services.stream().mapToDouble(s -> s.price).sum();
            return price + serviceTotal;
        }

        @Override
        public String toString() {
            return "ReservationID=" + reservationId +
                    ", Guest=" + guestName +
                    ", RoomType=" + roomType +
                    ", Qty=" + quantity +
                    ", Price=" + getTotalPrice() +
                    ", Status=" + status +
                    ", Services=" + services;
        }
    }

    static class Service {
        String name;
        double price;

        public Service(String name, double price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return name + "($" + price + ")";
        }
    }

    // -------------------- Services --------------------
    static class InventoryService {
        Map<String, Integer> roomCounts = new HashMap<>();
        Map<String, Double> roomPrices = new HashMap<>();

        public void addRoomType(String type, int count, double price) {
            roomCounts.put(type, count);
            roomPrices.put(type, price);
        }

        public boolean isAvailable(String type, int quantity) {
            return roomCounts.getOrDefault(type, 0) >= quantity;
        }

        public void bookRoom(String type, int quantity) {
            roomCounts.put(type, roomCounts.get(type) - quantity);
        }

        public void releaseRoom(String type, int quantity) {
            roomCounts.put(type, roomCounts.getOrDefault(type, 0) + quantity);
        }

        public void showInventory() {
            System.out.println("\n--- Room Inventory ---");
            for (String type : roomCounts.keySet()) {
                System.out.println(type + ": " + roomCounts.get(type) + " available, Price: $" + roomPrices.get(type));
            }
        }
    }

    static class BookingQueueService {
        Queue<Reservation> queue = new LinkedList<>();

        public void addBookingRequest(Reservation r) { queue.offer(r); }

        public Reservation processNextBooking() { return queue.poll(); }

        public List<Reservation> pendingBookings() { return new ArrayList<>(queue); }
    }

    static class BookingHistoryService {
        List<Reservation> history = new ArrayList<>();

        public void addReservation(Reservation r) { history.add(r); }

        public void cancelReservation(String id) {
            for (Reservation r : history) {
                if (r.reservationId.equals(id)) {
                    r.cancelReservation();
                    return;
                }
            }
        }

        public List<Reservation> getAllReservations() { return history; }

        public List<Reservation> getCancelledReservations() {
            List<Reservation> cancelled = new ArrayList<>();
            for (Reservation r : history) {
                if (r.status.equals("CANCELLED")) cancelled.add(r);
            }
            return cancelled;
        }

        public double calculateRevenue() {
            double total = 0;
            for (Reservation r : history) {
                if (r.status.equals("CONFIRMED")) total += r.getTotalPrice();
            }
            return total;
        }
    }

    // -------------------- Main --------------------
    public static void main(String[] args) {

        InventoryService inventory = new InventoryService();
        BookingQueueService bookingQueue = new BookingQueueService();
        BookingHistoryService history = new BookingHistoryService();

        // -------------------- Phase 1: Setup Inventory --------------------
        inventory.addRoomType("Single", 5, 1000);
        inventory.addRoomType("Double", 3, 1800);
        inventory.addRoomType("Suite", 2, 3500);

        inventory.showInventory();

        // -------------------- Phase 2: Booking Requests --------------------
        Reservation r1 = new Reservation("R101", "Alice", "Single", 1, inventory.roomPrices.get("Single"));
        Reservation r2 = new Reservation("R102", "Bob", "Double", 2, inventory.roomPrices.get("Double"));
        Reservation r3 = new Reservation("R103", "Charlie", "Suite", 1, inventory.roomPrices.get("Suite"));

        bookingQueue.addBookingRequest(r1);
        bookingQueue.addBookingRequest(r2);
        bookingQueue.addBookingRequest(r3);

        System.out.println("\n--- Pending Bookings ---");
        for (Reservation r : bookingQueue.pendingBookings()) System.out.println(r);

        // -------------------- Phase 3: Process Booking Queue --------------------
        Reservation next;
        while ((next = bookingQueue.processNextBooking()) != null) {
            if (inventory.isAvailable(next.roomType, next.quantity)) {
                inventory.bookRoom(next.roomType, next.quantity);
                history.addReservation(next);
                System.out.println("\nBooking Confirmed: " + next);
            } else {
                System.out.println("\nBooking Failed (No Availability): " + next);
            }
        }

        inventory.showInventory();

        // -------------------- Phase 4: Add-on Services --------------------
        r1.services.add(new Service("Breakfast", 200));
        r3.services.add(new Service("Airport Pickup", 500));
        System.out.println("\n--- Reservations with Services ---");
        for (Reservation r : history.getAllReservations()) System.out.println(r);

        // -------------------- Phase 5: Cancel a Reservation --------------------
        history.cancelReservation("R102");
        System.out.println("\n--- After Cancellation ---");
        for (Reservation r : history.getAllReservations()) System.out.println(r);

        // -------------------- Phase 6: Reports --------------------
        System.out.println("\n--- Cancelled Reservations ---");
        for (Reservation r : history.getCancelledReservations()) System.out.println(r);

        System.out.println("\n--- Total Revenue --- $" + history.calculateRevenue());
    }
}
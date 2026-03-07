package com.seveneleven.bookmystay.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.seveneleven.bookmystay.service.Service;

/**
 * Service to manage add-on services for reservations.
 * Supports attaching multiple services per reservation.
 */
public class AddOnService {

    // Maps reservation ID to a list of selected services
    private Map<String, List<Service>> reservationServices;

    public AddOnService() {
        reservationServices = new HashMap<>();
    }

    /**
     * Attach a service to a reservation.
     *
     * @param reservationId Reservation ID
     * @param service       Service to attach
     */
    public void addService(String reservationId, Service service) {
        reservationServices.putIfAbsent(reservationId, new ArrayList<>());
        reservationServices.get(reservationId).add(service);
        System.out.println("Service added: " + service + " to reservation " + reservationId);
    }

    /**
     * Get all services attached to a reservation.
     *
     * @param reservationId Reservation ID
     * @return List of services
     */
    public List<Service> getServices(String reservationId) {
        return reservationServices.getOrDefault(reservationId, new ArrayList<>());
    }

    /**
     * Calculate total add-on cost for a reservation.
     *
     * @param reservationId Reservation ID
     * @return Total cost of add-on services
     */
    public double calculateTotalCost(String reservationId) {
        List<Service> services = getServices(reservationId);
        return services.stream().mapToDouble(Service::getPrice).sum();
    }
}
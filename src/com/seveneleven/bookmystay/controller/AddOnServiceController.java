package com.seveneleven.bookmystay.controller;

import com.seveneleven.bookmystay.service.Service; // Corrected import
import com.seveneleven.bookmystay.service.AddOnService;

import java.util.List;

/**
 * Controller to handle guest add-on service requests in the BookMyStay application.
 *
 * <p>This class acts as an intermediary between the application layer (e.g., AddOnServiceApp)
 * and the service layer (AddOnService).</p>
 *
 * <p>Features provided:</p>
 * - Attach one or more services (breakfast, spa, pickup) to a reservation  
 * - Retrieve all selected services for a reservation  
 * - Calculate total cost of all add-on services per reservation
 */
public class AddOnServiceController {

    /** Service layer instance that manages the reservation → service mapping */
    private AddOnService addOnService;

    /**
     * Constructor initializes the AddOnService.
     */
    public AddOnServiceController() {
        this.addOnService = new AddOnService();
    }

    /**
     * Guest selects an add-on service for a specific reservation.
     *
     * @param reservationId the unique reservation ID
     * @param service       the add-on service to attach (e.g., Breakfast, Spa)
     */
    public void selectService(String reservationId, Service service) {
        addOnService.addService(reservationId, service);
    }

    /**
     * Display all services attached to a reservation and the total add-on cost.
     *
     * @param reservationId the unique reservation ID
     */
    public void showServices(String reservationId) {
        List<Service> services = addOnService.getServices(reservationId);
        System.out.println("Services for " + reservationId + ": " + services);
        System.out.println("Total add-on cost: $" + addOnService.calculateTotalCost(reservationId));
    }
}
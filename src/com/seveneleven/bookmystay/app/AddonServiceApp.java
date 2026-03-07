package com.seveneleven.bookmystay.app;

import com.seveneleven.bookmystay.controller.AddOnServiceController;
import com.seveneleven.bookmystay.service.Service;

/**
 * Demonstrates Add-On Service selection for reservations.
 */
public class AddonServiceApp {

    public static void main(String[] args) {

        AddOnServiceController controller = new AddOnServiceController();

        // Sample reservation IDs
        String reservation1 = "R101";
        String reservation2 = "R102";

        // Guest selects services
        controller.selectService(reservation1, new Service("Breakfast", 20));
        controller.selectService(reservation1, new Service("Spa", 50));
        controller.selectService(reservation2, new Service("Pickup", 30));

        // Display services and total cost
        controller.showServices(reservation1);
        controller.showServices(reservation2);
    }
}
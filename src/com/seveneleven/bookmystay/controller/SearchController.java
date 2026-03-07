package com.seveneleven.bookmystay.controller;

import java.util.HashMap;

import com.seveneleven.bookmystay.model.Room;
import com.seveneleven.bookmystay.service.SearchService;

/**
 * Controller that handles guest search requests.
 */
public class SearchController {

    private SearchService searchService;

    public SearchController(HashMap<String, Room> roomInventory) {
        this.searchService = new SearchService(roomInventory);
    }

    public void searchRooms() {
        searchService.displayAvailableRooms();
    }

    public void checkRoomAvailability(String roomType) {
        searchService.checkAvailability(roomType);
    }
}
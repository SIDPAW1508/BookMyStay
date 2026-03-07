# Use Case 2: Room Search & Availability Check

## Overview

The **Room Search & Availability Check** module allows guests to view available room types and check their availability without modifying the inventory.

This feature ensures that guests can search rooms quickly while maintaining **read-only access to the room inventory**.

The system retrieves room information using efficient **HashMap lookups**, ensuring fast response times.
---
# Example Operations

### Initialize Inventory

```
Single → 10 rooms → ₹1000
Double → 5 rooms → ₹1800
Suite  → 0 rooms → ₹3500
```

---

### Guest Searches Rooms

Output:

```
Available Rooms:

Room Type: Single
Price: ₹1000
Amenities: WiFi, TV
Available Count: 10

Room Type: Double
Price: ₹1800
Amenities: WiFi, TV, Mini Bar
Available Count: 5
```

---

### Check Specific Room Availability

```
Single rooms available: 10
Suite is currently unavailable.
```

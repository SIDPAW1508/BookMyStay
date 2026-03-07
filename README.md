# Use Case 3: Booking Request (First-Come-First-Served)

## Overview

The Booking Request module ensures guest reservations are processed in **first-come-first-served (FIFO) order**, maintaining fairness during high-demand scenarios.

A **Queue of Reservation objects** is used to manage booking requests and guarantees predictable, ordered processing.

---
## Key Data Structures

* **Queue<Reservation> (LinkedList)**
  Stores booking requests in arrival order (FIFO).
## Example Operations

### Guests Submit Booking Requests

```
Alice → Single → 1
Bob → Double → 2
Charlie → Suite → 1
```

### Process Bookings in FIFO Order

```
Processing booking for Alice (Single, Qty: 1)
Processing booking for Bob (Double, Qty: 2)
Processing booking for Charlie (Suite, Qty: 1)
No bookings to process.
```

### Pending Requests

```
Pending bookings: 0
```

---

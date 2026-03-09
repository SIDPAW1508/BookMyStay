# BookMyStay – Hotel Booking Management System
## Overview
BookMyStay is a hotel booking application that allows guests to search and reserve rooms on a **first-come, first-served basis**.
The system manages **live room inventory**, processes bookings, prevents **double-booking**, and supports **add-on services** like breakfast, spa, and airport pickup.
This project demonstrates how **Core Java and data structures** can be used to design a real-world booking system.
---
## Tech Stack
**Language:** Java  
**Concepts Used**
- Object-Oriented Programming (OOP)
- Data Structures
**Data Structures Used**
- HashMap
- Queue
- Set
- List
---
## Use Cases
### 1. Room Inventory Management
**Data Structures**
- `HashMap<String, Integer>` → Room type → Available count  
- `HashMap<String, Double>` → Room type → Price per night  
**Goal**
Maintain a centralized room inventory with **fast lookup** and **real-time availability**.
---
### 2. Room Search & Availability
Guests can search **available room types and view pricing** without modifying inventory.
**Concepts**
- Read-only access
- Availability validation
---
### 3. Booking Request (FIFO)
**Data Structure**
- `Queue<Reservation>` using `LinkedList`
Booking requests are processed using the **First-In-First-Out (FIFO)** principle to ensure fairness.
---
### 4. Reservation Confirmation
**Data Structures**
- `Set<String>` → Unique room IDs  
- `HashMap<String, Set<String>>` → Room type → Assigned rooms  
Ensures **unique room allocation** and prevents **double-booking**.
---
### 5. Add-On Services
**Data Structure**
- `Map<String, List<Service>>` → Reservation ID → Services  
Allows guests to attach services such as **breakfast, spa, or airport pickup**.
---
### 6. Booking History & Reporting
**Data Structure**
- `List<Reservation>`
Stores confirmed reservations for **history tracking and reporting**.
---
## Learning Outcomes
- Practical use of **Java Data Structures**
- Implementation of a **real-world system design**
- Understanding **inventory and booking workflows**
---
## Author
**Siddhi Pawar**  
B.Tech CSE (IoT)

QUESTION:
1. Parking Lot System
🧠 Concepts: OOP, Classes, Inheritance, Design Thinking
✅ Features:

Multiple floors, each with different types of parking spots (small, medium, large)

Entry/Exit gates, parking ticket generation

Real-time availability tracking

🔁 Extendable: Add payment logic, parking fee calculation


EXPLANATION:

The app simulates a basic multi-floor parking lot that:
Supports BIKE, CAR, and TRUCK
Uses SlotType to assign vehicles
Tracks parking/unparking using Ticket

**model/ Layer – Data & Enums

VehicleType.java -- 
Purpose: Enum to identify vehicle types.

SlotType.java --
Purpose: Enum for slot sizes that match vehicle types.

Vehicle.java --
Holds vehicle number (KA05AB1234) and type (BIKE, CAR, etc.).

ParkingSlot.java --
Represents a slot on a floor.
Tracks if it's occupied and which vehicle is in it.

Floor.java --
Each floor has multiple slots.

Ticket.java --
Represents parking proof.
Stores slot, floor, vehicle info, and entry time.

 **service/ParkingLot.java – Business Logic
This class:
Maintains the parking lot
Parks/unparks vehicles
Generates tickets

Key functions:

canFit() --
Checks if a vehicle type can fit in a given slot type:
BIKE → SMALL, MEDIUM, LARGE
CAR → MEDIUM, LARGE
TRUCK → LARGE

park(Vehicle vehicle) --
Loops through all floors and slots.
Finds first empty slot that fits the vehicle.
Marks it occupied and returns a Ticket.

unpark(String ticketId) --
Uses stored tickets map to get slot.
Clears slot and removes ticket.

getAvailableSlots(int floorNumber, SlotType type) --
Returns all available (non-occupied) slots of a given type from a floor.


** Main.java – Entry Point
This file:
Creates floors and slots
Initializes the ParkingLot object
Creates 3 vehicles
Parks them
Displays slot availability
Unparks a car
Checks slot availability again

Example Output--
Parked at Floor 0, Slot 0
Parked at Floor 0, Slot 1
Parked at Floor 0, Slot 2
Available Medium Slots on Floor 0: 0
Unparked vehicle: KA05CD5678
Available Medium Slots on Floor 0 after unparking: 1



Class	            Role
Vehicle	           Stores vehicle info
SlotType	       Enum for slot size
VehicleType	       Enum for vehicle type
ParkingSlot	       Each spot on a floor
Floor	           A list of slots
Ticket	           Receipt with parking details
ParkingLot	       Core logic: park, unpark, check
Main	           Simulates the system with test data
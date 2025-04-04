package service;

import model.*;

import java.time.LocalDateTime;
import java.util.*;

public class ParkingLot {
    private List<Floor> floors;
    private Map<String, Ticket> activeTickets;

    public ParkingLot(List<Floor> floors) {
        this.floors = floors;
        this.activeTickets = new HashMap<>();
    }

    public Ticket park(Vehicle vehicle) {
        SlotType preferredSlot = getPreferredSlot(vehicle.type);

        for (Floor floor : floors) {
            for (ParkingSlot slot : floor.slots) {
                if (!slot.isOccupied && slot.type == preferredSlot) {
                    slot.isOccupied = true;
                    slot.parkedVehicle = vehicle;

                    String ticketId = UUID.randomUUID().toString();
                    Ticket ticket = new Ticket(ticketId, floor.floorNumber, slot.id, vehicle, LocalDateTime.now());
                    activeTickets.put(ticketId, ticket);

                    System.out.println("Parked at Floor " + floor.floorNumber + ", Slot " + slot.id);
                    return ticket;
                }
            }
        }

        System.out.println("No available slots for vehicle type: " + vehicle.type);
        return null;
    }

    public void unpark(String ticketId) {
        Ticket ticket = activeTickets.get(ticketId);
        if (ticket == null) {
            System.out.println("Invalid ticket ID");
            return;
        }

        Floor floor = floors.get(ticket.floorNumber);
        ParkingSlot slot = floor.slots.get(ticket.slotId);

        slot.isOccupied = false;
        slot.parkedVehicle = null;

        activeTickets.remove(ticketId);

        System.out.println("Unparked vehicle: " + ticket.vehicle.number);
    }

    public List<ParkingSlot> getAvailableSlots(int floorNumber, SlotType slotType) {
        Floor floor = floors.get(floorNumber);
        List<ParkingSlot> available = new ArrayList<>();

        for (ParkingSlot slot : floor.slots) {
            if (!slot.isOccupied && slot.type == slotType) {
                available.add(slot);
            }
        }

        return available;
    }

    private SlotType getPreferredSlot(VehicleType type) {
        switch (type) {
            case BIKE: return SlotType.SMALL;
            case CAR: return SlotType.MEDIUM;
            case TRUCK: return SlotType.LARGE;
            default: throw new IllegalArgumentException("Unknown vehicle type");
        }
    }
}

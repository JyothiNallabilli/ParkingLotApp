import model.*;
import service.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create sample parking slots
        List<ParkingSlot> slotsFloor0 = Arrays.asList(
            new ParkingSlot(0, SlotType.SMALL),
            new ParkingSlot(1, SlotType.MEDIUM),
            new ParkingSlot(2, SlotType.LARGE)
        );

        List<ParkingSlot> slotsFloor1 = Arrays.asList(
            new ParkingSlot(0, SlotType.SMALL),
            new ParkingSlot(1, SlotType.MEDIUM),
            new ParkingSlot(2, SlotType.LARGE)
        );

        // Create floors
        Floor floor0 = new Floor(0, slotsFloor0);
        Floor floor1 = new Floor(1, slotsFloor1);

        List<Floor> floors = Arrays.asList(floor0, floor1);

        // Initialize Parking Lot
        ParkingLot parkingLot = new ParkingLot(floors);

        // Create vehicles
        Vehicle bike = new Vehicle("KA01AB1234", VehicleType.BIKE);
        Vehicle car = new Vehicle("KA05CD5678", VehicleType.CAR);
        Vehicle truck = new Vehicle("KA09EF9012", VehicleType.TRUCK);

        // Park vehicles
        Ticket ticket1 = parkingLot.park(bike);
        Ticket ticket2 = parkingLot.park(car);
        Ticket ticket3 = parkingLot.park(truck);

        // Display available medium slots on Floor 0
        List<ParkingSlot> available = parkingLot.getAvailableSlots(0, SlotType.MEDIUM);
        System.out.println("Available Medium Slots on Floor 0: " + available.size());

        // Unpark vehicle
        if (ticket2 != null) {
            parkingLot.unpark(ticket2.ticketId);
        }

        // Display available medium slots on Floor 0 again
        available = parkingLot.getAvailableSlots(0, SlotType.MEDIUM);
        System.out.println("Available Medium Slots on Floor 0 after unparking: " + available.size());
    }
}

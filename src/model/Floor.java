package model;

import java.util.List;

public class Floor {
    public int floorNumber;
    public List<ParkingSlot> slots;

    public Floor(int floorNumber, List<ParkingSlot> slots) {
        this.floorNumber = floorNumber;
        this.slots = slots;
    }
}

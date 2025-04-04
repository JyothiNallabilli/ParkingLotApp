package model;

public class ParkingSlot {
    public int id;
    public SlotType type;
    public boolean isOccupied;
    public Vehicle parkedVehicle;

    public ParkingSlot(int id, SlotType type) {
        this.id = id;
        this.type = type;
        this.isOccupied = false;
    }
}

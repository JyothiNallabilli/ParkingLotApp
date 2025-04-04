package model;

import java.time.LocalDateTime;

public class Ticket {
    public String ticketId;
    public int floorNumber;
    public int slotId;
    public Vehicle vehicle;
    public LocalDateTime entryTime;

    public Ticket(String ticketId, int floorNumber, int slotId, Vehicle vehicle, LocalDateTime entryTime) {
        this.ticketId = ticketId;
        this.floorNumber = floorNumber;
        this.slotId = slotId;
        this.vehicle = vehicle;
        this.entryTime = entryTime;
    }
}

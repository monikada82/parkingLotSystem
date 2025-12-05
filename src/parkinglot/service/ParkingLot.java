package parkinglot.service;

import parkinglot.models.*;
import java.util.*;

public class ParkingLot {
    private final List<Level> levels;
    private final Map<Integer, ParkingSlot> slotLookup = new HashMap<>();

    public ParkingLot(List<Level> levels) {
        this.levels = levels;

        // Fill slot lookup table for O(1) slot search
        for (Level level : levels) {
            for (ParkingSlot slot : level.getSlots()) {
                slotLookup.put(slot.getSlotId(), slot);
            }
        }
    }

    // Main method to park a vehicle
    public Ticket parkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            for (ParkingSlot slot : level.getSlots()) {

                if (slot.isAvailable() && isCompatible(slot.getSlotType(), vehicle.getType())) {
                    slot.park(vehicle);

                    String ticketId = "T-" + vehicle.getNumber() + "-" + slot.getSlotId();

                    System.out.println("Parked " + vehicle.getNumber() + " at Slot " + slot.getSlotId()
                            + " (Level " + level.getLevelNumber() + ")");

                    return new Ticket(ticketId, vehicle.getNumber(), slot.getSlotId());
                }
            }
        }

        System.out.println("Parking Full for vehicle type: " + vehicle.getType());
        return null;
    }

    // Compatibility rules
    private boolean isCompatible(SlotType slot, VehicleType vehicle) {
        if (vehicle == VehicleType.BIKE) return true;
        if (vehicle == VehicleType.CAR && (slot == SlotType.MEDIUM || slot == SlotType.LARGE)) return true;
        if (vehicle == VehicleType.TRUCK && slot == SlotType.LARGE) return true;

        return false;
    }

    // Unpark vehicle using ticket
    public boolean unparkVehicle(Ticket ticket) {
        ParkingSlot slot = slotLookup.get(ticket.getSlotId());

        if (slot == null) {
            System.out.println("Invalid Ticket!");
            return false;
        }

        if (slot.isAvailable()) {
            System.out.println("Slot already empty!");
            return false;
        }

        System.out.println("Unparking vehicle " + ticket.getVehicleNumber()
                + " from Slot " + slot.getSlotId());

        slot.unpark();
        return true;
    }

    // Display parking status
    public void printStatus() {
        System.out.println("\n===== PARKING LOT STATUS =====");
        for (Level level : levels) {
            System.out.println("Level " + level.getLevelNumber() + ":");
            for (ParkingSlot slot : level.getSlots()) {
                String status = slot.isAvailable()
                        ? "FREE"
                        : "OCCUPIED by " + slot.getParkedVehicle().getNumber();

                System.out.println("  Slot " + slot.getSlotId()
                        + " (" + slot.getSlotType() + ") -> "
                        + status);
            }
        }
    }
}

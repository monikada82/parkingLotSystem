import parkinglot.models.*;
import parkinglot.service.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // LEVEL 1 SLOTS
        List<ParkingSlot> level1Slots = new ArrayList<>();
        level1Slots.add(new ParkingSlot(1, SlotType.SMALL));
        level1Slots.add(new ParkingSlot(2, SlotType.MEDIUM));
        level1Slots.add(new ParkingSlot(3, SlotType.LARGE));

        // LEVEL 2 SLOTS
        List<ParkingSlot> level2Slots = new ArrayList<>();
        level2Slots.add(new ParkingSlot(4, SlotType.SMALL));
        level2Slots.add(new ParkingSlot(5, SlotType.MEDIUM));
        level2Slots.add(new ParkingSlot(6, SlotType.LARGE));

        // CREATE LEVEL OBJECTS
        Level level1 = new Level(1, level1Slots);
        Level level2 = new Level(2, level2Slots);

        // CREATE PARKING LOT
        ParkingLot parkingLot = new ParkingLot(Arrays.asList(level1, level2));

        // VEHICLES
        Vehicle bike = new Bike("BIKE101");
        Vehicle car = new Car("CAR202");
        Vehicle truck = new Truck("TRK303");
        Vehicle car2 = new Car("CAR404");

        // PARK VEHICLES
        Ticket t1 = parkingLot.parkVehicle(bike);   // should park at slot 1
        Ticket t2 = parkingLot.parkVehicle(car);    // should park at slot 2
        Ticket t3 = parkingLot.parkVehicle(truck);  // should park at slot 3
        Ticket t4 = parkingLot.parkVehicle(car2);   // should park at slot 5 (level 2)

        // PRINT STATUS
        parkingLot.printStatus();

        // UNPARK CAR202 (slot 2)
        parkingLot.unparkVehicle(t2);

        System.out.println("\nAfter Unparking CAR202:");
        parkingLot.printStatus();
    }
}

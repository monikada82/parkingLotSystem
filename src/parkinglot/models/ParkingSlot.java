package parkinglot.models;

public class ParkingSlot {
    private final int slotId;
    private final SlotType slotType;
    private boolean isAvailable;
    private Vehicle parkedVehicle;


    public ParkingSlot(int slotId, SlotType slotType){
        this.slotId=slotId;
        this.slotType=slotType;
        this.isAvailable=true;
        this.parkedVehicle=null;
    }
    public boolean isAvailable() {
        return isAvailable;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public int getSlotId() {
        return slotId;
    }

    public SlotType getSlotType() {
        return slotType;
    }
//park vehicle;
    public void park(Vehicle v){
        if(!isAvailable){
            throw new IllegalStateException("SLot is occupied");
        }
        this.parkedVehicle=v;
        this.isAvailable=false;
    }
    //unpark
    public void unpark(){
        this.parkedVehicle=null;
        this.isAvailable=true;
    }

}

package parkinglot.models;
import java.time.LocalDateTime;
public class Ticket {
    private final String ticketId;
    private final String vehicleNumber;
    private final int slotId;
    private final LocalDateTime issuedAt;

    public Ticket(String ticketId,String vehicleNumber,int slotId){
        this.ticketId=ticketId;
        this.vehicleNumber=vehicleNumber;
        this.slotId=slotId;
        this.issuedAt=LocalDateTime.now();
    }

    public LocalDateTime getIssuedAt() {
        return issuedAt;
    }

    public int getSlotId() {
        return slotId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }
}

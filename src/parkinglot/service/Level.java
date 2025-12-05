package parkinglot.service;
import parkinglot.models.ParkingSlot;
import java.util.List;
public class Level {
    private final int levelNumber;
    private final List<ParkingSlot>slots;

    public int getLevelNumber() {
        return levelNumber;
    }

    public List<ParkingSlot> getSlots() {
        return slots;
    }

    public Level(int levelNumber, List<ParkingSlot>slots){
        this.levelNumber=levelNumber;
        this.slots=slots;
    }
}

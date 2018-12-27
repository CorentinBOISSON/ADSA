package battleship;

import java.util.List;

public class Plateau {

    private List<Position> slot;

    public Plateau(List<Position> slot) {
        this.slot = slot;
    }

    public List<Position> getSlot() {
        return slot;
    }

    public void setSlot(List<Position> slot) {
        this.slot = slot;
    }
}
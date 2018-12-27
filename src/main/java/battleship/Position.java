package battleship;

public class Position{

    private int row;
    private int column;
    private boolean isOccupied;
    private boolean isHit;

    public Position(int row, int column, boolean isOccupied, boolean isHit) {
        this.row = row;
        this.column = column;
        this.isOccupied = isOccupied;
        this.isHit = isHit;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Position{" +
                "row=" + row +
                ", column=" + column +
                ", isOccupied=" + isOccupied +
                ", isHit=" + isHit +
                '}';
    }
}
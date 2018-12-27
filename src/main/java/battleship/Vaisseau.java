package battleship;

public class Vaisseau{

    private List<Position> longueur;
    private boolean isSink;
    private int shoot;

    public boolean isSink() {
        return isSink;
    }

    public void setSink(boolean sink) {
        isSink = sink;
    }

    public int getShoot() {
        return shoot;
    }

    public void setShoot(int shoot) {
        this.shoot = shoot;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Vaisseau{" +
                "longueur=" + longueur +
                ", isSink=" + isSink +
                ", shoot=" + shoot +
                '}';
    }
}
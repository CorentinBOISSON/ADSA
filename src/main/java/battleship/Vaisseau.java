package battleship;

import java.util.List;

public class Vaisseau{

    private List<Position> longueur;
    private boolean isSink;
    private int shoot;

    public Vaisseau(List<Position> longueur, boolean isSink, int shoot) {
        this.longueur = longueur;
        this.isSink = isSink;
        this.shoot = shoot;
    }

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
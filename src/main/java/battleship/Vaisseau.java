package battleship;

import java.util.List;

public class Vaisseau{

    private List<Position> emplacement;
    private int longueur;
    private Type Type;
    private boolean isSink;
    private int shoot;

    public Vaisseau(List<Position> emplacement, int longueur, battleship.Type type, boolean isSink, int shoot) {
        this.emplacement = emplacement;
        this.longueur = longueur;
        Type = type;
        this.isSink = isSink;
        this.shoot = shoot;
    }

    public List<Position> getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(List<Position> emplacement) {
        this.emplacement = emplacement;
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public battleship.Type getType() {
        return Type;
    }

    public void setType(battleship.Type type) {
        Type = type;
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

    @Override
    public String toString() {
        return "Vaisseau{" +
                "emplacement=" + emplacement +
                ", longueur=" + longueur +
                ", Type=" + Type +
                ", isSink=" + isSink +
                ", shoot=" + shoot +
                '}';
    }
}
package battleship;

import java.util.List;

public class Player {

    private String player;
    private List<Bateau> Ships;
    private int nbTour;
    private int nbShip;

    public Player(String player, List<Bateau> ships, int nbTour, int nbShip) {
        this.player = player;
        Ships = ships;
        this.nbTour = nbTour;
        this.nbShip = nbShip;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public List<Bateau> getShips() {
        return Ships;
    }

    public void setShips(List<Bateau> ships) {
        Ships = ships;
    }

    public int getNbTour() {
        return nbTour;
    }

    public void setNbTour(int nbTour) {
        this.nbTour = nbTour;
    }

    public int getNbShip() {
        return nbShip;
    }

    public void setNbShip(int nbShip) {
        this.nbShip = nbShip;
    }
}

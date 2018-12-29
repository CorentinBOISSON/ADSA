package battleship;

import java.util.List;
import java.util.Scanner;

public class Player {

    private String player;
    private List<Navire> Ships;
    private int nbTour;
    private int nbShip;



    public Player(String player, List<Navire> Ships, int nbTour, int nbShip) {
        this.Ships=Ships;
        this.player = player;
        this.nbTour = nbTour;
        this.nbShip = nbShip;
    }


    public List<Navire> getShips() {
        return Ships;
    }

    public void setShips(List<Navire> Ships) {
        this.Ships = Ships;
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

    public void CommencerPartie()
    {
        System.out.println("****** Welcome to BattleShip Royale ****** \n Please enter your name :");
        Scanner s = new Scanner(System.in);
        String player = s.nextLine();

    }

}

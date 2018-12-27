package battleship;

import java.util.Scanner;

public class Jeu{

    private int nbTour;
    private int nbShip;
    private int nbShot;
    private int nbSink;
    private String player;

    public Jeu(int nbTour, int nbShip, int nbShot, int nbSink, String player) {
        this.nbTour = nbTour;
        this.nbShip = nbShip;
        this.nbShot = nbShot;
        this.nbSink = nbSink;
        this.player = player;
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

    public int getNbShot() {
        return nbShot;
    }

    public void setNbShot(int nbShot) {
        this.nbShot = nbShot;
    }

    public int getNbSink() {
        return nbSink;
    }

    public void setNbSink(int nbSink) {
        this.nbSink = nbSink;
    }


    public void CommencerPartie(String joueur1, String joueur2)
    {
        System.out.println("****** Welcome to BattleShip Royale ****** \n Please enter your name :");
        Scanner s = new Scanner(System.in);
        String player = s.nextLine();

    }
}
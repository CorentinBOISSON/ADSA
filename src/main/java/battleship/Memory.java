package battleship;

public class Memory {

    public boolean random;
    public int[] coordonées;
    public int[][] haut;
    public int[][] bas;
    public int[][] droite;
    public int[][] gauche;

    public Memory(boolean random, int[] coordonées, int[][] haut, int[][] bas, int[][] droite, int[][] gauche) {
        this.random = random;
        this.coordonées = coordonées;
        this.haut = haut;
        this.bas = bas;
        this.droite = droite;
        this.gauche = gauche;
    }

    public boolean isRandom() {
        return random;
    }

    public void setRandom(boolean random) {
        this.random = random;
    }

    public int[] getCoordonées() {
        return coordonées;
    }

    public void setCoordonées(int[] coordonées) {
        this.coordonées = coordonées;
    }

    public int[][] getHaut() {
        return haut;
    }

    public void setHaut(int[][] haut) {
        this.haut = haut;
    }

    public int[][] getBas() {
        return bas;
    }

    public void setBas(int[][] bas) {
        this.bas = bas;
    }

    public int[][] getDroite() {
        return droite;
    }

    public void setDroite(int[][] droite) {
        this.droite = droite;
    }

    public int[][] getGauche() {
        return gauche;
    }

    public void setGauche(int[][] gauche) {
        this.gauche = gauche;
    }
}

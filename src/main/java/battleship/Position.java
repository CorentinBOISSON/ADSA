package battleship;

public class Position{

    private boolean presence_navire;


    private boolean navire_adversaire_touche;
    private boolean navire_adversaire_loupe;

    private boolean missile_adversaire_touche;
    private boolean missile_adversaire_loupe;

    public Position(boolean presence_navire, boolean navire_adversaire_touche, boolean navire_adversaire_loupe, boolean missile_adversaire_touche, boolean missile_adversaire_loupe) {
        this.presence_navire = presence_navire;
        this.navire_adversaire_touche = navire_adversaire_touche;
        this.navire_adversaire_loupe = navire_adversaire_loupe;
        this.missile_adversaire_touche = missile_adversaire_touche;
        this.missile_adversaire_loupe = missile_adversaire_loupe;
    }

    public boolean isPresence_navire() {
        return presence_navire;
    }

    public void setPresence_navire(boolean presence_navire) {
        this.presence_navire = presence_navire;
    }

    public boolean isNavire_adversaire_touche() {
        return navire_adversaire_touche;
    }

    public void setNavire_adversaire_touche(boolean navire_adversaire_touche) {
        this.navire_adversaire_touche = navire_adversaire_touche;
    }

    public boolean isNavire_adversaire_loupe() {
        return navire_adversaire_loupe;
    }

    public void setNavire_adversaire_loupe(boolean navire_adversaire_loupe) {
        this.navire_adversaire_loupe = navire_adversaire_loupe;
    }

    public boolean isMissile_adversaire_touche() {
        return missile_adversaire_touche;
    }

    public void setMissile_adversaire_touche(boolean missile_adversaire_touche) {
        this.missile_adversaire_touche = missile_adversaire_touche;
    }

    public boolean isMissile_adversaire_loupe() {
        return missile_adversaire_loupe;
    }

    public void setMissile_adversaire_loupe(boolean missile_adversaire_loupe) {
        this.missile_adversaire_loupe = missile_adversaire_loupe;
    }
}
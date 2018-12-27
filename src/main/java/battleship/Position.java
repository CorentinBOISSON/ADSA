package battleship;

public class Position{

    private boolean Presence_navire;

    private boolean Navire_adversaire_touche;
    private boolean Navire_adversaire_loupe;

    private boolean Missile_adversaire_touche;
    private boolean Missile_adversaire_loupe;

    public Position(boolean presence_navire, boolean navire_adversaire_touche, boolean navire_adversaire_loupe, boolean missile_adversaire_touche, boolean missile_adversaire_loupe) {
        Presence_navire = presence_navire;
        Navire_adversaire_touche = navire_adversaire_touche;
        Navire_adversaire_loupe = navire_adversaire_loupe;
        Missile_adversaire_touche = missile_adversaire_touche;
        Missile_adversaire_loupe = missile_adversaire_loupe;
    }

    public boolean isPresence_navire() {
        return Presence_navire;
    }

    public void setPresence_navire(boolean presence_navire) {
        Presence_navire = presence_navire;
    }

    public boolean isNavire_adversaire_touche() {
        return Navire_adversaire_touche;
    }

    public void setNavire_adversaire_touche(boolean navire_adversaire_touche) {
        Navire_adversaire_touche = navire_adversaire_touche;
    }

    public boolean isNavire_adversaire_loupe() {
        return Navire_adversaire_loupe;
    }

    public void setNavire_adversaire_loupe(boolean navire_adversaire_loupe) {
        Navire_adversaire_loupe = navire_adversaire_loupe;
    }

    public boolean isMissile_adversaire_touche() {
        return Missile_adversaire_touche;
    }

    public void setMissile_adversaire_touche(boolean missile_adversaire_touche) {
        Missile_adversaire_touche = missile_adversaire_touche;
    }

    public boolean isMissile_adversaire_loupe() {
        return Missile_adversaire_loupe;
    }

    public void setMissile_adversaire_loupe(boolean missile_adversaire_loupe) {
        Missile_adversaire_loupe = missile_adversaire_loupe;
    }
}
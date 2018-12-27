package battleship;

public class Position{

    private boolean Présence_navire;

    private boolean Navire_adversaire_touché;
    private boolean Navire_adversaire_loupé;

    private boolean Missile_adversaire_touché;
    private boolean Missile_adversaire_loupé;

    public Position(boolean présence_navire, boolean navire_adversaire_touché, boolean navire_adversaire_loupé, boolean missile_adversaire_touché, boolean missile_adversaire_loupé) {
        Présence_navire = présence_navire;
        Navire_adversaire_touché = navire_adversaire_touché;
        Navire_adversaire_loupé = navire_adversaire_loupé;
        Missile_adversaire_touché = missile_adversaire_touché;
        Missile_adversaire_loupé = missile_adversaire_loupé;
    }

    public boolean isPrésence_navire() {
        return Présence_navire;
    }

    public void setPrésence_navire(boolean présence_navire) {
        Présence_navire = présence_navire;
    }

    public boolean isNavire_adversaire_touché() {
        return Navire_adversaire_touché;
    }

    public void setNavire_adversaire_touché(boolean navire_adversaire_touché) {
        Navire_adversaire_touché = navire_adversaire_touché;
    }

    public boolean isNavire_adversaire_loupé() {
        return Navire_adversaire_loupé;
    }

    public void setNavire_adversaire_loupé(boolean navire_adversaire_loupé) {
        Navire_adversaire_loupé = navire_adversaire_loupé;
    }

    public boolean isMissile_adversaire_touché() {
        return Missile_adversaire_touché;
    }

    public void setMissile_adversaire_touché(boolean missile_adversaire_touché) {
        Missile_adversaire_touché = missile_adversaire_touché;
    }

    public boolean isMissile_adversaire_loupé() {
        return Missile_adversaire_loupé;
    }

    public void setMissile_adversaire_loupé(boolean missile_adversaire_loupé) {
        Missile_adversaire_loupé = missile_adversaire_loupé;
    }
}
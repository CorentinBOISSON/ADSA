package battleship;

import java.util.List;
import java.util.ArrayList;

public class Plateau {

    private List< ArrayList<Position> > Plateau;

    public Plateau(List<ArrayList<Position>> plateau) {
        Plateau = plateau;
    }

    public List<ArrayList<Position>> getPlateau() {
        return Plateau;
    }

    public void setPlateau(List<ArrayList<Position>> plateau) {
        Plateau = plateau;
    }


    }
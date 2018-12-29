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


    public void PlacementBateaux (int[][] grille, int ligne, int colonne, int longueur, String direction){
        //demande utilisateur de rentrer ligne, colonne(lettre), longueur du bateau, direction (H ou V), faut voir d'ou on recup tout ca
        // Question, on defini des types de bateaux avec des tailles ou pas ? mnt qu'on n,'a plus de classe...
        //dans tous les cas le programme sera le meme..
        //on part du principe que dans le programme qui demande a l'utilisateur de rentrer ligne, colonne et longueur, cela respecte taille du tableau

        for (int i=0; i<longueur/2; i++)
        {


            if (direction == "V")
            {
                for (int i=0; i<)
                {
                    grille[i][1]
                }
            }
        }


    }
}
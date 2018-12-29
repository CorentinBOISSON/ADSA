package battleship;

import java.util.List;
import java.util.Scanner;


public class Main {




    public static void main(String[] args) {


        System.out.println("****** Welcome to BattleShip Royale ****** \n Please enter your name :");
        Scanner s = new Scanner(System.in);
        String player = s.nextLine();

        //fonction creer plateau de jeu

        public int[][] CreerPlateau()
        {
            int grille [][] = new int[10][10];
            for (int i=0; i< grille.length; i++) {
                for (int j=0; j<grille[0].length; j++){
                    grille[i][j] = 0;
                }
            }
            return grille;
        }

        //fonction affichage de la grille si 0 rien (affichage 0), si 1 bateau (affichage *)
        //, si 2 dans l'eau (affichage o), si 3 touche (affichage x), si 4 coule (affichage X)


        public int[] coordonnees(char colonne, int ligne)
        {
            int Ligne=ligne-1;
            int Colonne=-1;
            int code = Character.getNumericValue(colonne);

            if (code >=65 && code <=75)
            {
            Colonne=code-65;
            }

            else
            {
                if (code >=97 && code <=107)
                {
                    Colonne=code-97;
                }
            }



            int Coordonnees[]  = {Colonne,Ligne};

            return(Coordonnees);

        }


        //fonction creation des bateaux

        public void PlacementBateaux (int [][] Coordonnees) {


        }





    }
}
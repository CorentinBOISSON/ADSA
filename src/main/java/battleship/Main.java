package battleship;

import java.util.List;


public class Main {

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



        int Coordonnees[]  = {Ligne,Colonne};

        return(Coordonnees);

    }


    public boolean placer_bateau (int[][]plateau, int taille, int[]coordonnees, boolean horizontal)
    {
        int hauteur = plateau.length;
        int largeur = plateau[0].length;
        boolean effectue =false;

        if (coordonnees[0]>=0 && coordonnees[0]<=hauteur && coordonnees[1]>=0 && coordonnees[1]<=largeur) {


            if (horizontal == true) {

                if (coordonnees[1]+taille <= largeur)
                {
                    boolean place =true;

                    for (int i =coordonnees[1];i<=coordonnees[1]+taille; i++ )
                    {
                        if (plateau[coordonnees[0]][i]==1)
                        {
                            place=false;
                        }
                    }

                    if (place==true)
                    {
                        for (int i =coordonnees[1];i<=coordonnees[1]+taille; i++ )
                        {
                            plateau[coordonnees[0]][i]=1;
                            effectue=true;
                        }

                    }

                }

            }

            else {

                if (coordonnees[0]+taille <= hauteur)
                {
                    boolean place =true;

                    for (int i =coordonnees[0];i<=coordonnees[0]+taille; i++ )
                    {
                        if (plateau[i][coordonnees[1]]==1)
                        {
                            place=false;
                        }
                    }

                    if (place==true)
                    {
                        for (int i =coordonnees[0];i<=coordonnees[0]+taille; i++ )
                        {
                            plateau[i][coordonnees[1]]=1;
                            effectue=true;
                        }

                    }

                }

            }

        }
        return(effectue);
    }

    public void Tir (int[][] grilleTirEffectueJ1, int[][] grilleBateauJ2, int[] coordonnes){
            //0 -> rien ; 1->bateau ; 2->tir dans l'eau ; 3->bateau touche
            if (grilleTirEffectueJ1[coordonnes[0]][coordonnes[1]] != 0) {
                System.out.println("Vous avez deja tire sur cette case. Veuillez renseigner une autre cible");
            }
            else{
                if (grilleBateauJ2[coordonnes[0]][coordonnes[1]] == 1) {
                    grilleBateauJ2[coordonnes[0]][coordonnes[1]] = 3; //bateau adverse touche
                    grilleTirEffectueJ1[coordonnes[0]][coordonnes[1]] = 3; //actualise grille de tir du joueur
                    System.out.println("Vous avez touche un bateau.");
                    //Appel fonction verifie si bateau coule
                }
                if (grilleBateauJ2[coordonnes[0]][coordonnes[1]] == 0){
                    grilleBateauJ2[coordonnes[0]][coordonnes[1]] = 2; //bateau adverse touche
                    grilleTirEffectueJ1[coordonnes[0]][coordonnes[1]] = 2; //actualise grille de tir du joueur
                    System.out.println("Vous avez tire dans l'eau.");
                }
            }
        }

        public void isSinked (int [][] grilleBateau, int [] coordonnee){



        }


    public static void main(String[] args) {

        System.out.print("Hello ");
        System.out.println("world");



    }
}
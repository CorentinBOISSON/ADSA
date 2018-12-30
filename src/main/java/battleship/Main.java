package battleship;

public class Main {

    public int[] coordonnees(char colonne, int ligne)
    {
        int Ligne=ligne-1;
        int Colonne=-1;
        int code = Character.getNumericValue(colonne);
        if (code >=65 && code <=75){
            Colonne=code-65;}
        else{
            if (code >=97 && code <=107){
                Colonne=code-97;}
            }

        return(new int[]{Ligne, Colonne});
    }


    public boolean placer_bateau (int[][]plateau, int taille, int[]coordonnees, boolean horizontal){
        int hauteur = plateau.length;
        int largeur = plateau[0].length;
        boolean effectue =false;
        boolean place =true;
        if (coordonnees[0]>=0 && coordonnees[0]<=hauteur && coordonnees[1]>=0 && coordonnees[1]<=largeur) {
            if (horizontal) {
                if (coordonnees[1]+taille <= largeur){

                    for (int i =coordonnees[1];i<=coordonnees[1]+taille; i++ ){
                        if (plateau[coordonnees[0]][i]==1){
                            place=false;}
                        }
                    }
                    if (place){
                        for (int i =coordonnees[1];i<=coordonnees[1]+taille; i++ ){
                            plateau[coordonnees[0]][i]=1;
                            effectue=true;
                        }
                    }
                }
            }
            else {
                if (coordonnees[0]+taille <= hauteur){

                    for (int i =coordonnees[0];i<=coordonnees[0]+taille; i++ ){
                        if (plateau[i][coordonnees[1]]==1){
                            place=false;
                        }
                    }
                    if (place){
                        for (int i =coordonnees[0];i<=coordonnees[0]+taille; i++ ){
                            plateau[i][coordonnees[1]]=1;
                            effectue=true;
                        }
                    }
                }
            }

        return(effectue);
    }

    public void TirJ1 (Position [][] plateau, Player J1, int[] coordonnees){
        //il va falloir faire 2 fonctions tir pour les deux joueurs..
        if (plateau [coordonnees[0]][coordonnees[1]].tire_joueur_1 == true) {
            System.out.println("Vous avez deja tire sur cette case. Veuillez renseigner une autre cible");
            //pas sur que cette ligne soit utile..
        }
        else{
            plateau [coordonnees[0]][coordonnees[1]].tire_joueur_1 = true; //verif
            plateau [coordonnees[0]][coordonnees[1]].bateau_joueur_2_touche = true; //verif
            System.out.println("Vous avez touche un bateau adverse");
            estCouleJ1(plateau, J1, coordonnees);
        }
    } //fonction tir ordi differentes dans modif booleens

    public void estCouleJ1 (Position [][] plateau, Player J1, int[] coordonnees){
        int id = plateau [coordonnees[0]][coordonnees[1]].getId_bateau_joueur_2();
        int cpt = 0;
        int[] stock= new int [20];
        int k = 0;
        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau[0].length; j++) {
                if (plateau[i][j].bateau_joueur_2_touche = false && plateau[coordonnees[0]][coordonnees[1]].getId_bateau_joueur_2() == id) {
                    cpt++;
                }
                else if (plateau[i][j].bateau_joueur_2_touche = true && plateau[coordonnees[0]][coordonnees[1]].getId_bateau_joueur_2() == id){
                    stock[k] = i;
                    stock [k+1] = j;
                    k++;
                }
            }
        }
        if (cpt != 0){
            for (int i = 0; i<k; i++){
                plateau[i][i+1].bateau_joueur_2_coule = true; //verif please
            }
            System.out.println("Vous avez coule le bateau adverse.");
        }
        else{
            System.out.println("Vous n'avez pas coule le bateau adverse.");
        }
    } //fonciton estCoule diff pour ordi dans la modif des booleens

    public boolean placer_bateau_J1 (Position[][]plateau, int taille, int[]coordonnees, boolean horizontal, int id){
        int hauteur = plateau.length;
        int largeur = plateau[0].length;
        boolean effectue =false;
        boolean place =true;
        if (coordonnees[0]>=0 && coordonnees[0]<=hauteur && coordonnees[1]>=0 && coordonnees[1]<=largeur) {
            if (horizontal) {
                if (coordonnees[1]+taille <= largeur){
                    for (int i =coordonnees[1];i<=coordonnees[1]+taille; i++ ){
                        if (plateau[coordonnees[0]][i].bateau_joueur_1 == true){
                            place=false;}
                    }
                }
                if (place){
                    for (int i =coordonnees[1];i<=coordonnees[1]+taille; i++ ){
                        plateau[coordonnees[0]][i].bateau_joueur_1 = true; //verif
                        plateau[coordonnees[0]][i].id_bateau_joueur_1 = id; //verif
                        effectue=true;
                    }
                }
            }
        }
        else {
            if (coordonnees[0]+taille <= hauteur){

                for (int i =coordonnees[0];i<=coordonnees[0]+taille; i++ ){
                    if (plateau[i][coordonnees[1]].bateau_joueur_1 == true){
                        place=false;
                    }
                }
                if (place){
                    for (int i =coordonnees[0];i<=coordonnees[0]+taille; i++ ){
                        plateau[i][coordonnees[1]].bateau_joueur_1 = true; //verif;
                        plateau[i][coordonnees[1]].id_bateau_joueur_1 = id; //verif
                        effectue=true;
                    }
                }
            }
        }
        return(effectue);
    }

    public void AfficherPlateauJ1 (Position[][] plateau){
        for (int i=0; i<plateau.length; i++){
            System.out.println();
            for (int j=0; j<plateau[0].length; j++){
                Position p = plateau[i][j];
                if(p.getId_bateau_joueur_1() == 0 && p.tire_joueur_2 == false){
                    System.out.print(0);
                }
                else if (p.getId_bateau_joueur_1() == 0 && p.tire_joueur_2 == true){
                    System.out.print('*');
                }
                else if (p.getId_bateau_joueur_1() != 0 && p.bateau_joueur_1_touche == false){
                    System.out.print(1);
                }
                else if (p.getId_bateau_joueur_1() != 0 && p.bateau_joueur_1_touche == true){
                    System.out.print('X');
                }
            }
        }
    } //a verifier que j'eusse fait tous les cas

    public void AfficherPlateauAttaqueJ1 (Position[][] plateau) {
        for (int i = 0; i < plateau.length; i++) {
            System.out.println();
            for (int j = 0; j < plateau[0].length; j++) {
                Position p = plateau[i][j];
                if (p.tire_joueur_1 == false) {
                    System.out.print(0);
                } else if (p.tire_joueur_1 == true && p.bateau_joueur_2 == false) {
                    System.out.print('*'); //tir dans l'eau
                } else if (p.bateau_joueur_2_touche == true) {
                    System.out.print('X');
                }
            }
        }
    } //a verifier que j'ai fait tous les cas

    public void Jeu(int hauteur, int largeur){


        Position[][] plateau = new Position[hauteur][largeur];



    }

    public static void main(String[] args) {

        System.out.print("Hello world");
        Plateau p = new Plateau(10,10);
        p.displayBoard();


    }
}
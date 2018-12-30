package battleship;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class Main {

    public static int[] coordonnees(char ligne,int colonne)
    {
        int Ligne=-1;
        int Colonne=colonne-1;
        int code = Character.getNumericValue(ligne);
        if (code >=65 && code <=75){
            Ligne=code-65;}
        else{
            if (code >=97 && code <=107){
                Ligne=code-97;}
        }

        return(new int[]{Ligne, Colonne});
    }


    public static void TirJ1 (Position [][] plateau, Player J1, int[] coordonnees){
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

    public static void estCouleJ1 (Position [][] plateau, Player J1, int[] coordonnees){
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

    public static boolean placer_bateau_J1 (Position[][]plateau, int taille, int[]coordonnees, boolean horizontal, int id){
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

    public static void AfficherPlateauJ1 (Position[][] plateau){
        for (int i=0; i<plateau.length; i++){
            System.out.println();
            for (int j=0; j<plateau[0].length; j++){
                if(plateau[i][j].id_bateau_joueur_1 == 0 && plateau[i][j].tire_joueur_2 == false){
                    System.out.print(0);
                }
                else if (plateau[i][j].getId_bateau_joueur_1() == 0 && plateau[i][j].tire_joueur_2 == true){
                    System.out.print('*');
                }
                else if (plateau[i][j].getId_bateau_joueur_1() != 0 && plateau[i][j].bateau_joueur_1_touche == false){
                    System.out.print(1);
                }
                else if (plateau[i][j].getId_bateau_joueur_1() != 0 && plateau[i][j].bateau_joueur_1_touche == true){
                    System.out.print('X');
                }
            }
        }
    } //a verifier que j'eusse fait tous les cas

    public static void AfficherPlateauAttaqueJ1 (Position[][] plateau) {
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

    public static Bateau placement(Position[][]plateau, int taille, int id,String name_joueur){

        String name1;
        int colonne;
        char ligne;
        char reponse;
        boolean horizontal = true;
        int [] coordonnees =new int[2];

        Scanner sc = new Scanner(System.in);
        boolean placement=false;

        while (placement==false){

            System.out.println("Veuillez saisir la ligne (lettre) de l'emplacement de votre bateau de taille "+ taille);
            String str = sc.nextLine();
            ligne = str.charAt(0);

            System.out.println("Veuillez saisir la colonne (chiffre) de l'emplacement de votre bateau de taille "+ taille);
            colonne = sc.nextInt();

            System.out.println("Voulez-vous placer votre bateau à l'horizontale (H) ou à la verticale (V) ?");
            String Str = sc.nextLine();
            reponse = Str.charAt(0);

            if (reponse=='V')
            {
                horizontal=false;
            }

            coordonnees=coordonnees(ligne, colonne);

            placement=placer_bateau_J1(plateau,taille,coordonnees,horizontal,id);

        }

        int[][]positions=new int[taille][2];
        if (horizontal==true){
            for (int i=0; i<taille;i++){
                positions[i][0]=coordonnees[0];
                positions[i][1]=coordonnees[1]+i;
            }
        }

        else{
            for (int i=0; i<taille;i++){
                positions[i][0]=coordonnees[0]+i;
                positions[i][1]=coordonnees[1];
            }

        }
        Bateau bateau = new Bateau(name_joueur,id,taille,positions,false);


        return(bateau);
    }


    public static void Jeu(int hauteur, int largeur){


        Position[][] plateau = new Position[hauteur][largeur];

        System.out.println("Veuillez saisir votre nom");
        Scanner sc = new Scanner(System.in);
        String name1 = sc.nextLine();

        List<Bateau> bateaux1 = new ArrayList<Bateau>();


        for (int i=2;i<=6;i++ ){
            AfficherPlateauJ1(plateau);
            bateaux1.add(placement(plateau,i,i+98,name1));

        }
        AfficherPlateauJ1(plateau);
        Player J1=new Player(name1,bateaux1,0,5);


    }

    public static void main(String[] args) {
        Jeu(10,10);
        // System.out.print("Hello world");
        // Plateau p = new Plateau(10,10);
        // p.displayBoard();


    }
}

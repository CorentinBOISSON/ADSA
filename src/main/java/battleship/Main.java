package battleship;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void TirJ1 (Position [][] plateau, Player J1) {
        //il va falloir faire 2 fonctions tir pour les deux joueurs..
        System.out.println("C'est a votre tour de tirer.");
        int[] coordonnees = EntrerCoordonnes();

        if (plateau[coordonnees[0]][coordonnees[1]].tire_joueur_1 == true) {
            System.out.println("Vous avez deja tire sur cette case. Veuillez renseigner une autre cible");
            System.out.println();
        }
        else {
            plateau[coordonnees[0]][coordonnees[1]].tire_joueur_1 = true; //verif
            if (plateau[coordonnees[0]][coordonnees[1]].bateau_joueur_2 == false) {
                System.out.println("Dans l'eau !");
                System.out.println();
            }
            else {
                System.out.println("Vous avez touche un bateau adverse !");
                plateau[coordonnees[0]][coordonnees[1]].bateau_joueur_2_touche = true;
                estCouleJ1(plateau, J1, coordonnees);
            }
        } //fonction tir ordi differentes dans modif booleens
    }

    public static void estCouleJ1 (Position [][] plateau, Player J1, int[] coordonnees){
        int id = plateau [coordonnees[0]][coordonnees[1]].id_bateau_joueur_2;
        int cpt = 0;
        int[] stock= new int [20];
        int k = 0;
        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau[0].length; j++) {
                if (plateau[i][j].bateau_joueur_2_touche == false && plateau[i][j].id_bateau_joueur_2 == id) {
                    cpt++;
                }
                else if (plateau[i][j].bateau_joueur_2_touche == true && plateau[i][j].id_bateau_joueur_2 == id){
                    stock[k] = i;
                    stock [k+1] = j;
                    k++;
                }
            }
        }
        if (cpt != 0){
            System.out.println("Vous n'avez pas coule le bateau adverse.");
            System.out.println();
        }
        else{
            for (int i = 0; i<k; i++){
                plateau[i][i+1].bateau_joueur_2_coule = true; //verif please
                //Rajouter actualisation class joueur nb de bato
            }
            System.out.println("Felicitation, vous avez coule le bateau adverse !");
            System.out.println();
        }
    } //fonciton estCoule diff pour ordi dans la modif des booleens

    public static boolean placer_bateau_Ordi (Position[][]plateau, int taille, int[]coordonnees, boolean horizontal, int id){
        int hauteur = plateau.length;
        int largeur = plateau[0].length;
        boolean effectue =false;
        boolean place =true;
        if (coordonnees[0]>=0 && coordonnees[0]<hauteur && coordonnees[1]>=0 && coordonnees[1]<largeur) {
            if (horizontal) {
                if (coordonnees[1]+taille <= largeur){
                    for (int i =coordonnees[1];i<coordonnees[1]+taille; i++ ){
                        if (plateau[coordonnees[0]][i].bateau_joueur_2){
                            place=false;
                        }
                    }
                    if (place){
                        for (int i =coordonnees[1];i<coordonnees[1]+taille; i++){
                            plateau[coordonnees[0]][i].bateau_joueur_2 = true;
                            plateau[coordonnees[0]][i].id_bateau_joueur_2 = id;
                            effectue=true;
                        }
                    }
                }
            }
            else {
                if (coordonnees[0]+taille <= hauteur){
                    for (int i =coordonnees[0];i<coordonnees[0]+taille; i++){
                        if ((plateau[i][coordonnees[1]]).bateau_joueur_2){
                            place=false;
                        }
                    }
                    if (place){
                        for (int i =coordonnees[0];i<coordonnees[0]+taille; i++ ){
                            plateau[i][coordonnees[1]].bateau_joueur_2 = true;
                            plateau[i][coordonnees[1]].id_bateau_joueur_2 = id;
                            effectue=true;
                        }
                    }
                }
            }
        }
        return(effectue);
    }

    public static boolean placer_bateau_J1 (Position[][]plateau, int taille, int[]coordonnees, boolean horizontal, int id){
        int hauteur = plateau.length;
        int largeur = plateau[0].length;
        boolean effectue =false;
        boolean place =true;
        if (coordonnees[0]>=0 && coordonnees[0]<hauteur && coordonnees[1]>=0 && coordonnees[1]<largeur) {
            if (horizontal) {//hjkhgfghjk
                if (coordonnees[1]+taille <= largeur){
                    for (int i =coordonnees[1];i<coordonnees[1]+taille; i++ ){
                        if (plateau[coordonnees[0]][i].bateau_joueur_1){
                            place=false;
                            System.out.print("Un bateau est deja place a cet endroit.");
                            System.out.println();
                            System.out.println();
                            //pas ici
                        }
                    }
                    if (place){
                        for (int i =coordonnees[1];i<coordonnees[1]+taille; i++ ){
                            plateau[coordonnees[0]][i].bateau_joueur_1 = true; //verif
                            plateau[coordonnees[0]][i].id_bateau_joueur_1 = id; //verif
                            effectue=true;
                        }
                    }
                }
                else {
                    System.out.print("Votre navire ne rentre pas dans le plateau.");
                    System.out.println();
                    System.out.println();
                }
            }
            else {
                if (coordonnees[0]+taille <= hauteur){
                    for (int i =coordonnees[0];i<coordonnees[0]+taille; i++ ){
                        if ((plateau[i][coordonnees[1]]).bateau_joueur_1){
                            place=false;
                            System.out.print("Un bateau est deja place a cet endroit.");
                            System.out.println();
                            System.out.println();
                        }
                    }
                    if (place){
                        for (int i =coordonnees[0];i<coordonnees[0]+taille; i++ ){
                            plateau[i][coordonnees[1]].bateau_joueur_1 = true; //verif;
                            plateau[i][coordonnees[1]].id_bateau_joueur_1 = id; //verif
                            effectue=true;
                        }
                    }
                }
                else {
                    System.out.print("Votre navire ne rentre pas dans le plateau.");
                    System.out.println();
                    System.out.println();
                }
            }
        }
        else{
            System.out.print("Oups, la ligne ou colonne que tu as saisi est invalide.");
            System.out.println();
            System.out.println();
        }

        return(effectue);
    }

    public static void AfficherPlateauJ1 (Position[][] plateau){
        System.out.print("  12345678910");
        for (int i=0; i<plateau.length; i++){
            String lettres [] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
            System.out.println();
            System.out.print(lettres[i] + " ");
            for (int j=0; j<plateau[0].length; j++){
                Position p = plateau[i][j];
                if(p.id_bateau_joueur_1 == 0 && p.tire_joueur_2 == false){
                    System.out.print(0);
                }
                else if (p.id_bateau_joueur_1 == 0 && p.tire_joueur_2 == true){
                    System.out.print('*');
                }
                else if (p.id_bateau_joueur_1 != 0 && p.bateau_joueur_1_touche == false){
                    System.out.print(1);
                }
                else if (p.id_bateau_joueur_1 != 0 && p.bateau_joueur_1_touche == true){
                    System.out.print('X');
                }
            }
        }
        System.out.println();
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
            System.out.println();
        }
    } //a verifier que j'ai fait tous les cas

    public static Bateau placement(Position[][]plateau, int taille, int id,String name_joueur){
        String name1;
        char reponse;
        boolean horizontal = true;
        int [] coordonnees =new int[2];
        boolean placement=false;
        while (placement==false){
            System.out.println("Placement du bateau de taille " + taille + " :");
            coordonnees = EntrerCoordonnes();
            ///
            System.out.println("Voulez-vous placer votre bateau à l'horizontale (H) ou à la verticale (V) ?");
            Scanner sc3 = new Scanner(System.in);
            String str2 = sc3.nextLine();
            reponse = str2.charAt(0);
            ///
            if (reponse=='V') {
                horizontal=false;
            }
            placement=placer_bateau_J1(plateau,taille,coordonnees,horizontal,id);
        }
        int[][]positions=new int[taille][2];
        positions = TestHorizontal(horizontal,coordonnees,taille);

        Bateau bateau = new Bateau(name_joueur,id,taille,positions,false);
        return(bateau);
    }

    public static int [][] TestHorizontal(boolean horizontal, int [] coordonnees, int taille) {
        int[][] positions = new int[taille][2];
        if (horizontal == true) {
            for (int i = 0; i < taille; i++) {
                positions[i][0] = coordonnees[0];
                positions[i][1] = coordonnees[1] + i;
            }
        } else {
            for (int i = 0; i < taille; i++) {
                positions[i][0] = coordonnees[0] + i;
                positions[i][1] = coordonnees[1];
            }
        }
        return positions;
    }

    public static Bateau placement2(Position[][]plateau, int taille, int id,String name_joueur){
        int [] coordonnees =new int[2];
        boolean placement=false;
        int ligne=0;
        int colonne=0;
        int test= (int)(Math.random());
        boolean  horizontal= test>=0.5;

        while (placement==false){

            if (horizontal){
                ligne = (int)(Math.random() * plateau.length);
                colonne = (int)(Math.random() * plateau[0].length-taille);
            }

            else{
                ligne = (int)(Math.random() * plateau.length-taille);
                colonne = (int)(Math.random() * plateau[0].length);
            }

            coordonnees[0]=ligne;
            coordonnees[1]=colonne;

            placement=placer_bateau_Ordi(plateau,taille,coordonnees,horizontal,id);
            test= (int)(Math.random());
            horizontal= test>=0.5;

        }
        int[][]positions=new int[taille][2];
        positions = TestHorizontal(horizontal,coordonnees,taille);

        Bateau bateau = new Bateau(name_joueur,id,taille,positions,false);
        return(bateau);
    }

    public static int[] EntrerCoordonnes() {
        int Ligne=-1;
        int[] coordonnees = new int[2];
        System.out.println("Veuillez saisir la ligne (lettre) :");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char ligne = str.charAt(0);

        Scanner sc2 = new Scanner(System.in);
        int number = readInt(sc2,"Veuillez saisir la colonne (chiffre) :", "Ceci n'est pas un nombre entier inférieur à 10. Recommencez : ");
        int Colonne = number -1;

        int code = Character.getNumericValue(ligne);
        if (code >=10 && code <=35){
            Ligne=code-10;}
        else{
            if (code >=97 && code <=107){
                Ligne=code-97;}
        }

        return(new int[]{Ligne, Colonne});
    }

    public static void Jeu(int hauteur, int largeur){
        Position[][] plateau = new Position[hauteur][largeur];
        for (int i=0;i<hauteur;i++) {
            for (int j=0;j<largeur;j++){
                plateau[i][j]=new Position(false,false,false,false,false,false,false,false,0,0);
            }
        }
        System.out.println("Veuillez saisir votre nom");
        Scanner sc = new Scanner(System.in);
        String name1 = sc.nextLine();
        List<Bateau> bateaux1 = new ArrayList<Bateau>();
        for (int i=2;i<=6;i++ ){
            AfficherPlateauJ1(plateau);
            System.out.println();
            bateaux1.add(placement(plateau,i,i+98,name1));
        }
        AfficherPlateauJ1(plateau);
        System.out.println();
        Player J1=new Player(name1,bateaux1,0,5);

        List<Bateau> bateaux2 = new ArrayList<Bateau>();
        for (int i=2;i<=6;i++ ){
            bateaux2.add(placement2(plateau,i,i+198,name1));
        }
        Player J2=new Player("Ordinateur",bateaux2,0,5);


        //test fonction tirer
        plateau[0][0].bateau_joueur_2 = true;
        plateau[0][0].id_bateau_joueur_2 = 500;

        plateau[0][1].bateau_joueur_2 = true;
        plateau[0][1].id_bateau_joueur_2 = 500;
        //test fonction tirer

        TirJ1(plateau, J1);
        TirJ1(plateau, J1);
        TirJ1(plateau, J1);

        //fonction estCoulee penser a modif attribut nbBato et List<Bato> du joueur
    }

    public static int readInt(Scanner scanner, String prompt, String promptOnError) {

        System.out.println(prompt);
        //!scanner.hasNextInt()
        while ( !scanner.hasNextInt()) {
            System.out.print(promptOnError);
            scanner.nextLine(); // vidage saisie incorrect
        }

        final int input = scanner.nextInt();
        //scanner.nextLine(); // vidage buffer
        return input;
    }

    public static void main(String[] args) {
        Jeu(10,10);
    }
}


package battleship;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static boolean TirJ1 (Position [][] plateau, Player J1) {
        //il va falloir faire 2 fonctions tir pour les deux joueurs..
        boolean touche =false;
        System.out.println("C'est à votre tour de tirer.");
        int[] coordonnees = EntrerCoordonnes();

        if (plateau[coordonnees[0]][coordonnees[1]].tire_joueur_1) {
            System.out.println("Vous avez déjà tiré sur cette case. Veuillez renseigner une autre cible");
            System.out.println();
        }
        else {
            plateau[coordonnees[0]][coordonnees[1]].tire_joueur_1 = true; //verif
            if (!plateau[coordonnees[0]][coordonnees[1]].bateau_joueur_2) {
                System.out.println("Dans l'eau !");
                System.out.println();
            }
            else {
                System.out.println("Vous avez touche un bateau adverse !");
                plateau[coordonnees[0]][coordonnees[1]].bateau_joueur_2_touche = true;
                estCouleJ1(plateau, J1, coordonnees);
                touche=true;
            }
        } //fonction tir ordi differentes dans modif booleens

        return (touche);
    }

    private static void estCouleJ1(Position[][] plateau, Player J1, int[] coordonnees){
        int id = plateau [coordonnees[0]][coordonnees[1]].id_bateau_joueur_2;
        int cpt = 0;
        int[] stock = new int [20];
        int k = 0;
        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau[0].length; j++) {
                if (!plateau[i][j].bateau_joueur_2_touche && plateau[i][j].id_bateau_joueur_2 == id) {
                    cpt++;
                }
                else if (plateau[i][j].bateau_joueur_2_touche && plateau[i][j].id_bateau_joueur_2 == id){
                    stock[k] = i;
                    stock [k+1] = j;
                    k=k+2;
                }
            }
        }
        if (cpt != 0){
            System.out.println("Vous n'avez pas coule le bateau adverse.");
            System.out.println();
        }
        else{
            for (int i = 0; i<=k; i=i+2){
                plateau[stock[i]][stock[i+1]].bateau_joueur_2_coule = true;
                //Rajouter actualisation class joueur nb de bato
            }
            System.out.println("Felicitation, vous avez coule le bateau adverse !");
            System.out.println();
        }
    } //actualise plateau et informe joueur
    //fonciton estCoule diff pour ordi dans la modif des booleens

    private static boolean placer_bateau_Ordi(Position[][] plateau, int taille, int[] coordonnees, boolean horizontal, int id){
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

    private static boolean placer_bateau_J1(Position[][] plateau, int taille, int[] coordonnees, boolean horizontal, int id){
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

    private static void AfficherPlateauJ1 (Position[][] plateau){
        String blanc = "                                           ";
        System.out.println(blanc + "Plateau de placement du joueur");
        System.out.print(blanc + "  |1|2|3|4|5|6|7|8|9|10|");
        for (int i=0; i<plateau.length; i++){
            System.out.println();
            String lettres [] = {blanc + "|A|", blanc + "|B|", blanc + "|C|", blanc + "|D|", blanc + "|E|", blanc + "|F|", blanc + "|G|", blanc + "|H|", blanc + "|I|", blanc + "|J|"};
            System.out.print(lettres[i]);
            for (int j=0; j<plateau[0].length; j++){
                Position p = plateau[i][j];
                if(p.id_bateau_joueur_1 == 0 && !p.tire_joueur_2){
                    System.out.print(" |");
                }
                else if (p.id_bateau_joueur_1 == 0 && p.tire_joueur_2){
                    System.out.print("*|");
                }
                else if (p.id_bateau_joueur_1 != 0 && !p.bateau_joueur_1_touche){
                    System.out.print(0 +"|");
                }
                else if (p.id_bateau_joueur_1 != 0 && p.bateau_joueur_1_touche){
                    System.out.print("X|");
                }
            }
        }
        System.out.println();
        System.out.print("Legende : | | = eau ; |*| = tir du joueur adverse ; |0| = presence bateau non touche ; |X| = notre position est touchee");
        System.out.println();
    }

    private static void AfficherPlateauOrdi (Position[][] plateau){
        String blanc = "                                           ";
        System.out.print(blanc + "  |1|2|3|4|5|6|7|8|9|10|");
        for (int i=0; i<plateau.length; i++){
            System.out.println();
            String lettres [] = {blanc + "|A|", blanc + "|B|", blanc + "|C|", blanc + "|D|", blanc + "|E|", blanc + "|F|", blanc + "|G|", blanc + "|H|", blanc + "|I|", blanc + "|J|"};
            System.out.print(lettres[i]);
            for (int j=0; j<plateau[0].length; j++){
                Position p = plateau[i][j];
                if(p.id_bateau_joueur_2 == 0 && !p.tire_joueur_1){
                    System.out.print(" |");
                }
                else if (p.id_bateau_joueur_2 == 0 && p.tire_joueur_1){
                    System.out.print("*|");
                }
                else if (p.id_bateau_joueur_2 != 0 && !p.bateau_joueur_2_touche){
                    System.out.print(0 +"|");
                }
                else if (p.id_bateau_joueur_2 != 0 && p.bateau_joueur_2_touche){
                    System.out.print("X|");
                }
            }
        }
        System.out.println();
        System.out.print("Legende : | | = eau ; |*| = tir du joueur adverse ; |0| = presence bateau non touche ; |X| = notre position est touchee");
        System.out.println();
    }

    public static void AfficherPlateauAttaqueJ1 (Position[][] plateau) {
        String blanc = "                                           ";
        System.out.print(blanc + "Plateau d'attaque du joueur ");
        System.out.print(blanc + "  |1|2|3|4|5|6|7|8|9|10|");
        for (int i = 0; i < plateau.length; i++) {
            System.out.println();
            String lettres [] = {blanc + "|A|", blanc + "|B|", blanc + "|C|", blanc + "|D|", blanc + "|E|", blanc + "|F|", blanc + "|G|", blanc + "|H|", blanc + "|I|", blanc + "|J|"};
            System.out.print(lettres[i]);
            for (int j = 0; j < plateau[0].length; j++) {
                Position p = plateau[i][j];
                if (!p.tire_joueur_1) {
                    System.out.print(" |");
                } else if (p.tire_joueur_1 && !p.bateau_joueur_2) {
                    System.out.print("*|"); //tir dans l'eau
                } else if (p.bateau_joueur_2_touche && !p.bateau_joueur_2_coule) { //si touche pas forcement coule
                    System.out.print("+|");
                } else if (p.bateau_joueur_2_coule) { //si coule forcement...
                    System.out.print("X|");
                }
            }
        }
        System.out.println();
        System.out.print("Legende : | | = eau ; |*| = tir dans l'eau ; |+| = tir sur bateau adverse ; |X| = bateau adverse coule");
        System.out.println();
    }

    private static Bateau placement(Position[][] plateau, int taille, int id, String name_joueur){
        String name1;
        char reponse;
        boolean horizontal = true;
        int [] coordonnees =new int[2];
        boolean placement=false;
        while (!placement){
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

        return(new Bateau(name_joueur,id,taille,positions,false));
    }

    private static int [][] TestHorizontal(boolean horizontal, int[] coordonnees, int taille) {
        int[][] positions = new int[taille][2];
        if (horizontal) {
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

    private static Bateau placement2(Position[][] plateau, int taille, int id, String name_joueur){
        int [] coordonnees =new int[2];
        boolean placement=false;
        int ligne;
        int colonne;

        int test= (int)(Math.random()*100);
        boolean  horizontal= test>=50;

        while (!placement){

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
            test= (int)(Math.random()*100);
            horizontal= test>=50;

        }
        int[][]positions=new int[taille][2];
        positions = TestHorizontal(horizontal,coordonnees,taille);

        return(new Bateau(name_joueur,id,taille,positions,false));
    }

    private static int[] EntrerCoordonnes() {

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

    private static void Jeu(int hauteur, int largeur){
        Position[][] plateau = new Position[hauteur][largeur];
        boolean vainqueur=false;
        for (int i=0;i<hauteur;i++) {
            for (int j=0;j<largeur;j++){
                plateau[i][j]=new Position(false,false,false,false,false,false,false,false,0,0);
            }
        }
        System.out.println("Veuillez saisir votre nom :");
        Scanner sc = new Scanner(System.in);
        String name1 = sc.nextLine();
        List<Bateau> bateaux1 = new ArrayList<Bateau>();
        for (int i=2;i<=2;i++ ){
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

        boolean tour1;
        boolean tour2;

       while (J1.nbShip!=0 || J2.nbShip!=0) {

           tour1=true;

           while (tour1){
               AfficherPlateauAttaqueJ1(plateau);
               tour1=TirJ1(plateau, J1);
           }

           tour2=true;

           while (tour2){
               tour2=TirJ1(plateau, J2);
           }

           AfficherPlateauJ1(plateau);
       }

       if (J1.nbShip!=0)
       {
           System.out.println("L'ordinateur a gagné, retenter votre chance !");
       }

       else{
           System.out.println("Bravo ! Vous avez gagné :D ");
       }

    }

    private static int readInt(Scanner scanner, String prompt, String promptOnError) {

        System.out.println(prompt);
        //!scanner.hasNextInt()
        while ( !scanner.hasNextInt()) {
            System.out.print(promptOnError);
            scanner.nextLine(); // vidage saisie incorrect
        }
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        Jeu(10,10);



    }
}


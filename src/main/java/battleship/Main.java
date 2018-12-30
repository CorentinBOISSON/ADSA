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



    public void Jeu(int hauteur, int largeur){


        Position[][] plateau = new Position[hauteur][largeur];



    }

    public static void main(String[] args) {

        System.out.print("Hello world");
        Plateau p = new Plateau(10,10);
        p.displayBoard();


    }
}
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



        int Coordonnees[]  = {Colonne,Ligne};

        return(Coordonnees);

    }


    public static void main(String[] args) {

        System.out.print("Hello ");
        System.out.println("world");



    }
}
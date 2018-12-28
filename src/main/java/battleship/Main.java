package battleship;

import java.util.List;


public class Main {

    public int[] coordonnees(char colonne, int ligne, int altitude)
    {
        int Ligne=ligne-1;
        int Colonne=-1;
        int code = Character.getNumericValue(colonne);

        if (code >=65 && code <=90)
        {
        Colonne=code-65;
        }

        else
        {
            if (code >=97 && code <=122)
            {
                Colonne=code-97;
            }
        }

        int Altitude = altitude + 4;

        int Coordonnees[]  = {Colonne,Ligne,Altitude};

        return(Coordonnees);

    }


    public static void main(String[] args) {


    }
}
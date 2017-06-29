package test.java;

/**
 * 	Fonctions auxiliaires
 *  @author Cannelle Rb
 */
public class Utils {
    /**
     * Calcule le nombre de caisses réalisées (utilisé pour l'affichage des résultats)
     *
     * @param sorted	le résultat du tri des caisses
     * @return		    le nombre de caisses résultant de ce tri
     */
    public static int getNombreCaisses(StringBuilder sorted) {
        int nb = 1;
        for (int i = 0; i<sorted.length(); i++) {
            if (sorted.charAt(i) ==  '/')
                nb++;
        }
        return nb;
    }
}

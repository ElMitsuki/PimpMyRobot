package model;

import java.util.Comparator;

/**
 * Cette classe implémente la classe Comparator<Regle> et elle permet notamment de trier une Collection d'objet Regle
 * (List, Array...) par odre croissant du poids d'un objet Regle grâce à la méthode compare redéfinit.
 */
public class ComparatorRegles implements Comparator<Regle>{
    /**
     * Compare le poids de la règle 1 avec le poids de la règle 2.
     * @param r1 première règle
     * @param r2 deuxième règle
     * @return un nombre inférieur à 0 si le poids de r1 est inférieur au poids de r2, égal à 0 si le poids de r1 est égal au poids de r2, supérieur à 0 si le poids de r1 est supérieur au poids de r2
     */
    public int compare(Regle r1, Regle r2) {
        return r1.getPoids().compareTo(r2.getPoids());
    }
}

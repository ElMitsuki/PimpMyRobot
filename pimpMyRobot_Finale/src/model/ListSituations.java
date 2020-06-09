package model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Classe représentant une liste de situations, pour cela, elle hérite de la classe ArrayList.
 */
public class ListSituations extends ArrayList<Situation> {

    public ListSituations() {
        super();
    }
    /**
     * Permet de supprimer tous les éléments de la liste de règle.
     */
    public void removeAll(){
        for(int i=0; i<this.size(); i++){
            this.remove(i);
        }
    }
}

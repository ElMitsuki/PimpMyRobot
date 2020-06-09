package model;

import java.util.ArrayList;

/**
 * Classe représentant une liste d'issues, pour cela, elle hérite de la classe ArrayList.
 */
public class ListIssues extends ArrayList<Issue>{
    
    public ListIssues() {
        super();
    }
    public void removeAll(){
        for(int i=0; i<this.size(); i++){
            this.remove(i);
        }
    }
}

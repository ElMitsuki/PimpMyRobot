package model;

import java.util.ArrayList;
import java.util.Collection;
import java.math.*;

import java.util.Collections;
import java.util.Comparator;

public class Situation {
    /**
     * L'identifiant de la situation
     * @see Integer
     * @see Situation#getID()
     * @see Situation#setID(Integer)
     */
    private Integer _ID;
    /**
     * Le titre d'une situation
     * @see String
     * @see Situation#getTitre()
     */
    private String _titre;
    /**
     * Le descriptif de la situation, l'explication de la situation
     * @see String
     * @see Situation#getDescriptif()
     */
    private String _descriptif;
    /**
     * La liste des issues que la situation va avoir, elle sont limitée aux nombres de 3 pour une situation
     * @see ListIssues
     * @see Situation#getListIssues()
     */
    private ListIssues _issue;
    /**
     * L'image qui va apparaitre pour illustrer la situation
     * @see String
     * @see Situation#getImage()
     */
    private String _image;

        /**
     *Constructeur de la situation, prends tout les éléments nécésssaire et crée une nouvelle instance
     * @param ID L'identifiant de la situation
     * @param title Le titre de la situation
     * @param desc La description de la situation
     * @param img L'image de la situation
     * @param li La liste d'issues de la situation
     * @see Integer
     * @see String
     * @see ListIssues
     */
    public Situation(Integer ID, String title, String desc, String img, ListIssues li){
        this._descriptif =desc;
        this._ID = ID;
        this._titre = title;
        this._issue = li;
        this._image = img;
    }

    public String getImage() {
        return _image;
    }

    /**
     * Retourne l'identifiant de la situation
     * @return L'identifiant
     * @see Integer
     */
    public Integer getID(){
        return this._ID;
    }
    /**
     * Retourne la liste d'issues de la situation
     * @return La liste d'issues
     */
    public ListIssues getListIssues() {
        return this._issue;
    }
    /**
     * Retourne le descriptif de la situation
     * @return Le descriptif
     */
    public String getDescriptif() {
        return _descriptif;
    }
    /**
     * Permet de rajouter une contrainte à l'ajout d'une issue, pour la limiter à 3
     * @param i L'issue a rajouter
     */
    public void addIssue(Issue i){
        if(getListIssues().size()<3){
            getListIssues().add(i);
        }
        else {
            throw new IllegalArgumentException("Vous avez deja 3 issues");
        }
    }
    /**
     * retourne le titre de la situation
     * @return _titre titre de la situation
     */
    public String getTitre() {
        return _titre;
    }

    /**
     * Trier les issues et prends celles avec le poids le plus élevé et la retourne en sortie
     * @return L'issue choisi
     * @see Issue
     * @see Situation#getListIssues()
     */
    public Issue getIssueChoisiPoids(){                       ;
        Issue i = null;
        if (getListIssues().get(0).getPoids()>getListIssues().get(1).getPoids()){
            i = getListIssues().get(0);
        }
        else if(getListIssues().get(0).getPoids()<getListIssues().get(1).getPoids()) {
            i = getListIssues().get(1);
        }
        else{
            i = getListIssues().get(2);
        }
        return i;

    }
}

package model;

import java.util.ArrayList;
import java.util.Collection;

public class Robot {
    
    /**
     * Nom du robot
     * @see String
     * @see Robot#getNom()
     * @see Robot#setNom(String)
     */
    private String _nom;
    /**
     * La liste des règles que le robot se doit de suivre
     * @see ListRegles
     * @see Robot#getListRegles()
     * @see Robot#setRegles(ListRegles)
     */
    private ListRegles _regles = new ListRegles();

    /**
     * Constructeur du robot prenant son nom et sa liste de règles pour faire une nouvelle instance
     * @param nom Le nom
     * @param lr La liste de règles
     */
    public Robot(String nom, ListRegles lr){
        this._nom = nom;
        this._regles = lr;
    }
    /**
     * 
     */
    public Robot(){
        
    }
    /**
     * Retourne le nom du robot
     * @see String
     * @return Le nom du robot
     */
    public String getNom() {
        return _nom;
    }
    /**
     * Remplace le nom du robot par celui donnée en paramêtre
     * @param _nom Le nouveau nom
     * @see String
     */
    public void setNom(String _nom) {
        this._nom = _nom;
    }
    /**
     * Retourne la liste des règles du robot
     * @return La liste des règles
     */
    public ListRegles getListRegles() {
        return _regles;
    }
    /**
     * Remplace la liste des règles par une nouvelle
     * @param _regles La nouvelle liste de règles
     */
    public void setRegles(ListRegles _regles) {
        this._regles = _regles;
    }
    /**
     * Résout une situation en parcourant les règles du robot en les comparants à celles des issues de la situations
     * @param s La situation observee
     * @see Situation
     * @see Issue
     * @see Regle
     */
    public void resoudrePoids(Situation s) {
        for(Issue i : s.getListIssues()) {
            for(Regle r : i.getListRegles()) {
                if(this.getListRegles().contains(r)) {
                    i.setPoids(r.getPoids());
                }
            }
        }
    }

    
}

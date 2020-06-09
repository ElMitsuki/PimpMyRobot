package model;

import java.util.ArrayList;

/**
 * La classe Regle fait office de filtre, elle permet de restraindre le robot dans la réalisation des actions entreprises
 *
 */
public class Regle {

    /**
     * L'intitule de la règle
     * @see String
     * @see Regle#getIntitule()
     * @see Regle#setIntitule(String)
     */
    private String _intitule;
    /**
     * La liste des issues que qui entre en contradiction avec la règle
     * @see ListIssues
     * @see Regle#getListIssues()
     * @see Regle#setListIssues(ListIssues)
     */
    private ListIssues _idIssues = new ListIssues();
    /**
     * L'identifiant de la règle
     * @see Integer
     * @see Regle#getID()
     */
    private Integer _ID;
    /**
     * Le poids de la règle
     * @see Integer
     * @see Regles#getID()
     * @see Regles#setID(Integer)
     */
    private Integer _poids;


    /**
     * Constructeur de la classe
     * @param intitule l'intitule de la règle
     * @param id L'identifiant de la règle
     * @see (String, Integer)
     */
    public Regle(String intitule,Integer id){
            this._intitule = intitule;
            this._ID = id;
        }
    /**
     * Retourne l'ID de la règle
     * @return L'ID de la règle
     */
    public Integer getID() {
        return _ID;
    }

    /**Recupere le poids actuel de la règle
     * @return Le poids de la règle
     * @see Integer
     */
    public Integer getPoids() {
        return _poids;
    }
    /**
     * Définit le nouveau poids de la règle
     * @param poids Le nouveau poids
     * @see Integer
     */
    public void setPoids(Integer poids) {
        this._poids = poids;
    }

    /**Récupere l'intitule de la règle actuelle
     * @return L'intitule de la règle
     * @see String
     */
    public String getIntitule() {
        return _intitule;
    }
    /**
     * Définit la nouvelle liste d'issue pour la règle
     * @param idIssues La nouvelle liste
     * @see ListIssues
     */
    public void setIdIssues(ListIssues idIssues) {
        this._idIssues = idIssues;
    }
    /**
     * Obtient la liste des issues de la règle
     * @return La liste des issues
     */
    public ListIssues getIdIssues() {
        return _idIssues;
    }
}

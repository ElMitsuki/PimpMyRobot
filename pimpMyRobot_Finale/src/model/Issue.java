package model;

public class Issue {
    /**
     * Le nom de l'issue
     * @see String
     * @see Issue#getNom()
     */
    private String _nom;

    /**
     * L'identifiant de l'issue
     * @see Integer
     * @see Issue#getID()
     */
    private Integer _ID;

    /**
     * Liste des règles en contradiction avec l'issue
     * @see ListRegles
     * @see Issue#getListRegles
     * @see Issue#setListRegles(ListRegles)
     */
    private ListRegles _reglesIssue = new ListRegles();

    /**
     * Le poids d'une issue initialement à 100
     * @see Integer
     * @see Issue#getPoids()
     * @see Issue#setPods(Integer)
     */
    private Integer _poids = 100;

    /**
     * Constructeur de la classe Issue
     * @param nomLe nom de l'issue
     * @param ID L'identifiant de l'issue
     * @param lr La liste de regle de l'issue
     * @see String
     * @see Integer
     * @see ListRegles
     */
    public Issue(String nom,Integer ID, ListRegles lr){
        this._nom = nom;
        this._ID = ID;
        this._reglesIssue = lr;
    }
    /**
     * Retourne l'identifiant de l'issue
     * @return L'identifiant de l'issue
     * @see Integer
     */
    public Integer getID() {
        return _ID;
    }
    /**
     *Retourne le nom de l'issue
     * @return Le nom de l'issue
     */
    public String getNom() {
        return _nom;
    }
    /**
     * Retourne la liste des règles de l'issue
     * @return La liste des règles de l'issue
     */
    public ListRegles getListRegles() {
        return _reglesIssue;
    }
    /**
     * Remplace la liste des règles courante de l'issue par celle donnée en paramètre
     * @param lr La liste des règles
     * @see ListRegles
     */
    public void setListRegles(ListRegles lr){
        this._reglesIssue = lr;
    }
    /**
     * Retourne le poids de la règle
     * @return Le poids de la règle
     */
    public Integer getPoids() {
        return _poids;
    }
    /**
     * Definit le nouveau poids de l'issue par celui donnée en paramètre
     * @param p Le nouveau poids
     * @see Integer
     */
    public void setPoids(Integer p){
        if (p<=getPoids()){
            this._poids = p;
        }
    }

}

package controler;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;

import java.io.IOException;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import java.nio.file.Path;

import java.nio.file.Paths;

import java.util.ArrayList;

import model.ListIssues;
import model.Robot;

import model.*;
import org.json.simple.*;
import org.json.simple.parser.*;

import view.FenetreAppelante;

/**
 * Classe qui représente une partie.
 */
public class Game {
    /**
     * Le robot du jeu.
     * @attribute _robot
     */
    private Robot _robot;

    /**
     * Liste des situations choisies aléatoirement parmi la liste de toutes les situations (_touteSituations) en fonction
     * du nombre de situations choisies par le joueur.
     * @attribute _situationsChoisies
     * @see Game#randomSituation(Integer)
     */
    private ListSituations _situationsChoisies;

    /**
     * Liste de toute les situations du jeu, remplie par la méthode init de Game.
     * @attribute _toutesSituations
     * @see Game#init()
     */
    private ListSituations _toutesSituations;

    /**
     * Liste de toute les issues du jeu, rempli par la méthode init de Game.
     * @attribute _toutesIssues
     * @see Game#init()
     */
    private ListIssues _toutesIssues;

    /**
     * Le nombre de situations choisies par le joueur.
     * @attribute _nbSituations
     */
    private Integer _nbSituations;

    /**
     * Un compteur qui permet de savoir à quelle situation on est; ce compteur correspond à la position dans la liste
     * de _situationsChoisies mais aussi au nombre de situations déjà effectuées à l'instant t.
     * @attribute _compteur
     */
    private Integer _compteur = 0;

    /**
     * Correspond au poids d'une règle; est utilisé uniquement pour attribuer un poids par défaut au début du jeu, lorsque le
     * joueur choisit ses règles mais cet attribut n'est pas utilisé lors de la hierarchisation des règles.
     * @attribute _poidsRegle
     */
    private Integer _poidsRegle = 0;

    /**
     * Score du joueur.
     * @attribute _score
     */
    private int _score = 0;

    /**
     * Liste des issues choisies par le joueur. Utile lors du récapitulatif dans le bilan.
     * @attribute _issuesJoueurs
     */
    private ListIssues _issuesJoueurs;

    /**
     * Liste des issues choisies par le robot. Utile lors du récapitulatif dans le bilan.
     * @attribute _issuesRobot
     */
    private ListIssues _issuesRobot;

    /**
     * Liste de toutes les règles du jeu, rempli par la méthode init de Game.
     * @attribute _toutesRegles
     */
    private ListRegles _toutesRegles;

    /**
     * Constructeur de la classe Game.
     */
    public Game() {
        this._situationsChoisies = new ListSituations();
        this._toutesSituations = new ListSituations();
        this._toutesRegles = new ListRegles();
        this._robot = new Robot();
        this._toutesIssues = new ListIssues();
        this._issuesJoueurs = new ListIssues();
        this._issuesRobot = new ListIssues();

    }
    /**
     *
     * @return
     */
    public ListSituations getToutesSituations() {
        return _toutesSituations;
    }

    /**
     * Affecte à la règle passé en paramètre la valeur de _poidsRegle, incrémente _poidsRegle de 1 et ajoute cette règle
     * à la liste des règles du robot.
     * @param regle règle à ajouter au robot
     */
    public void addRegleRobot(Regle regle) {
            regle.setPoids(this._poidsRegle);
            this._poidsRegle++;
            this._robot.getListRegles().add(regle);

    }

    /**
     * Résout la situation à la position _compteur dans la liste des situations choisies (_situationsChoisies); pour cela,
     * on récupère la situation à la position _compteur puis on affecte les bons poids aux issues de la situation grâce à la
     * méthode resoudrePoids de Robot; a la fin, on retourne l'issue choisit par le robot grâce à la méthode getIssueChoisiPoids
     * de Situations.
     * @return l'issue choisit par le robot
     * @see Robot#resoudrePoids(Situations)
     * @see Situations#getIssueChoisiPoids()
     */
    public Issue nextSituation() {
        Issue i = null;
        Situation s = this._situationsChoisies.get(_compteur);
        this._robot.resoudrePoids(s);
        i = s.getIssueChoisiPoids();
        return i;
    }

    public void setScore(int _score) {
        this._score = _score;
    }

    /**
     * Compare l'issue choisie par le jouer et l'issue choisie par le robot pour une situation et augmente le score de 1 point
     * si les deux issues sont égales.
     * @param ij issue choisie par le joueur
     * @param ir issue choisie par le robot
     */
    public void issueChoisi(Issue ij, Issue ir) {
        if(ij.getNom() == ir.getNom()) {
            this._score++;
        }
    }

    /**
     * Ajoute un nom au robot, celui rentré par le joueur.
     * @param nom nom du robot
     */
    public void addNom(String nom) {
        this._robot.setNom(nom);
    }

    /**
     * Affecte à _nbSituations le nombre de situations choisie par le joueur.
     * @param nombre nombre rentré par le joueur
     */
    public void choixNbSituations(Integer nombre) {
        this._nbSituations = nombre;
    }

    /**
     * Choisit aléatoirement des situations parmi la liste contenant toutes les situations (_toutesSituations)
     * Le nombre de situations choisies correspond aux nombre de situations choisie par le joueur.
     * @param nbSituations nombre de situations choisie par le joueur
     */
    public void randomSituation(Integer nbSituations) {
        ListSituations touteSitu = new ListSituations();
        for(Situation s : _toutesSituations) {
            touteSitu.add(s);
        }
        int i = 0;
        while(i < nbSituations) {
            int n = (int)(Math.random() * touteSitu.size());
            Situation s = touteSitu.get(n);
            this._situationsChoisies.add(s);
            touteSitu.remove(s);
            i++;
        }
    }

    /**
     * Retourne la règle correspondant à l'intitulé passé en paramètre parmi la liste contenant toutes les règles.
     * @param regle l'intitulé de la règle
     * @return la règle correspondant à l'intitulé passé en paramètre
     */
    public Regle getRegles(String regle) {
        Regle r = null;
        for(Regle r1 : this._toutesRegles) {
            if(r1.getIntitule().equals(regle)) {
                r = r1;
            }
        }
        return r;
    }

    /**
     * Retourne la règle correspondant à l'intitulé passé en paramètre parmi la liste des règles du robot.
     * @param regle l'intitulé de la règle
     * @return la règle correspondant à l'intitulé passé en paramètre
     */
    public Regle getReglesRobot(String regle) {
        Regle r = null;
        for(Regle r1 : this.getRobot().getListRegles()) {
            if(r1.getIntitule().equals(regle)) {
                r = r1;
            }
        }
        return r;
    }


    /**
     * Retourne le robot du jeu.
     * @return le robot du jeu
     */
    public Robot getRobot() {
        return _robot;
    }

    /**
     * Retourne la liste contenant toutes les règles du jeu.
     * @return la liste contenant toutes les règles du jeu
     */
    public ListRegles getTouteRegles() {
        return _toutesRegles;
    }

    /**
     * Retourne le score du joueur.
     * @return le score du joueur
     */
    public int getScore() {
        return _score;
    }

    /**
     * Retourne la liste contenant toutes les issues choisies par le joueur.
     * @return la liste contenant toutes les issues choisies par le joueur
     */
    public ListIssues getIssuesJoueurs() {
        return _issuesJoueurs;
    }

    /**
     * Retourne la liste contenant toutes les issues choisies par le robot.
     * @return la liste contenant toutes les issues choisies par le robot
     */
    public ListIssues getIssuesRobot() {
        return _issuesRobot;
    }

    /**
     * Retourne le nombre de situations choisies par le joueur.
     * @return le nombre de situations choisies par le joueur
     */
    public Integer getNbSituations() {
        return _nbSituations;
    }

    /**
     * Retourne la liste contenant toutes les situations choisies aléatoirement par la méthode randomSituation de la classe Game.
     * @return la liste contenant toutes les situations choisies aléatoirement
     */
    public ListSituations getSituationsChoisies() {
        return _situationsChoisies;
    }

    /**
     * Retourne le compteur du jeu.
     * @return le compteur du jeu
     */
    public Integer getCompteur() {
        return _compteur;
    }

    /**
     * Remplace la valeur de _compteur par celui passé en paramètre.
     * @param _compteur
     */
    public void setCompteur(Integer compteur) {
        this._compteur = compteur;
    }


    /**
     * Utilise le JSON d'initialisation pour compléter toutes les listes de chaque classes qui vont être utilisé lors du projet
     * Cette fonction ne renvoie rien, elle compléte seulement des objets déjà exitants
     * Elle ne prends rien en paramètres car elle va juste récupérer le chemin du fichier JSON définit plus haut.
     */
    public void init(){
        String path ="";
                try {
                    URI u = FenetreAppelante.class.getResource(".").toURI();
                    Path p = Paths.get(u);
                    path = p.getParent().getParent().getParent().resolve("ressources/JSON/initialisation.json").toString();
                } catch (URISyntaxException e) {
                    System.out.println(e);
                }

        Object obj;
        try {
            //JSONObject jo  = (JSONObject) new JSONParser().parse(new FileReader(path));
            JSONObject jo  = (JSONObject) new JSONParser().parse(new InputStreamReader(new FileInputStream(path), "UTF-8"));

            JSONArray ja = (JSONArray) jo.get("regles");
            for(int i = 0; i<ja.size();i++){
                JSONObject ob = (JSONObject) ja.get(i);
                String intitule = ob.get("intitule").toString();
                Integer id = Integer.valueOf(String.valueOf(ob.get("id")));
                this.getTouteRegles().add(new Regle("<html><body><h3>" + intitule + "</h3></body></html>", id));
            }

            JSONArray ja2 = (JSONArray) jo.get("issues");
            for(int i = 0; i<ja2.size(); i++){
                JSONObject ob2 = (JSONObject) ja2.get(i);
                Integer id = Integer.valueOf(String.valueOf(ob2.get("id")));
                String finalite = ob2.get("finalite").toString();
                ListRegles lr = new ListRegles();
                JSONArray jaa = (JSONArray) ob2.get("list_id_regle");
                if(jaa!=null){
                    for(int k = 0; k<jaa.size(); k++){
                        Integer in = Integer.valueOf(String.valueOf(jaa.get(k)));
                        for(Regle r : getTouteRegles()){
                            if(r.getID() == in){
                                lr.add(r);
                            }
                        }
                }
                }
                this._toutesIssues.add(new Issue(finalite, id, lr));
            }

            JSONArray ja3 = (JSONArray) jo.get("situations");
            for(int j = 0; j<ja3.size();j++){
                JSONObject ob3 = (JSONObject) ja3.get(j);
                Integer id = Integer.valueOf(String.valueOf(ob3.get("id")));
                String titre = ob3.get("titre").toString();
                String descriptif = ob3.get("descriptif").toString();
                String imgPath = ob3.get("image").toString();
                JSONArray listChoix = (JSONArray) ob3.get("liste_choix");
                ListIssues li = new ListIssues();
                if(listChoix!=null){
                    for(int k = 0; k<listChoix.size(); k++){
                        Integer in = Integer.valueOf(String.valueOf(listChoix.get(k)));
                        for(Issue i : this._toutesIssues){
                            if(i.getID() == in){
                                li.add(i);
                            }
                        }
                }
                this._toutesSituations.add(new Situation(id, titre, descriptif, imgPath, li));
            }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
            } catch (IOException e){
            System.out.println((e));

            } catch (ParseException e) {
            System.out.println(e);
        }

    }

}

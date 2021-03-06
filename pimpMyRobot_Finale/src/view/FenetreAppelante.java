
package view;

import controler.Game;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.UIManager;

/**
 *  Classe qui gère l'ensemble des fenêtres du jeu, à savoir la fenêtre d'accueil, de lancement, des règles, de la hierarchisation,
 *  des situations, du bilan; elle instancie toutes ces fenêtres et contient également une instance de la classe Game qui
 *  correspond à la partie en cours.
 * @author meya
 */
public class FenetreAppelante extends javax.swing.JPanel {
    /**
     * Instance de la classe contrôleur Game qui correspond à la partie en cours.
     * @attribute _game
     */
    private Game _game;
    
    /**
     * Instance de la fenêtre d'accueil du jeu, qui contient le titre du jeu et un bouton pour passer à la prochaine fenêtre.
     * @attribute _titre
     */
    private Accueil _titre;
    
    /**
     * Instance de la fenêtre de lancement du jeu, qui demande au joueur de rentrer le nom de son robot et le nombre de
     * situations à laquelle il souhaite être confronté.
     * @attribute _lancement
     */
    private Lancement _lancement;
    
    /**
     * Instance de la fenêtre des règles du jeu, qui affiche l'ensemble des règles du jeu.
     * @attribute _regles
     */
    private FenetreRegle _regles;
    
    /**
     * Instance de la fenêtre de hierarchisation des règles du jeu, qui propose aux joueurs d'ordonner ses règles selon ses
     * préférences de haut en bas (de la plus importante à la moins importante).
     * @attribute _hiera
     */
    private Hierarchisation _hiera;
    
    /**
     * Instance de la fenêtre des situations du jeu, qui affiche succesivement des situations et demande au joueur de choisir
     * l'issue qu'il pense que le robot va choisir selon la hierarchisation des règles qu'il s'est fixé.
     * @attribute _situation
     */
    private FenetreSituation _situation;
    
    /**
     * Instance de la fenêtre du bilan du jeu, qui affiche un récapitulatif à savoir le score du joueur ainsi que l'issue choisie
     * par le joueur et l'issue choisie par le robot pour chaque situations.
     * @attribute _bilan
     */
    private Bilan _bilan;
    
    /**
     * Instance de la fenêtre de didacticiel du jeu, elle affiche une interface d'aide pour le joueur.
     * @attribute _didacticiel
     */
    private Didacticiel _didacticiel;

    /**
     * Constructeur de la classe FenetreAppelante.
     */
    public FenetreAppelante() {
        this._game = new Game();
        _game.init();
        this._titre = new Accueil(this);
        this._titre.setVisible(true);
        this._lancement = new Lancement(this);
        this._regles = new FenetreRegle(this);
        this._hiera = new Hierarchisation(this);
        this._situation = new FenetreSituation(this);
        this._bilan = new Bilan(this);
        this._didacticiel= new Didacticiel(this);
        initComponents();
        this.setVisible(true);
        
    }
    
    /**
     * Retourne la fenêtre de lancement du jeu.
     * @return la fenêtre de lancement du jeu
     */
    public Lancement getLancement() {
        return _lancement;
    }
    
    /**
     * Retourne la fenêtre des règles du jeu.
     * @return la fenêtre des règles du jeu
     */
    public FenetreRegle getRegles() {
        return _regles;
    }
    
    /**
     * Retourne la fenêtre de hierarchisation des règles du jeu.
     * @return la fenêtre de hierarchisation des règles du jeu
     */
    public Hierarchisation getHiera() {
        return _hiera;
    }
    
    /**
     * Retourne la fenêtre des situations du jeu.
     * @return la fenêtre des situations du jeu
     */
    public FenetreSituation getSituation() {
        return _situation;
    }
    
    /**
     * Retourne la fenêtre de bilan du jeu.
     * @return la fenêtre de bilan du jeu
     */
    public Bilan getBilan() {
        return _bilan;
    }
    
    /**
     * Retourne l'instance du jeu courant.
     * @return l'instance du jeu courant
     */
    public Game getGame() {
        return _game;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 865, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 538, Short.MAX_VALUE)
        );
    }//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
     *Retourne le didacticiel du jeu
     * @return La fenetre de didacticiel du jeu
     */
    public Didacticiel getDidacticiel() {
        return _didacticiel;
    }
    // End of variables declaration//GEN-END:variables
    /**
     * Le main qui permet le démarrage du jeu et met en place le style 'Nimbus' comme design par défaut de toutes les fenêtres
     * de l'application et instancie la classe FenetreAppelante pour démarrer le jeu.
     * @param args paramètre rentrée par l'utilisateur en ligne de commande (non utilisé dans cette application)
     */
    public static void main(String args[]){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing
                                                                   .UIManager
                                                                   .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing
                         .UIManager
                         .setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util
                .logging
                .Logger
                .getLogger(Lancement.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util
                .logging
                .Logger
                .getLogger(Lancement.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util
                .logging
                .Logger
                .getLogger(Lancement.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util
                .logging
                .Logger
                .getLogger(Lancement.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        }
        new FenetreAppelante();
    }

    public Accueil getTitre() {
        return _titre;
    }

    public void setSituation(FenetreSituation _situation) {
        this._situation = _situation;
    }
}

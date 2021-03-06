
package view;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.FlowLayout;
import java.awt.Font;

import java.io.File;

import java.io.IOException;

import java.util.Timer;

import java.util.TimerTask;

import javax.imageio.ImageIO;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import model.Situation;

/**
 * Classe qui représente le bilan du jeu, à savoir un récapitulatif issues choisies par le joueur et le robot ainsi que
 * le score du joueur.
 * @author tramos
 */
public class Bilan extends javax.swing.JFrame {
    /**
     * Attribut static contenant l'instance de FenetreAppelante avec les données des autres fenêtres et les données du jeu.
     * @attribute static _fenetreAppelante
     */
    private static FenetreAppelante _fenetreAppelante;

    /**
     * Panel contenant la liste des règles qu'a choisie le joueurs, triée par ordre croissant des poids des règles.
     * @attribute _panelRegles
     */
    private JPanel _panelRegles;

    /**
     * Panel contenant le récapitulatif de la session de jeu du joueur, avec le score et les issues choisie par le joueur et le
     * robot pour chaques situations.
     * @attribute _panelStats
     */
    private JPanel _panelStats;

    /**
     * Constructeur de la classe Bilan.
     * @param tw l'instance de la classe FenetreAppelante avec les données des autres fenêtres et les données du jeu
     */
    public Bilan(FenetreAppelante tw) {
        _fenetreAppelante = tw;
        _panelRegles = new JPanel();
        BoxLayout boxlayout1 = new BoxLayout(_panelRegles, BoxLayout.Y_AXIS);
        _panelRegles.setLayout(boxlayout1);
        _panelStats = new JPanel();
        BoxLayout boxlayout2 = new BoxLayout(_panelStats, BoxLayout.Y_AXIS);
        _panelStats.setLayout(boxlayout2);
        initComponents();
        this.getContentPane().setBackground(Color.BLACK);
        this.setLocationRelativeTo(null);
        Border lineborder = BorderFactory.createLineBorder(new Color(20, 20, 20), 0);
        Border borderRegle = BorderFactory.createTitledBorder(lineborder, "Vos règles triées:", TitledBorder.LEFT,TitledBorder.TOP, new Font("Arial",Font.PLAIN, 20), Color.WHITE);
        Border borderStats = BorderFactory.createTitledBorder(lineborder, "Récapitulatif:", TitledBorder.LEFT,TitledBorder.TOP, new Font("Arial",Font.PLAIN, 20), Color.WHITE);
        _panelRegles.setBorder(borderRegle);
        _panelStats.setBorder(borderStats);
        _panelRegles.setBackground(new Color(20, 20, 20));
        _panelStats.setBackground(new Color(20, 20, 20));
        scp_regles.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scp_regles.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scp_stats.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scp_stats.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        btn_cadeau.setVisible(false);


        this.setIconImage((new javax.swing.ImageIcon(getClass().getResource("/image/pimpMyRobotProjectIcon.jpg"))).getImage());
        this.setResizable(false);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        lbl_robot = new javax.swing.JLabel();
        scp_stats = new javax.swing.JScrollPane();
        scp_regles = new javax.swing.JScrollPane();
        lbl_nbSitu = new javax.swing.JLabel();
        btn_new = new javax.swing.JButton();
        btn_quitter = new javax.swing.JButton();
        btn_cadeau = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lbl_robot.setForeground(new java.awt.Color(255, 255, 255));
        lbl_robot.setText("jLabel1");

        lbl_nbSitu.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nbSitu.setText("jLabel1");

        btn_new.setBackground(new java.awt.Color(0, 51, 255));
        btn_new.setForeground(new java.awt.Color(255, 255, 255));
        btn_new.setText("Recommencer");
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });

        btn_quitter.setBackground(new java.awt.Color(255, 0, 0));
        btn_quitter.setForeground(new java.awt.Color(255, 255, 255));
        btn_quitter.setText("Quitter");
        btn_quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quitterActionPerformed(evt);
            }
        });

        btn_cadeau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadeauActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scp_regles, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lbl_robot, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scp_stats, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_nbSitu, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_cadeau, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_new, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124)
                .addComponent(btn_quitter, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nbSitu, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_robot, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scp_regles, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                    .addComponent(scp_stats))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_quitter, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_new, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_cadeau, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }//GEN-END:initComponents

    /**
     * Quitte l'application.
     */
    private void btn_quitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quitterActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_quitterActionPerformed

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        // TODO add your handling code here:
        //_fenetreAppelante.getRegles().refresh();
        this._panelRegles.removeAll();
        this._panelStats.removeAll();
        _fenetreAppelante.getGame().getIssuesJoueurs().removeAll();
        _fenetreAppelante.getGame().getIssuesRobot().removeAll();
        _fenetreAppelante.getGame().setScore(0);
        _fenetreAppelante.getRegles().setVisible(true);
    }//GEN-LAST:event_btn_newActionPerformed

    private void btn_cadeauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadeauActionPerformed
       recompense();
    }//GEN-LAST:event_btn_cadeauActionPerformed

    /**
     * Remplie _panelRegles et _panelStats.
     */
    public void refresh() {

        lbl_robot.setText("<html><body><h3>" +
                          _fenetreAppelante.getGame().getRobot().getNom() +
                          "</h3></body></html>");
        lbl_nbSitu.setText(String.valueOf("<html><body><h3>" +
                                          "Nombre de situations jouées: " + _fenetreAppelante.getGame().getNbSituations() +
                                          "</h3></body></html>"));


        for(model.Regle r : _fenetreAppelante.getGame().getRobot().getListRegles()) {
            JLabel jlb = new JLabel();
            jlb.setText(r.getIntitule());
            jlb.setForeground(new Color(255, 153, 0));
            _panelRegles.add(jlb);
            _panelRegles.add(Box.createRigidArea(new Dimension(1, 5)));
            _panelRegles.add(Box.createRigidArea(new Dimension(1, 5)));
        }
        scp_regles.setViewportView(_panelRegles);

        JLabel score = new JLabel();
        score.setText("<html><body><h3>" +
                      "Score : " +
                      String.valueOf(_fenetreAppelante.getGame().getScore()) +
                      "/" + _fenetreAppelante.getGame().getNbSituations() +
                      "</h3></body></html>");
        score.setForeground(Color.WHITE);
        _panelStats.add(score);
        _panelStats.add(Box.createRigidArea(new Dimension(1, 5)));
        JLabel situ = new JLabel();
        situ.setText("<html><body><h3>Situations :</h3></body></html>");
        situ.setForeground(new Color(255, 153, 0));
        _panelStats.add(situ);
        _panelStats.add(Box.createRigidArea(new Dimension(1, 5)));
        for(int i = 0; i < _fenetreAppelante.getGame().getSituationsChoisies().size(); i++) {
            JLabel jlb = new JLabel();
            jlb.setText("<html><body><h3>" +
                        _fenetreAppelante.getGame().getSituationsChoisies().get(i).getTitre() +
                        " | Votre choix: " +
                        _fenetreAppelante.getGame().getIssuesJoueurs().get(i).getNom() +
                        " | Choix du robot: " +
                        _fenetreAppelante.getGame().getIssuesRobot().get(i).getNom() +
                        "</h3></body></html>");
            jlb.setForeground(new Color(255, 153, 0));
            _panelStats.add(jlb);
            _panelStats.add(Box.createRigidArea(new Dimension(1, 5)));
            _panelStats.add(Box.createRigidArea(new Dimension(1, 5)));
        }
        scp_stats.setViewportView(_panelStats);



        if((_fenetreAppelante.getGame().getScore() >= 5) && (_fenetreAppelante.getGame().getScore() == _fenetreAppelante.getGame().getNbSituations()) ){
            btn_cadeau.setVisible(true);
        }

    }

    public void recompense(){
        JFrame recompense = new JFrame();
        recompense.setSize(600, 400);
        recompense.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        recompense.setLocationRelativeTo(null);

        JLabel jl_image = new JLabel(new javax.swing.ImageIcon(getClass().getResource("/image/mereNoelCensure.jpg")));
        recompense.setContentPane(jl_image);
        recompense.getContentPane().setLayout(new FlowLayout());

        JLabel lbl_score = new JLabel(_fenetreAppelante.getGame().getScore() +"/"+_fenetreAppelante.getGame().getNbSituations());
        JLabel lbl_felicitation = new JLabel("FELICITATION !");

        lbl_score.setFont(new Font("Arial",Font.BOLD,80));
        lbl_felicitation.setFont(new Font("Arial",Font.BOLD,80));
        lbl_score.setForeground(Color.RED);
        lbl_felicitation.setForeground(Color.RED);


        recompense.add(lbl_score);
        recompense.add(lbl_felicitation);
        recompense.setVisible(true);

        Timer timer = new Timer();
        Timer timer2 = new Timer();
        TimerTask taskRed = new TimerTask(){
            public void run(){
                lbl_score.setForeground(Color.RED);
                lbl_felicitation.setForeground(Color.RED);
            }
        };
        TimerTask taskGreen = new TimerTask(){
            public void run(){
                lbl_score.setForeground(Color.GREEN);
                lbl_felicitation.setForeground(Color.GREEN);
            }
        };
        timer.scheduleAtFixedRate(taskRed, 0, 100);
        timer2.scheduleAtFixedRate(taskGreen, 250, 100);


    }

    //public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        /*try {
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
                .getLogger(Bilan.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util
                .logging
                .Logger
                .getLogger(Bilan.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util
                .logging
                .Logger
                .getLogger(Bilan.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util
                .logging
                .Logger
                .getLogger(Bilan.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /*java.awt
            .EventQueue
            .invokeLater(new Runnable() {
                public void run() {
                    new Bilan(_fenetreAppelante).setVisible(true);
                }
            });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cadeau;
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_quitter;
    private javax.swing.JLabel lbl_nbSitu;
    private javax.swing.JLabel lbl_robot;
    private javax.swing.JScrollPane scp_regles;
    private javax.swing.JScrollPane scp_stats;
    // End of variables declaration//GEN-END:variables

}

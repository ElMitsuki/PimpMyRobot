package view;

import java.awt.datatransfer.DataFlavor;

import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

import java.awt.datatransfer.UnsupportedFlavorException;

import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.TransferHandler;


/**
 * Réécriture de la classe transferHandler afin de pouvoir utiliser des JLabel
 * en tant que source de données et destinataire lors d'un transfert de données cliqué glissé.
 */
public class TransferHandlerJLabel extends TransferHandler{

    /**
     * Attribut static contenant "une sauvegarde" du texte du JLabel destinataire
     * car il verra son texte remplacé par le composant source lors du transfert
     * @attribute static textDestinataire
     */
    private static String _textDestinataire = "";


    /**
     * Méthode permettant à l'objet destinataire du transfert de savoir
     * si les données reçues sont autorisées à être importées
     * @param info Informations sur les données transmises lors  d'un transfert
     * @return boolean vrai si la nature des données sont un string, faux sinon
     */
    public boolean canImport(TransferHandler.TransferSupport info) {
        if (!info.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            return false;
          }
          return true;
    }

    /**
     * Assigne au composant JLabel destinataire le texte du composant JLabel source et sauvegarde
     * le texte du composantJLabel destinataire dans la l'attribut _textDestinataire.
     * @param support Encapsule tous les détails de l'oppération cliqué glissé
     * @return Vrai
     */
    public boolean importData(TransferHandler.TransferSupport support){
        if(!canImport(support)){
            return false;
        }
      Transferable data = support.getTransferable();
      String str = "";
      try {
        str = (String)data.getTransferData(DataFlavor.stringFlavor);
      } catch (UnsupportedFlavorException e){
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
      JLabel lab = (JLabel)support.getComponent();
      _textDestinataire = lab.getText();
      lab.setText(str);

      return true;
    }

    /**
     * Appelé après que les données soient transférées. L'action est MOVE donc cela remplace le texte du composantSource
     * par l'ancient texte, sauvegardé dans la variable textDestinataire, du composant destinataire du transfert.
     * @param composantSource Le composant qui était la source de donnée
     * @param donneesTransferees Les données qui ont étées transférées
     * @param action L'action qui a été executé, ici MOVE
     */
  protected void exportDone(JComponent composantSource, Transferable donneesTransferees, int action){
      if(action == MOVE)
            ((JLabel)composantSource).setText(_textDestinataire);
  }

    /**
     * Crée un Transferable pour l'utiliser comme jeu de données lors d'un transfert de données entre les composants.
     * @param composantSource Le composant source, il contient les données à transférer
     * @return La représentation des données qui vont être transférées, un string ici
     */
  protected Transferable createTransferable(JComponent composantSource) {
    return new StringSelection(((JLabel)composantSource).getText());
  }

    /**
     * Retourne le type de l'action du transfert supporté par la source
     * @param composantSource Le composant contenant les données à transférer
     * @return constante MOVE: l'objet transféré va juste être déplacé d'un composant source à un autre
     */
  public int getSourceActions(JComponent composantSource) {
    return MOVE;
  }
}

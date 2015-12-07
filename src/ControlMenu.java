import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by nico on 08/11/15.
 */
public class ControlMenu implements ActionListener {

    Fenetre fen;

    public ControlMenu(Fenetre fen) {
        this.fen=fen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == fen.itemInterface1) {
            fen.changerVersion(1);
            System.out.println(" joueur2 ok");
            fen.repaint();

        } else if (e.getSource() == fen.itemInterface2) {
            fen.changerVersion(2);
            System.out.println(" joueur3 ok");
            fen.repaint();


        } else if (e.getSource() == fen.itemInterface3) {
            fen.changerVersion(3);
            System.out.println(" joueur4 ok");
            fen.repaint();


        } else if (e.getSource() == fen.itemInterface4) {
            fen.changerVersion(4);
            System.out.println(" joueur5 ok");
            fen.repaint();


        } else if (e.getSource() == fen.itemInterface5) {
            fen.changerVersion(5);
            System.out.println(" joueur6 ok");
            fen.repaint();
        }
    }
}





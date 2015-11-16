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
            System.out.println("Test Version 1 ok");

        } else {
            if (e.getSource() == fen.itemInterface2) {
                fen.changerVersion(2);
                System.out.println("Test version 2 ok");

            } else {
                if (e.getSource() == fen.itemApropos) {
                    fen.creerDialogue("fait par nico");
                    System.out.println("aproposselectioné");

                } else {
                    System.out.println(" what?");
                }
            }
        }


    }
}

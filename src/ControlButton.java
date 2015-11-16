import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by nico on 08/11/15.
 */
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlButton implements ActionListener{
    protected Model model;
    protected Fenetre fen;
    int lancer=1;

    public ControlButton(Model m,Fenetre fen) {
        this.fen=fen;
        this.model=m;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int sortie[] = new int[6];
        JLabel dé1, dé2, dé3, dé4, dé5;


        if (e.getSource() == fen.lancer) {
            for (int i = 0; i <6 ; i++) {
                sortie[i]=(int)(6.0 * Math.random()) + 1;
            }
            if(lancer<=3) {

                System.out.println(lancer);
                if (fen.A1.isSelected() == false) {
                    dé1 = fen.dé1;
                    String chiffre1 = Integer.toString(sortie[1]);
                    dé1.setText(chiffre1);
                }
                if (fen.A2.isSelected() == false) {
                    dé2 = fen.dé2;
                    String chiffre2 = Integer.toString(sortie[2]);
                    dé2.setText(chiffre2);
                }
                if (fen.A3.isSelected() == false) {
                    dé3 = fen.dé3;
                    String chiffre3 = Integer.toString(sortie[3]);
                    dé3.setText(chiffre3);
                }
                if (fen.A4.isSelected() == false) {
                    dé4 = fen.dé4;
                    String chiffre4 = Integer.toString(sortie[4]);
                    dé4.setText(chiffre4);
                }
                if (fen.A5.isSelected() == false) {
                    dé5 = fen.dé5;
                    String chiffre5 = Integer.toString(sortie[5]);
                    dé5.setText(chiffre5);
                }

                lancer++;
            }

        }

        if (e.getSource() == fen.TotalAs) {
            System.out.println("controle attaque ok");
        }

        if (e.getSource() == fen.TotalDeux) {
            System.out.println("controle defence ok");
        }

        if (e.getSource() == fen.TotalTrois) {
            System.out.println("controle attendre ok");
        }

        if (e.getSource() == fen.TotalQuatre) {
            System.out.println("controle fin de tour ok");
        }
        if (e.getSource() == fen.TotalCinq) {
            System.out.println("controle attaque ok");
        }

        if (e.getSource() == fen.TotalSix) {
            System.out.println("controle defence ok");
        }

        if (e.getSource() == fen.Total) {
            System.out.println("controle attendre ok");
        }

        if (e.getSource() == fen.Brelan) {
            System.out.println("controle fin de tour ok");
        }
        if (e.getSource() == fen.Carre) {
            System.out.println("controle attaque ok");
        }

        if (e.getSource() == fen.Full) {
            System.out.println("controle defence ok");
        }

        if (e.getSource() == fen.PSuite) {
            System.out.println("controle attendre ok");
        }

        if (e.getSource() == fen.GSuite) {
            System.out.println("controle fin de tour ok");
        }
        if (e.getSource() == fen.Yahtzee) {
            System.out.println("controle attaque ok");
        }

        if (e.getSource() == fen.Chance) {
            System.out.println("controle defence ok");
        }

        if (e.getSource() == fen.PrimeY) {
            System.out.println("controle attendre ok");
        }

        if (e.getSource() == fen.Prime35) {
            System.out.println("controle fin de tour ok");
        }
        if (e.getSource() == fen.TotalInf) {
            System.out.println("controle attaque ok");
        }

        if (e.getSource() == fen.TotalSup) {
            System.out.println("controle defence ok");
        }

        if (e.getSource() == fen.TotalSup2) {
            System.out.println("controle attendre ok");
        }

    }
}

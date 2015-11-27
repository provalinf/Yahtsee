import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by nico on 08/11/15.
 */
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControlButton implements ActionListener{
    protected Model model;
    protected Fenetre fen;
    int totalup[];

    public ControlButton(Model model,Fenetre fen) {
        this.fen=fen;
        this.model=model;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        totalup= new int[model.getNbJoueur()];
        int sortie[] = new int[6];
        JLabel dé1, dé2, dé3, dé4, dé5;

        if (e.getSource() == fen.lancer) {
            model.jette();

            if (fen.A1.isSelected() == false) {
                dé1 = fen.dé1;
                String chiffre1 = Integer.toString(model.getSortie(1));
                dé1.setText(chiffre1);
                }
            if (fen.A2.isSelected() == false) {
                dé2 = fen.dé2;
                String chiffre2 = Integer.toString(model.getSortie(2));
                dé2.setText(chiffre2);
                }
            if (fen.A3.isSelected() == false) {
                dé3 = fen.dé3;
                String chiffre3 = Integer.toString(model.getSortie(3));
                dé3.setText(chiffre3);
                }
            if (fen.A4.isSelected() == false) {
                dé4 = fen.dé4;
                String chiffre4 = Integer.toString(model.getSortie(4));
                dé4.setText(chiffre4);
                }
            if (fen.A5.isSelected() == false) {
                dé5 = fen.dé5;
                String chiffre5 = Integer.toString(model.getSortie(5));
                dé5.setText(chiffre5);
            }

            if(model.getLancer()!=3){

                model.setLancer(1);

            }
            if(model.getLancer()==3){fen.lancer.setVisible(false);
                model.initLancer();}

            System.out.println("lancer  : "+model.getLancer());

        }

        if (e.getSource() == fen.TotalAs) {

            if(model.getJoueur()==model.getNbJoueur()){
                model.initJoueur();
            }

            fen.lancer.setVisible(true);
            model.initLancer();
            model.compAdd(fen,1);
            model.setScore(model.getJoueur(),model.getSomme());

            String esp1 = Integer.toString(model.getScore(model.getJoueur()));
            fen.esp[1][model.getJoueur()].setText(esp1);
            model.initCase(fen);

            totalup[model.getJoueur()]=totalup[model.getJoueur()]+ model.getSomme();

            String trans=Integer.toString(totalup[model.getJoueur()]);
            fen.esp[7][model.getJoueur()].setText(trans);
            fen.esp[9][model.getJoueur()].setText(trans);

            if(model.getJoueur()!=model.getNbJoueur()){model.setJoueur();}

        }

        if (e.getSource() == fen.TotalDeux) {


            if(model.getJoueur()==model.getNbJoueur()){
                model.initJoueur();
            }

            fen.lancer.setVisible(true);
            model.initLancer();
            model.compAdd(fen,2);
            model.setScore(model.getJoueur(),model.getSomme());

            String esp1 = Integer.toString(model.getScore(model.getJoueur()));
            fen.esp[2][model.getJoueur()].setText(esp1);
            model.initCase(fen);
            totalup[model.getJoueur()]=totalup[model.getJoueur()]+model.getSomme();
            String trans=Integer.toString(totalup[model.getJoueur()]);
            fen.esp[7][model.getJoueur()].setText(trans);
            fen.esp[9][model.getJoueur()].setText(trans);


            if(model.getJoueur()!=model.getNbJoueur()){

                model.setJoueur();
            }

        }

        if (e.getSource() == fen.TotalTrois) {


            if(model.getJoueur()==model.getNbJoueur()){
                model.initJoueur();
            }
            fen.lancer.setVisible(true);
            model.initLancer();
            model.compAdd(fen,3);
            model.setScore(model.getJoueur(),model.getSomme());

            String esp1 = Integer.toString(model.getScore(model.getJoueur()));
            fen.esp[3][model.getJoueur()].setText(esp1);
            model.initCase(fen);
            totalup[model.getJoueur()]=totalup[model.getJoueur()]+ model.getSomme();
            String trans=Integer.toString(totalup[model.getJoueur()]);
            fen.esp[7][model.getJoueur()].setText(trans);
            fen.esp[9][model.getJoueur()].setText(trans);

            if(model.getJoueur()!=model.getNbJoueur()){

                model.setJoueur();
            }
        }

        if (e.getSource() == fen.TotalQuatre) {

            if(model.getJoueur()==model.getNbJoueur()){
                model.initJoueur();
            }
            fen.lancer.setVisible(true);
            model.initLancer();
            model.compAdd(fen ,4);
            model.setScore(model.getJoueur(),model.getSomme());

            String esp1 = Integer.toString(model.getScore(model.getJoueur()));
            fen.esp[4][model.getJoueur()].setText(esp1);
            model.initCase(fen);
            totalup[model.getJoueur()]=totalup[model.getJoueur()]+ model.getSomme();
            String trans=Integer.toString(totalup[model.getJoueur()]);
            fen.esp[7][model.getJoueur()].setText(trans);
            fen.esp[9][model.getJoueur()].setText(trans);


            if(model.getJoueur()!=model.nbJoueur){

                model.setJoueur();
            }
            System.out.println("lancer  : "+model.getLancer());
        }

        if (e.getSource() == fen.TotalCinq) {

            if(model.getJoueur()==model.getNbJoueur()){
                model.initJoueur();
            }
            fen.lancer.setVisible(true);
            model.initLancer();
            model.compAdd(fen,5);
            model.setScore(model.getJoueur(),model.getSomme());

            String esp1 = Integer.toString(model.getScore(model.getJoueur()));
            fen.esp[5][model.getJoueur()].setText(esp1);
            model.initCase(fen);
            totalup[model.getJoueur()]=totalup[model.getJoueur()]+ model.getSomme();
            String trans=Integer.toString(totalup[model.getJoueur()]);
            fen.esp[7][model.getJoueur()].setText(trans);
            fen.esp[9][model.getJoueur()].setText(trans);

            if(model.getJoueur()!=model.getNbJoueur()){

                model.setJoueur();
            }
        }

        if (e.getSource() == fen.TotalSix) {

            if(model.getJoueur()==model.getNbJoueur()){
                model.initJoueur();
            }
            fen.lancer.setVisible(true);
            model.initLancer();
            model.compAdd(fen,6);
            model.setScore(model.getJoueur(),model.getSomme());

            String esp1 = Integer.toString(model.getScore(model.getJoueur()));
            fen.esp[6][model.getJoueur()].setText(esp1);
            model.initCase(fen);
            totalup[model.getJoueur()]=totalup[model.getJoueur()]+ model.getSomme();
            String trans=Integer.toString(totalup[model.getJoueur()]);
            fen.esp[7][model.getJoueur()].setText(trans);
            fen.esp[9][model.getJoueur()].setText(trans);

            if(model.getJoueur()!=model.getNbJoueur()){

                model.setJoueur();
            }

        }

        if (e.getSource() == fen.Brelan) {

            if(model.getJoueur()==model.getNbJoueur()){
                model.initJoueur();
            }
            model.compAdd2(fen,1,model.getJoueur());
            model.setScore(model.getJoueur(), model.getSomme());

            String esp1 = Integer.toString(model.getScore(model.getJoueur()));
            fen.esp[12][model.getJoueur()].setText(esp1);
            model.initLancer();
            model.initCase(fen);

            if(model.getJoueur()!=model.getNbJoueur()){

                model.setJoueur();
            }
        }

        if (e.getSource() == fen.Carre) {
            if(model.getJoueur()==model.getNbJoueur()){
                model.initJoueur();
            }
            model.compAdd2(fen,3,model.getJoueur());
            model.setScore(model.getJoueur(), model.getSomme());

            String esp1 = Integer.toString(model.getScore(model.getJoueur()));
            fen.esp[13][model.getJoueur()].setText(esp1);

            model.initLancer();
            model.initCase(fen);

            if(model.getJoueur()!=model.nbJoueur){

                model.setJoueur();
            }
        }

        if (e.getSource() == fen.Full) {
            if(model.getJoueur()==model.nbJoueur){
                model.initJoueur();
            }
            model.compAdd2(fen, 2,model.getJoueur());
            model.setScore(model.getJoueur(), model.getSomme());

            String esp1 = Integer.toString(model.getScore(model.getJoueur()));
            fen.esp[14][model.getJoueur()].setText(esp1);
            model.initLancer();
            model.initCase(fen);

            if(model.getJoueur()!=model.getNbJoueur()){

                model.setJoueur();
            }
        }

        if (e.getSource() == fen.PSuite) {
            if(model.getJoueur()==model.getNbJoueur()){
                model.initJoueur();
            }

            model.compAdd(fen,0);
            model.setScore(model.getJoueur(), model.getSomme());

            String esp1 = Integer.toString(model.getScore(model.getJoueur()));
            fen.esp[15][model.getJoueur()].setText(esp1);
            model.initLancer();
            model.initCase(fen);

            if(model.getJoueur()!=model.getNbJoueur()){

                model.setJoueur();
            }
        }

        if (e.getSource() == fen.GSuite) {
            if(model.getJoueur()==model.nbJoueur){
                model.initJoueur();
            }

            model.compAdd(fen,0);
            model.setScore(model.getJoueur(), model.getSomme());

            String esp1 = Integer.toString(model.getScore(model.getJoueur()));
            fen.esp[16][model.getJoueur()].setText(esp1);
            model.initLancer();
            model.initCase(fen);

            if(model.getJoueur()!=model.nbJoueur){

                model.setJoueur();
            }
        }
        if (e.getSource() == fen.Yahtzee) {
            if(model.getJoueur()==model.getNbJoueur()){
                model.initJoueur();
            }

            model.compAdd(fen,0);
            model.setScore(model.getJoueur(), model.getSomme());

            String esp1 = Integer.toString(model.getScore(model.getJoueur()));
            fen.esp[17][model.getJoueur()].setText(esp1);
            model.initLancer();
            model.initCase(fen);

            if(model.getJoueur()!=model.nbJoueur){

                model.setJoueur();
            }
        }

        if (e.getSource() == fen.Chance) {
            if(model.getJoueur()==model.nbJoueur){
                model.initJoueur();
            }

            model.compAdd(fen,0);
            model.setScore(model.getJoueur(), model.getSomme());

            String esp1 = Integer.toString(model.getScore(model.getJoueur()));
            fen.esp[6][model.getJoueur()].setText(esp1);
            model.initLancer();
            model.initCase(fen);

            if(model.getJoueur()!=model.getNbJoueur()){

                model.setJoueur();
            }
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

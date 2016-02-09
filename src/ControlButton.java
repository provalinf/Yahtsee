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
        totalup = new int[model.j.getNbJoueur()];
        int sortie[] = new int[6];
        JLabel dé1, dé2, dé3, dé4, dé5;

System.out.print(model.tour);

        if (e.getSource() == fen.lancer) {
            model.d.jette();
            model.initcheckTrue(fen);

            if (fen.A1.isSelected() == false) {
                dé1 = fen.dé1;
                String chiffre1 = Integer.toString(model.d.getSortie(1));
                dé1.setText(chiffre1);
            }
            if (fen.A2.isSelected() == false) {
                dé2 = fen.dé2;
                String chiffre2 = Integer.toString(model.d.getSortie(2));
                dé2.setText(chiffre2);
            }
            if (fen.A3.isSelected() == false) {
                dé3 = fen.dé3;
                String chiffre3 = Integer.toString(model.d.getSortie(3));
                dé3.setText(chiffre3);
            }
            if (fen.A4.isSelected() == false) {
                dé4 = fen.dé4;
                String chiffre4 = Integer.toString(model.d.getSortie(4));
                dé4.setText(chiffre4);
            }
            if (fen.A5.isSelected() == false) {
                dé5 = fen.dé5;
                String chiffre5 = Integer.toString(model.d.getSortie(5));
                dé5.setText(chiffre5);
            }

            if (model.d.getLancer() != 3) {

                model.d.setLancer(1);

            }
            if (model.d.getLancer() == 3) {
                fen.lancer.setVisible(false);
                model.d.initLancer();
            }

        }

        if (e.getSource() == fen.TotalAs) {

            if (model.j.getJoueur() == model.j.getNbJoueur()) {
                model.j.initJoueur();
            }
            if (fen.esp[1][model.j.getJoueur()].getText() == "_") {//le if est pour éviter d'écrire deux fois dans la même case

                fen.lancer.setVisible(true);///remet la touche de lancer
                model.d.initLancer();//initialise le lancer
                model.j.initScore(model.j.getJoueur());//initialisation de la somme
                model.compAdd(fen, 1);//utilise la focntion pour recupere les dés et sortire le totale du lancer

                if(model.j.getTotalScoreHaut(model.j.getJoueur())>=63&&model.j.getTrenteCinq(model.j.getJoueur())==true){//mise ne place de la verife si la prime de 35 point est valide
                    model.j.setTotalScoreHaut(model.j.getJoueur(),35);                                                      ///a repeter pour chaque touche
                    model.j.setPrimeTrenteCinq(model.j.getJoueur());
                    fen.esp[8][model.j.getJoueur()].setText("35");
                }

                String esp1 = Integer.toString(model.j.getScore(model.j.getJoueur()));////on transforme en string
                fen.esp[1][model.j.getJoueur()].setText(esp1);//on insert le text dans la fenetre
                model.initCase(fen);//on remet les des et les check a zero
                model.j.setTotalScoreHaut(model.j.getJoueur(),model.j.getScore(model.j.getJoueur()));//on update le score pour la partie haute
                String trans = Integer.toString(model.j.getTotalScoreHaut(model.j.getJoueur()));//transformation en string
                model.j.setScoreTotal(model.j.getJoueur(),model.j.getTotalScoreHaut(model.j.getJoueur()),model.j.getTotalScoreBas(model.j.getJoueur()));
                String transToo= Integer.toString(model.j.getScoreTotal(model.j.getJoueur()));
                fen.esp[7][model.j.getJoueur()].setText(trans);//insertion dans fentre
                fen.esp[9][model.j.getJoueur()].setText(trans);//la aussi
                fen.esp[22][model.j.getJoueur()].setText(transToo);
              //  model.verifcase(fen);

                model.initcheckFalse(fen);

                if (model.j.getJoueur() != model.j.getNbJoueur()) {
                    model.j.setJoueur();
                    model.verifTour(fen);
                }
                fen.Info3.setText(model.nomjoueur(model.j.getJoueur()));
            } else {fen.Info3.setText("Impossible case deja joué");}//ET LA LE CAS OU SI LA CASE EST DEJA REMPLI



            }

            if (e.getSource() == fen.TotalDeux) {


                if (model.j.getJoueur() == model.j.getNbJoueur()) {
                    model.j.initJoueur();
                }
                if (fen.esp[2][model.j.getJoueur()].getText() == "_") {
                fen.lancer.setVisible(true);
                model.d.initLancer();
                model.j.initScore(model.j.getJoueur());
                model.compAdd(fen, 2);
                    if(model.j.getTotalScoreHaut(model.j.getJoueur())>=63&&model.j.getTrenteCinq(model.j.getJoueur())==true){
                        model.j.setTotalScoreHaut(model.j.getJoueur(),35);
                        model.j.setPrimeTrenteCinq(model.j.getJoueur());
                        fen.esp[8][model.j.getJoueur()].setText("35");
                    }
                String esp1 = Integer.toString(model.j.getScore(model.j.getJoueur()));
                fen.esp[2][model.j.getJoueur()].setText(esp1);
                model.initCase(fen);
                model.j.setTotalScoreHaut(model.j.getJoueur(),model.j.getScore(model.j.getJoueur()));
                String trans = Integer.toString(model.j.getTotalScoreHaut(model.j.getJoueur()));
                    model.j.setScoreTotal(model.j.getJoueur(),model.j.getTotalScoreHaut(model.j.getJoueur()),model.j.getTotalScoreBas(model.j.getJoueur()));
                    String transToo= Integer.toString(model.j.getScoreTotal(model.j.getJoueur()));
                fen.esp[7][model.j.getJoueur()].setText(trans);
                fen.esp[9][model.j.getJoueur()].setText(trans);
                    fen.esp[22][model.j.getJoueur()].setText(transToo);
                  //  model.verifcase(fen);
                    model.initcheckFalse(fen);

                    if (model.j.getJoueur() != model.j.getNbJoueur()) {

                        model.j.setJoueur();
                        model.verifTour(fen);
                    }
                    fen.Info3.setText(model.nomjoueur(model.j.getJoueur()));
                }
                else {fen.Info3.setText("Impossible case deja joué");}



            }

            if (e.getSource() == fen.TotalTrois) {


                if (model.j.getJoueur() == model.j.getNbJoueur()) {
                    model.j.initJoueur();
                }
                if (fen.esp[3][model.j.getJoueur()].getText() == "_") {
                    fen.lancer.setVisible(true);
                    model.d.initLancer();
                    model.j.initScore(model.j.getJoueur());
                    model.compAdd(fen, 3);
                    if(model.j.getTotalScoreHaut(model.j.getJoueur())>=63&&model.j.getTrenteCinq(model.j.getJoueur())==true){
                        model.j.setTotalScoreHaut(model.j.getJoueur(),35);
                        model.j.setPrimeTrenteCinq(model.j.getJoueur());
                        fen.esp[8][model.j.getJoueur()].setText("35");
                    }
                    String esp1 = Integer.toString(model.j.getScore(model.j.getJoueur()));
                    fen.esp[3][model.j.getJoueur()].setText(esp1);
                    model.initCase(fen);
                    model.j.setTotalScoreHaut(model.j.getJoueur(),model.j.getScore(model.j.getJoueur()));
                    String trans = Integer.toString(model.j.getTotalScoreHaut(model.j.getJoueur()));

                    model.j.setScoreTotal(model.j.getJoueur(),model.j.getTotalScoreHaut(model.j.getJoueur()),model.j.getTotalScoreBas(model.j.getJoueur()));
                    String transToo= Integer.toString(model.j.getScoreTotal(model.j.getJoueur()));
                    fen.esp[7][model.j.getJoueur()].setText(trans);
                    fen.esp[9][model.j.getJoueur()].setText(trans);
                    fen.esp[22][model.j.getJoueur()].setText(transToo);
                  //  model.verifcase(fen);
                    model.initcheckFalse(fen);

                    if (model.j.getJoueur() != model.j.getNbJoueur()) {

                        model.j.setJoueur();
                        model.verifTour(fen);
                    }
                    fen.Info3.setText(model.nomjoueur(model.j.getJoueur()));
                } else {fen.Info3.setText("Impossible case deja joué");}


            }

            if (e.getSource() == fen.TotalQuatre) {

                if (model.j.getJoueur() == model.j.getNbJoueur()) {
                    model.j.initJoueur();
                }
                if (fen.esp[4][model.j.getJoueur()].getText() == "_") {
                    fen.lancer.setVisible(true);
                    model.d.initLancer();
                    model.j.initScore(model.j.getJoueur());
                    model.compAdd(fen, 4);
                    if(model.j.getTotalScoreHaut(model.j.getJoueur())>=63&&model.j.getTrenteCinq(model.j.getJoueur())==true){
                        model.j.setTotalScoreHaut(model.j.getJoueur(),35);
                        model.j.setPrimeTrenteCinq(model.j.getJoueur());
                        fen.esp[8][model.j.getJoueur()].setText("35");
                    }
                    String esp1 = Integer.toString(model.j.getScore(model.j.getJoueur()));
                    fen.esp[4][model.j.getJoueur()].setText(esp1);
                    model.initCase(fen);
                    model.j.setTotalScoreHaut(model.j.getJoueur(),model.j.getScore(model.j.getJoueur()));
                    String trans = Integer.toString(model.j.getTotalScoreHaut(model.j.getJoueur()));
                    model.j.setScoreTotal(model.j.getJoueur(),model.j.getTotalScoreHaut(model.j.getJoueur()),model.j.getTotalScoreBas(model.j.getJoueur()));
                    String transToo= Integer.toString(model.j.getScoreTotal(model.j.getJoueur()));
                    fen.esp[7][model.j.getJoueur()].setText(trans);
                    fen.esp[9][model.j.getJoueur()].setText(trans);
                    fen.esp[22][model.j.getJoueur()].setText(transToo);
                   // model.verifcase(fen);
                    model.initcheckFalse(fen);

                    if (model.j.getJoueur() != model.j.nbJoueur) {

                        model.j.setJoueur();
                        model.verifTour(fen);
                        fen.Info3.setText(model.nomjoueur(model.j.getJoueur()));
                }
                else {fen.Info3.setText("Impossible case deja joué");}


                }

            }

            if (e.getSource() == fen.TotalCinq) {

                if (model.j.getJoueur() == model.j.getNbJoueur()) {
                    model.j.initJoueur();
                }
                if (fen.esp[5][model.j.getJoueur()].getText() == "_") {
                    fen.lancer.setVisible(true);
                model.d.initLancer();
                model.j.initScore(model.j.getJoueur());
                model.compAdd(fen, 5);
                    if(model.j.getTotalScoreHaut(model.j.getJoueur())>=63&&model.j.getTrenteCinq(model.j.getJoueur())==true){
                        model.j.setTotalScoreHaut(model.j.getJoueur(),35);
                        model.j.setPrimeTrenteCinq(model.j.getJoueur());
                        fen.esp[8][model.j.getJoueur()].setText("35");
                    }
                String esp1 = Integer.toString(model.j.getScore(model.j.getJoueur()));
                fen.esp[5][model.j.getJoueur()].setText(esp1);
                model.initCase(fen);
                model.j.setTotalScoreHaut(model.j.getJoueur(),model.j.getScore(model.j.getJoueur()));
                String trans = Integer.toString(model.j.getTotalScoreHaut(model.j.getJoueur()));
                    model.j.setScoreTotal(model.j.getJoueur(),model.j.getTotalScoreHaut(model.j.getJoueur()),model.j.getTotalScoreBas(model.j.getJoueur()));
                    String transToo= Integer.toString(model.j.getScoreTotal(model.j.getJoueur()));
                fen.esp[7][model.j.getJoueur()].setText(trans);
                fen.esp[9][model.j.getJoueur()].setText(trans);
                    fen.esp[22][model.j.getJoueur()].setText(transToo);
                   // model.verifcase(fen);
                    model.initcheckFalse(fen);
                    if (model.j.getJoueur() != model.j.getNbJoueur()) {

                        model.j.setJoueur();
                        model.verifTour(fen);
                    }
                    fen.Info3.setText(model.nomjoueur(model.j.getJoueur()));
                }
                else {fen.Info3.setText("Impossible case deja joué");}


            }

            if (e.getSource() == fen.TotalSix) {

                if (model.j.getJoueur() == model.j.getNbJoueur()) {
                    model.j.initJoueur();
                }
                if (fen.esp[6][model.j.getJoueur()].getText() == "_") {
                    fen.lancer.setVisible(true);
                model.d.initLancer();
                model.j.initScore(model.j.getJoueur());
                    model.compAdd(fen, 6);
                    if(model.j.getTotalScoreHaut(model.j.getJoueur())>=63&&model.j.getTrenteCinq(model.j.getJoueur())==true){
                        model.j.setTotalScoreHaut(model.j.getJoueur(),35);
                        model.j.setPrimeTrenteCinq(model.j.getJoueur());
                        fen.esp[8][model.j.getJoueur()].setText("35");
                    }
                String esp1 = Integer.toString(model.j.getScore(model.j.getJoueur()));
                fen.esp[6][model.j.getJoueur()].setText(esp1);
                    model.initCase(fen);
                    model.j.setTotalScoreHaut(model.j.getJoueur(),model.j.getScore(model.j.getJoueur()));
                    String trans = Integer.toString(model.j.getTotalScoreHaut(model.j.getJoueur()));
                    model.j.setScoreTotal(model.j.getJoueur(),model.j.getTotalScoreHaut(model.j.getJoueur()),model.j.getTotalScoreBas(model.j.getJoueur()));
                    String transToo= Integer.toString(model.j.getScoreTotal(model.j.getJoueur()));
                    fen.esp[7][model.j.getJoueur()].setText(trans);
                    fen.esp[9][model.j.getJoueur()].setText(trans);
                    fen.esp[22][model.j.getJoueur()].setText(transToo);
                    model.initcheckFalse(fen);

                    if (model.j.getJoueur() != model.j.getNbJoueur()) {

                        model.j.setJoueur();
                        model.verifTour(fen);
                    }
                    fen.Info3.setText(model.nomjoueur(model.j.getJoueur()));
                }
                else {fen.Info3.setText("Impossible case deja joué");

                   // model.verifcase(fen);
                }

            }
        ////partie basse be quiet

            if (e.getSource() == fen.Brelan) {

                if (model.j.getJoueur() == model.j.getNbJoueur()) {
                    model.j.initJoueur();
                }
                if (fen.esp[13][model.j.getJoueur()].getText() == "_") {
                    fen.lancer.setVisible(true);
                model.d.initLancer();
                model.j.initScore(model.j.getJoueur());
                model.compAdd2(fen, 1, model.j.getJoueur());
                String esp1 = Integer.toString(model.j.getScore(model.j.getJoueur()));
                fen.esp[13][model.j.getJoueur()].setText(esp1);
                model.initCase(fen);
                    model.j.setTotalScoreBas(model.j.getJoueur(),model.j.getScore(model.j.getJoueur()));
                String trans = Integer.toString(model.j.getTotalScoreBas(model.j.getJoueur()));
                    model.j.setScoreTotal(model.j.getJoueur(),model.j.getTotalScoreHaut(model.j.getJoueur()),model.j.getTotalScoreBas(model.j.getJoueur()));
                    String transToo= Integer.toString(model.j.getScoreTotal(model.j.getJoueur()));

                fen.esp[21][model.j.getJoueur()].setText(trans);
                fen.esp[22][model.j.getJoueur()].setText(transToo);
                    model.initcheckFalse(fen);

                   // model.verifcase(fen);
                    if (model.j.getJoueur() != model.j.getNbJoueur()) {

                        model.j.setJoueur();
                        model.verifTour(fen);
                    }
                    fen.Info3.setText(model.nomjoueur(model.j.getJoueur()));
                }
                else {fen.Info3.setText("Impossible case deja joué");}


            }

            if (e.getSource() == fen.Carre) {
                if (model.j.getJoueur() == model.j.getNbJoueur()) {
                    model.j.initJoueur();
                }
                if (fen.esp[14][model.j.getJoueur()].getText() == "_") {
                    fen.lancer.setVisible(true);
                model.d.initLancer();
                model.j.initScore(model.j.getJoueur());
                model.compAdd2(fen, 2, model.j.getJoueur());
                String esp1 = Integer.toString(model.j.getScore(model.j.getJoueur()));
                fen.esp[14][model.j.getJoueur()].setText(esp1);
                model.initCase(fen);
                    model.j.setTotalScoreBas(model.j.getJoueur(),model.j.getScore(model.j.getJoueur()));
                String trans = Integer.toString(model.j.getTotalScoreBas(model.j.getJoueur()));
                    model.j.setScoreTotal(model.j.getJoueur(),model.j.getTotalScoreHaut(model.j.getJoueur()),model.j.getTotalScoreBas(model.j.getJoueur()));
                    String transToo= Integer.toString(model.j.getScoreTotal(model.j.getJoueur()));

                fen.esp[21][model.j.getJoueur()].setText(trans);
                    fen.esp[22][model.j.getJoueur()].setText(transToo);
                    //model.verifcase(fen);
                    model.initcheckFalse(fen);

                    if (model.j.getJoueur() != model.j.nbJoueur) {

                        model.j.setJoueur();
                        model.verifTour(fen);
                    }
                    fen.Info3.setText(model.nomjoueur(model.j.getJoueur()));
                }
                else {fen.Info3.setText("Impossible case deja joué");}

            }

            if (e.getSource() == fen.Full) {
                if (model.j.getJoueur() == model.j.nbJoueur) {
                    model.j.initJoueur();
                }
                if (fen.esp[15][model.j.getJoueur()].getText() == "_") {
                    fen.lancer.setVisible(true);
                model.d.initLancer();
                model.j.initScore(model.j.getJoueur());
                model.compAdd2(fen, 3, model.j.getJoueur());
                String esp1 = Integer.toString(model.j.getScore(model.j.getJoueur()));
                fen.esp[15][model.j.getJoueur()].setText(esp1);
                model.initCase(fen);
                model.j.setTotalScoreBas(model.j.getJoueur(),model.j.getScore(model.j.getJoueur()));
                String trans = Integer.toString(model.j.getTotalScoreBas(model.j.getJoueur()));
                    model.j.setScoreTotal(model.j.getJoueur(),model.j.getTotalScoreHaut(model.j.getJoueur()),model.j.getTotalScoreBas(model.j.getJoueur()));
                    String transToo= Integer.toString(model.j.getScoreTotal(model.j.getJoueur()));

                fen.esp[21][model.j.getJoueur()].setText(trans);
                    fen.esp[22][model.j.getJoueur()].setText(transToo);

                    model.initcheckFalse(fen);

                    if (model.j.getJoueur() != model.j.getNbJoueur()) {

                        model.j.setJoueur();
                        model.verifTour(fen);
                    }
                    fen.Info3.setText(model.nomjoueur(model.j.getJoueur()));
                }
                else {fen.Info3.setText("Impossible case deja joué");}


            }

            if (e.getSource() == fen.PSuite) {
                if (model.j.getJoueur() == model.j.getNbJoueur()) {
                    model.j.initJoueur();
                }
                if (fen.esp[16][model.j.getJoueur()].getText() == "_") {
                    fen.lancer.setVisible(true);
                model.d.initLancer();
                model.j.initScore(model.j.getJoueur());
                model.compAdd2(fen, 4, model.j.getJoueur());
                String esp1 = Integer.toString(model.j.getScore(model.j.getJoueur()));
                fen.esp[16][model.j.getJoueur()].setText(esp1);
                model.initCase(fen);
                model.j.setTotalScoreBas(model.j.getJoueur(),model.j.getScore(model.j.getJoueur()));
                String trans = Integer.toString(model.j.getTotalScoreBas(model.j.getJoueur()));
                    model.j.setScoreTotal(model.j.getJoueur(),model.j.getTotalScoreHaut(model.j.getJoueur()),model.j.getTotalScoreBas(model.j.getJoueur()));
                    String transToo= Integer.toString(model.j.getScoreTotal(model.j.getJoueur()));

                fen.esp[21][model.j.getJoueur()].setText(trans);
                    fen.esp[22][model.j.getJoueur()].setText(transToo);

                    model.initcheckFalse(fen);

                    if (model.j.getJoueur() != model.j.getNbJoueur()) {

                        model.j.setJoueur();
                        model.verifTour(fen);
                    }
                    fen.Info3.setText(model.nomjoueur(model.j.getJoueur()));
                }
                else {fen.Info3.setText("Impossible case deja joué");}


            }

            if (e.getSource() == fen.GSuite) {
                if (model.j.getJoueur() == model.j.nbJoueur) {
                    model.j.initJoueur();
                }
                if (fen.esp[17][model.j.getJoueur()].getText() == "_") {
                    fen.lancer.setVisible(true);
                model.d.initLancer();
                model.j.initScore(model.j.getJoueur());
                model.compAdd2(fen, 5, model.j.getJoueur());
                String esp1 = Integer.toString(model.j.getScore(model.j.getJoueur()));
                fen.esp[17][model.j.getJoueur()].setText(esp1);
                model.initCase(fen);
                model.j.setTotalScoreBas(model.j.getJoueur(),model.j.getScore(model.j.getJoueur()));
                String trans = Integer.toString(model.j.getTotalScoreBas(model.j.getJoueur()));
                    model.j.setScoreTotal(model.j.getJoueur(),model.j.getTotalScoreHaut(model.j.getJoueur()),model.j.getTotalScoreBas(model.j.getJoueur()));
                    String transToo= Integer.toString(model.j.getScoreTotal(model.j.getJoueur()));

                fen.esp[21][model.j.getJoueur()].setText(trans);
                    fen.esp[22][model.j.getJoueur()].setText(transToo);
                   // model.verifcase(fen);
                    model.initcheckFalse(fen);

                    if (model.j.getJoueur() != model.j.nbJoueur) {

                        model.j.setJoueur();
                        model.verifTour(fen);
                    }
                    fen.Info3.setText(model.nomjoueur(model.j.getJoueur()));
                    }
                else {fen.Info3.setText("Impossible case deja joué");}


            }


            if (e.getSource() == fen.Yahtzee) {
                if (model.j.getJoueur() == model.j.getNbJoueur()) {
                    model.j.initJoueur();
                }
                if (fen.esp[18][model.j.getJoueur()].getText() == "_") {
                    fen.lancer.setVisible(true);
                model.d.initLancer();
                model.j.initScore(model.j.getJoueur());
                model.compAdd2(fen, 6, model.j.getJoueur());
                String esp1 = Integer.toString(model.j.getScore(model.j.getJoueur()));
                    if(esp1!="0"){
                        fen.esp[18][model.j.getJoueur()].setText(esp1);
                    }
                model.initCase(fen);
                fen.esp[18][model.j.getJoueur()].setText(esp1);

                model.j.setTotalScoreBas(model.j.getJoueur(),model.j.getScore(model.j.getJoueur()));
                String trans = Integer.toString(model.j.getTotalScoreBas(model.j.getJoueur()));
                    model.j.setScoreTotal(model.j.getJoueur(),model.j.getTotalScoreHaut(model.j.getJoueur()),model.j.getTotalScoreBas(model.j.getJoueur()));
                    String transToo= Integer.toString(model.j.getScoreTotal(model.j.getJoueur()));

                fen.esp[21][model.j.getJoueur()].setText(trans);
                    fen.esp[22][model.j.getJoueur()].setText(transToo);

                    model.initcheckFalse(fen);
                 //   model.verifcase(fen);
                    if (model.j.getJoueur() != model.j.nbJoueur) {

                        model.j.setJoueur();
                        model.verifTour(fen);
                    }
                    fen.Info3.setText(model.nomjoueur(model.j.getJoueur()));
                    }
                else {fen.Info3.setText("Impossible case deja joué");}

            }

            if (e.getSource() == fen.Chance) {
                if (model.j.getJoueur() == model.j.nbJoueur) {
                    model.j.initJoueur();
                }
                if (fen.esp[19][model.j.getJoueur()].getText() == "_") {
                    fen.lancer.setVisible(true);
                model.d.initLancer();
                model.j.initScore(model.j.getJoueur());
                model.compAdd2(fen, 7, model.j.getJoueur());
                    model.initCase(fen);

                String esp1 = Integer.toString(model.j.getScore(model.j.getJoueur()));
                fen.esp[19][model.j.getJoueur()].setText(esp1);
                //model.initCase(fen);

                    model.j.setTotalScoreBas(model.j.getJoueur(),model.j.getScore(model.j.getJoueur()));

                    String trans = Integer.toString(model.j.getTotalScoreBas(model.j.getJoueur()));

                    model.j.setScoreTotal(model.j.getJoueur(),model.j.getTotalScoreHaut(model.j.getJoueur()),model.j.getTotalScoreBas(model.j.getJoueur()));
                    String transToo= Integer.toString(model.j.getScoreTotal(model.j.getJoueur()));

                    fen.esp[21][model.j.getJoueur()].setText(trans);
                    fen.esp[22][model.j.getJoueur()].setText(transToo);
                  //  model.verifcase(fen);
                    model.initcheckFalse(fen);

                    if (model.j.getJoueur() != model.j.getNbJoueur()) {

                        model.j.setJoueur();
                        model.verifTour(fen);
                    }
                    fen.Info3.setText(model.nomjoueur(model.j.getJoueur()));
                    }
                else {fen.Info3.setText("Impossible case deja joué");}


            }


    }
}

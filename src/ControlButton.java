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
        totalup = new int[model.getNbJoueur()];
        int sortie[] = new int[6];
        JLabel dé1, dé2, dé3, dé4, dé5;


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

            if (model.t == model.participant.size()) {
                model.t = 0;
            }
            System.out.println("t  = " + model.t + " joueur " + model.participant.get(model.t) + " taille de liste : " + model.participant.size());
            if (fen.esp[1][model.participant.get(model.t).getJoueur()].getText() == "_") {//le if est pour éviter d'écrire deux fois dans la même case
                fen.lancer.setVisible(true);///remet la touche de lancer
                model.d.initLancer();//initialise le lancer
                model.participant.get(model.t).initScore();//initialisation de la somme

                if (model.participant.get(model.t).getTotalScoreHaut() >= 63 && model.participant.get(model.t).getTrenteCinq() == true) {//mise ne place de la verife si la prime de 35 point est valide
                    model.participant.get(model.t).setTotalScoreHaut(35);                                                      ///a repeter pour chaque touche
                    model.participant.get(model.t).setPrimeTrenteCinq();
                    fen.esp[8][model.t].setText("35");
                }
                int temp = model.compAdd(fen, 1);
                String esp1 = Integer.toString(temp);////on transforme en string
                fen.esp[1][model.t].setText(esp1);//on insert le text dans la fenetre
                model.initCase(fen);//on remet les des et les check a zero
                model.initcheckFalse(fen);
                model.participant.get(model.t).setTotalScoreHaut(temp);//on update le score pour la partie haute
                model.participant.get(model.t).setScoreTotal(temp);
                String trans = Integer.toString(model.participant.get(model.t).getTotalScoreHaut());//transformation en string
                String transToo = Integer.toString(model.participant.get(model.t).getScoreTotal());
                fen.esp[7][model.t].setText(trans);//insertion dans fentre
                fen.esp[9][model.t].setText(trans);//la aussi
                fen.esp[22][model.t].setText(transToo);
                model.verifTour(fen);

                if (model.t != model.participant.size()) {
                    model.t = model.t + 1;
                    System.out.println("t 1end=" + model.t);
                    model.verifTour(fen);
                }
                fen.Info3.setText(model.nomjoueur(model.j.getJoueur()));
            } else {
                fen.Info3.setText("Impossible case deja joué");
            }//ET LA LE CAS OU SI LA CASE EST DEJA REMPLI


        }


        if (e.getSource() == fen.TotalDeux) {//////////////////////////////////////////////////////////////


            if (model.t == model.participant.size()) {
                model.t = 0;
            }
            if (fen.esp[2][model.t].getText() == "_") {
                fen.lancer.setVisible(true);///remet la touche de lancer
                model.d.initLancer();//initialise le lancer
                model.participant.get(model.t).initScore();//initialisation de la somme

                int temp = model.compAdd(fen, 2);
                model.participant.get(model.t).setTotalScoreHaut(temp);//on update le score pour la partie haute

                if (model.participant.get(model.t).getTotalScoreHaut() >= 63 && model.participant.get(model.t).getTrenteCinq() == true) {//mise ne place de la verife si la prime de 35 point est valide
                    model.participant.get(model.t).setTotalScoreHaut(35);                                                      ///a repeter pour chaque touche
                    model.participant.get(model.t).setPrimeTrenteCinq();
                    fen.esp[8][model.t].setText("35");
                }
                String esp1 = Integer.toString(temp);
                fen.esp[2][model.t].setText(esp1);
                model.initCase(fen);
                //on insert le text dans la fenetre
                model.initCase(fen);//on remet les des et les check a zero
                model.initcheckFalse(fen);
                model.participant.get(model.t).setScoreTotal(temp);
                String trans = Integer.toString(model.participant.get(model.t).getTotalScoreHaut());//transformation en string
                String transToo = Integer.toString(model.participant.get(model.t).getScoreTotal());
                fen.esp[7][model.t].setText(trans);
                fen.esp[9][model.t].setText(trans);
                fen.esp[22][model.t].setText(transToo);
                //  model.verifcase(fen);
                model.initcheckFalse(fen);

                if (model.t != model.participant.size()) {
                    model.t = model.t + 1;
                    System.out.println("t end =" + model.t);
                    model.verifTour(fen);
                }
            } else {
                fen.Info3.setText("Impossible case deja joué");
            }

        }

        if (e.getSource() == fen.TotalTrois) {


            if (model.t == model.participant.size()) {
                model.t = 0;
            }

            if (model.t == model.participant.size()) {
                model.t = 0;
            }
            if (fen.esp[3][model.t].getText() == "_") {
                fen.lancer.setVisible(true);///remet la touche de lancer
                model.d.initLancer();//initialise le lancer
                model.participant.get(model.t).initScore();//initialisation de la somme

                int temp = model.compAdd(fen, 3);
                model.participant.get(model.t).setTotalScoreHaut(temp);//on update le score pour la partie haute

                if (model.participant.get(model.t).getTotalScoreHaut() >= 63 && model.participant.get(model.t).getTrenteCinq() == true) {//mise ne place de la verife si la prime de 35 point est valide
                    model.participant.get(model.t).setTotalScoreHaut(35);                                                      ///a repeter pour chaque touche
                    model.participant.get(model.t).setPrimeTrenteCinq();
                    fen.esp[8][model.t].setText("35");
                }
                String esp1 = Integer.toString(temp);
                fen.esp[3][model.t].setText(esp1);
                model.initCase(fen);
                //on insert le text dans la fenetre
                model.initCase(fen);//on remet les des et les check a zero
                model.initcheckFalse(fen);
                model.participant.get(model.t).setScoreTotal(temp);
                String trans = Integer.toString(model.participant.get(model.t).getTotalScoreHaut());//transformation en string
                String transToo = Integer.toString(model.participant.get(model.t).getScoreTotal());
                fen.esp[7][model.t].setText(trans);
                fen.esp[9][model.t].setText(trans);
                fen.esp[22][model.t].setText(transToo);
                //  model.verifcase(fen);
                model.initcheckFalse(fen);

                if (model.t != model.participant.size()) {
                    model.t = model.t + 1;
                    System.out.println("t end =" + model.t);
                    model.verifTour(fen);
                }
            } else {
                fen.Info3.setText("Impossible case deja joué");
            }

        }

        if (e.getSource() == fen.TotalQuatre) {

            if (model.t == model.participant.size()) {
                model.t = 0;
            }
            if (fen.esp[4][model.t].getText() == "_") {
                fen.lancer.setVisible(true);///remet la touche de lancer
                model.d.initLancer();//initialise le lancer
                model.participant.get(model.t).initScore();//initialisation de la somme

                int temp = model.compAdd(fen, 4);
                model.participant.get(model.t).setTotalScoreHaut(temp);//on update le score pour la partie haute

                if (model.participant.get(model.t).getTotalScoreHaut() >= 63 && model.participant.get(model.t).getTrenteCinq() == true) {//mise ne place de la verife si la prime de 35 point est valide
                    model.participant.get(model.t).setTotalScoreHaut(35);                                                      ///a repeter pour chaque touche
                    model.participant.get(model.t).setPrimeTrenteCinq();
                    fen.esp[8][model.t].setText("35");
                }
                String esp1 = Integer.toString(temp);
                fen.esp[4][model.t].setText(esp1);
                model.initCase(fen);
                //on insert le text dans la fenetre
                model.initCase(fen);//on remet les des et les check a zero
                model.initcheckFalse(fen);
                model.participant.get(model.t).setScoreTotal(temp);
                String trans = Integer.toString(model.participant.get(model.t).getTotalScoreHaut());//transformation en string
                String transToo = Integer.toString(model.participant.get(model.t).getScoreTotal());
                fen.esp[7][model.t].setText(trans);
                fen.esp[9][model.t].setText(trans);
                fen.esp[22][model.t].setText(transToo);
                //  model.verifcase(fen);
                model.initcheckFalse(fen);

                if (model.t != model.participant.size()) {
                    model.t = model.t + 1;
                    System.out.println("t end =" + model.t);
                    model.verifTour(fen);
                }
            } else {
                fen.Info3.setText("Impossible case deja joué");
            }

        }

        if (e.getSource() == fen.TotalCinq) {

            System.out.println("5 actif");
            if (model.t == model.participant.size()) {
                model.t = 0;
            }
            if (fen.esp[5][model.t].getText() == "_") {
                fen.lancer.setVisible(true);///remet la touche de lancer
                model.d.initLancer();//initialise le lancer
                model.participant.get(model.t).initScore();//initialisation de la somme

                int temp = model.compAdd(fen, 5);
                model.participant.get(model.t).setTotalScoreHaut(temp);//on update le score pour la partie haute

                if (model.participant.get(model.t).getTotalScoreHaut() >= 63 && model.participant.get(model.t).getTrenteCinq() == true) {//mise ne place de la verife si la prime de 35 point est valide
                    model.participant.get(model.t).setTotalScoreHaut(35);                                                      ///a repeter pour chaque touche
                    model.participant.get(model.t).setPrimeTrenteCinq();
                    fen.esp[8][model.t].setText("35");
                }
                String esp1 = Integer.toString(temp);
                fen.esp[5][model.t].setText(esp1);
                model.initCase(fen);
                //on insert le text dans la fenetre
                model.initCase(fen);//on remet les des et les check a zero
                model.initcheckFalse(fen);
                model.participant.get(model.t).setScoreTotal(temp);
                String trans = Integer.toString(model.participant.get(model.t).getTotalScoreHaut());//transformation en string
                String transToo = Integer.toString(model.participant.get(model.t).getScoreTotal());
                fen.esp[7][model.t].setText(trans);
                fen.esp[9][model.t].setText(trans);
                fen.esp[22][model.t].setText(transToo);
                //  model.verifcase(fen);
                model.initcheckFalse(fen);

                if (model.t != model.participant.size()) {
                    model.t = model.t + 1;
                    System.out.println("t end =" + model.t);
                    model.verifTour(fen);
                }
            } else {
                fen.Info3.setText("Impossible case deja joué");
            }

            System.out.println("5 actif");
        }

        if (e.getSource() == fen.TotalSix) {

            if (model.t == model.participant.size()) {
                model.t = 0;
            }
            if (fen.esp[6][model.t].getText() == "_") {
                fen.lancer.setVisible(true);///remet la touche de lancer
                model.d.initLancer();//initialise le lancer
                model.participant.get(model.t).initScore();//initialisation de la somme

                int temp = model.compAdd(fen, 6);
                model.participant.get(model.t).setTotalScoreHaut(temp);//on update le score pour la partie haute

                if (model.participant.get(model.t).getTotalScoreHaut() >= 63 && model.participant.get(model.t).getTrenteCinq() == true) {//mise ne place de la verife si la prime de 35 point est valide
                    model.participant.get(model.t).setTotalScoreHaut(35);                                                      ///a repeter pour chaque touche
                    model.participant.get(model.t).setPrimeTrenteCinq();
                    fen.esp[8][model.t].setText("35");
                }
                String esp1 = Integer.toString(temp);
                fen.esp[6][model.t].setText(esp1);
                model.initCase(fen);
                //on insert le text dans la fenetre
                model.initCase(fen);//on remet les des et les check a zero
                model.initcheckFalse(fen);
                model.participant.get(model.t).setScoreTotal(temp);
                String trans = Integer.toString(model.participant.get(model.t).getTotalScoreHaut());//transformation en string
                String transToo = Integer.toString(model.participant.get(model.t).getScoreTotal());
                fen.esp[7][model.t].setText(trans);
                fen.esp[9][model.t].setText(trans);
                fen.esp[22][model.t].setText(transToo);
                //  model.verifcase(fen);
                model.initcheckFalse(fen);

                if (model.t != model.participant.size()) {
                    model.t = model.t + 1;
                    System.out.println("t end =" + model.t);
                    model.verifTour(fen);
                }
            } else {
                fen.Info3.setText("Impossible case deja joué");
            }

            // model.verifcase(fen);
        }


        ////partie basse be quiet

        if (e.getSource() == fen.Brelan) {

            if (model.t == model.participant.size()) {
                model.t = 0;
            }
            if (fen.esp[13][model.t].getText() == "_") {
                fen.lancer.setVisible(true);
                model.d.initLancer();
                model.participant.get(model.t).initScore();
                int temp = model.compAdd2(fen, 1);
                String esp1 = Integer.toString(temp);
                fen.esp[13][model.t].setText(esp1);
                model.initCase(fen);
                model.participant.get(model.t).setTotalScoreBas(temp);
                model.participant.get(model.t).setScoreTotal(temp);
                String trans = Integer.toString(model.participant.get(model.t).getTotalScoreBas());
                String transToo = Integer.toString(model.participant.get(model.t).getScoreTotal());

                fen.esp[21][model.t].setText(trans);
                fen.esp[22][model.t].setText(transToo);
                model.initcheckFalse(fen);

                // model.verifcase(fen);
                if (model.t != model.participant.size()) {
                    model.t = model.t + 1;
                    System.out.println("t end =" + model.t);
                    model.verifTour(fen);
                }
                //fen.Info3.setText(model.nomjoueur(model.j.getJoueur()));
            } else {
                fen.Info3.setText("Impossible case deja joué");
            }


        }

        if (e.getSource() == fen.Carre) {
            if (model.t == model.participant.size()) {
                model.t = 0;
            }
            if (fen.esp[14][model.t].getText() == "_") {
                fen.lancer.setVisible(true);
                model.d.initLancer();
                model.participant.get(model.t).initScore();
                int temp = model.compAdd2(fen, 2);
                String esp1 = Integer.toString(temp);
                fen.esp[14][model.t].setText(esp1);
                model.initCase(fen);
                model.participant.get(model.t).setTotalScoreBas(temp);
                model.participant.get(model.t).setScoreTotal(temp);
                String trans = Integer.toString(model.participant.get(model.t).getTotalScoreBas());
                String transToo = Integer.toString(model.participant.get(model.t).getScoreTotal());

                fen.esp[21][model.t].setText(trans);
                fen.esp[22][model.t].setText(transToo);
                model.initcheckFalse(fen);

                // model.verifcase(fen);
                if (model.t != model.participant.size()) {
                    model.t = model.t + 1;
                    System.out.println("t end =" + model.t);
                    model.verifTour(fen);
                }
                //fen.Info3.setText(model.nomjoueur(model.j.getJoueur()));
            } else {
                fen.Info3.setText("Impossible case deja joué");
            }

        }

        if (e.getSource() == fen.Full) {
            if (model.t == model.participant.size()) {
                model.t = 0;
            }
            if (fen.esp[15][model.t].getText() == "_") {
                fen.lancer.setVisible(true);
                model.d.initLancer();
                model.participant.get(model.t).initScore();
                int temp = model.compAdd2(fen, 3);
                String esp1 = Integer.toString(temp);
                fen.esp[15][model.t].setText(esp1);
                model.initCase(fen);
                model.participant.get(model.t).setTotalScoreBas(temp);
                model.participant.get(model.t).setScoreTotal(temp);
                String trans = Integer.toString(model.participant.get(model.t).getTotalScoreBas());
                String transToo = Integer.toString(model.participant.get(model.t).getScoreTotal());

                fen.esp[21][model.t].setText(trans);
                fen.esp[22][model.t].setText(transToo);
                model.initcheckFalse(fen);

                // model.verifcase(fen);
                if (model.t != model.participant.size()) {
                    model.t = model.t + 1;
                    System.out.println("t end =" + model.t);
                    model.verifTour(fen);
                }
                //fen.Info3.setText(model.nomjoueur(model.j.getJoueur()));
            } else {
                fen.Info3.setText("Impossible case deja joué");
            }


        }

        if (e.getSource() == fen.PSuite) {
            if (model.t == model.participant.size()) {
                model.t = 0;
            }
            if (fen.esp[16][model.t].getText() == "_") {
                fen.lancer.setVisible(true);
                model.d.initLancer();
                model.participant.get(model.t).initScore();
                int temp = model.compAdd2(fen, 4);
                String esp1 = Integer.toString(temp);
                fen.esp[16][model.t].setText(esp1);
                model.initCase(fen);
                model.participant.get(model.t).setTotalScoreBas(temp);
                model.participant.get(model.t).setScoreTotal(temp);
                String trans = Integer.toString(model.participant.get(model.t).getTotalScoreBas());
                String transToo = Integer.toString(model.participant.get(model.t).getScoreTotal());

                fen.esp[21][model.t].setText(trans);
                fen.esp[22][model.t].setText(transToo);
                model.initcheckFalse(fen);

                // model.verifcase(fen);
                if (model.t != model.participant.size()) {
                    model.t = model.t + 1;
                    System.out.println("t end =" + model.t);
                    model.verifTour(fen);
                }
                //fen.Info3.setText(model.nomjoueur(model.j.getJoueur()));
            } else {
                fen.Info3.setText("Impossible case deja joué");
            }


        }

        if (e.getSource() == fen.GSuite) {
            if (model.t == model.participant.size()) {
                model.t = 0;
            }
            if (fen.esp[17][model.t].getText() == "_") {
                fen.lancer.setVisible(true);
                model.d.initLancer();
                model.participant.get(model.t).initScore();
                int temp = model.compAdd2(fen, 5);
                String esp1 = Integer.toString(temp);
                fen.esp[17][model.t].setText(esp1);
                model.initCase(fen);
                model.participant.get(model.t).setTotalScoreBas(temp);
                model.participant.get(model.t).setScoreTotal(temp);
                String trans = Integer.toString(model.participant.get(model.t).getTotalScoreBas());
                String transToo = Integer.toString(model.participant.get(model.t).getScoreTotal());

                fen.esp[21][model.t].setText(trans);
                fen.esp[22][model.t].setText(transToo);
                model.initcheckFalse(fen);

                // model.verifcase(fen);
                if (model.t != model.participant.size()) {
                    model.t = model.t + 1;
                    System.out.println("t end =" + model.t);
                    model.verifTour(fen);
                }
                //fen.Info3.setText(model.nomjoueur(model.j.getJoueur()));
            } else {
                fen.Info3.setText("Impossible case deja joué");
            }


        }


        if (e.getSource() == fen.Yahtzee) {
            if (model.t == model.participant.size()) {
                model.t = 0;
            }
            if (fen.esp[18][model.t].getText() == "_") {
                fen.lancer.setVisible(true);
                model.d.initLancer();
                model.participant.get(model.t).initScore();
                int temp = model.compAdd2(fen, 6);
                String esp1 = Integer.toString(temp);
                fen.esp[18][model.t].setText(esp1);
                model.initCase(fen);
                model.participant.get(model.t).setTotalScoreBas(temp);
                model.participant.get(model.t).setScoreTotal(temp);
                String trans = Integer.toString(model.participant.get(model.t).getTotalScoreBas());
                String transToo = Integer.toString(model.participant.get(model.t).getScoreTotal());

                fen.esp[21][model.t].setText(trans);
                fen.esp[22][model.t].setText(transToo);
                model.initcheckFalse(fen);

                // model.verifcase(fen);
                if (model.t != model.participant.size()) {
                    model.t = model.t + 1;
                    System.out.println("t end =" + model.t);
                    model.verifTour(fen);
                }
                //fen.Info3.setText(model.nomjoueur(model.j.getJoueur()));
            } else {
                fen.Info3.setText("Impossible case deja joué");
            }

        }

        if (e.getSource() == fen.Chance) {
            if (model.t == model.participant.size()) {
                model.t = 0;
            }
            if (fen.esp[19][model.t].getText() == "_") {
                fen.lancer.setVisible(true);
                model.d.initLancer();
                model.participant.get(model.t).initScore();
                int temp = model.compAdd2(fen, 7);
                String esp1 = Integer.toString(temp);
                fen.esp[19][model.t].setText(esp1);
                model.initCase(fen);
                model.participant.get(model.t).setTotalScoreBas(temp);
                model.participant.get(model.t).setScoreTotal(temp);
                String trans = Integer.toString(model.participant.get(model.t).getTotalScoreBas());
                String transToo = Integer.toString(model.participant.get(model.t).getScoreTotal());

                fen.esp[21][model.t].setText(trans);
                fen.esp[22][model.t].setText(transToo);
                model.initcheckFalse(fen);

                // model.verifcase(fen);
                if (model.t != model.participant.size()) {
                    model.t = model.t + 1;
                    System.out.println("t end =" + model.t);
                    model.verifTour(fen);
                }
                //fen.Info3.setText(model.nomjoueur(model.j.getJoueur()));
            } else {
                fen.Info3.setText("Impossible case deja joué");
            }


        }
    }

    }


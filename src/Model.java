import com.sun.deploy.util.SystemUtils;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Created by nico on 08/11/15.
 */
public class Model {

    protected Joueur j;
    protected De d;
    protected Score s;
    protected int v, w, x, y, z, type;
    protected int tri[];

    protected ImageIcon face[]={new ImageIcon("/images/0.png"),//premier image vide pour que la liste icone sois correct
            new ImageIcon("/images/1.png"),new ImageIcon("/images/2.png")
            ,new ImageIcon("/images/3.png"),new ImageIcon("/images/4.png")
            ,new ImageIcon("/images/5.png"),new ImageIcon("/images/6.png")};//non utilisé a integré dans version 2

    protected ArrayList<Image> de0, de1, de2, de3, de4, de5, de6;
    Toolkit tk = Toolkit.getDefaultToolkit();

    String cho="";
    int TabRemp;
    int caseActu;

    public Model() {
        j = new Joueur();
        d = new De();
        s = new Score();
        tri = new int[5];
        TabRemp=19*j.getNbJoueur();
        caseActu=0;
        for (int i = 0; i <j.getJoueur() ; i++) {//initialisation de case en bool pour la prime de 35
            s.initPrimeTrenteCinq(i);
        }
    }

    //petit reset de case dans la partir de lancer
    public void initCase(Fenetre fen) {
        fen.dé1.setText("_");
        fen.dé2.setText("_");
        fen.dé3.setText("_");
        fen.dé4.setText("_");
        fen.dé5.setText("_");
        fen.A1.setSelected(false);
        fen.A2.setSelected(false);
        fen.A3.setSelected(false);
        fen.A4.setSelected(false);
        fen.A5.setSelected(false);
    }

    public void brelan(int t[], int joueur) {
        if ((t[0] == t[1] && t[1] == t[2]) || (t[1] == t[2] && t[2] == t[3]) || (t[2] == t[3] && t[3] == t[4])) {
            s.setScore(j.getJoueur(),(t[0]+t[1]+t[2]+t[3]+t[4]));
        } else {
            s.setScore(j.getJoueur(), 0);
        }
    }

    public void carre(int t[], int joueur) {

        if ((t[0] == t[1] && t[1] == t[2] && t[2] == t[3]) || (t[1] == t[2] && t[2] == t[3] && t[3] == t[4])) {
            s.setScore(j.getJoueur(), (t[0]+t[1]+t[2]+t[3]+t[4]));
        } else {
            s.setScore(j.getJoueur(), 0);
        }

    }


    public void full(int t[], int joueur) {
        for (int i = 0; i < 3; i++) {
            if (t[i] == t[i + 1] && t[i + 1] == t[i + 2]) {
                s.setScore(j.getJoueur(), 25);
            } else {
                s.setScore(j.getJoueur(), 0);
            }
        }
    }

    public void Psuite(int t[], int joueur) {//version propre
    // gestion des doublons
        for (int i = 0; i <t.length-1 ; i++) {
            if(t[i]==t[i+1]){t[i+1]=8;}
        }
        Arrays.sort(t);
        //verif de suite
        for (int i = 0; i < 2; i++) {
            if (t[i]==t[i+1]-1 && t[i+1]==t[i+2]-1 && t[i+2]==t[i+3]-1 ) {
                s.setScore(j.getJoueur(), 30);
            } else {
                s.setScore(j.getJoueur(), 0);
            }
        }


    }

    public void Gsuite(int t[], int joueur) {//version propre
        for (int i = 0; i < 1; i++) {
            if (t[i]==t[i+1]-1 && t[i+1]==t[i+2]-1 && t[i+2]==t[i+3]-1 && t[i+3]==t[i+4]-1 ) {
                s.setScore(j.getJoueur(), 40);
            } else {
                s.setScore(j.getJoueur(), 0);
            }
        }

    }


    public void Yahtzee(int t[], int joueur) {
        int i = 0;
        if (t[i] == t[i + 1] && t[i + 1] == t[i + 2] && t[i + 2] == t[i + 3] && t[i + 3] == t[i + 4]) {
            s.setScore(j.getJoueur(), 50);
        } else {
            s.setScore(j.getJoueur(), 0);
        }

    }

    public void Chance(int t[], int joueur) {
        int somme=0;

        for (int i = 0; i < t.length; i++) {
            somme= somme+t[i];
        }
        s.setScore(j.getJoueur(), somme);
    }

    //verif etajout score de la partie sup
    public void compAdd(Fenetre fen, int i) {
        v = Integer.parseInt(fen.dé1.getText());
        w = Integer.parseInt(fen.dé2.getText());
        x = Integer.parseInt(fen.dé3.getText());
        y = Integer.parseInt(fen.dé4.getText());
        z = Integer.parseInt(fen.dé5.getText());
        if (v != i) {
            v = 0;
        }
        if (w != i) {
            w = 0;
        }
        if (x != i) {
            x = 0;
        }
        if (y != i) {
            y = 0;
        }
        if (z != i) {
            z = 0;
        }

        s.setScore(j.getJoueur(), z + x + y + v + w);
    }

    //methode pour partie inf recupe dans un tableau puis tri et enfin comparaison.
    //explication fen,pas besoin, C c'est le numero de ce qu'on veut verifier, joueur le num du joueur
    public void compAdd2(Fenetre fen, int c, int joueur) {
        tri[0] = Integer.parseInt(fen.dé1.getText());
        tri[1] = Integer.parseInt(fen.dé2.getText());
        tri[2] = Integer.parseInt(fen.dé3.getText());
        tri[3] = Integer.parseInt(fen.dé4.getText());
        tri[4] = Integer.parseInt(fen.dé5.getText());
        type = c;
        Arrays.sort(tri);///on tri le tableau

        switch (type) {//et selon ce qu'on veut verifier on donne le numero
            case 1://case du brelan
                brelan(tri, j.getJoueur());
                break;
            case 2:
                carre(tri, j.getJoueur());
                break;
            case 3:
                full(tri, j.getJoueur());
                break;
            case 4:
                Psuite(tri, j.getJoueur());
                break;
            case 5:
                Gsuite(tri, j.getJoueur());
                break;
            case 6:
                Yahtzee(tri, j.getJoueur());
                break;
            case 7:
                Chance(tri, j.getJoueur());
                break;
        }

        for (int i = 0; i < tri.length; i++) {
            System.out.print(tri[i]);
        }

    }

    //fonction pour verifié si toutes les case sont remplis donc que la partie est terminé.
    public void verifcase(Fenetre fen) {

        for (int i = 0; i < 22; i++) {
            for (int k = 0; k < 22; k++) {

                String comp= fen.esp[i][k].getText();
                if (comp != "_"&& comp!=" ") {
                    caseActu=caseActu+1;
					System.out.println(caseActu);
                }
                if(caseActu==TabRemp){
                    System.out.println("PARTIE TERMINE");
					fen.creerDialogue("partie finis");
                }
            }
        }
    }
        //fonction a reviser pour le l'affichage du joueur
    public String nomjoueur(int joueur) {

        switch (joueur) {
            case 0:
                return cho=" Tour de joueur qui n'existe pas";

            case 1:
                return cho="Tour du Joueur 1";

            case 2:
                return cho="Tour du Joueur 2";

            case 3:
                return cho="Tour du Joueur 3";

            case 4:
                return cho="Tour du joueur 4";

            case 5:
                return cho="Tour du Joueur 5";

            case 6:
                return cho="Tour du Joueur 6";

            default:System.out.println(" hors piste");
        }
        return cho;
    }

    public void initcheckFalse(Fenetre Fen){{
    Fen.A1.setEnabled(false);}
    Fen.A2.setEnabled(false);
    Fen.A3.setEnabled(false);
    Fen.A4.setEnabled(false);
    Fen.A5.setEnabled(false);
    }


    public void initcheckTrue(Fenetre Fen){{
        Fen.A1.setEnabled(true);}
        Fen.A2.setEnabled(true);
        Fen.A3.setEnabled(true);
        Fen.A4.setEnabled(true);
        Fen.A5.setEnabled(true);
    }



}



    




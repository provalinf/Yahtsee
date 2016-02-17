
import com.sun.deploy.util.SystemUtils;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by nico on 08/11/15.
 */
public class Model {


    protected Joueur j;
    protected Robo r;
    protected LinkedList<Joueur>participant;
    protected int nbJoueur;
    protected De d;
    //protected Score s;
    protected int v, w, x, y, z, type;
    protected int tri[];
    public int DELAY=4;
    int flag;
    boolean commut;
    String cho="";
    int TabRemp;
    int tour=0;
    public int t;

    public Model() {
        nbJoueur = 2;
        participant = new LinkedList<>();
        if(nbJoueur>=2) {
            for (int i = 0; i < nbJoueur; i++) {

                j = new Joueur(i);
                participant.add(j);
            }
        }else{ j = new Joueur(0);
            r = new Robo (1);
            participant.add(j);
            participant.add(r);}

        d = new De();
        tri = new int[5];
        TabRemp=19*nbJoueur;
        tour=0;
        t = 0;
    }

    public int getNbJoueur(){
        return nbJoueur;
    }

    //fonction pour definir le nb de joueur
    public void setNbJoueur(int i){
        nbJoueur=i;
    }

    public void videList(){ participant.clear();}
    public void resetT(){t=0;}

    public void newListe(int nbJoueur){
        resetT();
        participant.clear();
        if(nbJoueur==1){
            j = new Joueur(0);
            r = new Robo(1);
            participant.add(j);
            participant.add(r);
        }
        else {
            for (int i = 0; i < nbJoueur; i++) {
                j = new Joueur(i);
                participant.add(j);

            }
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

    public int brelan(int t[]) {//corrigé le comptage des point est maintenant correct et propre
        int result=0;
        for (int i = 0; i <=2 ; i++) {

            if (t[i] == t[i+1] && t[i+1] == t[i+2]) {

                result=((t[i]+t[i+1]+t[i+2])*3);
                break;
            } else {
                result = 0;
            }
        }
        return result;
    }

    public int carre(int t[]) {//corrigé le comptage des point est maintenant correct et propre
        int result=0;
        for (int i = 0; i <=1 ; i++) {

            if (t[i] == t[1+1] && t[i+1] == t[i+2]&& t[i+2] == t[i+3]) {
                result = ((t[i]+t[i+1]+t[i+2]+t[i+3])*4);
                break;
            } else {
                result = 0;
            }
        }
        return result;
    }


    public int full(int t[]) {
        int result = 0;
            if (t[0] == t[1] && t[1] == t[2] && t[3]==t[4]||//brelan + pair
            t[0] == t[1] && t[2] == t[3]&&t[3]==t[4]) {//paire+brelan
                result = 25;
            } else {
                result = 0;
            }
        return result;
    }

    public int Psuite(int t[]) {//corrigé le comptage des point est maintenant correct et propre
    // gestion des doublons
        int result = 0;

        for (int i = 0; i <t.length-1 ; i++) {
            if(t[i]==t[i+1]){t[i+1]=8;}
        }
        Arrays.sort(t);
        //verif de suite
        for (int i = 0; i < 2; i++) {
            if (t[i]==t[i+1]-1 && t[i+1]==t[i+2]-1 && t[i+2]==t[i+3]-1 ) {
                result = 30;
                break;
            } else {
                result = 0;
            }
        }
        return result;

    }

    public int Gsuite(int t[]) {//corrigé le comptage des point est maintenant correct et propre
        int result = 0;
        for (int i = 0; i < 1; i++) {
            if (t[i]==t[i+1]-1 && t[i+1]==t[i+2]-1 && t[i+2]==t[i+3]-1 && t[i+3]==t[i+4]-1 ) {
                result = 40;
                break;
            } else {
                result = 0;
            }
        }
        return result;
    }

    public int Yahtzee(int t[]) {
        int result = 0;
        int i = 0;
        if (t[i] == t[i + 1] && t[i + 1] == t[i + 2] && t[i + 2] == t[i + 3] && t[i + 3] == t[i + 4]) {
            result = 50;
        } else {
            result = 0;
        }
        return result;
    }

    public int Chance(int t[]) {
        int result = 0;
        int somme=0;

        for (int i = 0; i < t.length; i++) {
            somme= somme+t[i];
        }
        result  = somme;
        return result;
    }

    //verif etajout score de la partie sup
    public int compAdd(Fenetre fen, int i) {
        int somme = 0;
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

        somme = z + x + y + v + w;
        return somme;
    }

    //methode pour partie inf recupe dans un tableau puis tri et enfin comparaison.
    //explication fen,pas besoin, C c'est le numero de ce qu'on veut verifier, joueur le num du joueur
    public int compAdd2(Fenetre fen, int c) {
        int somme = 0;
        tri[0] = Integer.parseInt(fen.dé1.getText());
        tri[1] = Integer.parseInt(fen.dé2.getText());
        tri[2] = Integer.parseInt(fen.dé3.getText());
        tri[3] = Integer.parseInt(fen.dé4.getText());
        tri[4] = Integer.parseInt(fen.dé5.getText());
        type = c;
        Arrays.sort(tri);///on tri le tableau
        for (int i = 0; i <tri.length ; i++) {
        }

        switch (type) {//et selon ce qu'on veut verifier on donne le numero
            case 1://case du brelan
                somme = brelan(tri);
                break;
            case 2:
                somme = carre(tri);
                break;
            case 3:
                somme = full(tri);
                break;
            case 4:
                somme = Psuite(tri);
                break;
            case 5:
                somme = Gsuite(tri);
                break;
            case 6:
                somme = Yahtzee(tri);
                break;
            case 7:
                somme = Chance(tri);
                break;
        }
        return somme;

    }

    //fonction pour verifié si toutes les case sont remplis donc que la partie est terminé.
    public void verifTour(Fenetre fen) {
        tour=tour+1;
        System.out.println("tour = "+tour);
                if(tour==14*nbJoueur){
					fen.creerDialogue("Voulez vous continuez ?");
                }
    }

    public void initTour(){tour=0;}
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



    




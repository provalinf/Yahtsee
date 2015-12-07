/**
 * Created by nico on 01/12/15.
 */
public class Joueur {
    protected int J;
    protected int nbJoueur;
    public Joueur(){
        J=0;
        nbJoueur=2;
    }


    //ok
    public int getJoueur(){return J;}
    //ok
    public void setJoueur(){J=J+1;}
    //ok
    public void initJoueur(){J=0;}

    public int getNbJoueur(){
        return nbJoueur;
    }
    //fonction pour definir le nb de joueur
    public void setNbJoueur(int i){
        nbJoueur=i;
    }
}

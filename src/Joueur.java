/**
 * Created by nico on 01/12/15.
 */
public class Joueur {
    protected int J;
    protected int nbJoueur;
    protected int score[];
    protected int totalScoreHaut[];
    protected int totalScoreBas[];
    protected  boolean primeTrenteCinq[];
    protected int scoreTotal[];

    public Joueur(){
        J=0;
        nbJoueur=2;
        score = new int[6];
        totalScoreBas = new int[6];
        totalScoreHaut = new int[6];
        scoreTotal = new int[6];
        primeTrenteCinq =new boolean[6];

    }

    /*public Score(boolean[] trenteCinq) {

        score = new int[6];
        totalScoreBas = new int[6];
        totalScoreHaut = new int[6];
        scoreTotal = new int[6];
        primeTrenteCinq = new boolean[6];
        for (int i = 0; i < 6; i++) {
            primeTrenteCinq[i] = trenteCinq[i];
        }

    }*/


    //fonction basique pour la recupe et l'update du score des cases et l'initialisation biensure
    public int getScore(int i){return score[i];}

    public void setScore(int i, int point){ score[i]=score[i]+point;}

    public void initScore(int i){score[i]=0;}

    //fonction pour le prime de 35
    public Boolean getTrenteCinq(int j){
        return primeTrenteCinq[j];
    }

    public void initPrimeTrenteCinq(int j){
        primeTrenteCinq[j]= true;
    }

    public void setPrimeTrenteCinq(int j){
        primeTrenteCinq[j]= false;
    }

    public int getTotalScoreHaut(int i){return totalScoreHaut[i];}

    public void setTotalScoreHaut(int i, int point){ totalScoreHaut[i]=totalScoreHaut[i]+point;}
    //et le bas
    public int getTotalScoreBas(int i){return totalScoreBas[i];}

    public void setTotalScoreBas(int i, int point){ totalScoreBas[i]=totalScoreBas[i]+point;}

    //et le score final
    public int getScoreTotal(int i){return scoreTotal[i];}

    public void setScoreTotal(int i,int j,int k){ scoreTotal[i]=j+k;}///on remplis la case final avec le sore total du haut et bas
    //public void setScoreTotal(int i,int j,int k){ scoreTotal[i]=scoreTotal[i]+j+k;}

    public void initTous(){//initialisation detous les scores
        for (int j = 0; j < 6; j++) {
            scoreTotal[j]=0;
            totalScoreHaut[j]=0;
            totalScoreBas[j]=0;
        }
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

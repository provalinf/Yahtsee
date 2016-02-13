/**
 * Created by nico on 01/12/15.
 */
public class Joueur {
    protected int J;
    protected int score;
    protected  int numero;
    protected int totalScoreHaut;
    protected int totalScoreBas;
    protected  boolean primeTrenteCinq;
    protected int scoreTotal;

    public Joueur(int n){
        this.J= n;
        score = 0;
        numero = n+1;
        totalScoreBas = 0;
        totalScoreHaut = 0;
        scoreTotal = 0;
        primeTrenteCinq = true ;

    }
    public int getNum(){return this.numero;}
    //fonction basique pour la recupe et l'update du score des cases et l'initialisation biensure
    public int getScore(){return this.score;}

    public void setScore(int point){ this.score= this.score+point;}

    public void initScore(){score=0;}

    //fonction pour le prime de 35
    public Boolean getTrenteCinq(){
        return this.primeTrenteCinq;
    }

    public void initPrimeTrenteCinq(){
        this.primeTrenteCinq= true;
    }

    public void setPrimeTrenteCinq(){
        this.primeTrenteCinq= false;
    }

    public int getTotalScoreHaut(){return this.totalScoreHaut;}

    public void setTotalScoreHaut(int point){ this.totalScoreHaut=this.totalScoreHaut+point;}
    //et le bas
    public int getTotalScoreBas(){return this.totalScoreBas;}

    public void setTotalScoreBas(int point){ this.totalScoreBas=this.totalScoreBas+point;}

    //et le score final
    public int getScoreTotal(){return this.scoreTotal;}

    public void setScoreTotal(int j){ this.scoreTotal=this.scoreTotal+j;}///on remplis la case final avec le sore total du haut et bas

   /* public void initTous(){//initialisation detous les scores
        for (int j = 0; j < 6; j++) {
            scoreTotal[j]=0;
            totalScoreHaut[j]=0;
            totalScoreBas[j]=0;
        }
    }*/
    //ok
    public int getJoueur(){return this.J;}
    //ok
    //public void setJoueur(){this.J=J+1;}
    //ok
    //public void initJoueur(){J=0;}

}

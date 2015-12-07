/**
 * Created by nico on 02/12/15.
 */
public class Score {

    protected int score[];
    protected int totalScoreHaut[];
    protected int totalScoreBas[];

    public Score(){
        score = new int[6];
        totalScoreBas = new int[6];
        totalScoreHaut = new int[6];

    }
    //fonction basique pour la recupe et l'update du score des cases et l'initialisation biensure
    public int getScore(int i){return score[i];}

    public void setScore(int i, int point){ score[i]=score[i]+point;}

    public void initScore(int i){score[i]=0;}

    ///pareil avec les cases qui vont contenir les scores finaux des partie haut et basse

    public int getTotalScoreHaut(int i){return totalScoreHaut[i];}

    public void setTotalScoreHaut(int i, int point){ totalScoreHaut[i]=totalScoreHaut[i]+point;}

    public void initTotalScoreHaut(int i){totalScoreHaut[i]=0;}

    /*public void primedes35(){
        if(totalScoreHaut=>63){
            fen.esp[19][model.j.getJoueur()].setText(esp1);
        }
    }*/
//et le bas
    public int getTotalScoreBas(int i){return totalScoreBas[i];}

    public void setTotalScoreBas(int i, int point){ totalScoreBas[i]=totalScoreBas[i]+point;}

    public void initTotalScoreBas(int i){totalScoreBas[i]=0;}

}

/**
 * Created by nico on 21/11/15.
 */
public class Joueur {
    public int score;
    public int position;

    public Joueur(int pos){
        score = 0;
        this.position = pos;
    }

    public int getScore(){
        return this.score;
    }

    public void setScore(){
        this.score=score;
    }


}

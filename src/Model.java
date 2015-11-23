import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by nico on 08/11/15.
 */
public class Model {
    protected int score;
    protected int point;
    protected int lancer;
    protected  int[] sortie;

    public Model(){
        score=0;
        lancer=0;
        sortie= new int[6];
        JLabel dé1, dé2, dé3, dé4, dé5;
    }

    public void jette(){
        for (int i = 0; i <6 ; i++) {
            int y=(int)(6.0 * Math.random()) + 1;
            setSortie(i,y);

        }
    }

    public void setSortie(int i,int j){
        sortie[i]=j;
    }

    public int getSortie(int i){
        return sortie[i];
    }

    public void setLancer(int i){
        lancer=lancer+i;
    }

    public int getLancer(){
        return lancer;
    }

    public int initScore(){
       return score=0;
    }


    public int getScore(){
        return score;
    }

    public void setScore(int point){
        score= score+point;
    }


}

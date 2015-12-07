import java.util.Random;

/**
 * Created by nrossdeu on 02/11/15.
 */
public class De {
    protected int lancer;
    protected int sortie[];

    public De(){
        int lancer=0;
        sortie= new int[6];
    }

    public void jette(){
        for (int i = 0; i <6 ; i++) {
            int y=(int)(6.0 * Math.random()) + 1;
            setSortie(i,y);
        }
    }

    public int getSortie(int i){
        return sortie[i];
    }
    //ok
    public void setSortie(int i,int j){
        sortie[i]=j;
    }
    //ok
    public int getLancer(){
        return lancer;
    }
    //compteur du lancer

    public void setLancer(int i){
        lancer=lancer+i;
    }
    //initialisation du lance a chaque tour du joueur

    public void initLancer(){lancer=0;}
    //initialisation du score

}

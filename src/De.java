import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by nrossdeu on 02/11/15.
 */
public class De {
    protected int lancer;
    protected int sortie[];
    protected Image face;
    protected ImageIcon ii;

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

    public Image getFace(int i){

        switch (i)
        {
            case 1:
                 ii= new ImageIcon("images/1.png");
                face = ii.getImage();
                ;
                break;
            case 2:
                ii = new ImageIcon("images/2.png");
                face = ii.getImage();

                break;
            case 3:
                ii = new ImageIcon("images/3.png");
                face = ii.getImage();

                break;
            case 4:
                ii = new ImageIcon("images/4.png");
                face = ii.getImage();

                break;
            case 5:
                ii = new ImageIcon("images/5.png");
                face = ii.getImage();

            case 6:
                ii = new ImageIcon("images/6.png");
                face = ii.getImage();

                break;

            default:
                System.out.println("Il faut davantage travailler.");
        }
        return face;
    }
}

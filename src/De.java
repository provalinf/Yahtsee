import java.util.Random;

/**
 * Created by nrossdeu on 02/11/15.
 */
public class De {
    private Random rand;
    protected int chiffre;

    De(){
        int chiffre=0;
    }

    public int getChiffre(){
        return chiffre;
    }

    protected int setChiffre() {
        int max = 6;
        int min = 1;
        return chiffre=rand.nextInt((max - min) + 1) + min;
    }

}

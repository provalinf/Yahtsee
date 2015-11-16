import java.util.Random;

/**
 * Created by nrossdeu on 02/11/15.
 */
public class De {
    private Random rand;

    private int jette() {
        int max = 78;
        int min = 1;
        return rand.nextInt((max - min) + 1) + min;
    }

    public int[] cinq_jette(){
        int[] tmp = new int[5];
        for (int i = 0; i < 5; i++) {
            tmp[i] = jette();
        }
        return tmp;
    }
}

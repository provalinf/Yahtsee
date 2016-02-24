/**
 * Created by nico on 17/02/16.
 */
public class Robo extends Joueur{

    protected Model model;


    public Robo(int n, Model m){
        super(n);
        this.model = m;

    }


    public void joueCoup(Robo r) {
        if (model.getNbJoueur() == 1 && model.t==1){
            model.d.jette();

           // if()
        }

    }

}

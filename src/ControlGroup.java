/**
 * Created by nico on 08/11/15.
 */
public class ControlGroup {

    private Model model;
    private Fenetre fen;
    public ControlButton controlButton;
    public ControlMenu controlMenu;


    public ControlGroup(Model model) {

        this.model = model;

        fen = new Fenetre(model);

        controlButton = new ControlButton(model,fen);
        controlMenu = new ControlMenu(fen);


    }
}

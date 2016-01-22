import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

/**
 * Created by nico on 11/01/16.
 */

public class RenderPanel extends JPanel {
    protected Fenetre fen;
    protected Model model;
    private Timer timer;
    // private final int DELAY = 10;

    public RenderPanel(Model m,Fenetre f) {
        super();
        model = m;
        fen = f;
        setLayout(new GridLayout(50,50,0,0)); //PB
        setFocusable(true);
        timer.start();
    }


    protected void paintComponent(Graphics g){
        Font font = new Font("Verdana", Font.BOLD, 30);//police pour l'affichage de l'état
        g.setFont(font);
        g.setColor(Color.white);//couleur biensur
        super.paintComponent(g);
        //fond map
        g.drawImage(model.getParchemin(),0,0,this);


    }

    public void actionPerformed(ActionEvent e) {


    }

}
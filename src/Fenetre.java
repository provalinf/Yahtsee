import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by nico on 08/11/15.
 */
public class Fenetre extends JFrame {
    protected Model model;

    private Panel pan = new Panel(new GridBagLayout());
    protected JCheckBox A1,A2,A3,A4,A5;
    protected int i;
    //section sup
    //int nbJoueur =3;
    protected JLabel esp[][] = new JLabel[22][22];
    protected JPanel espA[][] = new JPanel[22][22];
    protected JPanel espB[][] = new JPanel[22][22];
    //section bas

    protected JButton TotalAs,TotalDeux,TotalTrois,TotalQuatre,TotalCinq, TotalSix,Brelan,Carre, Full, PSuite, GSuite, Yahtzee, Chance;
    protected JLabel joueur ,joueur2 ,vide , PrimeY, Prime35, TotalInf,TotalSup, TotalSup2, Total;
    protected JLabel dé1, dé2, dé3, dé4, dé5;
    protected JButton lancer;
    protected JComboBox<String> E1;
    protected JCheckBox F1;
    protected JMenuBar menuBar;
    protected JMenu option;
    protected JMenuItem itemInterface1, itemInterface2, itemComment, itemApropos;
    protected JMenu itemAide;
    protected ImageIcon img1,img2;
    //protected JButton G1;
    protected ControlButton control;
    protected ControlButton controlA;
    protected ControlMenu control2 = new ControlMenu(this);


    public Fenetre(Model model) {

        this.model = model;
        initAttribut();
        creerMenu();
        creerWidget2();

        this.setResizable(true);
        pack();
        setTitle("Yahtsee");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public void initAttribut(){

        control = new ControlButton(model,this);
        controlA = new ControlButton(model,this);

        A1 = new JCheckBox("1",false);
        A2 = new JCheckBox("2",false);
        A3 = new JCheckBox("3",false);
        A4 = new JCheckBox("4",false);
        A5 = new JCheckBox("5",false);
        //case des dé
        dé1 = new JLabel("_");
        dé2 = new JLabel("_");
        dé3 = new JLabel("_");
        dé4 = new JLabel("_");
        dé5 = new JLabel("_");
        Total = new JLabel("Total");
        //lancer de dé
        lancer = new JButton("Lancer");
        lancer.addActionListener(control);

        //bouton partie droite
        TotalAs = new JButton("Total des AS");
        TotalAs.addActionListener(controlA);
        TotalDeux = new JButton("Total des DEUX");
        TotalDeux.addActionListener(controlA);
        TotalTrois = new JButton("Total des TROIS");
        TotalTrois.addActionListener(controlA);
        TotalQuatre = new JButton("Total des QUATRE");
        TotalQuatre.addActionListener(controlA);
        TotalCinq = new JButton("Total des CINQ");
        TotalCinq.addActionListener(controlA);
        TotalSix = new JButton("Total des SIX");
        TotalSix.addActionListener(controlA);
        Brelan = new JButton("Brelan - Total des 5 dés");
        Brelan.addActionListener(controlA);
        Carre = new JButton("Carré - Total des 5 dés");
        Carre.addActionListener(controlA);
        Full = new JButton("Full - 25 point");
        Full.addActionListener(controlA);
        PSuite = new JButton("Petite suite - 30 points");
        PSuite.addActionListener(controlA);
        GSuite = new JButton("Grande suite - 40 points");
        GSuite.addActionListener(controlA);
        Yahtzee = new JButton("Yahtzee - 50 points");
        Yahtzee.addActionListener(controlA);
        Chance = new JButton("Chance - Total des 5 dés");
        Chance.addActionListener(controlA);


        //partie sup
        joueur = new JLabel("joueur");
        vide= new JLabel(" ");

        String[] Option = new String[]{"Latin", "Grec", "Sport"};
        E1 = new JComboBox<String>(Option);

        F1 = new JCheckBox("", true);

       // G1= new JButton("Moyenne");

        menuBar = new JMenuBar();
        option = new JMenu("Option");
        img1 = new ImageIcon("version1.gif");
        setItemInterface1(new JMenuItem("Version 1",img1));
        img2 = new ImageIcon("version2.gif");
        itemInterface2 = new JMenuItem("Version 2",img2);
        itemAide = new JMenu("Aide");
        itemComment = new JMenuItem("Comment ça marche?");
        itemApropos = new JMenuItem("A propos");
       // G1.addActionListener((ActionListener) control);
        getItemInterface1().addActionListener(control2);
        itemInterface2.addActionListener(control2);
        itemAide.addActionListener(control2);
    }

    public void creerWidget2() {

//section superieur

        JPanel PanoB1 = new JPanel();
        PanoB1.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel sectionUp = new JLabel("SECTION SUPERIEUR");
        PanoB1.add(sectionUp);

        JPanel PanoB2 = new JPanel();
        PanoB2.setBorder(BorderFactory.createLineBorder(Color.black));
        PanoB2.add(TotalAs);

        JPanel PanoB3 = new JPanel();
        PanoB3.setBorder(BorderFactory.createLineBorder(Color.black));
        PanoB3.add(TotalDeux);

        JPanel PanoB4 = new JPanel();
        PanoB4.setBorder(BorderFactory.createLineBorder(Color.black));
        PanoB4.add(TotalTrois);

        JPanel PanoB5 = new JPanel();
        PanoB5.setBorder(BorderFactory.createLineBorder(Color.black));
        PanoB5.add(TotalQuatre);

        JPanel PanoB6 = new JPanel();
        PanoB6.setBorder(BorderFactory.createLineBorder(Color.black));
        PanoB6.add(TotalCinq);

        JPanel PanoB7 = new JPanel();
        PanoB7.setBorder(BorderFactory.createLineBorder(Color.black));
        PanoB7.add(TotalSix);

        JPanel PanoB8 = new JPanel();
        PanoB8.setBorder(BorderFactory.createLineBorder(Color.black));
        PanoB8.add(Total);

        JPanel PanoB9 = new JPanel();
        PanoB9.setBorder(BorderFactory.createLineBorder(Color.black));
        Prime35 = new JLabel("Prime des 35 points");
        PanoB9.add(Prime35);

        JPanel PanoB10 = new JPanel();
        PanoB10.setBorder(BorderFactory.createLineBorder(Color.black));
        TotalSup = new JLabel("Total de la section superieure");
        PanoB10.add(TotalSup);


        JPanel PanoB11 = new JPanel();
        PanoB11.setBorder(BorderFactory.createLineBorder(Color.black));
        PanoB10.add(vide);


        JPanel PanoA1 = new JPanel();
        PanoA1.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel sectionInf = new JLabel("SECTION INFERIEUR");
        PanoA1.add(sectionInf);

        JPanel PanoA2 = new JPanel();
        PanoA2.setBorder(BorderFactory.createLineBorder(Color.black));
        PanoA2.add(Brelan);

        JPanel PanoA3 = new JPanel();
        PanoA3.setBorder(BorderFactory.createLineBorder(Color.black));
        PanoA3.add(Carre);

        JPanel PanoA4 = new JPanel();
        PanoA4.setBorder(BorderFactory.createLineBorder(Color.black));
        PanoA4.add(Full);

        JPanel PanoA5 = new JPanel();
        PanoA5.setBorder(BorderFactory.createLineBorder(Color.black));
        PanoA5.add(PSuite);

        JPanel PanoA6 = new JPanel();
        PanoA6.setBorder(BorderFactory.createLineBorder(Color.black));
        PanoA6.add(GSuite);

        JPanel PanoA7 = new JPanel();
        PanoA7.setBorder(BorderFactory.createLineBorder(Color.black));
        PanoA7.add(Yahtzee);

        JPanel PanoA8 = new JPanel();
        PanoA8.setBorder(BorderFactory.createLineBorder(Color.black));
        PanoA8.add(Chance);

        JPanel PanoA9 = new JPanel();
        PanoA9.setBorder(BorderFactory.createLineBorder(Color.black));
        PrimeY = new JLabel("Prime Yahtzee 100 points");
        PanoA9.add(PrimeY);

        JPanel PanoA10 = new JPanel();
        PanoA10.setBorder(BorderFactory.createLineBorder(Color.black));
        TotalInf = new JLabel("Total de la section inferieur");
        PanoA10.add(TotalInf);

        JPanel PanoA11 = new JPanel();
        PanoA11.setBorder(BorderFactory.createLineBorder(Color.black));
        TotalSup2 = new JLabel("Total de la section supérieur");
        PanoA11.add(TotalSup2);

      //  JPanel PanoA12 = new JPanel();


        JPanel PanoCC1 = new JPanel();
        PanoCC1.setBorder(BorderFactory.createLineBorder(Color.black));
        JButton TotalGen = new JButton("Total Général");
        PanoCC1.add(TotalGen);

        //création de la partie des Dés
        //partie des checkbox et des label d'affichage

        A1= new JCheckBox("Garder");

        JPanel PartieD1 = new JPanel();
        PartieD1.setBorder(BorderFactory.createLineBorder(Color.black));
        PartieD1.add(A1);
        PartieD1.add(Box.createGlue());
        PartieD1.add(dé1);

        A2= new JCheckBox("Garder");

        JPanel PartieD2 = new JPanel();
        PartieD2.setBorder(BorderFactory.createLineBorder(Color.black));
        PartieD2.add(A2);
        PartieD2.add(Box.createGlue());
        PartieD2.add(dé2);

        A3= new JCheckBox("Garder");

        JPanel PartieD3 = new JPanel();
        PartieD3.setBorder(BorderFactory.createLineBorder(Color.black));
        PartieD3.add(A3);
        PartieD3.add(Box.createGlue());
        PartieD3.add(dé3);

        A4= new JCheckBox("Garder");

        JPanel PartieD4 = new JPanel();
        PartieD4.setBorder(BorderFactory.createLineBorder(Color.black));
        PartieD4.add(A4);
        PartieD4.add(Box.createGlue());
        PartieD4.add(dé4);

        A5= new JCheckBox("Garder");

        JPanel PartieD5 = new JPanel();
        PartieD5.setBorder(BorderFactory.createLineBorder(Color.black));
        PartieD5.add(A5);
        PartieD5.add(Box.createGlue());
        PartieD5.add(dé5);
        //partie du boutton
        JPanel PartieD6 = new JPanel();
        PartieD6.setBorder(BorderFactory.createLineBorder(Color.black));
        PartieD6.add(lancer);

        JPanel PanoC1 = new JPanel();
        PanoC1.add(PanoCC1);

        //grille1
        JPanel player= new JPanel(new GridLayout(22, model.getNbJoueur()));
        for (int j = 0; j <esp.length; j++) {
            for (int k = 0; k <model.getNbJoueur(); k++) {

                esp[j][k]= new JLabel();
               // esp[j][k].setBorder(BorderFactory.createLineBorder(Color.black));
                if(esp[j][k]==esp[0][k]){
                    int num=k+1;
                    esp[j][k].setText("joueur "+num );
                }
                else{
                esp[j][k].setText("_");}

                espA[j][k]= new JPanel();
                //espA[j][k].setBorder(BorderFactory.createLineBorder(Color.black));
                espA[j][k].add(esp[j][k]);
                espB[j][k]= new JPanel();
                espB[j][k].setBorder(BorderFactory.createLineBorder(Color.black));
                espB[j][k].add(espA[j][k]);
                player.add(espB[j][k]);
            }

        }
        
     //   player.add(joueur);


        //grille2
        JPanel partie= new JPanel(new GridLayout(6,1));

            partie.add(PartieD1);
            partie.add(PartieD2);
            partie.add(PartieD3);
            partie.add(PartieD4);
            partie.add(PartieD5);
            partie.add(PartieD6);

        //affichage partie h affichage de gauche
        JPanel PanoSecSup = new JPanel(new GridLayout(22, 1));
            PanoSecSup.setBorder(BorderFactory.createLineBorder(Color.black));
            PanoSecSup.add(PanoB1);
            PanoSecSup.add(PanoB2);
            PanoSecSup.add(PanoB3);
            PanoSecSup.add(PanoB4);
            PanoSecSup.add(PanoB5);
            PanoSecSup.add(PanoB6);
            PanoSecSup.add(PanoB7);
            PanoSecSup.add(PanoB8);
            PanoSecSup.add(PanoB9);
            PanoSecSup.add(PanoB10);
            PanoSecSup.add(PanoB11);
            PanoSecSup.add(PanoA1);
            PanoSecSup.add(PanoA2);
            PanoSecSup.add(PanoA3);
            PanoSecSup.add(PanoA4);
            PanoSecSup.add(PanoA5);
            PanoSecSup.add(PanoA6);
            PanoSecSup.add(PanoA7);
            PanoSecSup.add(PanoA8);
            PanoSecSup.add(PanoA9);
            PanoSecSup.add(PanoA10);
            PanoSecSup.add(PanoA11);





        JPanel Capsule1 = new JPanel();
            Capsule1.add(PanoSecSup);
        JPanel Capsule2 = new JPanel();
            Capsule2.add(partie);
        JPanel Capsule3 = new JPanel();
            Capsule3.add(player);
       /* JPanel Capsule4 = new JPanel();
        Capsule4.add(player2);*/

        JPanel affichage = new JPanel(new GridLayout(1,3));
            affichage.add(Capsule1);
            affichage.add(Capsule3);
            affichage.add(Capsule2);
       /* affichage.add(Capsule4);*/
        JPanel affichage2 = new JPanel();
            affichage2.add(affichage);

        setContentPane(affichage2);

    }

    public void creerDialogue(String dtexte) {
        JOptionPane d = new JOptionPane();
        d.showMessageDialog(this, dtexte, "Erreur",
                JOptionPane.ERROR_MESSAGE);

        JDialog fenErr = d.createDialog(this, "Erreur");
    }

    public void creerMenu() {
        JMenuBar menuBar = new JMenuBar();
        option.add(getItemInterface1());
        option.add(itemInterface2);
        option.add(itemAide);
        itemAide.add(itemComment);
        itemAide.add(itemApropos);
        menuBar.add(option);
        setJMenuBar(menuBar);
    }

    public void changerVersion(int Version) {

        switch(Version){
            case 1:
                pan.removeAll();
                pack();
                setVisible(true);
                break;

            case 2:
                pan.removeAll();
                creerWidget2();
                pack();
                setVisible(true);
                break;

            case 3:
                creerDialogue(" créer par nico");
                break;

            default:
                pan.removeAll();
                pack();
                setVisible(true);
                break;
        }

    }

    public JMenuItem getItemInterface1() {
        return itemInterface1;

    }
    public void setItemInterface1(JMenuItem itemInterface1) {

        this.itemInterface1 = itemInterface1;
    }

    public void setControlButton(ActionListener listener) {
        // xxx.addActionListener(listener);

       // lancer.addActionListener(control);

    }
}


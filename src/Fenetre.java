import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


/**
 * Created by nico on 08/11/15.
 */
public class Fenetre extends JFrame {
    protected Model model;

    protected Panel pan = new Panel(new GridBagLayout());
    protected JCheckBox A1,A2,A3,A4,A5;
    protected int i;
    //section sup
    //int nbJoueur =3;
    protected JLabel esp[][] = new JLabel[23][23];
    protected JPanel espA[][] = new JPanel[23][23];
    protected JPanel espB[][] = new JPanel[23][23];
    //section bas

    protected JButton TotalAs,TotalDeux,TotalTrois,TotalQuatre,TotalCinq, TotalSix,Brelan,Carre, Full, PSuite, GSuite, Yahtzee, Chance;
    protected JLabel joueur ,joueur2 ,vide , PrimeY, Prime35, TotalInf,TotalSup, TotalSup2, Total,Info3;
    protected JLabel dé1, dé2, dé3, dé4, dé5;
    protected JButton lancer;
    protected JComboBox<String> E1;
    protected JCheckBox F1;
    protected JMenuBar menuBar;
    protected JMenu option;
    protected JMenuItem itemInterface1, itemInterface2,itemInterface3, itemInterface4,itemInterface5, itemComment, itemApropos;
    protected JMenu itemAide;
    //protected JButton G1;
    protected ControlButton control;
    protected ControlButton controlA;
    protected ControlMenu control2 = new ControlMenu(this);
    protected ImageIcon listeImages[] = new ImageIcon[7];

    //parti du panneau
    protected JButton restart,stop;


    public Fenetre(Model model) {

        this.model = model;
        initAttribut();
        creerMenu();
        creerWidget2();
        setIconImage(new ImageIcon("images/logo.png").getImage());
        this.setResizable(true);
        pack();
        setTitle("YAHTZEE");
        //setSize(700,700);
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
        Brelan = new JButton("Brelan");
        Brelan.addActionListener(controlA);
        Carre = new JButton("Carré");
        Carre.addActionListener(controlA);
        Full = new JButton("Full");
        Full.addActionListener(controlA);
        PSuite = new JButton("Petite suite");
        PSuite.addActionListener(controlA);
        GSuite = new JButton("Grande suites");
        GSuite.addActionListener(controlA);
        Yahtzee = new JButton("Yahtzee");
        Yahtzee.addActionListener(controlA);
        Chance = new JButton("Chance");
        Chance.addActionListener(controlA);

        //bouton du panneau de fin
        restart = new JButton("recommencer");
        restart.addActionListener(controlA);
        stop = new JButton("quitter");
        stop.addActionListener(controlA);


        //partie sup
        joueur = new JLabel("joueur");
        vide= new JLabel(" ");
        Info3 = new JLabel("tour du joueur 1");


        // G1= new JButton("Moyenne");

        menuBar = new JMenuBar();
        option = new JMenu("Option");
        setItemInterface1(new JMenuItem("2 joueurs"));
        itemInterface2 = new JMenuItem("3 joueurs");
        itemInterface3 = new JMenuItem("4 joueurs");
        itemInterface4 = new JMenuItem("5 joueurs");
        itemInterface5 = new JMenuItem("6 joueurs");
        itemAide = new JMenu("Aide");
        itemComment = new JMenuItem("Comment ça marche?");
        itemApropos = new JMenuItem("A propos");
        // G1.addActionListener((ActionListener) control);
        getItemInterface1().addActionListener(control2);
        itemInterface2.addActionListener(control2);
        itemInterface3.addActionListener(control2);
        itemInterface4.addActionListener(control2);
        itemInterface5.addActionListener(control2);
        itemAide.addActionListener(control2);
    }

    public void creerWidget2() {

//section superieur

        JPanel PanoB1 = new JPanel();
        PanoB1.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel sectionUp = new JLabel("SECTION SUPERIEUR");
        PanoB1.add(sectionUp);

        JPanel PanoB8 = new JPanel();
        PanoB8.setBorder(BorderFactory.createLineBorder(Color.black));
        Total = new JLabel("Total");
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
        TotalSup2 = new JLabel("Total Final");
        PanoA11.add(TotalSup2);



        //création de la partie des Dés
        //partie des checkbox et des label d'affichage

        A1= new JCheckBox("Garder");
        A1.setEnabled(false);

        JPanel PartieD1 = new JPanel();
        PartieD1.setBorder(BorderFactory.createLineBorder(Color.black));
        PartieD1.add(A1);
        PartieD1.add(Box.createGlue());
        PartieD1.add(dé1);


        A2= new JCheckBox("Garder");
        A2.setEnabled(false);
        JPanel PartieD2 = new JPanel();
        PartieD2.setBorder(BorderFactory.createLineBorder(Color.black));
        PartieD2.add(A2);
        PartieD2.add(Box.createGlue());
        PartieD2.add(dé2);

        A3= new JCheckBox("Garder");
        A3.setEnabled(false);
        JPanel PartieD3 = new JPanel();
        PartieD3.setBorder(BorderFactory.createLineBorder(Color.black));
        PartieD3.add(A3);
        PartieD3.add(Box.createGlue());
        PartieD3.add(dé3);

        A4= new JCheckBox("Garder");
        A4.setEnabled(false);
        JPanel PartieD4 = new JPanel();
        PartieD4.setBorder(BorderFactory.createLineBorder(Color.black));
        PartieD4.add(A4);
        PartieD4.add(Box.createGlue());
        PartieD4.add(dé4);

        A5= new JCheckBox("Garder");
        A5.setEnabled(false);
        JPanel PartieD5 = new JPanel();
        PartieD5.setBorder(BorderFactory.createLineBorder(Color.black));
        PartieD5.add(A5);
        PartieD5.add(Box.createGlue());
        PartieD5.add(dé5);
        //partie du boutton
        JPanel PartieD6 = new JPanel();
        PartieD6.setBorder(BorderFactory.createLineBorder(Color.black));
        PartieD6.add(lancer);

        //panneau d'info du joueur
        JPanel PanoInfo = new JPanel();
        PanoInfo.setBackground(Color.gray);
        JPanel PanoInfo2 = new JPanel();

        PanoInfo2.setBorder(BorderFactory.createLineBorder(Color.black));
        PanoInfo2.add(Info3);
        PanoInfo.add(PanoInfo2);

        //grille des joueurs
        JPanel player = new JPanel(new GridLayout(22, model.j.getNbJoueur()));
        for (int j = 0; j <esp.length; j++) {
            for (int k = 0; k < model.j.getNbJoueur(); k++) {

                esp[j][k] = new JLabel();
                // esp[j][k].setBorder(BorderFactory.createLineBorder(Color.black));
                if (esp[j][k] == esp[0][k]) {
                    int num = k + 1;

                    esp[j][k].setText("joueur " + num);
                    esp[j][k].setOpaque(false);
                    esp[j][k].setBackground(Color.red);

                } else if (esp[j][k] == esp[11][k]&&esp[j][k] == esp[12][k]) {
                    esp[j][k].setText(" ");
                    esp[j][k].setOpaque(false);


                } else {
                    esp[j][k].setText("_");
                    esp[j][k].setOpaque(false);
                }

                espA[j][k] = new JPanel();

                if (espA[j][k] == espA[10][k]) {
                    espA[j][k].setOpaque(false);
                    espA[j][k].setBackground(Color.white);
                } else {

                    espA[j][k].add(esp[j][k]);
                    espA[j][k].setBackground(Color.white);
                }

                espB[j][k] = new JPanel();
                if (espB[j][k] == espB[10][k]) {
                    espB[j][k].setOpaque(false);
                    espB[j][k].setBackground(Color.white);
                } else {

                    espB[j][k].setBorder(BorderFactory.createLineBorder(Color.black));
                    espB[j][k].add(esp[j][k]);
                    Color color= new Color(225, 0, 225);
                    espB[j][k].setBackground(Color.white);
                    player.add(espB[j][k]);
                }
            }

        }

        //grille2
        JPanel partie= new JPanel(new GridLayout(7,1));
        partie.setBackground(Color.green);

        partie.add(PartieD1);
        partie.add(PartieD2);
        partie.add(PartieD3);
        partie.add(PartieD4);
        partie.add(PartieD5);
        partie.add(PartieD6);
        partie.add(PanoInfo);
        System.out.println(model.j.getJoueur());

        JPanel partie2= new JPanel(new GridLayout(5,1));
        partie2.setBackground(Color.green);

        JPanel PanoSup = new JPanel(new GridLayout(22, 1));
        PanoSup.add(PanoB1);
        PanoSup.add(TotalAs);
        PanoSup.add(TotalDeux);
        PanoSup.add(TotalTrois);
        PanoSup.add(TotalQuatre);
        PanoSup.add(TotalCinq);
        PanoSup.add(TotalSix);
        PanoSup.add(PanoB8);
        PanoSup.add(PanoB9);
        PanoSup.add(PanoB10);
        PanoSup.add(PanoB11);
        PanoSup.add(PanoA1);
        PanoSup.add(Brelan);
        PanoSup.add(Carre);
        PanoSup.add(Full);
        PanoSup.add(PSuite);
        PanoSup.add(GSuite);
        PanoSup.add(Yahtzee);
        PanoSup.add(Chance);
        PanoSup.add(PanoA9);
        PanoSup.add(PanoA10);
        PanoSup.add(PanoA11);

        JPanel Capsule1 = new JPanel();
        //Capsule1.add(PanoSecSup);
        Capsule1.add(PanoSup);

        JPanel Capsule3 = new JPanel();
        Capsule3.add(player);


        JPanel Capsule2 = new JPanel();
        Capsule2.add(partie);
        Capsule2.add(partie2);



        JPanel affichage = new JPanel(new GridLayout(1,4));
        affichage.add(Capsule1);
        affichage.add(Capsule3);
        affichage.add(Capsule2);
        JPanel affichage2 = new JPanel();
        affichage2.add(affichage);

        setContentPane(affichage2);

    }

    public void creerDialogue(String dtexte) {
        JOptionPane d = new JOptionPane();
        int option =d.showConfirmDialog(this, dtexte, "Fin de partie", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if(option == JOptionPane.OK_OPTION){
            model.j.setNbJoueur(model.j.getNbJoueur());
            pan.removeAll();
            initcheckText();
            model.j.initJoueur();
            model.j.initScore(model.j.getJoueur());
            model.j.initTous();
            model.d.initLancer();
            System.out.println(model.j.nbJoueur);
            creerWidget2();
            pack();
            setVisible(true);
            repaint();

        }
        if(option == JOptionPane.NO_OPTION){
            this.dispose();
        }
    }

    public void creerMenu() {
        JMenuBar menuBar = new JMenuBar();
        option.add(getItemInterface1());
        option.add(itemInterface2);
        option.add(itemInterface3);
        option.add(itemInterface4);
        option.add(itemInterface5);
        option.add(itemAide);
        itemAide.add(itemComment);
        itemAide.add(itemApropos);
        menuBar.add(option);
        setJMenuBar(menuBar);
    }

    public void changerVersion(int Version) {

        switch(Version){
            case 1:
                model.j.setNbJoueur(2);
                pan.removeAll();
                initcheckText();
                model.j.initJoueur();
                model.j.initScore(model.j.getJoueur());
                model.j.initTous();
                model.d.initLancer();
                System.out.println(model.j.nbJoueur);
                creerWidget2();
                pack();
                setVisible(true);
                repaint();
                break;

            case 2:
                model.j.setNbJoueur(3);
                pan.removeAll();
                initcheckText();
                model.j.initJoueur();
                model.j.initScore(model.j.getJoueur());
                model.j.initTous();
                model.d.initLancer();
                creerWidget2();
                pack();
                setVisible(true);
                repaint();
                break;

            case 3:
                model.j.setNbJoueur(4);
                pan.removeAll();
                initcheckText();
                model.j.initJoueur();
                model.j.initScore(model.j.getJoueur());
                model.j.initTous();
                model.d.initLancer();
                creerWidget2();
                pack();
                setVisible(true);
                break;

            case 4:
                pan.removeAll();
                model.j.setNbJoueur(5);
                initcheckText();
                model.j.initJoueur();
                model.d.initLancer();
                model.j.initScore(model.j.getJoueur());
                model.j.initTous();
                creerWidget2();
                pack();
                setVisible(true);
                break;

            case 5:
                pan.removeAll();
                model.j.setNbJoueur(6);
                initcheckText();
                model.j.initJoueur();
                model.j.initScore(model.j.getJoueur());
                model.j.initTous();
                model.d.initLancer();
                creerWidget2();
                pack();
                setVisible(true);
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

    public void initcheckText(){
        dé1.setText("_");
        dé2.setText("_");
        dé3.setText("_");
        dé4.setText("_");
        dé5.setText("_");

    }

}

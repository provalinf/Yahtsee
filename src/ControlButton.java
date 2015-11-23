import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by nico on 08/11/15.
 */
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControlButton implements ActionListener{
    protected Model model;
    protected Fenetre fen;
    int lancer=0;
    int total=0;
    ArrayList<Integer> stockage = new ArrayList<>();
   // int t=1;//tour de jeux
    int j=0;//num de joueur dans la grille
    int x,y,w,v,z;
    int totalup[];




    public ControlButton(Model m,Fenetre fen) {
        this.fen=fen;
        this.model=m;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        totalup= new int[fen.nbJoueur];
        int sortie[] = new int[6];
        JLabel dé1, dé2, dé3, dé4, dé5;

        if (e.getSource() == fen.lancer) {
            for (int i = 0; i <6 ; i++) {
               sortie[i]=(int)(6.0 * Math.random()) + 1;

            }

            if (fen.A1.isSelected() == false) {
                dé1 = fen.dé1;
                String chiffre1 = Integer.toString(sortie[1]);
                dé1.setText(chiffre1);
                }
            if (fen.A2.isSelected() == false) {
                dé2 = fen.dé2;
                String chiffre2 = Integer.toString(sortie[2]);
                dé2.setText(chiffre2);
                }
            if (fen.A3.isSelected() == false) {
                dé3 = fen.dé3;
                String chiffre3 = Integer.toString(sortie[3]);
                dé3.setText(chiffre3);
                }
            if (fen.A4.isSelected() == false) {
                dé4 = fen.dé4;
                String chiffre4 = Integer.toString(sortie[4]);
                dé4.setText(chiffre4);
                }
            if (fen.A5.isSelected() == false) {
                dé5 = fen.dé5;
                String chiffre5 = Integer.toString(sortie[5]);
                dé5.setText(chiffre5);
            }

            if(lancer!=3){

                lancer=lancer+1;

            }
            if(lancer==3){fen.lancer.setVisible(false);}

            System.out.println("lancer  : "+lancer);

        }

        if (e.getSource() == fen.TotalAs) {

            if(j==fen.nbJoueur){
                j=0;
            }

            fen.lancer.setVisible(true);
            lancer =0;
            v = Integer.parseInt(fen.dé1.getText());
            w= Integer.parseInt(fen.dé2.getText());
            x = Integer.parseInt(fen.dé3.getText());
            y = Integer.parseInt(fen.dé4.getText());
            z = Integer.parseInt(fen.dé5.getText());
            if(v!=1){v=0;}
            if(w!=1){w=0;}
            if(x!=1){x=0;}
            if(y!=1){y=0;}
            if(z!=1){z=0;}

            total=z+x+y+v+w;

            String esp1 = Integer.toString(total);
            fen.esp[1][j].setText(esp1);
            fen.dé1.setText("0");
            fen.dé2.setText("0");
            fen.dé3.setText("0");
            fen.dé4.setText("0");
            fen.dé5.setText("0");
            fen.A1.setSelected(false);
            fen.A2.setSelected(false);
            fen.A3.setSelected(false);
            fen.A4.setSelected(false);
            fen.A5.setSelected(false);

            totalup[j]=totalup[j]+ total;

            String trans=Integer.toString(totalup[j]);
            fen.esp[7][j].setText(trans);
            fen.esp[9][j].setText(trans);

            if(j!=fen.nbJoueur){

                j++;
            }
            System.out.println("lancer  : "+lancer);

        }

        if (e.getSource() == fen.TotalDeux) {


            if(j==fen.nbJoueur){
                j=0;
            }

            fen.lancer.setVisible(true);
            lancer =0;
            v = Integer.parseInt(fen.dé1.getText());
            w= Integer.parseInt(fen.dé2.getText());
            x = Integer.parseInt(fen.dé3.getText());
            y = Integer.parseInt(fen.dé4.getText());
            z = Integer.parseInt(fen.dé5.getText());
            if(v!=2){v=0;}
            if(w!=2){w=0;}
            if(x!=2){x=0;}
            if(y!=2){y=0;}
            if(z!=2){z=0;}

            total=z+x+y+v+w;
            String esp1 = Integer.toString(total);
            fen.esp[2][j].setText(esp1);
            fen.dé1.setText("0");
            fen.dé2.setText("0");
            fen.dé3.setText("0");
            fen.dé4.setText("0");
            fen.dé5.setText("0");
            fen.A1.setSelected(false);
            fen.A2.setSelected(false);
            fen.A3.setSelected(false);
            fen.A4.setSelected(false);
            fen.A5.setSelected(false);
            totalup[j]=totalup[j]+ total;
            String trans=Integer.toString(totalup[j]);
            fen.esp[7][j].setText(trans);
            fen.esp[9][j].setText(trans);


            if(j!=fen.nbJoueur){

                j++;
            }
            System.out.println("lancer  : "+lancer);

        }

        if (e.getSource() == fen.TotalTrois) {


            if(j==fen.nbJoueur){
                j=0;
            }
            fen.lancer.setVisible(true);
            lancer =0;
            v = Integer.parseInt(fen.dé1.getText());
            w= Integer.parseInt(fen.dé2.getText());
            x = Integer.parseInt(fen.dé3.getText());
            y = Integer.parseInt(fen.dé4.getText());
            z = Integer.parseInt(fen.dé5.getText());
            if(v!=3){v=0;}
            if(w!=3){w=0;}
            if(x!=3){x=0;}
            if(y!=3){y=0;}
            if(z!=3){z=0;}
            System.out.println("controle attendre ok");

            total=z+x+y+v+w;
            String esp1 = Integer.toString(total);
            fen.esp[3][j].setText(esp1);
            fen.dé1.setText("0");
            fen.dé2.setText("0");
            fen.dé3.setText("0");
            fen.dé4.setText("0");
            fen.dé5.setText("0");
            fen.A1.setSelected(false);
            fen.A2.setSelected(false);
            fen.A3.setSelected(false);
            fen.A4.setSelected(false);
            fen.A5.setSelected(false);
            totalup[j]=totalup[j]+ total;
            String trans=Integer.toString(totalup[j]);
            fen.esp[7][j].setText(trans);
            fen.esp[9][j].setText(trans);


            if(j!=fen.nbJoueur){

                j++;
            }
            System.out.println("lancer  : "+lancer);
        }

        if (e.getSource() == fen.TotalQuatre) {

            if(j==fen.nbJoueur){
                j=0;
            }
            fen.lancer.setVisible(true);
            lancer =0;
            v = Integer.parseInt(fen.dé1.getText());
            w= Integer.parseInt(fen.dé2.getText());
            x = Integer.parseInt(fen.dé3.getText());
            y = Integer.parseInt(fen.dé4.getText());
            z = Integer.parseInt(fen.dé5.getText());
            if(v!=4){v=0;}
            if(w!=4){w=0;}
            if(x!=4){x=0;}
            if(y!=4){y=0;}
            if(z!=4){z=0;}
            total=z+x+y+v+w;
            String esp1 = Integer.toString(total);
            fen.esp[4][j].setText(esp1);
            fen.dé1.setText("0");
            fen.dé2.setText("0");
            fen.dé3.setText("0");
            fen.dé4.setText("0");
            fen.dé5.setText("0");
            fen.A1.setSelected(false);
            fen.A2.setSelected(false);
            fen.A3.setSelected(false);
            fen.A4.setSelected(false);
            fen.A5.setSelected(false);
            totalup[j]=totalup[j]+ total;
            String trans=Integer.toString(totalup[j]);
            fen.esp[7][j].setText(trans);
            fen.esp[9][j].setText(trans);


            if(j!=fen.nbJoueur){

                j++;
            }
            System.out.println("lancer  : "+lancer);
        }

        if (e.getSource() == fen.TotalCinq) {

            if(j==fen.nbJoueur){
                j=0;
            }
            fen.lancer.setVisible(true);
            lancer =0;
            v = Integer.parseInt(fen.dé1.getText());
            w= Integer.parseInt(fen.dé2.getText());
            x = Integer.parseInt(fen.dé3.getText());
            y = Integer.parseInt(fen.dé4.getText());
            z = Integer.parseInt(fen.dé5.getText());
            if(v!=5){v=0;}
            if(w!=5){w=0;}
            if(x!=5){x=0;}
            if(y!=5){y=0;}
            if(z!=5){z=0;}
            total=z+x+y+v+w;
            String esp1 = Integer.toString(total);
            fen.esp[5][j].setText(esp1);
            fen.dé1.setText("0");
            fen.dé2.setText("0");
            fen.dé3.setText("0");
            fen.dé4.setText("0");
            fen.dé5.setText("0");
            fen.A1.setSelected(false);
            fen.A2.setSelected(false);
            fen.A3.setSelected(false);
            fen.A4.setSelected(false);
            fen.A5.setSelected(false);
            totalup[j]=totalup[j]+ total;
            String trans=Integer.toString(totalup[j]);
            fen.esp[7][j].setText(trans);
            fen.esp[9][j].setText(trans);


            if(j!=fen.nbJoueur){

                j++;
            }
            System.out.println("lancer  : "+lancer);
        }

        if (e.getSource() == fen.TotalSix) {

            if(j==fen.nbJoueur){
                j=0;
            }
            fen.lancer.setVisible(true);
            lancer =0;
            v = Integer.parseInt(fen.dé1.getText());
            w= Integer.parseInt(fen.dé2.getText());
            x = Integer.parseInt(fen.dé3.getText());
            y = Integer.parseInt(fen.dé4.getText());
            z = Integer.parseInt(fen.dé5.getText());
            if(v!=6){v=0;}
            if(w!=6){w=0;}
            if(x!=6){x=0;}
            if(y!=6){y=0;}
            if(z!=6){z=0;}
            total=z+x+y+v+w;
            String esp1 = Integer.toString(total);
            fen.esp[6][j].setText(esp1);
            fen.dé1.setText("0");
            fen.dé2.setText("0");
            fen.dé3.setText("0");
            fen.dé4.setText("0");
            fen.dé5.setText("0");
            fen.A1.setSelected(false);
            fen.A2.setSelected(false);
            fen.A3.setSelected(false);
            fen.A4.setSelected(false);
            fen.A5.setSelected(false);
            totalup[j]=totalup[j]+ total;
            String trans=Integer.toString(totalup[j]);
            fen.esp[7][j].setText(trans);
            fen.esp[9][j].setText(trans);


            if(j!=fen.nbJoueur){

                j++;
            }

        }


        if (e.getSource() == fen.Brelan) {
            if(j==fen.nbJoueur){
                j=0;
            }

            v = Integer.parseInt(fen.dé1.getText());
            w= Integer.parseInt(fen.dé2.getText());
            x = Integer.parseInt(fen.dé3.getText());
            y = Integer.parseInt(fen.dé4.getText());
            z = Integer.parseInt(fen.dé5.getText());
            if(v!=6){v=0;}
            if(w!=6){w=0;}
            if(x!=6){x=0;}
            if(y!=6){y=0;}
            if(z!=6){z=0;}
            total=z+x+y+v+w;
            System.out.println("chiffre" + total + " " + z + " " + x + " " + v + " " + w + " " + y);
            String esp1 = Integer.toString(total);
            fen.esp[6][j].setText(esp1);
            //passage de joueur et des tours
            lancer=0;
            fen.dé1.setText("0");
            fen.dé2.setText("0");
            fen.dé3.setText("0");
            fen.dé4.setText("0");
            fen.dé5.setText("0");
            fen.A1.setSelected(false);
            fen.A2.setSelected(false);
            fen.A3.setSelected(false);
            fen.A4.setSelected(false);
            fen.A5.setSelected(false);

            if(j!=fen.nbJoueur){

                j++;
            }
        }
        if (e.getSource() == fen.Carre) {
            if(j==fen.nbJoueur){
                j=0;
            }

            v = Integer.parseInt(fen.dé1.getText());
            w= Integer.parseInt(fen.dé2.getText());
            x = Integer.parseInt(fen.dé3.getText());
            y = Integer.parseInt(fen.dé4.getText());
            z = Integer.parseInt(fen.dé5.getText());
            if(v!=6){v=0;}
            if(w!=6){w=0;}
            if(x!=6){x=0;}
            if(y!=6){y=0;}
            if(z!=6){z=0;}
            total=z+x+y+v+w;
            System.out.println("chiffre"+total+" "+z+" "+x+" "+v+" "+w+" "+y);
            String esp1 = Integer.toString(total);
            fen.esp[6][j].setText(esp1);
            //passage de joueur et des tours
            lancer=0;
            fen.dé1.setText("0");
            fen.dé2.setText("0");
            fen.dé3.setText("0");
            fen.dé4.setText("0");
            fen.dé5.setText("0");
            fen.A1.setSelected(false);
            fen.A2.setSelected(false);
            fen.A3.setSelected(false);
            fen.A4.setSelected(false);
            fen.A5.setSelected(false);

            if(j!=fen.nbJoueur){

                j++;
            }
        }

        if (e.getSource() == fen.Full) {
            if(j==fen.nbJoueur){
                j=0;
            }

            v = Integer.parseInt(fen.dé1.getText());
            w= Integer.parseInt(fen.dé2.getText());
            x = Integer.parseInt(fen.dé3.getText());
            y = Integer.parseInt(fen.dé4.getText());
            z = Integer.parseInt(fen.dé5.getText());
            if(v!=6){v=0;}
            if(w!=6){w=0;}
            if(x!=6){x=0;}
            if(y!=6){y=0;}
            if(z!=6){z=0;}
            total=z+x+y+v+w;
            System.out.println("chiffre"+total+" "+z+" "+x+" "+v+" "+w+" "+y);
            String esp1 = Integer.toString(total);
            fen.esp[6][j].setText(esp1);
            //passage de joueur et des tours
            lancer=0;
            fen.dé1.setText("0");
            fen.dé2.setText("0");
            fen.dé3.setText("0");
            fen.dé4.setText("0");
            fen.dé5.setText("0");
            fen.A1.setSelected(false);
            fen.A2.setSelected(false);
            fen.A3.setSelected(false);
            fen.A4.setSelected(false);
            fen.A5.setSelected(false);

            if(j!=fen.nbJoueur){

                j++;
            }
        }

        if (e.getSource() == fen.PSuite) {
            if(j==fen.nbJoueur){
                j=0;
            }

            v = Integer.parseInt(fen.dé1.getText());
            w= Integer.parseInt(fen.dé2.getText());
            x = Integer.parseInt(fen.dé3.getText());
            y = Integer.parseInt(fen.dé4.getText());
            z = Integer.parseInt(fen.dé5.getText());
            if(v!=6){v=0;}
            if(w!=6){w=0;}
            if(x!=6){x=0;}
            if(y!=6){y=0;}
            if(z!=6){z=0;}
            total=z+x+y+v+w;
            System.out.println("chiffre"+total+" "+z+" "+x+" "+v+" "+w+" "+y);
            String esp1 = Integer.toString(total);
            fen.esp[6][j].setText(esp1);
            //passage de joueur et des tours
            lancer=0;
            fen.dé1.setText("0");
            fen.dé2.setText("0");
            fen.dé3.setText("0");
            fen.dé4.setText("0");
            fen.dé5.setText("0");
            fen.A1.setSelected(false);
            fen.A2.setSelected(false);
            fen.A3.setSelected(false);
            fen.A4.setSelected(false);
            fen.A5.setSelected(false);

            if(j!=fen.nbJoueur){

                j++;
            }
        }

        if (e.getSource() == fen.GSuite) {
            if(j==fen.nbJoueur){
                j=0;
            }

            v = Integer.parseInt(fen.dé1.getText());
            w= Integer.parseInt(fen.dé2.getText());
            x = Integer.parseInt(fen.dé3.getText());
            y = Integer.parseInt(fen.dé4.getText());
            z = Integer.parseInt(fen.dé5.getText());
            if(v!=6){v=0;}
            if(w!=6){w=0;}
            if(x!=6){x=0;}
            if(y!=6){y=0;}
            if(z!=6){z=0;}
            total=z+x+y+v+w;
            System.out.println("chiffre"+total+" "+z+" "+x+" "+v+" "+w+" "+y);
            String esp1 = Integer.toString(total);
            fen.esp[6][j].setText(esp1);
            //passage de joueur et des tours
            lancer=0;
            fen.dé1.setText("0");
            fen.dé2.setText("0");
            fen.dé3.setText("0");
            fen.dé4.setText("0");
            fen.dé5.setText("0");
            fen.A1.setSelected(false);
            fen.A2.setSelected(false);
            fen.A3.setSelected(false);
            fen.A4.setSelected(false);
            fen.A5.setSelected(false);

            if(j!=fen.nbJoueur){

                j++;
            }
        }
        if (e.getSource() == fen.Yahtzee) {
            if(j==fen.nbJoueur){
                j=0;
            }

            v = Integer.parseInt(fen.dé1.getText());
            w= Integer.parseInt(fen.dé2.getText());
            x = Integer.parseInt(fen.dé3.getText());
            y = Integer.parseInt(fen.dé4.getText());
            z = Integer.parseInt(fen.dé5.getText());
            if(v!=6){v=0;}
            if(w!=6){w=0;}
            if(x!=6){x=0;}
            if(y!=6){y=0;}
            if(z!=6){z=0;}
            total=z+x+y+v+w;
            System.out.println("chiffre"+total+" "+z+" "+x+" "+v+" "+w+" "+y);
            String esp1 = Integer.toString(total);
            fen.esp[6][j].setText(esp1);
            //passage de joueur et des tours
            lancer=0;
            fen.dé1.setText("0");
            fen.dé2.setText("0");
            fen.dé3.setText("0");
            fen.dé4.setText("0");
            fen.dé5.setText("0");
            fen.A1.setSelected(false);
            fen.A2.setSelected(false);
            fen.A3.setSelected(false);
            fen.A4.setSelected(false);
            fen.A5.setSelected(false);

            if(j!=fen.nbJoueur){

                j++;
            }
        }

        if (e.getSource() == fen.Chance) {
            if(j==fen.nbJoueur){
                j=0;
            }

            v = Integer.parseInt(fen.dé1.getText());
            w= Integer.parseInt(fen.dé2.getText());
            x = Integer.parseInt(fen.dé3.getText());
            y = Integer.parseInt(fen.dé4.getText());
            z = Integer.parseInt(fen.dé5.getText());
            if(v!=6){v=0;}
            if(w!=6){w=0;}
            if(x!=6){x=0;}
            if(y!=6){y=0;}
            if(z!=6){z=0;}
            total=z+x+y+v+w;
            System.out.println("chiffre"+total+" "+z+" "+x+" "+v+" "+w+" "+y);
            String esp1 = Integer.toString(total);
            fen.esp[6][j].setText(esp1);
            //passage de joueur et des tours
            lancer=0;
            fen.dé1.setText("0");
            fen.dé2.setText("0");
            fen.dé3.setText("0");
            fen.dé4.setText("0");
            fen.dé5.setText("0");
            fen.A1.setSelected(false);
            fen.A2.setSelected(false);
            fen.A3.setSelected(false);
            fen.A4.setSelected(false);
            fen.A5.setSelected(false);

            if(j!=fen.nbJoueur){

                j++;
            }
        }

        if (e.getSource() == fen.PrimeY) {
            System.out.println("controle attendre ok");
        }

        if (e.getSource() == fen.Prime35) {
            System.out.println("controle fin de tour ok");
        }
        if (e.getSource() == fen.TotalInf) {
            System.out.println("controle attaque ok");
        }

        if (e.getSource() == fen.TotalSup) {
            System.out.println("controle defence ok");
        }

        if (e.getSource() == fen.TotalSup2) {
            System.out.println("controle attendre ok");
        }

    }
}

import com.sun.deploy.util.SystemUtils;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Created by nico on 08/11/15.
 */
public class Model {
	protected int score[];//tableau de score
	protected int point;//nbpoint
	protected int lancer;//lancer de dé
	protected  int[] sortie;
	protected int nbJoueur;
	protected int joueur;
	protected int totalinf,totalsup,total,v,w,x,y,z,somme,type;
	protected int tri[];

	public Model(){
		nbJoueur=3;
		score=new int[nbJoueur];
		lancer=0;
		sortie= new int[6];
		JLabel dé1, dé2, dé3, dé4, dé5;
		total=0;
		totalinf=0;
		totalsup=0;
		somme=0;
		tri= new int[5];
	}
	//ok
	public void jette(){
		for (int i = 0; i <6 ; i++) {
			int y=(int)(6.0 * Math.random()) + 1;
			setSortie(i,y);
		}
	}
	//ok fonction pour récupérer le nb de joueur
	public int getNbJoueur(){
		return nbJoueur;
	}
	//fonction pour definir le nb de joueur
	public void setNbJoueur(int i){
		nbJoueur=i;
	}
	//ok
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
	public void initScore(int nbJoueur){
		for (int i = 0; i < nbJoueur; i++) {
			score[i]=0;
		}
	}
	//ok
	public int getJoueur(){return joueur;}
	//ok
	public void setJoueur(){joueur=joueur+1;}
	//ok
	public void initJoueur(){joueur=0;}

	//public void

	public int getScore(int i){
		return score[i];
	}

	public void setScore(int j,int point)
	{
		score[j]= score[j]+point;
	}
	//petit reset de case dans la partir de lancer
	public void initCase (Fenetre fen){
		fen.dé1.setText("_");
		fen.dé2.setText("_");
		fen.dé3.setText("_");
		fen.dé4.setText("_");
		fen.dé5.setText("_");
		fen.A1.setSelected(false);
		fen.A2.setSelected(false);
		fen.A3.setSelected(false);
		fen.A4.setSelected(false);
		fen.A5.setSelected(false);
	}

	public int getTotalInf(){return totalinf;}

	public void setTotalInf(int i){
		totalinf=totalinf+i;
	}

	public int getSomme(){return somme;}

	public void setSomme(int i){
		somme=somme+i;
	}

	public void initSomme(){somme=0;}

	public int getTotalSup(){return totalsup;}

	public void setTotalSup(int i){
		totalsup=totalsup+i;
	}

	public void brelan(int t[],int joueur){
		for (int i = 0; i < 3; i++) {
			if(t[i]==t[i+1]&&t[i+1]==t[i+2]){setScore(getJoueur(),10);}
			else{setScore(getJoueur(),0);}
		}
	}

	public void full(int t[],int joueur){
		for (int i = 0; i < 3; i++) {
			if(t[i]==t[i+1]&&t[i+1]==t[i+2]){setScore(getJoueur(),30);}
			else{setScore(getJoueur(),0);}
		}
	}

	public void carre(int t[],int joueur){
		for (int i = 0; i < 2; i++) {
			if(t[i]==t[i+1]&&t[i+1]==t[i+2]&&t[i+2]==t[i+3]){setScore(getJoueur(),40);}
			else{setScore(getJoueur(),0);}
		}
	}
	//verif etajout score de la partie sup
	public void compAdd(Fenetre fen, int i){
		v = Integer.parseInt(fen.dé1.getText());
		w= Integer.parseInt(fen.dé2.getText());
		x = Integer.parseInt(fen.dé3.getText());
		y = Integer.parseInt(fen.dé4.getText());
		z = Integer.parseInt(fen.dé5.getText());
		if(v!=i){v=0;}
		if(w!=i){w=0;}
		if(x!=i){x=0;}
		if(y!=i){y=0;}
		if(z!=i){z=0;}

		setSomme(z+x+y+v+w);
	}
	//methode pour partie inf recupe dans un tableau puis tri et enfin comparaison.
	//explication fen,pas besoin, C c'est le numero de ce qu'on veut verifier, joueur le num du joueur
	public void compAdd2(Fenetre fen,int c,int joueur){
		tri[0] = Integer.parseInt(fen.dé1.getText());
		tri[1]= Integer.parseInt(fen.dé2.getText());
		tri[2] = Integer.parseInt(fen.dé3.getText());
		tri[3] = Integer.parseInt(fen.dé4.getText());
		tri[4] = Integer.parseInt(fen.dé5.getText());
		type=c;
		Arrays.sort(tri);///on tri le tableau

		switch(type){//et selon ce qu'on veut verifier on donne le numero
			case 1://case du brelan
				brelan(tri,getJoueur());
				break;
			case 2 :
				full(tri,getJoueur());
				break;
			case 3 :
				carre(tri,getJoueur());
				break;}

		for (int i = 0; i <tri.length ; i++) {
			System.out.print(tri[i]);
		}

	}

}


    




import javax.swing.*;
import java.util.Random;

/**
 * Created by nico on 08/11/15.
 */
public class Model {

    int rand= (int)(6.0 * Math.random()) + 1;

    public int init(){
        return 0;
    }

    public int getRand(){

        return rand;
    }
/*

    private float noteAnglais;
    private int coeffAnglais;

    private float noteMaths;
    private int coeffMaths;

    private float noteGeo;
    private int coeffGeo;

    private float noteInfo;
    private int coeffInfo;

    // doit-on prendre en compte les coefficients ?
    private boolean isCoeffActive;


    // toutes les options possibles
    final int NOOPTION = 0;
    final int LATIN = 1;
    final int GREC = 2;
    final int SPORT = 3;

    private float noteOption;
    private int numOption;


    Model() {

        noteAnglais = 0;
        coeffAnglais = 1;

        noteMaths = 0;
        coeffMaths = 1;

        noteGeo = 0;
        coeffGeo = 1;

        noteInfo = 0;
        coeffInfo = 1;

        noteOption = 0;
        numOption = 0;

        isCoeffActive = true;
    }

    /*------------- les set des matieres obligatoires ----------------*/
    /*
     * Lorsque l'on set une note, si celle-ci n'est pas entre 0 et 20,
     * alors on genere l'exception NoteOutOfBound. De meme, lorsque
     * l'on set un coefficient, si celui-ci n'est pas entre 1 et 3,
     * alors on genere l'exception CoeffOutOfBound. Le code de ces
     * exception est en bas du fichier.
     */
/*
    void setNoteAnglais(float noteAnglais) throws NoteOutOfBound {

        if( noteAnglais < 0 | noteAnglais > 20 )
            throw new NoteOutOfBound("Anglais", noteAnglais);
        else
            this.noteAnglais = noteAnglais;
    }

    void setCoeffAnglais(int coeffAnglais) throws CoeffOutOfBound {

        if( coeffAnglais < 1 | coeffAnglais > 3)
            throw new CoeffOutOfBound("Anglais", coeffAnglais);

        else
            this.coeffAnglais = coeffAnglais;
    }

    void setNoteMaths(float noteMaths) throws NoteOutOfBound {

        if( noteMaths < 0 | noteMaths > 20 )
            throw new NoteOutOfBound("Mathematiques", noteMaths);
        else
            this.noteMaths = noteMaths;
    }

    void setCoeffMaths(int coeffMaths) throws CoeffOutOfBound {

        if( coeffMaths < 1 | coeffMaths > 3)
            throw new CoeffOutOfBound("Mathematiques", coeffMaths);

        else
            this.coeffMaths = coeffMaths;
    }

    void setNoteInfo(float noteInfo) throws NoteOutOfBound {

        if( noteInfo < 0 | noteInfo > 20 )
            throw new NoteOutOfBound("Informatique", noteInfo);
        else
            this.noteInfo = noteInfo;
    }

    void setCoeffInfo(int coeffInfo) throws CoeffOutOfBound {

        if( coeffInfo < 1 | coeffInfo > 3)
            throw new CoeffOutOfBound("Informatique", coeffInfo);

        else
            this.coeffInfo = coeffInfo;
    }

    void setNoteGeo(float noteGeo) throws NoteOutOfBound {

        if( noteGeo < 0 | noteGeo > 20 )
            throw new NoteOutOfBound("Geographie", noteGeo);
        else
            this.noteGeo = noteGeo;
    }

    void setCoeffGeo(int coeffGeo) throws CoeffOutOfBound {

        if( coeffGeo < 1 | coeffGeo > 3)
            throw new CoeffOutOfBound("Geographie", coeffGeo);

        else
            this.coeffGeo = coeffGeo;
    }

    void setCoeffActive(boolean state) {
        isCoeffActive = state;
    }

    /*------------- les get des matieres obligatoires ----------------*/

/*
    float getNoteAnglais() {
        return noteAnglais;
    }

    int getCoeffAnglais() {
        return coeffAnglais;
    }

    float getNoteMaths() {
        return noteMaths;
    }

    int getCoeffMaths() {
        return coeffMaths;
    }

    float getNoteInfo() {
        return noteInfo;
    }

    int getCoeffInfo() {
        return coeffInfo;
    }

    float getNoteGeo() {
        return noteGeo;
    }

    int getCoeffGeo() {
        return coeffGeo;
    }

    boolean getIsCoeffActive() {
        return isCoeffActive;
    }

    /*------------------------ les options ----------------------*/
/*
    // idem notes obligatoires
    void setNoteOption(float noteOption) throws NoteOutOfBound {

        if( noteOption < 0 | noteOption > 20 )
            throw new NoteOutOfBound("Option", noteOption);
        else
            this.noteOption = noteOption;
    }

    // l'exception generee est differente, car le message d'erreur doit l'etre aussi
    void setNumOption(int numOption) throws NumOptionOutOfBound {

        if( numOption < 0 | numOption > 3)
            throw new NumOptionOutOfBound(numOption);

        else
            this.numOption = numOption;
    }

    // s'il n'y a pas d'option choisie, genere une exception
    float getNoteOption() throws SansOptionException {

        if( numOption == NOOPTION )
            throw new SansOptionException("il n'y a pas d'option");
        else
            return noteOption;
    }

    int getNumOption() {
        return numOption;
    }


    int calculerCoeffOption(){

        switch( numOption ) {
            case LATIN :
            case GREC :
                return 2;
            case SPORT :
                return 1;
            default : // pas d'option
                return 0;
        }
    }

    /*-------------------------------- la moyenne ------------------------------*/
    /*
     * calcul la moyenne en prennant en compte s'il y a une option choisie ou non,
     * et si les coefficients doivent etre consideres ou non.
     */
/*

    float calculerMoyenne() {

        if( isCoeffActive ) {

            if( numOption == NOOPTION )

                return ( noteAnglais*coeffAnglais + noteInfo*coeffInfo
                        + noteMaths*coeffMaths + noteGeo*coeffGeo )
                        / ( coeffAnglais + coeffInfo + coeffMaths + coeffGeo );
            else {

                int coeffOption = calculerCoeffOption();
                return
                        ( noteAnglais*coeffAnglais + noteInfo*coeffInfo + noteMaths*coeffMaths
                                + noteGeo*coeffGeo + noteOption*coeffOption )
                                / ( coeffAnglais + coeffInfo + coeffMaths + coeffGeo + coeffOption );
            }
        }
        else
        if( numOption == NOOPTION )
            return ( noteAnglais + noteInfo + noteMaths + noteGeo ) / 4;
        else
            return ( noteAnglais + noteInfo + noteMaths + noteGeo + noteOption ) / 5;
    }



}

/* Nouvelles classes d'exception */

/*
class NoteOutOfBound extends Exception {

    NoteOutOfBound(String matiere, float note) {
        super(
                "Attention, la note en "+matiere+" n'est pas correcte.\n "
                        + "Vous devez entrer une note comprises entre 0 et 20,\n"
                        + " mais vous avez saisi : "+ note
        );
    }
}

class CoeffOutOfBound extends Exception {

    CoeffOutOfBound(String matiere, int coeff) {
        super(
                "Attention, le coefficient en "+matiere+" n'est pas correct.\n "
                        + "Vous devez entrer un coefficient compris entre 1 et 3,\n"
                        + " mais vous avez saisi : "+ coeff
        );
    }
}

class NumOptionOutOfBound extends Exception {

    NumOptionOutOfBound(int numOption) {
        super(
                "Attention, le numero de l'option choisi n'est pas correct.\n "
                        + "Vous devez entrer un numero compris entre 0 et 3,\n"
                        + " mais vous avez saisi : "+ numOption
        );
    }
}

class SansOptionException extends Exception {

    SansOptionException(String message) {
        super(message);
    }*/
}

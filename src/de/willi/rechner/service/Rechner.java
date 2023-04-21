package de.willi.rechner.service;

import de.willi.rechner.bean.Berechnung;
import de.willi.rechner.exeption.FalseImputException;
import de.willi.rechner.exeption.NumberToBigException;
import de.willi.rechner.parser.Parser;

import java.util.ArrayList;
import java.util.List;

public class Rechner {

    private Parser parser;
    private List<Operation> operationen;

    public Rechner() {
        this.parser = new Parser();
        this.operationen = new ArrayList<Operation>();
        this.operationen.add(new Addieren());
        this.operationen.add(new Substrahieren());
        this.operationen.add(new Multiplizieren());
        this.operationen.add(new Dividieren());
    }

    public Berechnung execute(String eingabe) throws FalseImputException, NumberToBigException {

        // Eingabe Parsen
        Berechnung berechnung = this.parser.parse(eingabe);

        // Berechnung holen
        Operation operation = getOperation(berechnung);

        // Rechnen
        operation.rechnen(berechnung);

        return berechnung;

    }

    private Operation getOperation(Berechnung berechnung){
        for (Operation operation: this.operationen) {
            if (berechnung.getOperante().equals("+")) {
                if (operation instanceof Addieren) {
                    return operation;
                }
            } else if (berechnung.getOperante().equals("-")) {
                if (operation instanceof Substrahieren) {
                    return operation;
                }
            } else if (berechnung.getOperante().equals("*")) {
                if (operation instanceof Multiplizieren) {
                    return operation;
                }
            } else if (berechnung.getOperante().equals("/")) {
                if (operation instanceof Dividieren) {
                    return operation;
                }
            }
        }
        return null;
    }

    /*
    public void setZahl(float zahl1, float zahl2){
        this.zahl1 = zahl1;
        this.zahl2 = zahl2;
    }

    public float addiere(){
        return zahl1 + zahl2;
    }

    public float subtrahieren() {
        return zahl1 - zahl2;
    }

    public float dividieren() {
        return zahl1 / zahl2;
    }

    public float multiplizieren() {
        return zahl1 * zahl2;
    }



    public float execute() {
        float ergebnis= 0f;
        if (operante.equals("+")){
            ergebnis = addiere();
        }else if (operante.equals("-")) {
            ergebnis = subtrahieren();
        }else if (operante.equals("*")) {
            ergebnis = multiplizieren();
        }else if (operante.equals("/")){
            ergebnis = dividieren();
        }
        return ergebnis;
    }
     */
}

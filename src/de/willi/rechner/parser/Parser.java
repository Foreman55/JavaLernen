package de.willi.rechner.parser;

import de.willi.rechner.bean.Berechnung;
import de.willi.rechner.exeption.FalseImputException;
import de.willi.rechner.exeption.NumberToBigException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    final static String REGEX = "([0-9]{1,10})[ ]*([/+\\-*])[ ]*([0-9]{1,10})";

    public Berechnung parse(String eingabe) throws FalseImputException, NumberToBigException {
        Berechnung berechnung = new Berechnung();
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(eingabe);
        if (matcher.matches()) {
            berechnung.setZahl1(Float.parseFloat(matcher.group(1)));
            berechnung.setOperante(matcher.group(2));
            berechnung.setZahl2(Float.parseFloat(matcher.group(3)));
            if(berechnung.getZahl1() >= 100 || berechnung.getZahl2() >= 100){
                throw new NumberToBigException("Zahl ist größer als 100");
            }
        }else{
            //System.out.println("Please enter number");
            throw new FalseImputException("Die Eingabe ist Falsch, sie darf nur Zahlen enthalten.");
        }
        return berechnung;
    }
}

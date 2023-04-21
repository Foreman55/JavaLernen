package de.willi.rechner;

import de.willi.rechner.service.Rechner;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRechner {
    // Client-Code
    public static void main(String[] args) {
        /*
        // Starten wir unsern Rechner
        final String REGEX = "([0-9]{1,10})[ ]*([/+\\-*])[ ]*([0-9]{1,10})";
        Rechner rechner = new Rechner();
        rechner.setZahl(10, 20);
        float ergebnis = rechner.addiere();
        System.out.println("Ergebnis: " + ergebnis);
        // Eingabe
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter numbers separated by operator.");
            String eingabe = scanner.nextLine();
            Pattern pattern = Pattern.compile(REGEX);
            Matcher matcher = pattern.matcher(eingabe);
            if(matcher.matches()) {
                rechner.parseInputString(eingabe);
                ergebnis = rechner.execute();
                System.out.println("Ergebnis: " + ergebnis);
            }else{
                System.out.println("false");
            }
        }



















        /*
        // Regex Reguläre Ausdrücke
        String regex = "([0-9]{1,10})[ ]*([/+\\-*])[ ]*([0-9]{1,10})";
        Pattern pattern = Pattern.compile(regex);

        Scanner scanner = new Scanner(System.in);
        while (true){
            String eingabe = scanner.nextLine();
            System.out.println(eingabe);
            Matcher matcher = pattern.matcher(eingabe);
            System.out.println(matcher.matches());
            if (matcher.matches()){
                System.out.println(matcher.groupCount());
                int zahl1 = Integer.parseInt(matcher.group(1));
                String operant = matcher.group(2);
                int zahl2 = Integer.parseInt( matcher.group(3));

                float ergebnis = 0f;
                if (operant.equals("+")){
                    ergebnis = zahl1 + zahl2;
                }else if (operant.equals("-")) {
                    ergebnis = zahl1 - zahl2;
                }else if (operant.equals("*")) {
                    ergebnis = zahl1 * zahl2;
                }else if (operant.equals("/")){
                    ergebnis = zahl1 / zahl2;
                }


                System.out.println(zahl1 + " " + operant + " " + zahl2 + " = " + ergebnis);
            }





            if (eingabe.equals("exit")){
                scanner.close();
                break;
            }
         */

    }
}

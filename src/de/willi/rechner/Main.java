package de.willi.rechner;

import de.willi.rechner.bean.Berechnung;
import de.willi.rechner.exeption.FalseImputException;
import de.willi.rechner.exeption.NumberToBigException;
import de.willi.rechner.service.Rechner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FalseImputException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter numbers separated by operator.");
            String eingabe = scanner.nextLine();
            Rechner rechner = new Rechner();
            try {
                Berechnung berechnung = rechner.execute(eingabe);
                System.out.println(berechnung);
            } catch (FalseImputException e) {
                System.out.println("FalseINputException: " + e.getMessage());
            } catch (NumberToBigException e) {
                System.out.println("NumberToBigException: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }
    }
}

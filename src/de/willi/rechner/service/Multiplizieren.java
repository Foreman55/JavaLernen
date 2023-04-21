package de.willi.rechner.service;

import de.willi.rechner.bean.Berechnung;

public class Multiplizieren implements Operation{
    @Override
    public void rechnen(Berechnung berechnung) {
        float zahl1 = berechnung.getZahl1();
        float zahl2 = berechnung.getZahl2();
        float ergebnis = zahl1 * zahl2;
        berechnung.setErgebnis(ergebnis);
    }
}

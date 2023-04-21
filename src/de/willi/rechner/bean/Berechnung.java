package de.willi.rechner.bean;

public class Berechnung {

    private float zahl1;
    private float zahl2;
    private String operante;
    private float ergebnis;

    public float getZahl1() {
        return zahl1;
    }

    public void setZahl1(float zahl1) {
        this.zahl1 = zahl1;
    }

    public float getZahl2() {
        return zahl2;
    }

    public void setZahl2(float zahl2) {
        this.zahl2 = zahl2;
    }

    public String getOperante() {
        return operante;
    }

    public void setOperante(String operante) {
        this.operante = operante;
    }

    public float getErgebnis() {
        return ergebnis;
    }

    public void setErgebnis(float ergebnis) {
        this.ergebnis = ergebnis;
    }

    @Override
    public String toString() {
        return "Berechnung{" +
                "zahl1=" + zahl1 +
                ", zahl2=" + zahl2 +
                ", operante='" + operante + '\'' +
                ", ergebnis=" + ergebnis +
                '}';
    }
}

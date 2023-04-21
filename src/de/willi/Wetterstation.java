package de.willi;

public class Wetterstation {

    private int temperatur;
    private int luftfeuchtigkeit;


    // Konstruktor
    public Wetterstation() {
        System.out.println("Mit Wetterstation verbinden");
        System.out.println("Daten auslesen von Wetterstation");
    }

    // Konstrutkor
    public Wetterstation(int temperatur, int luftfeuchtigkeit) {
        this.temperatur = temperatur;
        this.luftfeuchtigkeit = luftfeuchtigkeit;
    }

    // Konstrutkor
    public Wetterstation(String station) {
        System.out.println(station);
    }
}

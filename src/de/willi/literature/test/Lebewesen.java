package de.willi.literature.test;

public class Lebewesen {

    private int nr;

    public void printInfo(){
        System.out.println("Nr: " + this.nr);
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }
}

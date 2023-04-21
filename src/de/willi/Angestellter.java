package de.willi;

public class Angestellter extends Person implements Drucken {

    private String beruf;
    private int personalId;

    public Angestellter(String name, int alter, char male, String beruf, int personalId){
        this.beruf = beruf;
        this.personalId = personalId;
        super.setName(name);
        super.setMale(male);
    }


    public String getMyName() {
        return super.getMyName() + ", " + this.beruf + ", " + this.personalId;
    }

    public String getMyNameAngestelter() {
        return super.getMyName() + ", " + this.beruf + ", " + this.personalId;
    }

    public String getBeruf() {
        return beruf;
    }

    public void setBeruf(String beruf) {
        this.beruf = beruf;
    }

    public int getPersonalId() {
        return personalId;
    }

    public void setPersonalId(int personalId) {
        this.personalId = personalId;
    }

    @Override
    public String toString() {
        return "Angestellter{" +
                "beruf='" + beruf + '\'' +
                ", personalId=" + personalId +
                '}';
    }

    @Override
    public String drucken() {
        return "Angestellter{" +
                "beruf='" + beruf + '\'' +
                ", personalId=" + personalId +
                '}';
    }
}

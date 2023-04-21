package de.willi.literature.beans;

public class IndividualCharacter {
    public char individualCharacter;
    public int charFrequency;

    public int getCharFrequency() {
        return charFrequency;
    }

    public void setCharFrequency(int charFrequency) {
        this.charFrequency = charFrequency;
    }

    public void addCharFrequency(){
        this.charFrequency = this.charFrequency + 1;
    }

    public char getIndividualCharacter() {
        return individualCharacter;
    }

    public void setIndividualCharacter(char individualCharacter) {
        this.individualCharacter = individualCharacter;
    }
}

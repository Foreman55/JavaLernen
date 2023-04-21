package de.willi.Interface;

public class TXT implements Document{
    private String text= " Ich bin ein text document";

    @Override
    public String getCoordinates() {
        return text;
    }
}

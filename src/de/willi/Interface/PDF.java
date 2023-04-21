package de.willi.Interface;

public class PDF implements Document{

    private String text= " Ich bin ein PDF document";

    @Override
    public String getCoordinates() {
        return text;
    }
}

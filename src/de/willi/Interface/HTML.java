package de.willi.Interface;

public class HTML implements Document{
    private String text= " Ich bin ein HTML document";
    private String yoyo = "Ich bin ein berliner";

    @Override
    public String getCoordinates() {
        return text;
    }
}

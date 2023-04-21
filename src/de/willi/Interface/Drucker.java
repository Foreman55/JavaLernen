package de.willi.Interface;

public class Drucker{

    public void print(Document document){
        String coordinates = document.getCoordinates();
        System.out.println(coordinates);
    }

}

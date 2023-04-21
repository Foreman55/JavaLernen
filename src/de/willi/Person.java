package de.willi;

import java.util.Locale;

public class Person {

    // Instanzvariablen
    private String name;
    private int alter;
    private char male;

    private final static int CURRENT_YEAR = 2022;

    public Person() {

    }

    public Person(String name, int alter, char male) {
        this.name = name;
        this.alter = alter;
        this.male = male;
    }

    public String getMyName(){
        return this.name + ", " + this.alter + ", " + this.male;
    }

    // Methoden
    // modifer return methodenBezeichner(int alter, String name, char male)
    public void setName(String name){
        this.name = name.toUpperCase(Locale.ROOT);
    }

    public String getName(){
        return this.name.toLowerCase(Locale.ROOT);
    }

    public void setAlter(int alter){
       this.alter = alter;
    }

    public int getAlter(){
        return this.alter;
    }

    public void setMale(char male){
        this.male = male;
    }

    public char getMale(){
        return this.male;
    }

    public String getAllData(){
        return this.name + ", " + this.alter + ", " +  this.male;
    }

    public int getGeburtsJahr(){
        return this.CURRENT_YEAR - this.alter;

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", alter=" + alter +
                ", male=" + male +
                '}';
    }
}

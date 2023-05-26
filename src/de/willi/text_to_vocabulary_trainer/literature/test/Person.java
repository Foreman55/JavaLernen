package de.willi.text_to_vocabulary_trainer.literature.test;

public class Person extends Lebewesen{

    private String name;

    public void printInfo(){
        super.printInfo();
        System.out.println("Name: " + this.name);
    }


    public void setName(String name) {
        this.name = name;
    }
}

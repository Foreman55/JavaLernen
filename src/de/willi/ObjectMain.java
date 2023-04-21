package de.willi;

public class ObjectMain {

    public static void main(String[] args) {

        System.out.println("START");
        // Klass vs Object
        Person sebastian = new Person("sebastian", 41, 'm');
        //sebastian.setName("sebastian");
        //sebastian.setAlter(41);
        //sebastian.setMale('m');


        Person sebastian2 = sebastian;
        sebastian2.setAlter(42);
        System.out.println("sebastian2 " + sebastian2.toString());
        System.out.println("sebastian " + sebastian);


        int alter = 41 ;
        int alter2 = alter;
        alter2++;
        System.out.println(alter);
        System.out.println(alter2);

        Person willi = new Person();
        willi.setName("Willi");
        willi.setAlter(41);
        willi.setMale('m');

        // Ausgabe
        System.out.println(sebastian.getAllData());
        System.out.println(willi.getAllData());
        System.out.println(willi.getGeburtsJahr());

        // Vererbung
        Person angestellter1 = new Angestellter("Günter", 58, 'M', "Softwareentwickler", 1);
        //Angestellter angestellter2 = new Angestellter( "beruf", 1);
        //angestellter1.setName("Günter");
        //angestellter1.setAlter(50);
        //angestellter1.setMale('M');
        System.out.println(angestellter1.getMyName());

        // Polymorph Drucken
        Drucker drucker = new Drucker();
        drucker.print((Drucken)angestellter1);

        // Wetterstation
        Wetterstation wetterstation = new Wetterstation("");
        /*
        for (int i = 0; i < 100; i++){
            int temperatur = wetterstation.getTemperatur();
            if (temperatur >= 30){
                System.out.println("Sende an Schulen Hitzefrei");
            }
        }
        */

        // Wir drucken Person


    }

    public static void druckeName(){

    }

}

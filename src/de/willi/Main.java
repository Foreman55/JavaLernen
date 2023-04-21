package de.willi;

public class Main {

    public static void main(String[] args) {

        /***************** Kommentar test ***********************/
        // Einziges Kommentar
        /*
        Mehr zeilige Kommentar
        Nächste Zeile
         */

        /******************* Variablen *********************/
        // Primitive Datentypen: byte, short, int, long - float, double - boolean - char
        // Das ist ein Object: String

        // Escape-Zeichen \n \\ \t
        System.out.println("\"\n\t\\");

        // Numerischen
        byte number = 0;
        { // Scope 1
             number = 3;
             byte number2 = 2;
            {

            }
        }

        { // Scope 2
             number = 2;
        }

        // Konstanten werden immer groß geschrieben und können nicht mehr verändert werden
        final int LOHN_VON_SEBASTIAN = 1000;

        /************** Rechnen **************************/
        int zahl1 = 10;
        int zahl2 = 20;
        String zahl3 = "30";
        int zahl4 = 10;
        int sum = zahl1 + zahl2;
        String sum2 = (zahl1 + zahl2) * (2 + 10) + zahl3 + zahl4;
        System.out.println((2 + 3) * 10); // 3603010

        int alter = 18;

        if (/*boolscher-operator*/alter == 18){
            System.out.println("Du bist Volljährig");
        }else if (/*boolscher-operator*/alter < 18) {
            System.out.println("Du bist zujung");

        } else {
            System.out.println("Du bist zu alt");
        }

        // Imperative Beschreibung bung
        switch (alter){
            case 17:
                System.out.println("Du bist 7");
            case 18:
                System.out.println("Du bist volljährig");
            case 19:
                System.out.println("Du bist zu alt");
            default:
                System.out.println("Default");
        }

        // Schleifen
        int count = 3;
        while (count >= 0){
            System.out.println("While-Schleife " + count--);
        }

        for (int a = 0; a < 100; a++){
            System.out.println("For-Schleife " + a);
        }

        do {
            count++;
            System.out.println("Do-While-Schleife " + count);
        }while (count <=2);

        // Boolsche-Operatoren
        boolean ist = (1 == 1 | (1 != 1 & 1 == 2)) & (1 >= 1 & 1 > 1);

        // Arrays
        int menge = 2;
        /*
        int[] mengen = new int[4];
        mengen[0] = 10;
        mengen[1] = 2;
        mengen[2] = 9;
        mengen[3] = 11;
        */
        int[] mengen = {1,3,12,17,12,33,21};

        //System.out.println(mengen[3]);
        mengen[1] = mengen[1] * 5;
        System.out.println(mengen[1]);
        for(int i = 0; i <= mengen.length; i++){
            System.out.println(mengen[i]);
        }
        int[][] multi = new int[5][5];
        multi[2][0] = 1;

        String name[] = new String[3];
        name[0] = "eins";
        name[1] = "zwei";

        for (String s: name){
            System.out.println(s);
        }

    }

}

package de.willi.Interface;

public class Main {
    public static void main(String[] args) {
        String document = " Hello my name is William";
        Drucker drucker = new Drucker();
        TXT text = new TXT();
        PDF pdf = new PDF();
        HTML html = new HTML();

        drucker.print(pdf);
        drucker.print(html);
        drucker.print(text);


    }
}

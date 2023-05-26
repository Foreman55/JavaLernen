package de.willi.text_to_vocabulary_trainer.literature.test;

public class MainTestConstructor {

    public static void main(String[] args) {
        Object tc = TestConstructor.getInstance();
        System.out.println(tc);
        tc = TestConstructor.getInstance();
        System.out.println(tc);
        tc = TestConstructor.getInstance();
        System.out.println(tc);
    }
}

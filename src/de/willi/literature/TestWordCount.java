package de.willi.literature;

public class TestWordCount {

    public static void main(String[] args) {
        String a[] = "hallo,eins,hallo,zwei".split(",");
        WordCount wc = new WordCount();
        wc.countWord(a);
    }
}

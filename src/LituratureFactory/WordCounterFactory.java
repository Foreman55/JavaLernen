package LituratureFactory;

import LituratureFactory.Counter;
import LituratureFactory.SimpleWordCounter;

public class WordCounterFactory {
    public static int createWordCounter(String text) {
        SimpleWordCounter sc = new SimpleWordCounter();
        int wordCount =   sc.countWords(text);
        return wordCount;
    }
}

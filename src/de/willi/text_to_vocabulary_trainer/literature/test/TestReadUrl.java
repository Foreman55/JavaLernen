package de.willi.text_to_vocabulary_trainer.literature.test;

import de.willi.text_to_vocabulary_trainer.literature.service.LituratureService;

import java.net.MalformedURLException;
import java.net.URL;

public class TestReadUrl {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https://www.gutenberg.org/cache/epub/69307/pg69307.txt");
        LituratureService lit =  LituratureService.getInstance();
        String literatur = lit.readFromUrl(url);
        System.out.println(literatur);
    }
}

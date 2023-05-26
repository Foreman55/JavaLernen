package de.willi.text_to_vocabulary_trainer.literature.test;


import de.willi.text_to_vocabulary_trainer.literature.service.LituratureService;

import java.net.MalformedURLException;
import java.net.URL;

public class LetterCount {
    public static void main(String[] args) throws MalformedURLException {
        LituratureService lituratureService = new LituratureService();
        String text = lituratureService.readFromUrl(new URL("https://www.gutenberg.org/cache/epub/69307/pg69307.txt"));


        int[] letterCount = new int[26];
        for (int i = 0; i < 26; i++) {
            letterCount[i] = 0;
        }

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            c = Character.toLowerCase(c);
            int index = c - 'a';
            if (index >= 0 && index < 26) {
                letterCount[index]++;
            }
        }

        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            System.out.println(c + ": " + letterCount[i]);
        }
    }
}
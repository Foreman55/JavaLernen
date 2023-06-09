package de.willi.text_to_vocabulary_trainer.literature;

import de.willi.text_to_vocabulary_trainer.literature.beans.UniqueWord;
import de.willi.text_to_vocabulary_trainer.literature.service.LituratureService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Main {

    // Hallo Sebastian 2
    public static void main(String[] args) throws MalformedURLException {
        LituratureService lituratureService =  LituratureService.getInstance();
        //String liturature = lituratureService.readLituratureFromFileSystemToString(new File("/Users/williamhall/Desktop/adroune bonner.txt"));
        String liturature = lituratureService.readFromUrl(new URL("https://www.gutenberg.org/cache/epub/69307/pg69307.txt"));
        System.out.println("liturature length: " + liturature.length());
        String[] rawWords = lituratureService.cleanAndGetWords(liturature);
        int countAllWords = lituratureService.countWords(rawWords);
        System.out.println("rawWords " + countAllWords);
        List<String> uniqueWords = lituratureService.uniqueWordListBuilder(rawWords);
        List<UniqueWord> uniqueWords1 = lituratureService.frecuencyBuilder(uniqueWords, List.of(rawWords));

        lituratureService.sortByWordFrequency(uniqueWords1);
        int counter = 0;
        for(UniqueWord u: uniqueWords1) {
            counter++;
            System.out.println(counter + " " + u.getUniqueName() + ": " + u.getWordFrequency());
        }
    }
}

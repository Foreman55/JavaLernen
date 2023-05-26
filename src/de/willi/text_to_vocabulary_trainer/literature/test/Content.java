package de.willi.text_to_vocabulary_trainer.literature.test;

import java.io.IOException;
import java.net.URL;

public class Content {
    private String textFromURL;

    public String content(URL url) throws IOException {
        Object content = url.getContent();
        System.out.println("Class: " + content.getClass());
        textFromURL =  content.toString();
        return textFromURL;
    }

    @Override
    public String toString() {
        return "the content is " + textFromURL;
    }
}

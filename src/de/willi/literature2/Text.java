package de.willi.literature2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Text {
    URL url = new URL(null);
    StringBuffer rawText;
    String cleanText;
    List<IndividualWords> wordsAndFrequency;

    public Text(URL url) throws MalformedURLException {
        this.url = url;
    }
}

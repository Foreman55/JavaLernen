package de.willi;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class TestJSoup {

    public static void main(String[] args) throws IOException {
        String html = "<html><head></head><body><style>h1{color:red;}</style><h1>Hallo Will</h1></body></html>";
        //Document doc = Jsoup.connect("http://en.wikipedia.org/wiki/Main_Page").get();
        Document doc = Jsoup.parse(html);
        System.out.println(doc.text());
        /*
        Elements el = doc.select("div#mp-tfa");
        for (Element e : el) {
            System.out.println(e.text());
        }

         */
    }
}

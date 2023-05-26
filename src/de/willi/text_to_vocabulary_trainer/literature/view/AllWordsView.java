package de.willi.text_to_vocabulary_trainer.literature.view;
import de.willi.text_to_vocabulary_trainer.literature.HtmlParser;
import de.willi.text_to_vocabulary_trainer.literature.beans.Constant;
import de.willi.text_to_vocabulary_trainer.literature.beans.Document;
import org.jsoup.Jsoup;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AllWordsView {
    public static String renderView(Document document) throws IOException {

        HtmlParser htmlParser = new HtmlParser();
        String htmlTemplate = htmlParser.getHtml();
        StringBuffer htmlContent = new StringBuffer();
        String rawText = document.getRawText();
        org.jsoup.nodes.Document doc = Jsoup.parse(rawText);
        String yoyoma = doc.text();
        htmlContent.append("<p>");
        htmlContent.append(yoyoma);
        htmlContent.append("</p>");
        String html = "";
        String buttons = "";
        Path pathbuttons = Paths.get(Constant.PATH_TEMPLATE_FOLDER + File.separator + "buttons.html");
        for (String line: Files.readAllLines(pathbuttons)){
            buttons += line + "\n";
        }
        try {
            html = htmlTemplate.replaceAll("<!--CONTENT-->", htmlContent.toString()).replaceAll("<!--buttons-->", buttons);
        }catch (Throwable t){
            System.out.println("fehler " + t.getMessage());
            t.printStackTrace();
            html = htmlTemplate.replaceAll("<!--CONTENT-->", "fehler");
        }
        return html;
    }
}

package de.willi.literature.view;
import de.willi.literature.HtmlParser;
import de.willi.literature.beans.Document;
import org.jsoup.Jsoup;

public class AllWordsView {
    public static String renderView(Document document){

        HtmlParser htmlParser = new HtmlParser();
        String htmlTemplate = htmlParser.getHtml();
        StringBuffer htmlContent = new StringBuffer();
        String rawText = document.getRawText();
        org.jsoup.nodes.Document doc = Jsoup.parse(rawText);
        String yoyoma = doc.text();
        htmlContent.append("<p>");
        htmlContent.append(yoyoma);
        htmlContent.append("</p>");
        String html =  htmlTemplate.replaceAll("<!--CONTENT-->", htmlContent.toString());

        return html;
    }
}

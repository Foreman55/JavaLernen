package de.willi.literature.view;

import de.willi.literature.HtmlParser;
import de.willi.literature.beans.Document;
import de.willi.literature.beans.UniqueWord;

import java.util.List;

public class WordCounterView {

    public static String renderView(Document document){
        HtmlParser htmlParser = new HtmlParser();
        String htmlTemplate = htmlParser.getHtml();
        StringBuffer htmlContent = new StringBuffer();
        List<UniqueWord> uniqueWords = document.getUniqueWords();
        htmlContent.append("<table>");
        htmlContent.append("<tr>");
        htmlContent.append("<th>Anzahl</th>");
        htmlContent.append("<th>Word</th>");
        htmlContent.append("</tr>");
        for (UniqueWord uniqueWord : uniqueWords) {
            htmlContent.append("<tr>");
            htmlContent.append("<td>" + uniqueWord.getWordFrequency() + "</td>");
            // Kürzt das Wort auf 15 Zeichen, wenn es länger ist
            if(uniqueWord.getUniqueName().length() > 15){
                htmlContent.append("<td>" + uniqueWord.getUniqueName().substring(0,15) + "...</td>");
            }else{
                htmlContent.append("<td>" + uniqueWord.getUniqueName() + "</td>");
            }
            htmlContent.append("</tr>");
        }
        htmlContent.append("</table>");
        String html =  htmlTemplate.replaceAll("<!--CONTENT-->", htmlContent.toString());
        return html;
    }

}

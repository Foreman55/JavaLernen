package de.willi.text_to_vocabulary_trainer.literature.view;

import de.willi.text_to_vocabulary_trainer.bucket.beans.Bucket;
import de.willi.text_to_vocabulary_trainer.bucket.beans.Vocabulary;
import de.willi.text_to_vocabulary_trainer.literature.HtmlParser;
import de.willi.text_to_vocabulary_trainer.literature.beans.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WordCounterView {

    public static String renderView(Document document, Bucket bucket) throws IOException {
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
            // protokoll://domain:port/path/path/datei.html?key=value&key=value
            List<Vocabulary> bucketList = bucket.getVocabularyList();
            boolean card = false;
            FlashCard playCard = null;
            for(Vocabulary v : bucketList){
                if(v.getWord().equals(uniqueWord.getUniqueName())){
                    card = true;
                    //playCard = uniqueWord.getUniqueName();
                }
            }

            if (card){
                htmlContent.append("<td><a href='http://localhost:8080/ls?word=" + uniqueWord.getUniqueName() + "&action=unsaveWord'>unsave</a></tr>");
                htmlContent.append("</tr>");
                FlashCards.getInstance().setPlayCard(playCard);

            }else{
                htmlContent.append("<td><a href='http://localhost:8080/ls?word=" + uniqueWord.getUniqueName() + "&action=saveWord'>save</a></tr>");
                htmlContent.append("</tr>");
            }
        }
        htmlContent.append("</table>");
        String buttons = "";
        Path pathbuttons = Paths.get(Constant.PATH_TEMPLATE_FOLDER + File.separator + "buttons.html");
        for (String line: Files.readAllLines(pathbuttons)){
            buttons += line + "\n";
        }
        String html =  htmlTemplate.replaceAll("<!--CONTENT-->", htmlContent.toString()).replaceAll("<!--buttons-->", buttons);
        return html;
    }

}

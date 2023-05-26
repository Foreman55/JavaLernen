package de.willi.text_to_vocabulary_trainer.literature.view;

import de.willi.text_to_vocabulary_trainer.bucket.beans.Bucket;
import de.willi.text_to_vocabulary_trainer.bucket.beans.Vocabulary;
import de.willi.text_to_vocabulary_trainer.literature.HtmlParser;
import de.willi.text_to_vocabulary_trainer.literature.beans.Document;
import de.willi.text_to_vocabulary_trainer.literature.beans.FlashCard;
import de.willi.text_to_vocabulary_trainer.literature.beans.FlashCards;
import de.willi.text_to_vocabulary_trainer.literature.beans.UniqueWord;

import java.util.List;

public class BucketView {

    public static String renderView(Document document, Bucket bucket){
        HtmlParser htmlParser = new HtmlParser();
        String htmlTemplate = htmlParser.getHtml();
        StringBuffer htmlContent = new StringBuffer();
        List<Vocabulary> bucketList = bucket.getVocabularyList();
        htmlContent.append("<table>");
        htmlContent.append("<tr>");
        htmlContent.append("</tr>");
        for (Vocabulary b : bucketList) {
            htmlContent.append("<tr>");
            htmlContent.append("<td>" + b.getWord() + "<a href=http://localhost:8080/ls?word=" + b.getWord() + "&action=bucketRemove>    -Remove</a>" + "</td>");
        }
        htmlContent.append("</table>");
        String html =  htmlTemplate.replaceAll("<!--CONTENT-->", htmlContent.toString());
        System.out.println("Bucket contentes " + html);
        return html;
    }

}

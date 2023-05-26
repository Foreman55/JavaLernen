package de.willi.text_to_vocabulary_trainer.literature.view;

import de.willi.text_to_vocabulary_trainer.literature.HtmlParser;
import de.willi.text_to_vocabulary_trainer.literature.beans.FlashCard;
import de.willi.text_to_vocabulary_trainer.literature.beans.FlashCards;

import java.util.List;
import java.util.Random;

public class FlashCardsView {
    public static String renderView(){
        List<FlashCard> cards = FlashCards.getInstance().getFlashCards();
        HtmlParser htmlParser = new HtmlParser();
        String htmlTemplate = htmlParser.getHtml();
        FlashCard flashCard= randomChoice(cards);
        FlashCards.getInstance().setPlayCard(flashCard);
        StringBuffer htmlContent = new StringBuffer();
        htmlContent.append("<p>");
        htmlContent.append(flashCard.getFrontside());
        htmlContent.append("</p>");
        htmlContent.append("<p> Score: " + flashCard.getScore() + "</p>");
        htmlContent.append("<p><a href='http://localhost:8080/ls?word=" + flashCard.getFrontside() + "&action=backside'>Backside</a></p>");
        String html = htmlTemplate.replaceAll("<!--CONTENT-->", htmlContent.toString());
        return html;
    }

    public static FlashCard randomChoice(List<FlashCard> flashCards){

        Random rand = new Random();
        FlashCard randomElement = flashCards.get(rand.nextInt(flashCards.size()));
        return randomElement;

    }
}

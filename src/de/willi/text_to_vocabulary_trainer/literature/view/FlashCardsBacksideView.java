package de.willi.text_to_vocabulary_trainer.literature.view;

import de.willi.text_to_vocabulary_trainer.literature.HtmlParser;
import de.willi.text_to_vocabulary_trainer.literature.beans.FlashCard;
import de.willi.text_to_vocabulary_trainer.literature.beans.FlashCards;

import java.util.List;

public class FlashCardsBacksideView {
    public static String renderView(){

        List<FlashCard> cards = FlashCards.getInstance().getFlashCards();
        HtmlParser htmlParser = new HtmlParser();
        String htmlTemplate = htmlParser.getHtml();
        FlashCard flashCard = FlashCards.getPlayCard();
        StringBuffer htmlContent = new StringBuffer();
        htmlContent.append("<p>");
        htmlContent.append(flashCard.getFrontside());
        htmlContent.append("</p>");
        htmlContent.append("<p> Score: " + flashCard.getScore() + "</p>");
        System.out.println("Backside " + flashCard.getBackside());

        htmlContent.append("<p><a href='http://localhost:8080/ls?word=" + flashCard.getFrontside() + "&action=gotIt'>Got It</a></p>");
        htmlContent.append("<p><a href='http://localhost:8080/ls?word=" + flashCard.getFrontside() + "&action=notGotIt'>Not Got It</a></p>");
        String html = htmlTemplate.replaceAll("<!--CONTENT-->", htmlContent.toString());
        return html;
    }
}

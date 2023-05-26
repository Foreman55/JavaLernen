package de.willi.text_to_vocabulary_trainer.literature.beans;

import java.util.ArrayList;
import java.util.List;

public class FlashCards {
    
    private List<FlashCard> flashCards;
    private static FlashCards flashCardsObject;
    public static FlashCard playCard;

    public static FlashCard getPlayCard() {
        return playCard;
    }

    public void setPlayCard(FlashCard playCard) {
        this.playCard = playCard;
    }

    public List<FlashCard> getFlashCards() {
        return flashCards;
    }

    public void setFlashCards(List<FlashCard> flashCards) {
        this.flashCards = flashCards;
    }

    private FlashCards(){
        flashCards = new ArrayList<>();
    }

    public static FlashCards getInstance(){
        if (flashCardsObject == null){
            flashCardsObject = new FlashCards();
        }
        return flashCardsObject;
    }

    public boolean contains(String word) {
        for(FlashCard f : flashCards){
            if(word.equals(f.getFrontside())){
                return true;
            }
        }
        return false;
    }


    public void save(String word) throws Exception {
       // String translation = Translator.getTranslation(word);
        FlashCard flashCard = new FlashCard(word,"translation",0);
        flashCards.add(flashCard);
    }

    public void unsave(String word){

        for(FlashCard f: flashCards) {
            if (f.getFrontside().equals(word)) {
                flashCards.remove(f);
            }
        }
    }
}

package de.willi.text_to_vocabulary_trainer.literature.beans;

public class FlashCard {
    private String frontside;
    private String backside;
    private int score;

    public void setScore(int score) {
        this.score = score;
    }

    public String getFrontside() {
        return frontside;
    }

    public String getBackside() {
        return backside;
    }

    public int getScore() {
        return score;
    }

    public FlashCard(String frontside, String backside, int score) {
        this.frontside = frontside;
        this.backside = backside;
        this.score = score;
    }
}

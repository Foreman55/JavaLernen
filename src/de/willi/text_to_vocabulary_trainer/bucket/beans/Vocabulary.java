package de.willi.text_to_vocabulary_trainer.bucket.beans;

public class Vocabulary {

    private String word;
    private String translation;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    @Override
    public String toString() {
        return "Vocabulary{" +
                "word='" + word + '\'' +
                ", translation='" + translation + '\'' +
                '}';
    }
}

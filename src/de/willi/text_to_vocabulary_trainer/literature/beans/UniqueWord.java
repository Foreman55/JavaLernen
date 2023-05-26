package de.willi.text_to_vocabulary_trainer.literature.beans;

public class UniqueWord implements Comparable{
    private String uniqueName;
    private int wordFrequency;
    public boolean save = false;

    public void setSave(boolean save) {
        this.save = save;
    }

    public void addWordFrequency(){
        this.wordFrequency = this.wordFrequency + 1;
    }

    public String getUniqueName() {
        return uniqueName;
    }

    public void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }

    public int getWordFrequency() {
        return wordFrequency;
    }

    public void setWordFrequency(int wordFrequency) {
        this.wordFrequency = wordFrequency;
    }

    @Override
    public String toString() {
        return "UniqueWord{" +
                "uniqueName='" + uniqueName + '\'' +
                ", wordFrequency=" + wordFrequency +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        UniqueWord uniqueWord = (UniqueWord) o;
        if (this.wordFrequency == uniqueWord.wordFrequency){
            return 0;
        }else if (this.wordFrequency > uniqueWord.wordFrequency){
            return -1;
        }
        return 1;
    }
}

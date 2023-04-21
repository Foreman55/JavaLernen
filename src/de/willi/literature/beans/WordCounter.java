package de.willi.literature.beans;

import java.util.ArrayList;
import java.util.List;

public class WordCounter {
    private int allWords;
    private int allCharacters;
    private List<UniqueWord> uniqueWords;

    public int getCountUniqueWords(){
        return this.uniqueWords.size();
    }

    public WordCounter() {
        this.uniqueWords = new ArrayList<>();
    }

    public void addUniqueWord(UniqueWord uniqueWord){
        this.uniqueWords.add(uniqueWord);
    }

    public int getAllWords() {
        return allWords;
    }

    public void setAllWords(int allWords) {
        this.allWords = allWords;
    }

    public int getAllCharacters() {
        return allCharacters;
    }

    public void setAllCharacters(int allCharacters) {
        this.allCharacters = allCharacters;
    }

    public List<UniqueWord> getUniqueWords() {
        return uniqueWords;
    }

    public void setUniqueWords(List<UniqueWord> uniqueWords) {
        this.uniqueWords = uniqueWords;
    }
}

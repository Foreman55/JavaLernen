package de.willi.text_to_vocabulary_trainer.literature;

import de.willi.text_to_vocabulary_trainer.literature.beans.UniqueWord;
import de.willi.text_to_vocabulary_trainer.literature.service.LituratureService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ConsoleState {
    private String url;
    private String rawText;
    private String[] rawWord;
    private LituratureService lituratureService;
    private List<UniqueWord> uniqueWords;
    private List<String> uniqueWordList;
    private Integer countAllWords;

    public ConsoleState(String url) throws MalformedURLException {
        this.lituratureService = LituratureService.getInstance();
        this.url = url;
    }

    public String getRawText() throws MalformedURLException {
        if(this.rawText==null){
            this.rawText = this.lituratureService.readFromUrl(new URL(this.url));
        }
        return this.rawText;
    }


    public String[] rawWords(){
        String[] rawWord = lituratureService.cleanAndGetWords(rawText);
        return rawWord;
    }

    public String countWords(){
        return Utils.germanNumberFormat(this.countAllWords);
    }


    public String getUrl() {
        if(this.url==null){
            this.url = url;
        }
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setRawText(String rawText) {
        this.rawText = rawText;
    }

    public String[] getRawWord() throws MalformedURLException {
        if(this.rawWord == null) {
            this.rawText = this.lituratureService.readFromUrl(new URL(this.url));
            this.rawWord = lituratureService.cleanAndGetWords(rawText);
        }
        return this.rawWord;
    }

    public void setRawWord(String[] rawWord) {
        this.rawWord = rawWord;
    }

    public LituratureService getLituratureService() {
        return lituratureService;
    }

    public void setLituratureService(LituratureService lituratureService) {
        this.lituratureService = lituratureService;
    }

    public List<UniqueWord> getUniqueWords() {
        if(this.uniqueWords==null){
            this.uniqueWords = lituratureService.frecuencyBuilder(this.uniqueWordList, List.of(this.rawWord));
        }

        return uniqueWords;
    }

    public void setUniqueWords(List<UniqueWord> uniqueWords) {
        this.uniqueWords = uniqueWords;
    }

    public List<String> getUniqueWordList() {
        if(this.uniqueWordList==null){
            this.uniqueWordList = lituratureService.uniqueWordListBuilder(this.rawWord);
        }
        return this.uniqueWordList;
    }

    public void setUniqueWordList(List<String> uniqueWordList) {
        this.uniqueWordList = uniqueWordList;
    }

    public int getCountAllWords() {
        if(countAllWords==null){
            this.countAllWords = lituratureService.countWords(this.rawWords());
        }
        return countAllWords;
    }

    public void setCountAllWords(int countAllWords) {
        this.countAllWords = countAllWords;
    }
}

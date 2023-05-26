package de.willi.text_to_vocabulary_trainer.literature.beans;

import org.jsoup.Jsoup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class Document {

    private String url;
    private String rawText;
    private static String[] rawWord;
    private List<UniqueWord> uniqueWords;
    private static List<String> uniqueWordList;
    private Integer countAllWords;

    public Document() {
    }

    public static Document getDocument(URL url) throws MalformedURLException {
        // Url abrufen
        String contentType = "";
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            contentType = connection.getContentType();
            System.out.println("contentType: " + contentType);
        }catch (Exception e){
            e.printStackTrace();
        }

        // HTTP_Header prüfen ob HTML oder TXT
        Document document = null;
        if (contentType.matches(".*html.*")) {
            document = new HTML(url);
        }
        if (contentType.matches(".*txt.*")) {
            //document = new TXT(url);
        }
        document.cleanAndGetWords();
        document.countAllWords();
        document.uniqueWordListBuilder();
        document.uniqueWords= frecuencyBuilder(uniqueWordList, List.of(rawWord));
        document.countWords();

        return document;
    }

    public Document(String url) throws Exception {
        this.url = url;
        this.readFromUrl(new URL(url));
        this.cleanAndGetWords();
        this.countAllWords();
        this.uniqueWordListBuilder();
        this.uniqueWords= frecuencyBuilder(uniqueWordList, List.of(rawWord));

        this.countWords();

        // Verbeiten
        // Url abrufen
        // Zerlegen
        // Zählen
    }

    public List<String> uniqueWordListBuilder(String[] words){
        Set<String> sortUniqueWords = new HashSet<String>();
        for (String word: words) {
            sortUniqueWords.add(word);
        }
        return sortUniqueWords.stream().sorted().toList();
    }


    public static List<UniqueWord> frecuencyBuilder(List<String> uniqueWords, List<String> rawWords){

        List<UniqueWord> uniqueWordsCount = new ArrayList<>();

        // Alle Unique Word durachlaufen und counten
        for (String uniqueName: uniqueWords){

            UniqueWord uniqueWord = new UniqueWord();
            uniqueWord.setUniqueName(uniqueName);
            uniqueWordsCount.add(uniqueWord);

            // Counten
            for (String rawWord: rawWords){
                if (uniqueName.equals(rawWord)){
                    uniqueWord.addWordFrequency();
                }
            }

        }

        return uniqueWordsCount;
    }

    public List<IndividualCharacter> frecuencyCharBuilder(char [] rawCharacters){

        char [] charactersLower = {'a' ,'b' ,'c' ,'d' ,'e' ,'f' ,'g' ,'h' ,'i' ,'j' ,'k' ,'l' ,'m' ,'n' ,'o' ,'p' ,'q' ,'r' ,'s' ,'t' ,'u' ,'v' ,'w' ,'x' ,'y' ,'z'};
        List<IndividualCharacter> frecuencyChar = new ArrayList<>();
        // Alle Unique Word durachlaufen und counten
        for (char r: charactersLower){
            IndividualCharacter individualCharacter = new IndividualCharacter();
            individualCharacter.setIndividualCharacter(r);
            frecuencyChar.add(individualCharacter);
            char indi = individualCharacter.getIndividualCharacter();
            // Counten
            for (char c: rawCharacters){
                if (indi == c){
                    individualCharacter.addCharFrequency();
                }
            }
        }
        return frecuencyChar;
    }

    public List<UniqueWord> wordCountSorter(List<UniqueWord> list){
        for(int i = 0; i < list.size(); i++){
            UniqueWord a = list.get(i);
            for(int j = 0; j < list.size(); j++){
                UniqueWord b = list.get(j);
                System.out.println(a + " > " + b);
                if(a.getWordFrequency() > b.getWordFrequency()){
                    list.add(j, a);
                    list.add(i, b);
                }
            }
        }
        return list;
    }

    public void sortByWordFrequency(List<UniqueWord> list){
        Collections.sort(list);
    }

    public int countWords(){
        return this.rawWord.length;
    }

    private void readFromUrl(URL url)  {
        String contentType = "";
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            contentType = connection.getContentType();
        }catch (Exception e){
            e.printStackTrace();
        }
        StringBuffer text = new StringBuffer();

        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(url.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null){
                text.append(inputLine + " ");
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (in != null) {
                try {in.close();} catch (IOException e) {}
            }
        }

        this.rawText = text.toString();

    }

    public void cleanAndGetWords(){
        String cleanText = this.rawText.toLowerCase(Locale.ROOT);
        org.jsoup.nodes.Document doc = Jsoup.parse(cleanText);
        cleanText = doc.text()
                .replaceAll("[-%?.,:!\"0-9/($)*_“”‘’]", "")
                .replaceAll("\n", " ")
                .replaceAll("[ \\[]+", " ")
                .replaceAll("[-_]", " ")
                .replaceAll("i’ve", "I have")
                .replaceAll("i’ll", "I will")
                .replaceAll("i’m", "I am")
                .replaceAll("it’s", "it is")
                .replaceAll("isn’t", "is not")
                .replaceAll("don’t", "do not")
                .replaceAll("that’s", "that is")
                .replaceAll("who’s", "who is")
                .replaceAll("isn’t", "is not")
                .replaceAll("that’ll", "that will")
                .replaceAll("wouldn’t", "would not")
                .replaceAll("haven’t", "have not")
                .replaceAll("can’t", "can not")
                .replaceAll("what’s", "what is")
                .replaceAll("he’s", "he is")
                .replaceAll("i’d", "i would")
                .replaceAll("wasn’t", "was not")
                .replaceAll("hadn’t", "had not")
                .replaceAll("you’re", "you are")
                .replaceAll("needn’t", "need not")
                .replaceAll("we’ll", "we will")
                .replaceAll("didn’t", "did not")
                .replaceAll("doesn’t", "does not")
                .replaceAll("won’t", "would not")
                .replaceAll("couldn’t", "could not")
                .replaceAll("let’s", "let us")
                .replaceAll("where’s", "where is")
                .replaceAll("harris’ll", "harris will")
                .replaceAll("they’d", "they would")
                .replaceAll("she’ll", "she will")
                .replaceAll("it’ll", "it will")
                .replaceAll("weren’t", "were not")
                .replaceAll("couldn’t", "could not")
                .replaceAll("it’ll", "it will")
                .replaceAll("it’ll", "it will")
                .replaceAll("it’ll", "it will")
                .replaceAll("—", " ")
                .replaceAll(";", "")

                ;

        //System.out.println(cleanText);

        String[] textArray = cleanText.split(" ");
        this.rawWord= textArray;
    }

    public void uniqueWordListBuilder(){
        Set<String> sortUniqueWords = new HashSet<String>();
        for (String word: this.rawWord) {
            sortUniqueWords.add(word);
        }
        this.uniqueWordList =sortUniqueWords.stream().sorted().toList();
    }

    public void countAllWords() {
        this.countAllWords = this.countWords();
    }

    public void sortByWordFrequency(){
        Collections.sort(uniqueWords);
    }

    public char [] convertToCharArray(){
        char[] charArray = this.rawText.toCharArray();
        return charArray;
    }



    /************************ getter/setter *****************************/

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRawText() {
        return rawText;
    }

    public void setRawText(String rawText) {
        this.rawText = rawText;
    }

    public String[] getRawWord() {
        return rawWord;
    }

    public void setRawWord(String[] rawWord) {
        this.rawWord = rawWord;
    }



    public List<UniqueWord> getUniqueWords() {
        return uniqueWords;
    }

    public void setUniqueWords(List<UniqueWord> uniqueWords) {
        this.uniqueWords = uniqueWords;
    }

    public List<String> getUniqueWordList() {
        return uniqueWordList;
    }

    public void setUniqueWordList(List<String> uniqueWordList) {
        this.uniqueWordList = uniqueWordList;
    }

    public Integer getCountAllWords() {
        return countAllWords;
    }

    public void setCountAllWords(Integer countAllWords) {
        this.countAllWords = countAllWords;
    }

}



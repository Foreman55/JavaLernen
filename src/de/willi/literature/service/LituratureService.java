package de.willi.literature.service;

import de.willi.literature.beans.Document;
import de.willi.literature.beans.HTML;
import de.willi.literature.beans.IndividualCharacter;
import de.willi.literature.beans.UniqueWord;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class LituratureService {

    private static LituratureService lc;

    public LituratureService(){}

    public static LituratureService getInstance(){
        if (lc == null){
            lc = new LituratureService();
        }
        return lc;
    }

    public Document getDocumentFromURL(String url){
        Document document = null;
        // Abrufen die URL

        // Prüfen welche Typ
        if ("html".equals("html")){
            document = new HTML();
        }
        if ("html".equals("html")){
            HTML html = new HTML();
            html.setURL(url);
            document = html;
        }
        return document;
    }

    /*******************************************************************/

    public String readLituratureFromFileSystemToString(File liturature){
        StringBuffer text = new StringBuffer();
        try {
            Scanner scanner = new Scanner(liturature);
            while(scanner.hasNextLine()){
                text.append(scanner.nextLine() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    public String[] cleanAndGetWords(String literature){
        String cleanText = literature.toLowerCase(Locale.ROOT)
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
        String[] textArray = cleanText.split(" ");
        return textArray;
    }


    public int countWords(String[] words){
        return words.length;
    }

    public List<String> uniqueWordListBuilder(String[] words){
        Set<String> sortUniqueWords = new HashSet<String>();
        for (String word: words) {
            sortUniqueWords.add(word);
        }
        return sortUniqueWords.stream().sorted().toList();
        /*List<String> list = new ArrayList<>();
        Collections.addAll(list,words);
        int counter = 0;
        String word = "";
        for(int i = 0; i < list.size(); i++){
            for(int j = 0 ;j < list.size(); j++){
                if(list.get(i).equals(list.get(j))&&i!=j){
                    int yo = j;
                    list.remove(yo);
                }
            }
            }
        return list;*/
    }

    public List<UniqueWord> frecuencyBuilder(List<String> uniqueWords, List<String> rawWords){

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

    public String readFromUrl(URL url)  {
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

        if(contentType.equals("text/html; charset=UTF-8")){
            System.out.println("Hello ma");
            String hoho = html(text.toString());
            return hoho;
        }
        return text.toString();
    }

    public String html(String html){

        System.out.println("hello da ");
        /*String[] splitt = html.split("<body.*>");
        if (splitt.length > 1){
            html = splitt[1];
        }*/
        html = html.replaceAll("<head>.*</head>", "")
                .replaceAll("\n", " ")
                .replaceAll("<script>[^<>]*</script>", "")
                .replaceAll("<style(.*?)>.+<\\/style>", "")
                .replaceAll("<.+?>", "")
                .replaceAll("[ ]+", " ")
                .replaceAll("\t",   " ")
                .replaceAll("[ ]+", " ");

        return html;
    }

    public char [] convertToCharArray(String text){
        char [] charArray = text.toCharArray();
        return charArray;
    }
}

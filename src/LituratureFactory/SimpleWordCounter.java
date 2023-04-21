package LituratureFactory;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.Locale;

public class SimpleWordCounter implements Counter {
    @Override
    public int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String jsoup = String.valueOf(Jsoup.parse(text).text());
        cleanAndGetWords(jsoup);
        System.out.println(jsoup);
        String[] words = text.split("\\s+");
        return words.length;
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
                .replaceAll("<head>.*</head>", "")
                .replaceAll("\n", " ")
                .replaceAll("<script>[^<>]*</script>", "")
                .replaceAll("<style(.*?)>.+<\\/style>", "")
                .replaceAll("<.+?>", "")
                .replaceAll("[ ]+", " ")
                .replaceAll("\t",   " ")
                .replaceAll("[ ]+", " ");
                ;
        String[] textArray = cleanText.split(" ");
        return textArray;
    }
}

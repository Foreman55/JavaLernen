package de.willi.text_to_vocabulary_trainer.literature.beans;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class DocumentFactory {
    public static Document createDocument(URL url){

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
        if (contentType.matches(".*text.*")) {
            document = new TXT(url);
        }
        document.cleanAndGetWords();
        document.countAllWords();
        document.uniqueWordListBuilder();
        document.setUniqueWords(Document.frecuencyBuilder(document.getUniqueWordList(), List.of(document.getRawWord())));
        document.countWords();

        return document;
    }
}

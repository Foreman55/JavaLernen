package de.willi.text_to_vocabulary_trainer.literature.controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import de.willi.text_to_vocabulary_trainer.bucket.beans.Bucket;
import de.willi.text_to_vocabulary_trainer.literature.HtmlStrings;
import de.willi.text_to_vocabulary_trainer.literature.beans.*;
import de.willi.text_to_vocabulary_trainer.literature.view.*;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LiteratureController implements HttpHandler {
   HtmlStrings htmlStrings = new HtmlStrings();
    private Document document;
    List<FlashCard> flashCardList = FlashCards.getInstance().getFlashCards();
    Bucket bucket = Bucket.getInstance();


    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // URL holen
        String url =  exchange.getRequestURI().toString();
        // CSS ausgeben
        if (url.matches(".*/css/(.*)")){
            // CSS-Dateiname ermitteln
            String regexUrl = ".*/css/(.*)";
            Pattern patternUrl = Pattern.compile(regexUrl, Pattern.CASE_INSENSITIVE);
            Matcher matcherUrl = patternUrl.matcher(url);
            if(matcherUrl.find()){
                String fileName = matcherUrl.group(1);
                String css = CSSView.renderView(fileName);
                if (css == null){
                    response404(exchange);
                }
                response(css,exchange);
            }
            return;
        }

        // Action bestimmen

        // Startseite.
        // Test
        String regex = "action=(.*)&?";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(url);
        boolean matchFound = matcher.find();

        // Wenn der Benutzer die Seite das erste mal aufruft, damit er die URL eingeben kann
        if (!matchFound){
            String html = StartView.renderView();
            response(html,exchange);
        }

        // Startseite
        if (matchFound){
            String []urlDisplayOut = URLDecoder.decode(url).split("=",2);
            String urlOut = urlDisplayOut[1];
            String [] one = urlOut.split("&",2);
            urlOut = one[0];
            // Action auslesen
            String action = matcher.group(1);
            // Document von URL erstellen
            if (action.equals("process-request")){
                // URl Holen
                String regexUrl = "url=([a-z0-9-_%.]*)&";
                Pattern patternUrl = Pattern.compile(regexUrl, Pattern.CASE_INSENSITIVE);
                Matcher matcherUrl = patternUrl.matcher(url);
                boolean matchFoundUrl = matcherUrl.find();
                if (matchFoundUrl){
                    String paramUrl = matcherUrl.group(1);
                    paramUrl = URLDecoder.decode(paramUrl);
                    URL url2 = null;
                    try {
                        url2 = new URL(paramUrl);
                        document = DocumentFactory.createDocument(url2);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    System.out.println(paramUrl);
                }
                // Document.creat mit URL
            }

            if(action.equals("saveWord")){
                String regexUrl = "word=([a-z0-9-_%.]*)&";
                Pattern patternUrl = Pattern.compile(regexUrl, Pattern.CASE_INSENSITIVE);
                Matcher matcherUrl = patternUrl.matcher(url);
                boolean matchFoundUrl = matcherUrl.find();
                if (matchFoundUrl){
                    String word = matcherUrl.group(1);
                    try {
                        Bucket.getInstance().save(word);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    action = "Individual word count";
                }
            }

            if(action.equals("unsaveWord")){
                String regexUrl = "word=([a-z0-9-_%.]*)&";
                Pattern patternUrl = Pattern.compile(regexUrl, Pattern.CASE_INSENSITIVE);
                Matcher matcherUrl = patternUrl.matcher(url);
                boolean matchFoundUrl = matcherUrl.find();
                if (matchFoundUrl){
                    String word = matcherUrl.group(1);
                    Bucket.getInstance().unsave(word);
                    action = "Individual word count";
                }
            }

            if(action.equals("bucketRemove")){
                String regexUrl = "word=([a-z0-9-_%.]*)&";
                Pattern patternUrl = Pattern.compile(regexUrl, Pattern.CASE_INSENSITIVE);
                Matcher matcherUrl = patternUrl.matcher(url);
                boolean matchFoundUrl = matcherUrl.find();
                if (matchFoundUrl){
                    String word = matcherUrl.group(1);
                    Bucket.getInstance().unsave(word);
                    action = "bucket";
                }
                String html = BucketView.renderView(document, bucket);
                String out = html.replaceAll("<!--Content1-->", urlOut );
                out = out.replaceAll("show", "none");
                response(out, exchange);
            }
            if(action.equals("bucket")){
                String html = BucketView.renderView(document, bucket);
                String out = html.replaceAll("<!--Content1-->", urlOut );
                out = out.replaceAll("show", "none");
                response(out, exchange);
            }



            if(action.equals("gotIt")){
                    int score = FlashCards.playCard.getScore();
                    score++;
                    FlashCards.playCard.setScore(score);
                    action = "FlashCards";
                }


            if(action.equals("notGotIt")){
                    int score = FlashCards.playCard.getScore();
                    score--;
                    FlashCards.playCard.setScore(score);
                    action = "FlashCards";
            }



            action = URLDecoder.decode(action);

            if (action.equals("Individual word count")){
                String html = WordCounterView.renderView(document, bucket);
                String out = html.replaceAll("<!--Content1-->", urlOut );
                out = out.replaceAll("show", "none");
                response(out, exchange);
            }else if (action.equals("Character count")){
                String html = CharacterCountView.renderView(document);
                String out = html.replaceAll("<!--Content1-->", urlOut );
                out = out.replaceAll("show", "none");
                response(out, exchange);
            }else if(action.equals("All words")){
                String html = AllWordsView.renderView(document);
                String out = html.replaceAll("<!--Content1-->", urlOut );
                out = out.replaceAll("show", "none");
                response(out, exchange);
            }else if(action.equals("New URL")){
                String html = StartView.renderView();
                String out = html.replaceAll("<!--Content1-->", urlOut );
                out = out.replaceAll("none", "show");
                response(out, exchange);
            }else if(action.equals("FlashCards")){
                String html = FlashCardsView.renderView();
                String out = html.replaceAll("<!--Content1-->", urlOut );
                out = out.replaceAll("show", "none");
                response(out, exchange);
            }else if(action.equals("backside")){
                String html = FlashCardsBacksideView.renderView();
                String out = html.replaceAll("<!--Content1-->", urlOut );
                out = out.replaceAll("show", "none");
                response(out, exchange);
            }


            Path path = Paths.get(Constant.PATH_TEMPLATE_FOLDER + File.separator + "Template.html");
            String template = "";
            for (String line: Files.readAllLines(path)){
                template += line + "\n";
            }
            String buttons = "";
            Path pathbuttons = Paths.get(Constant.PATH_TEMPLATE_FOLDER + File.separator + "buttons.html");
            for (String line: Files.readAllLines(pathbuttons)){
                buttons += line + "\n";
            }

            String out = template.replaceAll("<!--Content1-->", urlOut ).replaceAll("<!--buttons-->", buttons);
            out = out.replaceAll("show", "none");
            response(out, exchange);
        }
    }


    private void response(String html, HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(200, html.getBytes().length);
        OutputStream out = exchange.getResponseBody();
        out.write(html.getBytes());
        out.close();
    }

    private void response404( HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(404,0);
        OutputStream out = exchange.getResponseBody();
        out.close();
    }
}

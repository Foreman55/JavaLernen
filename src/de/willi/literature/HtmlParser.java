package de.willi.literature;

import java.io.*;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlParser {
    private String html;
    static Path filePath = Path.of("/Users/williamhall/IdeaProjects/JavaLernen/SelectAction.html");
    public String getHtml() {
        return html;
    }

    public HtmlParser() {
      this.html = fileParser();

    }

    public static String fileParser(){
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(String.valueOf(filePath)))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null)
            {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

    public static String stringParser(String incoming){
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(String.valueOf(filePath)))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null)
            {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }
}

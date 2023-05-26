package de.willi.text_to_vocabulary_trainer.literature;

import de.willi.text_to_vocabulary_trainer.literature.beans.Constant;

import java.io.*;
import java.nio.file.Path;

public class HtmlParser {
    private String html;
    static Path filePath = Path.of(Constant.PATH_TEMPLATE_FOLDER + "/Template.html");
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

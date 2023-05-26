package de.willi.text_to_vocabulary_trainer.literature.view;
import de.willi.text_to_vocabulary_trainer.literature.HtmlParser;
import de.willi.text_to_vocabulary_trainer.literature.beans.Constant;
import de.willi.text_to_vocabulary_trainer.literature.beans.Document;
import de.willi.text_to_vocabulary_trainer.literature.beans.IndividualCharacter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CharacterCountView {
    public static String renderView(Document document) throws IOException {
        HtmlParser htmlParser = new HtmlParser();
        String htmlTemplate = htmlParser.getHtml();
        StringBuffer htmlContent = new StringBuffer();
        char [] charaters = document.convertToCharArray();
        List<IndividualCharacter> indChar = document.frecuencyCharBuilder(charaters);
        htmlContent.append("<table>");
        htmlContent.append("<tr>");
        htmlContent.append("<th>Anzahl</th>");
        htmlContent.append("<th>Word</th>");
        htmlContent.append("</tr>");

        for (IndividualCharacter i: indChar) {
            htmlContent.append("<tr>");
            htmlContent.append("<td>" + i.getCharFrequency() + "</td>");
                htmlContent.append("<td>" + i.getIndividualCharacter() + "</td>");
            htmlContent.append("</tr>");
        }
        htmlContent.append("</table>");
        String buttons = "";
        Path pathbuttons = Paths.get(Constant.PATH_TEMPLATE_FOLDER + File.separator + "buttons.html");
        for (String line: Files.readAllLines(pathbuttons)){
            buttons += line + "\n";
        }
        String html =  htmlTemplate.replaceAll("<!--CONTENT-->", htmlContent.toString()).replaceAll("<!--buttons-->", buttons);
        return html;
    }
}

package de.willi.literature.view;
import de.willi.literature.HtmlParser;
import de.willi.literature.beans.Document;
import de.willi.literature.beans.IndividualCharacter;
import java.util.List;

public class CharacterCountView {
    public static String renderView(Document document){
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
        String html =  htmlTemplate.replaceAll("<!--CONTENT-->", htmlContent.toString());
        return html;
    }
}

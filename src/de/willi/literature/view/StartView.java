package de.willi.literature.view;

import de.willi.literature.beans.Document;
import de.willi.literature.template.TemplateEngine;
import org.jsoup.Jsoup;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static de.willi.literature.beans.Constant.*;

public class StartView {
    public static String renderView() throws IOException {
        TemplateEngine templateEngine = new TemplateEngine();
        String userDir = System.getProperty("user.dir");
        String templatePath = PATH_TEMPLATE_FOLDER + File.separator + "Template.html";
        templateEngine.generateTemplate(templatePath);
        String template = templateEngine.getTemplate();
        String inputUrlElement = templateEngine.getElementByName("url-input");
        template = template.replaceAll("<!--#url-input#-->", inputUrlElement);
        return template;
    }
}

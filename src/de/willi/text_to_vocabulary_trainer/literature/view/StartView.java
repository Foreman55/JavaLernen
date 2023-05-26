package de.willi.text_to_vocabulary_trainer.literature.view;

import de.willi.text_to_vocabulary_trainer.literature.template.TemplateEngine;

import java.io.File;
import java.io.IOException;

import static de.willi.text_to_vocabulary_trainer.literature.beans.Constant.*;

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

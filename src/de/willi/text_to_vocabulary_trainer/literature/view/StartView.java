package de.willi.text_to_vocabulary_trainer.literature.view;

import de.willi.text_to_vocabulary_trainer.literature.template.TemplateEngine;

import java.io.File;
import java.io.IOException;

import static de.willi.text_to_vocabulary_trainer.literature.beans.Constant.*;

public class StartView {
    public static String renderView() throws IOException {
        TemplateEngine templateEngine = new TemplateEngine();
        String templatePath = PATH_TEMPLATE_FOLDER_Wizard + File.separator + "intro.html";
        templateEngine.generateTemplate(templatePath);
        String template = templateEngine.getTemplate();
        return template;
    }
}

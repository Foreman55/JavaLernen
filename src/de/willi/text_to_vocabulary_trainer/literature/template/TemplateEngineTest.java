package de.willi.text_to_vocabulary_trainer.literature.template;

import java.io.IOException;

public class TemplateEngineTest {
    public static void main(String[] args) throws IOException {
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.generateTemplate("/Users/williamhall/IdeaProjects/JavaLernen/Frontend/Template.html");
        System.out.println(templateEngine);
    }
}

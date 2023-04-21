package de.willi.literature.template;

import java.io.File;
import java.io.IOException;

public class TemplateEngineTest {
    public static void main(String[] args) throws IOException {
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.generateTemplate("/Users/williamhall/IdeaProjects/JavaLernen/Template.html");
        System.out.println(templateEngine);
    }
}

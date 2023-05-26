package de.willi.text_to_vocabulary_trainer.literature;

import java.io.File;
import java.io.IOException;

public class TestTemplateEngine {
    public static void main(String[] args) throws IOException {
        /*Path path = Paths.get("/Users/williamhall/IdeaProjects/JavaLernen/Template.html");
        String template = "";
        for (String line: Files.readAllLines(path)){
            template += line + "\n";
        }
        System.out.println(template);*/
        String frontend = "Frontend";

        String userDir = System.getProperty("user.dir");
        String out = userDir + File.separator + frontend;
        System.out.println(out);
    }
}

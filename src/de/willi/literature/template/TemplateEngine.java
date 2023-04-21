package de.willi.literature.template;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateEngine {

    private String template;
    private HashMap<String, String> templateElements;

    public TemplateEngine() {
        this.templateElements = new HashMap<String, String>();
    }

    public static TemplateEngine instance(){
        return new TemplateEngine();
    }

    public String getTemplate() {
        return template;
    }

    public HashMap<String, String> getTemplateElements() {
        return templateElements;
    }

    public void generateTemplate(String templatePath) throws IOException {

        // 1. Lesen wir das Template ein
        Path path = Paths.get(templatePath);
        template = "";
        for (String line: Files.readAllLines(path)){
            template += line + "\n";
        }

        // 2. Auslesen aller Element
        Pattern pattern = Pattern.compile("<!--#([a-z-]+)#-->");
        Matcher matcher = pattern.matcher(template);
        while (matcher.find()){
            String elementName = matcher.group(1);
            Path element =  Paths.get(path.getParent() + "/" + elementName + ".html");
            if (Files.exists(element)){
                String elementContent = "";
                for (String line: Files.readAllLines(element)){
                    elementContent += line + "\n";
                }
                templateElements.put(elementName, elementContent);
            }
        }
    }



    @Override
    public String toString() {
        return "TemplateEngine{" +
                "template='" + template + '\'' +
                ", templateElements=" + templateElements +
                '}';
    }

    public String getElementByName(String s) {
        String element = templateElements.get(s);
        return element;
    }
}

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TestReadFileToString {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/williamhall/IdeaProjects/JavaLernen/SelectAction.html");
        String html = "";
        for (String line: Files.readAllLines(path)){
            html += line + "\n";
        }

        System.out.println(html);
    }
}

package de.willi.text_to_vocabulary_trainer.literature.view;

import static de.willi.text_to_vocabulary_trainer.literature.beans.Constant.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class CSSView {

    public static String renderView(String fielname){
        StringBuilder contentBuilder = new StringBuilder();
        Path filePath = Path.of(PATH_TEMPLATE_FOLDER_Wizard + File.separator + fielname);
        try (BufferedReader br = new BufferedReader(new FileReader(String.valueOf(filePath)))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null)
            {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return contentBuilder.toString();
    }

}

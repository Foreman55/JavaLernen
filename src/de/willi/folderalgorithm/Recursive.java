package de.willi.folderalgorithm;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Recursive {

    public static int readFiles(File folder){

        // Addition aller Zahlen
        int sum = 0;

        // Lese alle Datein/Folder im aktuellen Verzeichnis
        File[] files = folder.listFiles();

        // Durchläuft alle Datei/Verzeicznisse
        for (File file : files) {

            // 1. Wenn Datei dann lese Inhal
            if (file.isFile() && !file.getName().endsWith("DS_Store")) {
                sum = sum + getZahl(file);
            }

            // 2. Wenn Folder, dann rufe dich selbst auf
            if (file.isDirectory()) {
                int returnSum = readFiles(file);
                sum = sum + returnSum;
            }
        }
        System.out.println("Return Sum: " + sum);
        return  sum;
    }

    private static int getZahl( File file) {
        int sum = 0;
        try {
            // Creates a FileReader
            FileReader file1 = new FileReader(file);
            // Creates a BufferedReader
            BufferedReader input = new BufferedReader(file1);
            // Reads characters
            String line = input.readLine();
            String line1 = line.split("=")[1];
            sum = sum + Integer.parseInt(line1);
            input.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return sum;
    }
}

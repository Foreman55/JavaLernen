package de.willi.folderalgorithm.Mail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MailMain {
    public static void main(String[] args) {
        File file = new File("/Users/williamhall/Desktop/GitTest/Mail/V9/55E31785-D3A3-4793-87A4-F8EA81B3CDA8/[Gmail].mbox/All Mail.mbox/827F7C07-B9E1-4DA1-AC6A-608FF10B9C64/Data/6/1/1/Messages");
        System.out.println(getFile(file));
    }
    private static String getFile( File file) {

        StringBuffer file5= new StringBuffer();
        try {
            System.out.println("yo");
            // Creates a FileReader
            FileReader file1 = new FileReader(file);
            // Creates a BufferedReader
            BufferedReader input = new BufferedReader(file1);
            // Reads characters

                System.out.println("kokomo");
                String line = input.readLine();
                System.out.println(line);
                file5.append(line);



            input.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return file5.toString();
    }
}

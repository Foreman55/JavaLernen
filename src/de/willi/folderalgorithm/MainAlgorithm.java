package de.willi.folderalgorithm;
import java.io.File;
import java.util.Arrays;


public class MainAlgorithm {


    public static void main(String[] args) {
        File folder = new File("/Users/williamhall/IdeaProjects/JavaLernen/1");
        int results = Recursive.readFiles( folder);
        System.out.println("results is "+results);
       /* for(int i = 0; i < hello.size(); i++){
            result += hello.get(i);
            System.out.println(hello.get(i));
        }
        System.out.println("result is : " + result);*/
        /*
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println("File: " + file);
            }
            if (file.isDirectory()) {
                System.out.println("Dir: " + file);
                File [] listOfFiles1 = file.listFiles();

                for(File f: listOfFiles1){
                    System.out.println("Dir1: " + f);
                    if (f.isDirectory()) {
                        File[] listOfFiles2 = f.listFiles();
                        for (File i : listOfFiles2) {
                            System.out.println("Dir2 : " + i);
                        }
                    }
                }
            }
        }
         */
    }
}

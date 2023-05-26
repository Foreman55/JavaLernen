package de.willi.text_to_vocabulary_trainer.literature;
//https://en.wikipedia.org/wiki/Main_Page
import de.willi.text_to_vocabulary_trainer.literature.beans.Document;
import de.willi.text_to_vocabulary_trainer.literature.beans.DocumentFactory;
import de.willi.text_to_vocabulary_trainer.literature.beans.IndividualCharacter;
import de.willi.text_to_vocabulary_trainer.literature.beans.UniqueWord;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainConsoleOO {

    public static void main(String[] args) throws Exception {

        // Starten Webserver
        HTTPServer server = new HTTPServer();
        server.start();

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("Please enter a URL with a text file");
            String url = sc.nextLine();

            // Findet hier die Verarbeitung statt?
            //Document document = Document.getDocument(new URL(url));
            Document document = DocumentFactory.createDocument(new URL(url));

            // Und hier nur die Ausgabe der Daten
            while (true){

                System.out.println(" Please enter an option:\n a = print entire text\n b = individual words\n c = the total word count\n d = word count of individual words\n e = word search\n f = character count\n g = new URL\n h = EXIT ");
                String selection = sc.nextLine();

                if (selection.equals("a")){
                    System.out.println(Arrays.toString(document.getRawWord()));
                }else if (selection.equals("b")){
                    String[] rawWords = document.getRawWord();
                    for (String rawWord: rawWords){
                        System.out.println(rawWord);
                    }
                }else if (selection.equals("c")) {
                    System.out.println(" The total word count is " +  document.getCountAllWords());

                }else if(selection.equals("d")){
                    document.sortByWordFrequency();
                    for(UniqueWord uniqueWord: document.getUniqueWords()){
                        System.out.println(uniqueWord.getWordFrequency() + " = " + uniqueWord.getUniqueName());
                    }

                }else if(selection.equals("e")){
                    System.out.println("Bitte geben die das Suchwort ein!");
                    String searchWord = sc.nextLine();
                    document.sortByWordFrequency();
                    for(UniqueWord uniqueWord: document.getUniqueWords()){
                        if (uniqueWord.getUniqueName().equals(searchWord)){
                            System.out.println(uniqueWord.getUniqueName() + " = " +uniqueWord.getWordFrequency());
                        }
                    }
                }else if(selection.equals("f")){
                    char [] charaters = document.convertToCharArray();
                    List<IndividualCharacter> indChar = document.frecuencyCharBuilder(charaters);
                    for(IndividualCharacter i: indChar){
                        System.out.println(i.getIndividualCharacter()+ " = " + i.getCharFrequency() );
                    }
                } else if (selection.equals("g")){ // Neue URL
                    break;
                }else if (selection.equals("h")){ // Exit
                    return;
                }
            }

        }
    }
}

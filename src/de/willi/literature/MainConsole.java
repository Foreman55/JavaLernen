package de.willi.literature;

import de.willi.literature.beans.IndividualCharacter;
import de.willi.literature.beans.UniqueWord;
import de.willi.literature.service.LituratureService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainConsole {

    public static void main(String[] args) throws MalformedURLException {

        ConsoleState consoleState = null;
        Scanner sc = new Scanner(System.in);
        LituratureService lituratureService =  LituratureService.getInstance();



        while(true){
            System.out.println("Please enter a URL with a text file");
            String url = sc.nextLine();
            consoleState =  new ConsoleState(url);

            while (true){
                System.out.println(" Please enter an option:\n a = print entire test\n b = individual words\n c = the total word count\n d = word count of individual words\n e = word search\n f = character count\n g = new URL\n h = EXIT ");
                String selection = sc.nextLine();

                if (selection.equals("a")){
                    System.out.println(Arrays.toString(consoleState.getRawWord()));
                }else if (selection.equals("b")){
                    String[] rawWords = consoleState.rawWords();
                    for (String rawWord: rawWords){
                        System.out.println(rawWord);
                    }
                }else if (selection.equals("c")) {
                    consoleState.getCountAllWords();
                    System.out.println(" The total word count is " + consoleState.countWords());
                }else if(selection.equals("d")){
                    consoleState.getRawText();
                    consoleState.getRawWord();
                    consoleState.getUniqueWordList();
                    lituratureService.sortByWordFrequency(consoleState.getUniqueWords());
                    for(UniqueWord uniqueWord: consoleState.getUniqueWords()){
                        System.out.println(uniqueWord.getWordFrequency() + " = " + uniqueWord.getUniqueName());
                    }
                }else if(selection.equals("e")){
                    System.out.println("Bitte geben die das Suchwort ein!");
                    String searchWord = sc.nextLine();
                    lituratureService.sortByWordFrequency(consoleState.getUniqueWords());
                    for(UniqueWord uniqueWord: consoleState.getUniqueWords()){
                        if (uniqueWord.getUniqueName().equals(searchWord)){
                            System.out.println(uniqueWord.getUniqueName() + " = " +uniqueWord.getWordFrequency());
                        }
                    }
                }else if(selection.equals("f")){
                    String convertToCharacter = consoleState.getRawText();
                    char [] charaters = lituratureService.convertToCharArray(convertToCharacter);
                    List<IndividualCharacter> indChar = lituratureService.frecuencyCharBuilder(charaters);
                    for(IndividualCharacter i: indChar){
                        System.out.println(i.getIndividualCharacter()+ " = " + i.getCharFrequency() );
                    }
                } else if (selection.equals("g")){ // Neue URL
                    break;
                }else if (selection.equals("h")){ // Exit
                    return;
                }
            }
            /*
            String liturature = lituratureService.readFromUrl(new URL(input));

            String selection = sc.nextLine();
            if(selection.equals("all words")){
                String[] rawWords = lituratureService.cleanAndGetWords(liturature);
                int countAllWords = lituratureService.countWords(rawWords);
                System.out.println(countAllWords);
            }
            if(selection.equals("unique words")){

            }
            */

        }
    }
}

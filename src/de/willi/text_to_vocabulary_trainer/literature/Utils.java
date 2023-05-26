package de.willi.text_to_vocabulary_trainer.literature;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static String germanNumberFormat(int number) {
        String zahlString = String.valueOf(number);
        int counterDigit = 3;
        int currentDigitCounter = 0;
        List<String> list = new ArrayList<>();
        for (int i = (zahlString.length() - 1); i >= 0; i--){
            if (currentDigitCounter == 3){
                list.add(".");
                currentDigitCounter = 1;
            }
            list.add(zahlString.charAt(i) + "");
            currentDigitCounter++;
        }
        String formattDigits = "";
        for (String s: list){
            formattDigits = s + formattDigits;
        }
       return formattDigits;
    }

}

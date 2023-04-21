package de.willi.literature;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testURLRegex {
    public static void main(String[] args) {
        // protokoll://host:port/verzeichnisse/seite.html?key=value&key=value
        String url = "http://localhost:8080/ls?url=www.google-abc.de%100&action=process-request&key=value";
        String regex = "action=([a-z-]*)&?";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(url);
        boolean matchFound = matcher.find();

        if(matchFound) {
            System.out.println("Match found");
            String action = matcher.group(1);
            System.out.println(action);
            if (action.equals("process-request")){
                String regexUrl = "url=([a-z0-9-_%.]*)&";
                Pattern patternUrl = Pattern.compile(regexUrl, Pattern.CASE_INSENSITIVE);
                Matcher matcherUrl = patternUrl.matcher(url);
                boolean matchFoundUrl = matcherUrl.find();
                if (matchFoundUrl){
                    String paramUrl = matcherUrl.group(1);
                    System.out.println(paramUrl);
                }

            }

        } else {
            System.out.println("Match not found");
        }

    }
}

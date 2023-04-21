package de.willi.literature;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlTester {
    private static String html1;
    private static String html2;
    public static void main(String[] args) {
        StringBuffer html = new StringBuffer();
        String pattern = "hello whar up <div id = \"InsertStuff\"> öaakerjg g";
        String []pattern1 = pattern.split("<div id = \"InsertStuff\"> ");
        html.append(pattern1[0]);
        System.out.println("Stringbuffer " + html);
        System.out.println("pattern 1 " +pattern1[0]);
        System.out.println("pattern 2 " + pattern1[1]);

        //htmlSplitter(pattern);
        System.out.println(html1);
    }

    public static void htmlSplitter(String incoming){
        Pattern pattern = Pattern.compile("(.*?)(<div id = \"InsertStuff\">)([.]*?)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(incoming);
        html1 = matcher.group(0);
        html2 = matcher.group(2);
    }
}

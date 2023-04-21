package LituratureFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws MalformedURLException {
//https://en.wikipedia.org/wiki/Main_Page
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entre a URL please");
        String url = scanner.nextLine();
        URL text = new URL(url);
        String litText = urlParser(text);
        int WordCount = WordCounterFactory.createWordCounter(litText);
        System.out.println(Integer.parseInt(String.valueOf(WordCount)));
    }

    public static String urlParser(URL url){
        StringBuffer content = null;
        try {

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            return content.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
       return content.toString();
    }
}

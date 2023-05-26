package de.willi.literature2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class MainMethod {
    public static void main(String[] args) throws IOException {
        BufferedReader in = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Enter a web URL");
        String urlStr = scanner.nextLine();
        URL url = new URL(urlStr);
        Text text = new Text(url);
        in = new BufferedReader(new InputStreamReader(url.openStream()));
        System.out.println(in);
    }
}

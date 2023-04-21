package de.willi.literature.beans;

import org.jsoup.Jsoup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class HTML extends Document {

    public HTML() {
    }

    public HTML(URL url) {
        StringBuffer text = new StringBuffer();

        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(url.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null){
                text.append(inputLine + " ");
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (in != null) {
                try {in.close();} catch (IOException e) {}
            }
        }
        String html = text.toString();
        org.jsoup.nodes.Document doc = Jsoup.parse(html);
        String rawText = doc.text();
        this.setRawText(rawText);
        super.cleanAndGetWords();
    }



    public void setURL(String url) {
        System.out.println("hello da ");
        /*String[] splitt = html.split("<body.*>");
        if (splitt.length > 1){
            html = splitt[1];
        }*/
        /*rawText = html.replaceAll("<head>.*</head>", "")
                .replaceAll("\n", " ")
                .replaceAll("<script>[^<>]*</script>", "")
                .replaceAll("<style(.*?)>.+<\\/style>", "")
                .replaceAll("<.+?>", "")
                .replaceAll("[ ]+", " ")
                .replaceAll("\t",   " ")
                .replaceAll("[ ]+", " ");*/
    }
}

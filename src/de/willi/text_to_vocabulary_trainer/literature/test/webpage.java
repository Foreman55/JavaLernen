package de.willi.text_to_vocabulary_trainer.literature.test;

import java.io.*;
import java.net.URL;

public class webpage {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://en.wikipedia.org/wiki/Main_Page");
        String html = reader(url);
        String[] splitt = html.split("<body.*>");
        if (splitt.length > 1){
            html = splitt[1];
        }
        html = html.replaceAll("<head>.*</head>", "");

        System.out.println("Ausgabe: " +
                html
                .replaceAll("\n", " ")
                .replaceAll("<script>[^<>]*</script>", "")
                .replaceAll("<style(.*?)>.+<\\/style>", "")
                .replaceAll("<.+?>", "")
                .replaceAll("[ ]+", " ")
                .replaceAll("\t",   " ")
                .replaceAll("[ ]+", " ")
               );

        String testHmlt = " <script type=\"text/javascript\">/*\n" +
                "*/\n" +
                "    go = function(){\n" +
                "        $.fn.socialSharePrivacy.settings.path_prefix = 'typo3conf/ext/site_duesseldorf/Resources/Public/Scripts/Vendor/SocialSharePrivacy/';\n" +
                "        $.fn.socialSharePrivacy.settings.info_link = '/infonav/datenschutzhinweise-fuer-social-plugins.html';\n" +
                "        twittertimeline.referrer_track = 'duesseldorf';\n" +
                "        twittertimeline.id = '291180153764200448';\n" +
                "        twittertimeline.txt_info = 'Zwei Klicks für mehr Datenschutz: Erst wenn Sie hier klicken, wird der Button aktiv und Sie können Ihre Empfehlung an Twitter senden. Schon beim Aktivieren werden Daten an Dritte übertragen - siehe &quot;i&quot;-Icon.';\n" +
                "        twittertimeline.txt_on = '<img src=\"/typo3conf/ext/site_duesseldorf/Resources/Public/Images/slide-stop.png\" alt=\"mit Twitter verbunden\">';\n" +
                "        twittertimeline.txt_off = '<img src=\"/typo3conf/ext/site_duesseldorf/Resources/Public/Images/slide-play.png\" alt=\"nicht mit Twitter verbunden\">';\n" +
                "        jQuery.extend(jQuery.fn.socialSharePrivacy.settings, { txt_help: 'Wenn Sie diese Felder durch einen Klick aktivieren, werden Informationen an Facebook, Twitter oder Google etc. in die USA übertragen und unter Umständen auch dort gespeichert. Näheres erfahren Sie durch einen Klick auf das &quot;i&quot;-Icon.'});\n" +
                "        $('.share-117311-2').socialSharePrivacy.settings.services.twittertimeline = twittertimeline;\n" +
                "        $('.share-117311-2').socialSharePrivacy.settings.services.FBtimeline = {};\n" +
                "        $('.share-117311-2').socialSharePrivacy.settings.services.INtimeline = {};\n" +
                "        $('.share-117311-2').socialSharePrivacy();\n" +
                "    }\n" +
                "    window.addEventListener(\"load\", go , false);\n" +
                "    // ]]>\n" +
                "    </script>";
        System.out.println("second ausgabe: "+html
                .replaceAll("[ ]+", " ")
                .replaceAll("\t",   " ")
                .replaceAll("<style(.*?)>.+<\\/style>", "")
                .replaceAll("\n", " ")
                .replaceAll("<script.*>[^<>]*</script>", "")
                .replaceAll("<(.*?\n\t.*?)*>", "")
                .replaceAll("\n", " ")
                .replaceAll("<.+?>", "")
                .replaceAll("[&][#].+[;]","")
                .replaceAll("[ ]+", " ")

        );
    }


    public static String reader(URL url) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;

        InputStream in = url.openStream();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
        } finally {
            in.close();
        }

        return sb.toString();
    }
}



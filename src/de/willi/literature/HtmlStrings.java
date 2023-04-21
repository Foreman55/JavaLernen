package de.willi.literature;

public class HtmlStrings {
    static StringBuffer insertOne;
    public static String getInsertOne(){
        insertOne.append("<form action=\"http://localhost:8080/ls\" method=\"get\">"+"\n");
        insertOne.append("<label for=\"url\">URL:</label>"+"\n");
        insertOne.append("<input id=\"url\" name=\"url\" type=\"text\" required size=\"100\"/>"+"\n");
        insertOne.append("<input name=\"los\" type=\"submit\" value=\"Submit\">"+"\n");
        insertOne.append("<input type=\"hidden\" name=\"action\" value=\"process-request\">"+"\n");
        insertOne.append("</form>"+"\n");
        return insertOne.toString();
    }
}

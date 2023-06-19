package de.willi.text_to_vocabulary_trainer.literature.mysql;

import de.willi.text_to_vocabulary_trainer.Users.User;
import de.willi.text_to_vocabulary_trainer.literature.beans.UniqueWord;

import java.sql.*;

public class Mysql {
    private static String url= "jdbc:mysql://localhost:3306/WordCounter";
    private static String username="root";
    private static String password="Elephant55";

    public static void insertNewUser(User user){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection= DriverManager.getConnection(url,username,password);
            Statement statement= connection.createStatement();
            String query = "INSERT INTO Users(Username,email,password)" +
                    "VALUES (?,?,?)" ;
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, user.getName());
            preparedStmt.setString (2, user.getEmail());
            preparedStmt.setString (3, user.getPassword());
            // execute the preparedstatement
            preparedStmt.execute();

            connection.close();
        }catch (Exception e){
            System.out.println("got an exception");
            System.out.println(e);
        }
    }

    public static void addWordToBucket(UniqueWord uniqueWord){

    }

    public static void removeWordFromBucket(UniqueWord uniqueWord){

    }
}

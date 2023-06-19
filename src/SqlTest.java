import java.sql.*;
import java.util.Arrays;

import static java.sql.DriverManager.getConnection;

public class SqlTest {
    public static void main(String[] args) {
        String url= "jdbc:mysql://localhost:3306/willy";
        String username="root";
        String password="Elephant55";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection= DriverManager.getConnection(url,username,password);
             Statement statement= connection.createStatement();
             ResultSet resultSet= statement.executeQuery("select * from Avengers");
             while(resultSet.next()){
                 System.out.println(resultSet.getInt(1)+ " " + resultSet.getString(2));
             }
             connection.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }



    }



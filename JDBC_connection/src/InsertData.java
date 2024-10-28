
//Task-2

import java.sql.*;

public class InsertData {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/studentdb";
            String username ="root";
            String password = "2405";

            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            Object[][] insertStatements = {
                {1, "John", "Doe", 85},
                {2, "Jane", "Smith", 92},
                {3, "Alice", "Johnson", 78},
                {4, "Bob", "Brown", 88},
                {5, "Charlie", "Davis", 95},
                {6, "Emily", "Wilson", 70},
                {7, "Frank", "Taylor", 82},
                {8, "Grace", "Clark", 76},
                {9, "Hank", "White", 89},
                {10, "Ivy", "King", 90}
            };

            for (Object[] student : insertStatements) {
                String insertStatement = String.format("INSERT INTO students (id, firstname,lastname,grade) VALUE(%d , '%s' , '%s' , %d)",(int)student[0],(String)student[1],(String)student[2],(int)student[3]);
                statement.executeUpdate(insertStatement);

            }
            System.out.println("Data inserted successfully!");

            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();// TODO: handle exception
        }
    }
    
}

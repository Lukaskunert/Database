package YEET;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/c3zoo", "root", ""
        );
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(
                "SELECT Zvirata.jmeno, Druhy.nazev, Zvirata.id FROM Zvirata JOIN Druhy ON (Zvirata.druh = Druhy.id) LIMIT 50;"
        );
        while(result.next()) {
            int id = result.getInt("id");
            String name = result.getString("jmeno");
            String type = result.getString("nazev");
            System.out.println(type + "," + name + "," + id + ";");
        }
        connection.close();
    }
}

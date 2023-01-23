package selects_db;

import java.sql.*;

public class ReadingCarsValues {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/car", "root", "root");

        String selectQuery = "SELECT * FROM cars";

        PreparedStatement statement = connection.prepareStatement(selectQuery);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            System.out.println(result.getInt(1)  + " | " +
                               result.getString(2) + " | " +
                               result.getString(3) + " | " +
                               result.getInt(4) + " | " +
                               result.getInt(5));
        }
        statement.close();
        connection.close();
    }
}

package selects_db;

import java.sql.*;

/**
 * Hello world!
 *
 */

public class WritingCarsValues {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/car", "root", "root");

        String insertQuery = "INSERT INTO cars(id, color,  brand, year_of_release, price) " +
                "VALUES (1, 'Black', 'BMW', 2000, 50000)," +
                "(2, 'Yellow', 'Porch', 2015, 100000)," +
                "(3, 'White', 'Audi', 2013, 40000)," +
                "(4, 'Yellow', 'Camara', 2008, 65000)," +
                "(5, 'Pink', 'Ford', 2023, 140000)";

        PreparedStatement statement = connection.prepareStatement(insertQuery);
        statement.executeUpdate();

        statement.close();
        connection.close();





    }


}

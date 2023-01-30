package DAO;

import java.sql.*;

public class CarDAO {
    public void saveNewCar(Car car) {
        String insertSql = "insert into cars (color, brand, year_of_release, price) values (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/car", "root", "root")) {
            PreparedStatement statement = connection.prepareStatement(insertSql);

            statement.setString(1, car.color);
            statement.setString(2, car.brand);
            statement.setInt(3, car.yearOfRelease);
            statement.setInt(4, car.price);

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Car getCarsById(int id) throws SQLException{
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/car", "root", "root");

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM cars WHERE id = ?",
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();
        if (!resultSet.first()) {
            return null;
        }

        Car car = new Car();
        car.id = resultSet.getInt(1);
        car.color = resultSet.getString(2);
        car.brand = resultSet.getString(3);
        car.yearOfRelease = resultSet.getInt(4);
        car.price = resultSet.getInt(5);
        System.out.println(car);
        return car;
    }
}

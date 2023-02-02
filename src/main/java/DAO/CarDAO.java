package DAO;

import java.sql.*;

public class CarDAO {

    private final Connection connection;

     CarDAO() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/car", "root", "root");
    }

    public void saveNewCar(Car car)  {
        String insertSql = "insert into cars (color, brand, year_of_release, price) values (?, ?, ?, ?)";

           try (PreparedStatement statement = connection.prepareStatement(insertSql)) {

               statement.setString(1, car.getColor());
               statement.setString(2, car.getBrand());
               statement.setInt(3, car.getYearOfRelease());
               statement.setInt(4, car.getPrice());

               statement.executeUpdate();
           }
           catch (Exception e) {
               e.printStackTrace();
           }

    }

    public Car getCarsById(int id) {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM cars WHERE id = ?",
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE)) {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.first()) {
                return null;
            }

            Car car = new Car();
            car.setId(resultSet.getInt(1));
            car.setColor(resultSet.getString(2));
            car.setBrand(resultSet.getString(3));
            car.setYearOfRelease(resultSet.getInt(4));
            car.setPrice(resultSet.getInt(5));
            return car;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateCar(Car car, int id) {
        String updateSql =
                "UPDATE cars SET color = ?, brand = ?, year_of_release = ?, price = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(updateSql)) {

            statement.setString(1, car.getColor());
            statement.setString(2, car.getBrand());
            statement.setInt(3, car.getYearOfRelease());
            statement.setInt(4, car.getPrice());
            statement.setInt(5, id);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Car was updated!");
            }
            else {
                System.out.println("Car was not updated!");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeCar(int id) {
         String deleteSql = "DELETE FROM cars WHERE id = ?";

         try (PreparedStatement statement = connection.prepareStatement(deleteSql)) {
             statement.setInt(1, id);

             int rowDeleted = statement.executeUpdate();
             if (rowDeleted > 0) {
                 System.out.println("Car was deleted!");
             }
             else {
                 System.out.println("Car was not deleted!");
             }
         }
         catch (SQLException e) {
             e.printStackTrace();
         }
    }
}

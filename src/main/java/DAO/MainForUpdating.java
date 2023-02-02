package DAO;

import java.sql.SQLException;

public class MainForUpdating {
    public static void main(String[] args) throws SQLException {
        CarDAO carDAO = new CarDAO();
        Car car = new Car("Red", "Moskvich", 1970, 50000);
        carDAO.updateCar(car, 6);
    }
}

package DAO;

import java.sql.SQLException;

public class MainForWriting {
    public static void main(String[] args) throws SQLException {
        CarDAO carDAO = new CarDAO();
        Car car = new Car("yellow", "lada", 2020, 10000);
        carDAO.saveNewCar(car);
    }
}

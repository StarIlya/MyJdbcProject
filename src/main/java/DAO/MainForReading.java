package DAO;

import java.sql.SQLException;

public class MainForReading {
    public static void main(String[] args) throws SQLException {
        CarDAO carDAO = new CarDAO();
        System.out.println(carDAO.getCarsById(5));
    }
}

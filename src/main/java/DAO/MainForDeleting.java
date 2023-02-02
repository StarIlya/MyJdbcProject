package DAO;

import java.sql.SQLException;

public class MainForDeleting {

    public static void main(String[] args) throws SQLException {
        CarDAO carDAO = new CarDAO();
        carDAO.removeCar(5);
    }

}

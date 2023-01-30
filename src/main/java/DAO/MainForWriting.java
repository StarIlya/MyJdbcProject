package DAO;

public class MainForWriting {
    public static void main(String[] args) {
        CarDAO carDAO = new CarDAO();
        Car car = new Car("yellow", "lada", 2020, 10000);
        carDAO.saveNewCar(car);
    }
}

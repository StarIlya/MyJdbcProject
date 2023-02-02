package DAO;

import lombok.Data;

@Data
public class Car {

    private int id;
    private String color;
    private String brand;
    private int yearOfRelease;
    private int price;

    public Car(){}
    public Car(String color, String brand, int yearOfRelease, int price) {
        this.color = color;
        this.brand = brand;
        this.yearOfRelease = yearOfRelease;
        this.price = price;
    }

}
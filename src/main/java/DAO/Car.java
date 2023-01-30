package DAO;

import lombok.Data;

@Data
public class Car {

    public int id;
    public String color;
    public String brand;
    public int yearOfRelease;
    public int price;

    public Car(){}
    public Car(String color, String brand, int yearOfRelease, int price) {
        this.color = color;
        this.brand = brand;
        this.yearOfRelease = yearOfRelease;
        this.price = price;
    }

}
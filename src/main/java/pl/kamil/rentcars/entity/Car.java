package pl.kamil.rentcars.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "color")
    private String color;

    @Column(name = "vin")
    private long vin;

    @Column(name = "rented")
    private boolean rented;

    @Column(name = "fixing")
    private boolean fixing;

    public Car() {
    }

    public Car(String brand, String model, String color, long vin, boolean rented, boolean fixing) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.vin = vin;

        this.rented = rented;
        this.fixing = fixing;
    }

    public Car(int id, String brand, String model, String color, long vin, boolean rented, boolean fixing) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.vin = vin;
        this.rented = rented;
        this.fixing = fixing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getVin() {
        return vin;
    }

    public void setVin(long vin) {
        this.vin = vin;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public boolean isFixing() {
        return fixing;
    }

    public void setFixing(boolean fixing) {
        this.fixing = fixing;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", vin=" + vin +
                ", rented=" + rented +
                ", fixing=" + fixing +
                '}';
    }
}

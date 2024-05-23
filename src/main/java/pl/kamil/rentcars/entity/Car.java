package pl.kamil.rentcars.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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


    public Car(String brand, String model, String color, long vin, boolean rented, boolean fixing) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.vin = vin;

        this.rented = rented;
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

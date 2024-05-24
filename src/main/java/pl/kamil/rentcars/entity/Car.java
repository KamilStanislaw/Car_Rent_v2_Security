package pl.kamil.rentcars.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @NotEmpty(message = "Brand must not be empty")
    @Column(name = "brand")
    private String brand;

    @NotEmpty(message = "Model  must not be empty")
    @Column(name = "model")
    private String model;

    @NotEmpty(message = "Color  must not be empty")
    @Column(name = "color")
    private String color;

    @NotNull()
    @Min(value = 0L)
    @Column(name = "vin")
    private long vin;

    @NotNull()
    @Column(name = "rented")
    private boolean rented;

    @NotNull()
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

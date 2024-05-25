package pl.kamil.rentcars.repository;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pl.kamil.rentcars.entity.Car;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CarRepositoryTest {

    // H2 database to test repo functions - not using real;

    @Autowired
    private CarRepository carRepository;

    @Test
    public void carRepositorySaveAllReturnSavedCar() {

        // Arrange
        Car car1 = new Car("Toyota", "Celica", "black", 2345776666L, false, false);

        // Act
        Car savedCar1 = carRepository.save(car1);

        // Assert
        Assertions.assertThat(savedCar1).isNotNull();
        Assertions.assertThat(car1.getId()).isGreaterThan(0);
        System.out.println(savedCar1);
    }

    @Test
    public void carRepositorySaveAllReturnMoreThanOneSavedCar() {

        Car car1 = new Car("Toyota", "Supra", "black", 2345776543L, false, false);
        Car car2 = new Car("Nissan", "Leaf", "white", 1345806543L, true, false);

        Car savedCar1 = carRepository.save(car1);
        Car savedCar2 = carRepository.save(car2);

        List<Car> carsList = carRepository.findAll();

        Assertions.assertThat(carsList).isNotNull();
        Assertions.assertThat(carsList.size()).isEqualTo(2);
        System.out.println(carsList);
    }

    @Test
    public void carRepositoryFindByIdReturnCar() {

        Car car1 = new Car("Subaru", "Impreza", "blue", 2345776543L, false, false);

        carRepository.save(car1);

        Car foundCar = carRepository.findById(Math.toIntExact(car1.getId())).get();

        Assertions.assertThat(foundCar).isNotNull();
        System.out.println(foundCar);
    }

    @Test
    public void carRepositoryFindByBrandReturnCar() {

        Car car1 = new Car("Volkswagen", "Polo", "grey", 4345776543L, false, false);
        Car car2 = new Car("Subaru", "Impreza", "blue", 2345776543L, false, false);
        Car car3 = new Car("Toyota", "Supra", "black", 1345776543L, false, false);
        Car car4 = new Car("Nissan", "Leaf", "white", 3345806543L, true, false);

        carRepository.save(car1);
        carRepository.save(car2);
        carRepository.save(car3);
        carRepository.save(car4);

        List<Car> carsByBrand = carRepository.findAllByOrderByBrandAsc();

        Assertions.assertThat(carsByBrand).isNotNull();
        Assertions.assertThat(carsByBrand.size()).isEqualTo(4);
        System.out.println(carsByBrand);
    }

    @Test
    public void carRepositoryFindByModelReturnCar() {

        Car car1 = new Car("Volkswagen", "Polo", "grey", 4345776543L, false, false);
        Car car2 = new Car("Subaru", "Impreza", "blue", 2345776543L, false, false);
        Car car3 = new Car("Toyota", "Supra", "black", 1345776543L, false, false);
        Car car4 = new Car("Nissan", "Leaf", "white", 3345806543L, true, false);

        carRepository.save(car1);
        carRepository.save(car2);
        carRepository.save(car3);
        carRepository.save(car4);

        List<Car> carsByBrand = carRepository.findAllByOrderByModelAsc();

        Assertions.assertThat(carsByBrand).isNotNull();
        Assertions.assertThat(carsByBrand.size()).isEqualTo(4);
        System.out.println(carsByBrand);
    }

    @Test
    public void carRepositoryFindByVinReturnCar() {

        Car car1 = new Car("Volkswagen", "Polo", "grey", 4345776543L, false, false);
        Car car2 = new Car("Subaru", "Impreza", "blue", 2345776543L, false, false);
        Car car3 = new Car("Toyota", "Supra", "black", 1345776543L, false, false);
        Car car4 = new Car("Nissan", "Leaf", "white", 3345806543L, true, false);

        carRepository.save(car1);
        carRepository.save(car2);
        carRepository.save(car3);
        carRepository.save(car4);

        List<Car> carsByBrand = carRepository.findAllByOrderByVinAsc();

        Assertions.assertThat(carsByBrand).isNotNull();
        Assertions.assertThat(carsByBrand.size()).isEqualTo(4);
        System.out.println(carsByBrand);
    }

    @Test
    public void carRepositoryUpdateCarReturnCarNotNull() {

        Car car1 = new Car("Volkswagen", "Polo", "grey", 4345776543L, false, false);
        Car savedCar = carRepository.save(car1);
        System.out.println(savedCar);

        Car foundCar = carRepository.findById(Math.toIntExact(savedCar.getId())).get();
        foundCar.setColor("red");
        foundCar.setModel("Golf");
        Car updatedCar = carRepository.save(foundCar);

        Car updatedFoundCar = carRepository.findById(Math.toIntExact(car1.getId())).get();
        System.out.println(updatedFoundCar);

        Assertions.assertThat(updatedCar.getColor()).isNotNull();
        Assertions.assertThat(updatedCar.getModel()).isNotNull();
        Assertions.assertThat(updatedFoundCar.getColor()).isNotEqualTo("grey");
        Assertions.assertThat(updatedFoundCar.getModel()).isNotEqualTo("Polo");
    }

    @Test
    public void carRepositoryDeleteById() {

        Car car1 = Car.builder()
                .brand("Fiat")
                .model("Multipla")
                .color("grey")
                .vin(4444776543L)
                .rented(false)
                .fixing(true)
                .build();

        Car savedCar = carRepository.save(car1);
        System.out.println(savedCar);

        carRepository.deleteById(Math.toIntExact(savedCar.getId()));

        Optional<Car> returnedCar = carRepository.findById(Math.toIntExact(savedCar.getId()));
        System.out.println(returnedCar);

        Assertions.assertThat(returnedCar).isEmpty();

    }

}

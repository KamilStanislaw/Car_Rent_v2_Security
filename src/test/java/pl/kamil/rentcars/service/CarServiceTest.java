package pl.kamil.rentcars.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.kamil.rentcars.entity.Car;
import pl.kamil.rentcars.repository.CarRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    // testing service layer with Mocked repo

    @Mock
    private CarRepository carRepository; //"fake" repo - mocked - simulated real repo?

    @InjectMocks
    private CarServiceImpl carService; //inject "fake" - simulate real repo into real service


    @Test
    public void carServiceFindById() {

        // real DB and cars (repo) not exists - prepare this car1;
        Car car1 = new Car("Subaru", "Impreza", "blue", 2345776543L, false, false);

        // after calling repo methods - not returning real obj/list - returning prepared (or mocked - auto prepared)
        when(carRepository.findById(1)).thenReturn(Optional.ofNullable(car1));


        // calling real carService
        Car foundCar = carService.findById(1);

        Assertions.assertThat(foundCar).isNotNull();
    }

    @Test
    public void carServiceFindAll() {
        List<Car> carResult = Mockito.mock(List.class); // prepared by Mockito - sim real list to return

        when(carRepository.findAll()).thenReturn(carResult); // repo returns List<Cars> - so return mocked

        List<Car> carsList = carService.findAll(); //real service

        Assertions.assertThat(carsList).isNotNull();
    }

    @Test
    public void carServiceDeleteById() {

        Car car1 = new Car(1L, "Subaru", "Impreza", "blue", 2345776543L, false, false);

        when(carRepository.findById(1)).thenReturn(Optional.ofNullable(car1));
        doNothing().when(carRepository).deleteById(Math.toIntExact(car1.getId()));

        Car foundCar = carService.findById(1);
        carService.deleteById(Math.toIntExact(foundCar.getId()));

        assertAll(() -> carService.deleteById(1));
    }

}

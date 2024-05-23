package pl.kamil.rentcars.service;

import pl.kamil.rentcars.entity.Car;

import java.util.List;

public interface CarService {

    List<Car> findAll();

    Car findById(Long id);

    void save(Car car);

    void deleteById(Long id);

    List<Car> findAllByOrderByBrandAsc();

    List<Car> findAllByOrderByModelAsc();

    List<Car> findAllByOrderByVinAsc();


}

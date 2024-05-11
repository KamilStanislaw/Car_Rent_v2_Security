package pl.kamil.rentcars.service;

import pl.kamil.rentcars.entity.Car;

import java.util.List;

public interface CarService {

    List<Car> findAll();

    Car findById(int id);

    void save(Car car);

    void deleteById(int id);

    List<Car> findAllByOrderByBrandAsc();

    List<Car> findAllByOrderByModelAsc();

    List<Car> findAllByOrderByVinAsc();


}

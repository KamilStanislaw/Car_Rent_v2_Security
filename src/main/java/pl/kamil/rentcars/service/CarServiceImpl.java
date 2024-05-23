package pl.kamil.rentcars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kamil.rentcars.entity.Car;
import pl.kamil.rentcars.repository.CarRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Car findById(Long id) {
        Optional<Car> resultCar = carRepository.findById(id);
        Car car = null;
        
        if (resultCar.isPresent()) {
            car = resultCar.get();
        } else {
            throw new RuntimeException("Did not find car id - " + id);
        }
        return car;
    }

    @Override
    public void save(Car car) {
        carRepository.save(car);
    }

    @Override
    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public List<Car> findAllByOrderByBrandAsc() {
        return carRepository.findAllByOrderByBrandAsc();
    }

    @Override
    public List<Car> findAllByOrderByModelAsc() {
        return carRepository.findAllByOrderByModelAsc();
    }

    @Override
    public List<Car> findAllByOrderByVinAsc() {
        return carRepository.findAllByOrderByVinAsc();
    }

}

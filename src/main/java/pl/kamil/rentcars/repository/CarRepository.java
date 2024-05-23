package pl.kamil.rentcars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kamil.rentcars.entity.Car;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByOrderByBrandAsc();
    List<Car> findAllByOrderByModelAsc();
    List<Car> findAllByOrderByVinAsc();


}

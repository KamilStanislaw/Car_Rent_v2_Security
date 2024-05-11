package pl.kamil.rentcars.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import pl.kamil.rentcars.entity.Car;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer>, PagingAndSortingRepository<Car, Integer> {
    List<Car> findAllByOrderByBrandAsc();
    List<Car> findAllByOrderByModelAsc();
    List<Car> findAllByOrderByVinAsc();


}

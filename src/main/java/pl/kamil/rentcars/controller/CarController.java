package pl.kamil.rentcars.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.kamil.rentcars.entity.Car;
import pl.kamil.rentcars.service.CarService;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {
    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/list")
    public String getAll(Model model) {

        List<Car> cars = carService.findAll();
        model.addAttribute("cars", cars);

        return "cars/list-cars";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("car") Car car) { // take modelAttribute made in form
        carService.save(car);

        return "redirect:/cars/list";
    }

    @GetMapping("/showAddForm") // need new model do add a new car
    public String showAddForm(Model model) {

        Car theCar = new Car();
        model.addAttribute("car", theCar);

        return "cars/add-form";
    }

    @GetMapping("/showUpdateForm")
    public String showUpdateForm(@RequestParam("carId") int id, Model model) {

        Car theCar = carService.findById(id);
        model.addAttribute("car", theCar);

        return "cars/update-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("carId") int id) {

        carService.deleteById(id);

        return "redirect:/cars/list";
    }

    @GetMapping("/brand")
    public String getAllByBrand(Model model) {

        List<Car> cars = carService.findAllByOrderByBrandAsc();
        model.addAttribute("cars", cars);

        return "cars/list-cars";
    }

    @GetMapping("/model")
    public String getAllByMode(Model model) {

        List<Car> cars = carService.findAllByOrderByModelAsc();
        model.addAttribute("cars", cars);

        return "cars/list-cars";
    }

    @GetMapping("/vin")
    public String getAllByVin(Model model) {

        List<Car> cars = carService.findAllByOrderByVinAsc();
        model.addAttribute("cars", cars);

        return "cars/list-cars";
    }

}

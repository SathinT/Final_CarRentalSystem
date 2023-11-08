package lk.easyCarRental.controller;

import lk.easyCarRental.dto.CarDTO;
import lk.easyCarRental.dto.UserDTO;
import lk.easyCarRental.service.CarService;
import lk.easyCarRental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
@CrossOrigin

public class CarController {
    @Autowired
    CarService carService;

    @GetMapping
    public ResponseUtil getCar(){
        System.out.println(carService.getAllCars());

        return new ResponseUtil("OK","Car Added Successfully",carService.getAllCars());
    }
    @PostMapping
    public ResponseUtil addCar(@ModelAttribute CarDTO carDTO, @ModelAttribute UserDTO userDTO){
        System.out.println("PostMapping");
        System.out.println(carDTO.toString());
        System.out.println(userDTO.toString());
        carService.saveCar(carDTO);
        return new ResponseUtil("OK","Successfully Car Registered",null);
    }
}

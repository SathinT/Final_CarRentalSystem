package lk.easyCarRental.service;

import lk.easyCarRental.dto.CarDTO;
import lk.easyCarRental.dto.CustomerDTO;

import java.util.ArrayList;

public interface CarService {
    ArrayList<CarDTO> getAllCars();

    void saveCar(CarDTO carDTO);
    void deleteCar(String CarRegNo, CarDTO carDTO);
    void updateCar(CarDTO carDTO);
}

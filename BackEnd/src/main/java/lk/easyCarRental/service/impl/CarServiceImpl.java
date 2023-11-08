package lk.easyCarRental.service.impl;

import lk.easyCarRental.dto.CarDTO;
import lk.easyCarRental.dto.CustomerDTO;
import lk.easyCarRental.entity.Car;
import lk.easyCarRental.entity.Customer;
import lk.easyCarRental.repo.CarRepo;
import lk.easyCarRental.repo.CustomerRepo;
import lk.easyCarRental.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional

public class CarServiceImpl implements CarService {

    @Autowired
    CarRepo carRepo;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public ArrayList<CarDTO> getAllCars() {

        System.out.println(getAllCars());

        List<Car> all = carRepo.findAll();
        return modelMapper.map(all, new TypeToken<List<CarDTO>>() {
        }.getType());
    }

    @Override
    public void saveCar(CarDTO carDTO) {
        Car car = modelMapper.map(carDTO, Car.class);

        if (carRepo.existsById(carDTO.getCarId())) {
            throw new RuntimeException("Car ID Already Exists.");
        }

        try {
            String path = System.getProperty("user.dir");
            File file = new File(path + "/uploads/car/carFront");
            File file2 = new File(path + "/uploads/car/carBack");
            File file3 = new File(path + "/uploads/car/carSide");
            File file4 = new File(path + "/uploads/car/carInterior");

            if (!file.exists()) {
                file.mkdirs();
                System.out.println("Directory 'carFront' created.");
            }

            if (!file2.exists()) {
                file2.mkdirs();
                System.out.println("Directory 'carBack' created.");
            }

            if (!file3.exists()) {
                file3.mkdirs();
                System.out.println("Directory 'carSide' created.");
            }

            if (!file4.exists()) {
                file4.mkdirs();
                System.out.println("Directory 'carInterior' created.");
            }


            File frontFile = new File(file.getAbsolutePath() + "/" + carDTO.getCarImageFront().getOriginalFilename());
            if (frontFile.exists()) {
                throw new RuntimeException("File 'carFront/" + frontFile.getName() + "' already exists.");
            } else {
                carDTO.getCarImageFront().transferTo(frontFile);
                car.setCarImageFront("uploads/car/carFront/" + frontFile.getName());
            }

            File backFile = new File(file2.getAbsolutePath() + "/" + carDTO.getCarImageBack().getOriginalFilename());
            if (backFile.exists()) {
                throw new RuntimeException("File 'carBack/" + backFile.getName() + "' already exists.");
            } else {
                carDTO.getCarImageBack().transferTo(backFile);
                car.setCarImageBack("uploads/car/carBack/" + backFile.getName());
            }

            File sideFile = new File(file3.getAbsolutePath() + "/" + carDTO.getCarImageSide().getOriginalFilename());
            if (sideFile.exists()) {
                throw new RuntimeException("File 'carSide/" + sideFile.getName() + "' already exists.");
            } else {
                carDTO.getCarImageSide().transferTo(sideFile);
                car.setCarImageSide("uploads/car/carSide/" + sideFile.getName());
            }

            File interiorFile = new File(file4.getAbsolutePath() + "/" + carDTO.getCarImageInterior().getOriginalFilename());
            if (interiorFile.exists()) {
                throw new RuntimeException("File 'carInterior/" + interiorFile.getName() + "' already exists.");
            } else {
                carDTO.getCarImageInterior().transferTo(interiorFile);
                car.setCarImageInterior("uploads/car/carInterior/" + interiorFile.getName());
            }

            System.out.println(car);
            carRepo.save(car);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    @Override
    public void deleteCar(String CarRegNo, CarDTO carDTO) {

    }

    @Override
    public void updateCar(CarDTO carDTO) {

    }
}

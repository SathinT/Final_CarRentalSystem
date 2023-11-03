package lk.easyCarRental.service.impl;

import lk.easyCarRental.dto.CustomerDTO;
import lk.easyCarRental.dto.DriverDTO;
import lk.easyCarRental.entity.Customer;
import lk.easyCarRental.entity.Driver;
import lk.easyCarRental.entity.User;
import lk.easyCarRental.repo.CustomerRepo;
import lk.easyCarRental.repo.DriverRepo;
import lk.easyCarRental.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional

public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepo driverRepo;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public ArrayList<DriverDTO> getAllDrivers() {

        List<Driver> all = driverRepo.findAll();
        return modelMapper.map(all, new TypeToken<List<DriverDTO>>() {
        }.getType());
    }

    @Override
    public void saveDriver(DriverDTO driverDTO) {
        Driver driver= modelMapper.map(driverDTO,Driver.class);
        driver.setUser(new User(driver.getUser().getUserName(),driver.getUser().getPassword(), "DRIVER"));

        if (driverRepo.existsById(driver.getDriverId())){
            throw new RuntimeException("Driver ID Already Exists");
        }
        else if (driverRepo.existsById(driverDTO.getDriverId())){
            throw new RuntimeException("Sorry! Username Already Exists");
        }

        try {
            String path= System.getProperty("user.dir");
            File file1 = new File(path + "/upload/driver/drivingLicenseFront");
            File file2 = new File(path + "/upload/driver/drivingLicenseBack");

            // Create directories if they don't exist
            file1.mkdirs();
            file2.mkdirs();

            File licenFFile = new File(file1, driverDTO.getDriverFrontImg().getOriginalFilename());
            File licenBFile = new File(file2, driverDTO.getDriverBackImg().getOriginalFilename());

            if (licenFFile.exists()) {
                throw new RuntimeException("LicenF File Already Exists");
            }

            driverDTO.getDriverFrontImg().transferTo(licenFFile);
            driver.setDriverFrontImg("upload/driver/drivingLicenseFront" + licenFFile.getName());

            if (licenBFile.exists()) {
                throw new RuntimeException("LicenB File Already Exists");
            }

            driverDTO.getDriverBackImg().transferTo(licenBFile);
            driver.setDriverBackImg("upload/driver/drivingLicenseBack" + licenBFile.getName());

            System.out.println(driver);
            driverRepo.save(driver);
        } catch (IOException e) {
            // Handle IOException, e.g., file transfer failure
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDriver(String driverId, DriverDTO driverDTO) {

    }

    @Override
    public void updateDriver(DriverDTO driverDTO) {

    }
}

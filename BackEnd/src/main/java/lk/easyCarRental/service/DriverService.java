package lk.easyCarRental.service;

import lk.easyCarRental.dto.DriverDTO;

import java.util.ArrayList;

public interface DriverService {
    ArrayList<DriverDTO> getAllDrivers();

    void saveDriver(DriverDTO driverDTO);
    void deleteDriver(String driverId);
    void updateDriver(DriverDTO driverDTO);
}

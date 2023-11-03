package lk.easyCarRental.controller;

import lk.easyCarRental.dto.DriverDTO;
import lk.easyCarRental.dto.UserDTO;
import lk.easyCarRental.service.DriverService;
import lk.easyCarRental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
@CrossOrigin

public class DriverController {
    @Autowired
    DriverService driverService;

    @GetMapping
    public ResponseUtil getDriver(){

        return new ResponseUtil("OK","Driver Successfully Loaded",driverService.getAllDrivers());
    }

    @PostMapping
    public ResponseUtil addDriver(@ModelAttribute DriverDTO driverDTO, @ModelAttribute UserDTO userDTO){
        System.out.println("PostMapping");
        System.out.println(driverDTO.toString());
        System.out.println(userDTO.toString());
        driverDTO.setUser(userDTO);
        driverService.saveDriver(driverDTO);
        return new ResponseUtil("OK","Successfully Driver Registered!", null );
    }
}
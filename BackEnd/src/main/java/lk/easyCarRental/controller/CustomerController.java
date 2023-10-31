package lk.easyCarRental.controller;

import lk.easyCarRental.service.CustomerService;
import lk.easyCarRental.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lk.easyCarRental.dto.CustomerDTO;
import lk.easyCarRental.dto.UserDTO;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponseUtil getCustomer(){
        return new ResponseUtil("Ok","Customer Successfully Added",null);
    }

    @PostMapping
    public ResponseUtil addCustomer(@ModelAttribute CustomerDTO customerDTO, @ModelAttribute UserDTO userDTO) {
        System.out.println("PostMapping");
        System.out.println(customerDTO.toString());
        System.out.println(userDTO.toString());
        customerDTO.setUser(userDTO);
        customerService.saveCustomer(customerDTO);
        return new ResponseUtil("OK", "Successfully Registered!", null);
    }
}
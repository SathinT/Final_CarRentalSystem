package lk.easyCarRental.controller;

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
//    CustomerService customerService;

    @GetMapping
    public ResponseUtil getCustomer(){
        return new ResponseUtil("Ok","Customer Successfully Added",null);
    }

    @PostMapping
    public ResponseUtil addCustomer(@ModelAttribute CustomerDTO customerDTO, @ModelAttribute UserDTO userDTO) {
        System.out.println("PostMapping");
        System.out.println(customerDTO);
//        customerService.saveCustomer(customerDTO);
        return new ResponseUtil("OK", "Account Create Successfully!", customerDTO);
    }
}
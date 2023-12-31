package lk.easyCarRental.controller;

import lk.easyCarRental.service.CustomerService;
import lk.easyCarRental.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lk.easyCarRental.dto.CustomerDTO;
import lk.easyCarRental.dto.UserDTO;

@RestController
@RequestMapping("/customer")
@CrossOrigin
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseUtil getCustomer(){
        return new ResponseUtil("Ok","Customer Successfully Loaded",customerService.getAllCustomer());
    }

    @PostMapping
    public ResponseUtil addCustomer(@ModelAttribute CustomerDTO customerDTO, @ModelAttribute UserDTO userDTO) {
        System.out.println("PostMapping");
        System.out.println(customerDTO.toString());
        System.out.println(userDTO.toString());
        customerDTO.setUser(userDTO);
        customerService.saveCustomer(customerDTO);
        return new ResponseUtil("OK", "Successfully Customer Registered!", null);
    }


}
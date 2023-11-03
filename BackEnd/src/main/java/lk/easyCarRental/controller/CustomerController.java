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

    @DeleteMapping("/customers/{customerId}")
    public ResponseUtil deleteCustomer(@PathVariable String customerId) {
        // Check if the customer exists
        if (customerService.customerExists(customerId)) {
            customerService.deleteCustomer(customerId); // Assuming you have a method for deleting a customer by customerId
            return new ResponseUtil("OK", "Customer deleted successfully", null);
        } else {
            return new ResponseUtil("Error", "Customer not found", null);
        }
    }



}
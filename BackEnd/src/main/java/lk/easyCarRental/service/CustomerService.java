package lk.easyCarRental.service;

import lk.easyCarRental.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public interface CustomerService {
    ArrayList<CustomerDTO> getAllCustomer();
    void saveCustomer(CustomerDTO customerDTO);
    void deleteCustomer(String customerId);
    void updateCustomer(CustomerDTO customerDTO);
}

package lk.easyCarRental.service.impl;

import lk.easyCarRental.dto.CustomerDTO;
import lk.easyCarRental.entity.Customer;
import lk.easyCarRental.entity.User;
import lk.easyCarRental.repo.CustomerRepo;
import lk.easyCarRental.service.CustomerService;
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
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    ModelMapper modelMapper;

//    @Override
//    public ArrayList<CustomerDTO> getAllCustomers(){
//        return null;
//    }
//    @Override
//    public void SaveCustomer(CustomerDTO customerDTO){
//
//    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() {

        List<Customer> all = customerRepo.findAll();
        return modelMapper.map(all, new TypeToken<List<CustomerDTO>>() {
        }.getType());
    }

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        Customer customer= modelMapper.map(customerDTO,Customer.class);
        customer.setUser(new User(customer.getUser().getUserName(),customer.getUser().getPassword(), "CUSTOMER"));

        if (customerRepo.existsById(customer.getCustomerId())){
            throw new RuntimeException("Customer ID Already Exists");
        }
        else if (customerRepo.existsById(customerDTO.getCustomerId())){
            throw new RuntimeException("Sorry! UserName Already Taken");
        }

        try {
            String path = System.getProperty("user.dir");
            File file1 = new File(path + "/upload/customer/drivingLicenseFront");
            File file2 = new File(path + "/upload/customer/drivingLicenseBack");

            // Create directories if they don't exist
            file1.mkdirs();
            file2.mkdirs();

            File licenFFile = new File(file1, customerDTO.getLicenFrontImg().getOriginalFilename());
            File licenBFile = new File(file2, customerDTO.getLicenBackImg().getOriginalFilename());

            if (licenFFile.exists()) {
                throw new RuntimeException("LicenF File Already Exists");
            }

            customerDTO.getLicenFrontImg().transferTo(licenFFile);
            customer.setLicenFrontImg("upload/customer/drivingLicenseFront" + licenFFile.getName());

            if (licenBFile.exists()) {
                throw new RuntimeException("LicenB File Already Exists");
            }

            customerDTO.getLicenBackImg().transferTo(licenBFile);
            customer.setLicenBackImg("upload/customer/drivingLicenseBack" + licenBFile.getName());

            customerRepo.save(customer);
            System.out.println(customer);

        } catch (IOException e) {
            // Handle IOException, e.g., file transfer failure
            e.printStackTrace();
        } catch (Exception e) {
            // Handle other exceptions
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(String customerId) {

    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {

    }
}

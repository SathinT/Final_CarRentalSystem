package lk.easyCarRental.repo;

import lk.easyCarRental.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer, String> {
}

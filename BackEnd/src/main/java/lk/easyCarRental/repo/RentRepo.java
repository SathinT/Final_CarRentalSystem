package lk.easyCarRental.repo;

import lk.easyCarRental.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepo extends JpaRepository<Rent, String> {
}

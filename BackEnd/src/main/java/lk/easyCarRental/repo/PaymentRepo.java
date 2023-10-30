package lk.easyCarRental.repo;

import lk.easyCarRental.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository <Payment, String> {
}

package lk.easyCarRental.repo;

import lk.easyCarRental.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepo extends JpaRepository<Login, String> {
}

package lk.easyCarRental.repo;

import lk.easyCarRental.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository <User ,String >{
}

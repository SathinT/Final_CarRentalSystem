package lk.easyCarRental.dto;

import lk.easyCarRental.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class DriverDTO {
    private String driverId;
    private String driverLicenNo;
    private String driverName;
    private String driverEmail;
    private String driverContactNo;
    private String driverFrontImg;
    private String driverBackImg;
    private User user;
}

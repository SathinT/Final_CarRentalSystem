package lk.easyCarRental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class Driver {
    @Id
    private String driverId;
    private String driverLicenNo;
    private String driverName;
    private String driverEmail;
    private String driverContactNo;
    private String driverFrontImg;
    private String driverBackImg;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}

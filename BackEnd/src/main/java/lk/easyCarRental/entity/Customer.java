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

public class Customer {
    @Id
    private String customerId;
    private  String name;
    private String address;
    private String contactNo;
    private String email;
    private String nicNo;
    private String licenNo;
    private String licenFrontImg;
    private String licenBackImg;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}

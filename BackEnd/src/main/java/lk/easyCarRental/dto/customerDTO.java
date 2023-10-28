package lk.easyCarRental.dto;

import lk.easyCarRental.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class customerDTO {
    private String customerId;
    private  String name;
    private String address;
    private String contactNo;
    private String email;
    private String nicNo;
    private String licenNo;
    private String licenFrontImg;
    private String licenBackImg;
    private User user;
}

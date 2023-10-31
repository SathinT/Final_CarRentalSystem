package lk.easyCarRental.dto;

import lk.easyCarRental.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class CustomerDTO {

    private String customerId;
    private  String name;
    private String address;
    private String contactNo;
    private String email;
    private String nicNo;
    private String licenNo;
    private MultipartFile licenFrontImg;
    private MultipartFile licenBackImg;
    private UserDTO user;
}

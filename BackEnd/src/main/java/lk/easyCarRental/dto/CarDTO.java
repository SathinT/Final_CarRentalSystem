package lk.easyCarRental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class CarDTO {
    private String CarId;
    private String CarRegNo;
    private String CarBrand;
    private String CarType;
    private String CarNoOfPassengers;
    private String CarColor;
    private String CarTransmission;
    private String CarFuel;
    private String CarDailyRate;
    private String CarMonthlyRate;
    private String CarExKmPrice;
    private String CarCurrentMilage;
    private String CarDailyFree;
    private String dailyPrice;
    private String CarMonthlyFreeMilage;
    private String monthlyFreeMilagePrice;
    private MultipartFile CarImageFront;
    private MultipartFile CarImageBack;
    private MultipartFile CarImageSide;
    private MultipartFile CarImageInterior;
}

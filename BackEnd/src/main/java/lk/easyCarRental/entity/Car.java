package lk.easyCarRental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class Car {
    @Id
    String CarId;
    String CarRegNo;
    String CarBrand;
    String CarType;
    String CarNoOfPassengers;
    String CarColor;
    String CarTransmission;
    String CarFuel;
    String CarDailyRate;
    String CarMonthlyRate;
    String CarExKmPrice;
    String CarCurrentMilage;
    String CarDailyFree;
    String dailyPrice;
    String CarMonthlyFreeMilage;
    String monthlyFreeMilagePrice;
    String CarImageFront;
    String CarImageBack;
    String CarImageSide;
    String CarImageInterior;
}

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
    String carId;
    String regNo;
    String brand;
    String type;
    String passenger;
    String color;
    String transmissionType;
    String fuel;
    String currentMilage;
    String extraMilagePrice;
    String waiverPayment;
    String availability;
    String dailyFreeMilage;
    String dailyPrice;
    String monthlyFreeMilage;
    String monthlyFreeMilagePrice;
    String frontImg;
    String backImg;
    String sideImg;
    String interiorImg;
}

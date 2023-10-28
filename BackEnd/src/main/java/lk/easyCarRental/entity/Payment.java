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

public class Payment {
    @Id
    private String paymentId;
    private double waiverReduction;
    private String waiverSlip;
    private double extraMilagePayment;
}

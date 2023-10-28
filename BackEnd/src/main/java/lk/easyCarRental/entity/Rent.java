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

public class Rent {
    @Id
    private String rentId;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "customerId",referencedColumnName = "customerId",nullable = false)
    private Customer cusId;
    private String pickupTime;
    private String pickupDate;
    private String availability;
    private String declineReason;
}

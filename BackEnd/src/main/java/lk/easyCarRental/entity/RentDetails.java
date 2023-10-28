package lk.easyCarRental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class RentDetails implements Serializable {
    @Id
    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "rentId",referencedColumnName = "rentId",nullable = false)
    private Rent rentId;

    @Id
    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "carId",referencedColumnName = "carId",nullable = false)
    private Car carId;

    @Id
    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "driverId",referencedColumnName = "driverId",nullable = false)
    private Driver driverId;

    @Id
    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "paymentId",referencedColumnName = "paymentId",nullable = false)
    private Payment paymentId;
}

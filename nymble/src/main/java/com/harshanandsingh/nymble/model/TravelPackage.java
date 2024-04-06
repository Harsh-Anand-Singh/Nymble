package com.harshanandsingh.nymble.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "travel_package")
public class TravelPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "travel_package_id")
    private Long travelPackageId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "passenger_capacity", nullable = false)
    private Integer passengerCapacity;

    @OneToMany(mappedBy = "travelPackage")
    private List<Destination> destinations;

    @OneToMany(mappedBy = "travelPackage")
    private List<Passenger> passengers;
}
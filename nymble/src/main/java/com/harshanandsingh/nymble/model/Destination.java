package com.harshanandsingh.nymble.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "destinations")
@Entity
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "destination_id")
    private Long destinationId;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "travel_package_id", nullable = false)
    private TravelPackage travelPackage;

    @OneToMany(mappedBy = "destination")
    private List<Activity> activities;
}

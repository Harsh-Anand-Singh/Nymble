package com.harshanandsingh.nymble.controller;

import com.harshanandsingh.nymble.model.TravelPackage;
import com.harshanandsingh.nymble.service.TravelPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/travel-packages")
public class TravelPackageController {

    @Autowired
    private TravelPackageService travelPackageService;

    @GetMapping
    public ResponseEntity<List<TravelPackage>> getAllTravelPackages() {
        List<TravelPackage> travelPackages = travelPackageService.getAllTravelPackages();
        return new ResponseEntity<>(travelPackages, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TravelPackage> getTravelPackageById(@PathVariable("id") Long id) {
        TravelPackage travelPackage = travelPackageService.getTravelPackageById(id);
        return new ResponseEntity<>(travelPackage, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TravelPackage> createTravelPackage(@RequestBody TravelPackage travelPackage) {
        TravelPackage createdTravelPackage = travelPackageService.createTravelPackage(travelPackage);
        return new ResponseEntity<>(createdTravelPackage, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TravelPackage> updateTravelPackage(@PathVariable("id") Long id, @RequestBody TravelPackage travelPackage) {
        TravelPackage updatedTravelPackage = travelPackageService.updateTravelPackage(id, travelPackage);
        return new ResponseEntity<>(updatedTravelPackage, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTravelPackage(@PathVariable("id") Long id) {
        travelPackageService.deleteTravelPackage(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

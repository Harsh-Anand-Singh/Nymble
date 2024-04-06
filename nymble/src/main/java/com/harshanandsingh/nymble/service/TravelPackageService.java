package com.harshanandsingh.nymble.service;

import com.harshanandsingh.nymble.model.TravelPackage;
import com.harshanandsingh.nymble.repository.TravelPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TravelPackageService {
    private final TravelPackageRepository travelPackageRepository;

    @Autowired
    public TravelPackageService(TravelPackageRepository travelPackageRepository) {
        this.travelPackageRepository = travelPackageRepository;
    }

    public List<TravelPackage> getAllTravelPackages() {
        return travelPackageRepository.findAll();
    }

    public TravelPackage getTravelPackageById(Long id) {
        return travelPackageRepository.findById(id).orElse(null);
    }

    public TravelPackage createTravelPackage(TravelPackage travelPackage) {
        return travelPackageRepository.save(travelPackage);
    }

    public TravelPackage updateTravelPackage(Long id, TravelPackage newTravelPackage) {
        return travelPackageRepository.findById(id).map(existingTravelPackage -> {
            existingTravelPackage.setName(newTravelPackage.getName());
            existingTravelPackage.setPassengerCapacity(newTravelPackage.getPassengerCapacity());
            return travelPackageRepository.save(existingTravelPackage);
        }).orElse(null);
    }

    public void deleteTravelPackage(Long id) {
        travelPackageRepository.deleteById(id);
    }
}
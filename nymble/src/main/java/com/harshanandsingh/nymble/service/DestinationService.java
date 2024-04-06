package com.harshanandsingh.nymble.service;

import com.harshanandsingh.nymble.model.Destination;
import com.harshanandsingh.nymble.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinationService {

    @Autowired
    private DestinationRepository destinationRepository;

    public List<Destination> getAllDestinations() {
        return destinationRepository.findAll();
    }

    public Destination getDestinationById(Long id) {
        Optional<Destination> optionalDestination = destinationRepository.findById(id);
        return optionalDestination.orElse(null);
    }

    public Destination createDestination(Destination destination) {
        return destinationRepository.save(destination);
    }

    public Destination updateDestination(Long id, Destination newDestination) {
        Optional<Destination> optionalDestination = destinationRepository.findById(id);
        if (optionalDestination.isPresent()) {
            Destination existingDestination = optionalDestination.get();
            existingDestination.setName(newDestination.getName());

            return destinationRepository.save(existingDestination);
        }
        return null;
    }

    public void deleteDestination(Long id) {
        destinationRepository.deleteById(id);
    }
}
package com.harshanandsingh.nymble.service;

import com.harshanandsingh.nymble.model.Passenger;
import com.harshanandsingh.nymble.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public Passenger getPassengerById(Long id) {
        Optional<Passenger> optionalPassenger = passengerRepository.findById(id);
        return optionalPassenger.orElse(null);
    }

    public Passenger createPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public Passenger updatePassenger(Long id, Passenger newPassenger) {
        Optional<Passenger> optionalPassenger = passengerRepository.findById(id);
        if (optionalPassenger.isPresent()) {
            Passenger existingPassenger = optionalPassenger.get();
            existingPassenger.setName(newPassenger.getName());
            return passengerRepository.save(existingPassenger);
        }
        return null;
    }

    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }
}
package com.harshanandsingh.nymble.repository;

import com.harshanandsingh.nymble.model.TravelPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TravelPackageRepository extends JpaRepository<TravelPackage, Long> {
}
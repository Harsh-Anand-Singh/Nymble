package com.harshanandsingh.nymble.repository;

import com.harshanandsingh.nymble.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

}
package com.harshanandsingh.nymble.service;

import com.harshanandsingh.nymble.model.Activity;
import com.harshanandsingh.nymble.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    public Activity getActivityById(Long id) {
        Optional<Activity> optionalActivity = activityRepository.findById(id);
        return optionalActivity.orElse(null);
    }

    public Activity createActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    public Activity updateActivity(Long id, Activity newActivity) {
        Optional<Activity> optionalActivity = activityRepository.findById(id);
        if (optionalActivity.isPresent()) {
            Activity existingActivity = optionalActivity.get();
            existingActivity.setName(newActivity.getName());

            return activityRepository.save(existingActivity);
        }
        return null;
    }

    public void deleteActivity(Long id) {
        activityRepository.deleteById(id);
    }
}
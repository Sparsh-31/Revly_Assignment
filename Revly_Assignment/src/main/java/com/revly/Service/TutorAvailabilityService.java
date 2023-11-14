package com.revly.Service;

import java.util.List;

import com.revly.Entity.User;

public interface TutorAvailabilityService {

	void updateLastPingTime(Integer tutorID);

    List<User> getAllTutors();
}

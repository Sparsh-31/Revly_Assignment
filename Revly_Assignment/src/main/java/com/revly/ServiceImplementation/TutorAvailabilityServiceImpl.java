package com.revly.ServiceImplementation;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revly.Entity.TutorAvailability;
import com.revly.Entity.User;
import com.revly.Entity.UserType;
import com.revly.Repository.TutorAvailabilityRepository;
import com.revly.Repository.UserRepository;
import com.revly.Service.TutorAvailabilityService;

public class TutorAvailabilityServiceImpl implements TutorAvailabilityService {

	@Autowired
    private TutorAvailabilityRepository tutorAvailabilityRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void updateLastPingTime(Integer tutorID) {
		// TODO Auto-generated method stub
		TutorAvailability tutorAvailability = tutorAvailabilityRepository.findByTutorID(tutorID);

        if (tutorAvailability == null) {
            tutorAvailability = new TutorAvailability();
            tutorAvailability.setTutorID(tutorID);
        }

        tutorAvailability.setLastPingTime(LocalDateTime.now());

        tutorAvailabilityRepository.save(tutorAvailability);
	}

	@Override
	public List<User> getAllTutors() {
		// TODO Auto-generated method stub
		List<User> availableList = userRepository.findByUserType(UserType.TUTOR);
		if(availableList.size() != 0) return availableList;
		else return Collections.emptyList();
	}
	
	

}

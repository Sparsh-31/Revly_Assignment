package com.revly.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revly.Entity.TutorAvailability;

public interface TutorAvailabilityRepository extends JpaRepository<TutorAvailability, Long> {

	TutorAvailability findByTutorID(Integer tutorID);

}

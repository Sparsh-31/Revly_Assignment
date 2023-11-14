package com.revly.Controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revly.Entity.User;
import com.revly.Service.TutorAvailabilityService;

@RestController
@RequestMapping("/revly/tutor-availability")
public class TutorAvailabilityController {

    @Autowired
    private TutorAvailabilityService tutorAvailabilityService;

    @PostMapping("/update-ping-time")
    public ResponseEntity<String> updatePingTime(@RequestParam Integer tutorID) {
        try {
            tutorAvailabilityService.updateLastPingTime(tutorID);
            return ResponseEntity.ok("Ping time updated successfully");
        } catch (Exception e) {
            // Log the exception or handle it appropriately
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update ping time");
        }
    }

    @GetMapping("/get-All-tutors")
    public ResponseEntity<List<User>> getAllTutors() {
        try {
            List<User> onlineTutors = tutorAvailabilityService.getAllTutors();
            return ResponseEntity.ok(onlineTutors);
        } catch (Exception e) {
            // Log the exception or handle it appropriately
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }
    }
}

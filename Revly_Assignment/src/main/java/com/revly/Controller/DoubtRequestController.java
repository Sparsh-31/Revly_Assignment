package com.revly.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revly.Entity.DoubtRequest;
import com.revly.Entity.DoubtRequestCreateRequest;
import com.revly.Entity.User;
import com.revly.Exception.DoubtRequestException;
import com.revly.Exception.UserException;
import com.revly.Repository.UserRepository;
import com.revly.Service.DoubtRequestService;
import com.revly.Service.UserService;

@RestController
@RequestMapping("/revly/doubt-request")
public class DoubtRequestController {

    @Autowired
    private DoubtRequestService doubtRequestService;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<String> createDoubtRequest(@RequestBody DoubtRequestCreateRequest request) {
        try {
            // Use doubtRequestService to get the user
            User user = doubtRequestService.getUserById(request.getUserId());
            String query = request.getQuery();
    
            String response = doubtRequestService.createDoubtRequest(user, query);
    
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (DoubtRequestException e) {
            // Handle exception appropriately
            return new ResponseEntity<>("Failed to create doubt request.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    
    }

    @GetMapping("/history/{userId}")
    public ResponseEntity<List<DoubtRequest>> getDoubtHistory(@PathVariable Long userId) {
        try {
            // Use doubtRequestService to get doubt history
            List<DoubtRequest> doubtHistory = doubtRequestService.getDoubtHistory(userId);
    
            return new ResponseEntity<>(doubtHistory, HttpStatus.OK);
        } catch (DoubtRequestException e) {
            // Handle the exception appropriately, e.g., log it
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }



}

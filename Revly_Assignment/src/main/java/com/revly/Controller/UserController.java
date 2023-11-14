package com.revly.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revly.Entity.User;
import com.revly.Exception.UserException;
import com.revly.Service.UserService;

@RestController
@RequestMapping("/revly/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            userService.registerUser(user);
            return ResponseEntity.ok("User registered successfully");
        } catch (UserException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam String username, @RequestParam String password) {
        try {
            String token = userService.loginUser(username, password);
            return ResponseEntity.ok(token);
        } catch (UserException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logoutUser(@RequestParam String token) {
        userService.logoutUser(token);
        return ResponseEntity.ok("User logged out successfully");
    }

    @GetMapping("/check-token")
    public ResponseEntity<String> checkToken(@RequestParam String token) {
        boolean isBlacklisted = userService.isTokenBlacklisted(token);
        if (isBlacklisted) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token is blacklisted");
        } else {
            return ResponseEntity.ok("Token is valid");
        }
    }
}
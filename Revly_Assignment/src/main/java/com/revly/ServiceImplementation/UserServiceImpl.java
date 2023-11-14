package com.revly.ServiceImplementation;

import java.sql.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.revly.Entity.User;
import com.revly.Exception.UserException;
import com.revly.Repository.UserRepository;
import com.revly.Service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Set<String> tokenBlacklist = new HashSet<>();

    @Override
    public User registerUser(User user) throws UserException {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new UserException("Username is already taken.");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public String loginUser(String username, String password) throws UserException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserException("User not found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new UserException("Invalid password");
        }

        // Generate and return a JWT token upon successful login
        return generateJwtToken(user);
    }

    @Override
    public void logoutUser(String token) {

        tokenBlacklist.add(token);
    }

    @Override
    public String generateJwtToken(User user) {

        long expirationTimeMillis = 3600000; 
        String secretKey = "yourSecretKey"; 

        return Jwts.builder()
                .setSubject(user.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTimeMillis))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    @Override
    public boolean isTokenBlacklisted(String token) {
        return tokenBlacklist.contains(token);
    }

	@Override
	public User getByUserId(Long userId) throws UserException {
		// TODO Auto-generated method stub
		Optional<User> optionalUser = userRepository.findById(userId);

	    if (optionalUser.isPresent()) {
	        return optionalUser.get();
	    } else {
	        throw new UserException("User not found with ID: " + userId);
	    }
	}
}
package com.revly.Service;

import com.revly.Entity.User;
import com.revly.Exception.UserException;

public interface UserService {
	
	public User registerUser(User user) throws UserException;
	public String loginUser(String username, String password) throws UserException;
	public void logoutUser(String token);
	String generateJwtToken(User user);
	public User getByUserId(Long userId) throws UserException;
    boolean isTokenBlacklisted(String token);
	
}

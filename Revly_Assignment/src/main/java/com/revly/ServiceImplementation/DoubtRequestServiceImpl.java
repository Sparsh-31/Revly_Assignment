package com.revly.ServiceImplementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revly.Entity.DoubtRequest;
import com.revly.Entity.User;
import com.revly.Entity.UserType;
import com.revly.Exception.DoubtRequestException;
import com.revly.Repository.DoubtRequestRepository;
import com.revly.Repository.UserRepository;
import com.revly.Service.DoubtRequestService;

@Service
public class DoubtRequestServiceImpl implements DoubtRequestService {
	
	@Autowired
    private DoubtRequestRepository doubtRequestRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public String createDoubtRequest(User user, String query) throws DoubtRequestException {
		// TODO Auto-generated method stub
		DoubtRequest doubtRequest = new DoubtRequest();
        doubtRequest.setUser(user);
        doubtRequest.setQuery(query);
        doubtRequest.setTimestamp(LocalDateTime.now());
        
        doubtRequestRepository.save(doubtRequest);
        
        List<User> availableList = userRepository.findByUserTypeAndClassGradeAndLanguage(UserType.TUTOR, user.getClassGrade(), user.getLanguage());
        
        if(availableList.size() == 0) return "At the moment, no tutor is available. Our team will get back to you soon.";
        
		return "Successfully resolved the doubt.";
	}

	@Override
	public List<DoubtRequest> getDoubtHistory(User user) throws DoubtRequestException {
		// TODO Auto-generated method stub
//		List<DoubtRequest> doubtHistory = doubtRequestRepository.findByUserIdOrderByTimestampDesc(user.getId());
		
		
		
		return null;
	}

	
}

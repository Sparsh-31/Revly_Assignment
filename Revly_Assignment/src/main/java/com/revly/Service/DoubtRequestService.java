package com.revly.Service;

import com.revly.Entity.DoubtRequest;
import com.revly.Entity.User;
import com.revly.Exception.DoubtRequestException;

import java.util.List;

public interface DoubtRequestService {

    String createDoubtRequest(User user, String query) throws DoubtRequestException;

    List<DoubtRequest> getDoubtHistory(User user) throws DoubtRequestException;

}

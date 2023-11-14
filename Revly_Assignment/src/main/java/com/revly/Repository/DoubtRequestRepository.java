package com.revly.Repository;

import com.revly.Entity.DoubtRequest;
import com.revly.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DoubtRequestRepository extends JpaRepository<DoubtRequest, Long> {

//	List<DoubtRequest> findByUserIdOrderByTimestampDesc(Long userId);    
    
}

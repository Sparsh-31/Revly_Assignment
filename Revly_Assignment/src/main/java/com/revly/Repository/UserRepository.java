package com.revly.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revly.Entity.User;
import com.revly.Entity.UserType;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    List<User> findByUserType(UserType userType);

    List<User> findByUserTypeAndClassGradeAndLanguage(UserType userType, int classGrade, String language);

    
}
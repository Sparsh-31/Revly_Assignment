package com.revly.Entity;

import com.revly.Entity.UserType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	
	 @Column(name = "username", unique = true, nullable = false)
	 private String username;
	
	 @Column(name = "password", nullable = false)
	 private String password;
	
	 @Enumerated(EnumType.STRING)
	 @Column(name = "user_type", nullable = false)
	 private UserType userType;
	
	 @Column(name = "class_grade")
	 private Integer classGrade;
	
	 @Column(name = "language")
	 private String language;
	
	 

 
}

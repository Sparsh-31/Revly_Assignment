package com.revly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Day15Problem1Application {

	public static void main(String[] args) {
		SpringApplication.run(Day15Problem1Application.class, args);
		
	}
	
	@Bean
	public PasswordEncoder paswoEncoder() {
		return new BCryptPasswordEncoder();
	}

}

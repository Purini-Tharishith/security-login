package com.example.login;

import com.example.login.entities.Role;
import com.example.login.entities.User;
import com.example.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class LoginApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
	}

	public  void run(String... args){
		User adminAccount = userRepository.findByRole(Role.ADMIN);
		if(adminAccount == null){
			User user = new User();

			user.setEmail("admin@gmail.com");
			user.setFirstname("DEFAULT");
			user.setLastname("ADMIN");
			user.setRole(Role.ADMIN);
			user.setPassword( new BCryptPasswordEncoder().encode("ADMIN"));
			userRepository.save(user);
		}
	}
}

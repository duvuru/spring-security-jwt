package com.ragainfotech;

import com.ragainfotech.entity.User;
import com.ragainfotech.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringSecurityJwtApplication {

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void initUsers(){
		List<User> users = Stream.of(
				new User(100,"admin","admin","admin@test.com"),
				new User(101,"user1","pwd1","user1@test.com"),
				new User(102,"user2","pwd2","user2@test.com"),
				new User(103,"user3","pwd3","user3@test.com"),
				new User(104,"user4","pwd4","user4@test.com")
		).collect(Collectors.toList());
		userRepository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}

}

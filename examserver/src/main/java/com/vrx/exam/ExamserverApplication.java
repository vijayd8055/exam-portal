package com.vrx.exam;

import com.vrx.exam.model.Role;
import com.vrx.exam.model.User;
import com.vrx.exam.model.UserRole;
import com.vrx.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		System.out.println("starting code");

//		User user = new User();
//
//		user.setFirstName("Vijay");
//		user.setLastName("Kumar");
//		user.setUsername("vihku7");
//		user.setPassword("abc");
//		user.setEmail("abc@abc.com");
//		user.setProfile("default.png");
//
//		Role role = new Role();
//		role.setRoleId(44L);
//		role.setRoleName("ADMIN");
//
//		Set<UserRole> userRoleSet = new HashSet<>();
//		UserRole userRole = new UserRole();
//		userRole.setRole(role);
//		userRoleSet.add(userRole);
//
//		user.setUserRoles(userRoleSet);
//
//		User user1 = userService.createUser(user, userRoleSet);
//		System.out.println(user1.getUsername());
	}
}

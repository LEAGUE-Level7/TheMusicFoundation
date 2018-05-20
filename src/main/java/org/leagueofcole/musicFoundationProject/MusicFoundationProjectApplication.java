package org.leagueofcole.musicFoundationProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MusicFoundationProjectApplication {

	@Autowired
	DataLoader ld;
	
	public static void main(String[] args) {
		SpringApplication.run(MusicFoundationProjectApplication.class, args);
	}
}

//Eli: go here and finish it, start on Spring Validator
//https://hellokoding.com/registration-and-login-example-with-spring-security-spring-boot-spring-data-jpa-hsql-jsp/
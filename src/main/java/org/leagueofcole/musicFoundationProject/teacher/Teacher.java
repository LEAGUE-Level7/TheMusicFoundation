package org.leagueofcole.musicFoundationProject.teacher;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Teacher {
	@Id
	@GeneratedValue
	private Long id;
	private String userName;
	private String password;
	private String confirmPassword;
	private String registryCode;
	

	public Long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public String getRegistryCode() {
		return registryCode;
	}

	public Teacher(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
		this.confirmPassword=confirmPassword;
		this.registryCode=registryCode;
	}
	Teacher(){
		
	}
}
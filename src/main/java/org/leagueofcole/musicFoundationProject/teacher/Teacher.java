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

	public Long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public Teacher(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	Teacher(){
		
	}
}

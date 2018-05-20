package org.leagueofcole.musicFoundationProject.teacher;

import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "user")
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String userName;
	private String password;
	private String passwordConfirm;
	private Set<Role> roles;

	public Teacher(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	Teacher() {

	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void getUserName(String username) {
		this.userName = username;
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

	public void setPassword(String password) {
		this.password = password;
		this.confirmPassword=confirmPassword;
		this.registryCode=registryCode;
	}

	@Transient
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	@ManyToMany
	@JoinTable(name = "user_rle", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
package org.leagueofcole.musicFoundationProject.teacher;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.leagueofcole.musicFoundationProject.role.Role;

@Entity
@Table(name = "teacher")
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String userName;
	private String password;
	private String passwordConfirm;
@ManyToMany(fetch=FetchType.EAGER)
private Set<Role> roles;

	public Teacher(String userName, String password, String passwordConfirm) {
		super();
		this.userName = userName;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
	}
Teacher(){
	
}

/**
 * @return teacher id
 */
	public Long getId() {
		return id;
	}

/**
 * set new id for teacher
 * @param id
 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return teacher's username
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * set new username for teacher
	 * @param username
	 */
	public void getUserName(String username) {
		this.userName = username;
	}

	/**
	 * @return teacher's password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * set new password for teacher
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getRegistryCode() {
		return "";
	}

	@Transient
	/**
	 * @return teacher's confirmed password
	 */
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	/**
	 * set new confirmed password for teacher
	 * @param passwordConfirm
	 */
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	
	/**
	 * @return a set of all the teacher roles
	 */
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "teacher_role", joinColumns = @JoinColumn(name = "teacher_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * set new set of roles for teachers
	 * @param roles
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
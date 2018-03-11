package org.leagueofcole.musicFoundationProject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Room {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String type;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public Room(Long id, String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}
}

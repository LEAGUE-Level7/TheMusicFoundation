package org.leagueofcole.musicFoundationProject.rooms;

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

	public Room(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	Room(){
		
	}
}

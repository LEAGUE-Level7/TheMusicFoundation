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

	/**
	 * @return room id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return name of room
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return type of room
	 */
	public String getType() {
		return type;
	}

	/**
	 * creates new Room
	 * @param name
	 * @param type
	 */
	public Room(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	Room(){
		
	}
}

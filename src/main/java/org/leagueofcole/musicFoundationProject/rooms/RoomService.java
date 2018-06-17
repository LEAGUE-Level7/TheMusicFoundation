package org.leagueofcole.musicFoundationProject.rooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
	@Autowired
	RoomRepository roomRepo;
	
	/**
	 * @param name
	 * @return all rooms with name given by @param name
	 */
	public Room findByName(String name) {
		
		return roomRepo.findByName(name);
	}
	
	/**
	 * @return all rooms in the room repository
	 */
	public Iterable<Room> all() {
		return roomRepo.findAll();
	}
}
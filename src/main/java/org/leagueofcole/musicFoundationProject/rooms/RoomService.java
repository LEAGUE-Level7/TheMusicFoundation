package org.leagueofcole.musicFoundationProject.rooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
	@Autowired
	RoomRepository roomRepo;
	
	public Room findByName(String name) {
		
		return roomRepo.findByName(name);
	}
}
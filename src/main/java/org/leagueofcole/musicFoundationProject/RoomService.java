package org.leagueofcole.musicFoundationProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
	@Autowired
	RoomRepository roomRepo;
	
	public Room findByName(String name) {
		Room room = null;
		for (Room room_ : roomRepo.findAll()) {
			if (room_.getName().equals(name)) {
				room = room_;
			}
		}
		return room;
	}
}
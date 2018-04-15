package org.leagueofcole.musicFoundationProject.rooms;

import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room,Long>{
	public Room findByName(String name);
}

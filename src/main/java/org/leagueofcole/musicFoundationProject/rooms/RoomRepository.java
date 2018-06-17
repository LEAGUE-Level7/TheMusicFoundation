package org.leagueofcole.musicFoundationProject.rooms;

import org.springframework.data.repository.CrudRepository;

/**
 * room repository responsible for retrieving data from the database
 * @author league
 *
 */
public interface RoomRepository extends CrudRepository<Room,Long>{
	public Room findByName(String name);
}

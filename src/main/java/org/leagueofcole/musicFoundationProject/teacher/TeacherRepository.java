package org.leagueofcole.musicFoundationProject.teacher;

import org.springframework.data.repository.CrudRepository;

/**
 * teacher repository responsible for retrieving data from the database
 * @author league
 *
 */
public interface TeacherRepository extends CrudRepository<Teacher, Long>{
	Teacher findByUserName(String userName);
}

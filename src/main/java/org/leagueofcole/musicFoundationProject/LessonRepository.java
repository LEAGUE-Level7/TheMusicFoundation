package org.leagueofcole.musicFoundationProject;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.leagueofcole.musicFoundationProject.teacher.Teacher;
import org.leagueofcole.musicFoundationProject.Lesson;

public interface LessonRepository extends CrudRepository<Lesson , Long > {
	public List<Lesson> findByTeacher(Teacher optional);
}

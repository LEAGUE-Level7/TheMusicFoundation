package org.leagueofcole.musicFoundationProject.lesson;

import java.util.Calendar;
import java.util.List;

import org.leagueofcole.musicFoundationProject.NewLessonRequest;
import org.leagueofcole.musicFoundationProject.rooms.Room;
import org.leagueofcole.musicFoundationProject.teacher.Teacher;
import org.leagueofcole.musicFoundationProject.teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Handles anything needed to interact with lessons
 */
@Service
public class LessonService {
	@Autowired
	LessonRepository lessonRepo;
	@Autowired
	TeacherRepository teacherRepo;
	
	/**
	 * Finds a Lesson by its id.
	 * @param id Id of lesson to find
	 * @return the lesson corresponding the id passed in; null if not found
	 */
	public Lesson findById(Long id) {
		return lessonRepo.findById(id).orElse(null);
	}
	
	/**
	 * Finds all lessons owned by a specific teacher's id, will error if the
	 * teacher's id is invalid.
	 * @param id Id of teacher to find lessons owned by
	 * @return a list of all lessons owned by the teacher
	 */
	public List<Lesson> findByTeacherID(Long id){
		return lessonRepo.findByTeacher(teacherRepo.findById(id).get());
	}
	
	/**
	 * Creates a lesson according to a NewLessonRequest, errors
	 * if the fields are invalid.
	 * @param teacher Owner of lesson to be created
	 * @param room Room the lesson will be in
	 * @param newLesson Info about this lesson
	 * @return the lesson created
	 */
	public Lesson createLesson(Teacher teacher, Room room, NewLessonRequest newLesson) {
		int year   = Integer.parseInt(newLesson.getYear());
		int month  = Integer.parseInt(newLesson.getMonth());
		int day    = Integer.parseInt(newLesson.getDay());
		int hour   = Integer.parseInt(newLesson.getHour());
		int minute = Integer.parseInt(newLesson.getMinute());
		
		hour += (newLesson.getAmpm()).equals("PM") ? 12 : 0; 
		
		Calendar c = Calendar.getInstance();
		c.set(year, month, day, hour, minute);
		
		Long date  = c.getTime().getTime();
		long dur   = Long.parseLong(newLesson.getDuration());
		
		int numStu = 0/*Integer.parseInt(newLesson.getNumStudents())*/;
		
		Lesson l   = new Lesson(teacher, date, dur, room, numStu, newLesson.getType());
		lessonRepo.save(l);
		
		return l;
	}
	
	/**
	 * Updates a lesson according to the fields, may or may not work, 
	 * this method is never used and is thus untested currently.
	 * @param lessonId id of lesson to edit
	 * @param room Updated room for this lesson (could be the same)
	 * @param updatedLesson information to update
	 * @return updated lesson
	 */
	public Lesson editLesson(long lessonId, Room room, NewLessonRequest updatedLesson) {
		Lesson l = findById(lessonId);
		int year   = Integer.parseInt(updatedLesson.getYear());
		int month  = Integer.parseInt(updatedLesson.getMonth());
		int day    = Integer.parseInt(updatedLesson.getDay());
		int hour   = Integer.parseInt(updatedLesson.getHour());
		int minute = Integer.parseInt(updatedLesson.getMinute());
		
		hour += (updatedLesson.getAmpm()).equals("PM") ? 12 : 0; 
		
		Calendar c = Calendar.getInstance();
		c.set(year, month, day, hour, minute);
		
		Long date  = c.getTime().getTime();
		
		long dur   = Long.parseLong(updatedLesson.getDuration());
		int numStu = 0/*Integer.parseInt(newLesson.getNumStudents())*/;
		
		l.setDate(date);
		l.setDuration(dur);
		l.setNumStudents(numStu);
		l.setRoom(room);
		l.setType(updatedLesson.getType());
		
		lessonRepo.save(l);
		
		return l;
	}
	
	/**
	 * Gets all lessons
	 * @return Every lesson
	 */
	public Iterable<Lesson> all() {
		return lessonRepo.findAll();
	}
}

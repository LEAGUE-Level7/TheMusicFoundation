package org.leagueofcole.musicFoundationProject.lesson;

import java.util.Calendar;
import java.util.List;

import org.leagueofcole.musicFoundationProject.NewLessonRequest;
import org.leagueofcole.musicFoundationProject.rooms.Room;
import org.leagueofcole.musicFoundationProject.teacher.Teacher;
import org.leagueofcole.musicFoundationProject.teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {
	@Autowired
	LessonRepository lessonRepo;
	@Autowired
	TeacherRepository teacherRepo;
	public Lesson findById(Long id) {
		return lessonRepo.findById(id).orElse(null);
	}
	public List<Lesson> findByTeacherID(Long id){
		return lessonRepo.findByTeacher(teacherRepo.findById(id).get());
	}
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
	
	public Iterable<Lesson> all() {
		return lessonRepo.findAll();
	}
}

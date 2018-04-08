package org.leagueofcole.musicFoundationProject;

import java.util.Calendar;

import org.leagueofcole.musicFoundationProject.rooms.Room;
import org.leagueofcole.musicFoundationProject.teacher.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {
	@Autowired
	LessonRepository lessonRepo;
	
	public Lesson findById(Long id) {
		return lessonRepo.findById(id).get();
	}
	
	public Lesson createLesson(Teacher teacher, Room room, NewLessonRequest newLesson) {
		int year   = Integer.parseInt(newLesson.getYear());
		int month  = Integer.parseInt(newLesson.getMonth());
		int day    = Integer.parseInt(newLesson.getDay());
		int hour   = Integer.parseInt(newLesson.getHour());
		int minute = Integer.parseInt(newLesson.getMinute());
		hour      += (newLesson.getAmpm()).equals("PM") ? 12 : 0; 
		Calendar c = Calendar.getInstance();
		c.set(year, month, day, hour, minute);
		Long date  = c.getTime().getTime();
		long dur   = Long.parseLong(newLesson.getDuration());
		int numStu = 0/*Integer.parseInt(newLesson.getNumStudents())*/;
		Lesson l   = new Lesson(teacher, date, dur, room, numStu);
		lessonRepo.save(l);
		return l;
	}
}

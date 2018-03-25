package org.leagueofcole.musicFoundationProject;

import java.util.Calendar;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {
	@Autowired
	LessonRepository lessonRepo;
	
	public Lesson createLesson(Teacher teacher, Map<String, Object> newLesson) {
		int year   = Integer.parseInt((String) newLesson.get("year"));
		int month  = Integer.parseInt((String) newLesson.get("month"));
		int day    = Integer.parseInt((String) newLesson.get("day"));
		int hour   = Integer.parseInt((String) newLesson.get("hour"));
		int minute = Integer.parseInt((String) newLesson.get("minute"));
		hour      += ((String) newLesson.get("ampm")).equals("PM") ? 12 : 0; 
		Calendar c = Calendar.getInstance();
		c.set(year, month, day, hour, minute);
		Long date  = c.getTime().getTime();
		long dur   = Long.parseLong((String) newLesson.get("duration"));
		int numStu = 0/*Integer.parseInt((String) newLesson.get("numStudents"))*/;
		Lesson l   = new Lesson(teacher, date, dur, new Room("A", ""), numStu);
		lessonRepo.save(l);
		return l;
	}
}

package org.leagueofcole.musicFoundationProject;

import javax.annotation.PostConstruct;

import org.leagueofcole.musicFoundationProject.lesson.LessonRepository;
import org.leagueofcole.musicFoundationProject.rooms.Room;
import org.leagueofcole.musicFoundationProject.rooms.RoomRepository;
import org.leagueofcole.musicFoundationProject.teacher.Teacher;
import org.leagueofcole.musicFoundationProject.teacher.TeacherRepository;
import org.leagueofcole.musicFoundationProject.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataLoader {
	@SuppressWarnings("unused")
	private LessonRepository lessonRepo;
	@SuppressWarnings("unused")
	private RoomRepository roomRepo;
	@SuppressWarnings("unused")
	private TeacherRepository teacherRepo;
	private TeacherService teacherService;
	

	@Autowired
	public DataLoader(LessonRepository lessonRepo, RoomRepository roomRepo, TeacherRepository teacherRepo, TeacherService teacherService) {
		super();
		this.lessonRepo = lessonRepo;
		this.roomRepo = roomRepo;
		this.teacherRepo = teacherRepo;
		this.teacherService = teacherService;
	}
	@PostConstruct
	private void loadData() {
		teacherService.save(new Teacher("Ian","12345", "12345"));
		//lessonRepo.save(new Lesson(new Teacher("Ian","12345"), new Date(), new Time()));
//		Room a = new Room("A", "General");
//		roomRepo.save(a);
//		Teacher t = new Teacher("wow", "pwd");
//		teacherRepo.save(t);
		//lessonRepo.save(new Lesson(t, new Date(), new Time(new Date().getTime()), new Time(new Date().getTime() + (1000 * 60 * 30)), a, 1));
	}
}

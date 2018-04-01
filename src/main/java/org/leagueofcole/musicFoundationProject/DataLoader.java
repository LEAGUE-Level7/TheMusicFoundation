package org.leagueofcole.musicFoundationProject;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataLoader {
	private LessonRepository lessonRepo;
	private RoomRepository roomRepo;
	private TeacherRepository teacherRepo;

	@Autowired
	public DataLoader(LessonRepository lessonRepo, RoomRepository roomRepo, TeacherRepository teacherRepo) {
		super();
		this.lessonRepo = lessonRepo;
		this.roomRepo = roomRepo;
		this.teacherRepo = teacherRepo;
	}
	@PostConstruct
	private void loadData() {
		//lessonRepo.save(new Lesson(new Teacher("Ian","12345"), new Date(), new Time()));
		Room a = new Room("A", "General");
		roomRepo.save(a);
		Teacher t = new Teacher("wow", "pwd");
		teacherRepo.save(t);
		//lessonRepo.save(new Lesson(t, new Date(), new Time(new Date().getTime()), new Time(new Date().getTime() + (1000 * 60 * 30)), a, 1));
	}
}

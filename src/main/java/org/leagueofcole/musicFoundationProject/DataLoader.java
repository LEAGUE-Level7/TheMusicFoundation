package org.leagueofcole.musicFoundationProject;

import javax.annotation.PostConstruct;

import org.leagueofcole.musicFoundationProject.lesson.LessonRepository;
import org.leagueofcole.musicFoundationProject.role.Role;
import org.leagueofcole.musicFoundationProject.role.RoleRepository;
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
	private RoomRepository roomRepo;
	@SuppressWarnings("unused")
	private TeacherRepository teacherRepo;
	private TeacherService teacherService;
	
	private RoleRepository roleRepository;
	
	/**
	 * Initializes DataLoader automatically (thats what @Autowired does)
	 */
	@Autowired
	public DataLoader(LessonRepository lessonRepo, RoomRepository roomRepo, TeacherRepository teacherRepo, TeacherService teacherService, RoleRepository roleRepository) {
		super();
		this.lessonRepo = lessonRepo;
		this.roomRepo = roomRepo;
		this.teacherRepo = teacherRepo;
		this.teacherService = teacherService;
		this.roleRepository = roleRepository;
	}

	/**
	 * Loads data -- is called every time the application starts
	 */
	@PostConstruct
	private void loadData() {
		/*
		 * Creates a Teacher named Ian with password 12345 -- use this to log in
		 */
		teacherService.save(new Teacher("Ian","12345", "12345"));
		
		/*
		 * Creates two initial rooms
		 */
		Room a = new Room("A", "General");
		roomRepo.save(new Room("B", "General"));
		roomRepo.save(a);
		
		/*
		 * Creates user roles -- ADMIN and TEACHER
		 */
		roleRepository.save(new Role("ADMIN"));
		roleRepository.save(new Role("TEACHER"));
	}
}

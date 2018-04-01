package org.leagueofcole.musicFoundationProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
	@Autowired
	TeacherRepository teacherRepo;
	
	public Teacher findByUserName(String name) {
		Teacher teacher = null;
		for (Teacher teacher_ : teacherRepo.findAll()) {
			if (teacher_.getUserName().equals(name)) {
				teacher = teacher_;
			}
		}
		return teacher;
	}
}
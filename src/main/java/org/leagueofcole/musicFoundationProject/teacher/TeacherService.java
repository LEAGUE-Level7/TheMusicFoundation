package org.leagueofcole.musicFoundationProject.teacher;

import java.util.HashSet;

import org.leagueofcole.musicFoundationProject.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class TeacherService {
	@Autowired
	TeacherRepository teacherRepo;
	
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * saves a new teacher to the teacher repository
     * @param teacher
     */
    public void save(Teacher teacher) {
        teacher.setPassword(bCryptPasswordEncoder.encode(teacher.getPassword()));
        teacher.setRoles(new HashSet<>(roleRepository.findAll()));
        teacherRepository.save(teacher);
    }

	/**
	 * 
	 * @param name
	 * @return all teachers with username given by @param name
	 */
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
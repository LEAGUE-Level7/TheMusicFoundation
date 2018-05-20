package org.leagueofcole.musicFoundationProject.service;

<<<<<<< HEAD:src/main/java/org/leagueofcole/musicFoundationProject/service/TeacherServiceImpl.java
import org.leagueofcole.musicFoundationProject.teacher.RoleRepository;
import org.leagueofcole.musicFoundationProject.teacher.Teacher;
import org.leagueofcole.musicFoundationProject.teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
=======
>>>>>>> LeaguePelicans/master:src/main/java/org/leagueofcole/musicFoundationProject/service/UserServiceImpl.java
import org.springframework.stereotype.Service;

@Service
<<<<<<< HEAD:src/main/java/org/leagueofcole/musicFoundationProject/service/TeacherServiceImpl.java
public class TeacherServiceImpl {
    @Autowired
    private TeacherRepository teacherRepository;
=======
public class UserServiceImpl /* implements UserService */ {
	/*
>>>>>>> LeaguePelicans/master:src/main/java/org/leagueofcole/musicFoundationProject/service/UserServiceImpl.java
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

<<<<<<< HEAD:src/main/java/org/leagueofcole/musicFoundationProject/service/TeacherServiceImpl.java
    public void save(Teacher teacher) {
        teacher.setPassword(bCryptPasswordEncoder.encode(teacher.getPassword()));
        teacher.setRoles(new HashSet<>(roleRepository.findAll()));
        teacherRepository.save(teacher);
    }

    public Teacher findByUsername(String username) {
        return teacherRepository.findByUserName(username);
    }
=======
    @Override
    public void save(Teacher user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.save(user);
    }

	@Override
	public Teacher findByUsername(String username) {
		return userService.findByUsername(username);
	}
	*/
>>>>>>> LeaguePelicans/master:src/main/java/org/leagueofcole/musicFoundationProject/service/UserServiceImpl.java
}
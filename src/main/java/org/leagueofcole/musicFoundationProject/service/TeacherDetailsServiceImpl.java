package org.leagueofcole.musicFoundationProject.service;

<<<<<<< HEAD:src/main/java/org/leagueofcole/musicFoundationProject/service/TeacherDetailsServiceImpl.java
import org.leagueofcole.musicFoundationProject.teacher.Role;
import org.leagueofcole.musicFoundationProject.teacher.Teacher;
import org.leagueofcole.musicFoundationProject.teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
=======
>>>>>>> LeaguePelicans/master:src/main/java/org/leagueofcole/musicFoundationProject/service/UserDetailsServiceImpl.java
import org.springframework.stereotype.Service;

@Service
<<<<<<< HEAD:src/main/java/org/leagueofcole/musicFoundationProject/service/TeacherDetailsServiceImpl.java
public class TeacherDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private TeacherRepository teacherRepository;
=======
public class UserDetailsServiceImpl /*implements UserDetailsService*/ {
	/*
    @Autowired
    private UserService userService;
>>>>>>> LeaguePelicans/master:src/main/java/org/leagueofcole/musicFoundationProject/service/UserDetailsServiceImpl.java

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
<<<<<<< HEAD:src/main/java/org/leagueofcole/musicFoundationProject/service/TeacherDetailsServiceImpl.java
        Teacher teacher = teacherRepository.findByUserName(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : teacher.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
=======
        Teacher user = userService.findByUsername(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        //for (Role role : user.getRoles()){
        //    grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        //}
>>>>>>> LeaguePelicans/master:src/main/java/org/leagueofcole/musicFoundationProject/service/UserDetailsServiceImpl.java

        return new org.springframework.security.core.userdetails.User(teacher.getUserName(), teacher.getPassword(), grantedAuthorities);
    }
    */
}
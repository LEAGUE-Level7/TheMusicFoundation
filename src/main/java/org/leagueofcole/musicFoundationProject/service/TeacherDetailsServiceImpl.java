package org.leagueofcole.musicFoundationProject.service;

import org.leagueofcole.musicFoundationProject.teacher.Role;
import org.leagueofcole.musicFoundationProject.teacher.Teacher;
import org.leagueofcole.musicFoundationProject.teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TeacherDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private TeacherRepository teacherRepository;

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}
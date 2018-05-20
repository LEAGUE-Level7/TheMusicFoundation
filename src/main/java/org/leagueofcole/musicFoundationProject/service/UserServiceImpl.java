package org.leagueofcole.musicFoundationProject.service;

import org.leagueofcole.musicFoundationProject.teacher.RoleRepository;
import org.leagueofcole.musicFoundationProject.teacher.Teacher;
import org.leagueofcole.musicFoundationProject.teacher.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Teacher user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public Teacher findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
package org.leagueofcole.musicFoundationProject.service;

import org.leagueofcole.musicFoundationProject.teacher.Teacher;

public interface UserService {
    void save(Teacher user);

    Teacher findByUsername(String username);
}
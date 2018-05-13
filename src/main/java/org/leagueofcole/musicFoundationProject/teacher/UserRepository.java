package org.leagueofcole.musicFoundationProject.teacher;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Teacher, Long> {
    Teacher findByUsername(String username);
}
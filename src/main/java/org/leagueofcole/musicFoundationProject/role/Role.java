package org.leagueofcole.musicFoundationProject.role;


import javax.persistence.*;

import org.leagueofcole.musicFoundationProject.teacher.Teacher;

import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
    private Long id;
    private String name;
    @ElementCollection(targetClass=Teacher.class)
    private Set<Teacher> teachers;

    Role(){
    	
    
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "roles")
    public Set<Teacher> getUsers() {
        return teachers;
    }

    public void setUsers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
}

package org.leagueofcole.musicFoundationProject;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Lesson {
	@Id
	@GeneratedValue
	private Long id;
	private Teacher teacher;
	private Date date;
	private Time startTime;
	private Time endTime;
	private Room room;
	private int numStudents;

	public Long getId() {
		return id;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public Date getDate() {
		return date;
	}

	public Time getStartTime() {
		return startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public Room getRoom() {
		return room;
	}

	public int getNumStudents() {
		return numStudents;
	}

	public Lesson(Long id, Teacher teacher, Date date, Time startTime, Time endTime, Room room, int numStudents) {
		super();
		this.id = id;
		this.teacher = teacher;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.room = room;
		this.numStudents = numStudents;
	}
}

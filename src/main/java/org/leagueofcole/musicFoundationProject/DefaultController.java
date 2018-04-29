package org.leagueofcole.musicFoundationProject;

import org.leagueofcole.musicFoundationProject.rooms.RoomService;
import org.leagueofcole.musicFoundationProject.teacher.Teacher;
import org.leagueofcole.musicFoundationProject.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DefaultController {

	@Autowired
	LessonService lessonService;
	
	@Autowired
	RoomService roomService;
	
	@Autowired
	TeacherService teacherService;
	
	@GetMapping(path = "/login")
	public String login() {
		return "login";
	}
	
	@GetMapping(path = "/register")
	public String register() {
		return "register";
	}
	
	@GetMapping(path = "/lessons")
	public String calendar(Model model) {
		model.addAttribute("lessons", lessonService.all());
		return "calendar";
	}

	@GetMapping(path = "/")
	public String homepage() {
		return "homepage";
	}
	@GetMapping(path = "/lessons/view/{id}")
	public String view(@PathVariable Long id, Model model) {
		model.addAttribute("lesson", lessonService.findById(id));
		return "view";
	}
	@GetMapping(path = "/lessons/new")
	public String _new(Model model) {
		model.addAttribute("rooms", roomService.all());
		return "new";
	}
	
	@GetMapping(path="/lessons/all")
	@ResponseBody
	public Iterable<Lesson> all() {
		return lessonService.all();
	}
	
	@GetMapping(path = "/lessons/create")
	public String __new(@ModelAttribute NewLessonRequest newLesson, Model model) {
		Lesson l = lessonService.createLesson(teacherService.findByUserName("wow"), roomService.findByName(newLesson.getRoom()), newLesson);
		model.addAttribute("lesson", l);
		return "view";
	}
	@GetMapping(path = "/teachers/create")
	public String __new(@ModelAttribute Teacher newTeacher, Model model) {
		model.addAttribute("teacher", newTeacher);
		return "homepage";
	}
}

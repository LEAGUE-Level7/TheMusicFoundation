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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

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

	@GetMapping(path = "/lessons")
	public String calendar() {
		return "calendar";
	}

	// @GetMapping(path = "/")
	// public String login() {
	// return "login";
	// }
	@GetMapping(path = "/")
	public String homepage() {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		try {
			String json = ow.writeValueAsString(new Teacher("Emp palp", "rebel scum"));
			System.out.println(json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "homepage";
	}

	@GetMapping(path = "/lessons/view/{id}")
	public String view(@PathVariable Long id, Model model) {
		for (Lesson l : lessonService.all()) {
			System.out.printf("Id: %d%n", l.getId());
		}
		// System.out.printf("This: %d%n", lessonService.findById(id) != null ?
		// lessonService.findById(id).getId() : -1);
		model.addAttribute("lesson", lessonService.findById(id));
		return "view";

		// return "calendar";
	}

	@GetMapping(path = "/lessons/new")
	public String _new() {
		return "new";
	}

	@GetMapping(path = "/lessons/create")
	public String __new(@ModelAttribute NewLessonRequest newLesson, Model model) {
		Lesson l = lessonService.createLesson(teacherService.findByUserName("wow"), roomService.findByName("A"),
				newLesson);
		model.addAttribute("lesson", l);
		return "view";
	}
}

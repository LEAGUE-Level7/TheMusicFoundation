package org.leagueofcole.musicFoundationProject;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class DefaultController {

	@Autowired
	LessonService lessonService;
	
	@GetMapping(path = "/lessons")
	public String calendar() {
		return "calendar";
	}
//	@GetMapping(path = "/")
//	public String login() {
//		return "login";
//	}
	@GetMapping(path = "/")
	public String homepage() {
		return "homepage";
	}
	@GetMapping(path = "/lessons/view")
	public String view() {
		return "view";
	}
	@GetMapping(path = "/lessons/new")
	public String _new() {
		return "new";
	}
	@PostMapping(path = "/lessons/new")
	public String __new() {
		//System.out.println(newLesson);
		//lessonService.createLesson(new Teacher("u1", "pwd"), newLesson);
		return "/lessons/view";
	}
}

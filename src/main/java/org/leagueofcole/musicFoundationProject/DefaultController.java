package org.leagueofcole.musicFoundationProject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

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
}

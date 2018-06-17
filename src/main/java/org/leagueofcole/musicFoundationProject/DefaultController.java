package org.leagueofcole.musicFoundationProject;

import org.leagueofcole.musicFoundationProject.lesson.Lesson;
import org.leagueofcole.musicFoundationProject.lesson.LessonService;
import org.leagueofcole.musicFoundationProject.rooms.RoomService;
import org.leagueofcole.musicFoundationProject.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles every request to the server
 */
@Controller
public class DefaultController {

	@Autowired
	LessonService lessonService;

	@Autowired
	RoomService roomService;

	@Autowired
	TeacherService teacherService;

	/**
	 * Maps path /lessons to the calendar. This path requires all lessons,
	 * which are passed in through the model to calendar.html
	 * @param model Object that allows for bindings with the thymeleaf file
	 * @return "calendar" -- tells java to render calendar.html
	 */
	@GetMapping(path = "/lessons")
	public String calendar(Model model) {
		model.addAttribute("lessons", lessonService.all());
		return "calendar";
	}

	/**
	 * Maps path / to the homepage.
	 * @return "homepage" -- tells java to render homepage.html
	 */
	@GetMapping(path = "/")
	public String homepage() {
		return "homepage";
	}

	/**
	 * Maps path /lessons/view/{id} to the view page. It renders the lesson information.
	 * I.e. /lessons/view/1 will render the view page and say id: 1, while
	 * /lessons/view/2 will render the view page and say id: 2, by passing in the lesson
	 * information obtained via the path parameter.
	 * @param id Id of the lesson, is found via the path being accessed
	 * @param model Object that allows for bindings with the thymeleaf file
	 * @return "view" -- tells java to render view.html
	 */
	@GetMapping(path = "/lessons/view/{id}")
	public String view(@PathVariable Long id, Model model) {
		model.addAttribute("lesson", lessonService.findByTeacherID(id));
		return "view";
	}

	/**
	 * Maps path /lessons/new to show the new lesson page. Will probably have to
	 * be updated to take in the list of lessons, so that the form can validate 
	 * whether the lesson to be created overlaps with an existing one. Needs
	 * to know the rooms because lessons must be created with a specific room.
	 * @param model Object that allows for bindings with the thymeleaf file
	 * @return "new" -- tells java to render new.html
	 */
	@GetMapping(path = "/lessons/new")
	public String _new(Model model) {
		model.addAttribute("rooms", roomService.all());
		return "new";
	}
	
	/**
	 * Maps the path /lessons/all to the JSON data associated with every 
	 * lesson. Run the application and go to this path to see the specific format, 
	 * as it directly reflects the underlying structure of the lesson
	 * object, which could change in the future.
	 * @return All lessons -- is automatically converted to JSON
	 */
	@GetMapping(path="/lessons/all")
	@ResponseBody
	public Iterable<Lesson> all() {
		return lessonService.all();
	}
	
	/**
	 * Method that maps /lessons/create to show the new lesson after saving
	 * it to the database. Spring captures the path query in the 
	 * newLesson object, which is passed to the service to save the
	 * lesson, and then the lesson is bound to the model and view is 
	 * rendered.
	 * @param newLesson Parameters passed from the client that are used to build the
	 * 					new lesson
	 * @param model Object that allows for bindings with the thymeleaf file
	 * @return "view" -- tells java to render view.html
	 */
	@GetMapping(path = "/lessons/create")
	public String __new(@ModelAttribute NewLessonRequest newLesson, Model model) {
		Lesson l = lessonService.createLesson(teacherService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName()), roomService.findByName(newLesson.getRoom()), newLesson);
		model.addAttribute("lesson", l);
		return "view";
	}
	
		
}

package org.leagueofcole.musicFoundationProject.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TeacherController {
    // @Autowired
    // private TeacherService teacherService;

	// @Autowired
	// private SecurityService securityService;

	// @Autowired
	// private TeacherValidator teacherValidator;

    /**
     * 
     * @param model
     * @return directs user to the registration page
     */
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new Teacher());
        System.out.println("registration requested");
        return "registration";
    }

//    @RequestMapping(value = "/registration", method = RequestMethod.POST)
//    public String registration(@ModelAttribute("userForm") Teacher userForm, BindingResult bindingResult, Model model) {
//        teacherValidator.validate(userForm, bindingResult);
//
//        if (bindingResult.hasErrors()) {
//            return "registration";
//        }
//
//       // teacherService.save(userForm);
//
//        securityService.autologin(userForm.getUserName(), userForm.getPasswordConfirm());
//
//        return "redirect:/login";
//    }

    /**
     * 
     * @param model
     * @param error
     * @param logout
     * @return directs user to the login page if there are no errors with username and password
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

//    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
//    public String welcome(Model model) {
//        return "welcome";
//    }
}

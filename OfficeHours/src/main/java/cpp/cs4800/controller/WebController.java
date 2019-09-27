package cpp.cs4800.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

	@SuppressWarnings("static-access")
	@RequestMapping(value = "/model", method = RequestMethod.GET)
	public ModelAndView showMessage() {
		ModelAndView mv = new ModelAndView("model");
		mv.addObject("departments", ModelController.getInstance().listDepartments());
		mv.addObject("faculties", ModelController.getInstance().listFaculties());
		mv.addObject("officeHours", ModelController.getInstance().listOfficeHours());
		mv.addObject("courses", ModelController.getInstance().listCourses());
		mv.addObject("sections", ModelController.getInstance().listSections());
		return mv;
	}
	
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView show() {
		ModelAndView mv = new ModelAndView("test");
		mv.addObject("departments", ModelController.getInstance().listDepartments());
		mv.addObject("faculties", ModelController.getInstance().listFaculties());
		mv.addObject("officeHours", ModelController.getInstance().listOfficeHours());
		mv.addObject("courses", ModelController.getInstance().listCourses());
		mv.addObject("sections", ModelController.getInstance().listSections());
		return mv;
	}


	@RequestMapping(value = "/OfficeHours/hi", method = RequestMethod.GET)
	String health1Check() {
		// You can replace this with other string,
		// and run the application locally to check your changes
		// with the URL: http://localhost:8080/
		return "hell";
	}
	
	@RequestMapping(value = "/OfficeHours/ping", method = RequestMethod.GET)
	public ModelAndView healthCheck() {
		ModelAndView mv = new ModelAndView("model");
		mv.addObject("Welcome", ModelController.getInstance().getWelcomeMessage());
		return mv;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("departments", ModelController.getInstance().listDepartments());
		mv.addObject("faculties", ModelController.getInstance().listFaculties());
		mv.addObject("officeHours", ModelController.getInstance().listOfficeHours());
		mv.addObject("courses", ModelController.getInstance().listCourses());
		mv.addObject("sections", ModelController.getInstance().listSections());
		return mv;
	}
	
	
}

package cpp.cs4800.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

	@SuppressWarnings("static-access")
	@RequestMapping(value = "/model", method = RequestMethod.POST)
	public ModelAndView showMessage() {
		ModelAndView mv = new ModelAndView("model");
		mv.addObject("departments", ModelController.getInstance().listDepartments());
		mv.addObject("faculties", ModelController.getInstance().listFaculties());
		mv.addObject("officeHours", ModelController.getInstance().listOfficeHours());
		mv.addObject("courses", ModelController.getInstance().listCourses());
		mv.addObject("sections", ModelController.getInstance().listSections());
		return mv;
	}

}

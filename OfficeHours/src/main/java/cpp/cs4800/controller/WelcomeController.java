package cpp.cs4800.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	@SuppressWarnings("static-access")
	@RequestMapping(value = "/welcome", method = RequestMethod.POST)
	public ModelAndView showMessage() {
		ModelAndView mv = new ModelAndView("welcome");
		mv.addObject("departments", ModelController.getInstance().listDepartments());
		return mv;
	}

}

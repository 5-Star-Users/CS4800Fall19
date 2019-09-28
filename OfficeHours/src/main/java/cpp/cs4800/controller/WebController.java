package cpp.cs4800.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cpp.cs4800.model.Faculty;

@Controller
public class WebController {

	/**
	 * Users request for the search page
	 * 
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String showSearch() {
		return "search";
	}

	/**
	 * Users search for Office Hours
	 * 
	 * @param request
	 * @param response
	 * @return results
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView processSearch(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("search");
		/**
		 * User ModelController to access database for searching criteria
		 */
		mv.addObject("message", "Test Post method");
		return mv;
	}

	/**
	 * Faculties want to reset their passwords
	 * 
	 */
	@RequestMapping(value = "/reset", method = RequestMethod.GET)
	public String showResetPage() {
		return "reset";
	}

	/**
	 * Faculties request the login page
	 * 
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin() {
		return "login";
	}

	/**
	 * Handle login process
	 * 
	 * @param request
	 * @param response
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView processLogin(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String passphrase = request.getParameter("passphrase");

		/*
		 * Handle updated OfficeHours
		 */
		if ((username == null) && (passphrase == null)) {
			ModelAndView postModels = new ModelAndView("edit");
			postModels.addObject("message", "Test Post method");
			return postModels;
		}

		/*
		 * Username && passphrase verification
		 */
		Faculty faculty = ModelController.getInstance().getFaculty(username, passphrase);
		if (faculty != null) {
			ModelAndView editModels = new ModelAndView("edit");
			editModels.addObject("faculty", faculty);
			return editModels;
		}

		/*
		 * Handle invalid validation
		 */
		ModelAndView loginModel = new ModelAndView("login");
		loginModel.addObject("error", "Invalid Username/Passphrase!");
		return loginModel;

	}

}

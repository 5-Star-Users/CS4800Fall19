package cpp.cs4800.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cpp.cs4800.model.Faculty;
import cpp.cs4800.model.OfficeHour;

@Controller
public class WebController {
	private Faculty latestFaculty = null;

	/**
	 * Default One Time Passphrase Length
	 */
	private static final int OTP_LENGTH = 20;

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
		Set<Faculty> faculties = ModelController.getInstance().listFaculty(request.getParameter("searchString"));

		if (faculties.isEmpty()) {
			mv.addObject("message", "Nothing is matched with your criteria!");
			return mv;
		}

		mv.addObject("faculties", faculties);
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
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/reset", method = RequestMethod.POST)
	public ModelAndView processReset(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = null;
		String otp = RandomStringUtils.random(OTP_LENGTH, true, true);

		Faculty faculty = ModelController.getInstance().updateFaculty(request.getParameter("username"), otp);

		if (faculty != null) {
			MailHelper.getInstance().send(faculty.getFirstName() + faculty.getLastName(), faculty.getEmailAddress(),
					otp);
			mv = new ModelAndView("login");
			mv.addObject("message", "Please check your email for a new passphrase: ");
			mv.addObject("email", faculty.getEmailAddress());
		} else {
			mv = new ModelAndView("reset");
			mv.addObject("error", "Your Bronco ID does not exist in this system!");
		}

		return mv;
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
		String newHours = request.getParameter("newHours");

		if (username != null && passphrase != null) {
			latestFaculty = ModelController.getInstance().getFaculty(username, passphrase);
		}
		/*
		 * Handle updated OfficeHours
		 */
		if ((username == null) && (passphrase == null)) {
			if (newHours.isEmpty()) {
				ModelAndView postModels = new ModelAndView("edit");
				postModels.addObject("message", "Test Post method");
				return postModels;
			}
			OfficeHour updatedHours = new OfficeHour(latestFaculty.getFacultyId(), newHours, null);
			ModelController.getInstance().updateOfficeHour(updatedHours);
			ModelAndView editModels = new ModelAndView("edit");
			editModels.addObject("faculty", ModelController.getInstance().getFaculty(latestFaculty.getFacultyId()));
			// ModelAndView postModels = new ModelAndView("edit");
			// postModels.addObject("message", "Test Post method");
			// return postModels;
			return editModels;
		}

		/*
		 * Username && passphrase verification
		 */
		if (latestFaculty != null) {
			ModelAndView editModels = new ModelAndView("edit");
			editModels.addObject("faculty", latestFaculty);
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

package cpp.cs4800.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {

	@RequestMapping(value = "errors", method = RequestMethod.GET)
	public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {

		ModelAndView errorPage = new ModelAndView("error");
		StringBuilder message = new StringBuilder("[5-Star-Users] CPP Office Hours: ");
		int httpErrorCode = getErrorCode(httpRequest);

		switch (httpErrorCode) {
		case 400: {
			message.append("Bad Request!");
			break;
		}
		case 401: {
			message.append("Unauthorized!");
			break;
		}
		case 404: {
			message.append("Resource not found!");
			break;
		}
		case 500: {
			message.append("Internal Server Error!");
			break;
		}
		default: {
			message.append("Undefined error!");
			break;
		}
		}
		errorPage.addObject("message", message);
		return errorPage;
	}

	private int getErrorCode(HttpServletRequest httpRequest) {
		return (Integer) httpRequest.getAttribute("javax.servlet.error.status_code");
	}
}

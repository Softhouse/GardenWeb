package se.softhouse.garden.web.publisher;

import java.io.IOException;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import se.softhouse.garden.orchid.spring.text.OrchidDirectoryMessageSource;

@Controller
public class ResourcesController {

	@Resource
	OrchidDirectoryMessageSource messageSource;

	@RequestMapping("/resources/**")
	@ResponseBody
	public String forward(HttpServletRequest request, HttpServletResponse response, Locale locale) throws NoSuchRequestHandlingMethodException, IOException {
		String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		String resources = this.messageSource.getMessage("resources.path", null, locale);
		response.sendRedirect(resources + path);
		return "OK";
	}
}

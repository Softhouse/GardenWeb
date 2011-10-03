package se.softhouse.garden.web.publisher;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import se.softhouse.garden.orchid.spring.text.OrchidDirectoryMessageSource;

@Controller
public class RefreshController {

	@Resource
	OrchidDirectoryMessageSource messageSource;

	@RequestMapping("/refresh")
	@ResponseBody
	public String page() throws NoSuchRequestHandlingMethodException {
		try {
			this.messageSource.reload();
		} catch (Throwable e) {
			StringWriter w = new StringWriter();
			e.printStackTrace(new PrintWriter(w));
			return w.toString();
		}
		return "Reloaded";
	}
}

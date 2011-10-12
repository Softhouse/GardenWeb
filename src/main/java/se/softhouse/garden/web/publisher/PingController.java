package se.softhouse.garden.web.publisher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

@Controller
public class PingController {

	@RequestMapping("/ping")
	@ResponseBody
	public String page() throws NoSuchRequestHandlingMethodException {
		return "Ping";
	}
}

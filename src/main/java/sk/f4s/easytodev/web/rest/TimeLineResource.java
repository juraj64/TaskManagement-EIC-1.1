package sk.f4s.easytodev.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sk.f4s.easytodev.tasks.domain.TimeLine;

/**
 * Implementation of TimeLineResource.
 */
@Controller
public class TimeLineResource extends TimeLineResourceBase {

	public TimeLineResource() {
	}

	@RequestMapping(value = "/timeLine/form", method = RequestMethod.GET)
	public String createForm(ModelMap modelMap) {
		TimeLine entity = new TimeLine();
		modelMap.addAttribute("entity", entity);
		return "timeLine/create";
	}

}

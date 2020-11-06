package sk.f4s.easytodev.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sk.f4s.easytodev.tasks.domain.Useer;

/**
 * Implementation of UseerResource.
 */
@Controller
public class UseerResource extends UseerResourceBase {

	public UseerResource() {
	}

	@RequestMapping(value = "/useer/form", method = RequestMethod.GET)
	public String createForm(ModelMap modelMap) {
		Useer entity = new Useer();
		modelMap.addAttribute("entity", entity);
		return "useer/create";
	}

}

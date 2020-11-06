package sk.f4s.easytodev.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sk.f4s.easytodev.tasks.domain.Communication;

/**
 * Implementation of CommunicationResource.
 */
@Controller
public class CommunicationResource extends CommunicationResourceBase {

	public CommunicationResource() {
	}

	@RequestMapping(value = "/communication/form", method = RequestMethod.GET)
	public String createForm(ModelMap modelMap) {
		Communication entity = new Communication();
		modelMap.addAttribute("entity", entity);
		return "communication/create";
	}

}

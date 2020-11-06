package sk.f4s.easytodev.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sk.f4s.easytodev.tasks.domain.Deployment;

/**
 * Implementation of DeploymentResource.
 */
@Controller
public class DeploymentResource extends DeploymentResourceBase {

	public DeploymentResource() {
	}

	@RequestMapping(value = "/deployment/form", method = RequestMethod.GET)
	public String createForm(ModelMap modelMap) {
		Deployment entity = new Deployment();
		modelMap.addAttribute("entity", entity);
		return "deployment/create";
	}

}

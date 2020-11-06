package sk.f4s.easytodev.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sk.f4s.easytodev.tasks.domain.Project;

import java.util.Date;

/**
 * Implementation of ProjectResource.
 */
@Controller
public class ProjectResource extends ProjectResourceBase {

	public ProjectResource() {
	}

	@RequestMapping(value = "/project/form", method = RequestMethod.GET)
	public String createForm(ModelMap modelMap) {
		Project entity = new Project();
		modelMap.addAttribute("entity", entity);
		return "project/create";
	}

	// Doplnena overwritnuta metoda pre vytvorenie noveho Projektu
	@RequestMapping(value = "/project", method = RequestMethod.POST)
	public String create(@RequestBody Project entity) {

		// nastavenie aktualneho casu
		Date launchDate = new Date();
		entity.setLaunchDate(launchDate);

		// nastavenie projektu pre jednotlive tasky
		entity.getTasks().forEach(task -> task.setProject(entity));

		return super.create(entity);
	}

}

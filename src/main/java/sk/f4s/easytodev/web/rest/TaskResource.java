package sk.f4s.easytodev.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sk.f4s.easytodev.tasks.domain.Project;
import sk.f4s.easytodev.tasks.domain.Task;
import sk.f4s.easytodev.tasks.serviceapi.ProjectService;

import java.util.Date;

/**
 * Implementation of TaskResource.
 */
@Controller
public class TaskResource extends TaskResourceBase {

	public TaskResource() {
	}

	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "/task/form", method = RequestMethod.GET)
	public String createForm(ModelMap modelMap) {
		Task entity = new Task();
		modelMap.addAttribute("entity", entity);
		return "task/create";
	}

	// Doplnena overwritnuta metoda pre vytvorenie noveho Tasku
	@RequestMapping(value = "/task", method = RequestMethod.POST)
	public String create(@RequestBody Task entity) {

		// nastavenie aktualneho casu
		Date originDate = new Date();
		entity.setOriginDate(originDate);

		// nacitanie projektu podla id
		Long projectID = entity.getProject().getId();
		if (projectID != null) {
			try {
				Project project = projectService.findById(serviceContext(), projectID);
				entity.setProject(project);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// nastavenie tasku pre jednotlive communications a timelines
		entity.getCommunications().forEach(communication -> communication.setTask(entity));
		entity.getTimeLines().forEach(timeLine -> timeLine.setTask(entity));

		return super.create(entity);
	}


}

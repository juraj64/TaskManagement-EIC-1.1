package sk.f4s.easytodev.web.rest;

import org.sculptor.framework.accessapi.ConditionalCriteria;
import org.sculptor.framework.accessapi.ConditionalCriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sk.f4s.easytodev.tasks.domain.*;
import sk.f4s.easytodev.tasks.serviceapi.DeploymentService;
import sk.f4s.easytodev.tasks.serviceapi.TaskService;

import java.util.Date;
import java.util.List;

/**
 * Implementation of ProjectResource.
 */
@Controller
public class ProjectResource extends ProjectResourceBase {

	public ProjectResource() {
	}

	@Autowired
	private DeploymentService deploymentService;
	@Autowired
	private ProjectRepository projectRepository;

	@RequestMapping(value = "/project/form", method = RequestMethod.GET)
	public String createForm(ModelMap modelMap) {
		Project entity = new Project();
		modelMap.addAttribute("entity", entity);
		return "project/create";
	}
	// formular pre pripad, ze project name uz existuje
	@RequestMapping(value = "/project/form/existingname", method = RequestMethod.GET)
	public String createFormExistingName(ModelMap modelMap) {
		Project entity = new Project();
		modelMap.addAttribute("entity", entity);
		return "project/createexistingname";
	}

	// Doplnena overwritnuta metoda pre vytvorenie noveho Projektu
	@RequestMapping(value = "/project", method = RequestMethod.POST)
	public String create(@RequestBody Project entity) {

		// kontrola, ci neexistuje projekt s navrhovanym menom
		String name = entity.getName();
		List<Project> projects = projectRepository.findAll();
		for(Project project : projects) {
			if(project.getName().equals(name)) {
				return "redirect:/rest/project/form/existingname";
			}
		}

		// nastavenie aktualneho casu
		Date launchDate = new Date();
		entity.setLaunchDate(launchDate);

		// pri prvom projekte, alebo ak este neexistuju, vytvor dva zakladne deploymenty
		List<Deployment> deployments = deploymentService.findAll(serviceContext());
		if(deployments.size() == 0) {

			Deployment dev = new Deployment();
			dev.setLabel("DEV --> TEST");
			dev.setEnvironment(Environment.DEV);
			dev.setDate(new Date());
			deploymentService.save(serviceContext(), dev);

			Deployment test = new Deployment();
			test.setLabel("TEST --> RUT");
			test.setEnvironment(Environment.TEST);
			test.setDate(new Date());
			deploymentService.save(serviceContext(), test);

		}

		// nastavenie projektu pre jednotlive tasky
		entity.getTasks().forEach(task -> task.setProject(entity));

		return super.create(entity);
	}

	//Doplnena overwritnuta metoda pre showAll (zoradenie podla casu od najnovsej)
	@RequestMapping(value = "/project", method = RequestMethod.GET) // url adresa
	public String showAll(ModelMap modelMap) {

		List<ConditionalCriteria> criteria = ConditionalCriteriaBuilder.criteriaFor(Project.class)
				.orderBy(ProjectProperties.createdDate()).descending().build();
		List<Project> result = projectRepository.findByCondition(criteria);

		modelMap.addAttribute("result", result);
		return "project/showlist";  // vrat prislusny jsp subor (showlist.jsp)
	}

}

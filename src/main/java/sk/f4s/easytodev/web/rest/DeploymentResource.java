package sk.f4s.easytodev.web.rest;

import org.sculptor.framework.accessapi.ConditionalCriteria;
import org.sculptor.framework.accessapi.ConditionalCriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sk.f4s.easytodev.tasks.domain.*;
import sk.f4s.easytodev.tasks.exception.TaskNotFoundException;
import sk.f4s.easytodev.tasks.serviceapi.DeploymentService;
import sk.f4s.easytodev.tasks.serviceapi.EndUserService;
import sk.f4s.easytodev.tasks.serviceapi.TaskService;

import java.util.Date;
import java.util.List;

/**
 * Implementation of DeploymentResource.
 */
@Controller
public class DeploymentResource extends DeploymentResourceBase {

	public DeploymentResource() {
	}

	@Autowired
	private EndUserService endUserService;
	@Autowired
	private DeploymentService deploymentService;
	@Autowired
	private DeploymentRepository deploymentRepository;
	@Autowired
	private TaskService taskService;

	@RequestMapping(value = "/deployment/form", method = RequestMethod.GET)
	public String createForm(ModelMap modelMap) {
		Deployment entity = new Deployment();
		modelMap.addAttribute("entity", entity);
		return "deployment/create";
	}

	// Doplnena overwritnuta metoda pre vytvorenie noveho Deploymentu
	@RequestMapping(value = "/deployment", method = RequestMethod.POST)
	public String create(@RequestBody Deployment entity) {

		// nastavenie aktualneho casu
		Date date = new Date(System.currentTimeMillis());
		entity.setDate(date);

		return super.create(entity);
	}

	// Zavolanie formulara pre addTask
	@RequestMapping(value = "/deployment/addtask/form", method = RequestMethod.GET) // url na zavolanie
	public String addTaskForm(ModelMap modelMap) {

		Task entity = new Task();  // Task lebo beriem vsetky fieldy z Tasku
		modelMap.addAttribute("entity", entity);
		return "deployment/addtask"; // jsp.file
	}

	// formular pre pripad, ze task name neexistuje
	@RequestMapping(value = "/deployment/addtask/form/notask", method = RequestMethod.GET) // url na zavolanie
	public String addTaskFormNoTask(ModelMap modelMap) {

		Task entity = new Task();  // Task lebo beriem vsetky fieldy z Tasku
		modelMap.addAttribute("entity", entity);
		return "deployment/addtasknotask"; // jsp.file
	}

	// formular pre pripad, ze user name neexistuje
	@RequestMapping(value = "/deployment/addtask/form/nouser", method = RequestMethod.GET) // url na zavolanie
	public String addTaskFormNoUser(ModelMap modelMap) {

		Task entity = new Task();  // Task lebo beriem vsetky fieldy z Tasku
		modelMap.addAttribute("entity", entity);
		return "deployment/addtasknouser"; // jsp.file
	}

	// formular pre pripad, ze zly environment
	@RequestMapping(value = "/deployment/addtask/form/wrongenvi", method = RequestMethod.GET) // url na zavolanie
	public String addTaskFormWrongEnvi(ModelMap modelMap) {

		Task entity = new Task();  // Task lebo beriem vsetky fieldy z Tasku
		modelMap.addAttribute("entity", entity);
		return "deployment/addtaskwrongenvi"; // jsp.file
	}

	// formular pre pripad, ze status nie je resolved
	@RequestMapping(value = "/deployment/addtask/form/wrongstatus", method = RequestMethod.GET) // url na zavolanie
	public String addTaskFormWrongStatus(ModelMap modelMap) {

		Task entity = new Task();  // Task lebo beriem vsetky fieldy z Tasku
		modelMap.addAttribute("entity", entity);
		return "deployment/addtaskwrongstatus"; // jsp.file
	}

	// Pridat jednotlive tasky do prislusneho Deploymentu podle environmentu
	// Riesenie pre metodu cez localhost - @ModelAttribute("entity")
	@RequestMapping(value = "/deployment/addtask", method = RequestMethod.POST)
	public String add(@ModelAttribute("entity") Task entity) throws TaskNotFoundException { // Task lebo beriem vsetky fieldy z Tasku

		String name = entity.getName();
		Long taskId = taskService.findIdByName(serviceContext(), name);
		if (taskId == 0) { // ak neexistuje
			return "redirect:/rest/deployment/addtask/form/notask";
		}

		// kontrola environmentu
		Task task = taskService.findById(serviceContext(), taskId);
		Environment placement = entity.getPlacement();
		if(!task.getPlacement().equals(placement)) {
			return "redirect:/rest/deployment/addtask/form/wrongenvi";
		}

		// kontrola statusu (resolved)
		if(!task.getStatus().equals(TaskStatus.Resolved)) {
			return "redirect:/rest/deployment/addtask/form/wrongstatus";
		}


		String personName = entity.getPersonName();
		Long personId = endUserService.findIdByName(serviceContext(), personName);
		if (personId == 0) { // ak neexistuje
			return "redirect:/rest/deployment/addtask/form/nouser";
		}

		deploymentService.addTask(serviceContext(), name, placement, personName);
		return "redirect:/rest/timeLine"; // url
	}

	// Zavolanie formulara pre toDeploy
	@RequestMapping(value = "/deployment/deploy/form", method = RequestMethod.GET) // url na zavolanie
	public String toDeployForm(ModelMap modelMap) {

		Deployment entity = new Deployment();
		modelMap.addAttribute("entity", entity);
		return "deployment/deploy"; // jsp.file
	}

	// formular pre pripad, ze pre dany environment neexistuje ziadna uloha na deployment
	@RequestMapping(value = "/deployment/deploy/form/notask", method = RequestMethod.GET) // url na zavolanie
	public String toDeployFormNoTask(ModelMap modelMap) {

		Deployment entity = new Deployment(); // Task lebo beriem vsetky fieldy z Tasku
		modelMap.addAttribute("entity", entity);
		return "deployment/deploynotask"; // jsp.file
	}

	// formular pre pripad, ze user name neexistuje
	@RequestMapping(value = "/deployment/deploy/form/nouser", method = RequestMethod.GET) // url na zavolanie
	public String toDeployFormNoUser(ModelMap modelMap) {

		Deployment entity = new Deployment();
		modelMap.addAttribute("entity", entity);
		return "deployment/deploynouser"; // jsp.file
	}

	// Samotny Deployment do noveho prostredia
	// Riesenie pre metodu cez localhost - @ModelAttribute("entity")
	@RequestMapping(value = "/deployment/deploy", method = RequestMethod.POST)
	public String deploy(@ModelAttribute("entity") Deployment entity)  {

		Environment environment = entity.getEnvironment();
		int numberOfTasks = deploymentService.findNumberAddedTasks(serviceContext(), environment);
		if (numberOfTasks == 0) {
			return "redirect:/rest/deployment/deploy/form/notask";
		}

		String personName = entity.getLabel(); // formalne potrebujem string
		Long personId = endUserService.findIdByName(serviceContext(), personName);
		if (personId == 0) { // ak neexistuje
			return "redirect:/rest/deployment/deploy/form/nouser";
		}

		deploymentService.toDeploy(serviceContext(), environment, personName);
		return "redirect:/rest/timeLine"; // url
	}


	// Pridat jednotlive tasky do prislusneho Deploymentu podle environmentu
	// Riesenie pre prikazy pomocou curl - @RequestBody
	@RequestMapping(value = "/deployment/addtaskcurl", method = RequestMethod.POST)
	public String addcurl(@RequestBody Task entity)  {

		String name = entity.getName();
		Environment placement = entity.getPlacement();
		String personName = entity.getPersonName();

		Deployment entityTwo = deploymentService.addTask(serviceContext(), name, placement, personName);

		return String.format("redirect:/rest/deployment/%s", entityTwo.getId()); // url, entity %s = id
	}

	// Samotny Deployment do noveho prostredia
	// Riesenie pre prikazy pomocou curl - @RequestBody
	@RequestMapping(value = "/deployment/deploycurl", method = RequestMethod.POST)
	public String deploycurl(@RequestBody Deployment entity)  {

		Environment environment = entity.getEnvironment();
		String personName = entity.getLabel(); // formalne potrebujem string

		deploymentService.toDeploy(serviceContext(), environment, personName);

		return String.format("redirect:/rest/deployment/%s", entity.getId()); // url, entity
	}

}

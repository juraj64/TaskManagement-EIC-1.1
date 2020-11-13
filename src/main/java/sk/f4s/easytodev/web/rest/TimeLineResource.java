package sk.f4s.easytodev.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sk.f4s.easytodev.tasks.domain.Communication;
import sk.f4s.easytodev.tasks.domain.EndUser;
import sk.f4s.easytodev.tasks.domain.Task;
import sk.f4s.easytodev.tasks.domain.TimeLine;

import sk.f4s.easytodev.tasks.serviceapi.EndUserService;
import sk.f4s.easytodev.tasks.serviceapi.TaskService;


import java.util.Date;

/**
 * Implementation of TimeLineResource.
 */
@Controller
public class TimeLineResource extends TimeLineResourceBase {

	public TimeLineResource() {
	}

	@Autowired
	private TaskService taskService;
	@Autowired
	private EndUserService endUserService;

	@RequestMapping(value = "/timeLine/form", method = RequestMethod.GET)
	public String createForm(ModelMap modelMap) {
		TimeLine entity = new TimeLine();
		modelMap.addAttribute("entity", entity);
		return "timeLine/create";
	}

	// Doplnena overwritnuta metoda pre vytvorenie novej timeLine
	@RequestMapping(value = "/timeline", method = RequestMethod.POST)
	public String create(@RequestBody TimeLine entity) {

		// nacitanie persony podla id
		Long personId = entity.getPerson().getId();
		if (personId != null) {
			try {
				EndUser person = endUserService.findById(serviceContext(), personId);
				entity.setPerson(person);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// nacitanie Tasku podla id
		Long taskId = entity.getTask().getId();
		if (taskId != null) {
			try {
				Task task = taskService.findById(serviceContext(), taskId);
				entity.setTask(task);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return super.create(entity);
	}

}

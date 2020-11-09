package sk.f4s.easytodev.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sk.f4s.easytodev.tasks.domain.Communication;
import sk.f4s.easytodev.tasks.domain.Project;
import sk.f4s.easytodev.tasks.domain.Task;
import sk.f4s.easytodev.tasks.domain.Useer;
import sk.f4s.easytodev.tasks.serviceapi.ProjectService;
import sk.f4s.easytodev.tasks.serviceapi.TaskService;
import sk.f4s.easytodev.tasks.serviceapi.UseerService;

import java.util.Date;

/**
 * Implementation of CommunicationResource.
 */
@Controller
public class CommunicationResource extends CommunicationResourceBase {

	public CommunicationResource() {
	}

	@Autowired
	private TaskService taskService;
	@Autowired
	private UseerService useerService;

	@RequestMapping(value = "/communication/form", method = RequestMethod.GET)
	public String createForm(ModelMap modelMap) {
		Communication entity = new Communication();
		modelMap.addAttribute("entity", entity);
		return "communication/create";
	}

	// Doplnena overwritnuta metoda pre vytvorenie novej Communication
	@RequestMapping(value = "/communication", method = RequestMethod.POST)
	public String create(@RequestBody Communication entity) {

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

		// nacitanie sendera podla id
		Long senderId = entity.getSender().getId();
		if (senderId != null) {
			try {
				Useer user = useerService.findById(serviceContext(), senderId);
				entity.setSender(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// nacitanie recipienta podla id
		Long recipientId = entity.getRecipient().getId();
		if (recipientId != null) {
			try {
				Useer user = useerService.findById(serviceContext(), recipientId);
				entity.setRecipient(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// nastavenie aktualneho casu
		Date date = new Date();
		entity.setDate(date);


		return super.create(entity);
	}

}

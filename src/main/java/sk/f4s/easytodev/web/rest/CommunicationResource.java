package sk.f4s.easytodev.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sk.f4s.easytodev.tasks.domain.Communication;
import sk.f4s.easytodev.tasks.domain.EndUser;
import sk.f4s.easytodev.tasks.domain.Project;
import sk.f4s.easytodev.tasks.domain.Task;

import sk.f4s.easytodev.tasks.serviceapi.CommunicationService;
import sk.f4s.easytodev.tasks.serviceapi.EndUserService;
import sk.f4s.easytodev.tasks.serviceapi.ProjectService;
import sk.f4s.easytodev.tasks.serviceapi.TaskService;


import java.util.Date;
import java.util.List;

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
	private EndUserService endUserService;
	@Autowired
	private CommunicationService communicationService;

	@RequestMapping(value = "/communication/form", method = RequestMethod.GET)
	public String createForm(ModelMap modelMap) {
		Communication entity = new Communication();
		modelMap.addAttribute("entity", entity);
		return "communication/create";
	}

	// Doplnena overwritnuta metoda pre vytvorenie novej Communication
	@RequestMapping(value = "/communication", method = RequestMethod.POST)
	public String create(@RequestBody Communication entity) {

		// nacitanie tasku podla taskId
		Long taskId = entity.getTaskId();
		if (taskId != null) {
			try {
				Task task = taskService.findById(serviceContext(), taskId);
				entity.setTask(task);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// nacitanie sendera podla name
		String senderName = entity.getSenderName();
		if (senderName != null) {
			try {
				EndUser sender = endUserService.findByName(serviceContext(), senderName);
				entity.setSender(sender);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// nacitanie recipienta podla name
		String recipientName = entity.getRecipientName();
		if (recipientName != null) {
			try {
				EndUser recipient = endUserService.findByName(serviceContext(), recipientName);
				entity.setRecipient(recipient);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// nastavenie aktualneho casu
		Date date = new Date(System.currentTimeMillis());
		entity.setDate(date);

		return super.create(entity);
	}

	//Doplnena overwritnuta metoda pre showAll (zoradenie podla casu komunikacie od najnovsej)
	@RequestMapping(value = "/communication", method = RequestMethod.GET)
	// value = "/communication je url stranka na localhoste, ktoru viem zavolat cez prislusny jsp
	public String showAll(ModelMap modelMap) {

		List<Communication> result = communicationService.orderByDateDesc(serviceContext());
		modelMap.addAttribute("result", result);
		return "communication/showlist";  // vrat prislusny jsp subor (showlist.jsp)
	}

	// Metoda pre orderByDateAsc (zoradenie podla casu komunikacie od najstarsej)
	// To iste ako showAll, ale casovo zoradena opacne
	@RequestMapping(value = "/communication/ascending", method = RequestMethod.GET)
	public String byDateAsc(ModelMap modelMap) {

		List<Communication> result = communicationService.orderByDateAsc(serviceContext());
		modelMap.addAttribute("result", result);
		return "communication/showlistascending";
	}

	// zobrazenie komunikacie podla vybrateho tasku na localhoste
	// zoradena podla casu zostupne (od najnovsej)
	@RequestMapping(value = "/communication/task/{id}", method = RequestMethod.GET)
	public String byTaskDesc(@PathVariable("id") Long id, ModelMap modelMap) {
		// id je cislo tasku, ktore chcem
		Task task = new Task();
		try {
			task = taskService.findById(serviceContext(), id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<Communication> result = communicationService.showByTaskDesc(serviceContext(), task);
		modelMap.addAttribute("result", result);
		return "communication/showtask";
	}

	// zobrazenie komunikacie podla vybrateho tasku na localhoste
	// zoradena podla casu vzostupne (od najstarsej)
	@RequestMapping(value = "/communication/task/ascending/{id}", method = RequestMethod.GET)
	public String byTaskAsc(@PathVariable("id") Long id, ModelMap modelMap) { // id je cislo tasku, ktore chcem
		Task task = new Task();
		try {
			task = taskService.findById(serviceContext(), id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<Communication> result = communicationService.showByTaskAsc(serviceContext(), task);
		modelMap.addAttribute("result", result);
		return "communication/showtask";
	}

	// zoradi vsetky komunikacie podla tasku abc a casu od najnovsej
	@RequestMapping(value = "/communication/order/bytask", method = RequestMethod.GET)  // url stranka na localhoste
	public String showAllByTask(ModelMap modelMap) {

		List<Communication> result = communicationService.orderByTask(serviceContext());
		modelMap.addAttribute("result", result);
		return "communication/showlist";  // vrat prislusny jsp subor (showlist.jsp)
	}

	// zoradi vsetky komunikacie podla tasku xyz a casu od najnovsej
	@RequestMapping(value = "/communication/order/bytask/descending", method = RequestMethod.GET)  // url stranka na localhoste
	public String showAllByTaskDesc(ModelMap modelMap) {

		List<Communication> result = communicationService.orderByTaskDesc(serviceContext());
		modelMap.addAttribute("result", result);
		return "communication/showlistascending";  // vrat prislusny jsp subor (showlist.jsp)
	}




	// len komunikacia podla vybrateho tasku.
	// Ak davam prikazy cez curl (pre tento pripad to vlastne nepotrebujem)
	@RequestMapping(value = "/communication/task", method = RequestMethod.POST)
	public String communicationsByTask(@RequestBody Communication entity) {

		Task task = new Task();
		// nacitanie tasku podla id
		Long taskId = entity.getTask().getId();
		if (taskId != null) {
			try {
				task = taskService.findById(serviceContext(), taskId);
				entity.setTask(task);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		communicationService.showByTaskDesc(serviceContext(), task);
		return String.format("redirect:/rest/task/%s", entity.getContent());
	}



}

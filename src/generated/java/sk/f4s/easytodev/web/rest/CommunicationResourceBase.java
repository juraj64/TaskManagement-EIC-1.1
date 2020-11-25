package sk.f4s.easytodev.web.rest;

import java.io.IOException;
import java.lang.Exception;
import java.lang.IllegalArgumentException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.sculptor.framework.context.ServiceContext;
import org.sculptor.framework.context.ServiceContextStore;
import org.sculptor.framework.errorhandling.OptimisticLockingException;
import org.sculptor.framework.errorhandling.SystemException;
import org.sculptor.framework.errorhandling.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sk.f4s.easytodev.tasks.domain.Communication;
import sk.f4s.easytodev.tasks.exception.CommunicationNotFoundException;
import sk.f4s.easytodev.tasks.exception.EndUserNotFoundException;
import sk.f4s.easytodev.tasks.exception.TaskNotFoundException;
import sk.f4s.easytodev.tasks.serviceapi.CommunicationService;

/**
 * Generated base class for implementation of CommunicationResource.
 * <p>
 * Make sure that subclass defines the following annotations:
 * 
 * <pre>
 * @org.springframework.stereotype.Controller
 * </pre>
 */
public abstract class CommunicationResourceBase {

	public CommunicationResourceBase() {
	}

	protected ServiceContext serviceContext() {
		return ServiceContextStore.get();
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
	}

	@Autowired
	private CommunicationService communicationService;

	protected CommunicationService getCommunicationService() {
		return communicationService;
	}

	@RequestMapping(value = "/communication/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") Long id, ModelMap modelMap) throws CommunicationNotFoundException {
		Communication result = communicationService.findById(serviceContext(), id);
		modelMap.addAttribute("result", result);
		return "communication/show";
	}

	@RequestMapping(value = "/communication", method = RequestMethod.GET)
	public String showAll(ModelMap modelMap) {
		List<Communication> result = communicationService.findAll(serviceContext());
		modelMap.addAttribute("result", result);
		return "communication/showlist";
	}

	@RequestMapping(value = "/communication", method = RequestMethod.POST)
	public String create(@RequestBody Communication entity) throws TaskNotFoundException, EndUserNotFoundException {
		Communication result = communicationService.save(serviceContext(), entity);
		return String.format("redirect:/rest/communication/%s", result.getId());
	}

	@RequestMapping(value = "/communication/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id) throws Exception {
		Communication deleteObj = communicationService.findById(serviceContext(), id);
		communicationService.delete(serviceContext(), deleteObj);
		return "redirect:/rest/communication";
	}

	/*
	 * @org.springframework.web.bind.annotation.RequestMapping(value = "/communication/form",
	 * method=org.springframework.web.bind.annotation.RequestMethod.GET) public String createForm(org.springframework.ui.ModelMap
	 * modelMap )
	 */
	public abstract String createForm(ModelMap modelMap);

	/**
	 * This method is needed for form data POST. Delegates to {@link #create}
	 */
	@RequestMapping(value = "/communication", method = RequestMethod.POST, headers = "content-type=application/x-www-form-urlencoded")
	public String createFromForm(@ModelAttribute("entity") Communication entity) throws EndUserNotFoundException, TaskNotFoundException {
		return create(entity);
	}

	@ExceptionHandler
	public void handleException(CommunicationNotFoundException e, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.NOT_FOUND.value(), e.getMessage());
	}

	@ExceptionHandler
	public void handleException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
	}

	@ExceptionHandler
	public void handleException(ValidationException e, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
	}

	@ExceptionHandler
	public void handleException(SystemException e, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.SERVICE_UNAVAILABLE.value(), e.getMessage());
	}

	@ExceptionHandler
	public void handleException(OptimisticLockingException e, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.CONFLICT.value(), e.getMessage());
	}

}

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
import sk.f4s.easytodev.tasks.domain.TimeLine;
import sk.f4s.easytodev.tasks.exception.TimeLineNotFoundException;
import sk.f4s.easytodev.tasks.serviceapi.TimeLineService;

/**
 * Generated base class for implementation of TimeLineResource.
 * <p>
 * Make sure that subclass defines the following annotations:
 * 
 * <pre>
 * @org.springframework.stereotype.Controller
 * </pre>
 */
public abstract class TimeLineResourceBase {

	public TimeLineResourceBase() {
	}

	protected ServiceContext serviceContext() {
		return ServiceContextStore.get();
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
	}

	@Autowired
	private TimeLineService timeLineService;

	protected TimeLineService getTimeLineService() {
		return timeLineService;
	}

	@RequestMapping(value = "/timeLine/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") Long id, ModelMap modelMap) throws TimeLineNotFoundException {
		TimeLine result = timeLineService.findById(serviceContext(), id);
		modelMap.addAttribute("result", result);
		return "timeLine/show";
	}

	@RequestMapping(value = "/timeLine", method = RequestMethod.GET)
	public String showAll(ModelMap modelMap) {
		List<TimeLine> result = timeLineService.findAll(serviceContext());
		modelMap.addAttribute("result", result);
		return "timeLine/showlist";
	}

	@RequestMapping(value = "/timeLine", method = RequestMethod.POST)
	public String create(@RequestBody TimeLine entity) {
		TimeLine result = timeLineService.save(serviceContext(), entity);
		return String.format("redirect:/rest/timeLine/%s", result.getId());
	}

	@RequestMapping(value = "/timeLine/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id) throws Exception {
		TimeLine deleteObj = timeLineService.findById(serviceContext(), id);
		timeLineService.delete(serviceContext(), deleteObj);
		return "redirect:/rest/timeLine";
	}

	/*
	 * @org.springframework.web.bind.annotation.RequestMapping(value = "/timeLine/form",
	 * method=org.springframework.web.bind.annotation.RequestMethod.GET) public String createForm(org.springframework.ui.ModelMap
	 * modelMap )
	 */
	public abstract String createForm(ModelMap modelMap);

	/**
	 * This method is needed for form data POST. Delegates to {@link #create}
	 */
	@RequestMapping(value = "/timeLine", method = RequestMethod.POST, headers = "content-type=application/x-www-form-urlencoded")
	public String createFromForm(@ModelAttribute("entity") TimeLine entity) {
		return create(entity);
	}

	@ExceptionHandler
	public void handleException(TimeLineNotFoundException e, HttpServletResponse response) throws IOException {
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

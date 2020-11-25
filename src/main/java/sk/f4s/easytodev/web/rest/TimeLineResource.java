package sk.f4s.easytodev.web.rest;

import org.sculptor.framework.accessapi.ConditionalCriteria;
import org.sculptor.framework.accessapi.ConditionalCriteriaBuilder;
import org.sculptor.framework.domain.PagedResult;
import org.sculptor.framework.domain.PagingParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import sk.f4s.easytodev.tasks.domain.*;

import sk.f4s.easytodev.tasks.exception.EndUserNotFoundException;
import sk.f4s.easytodev.tasks.serviceapi.EndUserService;
import sk.f4s.easytodev.tasks.serviceapi.TaskService;
import sk.f4s.easytodev.tasks.serviceapi.TimeLineService;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	@Autowired
	private TimeLineService timeLineService;
	@Autowired
	private TimeLineRepository timeLineRepository;

	@RequestMapping(value = "/timeLine/form", method = RequestMethod.GET)
	public String createForm(ModelMap modelMap) {
		TimeLine entity = new TimeLine();
		modelMap.addAttribute("entity", entity);
		return "timeLine/create";
	}

	//Doplnena overwritnuta metoda pre showAll (zoradenie podla casu timeline od najnovsej)
	@RequestMapping(value = "/timeLine", method = RequestMethod.GET)
	public String showAll(ModelMap modelMap) {

		List<ConditionalCriteria> criteria = ConditionalCriteriaBuilder.criteriaFor(TimeLine.class)
				.orderBy(TimeLineProperties.createdDate()).descending().build();
		List<TimeLine> result = timeLineRepository.findByCondition(criteria);

		modelMap.addAttribute("result", result);
		return "timeLine/showlist";  // vrat prislusny jsp subor (showlist.jsp)
	}
// Pokus o pagovanie. Zatial bez uspechu.
//	@RequestMapping(value = "/timeLine", method = RequestMethod.GET)
//	public String showAll(@RequestParam("pagingParameter") PagingParameter pagingParameter, ModelMap modelMap) {
//		//pagingParameter = PagingParameter.rowAccess(0, 10);
//		pagingParameter = PagingParameter.pageAccess(10, 1, true);
//		PagedResult<TimeLine> result = timeLineService.findAll(serviceContext(), pagingParameter);
//		modelMap.addAttribute("result", result);
//		return "timeLine/showlist";
//	}

	// To iste ako showAll, ale casovo zoradena opacne
	@RequestMapping(value = "/timeLine/ascending", method = RequestMethod.GET)
	public String showAllAscending(ModelMap modelMap) {

		List<ConditionalCriteria> criteria = ConditionalCriteriaBuilder.criteriaFor(TimeLine.class)
				.orderBy(TimeLineProperties.createdDate()).build();
		List<TimeLine> result = timeLineRepository.findByCondition(criteria);

		modelMap.addAttribute("result", result);
		return "timeLine/showlistascending";
	}

	// zoradi vsetky timeliny podla tasku abc a casu od najnovsej
	@RequestMapping(value = "/timeLine/order/bytask", method = RequestMethod.GET)  // url stranka na localhoste
	public String showAllByTask(ModelMap modelMap) {

		List<ConditionalCriteria> criteria = ConditionalCriteriaBuilder.criteriaFor(TimeLine.class)
				.orderBy(TimeLineProperties.task())
				.orderBy(TimeLineProperties.createdDate()).descending().build();
		List<TimeLine> result = timeLineRepository.findByCondition(criteria);

		modelMap.addAttribute("result", result);
		return "timeLine/showlist";  // vrat prislusny jsp subor (showlist.jsp)
	}

	// zoradi vsetky timeliny podla tasku xyz a casu od najnovsej
	@RequestMapping(value = "/timeLine/order/bytask/descending", method = RequestMethod.GET)  // url stranka na localhoste
	public String showAllByTaskDesc(ModelMap modelMap) {

		List<ConditionalCriteria> criteria = ConditionalCriteriaBuilder.criteriaFor(TimeLine.class)
				.orderBy(TimeLineProperties.task()).descending()
				.orderBy(TimeLineProperties.createdDate()).descending().build();
		List<TimeLine> result = timeLineRepository.findByCondition(criteria);

		modelMap.addAttribute("result", result);
		return "timeLine/showlistascending";  // vrat prislusny jsp subor (showlist.jsp)
	}

	// zobrazenie podla vybrateho tasku na localhoste
	// zoradena podla casu zostupne (od najnovsej)
	@RequestMapping(value = "/timeLine/task/{id}", method = RequestMethod.GET)
	public String byTaskDesc(@PathVariable("id") Long id, ModelMap modelMap) {
		// id je cislo tasku, ktore chcem
		Task task = new Task();
		try {
			task = taskService.findById(serviceContext(), id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<ConditionalCriteria> criteria = ConditionalCriteriaBuilder.criteriaFor(TimeLine.class)
				.withProperty(TimeLineProperties.task()).eq(task)
				.orderBy(TimeLineProperties.createdDate()).descending().build();
		List<TimeLine> result = timeLineRepository.findByCondition(criteria);

		modelMap.addAttribute("result", result);
		return "timeLine/showtask";
	}

	// zobrazenie podla vybrateho tasku na localhoste
	// zoradena podla casu vzostupne (od najstarsej)
	@RequestMapping(value = "/timeLine/task/ascending/{id}", method = RequestMethod.GET)
	public String byTaskAsc(@PathVariable("id") Long id, ModelMap modelMap) {
		// id je cislo tasku, ktore chcem
		Task task = new Task();
		try {
			task = taskService.findById(serviceContext(), id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<ConditionalCriteria> criteria = ConditionalCriteriaBuilder.criteriaFor(TimeLine.class)
				.withProperty(TimeLineProperties.task()).eq(task)
				.orderBy(TimeLineProperties.createdDate()).build();
		List<TimeLine> result = timeLineRepository.findByCondition(criteria);

		modelMap.addAttribute("result", result);
		return "timeLine/showtask";
	}

}

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
import sk.f4s.easytodev.tasks.exception.EndUserNotFoundException;
import sk.f4s.easytodev.tasks.exception.ProjectNotFoundException;
import sk.f4s.easytodev.tasks.serviceapi.EndUserService;
import sk.f4s.easytodev.tasks.serviceapi.ProjectService;
import sk.f4s.easytodev.tasks.serviceapi.TaskService;

import java.util.Date;
import java.util.List;

/**
 * Implementation of TaskResource.
 */
@Controller
public class TaskResource extends TaskResourceBase {

    public TaskResource() {
    }

    @Autowired
    private ProjectService projectService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private EndUserService endUserService;

    @RequestMapping(value = "/task/form", method = RequestMethod.GET)
    public String createForm(ModelMap modelMap) {
        Task entity = new Task();
        modelMap.addAttribute("entity", entity);
        return "task/create";
    }

    // formular pre pripad, ze task name uz existuje
    @RequestMapping(value = "/task/form/existingname", method = RequestMethod.GET)
    public String createFormExistingName(ModelMap modelMap) {
        Task entity = new Task();
        modelMap.addAttribute("entity", entity);
        return "task/createexistingname";
    }

    // formular pre pripad, ze project name neexistuje
    @RequestMapping(value = "/task/form/noproject", method = RequestMethod.GET)
    public String createFormNoProject(ModelMap modelMap) {
        Task entity = new Task();
        modelMap.addAttribute("entity", entity);
        return "task/createnoproject";
    }

    // formular pre pripad, ze user name neexistuje
    @RequestMapping(value = "/task/form/nouser", method = RequestMethod.GET)
    public String createFormNoUser(ModelMap modelMap) {
        Task entity = new Task();
        modelMap.addAttribute("entity", entity);
        return "task/createnouser";
    }

    // Doplnena overwritnuta metoda pre vytvorenie noveho Tasku
    @RequestMapping(value = "/task", method = RequestMethod.POST)
    public String create(@RequestBody Task entity) throws ProjectNotFoundException, EndUserNotFoundException {

        // kontrola, ci neexistuje task s navrhovanym menom
        // (zatial vsetky, teoreticky by mohli byt rovnake mena uloh, ak ide o rozne projekty)
        String name = entity.getName();
        List<Task> tasks = taskRepository.findAll();
        for(Task task : tasks) {
            if(task.getName().equals(name)) {
                return "redirect:/rest/task/form/existingname";
            }
        }

        // nastavenie aktualneho casu
        Date originDate = new Date();
        entity.setOriginDate(originDate);

        // nacitanie projektu podla name
        Project project;
        String projectName = entity.getProject().getName();
        Long projectId = projectService.findIdByName(serviceContext(), projectName);
        if (projectId != 0) {
            project = projectService.findById(serviceContext(), projectId);
            entity.setProject(project);
            entity.setProjectId(projectId);
        } else { // ak project s name neexistuje
            return "redirect:/rest/task/form/noproject";
        }

        // toto sa neda pouzit, lebo ak dam zly type, tak sa program do tehto metody ani nedostane
        Type type = entity.getTaskType();
        if (!type.equals(Type.NewFunction) && !type.equals(Type.ChangeRequest) && !type.equals(Type.Bug)
                && !type.equals(Type.Other)) {
            return "redirect:/rest/task/form/nouser"; // len na skusku, pozri tiez text vyssie
        }

        // pri vytvoreni noveho tasku nastavime status vzdy na Created a placement na DEV
        entity.setStatus(TaskStatus.Created);
        entity.setPlacement(Environment.DEV);

        // nacitanie person podla name
        EndUser person;
        String personName = entity.getPerson().getName();
        Long personId = endUserService.findIdByName(serviceContext(), personName);
        if (personId != 0) {
            person = endUserService.findById(serviceContext(), personId);
            entity.setPerson(person);
            entity.setPersonName(personName);
        } else { // ak person s name neexistuje
            return "redirect:/rest/task/form/nouser";
        }

        // vytvorenie uvodneho timeline
        TimeLine timeLine = new TimeLine();
        timeLine.setDate(new Date());
        timeLine.setLabel(entity.getStatus().getName() + " in DEV environment");
        timeLine.setPerson(entity.getPerson());
        timeLine.setPersonId(entity.getPerson().getId());
        timeLine.setTask(entity);
        entity.addTimeLine(timeLine);

        // nastavenie tasku pre jednotlive communications a timelines
        entity.getCommunications().forEach(communication -> communication.setTask(entity));
        entity.getTimeLines().forEach(line -> line.setTask(entity));

        return super.create(entity);
    }

    //Doplnena overwritnuta metoda pre showAll (zoradenie podla casu od najnovsej)
    @RequestMapping(value = "/task", method = RequestMethod.GET) // url adresa
    public String showAll(ModelMap modelMap) {

        List<ConditionalCriteria> criteria = ConditionalCriteriaBuilder.criteriaFor(Task.class)
                .orderBy(TaskProperties.createdDate()).descending().build();
        List<Task> result = taskRepository.findByCondition(criteria);

        modelMap.addAttribute("result", result);
        return "task/showlist";  // vrat prislusny jsp subor (showlist.jsp)
    }

    // Zavolanie formulara pre changeStatus
    @RequestMapping(value = "/task/changestatus/form", method = RequestMethod.GET) // url na zavolanie
    public String changeStatusForm(ModelMap modelMap) {

        Task entity = new Task();
        modelMap.addAttribute("entity", entity);
        return "task/changestatus"; // jsp.file
    }

    // formular pre pripad, ze user name neexistuje
    @RequestMapping(value = "/task/changestatus/form/nouser", method = RequestMethod.GET) // url na zavolanie
    public String changeStatusFormNoUser(ModelMap modelMap) {

        Task entity = new Task();
        modelMap.addAttribute("entity", entity);
        return "task/changestatusnouser"; // jsp.file
    }

    // formular pre pripad, ze task name neexistuje
    @RequestMapping(value = "/task/changestatus/form/notask", method = RequestMethod.GET) // url na zavolanie
    public String changeStatusFormNoTask(ModelMap modelMap) {

        Task entity = new Task();
        modelMap.addAttribute("entity", entity);
        return "task/changestatusnotask"; // jsp.file
    }

    // formular pre pripad, ze zly typ statusu
    @RequestMapping(value = "/task/changestatus/form/wrongstatus", method = RequestMethod.GET) // url na zavolanie
    public String changeStatusWrongStatus(ModelMap modelMap) {

        Task entity = new Task();
        modelMap.addAttribute("entity", entity);
        return "task/changestatuswrong"; // jsp.file
    }

    // Zmena statusu a zapis do TimeLine
    // Riesenie pre metodu cez localhost - @ModelAttribute("entity")
    @RequestMapping(value = "/task/changestatus", method = RequestMethod.POST)
    public String change(@ModelAttribute("entity") Task entity) throws EndUserNotFoundException {

        String name = entity.getName();
        Long taskId = taskService.findIdByName(serviceContext(), name);
        if (taskId == 0) {
            return "redirect:/rest/task/changestatus/form/notask";
        }

        TaskStatus status = entity.getStatus();

        String personName = entity.getPersonName();
        Long personId = endUserService.findIdByName(serviceContext(), personName);
        if (personId == 0) {
            return "redirect:/rest/task/changestatus/form/nouser";
        }

        Task task = taskService.changeStatus(serviceContext(), name, status, personName);
        if(task != null) {
            return "redirect:/rest/task/"; // url
        } else {
            return "redirect:/rest/task/changestatus/form/wrongstatus";
        }
    }


    // Zmena statusu a zapis do TimeLine
    // Riesenie pre prikazy pomocou curl - @RequestBody
    @RequestMapping(value = "/task/changestatuscurl", method = RequestMethod.POST)
    public String changecurl(@RequestBody Task entity) {

        String name = entity.getName();
        TaskStatus status = entity.getStatus();
        String personName = entity.getPersonName();

        entity = taskService.changeStatus(serviceContext(), name, status, personName);
        return String.format("redirect:/rest/task/%s", entity.getId()); // url, entity
    }


}

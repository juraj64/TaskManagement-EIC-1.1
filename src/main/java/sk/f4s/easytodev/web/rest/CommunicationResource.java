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

import sk.f4s.easytodev.tasks.exception.EndUserNotFoundException;
import sk.f4s.easytodev.tasks.exception.TaskNotFoundException;
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

    // formular pre pripad, ze task name neexistuje
    @RequestMapping(value = "/communication/form/notask", method = RequestMethod.GET)
    public String createFormNoTask(ModelMap modelMap) {
        Communication entity = new Communication();
        modelMap.addAttribute("entity", entity);
        return "communication/createnotask";
    }

    // formular pre pripad, ze user name neexistuje
    @RequestMapping(value = "/communication/form/nouser", method = RequestMethod.GET)
    public String createFormNoUser(ModelMap modelMap) {
        Communication entity = new Communication();
        modelMap.addAttribute("entity", entity);
        return "communication/createnouser";
    }

    // Doplnena overwritnuta metoda pre vytvorenie novej Communication
    @RequestMapping(value = "/communication", method = RequestMethod.POST)
    public String create(@RequestBody Communication entity) throws TaskNotFoundException, EndUserNotFoundException {

        // nacitanie tasku podla name
        Task task;
        String name = entity.getTask().getName();
        Long taskId = taskService.findIdByName(serviceContext(), name);
        if (taskId != 0) {
            task = taskService.findById(serviceContext(), taskId);
            entity.setTask(task);
            entity.setTaskId(taskId);
        } else { // ak task s name neexistuje
            return "redirect:/rest/communication/form/notask";
        }

        // nacitanie sendera podla name
        EndUser sender;
        String senderName = entity.getSenderName();
        Long senderId = endUserService.findIdByName(serviceContext(), senderName);
        if (senderId != 0) {
            sender = endUserService.findById(serviceContext(), senderId);
            entity.setSender(sender);
        } else {
            return "redirect:/rest/communication/form/nouser";
        }

        // nacitanie recipienta podla name
        EndUser recipient;
        String recipientName = entity.getRecipientName();
        Long recipientId = endUserService.findIdByName(serviceContext(), recipientName);
        if (recipientId != 0) {
            recipient = endUserService.findById(serviceContext(), recipientId);
            entity.setRecipient(recipient);
        } else {
            return "redirect:/rest/communication/form/nouser";
        }

        // nastavenie aktualneho casu
        Date date = new Date(System.currentTimeMillis());
        entity.setDate(date);

        communicationService.save(serviceContext(), entity);
        // zmena, aby to nevratilo url danej spravy, ale url celej komunikacie
        return "redirect:/rest/communication";
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
    @RequestMapping(value = "/communication/order/bytask/descending", method = RequestMethod.GET)
    // url stranka na localhoste
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

package ua.i.giggss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.i.giggss.model.Worker;
import ua.i.giggss.service.WorkerService;

@Controller
public class WorkerController {

    private WorkerService workerService;

    @Autowired(required = true)
    @Qualifier(value = "workerService")
    public void setWorkerService(WorkerService workerService) {
        this.workerService = workerService;
    }

    // формерую полный список книг
    @RequestMapping(value = "workers", method = RequestMethod.GET)
    public String listWorkers(Model model) {
        model.addAttribute("worker", new Worker());
        model.addAttribute("listWorkers", this.workerService.listWorkers());

        return "workers";
    }

    @RequestMapping("/workerremove/{id}")
    public String removeWorker(@PathVariable("id") int id) {
        Worker worker = new Worker();
        worker.setWorkerId(id);
        worker.setLastName("empty");
        worker.setName(null);
        worker.setBirthday(null);
        worker.setTelephone(null);
        worker.setPosition(null);
        worker.setSalary(0);
        this.workerService.updateWorker(worker);

        return "redirect:/workers";
    }

    @RequestMapping("workeredit/{id}")
    public String editWorker(@PathVariable("id") int id, Model model) {
        model.addAttribute("worker", this.workerService.getWorkerById(id));
        model.addAttribute("listWorkers", this.workerService.listWorkers());

        return "workers";
    }

    @RequestMapping(value = "/workers/add", method = RequestMethod.POST)
    public String addWorker(@ModelAttribute("worker") Worker worker) {
        if (worker.getWorkerId() == 0) {
            this.workerService.addWorker(worker);
        } else {
            this.workerService.updateWorker(worker);
        }

        return "redirect:/workers";
    }
}
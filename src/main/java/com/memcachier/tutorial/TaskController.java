package com.memcachier.tutorial;

import javax.validation.Valid;
import java.lang.Iterable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class TaskController {

  private TaskRepository taskRepo;

  @Autowired
  public TaskController(TaskRepository repo) {
    this.taskRepo = repo;
  }

  @RequestMapping(method = RequestMethod.GET)
  public String showAllTasks(ModelMap model) {
    Iterable<Task> tasks = this.taskRepo.findAllCached();
    model.addAttribute("tasks", tasks);
    model.addAttribute("newTask", new Task());
    return "task";
  }

  @RequestMapping(method = RequestMethod.POST)
  public String newTask(ModelMap model,
                        @ModelAttribute("newTask") @Valid Task task,
                        BindingResult result) {
    if (!result.hasErrors()) {
      this.taskRepo.saveAndClearCache(task);
    }
    return showAllTasks(model);
  }

  @RequestMapping(method = RequestMethod.DELETE)
  public String deleteTask(ModelMap model, @RequestParam("taskId") Long id) {
    this.taskRepo.deleteByIdAndClearCache(id);
    return showAllTasks(model);
  }
}

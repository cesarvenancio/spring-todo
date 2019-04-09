package com.challenge.todo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.challenge.todo.model.Task;
import com.challenge.todo.model.User;
import com.challenge.todo.service.TaskService;
import com.challenge.todo.service.UserService;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;
    
    @Autowired
    private UserService userService;
    
    @InitBinder  
    public void initBinder(WebDataBinder binder) {  
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));  
    }  

    @PostMapping(value = "/saveTask")
    public ModelAndView saveTask(@Valid Task task, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        
        Task taskExists = taskService.findById(task.getId());
        if (taskExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        
        if (!bindingResult.hasErrors()) {
            task.setUser(user);
            task.setCreatedDate(new Date());
            taskService.saveTask(task);
            modelAndView.addObject("successMessage", "Task has been registered successfully");
        } 
        
        modelAndView.addObject("task", new Task());
        modelAndView.addObject("tasks", taskService.findByUser(user));
        modelAndView.setViewName("admin/home");
        
        return modelAndView;
    }
    
    @GetMapping(value = "/deleteTask/{id}")
    public ModelAndView deleteTask(@PathVariable("id") int taskId) {
        ModelAndView modelAndView = new ModelAndView();
        Task task = taskService.findById(taskId);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        
        if (task != null && task.getUser().equals(user)) {
            taskService.deleteTask(task);
            modelAndView.addObject("successMessage", "Task has been deleted successfully");
        } else {
            modelAndView.addObject("errorMessage", "Task does not exist");
        }
        
        modelAndView.addObject("task", new Task());
        modelAndView.addObject("tasks", taskService.findByUser(user));
        modelAndView.setViewName("admin/home");
        
        return modelAndView;
    }

}

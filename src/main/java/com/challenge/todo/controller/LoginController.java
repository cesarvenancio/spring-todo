package com.challenge.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.challenge.todo.model.Task;
import com.challenge.todo.model.User;
import com.challenge.todo.service.TaskService;
import com.challenge.todo.service.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private TaskService taskService;

    @Autowired
    public LoginController(UserService userService, TaskService taskService) {
       this.userService = userService;
       this.taskService = taskService;
    }
    
    @GetMapping(value={"/", "/login"})
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping(value="/admin/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        
        modelAndView.addObject("task", new Task());
        modelAndView.addObject("tasks", taskService.findByUser(user));

        modelAndView.setViewName("admin/home");
        return modelAndView;
    }


}

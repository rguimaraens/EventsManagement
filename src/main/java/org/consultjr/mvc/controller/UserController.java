/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.consultjr.mvc.controller;

import java.util.List;
import org.consultjr.mvc.core.base.AppController;
import org.consultjr.mvc.core.base.CRUDable;
import org.consultjr.mvc.model.ClassesSubscription;
import org.consultjr.mvc.model.SubscriptionProfile;
import org.consultjr.mvc.model.User;
import org.consultjr.mvc.service.ClassesService;
import org.consultjr.mvc.service.ClassesSubscriptionService;
import org.consultjr.mvc.service.SubscriptionProfileService;
import org.consultjr.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author rgcs
 */
@Controller
@Scope("request")
@RequestMapping("/User")
public class UserController extends AppController implements CRUDable{

    @Autowired
    private UserService userService;
    @Autowired
    private ClassesSubscriptionService subscriptionService;
    @Autowired
    private ClassesService classesService;
    @Autowired
    private SubscriptionProfileService subscriptionProfileService;

    @RequestMapping("") // Index Method: => /PROJECT/User
    @Override
    public ModelAndView index() {
        return this.allUsers();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET) // GET: /PROJECT/User/add
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView("User/_form");
        modelAndView.addObject("user", new User());
        modelAndView.addObject("action", "add");
        modelAndView.addObject("userID", null);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST) // Save Method: POST /PROJECT/User/add
    public ModelAndView addUser(@ModelAttribute User user) {
        ModelAndView modelAndView = new ModelAndView("User/_form");
        userService.addUser(user);
        String message = "User was succesfully added";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("User/_form");
        User user = userService.getUserById(id);
        modelAndView.addObject("user", user);
        modelAndView.addObject("action", "edit");
        modelAndView.addObject("userID", user.getId());
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView updateUser(@ModelAttribute User user, @PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("User/_form");
        userService.updateUser(user, id);
        String message = "User was successfully edited.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("User/_list");
        //TODO checar se houve deleção do usuário!
        userService.deleteUser(userService.getUserById(id));
        List<User> users = userService.getUsers();
        modelAndView.addObject("users", users);
        String message = "User was successfully deleted.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @RequestMapping(value = "/all")
    public ModelAndView allUsers() {
        ModelAndView modelAndView = new ModelAndView("User/_list");
        List<User> users = userService.getUsers();
        modelAndView.addObject("users", users);
        return modelAndView;
    }
    
    @RequestMapping(value = "/all/{id}")
    public ModelAndView allUsers(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("User/_listSubscription");
        List<User> users = userService.getUsers();
        modelAndView.addObject("users", users);
        modelAndView.addObject("classId", id);
        return modelAndView;
    }
    
    
        @RequestMapping(value = "/subscription/{classId}/{userId}/{tipo}")
        public ModelAndView allUsers(@PathVariable int classId, @PathVariable int userId, @PathVariable int tipo) {
        ModelAndView modelAndView = new ModelAndView("User/_listSubscription");
        
        ClassesSubscription subs = new ClassesSubscription();
        subs.setUser(userService.getUserById(userId));
        subs.setClasses(classesService.getClassesById(classId));
        subs.setSubscriptionProfile(subscriptionProfileService.getSubscriptionProfileById(tipo));
        System.out.println("AQUI" + subs.toString());
        subscriptionService.addClassesSubscription(subs);
        
        List<User> users = userService.getUsers();        
        modelAndView.addObject("users", users);
        modelAndView.addObject("message", "Congratulations! The system [barely] works");
        return modelAndView;
    }
    
    
        /*@RequestMapping(value = "/all/{id}")
        public ModelAndView allUsers(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("User/_listSubscription");
        List<User> users = userService.getUsers();
        modelAndView.addObject("users", users);
        modelAndView.addObject("classId", id);
        return modelAndView;
    }*/

}

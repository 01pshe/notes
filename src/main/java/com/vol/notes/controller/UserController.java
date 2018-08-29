package com.vol.notes.controller;

import com.vol.notes.model.User;
import com.vol.notes.services.SecurityService;
import com.vol.notes.services.UserService;
import com.vol.notes.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model){
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm,
                                    BindingResult bindingResult, Model model){
        userValidator.validate(userForm,bindingResult);
        if(bindingResult.hasErrors()){
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getName(),userForm.getPassword());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout){
        if(error!=null){
            model.addAttribute("error","Username or password is incorrect.");
        }

        if (logout!=null){
            model.addAttribute("message","Logged out successfully");
        }

        return "login";
    }

    @RequestMapping(value = {"/","/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model){
        return "welcome";
    }

    @RequestMapping(value = "admin", method = RequestMethod.GET)
    public String admin(Model model){
        return "admin";
    }


}
package com.esense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.esense.service.LoginService;

@Controller
public class LoginController {

	
	  @Autowired
	  private  LoginService service;
	 
	  
	  @RequestMapping(value="/login", method = RequestMethod.GET)
	  public String showLoginPage(){
	        return "login";
	    }
	  
	   @RequestMapping(value="/login", method = RequestMethod.POST)
	    public String showWelcomePage(ModelMap map, @RequestParam String name, @RequestParam String password){
	        boolean isValidUser = service.validateUser(name, password);
	        if (!isValidUser) {
	            map.put("errorMessage", "Invalid Credentials");
	            return "login";
	        }
	        map.put("name", name);
	        map.put("password", password);
	        return "welcome";
	    }

}
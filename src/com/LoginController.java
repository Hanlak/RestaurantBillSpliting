package com;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



//Controller page for Form Validations
@Controller
public class LoginController{//Controlling Login for Restaurant owners
	@Autowired
	LoginDao dao;
	@RequestMapping(value ="/restlogin",method =RequestMethod.GET)
	protected ModelAndView restlogin(){
		ModelAndView modelandview = new ModelAndView("restlogin");
		return modelandview;
		
	}
	//Controlling Login for Customers
	@RequestMapping(value ="/custlogin",method =RequestMethod.GET)
	protected ModelAndView custlogin(){
		ModelAndView modelandview = new ModelAndView("custlogin");
		return modelandview;
		
	}
	//Controlling Restaurant owner's Table Details Form 
	@RequestMapping(value="/restsubmit" ,method =RequestMethod.POST)
	protected ModelAndView restsubmit(@RequestParam("username") String username, @RequestParam("password") String password){
		Login  login = dao.getUserById(username);
		System.out.println(login.getUsername()+login.getPassword());
		ModelAndView model;
		
		if(username.equals(login.getUsername())&& password.equals(login.getPassword()))
		{
			model = new ModelAndView("tableform");
			return model;
		}
		model = new ModelAndView("restlogin","msg","invalid credentials");
		return model;
	}
	//Controlling Customer's Table Details Form 
	@RequestMapping(value="/custsubmit" ,method =RequestMethod.POST)
	protected ModelAndView custsubmit(@RequestParam("username") String username, @RequestParam("password") String password){
	   Login login = dao.getUserById(username);
		ModelAndView model;
		
		if(username.equals(login.getUsername())&& password.equals(login.getPassword()))
		{
			model = new ModelAndView("tablefindform");
			return model;
		}
		model = new ModelAndView("custlogin","msg","invalid credentials");
		return model;
	}
	
		
	}
		

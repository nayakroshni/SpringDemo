package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.UserModel;
import com.example.demo.repository.MaritalRepo;
import com.example.demo.service.UserService;

@Controller
public class HomeController
{
	@Autowired
	UserService userService;
	
	@Autowired
	MaritalRepo maritalRepo;

	@RequestMapping(value = { "", "/", "index" })
	public String index1()
	{
		return "index";
	}

	@RequestMapping("/reqRegistration")
	public ModelAndView reqRegistration()
	{
		ModelAndView mv = new ModelAndView("/regestration");
		mv.addObject("list", maritalRepo.findAll());
		mv.addObject("userList", userService.findAll());
		
		return mv;
	}
	@RequestMapping("/reqEdit/{userID}")
	public ModelAndView reqEditRegistration(@PathVariable Integer userID)
	{
		ModelAndView mv = new ModelAndView("/regestration");
		mv.addObject("list", maritalRepo.findAll());
		mv.addObject("userModel", userService.findById(userID));
		mv.addObject("userList", userService.findAll());
		
		return mv;
	}
	
	@RequestMapping("/reqDelete/{userID}")
	public ModelAndView reqDeleteRegistration(@PathVariable Integer userID)
	{
		userService.deleteById(userID);
		ModelAndView mv = new ModelAndView("/regestration");
		mv.addObject("list", maritalRepo.findAll());
		mv.addObject("userList", userService.findAll());
		
		return mv;
	}

	@RequestMapping("/savePage")
	public String registrationSubmit(@ModelAttribute UserModel userModel)
	{
		userService.save(userModel);
		System.out.println("User Name :=> " + userModel.getFirstName() + " " + userModel.getMiddleName() + " " + userModel.getSurName());
		return "index";
	}
}

package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.UserModel;
import com.example.demo.repository.MaritalRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HomeController
{
	@Autowired
	UserService userService;
	
	@Autowired
	MaritalRepo maritalRepo;
	
	@Autowired
	UserRepo userRepo;

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
	public ModelAndView reqEditRegistration(@PathVariable Integer
			userID)
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
	
	
	@RequestMapping("/userlist")  
    public List<UserModel> allUser() {  
         return userRepo.findAll();  
          
    }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/getUser/{userID}")  
    public Optional<UserModel> getUser(@PathVariable Integer userID) {  
         return userRepo.findById(userID);  
          
    }
	
	@DeleteMapping("/deleteuser/{userID}")  
    public void deleteUser(@PathVariable Integer userID) {  
		userRepo.deleteById(userID);  
    }
	
	
	@RequestMapping("/saveuser")  
    public UserModel saveStudent(@RequestBody UserModel userModel) {
		
		
		
         return userRepo.save(userModel); 
          
    }
	@RequestMapping("/updateuser/{userID}")  
    public UserModel updateStudent(@PathVariable Integer userID,@RequestBody UserModel userModel) {
		
		
		
         return userRepo.save(userModel); 
          
    }
}

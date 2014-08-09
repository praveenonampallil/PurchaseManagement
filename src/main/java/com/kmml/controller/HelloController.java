package com.kmml.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kmml.model.Hello;
import com.kmml.service.HelloService;

@Controller
public class HelloController {
	
	@Autowired
	private HelloService helloService;
	
	@RequestMapping(value="/greeting" , method=RequestMethod.GET)
	public String sayHello(Model model)
	{
		model.addAttribute("hello", new Hello());
		return "addUser";
	}
	
	@RequestMapping(value="/greeting" , method=RequestMethod.POST)
	public String sayHelloTwo( @Valid @ModelAttribute("hello")  Hello hello,BindingResult result )
	{
		System.out.println(result.hasErrors());
		System.out.println("Name:" +hello.getName());
		if(!result.hasErrors())
		{
			helloService.save(hello);
		}
		return "addUser";
	}
	
	@RequestMapping(value="/greeting/{helloId}" , method=RequestMethod.GET)
	public String sayHelloUpdate(Model model,@PathVariable long helloId)
	{
		model.addAttribute("hello", helloService.find(helloId));
		
		return "addUser";
	}
	
	@RequestMapping(value="/greeting/{helloId}" , method=RequestMethod.POST)
	public String sayHelloUpdateTwo(@Valid @ModelAttribute("hello")  Hello hello,BindingResult result,@PathVariable long helloId)
	{

		System.out.println(result.hasErrors());
		System.out.println("Name:" +hello.getName());
		System.out.println("Name:" +hello.getId());
		hello.setId(helloId);
		
		if(!result.hasErrors())
		{
			helloService.update(hello);
		}
		return "addUser";
	}
}

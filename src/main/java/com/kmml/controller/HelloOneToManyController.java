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

import com.kmml.model.HelloOneToMany;
import com.kmml.service.HelloOneToManyService;
import com.kmml.service.HelloService;

@Controller
public class HelloOneToManyController {
	
	@Autowired
	private HelloOneToManyService helloOneToManyService;
	@Autowired
	private HelloService helloService;
	
	@RequestMapping(value="/hello" , method=RequestMethod.GET)
	public String sayHello(Model model)
	{
		
		model.addAttribute("helloOneToMany", new HelloOneToMany());                      
		model.addAttribute("hellos",helloService.findAll());
		
		return "oneToMany";
	}
	
	@RequestMapping(value="/hello" , method=RequestMethod.POST)
	public String sayHelloTwo( @Valid @ModelAttribute("helloOneToMany")  HelloOneToMany helloOneToMany,BindingResult result )
	{
		System.out.println(result.hasErrors());
		System.out.println(result.getAllErrors());
		System.out.println("Name:" +helloOneToMany.getName());
		System.out.println("Name:" +helloOneToMany.getHello());
		if(!result.hasErrors())
		{
			helloOneToManyService.save(helloOneToMany);
		}
		return "oneToMany";
	}
	
	@RequestMapping(value="/hello/{helloOneToManyId}" , method=RequestMethod.GET)
	public String sayHelloUpdate(Model model,@PathVariable long helloOneToManyId)
	{
		model.addAttribute("helloOneToMany", helloOneToManyService.find(helloOneToManyId));
		
		return "oneToMany";
	}
	
	@RequestMapping(value="/hello/{helloOneToManyId}" , method=RequestMethod.POST)
	public String sayHelloUpdateTwo(@Valid @ModelAttribute("helloOneToMany")  HelloOneToMany helloOneToMany,BindingResult result,@PathVariable long helloOneToManyId)
	{

		System.out.println(result.hasErrors());
		System.out.println("Name:" +helloOneToMany.getName());
		System.out.println("Name:" +helloOneToMany.getId());
		helloOneToMany.setId(helloOneToManyId);
		
		if(!result.hasErrors())
		{
			helloOneToManyService.update(helloOneToMany);
		}
		return "oneToMany";
	}

}

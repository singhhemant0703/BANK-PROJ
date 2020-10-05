package com.hss.controller;

import java.beans.BeanProperty;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.hss.command.CustomerCommand;
import com.hss.model.CustomerModel;
import com.hss.service.CustomerManagerServicesImpl;

@Controller
public class CustomerController {

	@Autowired
	private CustomerManagerServicesImpl customerService;
	
	@GetMapping("home")
	public String showHome() {
		return "home";
	}
	@GetMapping("register")
	public String registerCustomer(@ModelAttribute("customer")CustomerCommand command) {
		return "register";
	}
	@PostMapping("save")
	public String saveCustomer(Map<String,Object> map,@ModelAttribute("customer")CustomerCommand cmd) {
		String result=null; 
		CustomerModel model=null;
		 model=new CustomerModel();
		 System.out.println(cmd);
		 BeanUtils.copyProperties(cmd,model);
		 //use service
		 result=customerService.registerCustomer(model);
		 map.put("result",result);
		return "redirect:/register";
	}
	@GetMapping("show_customer")
	public String showRegisterCustomer(CustomerCommand command) {
		return "show";
	}
	
	@GetMapping("remove")
	public String removeCustomer(CustomerCommand command) {
		return "home";
	}
}

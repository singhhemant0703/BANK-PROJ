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
		 
		 BeanUtils.copyProperties(cmd,model);
		 
		 //use service
		 result=customerService.registerCustomer(model);
		 map.put("result",result);
		return "redirect:/register";
	}
	
	@GetMapping("show_customer")
	public String showCheckCustomer(Map<String,Object> map,@ModelAttribute("customer")CustomerCommand command) {
		return "show";
	}
	@PostMapping("show_customer")
	public String showRegisterCustomer(Map<String,Object> map,@ModelAttribute("customer")CustomerCommand command) {
		  CustomerModel model=null;
		  CustomerCommand cmd=null;
		  //create command class object
		  cmd=new CustomerCommand();
		if(command.getPanNo()!=null) {
			 model=customerService.getCustomerBasedOnPanNo(command.getPanNo());
			 BeanUtils.copyProperties(model, cmd);
			 map.put("result",cmd);
		 }
		else if(command.getAadharNo()!=0) {
			model=customerService.getCustomerBasedOnAadharNo(command.getAadharNo());
			BeanUtils.copyProperties(model, cmd);
			 map.put("result",cmd);
		}
		else {
			map.put("output","search customer based on Pan and Aadhar only");
		}
		return "show";
	}
	
	@GetMapping("remove")
	public String removeCustomer(CustomerCommand command) {
		return "home";
	}
	@GetMapping("user-show")
	public String showUsers() {
		return "user-show";
	}
}

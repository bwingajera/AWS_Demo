package com.esense.server.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.esense.entity.Employee;
import com.esense.service.CommonService;
import com.esense.service.impl.CommonServiceImpl;

@Controller
//@RequestMapping(value="employee")
public class EmployeeController {

	@Autowired
	private CommonService commonService; 
	
	@GetMapping(value="/")
	public String login() {
		return "create-employee";
	}
	
	@PostMapping(value="/save")
	public String saveEmployee(@RequestParam("fname")String fname,@RequestParam("lname")String lname,
			@RequestParam("city")String city,@RequestParam("state")String state,@RequestParam("country")String country,
			@RequestParam("address")String address) {
		
		Employee employee=new Employee();
		employee.setAddress(address);
		employee.setCity(city);
		employee.setCountry(country);
		employee.setLastName(lname);
		employee.setFirstName(fname);
		commonService.saveObject(employee);
	
		return "redirect:/employee/";
	}
	
}

package com.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.demo.model.Employee_Foram;
import com.demo.model.JsonResponse;
import com.demo.service.Employee_ForamService;

@Controller
@RequestMapping
public class Employee_ForamController {

	@Autowired
	Employee_ForamService employeeService;

	// load add employee form
	@GetMapping("addEmployee")
	public String addEmp() {
		return "AddEmployee";
	}

	// validate employee
	// load add employee form
	@PostMapping("/validateEmployee")
	public @ResponseBody JsonResponse validateEmployee(@Valid @ModelAttribute("emp") Employee_Foram emp, BindingResult result) {

		JsonResponse res = new JsonResponse();
		/*
		 * ValidationUtils.rejectIfEmpty(result, "name", "Name cannot be empty.");
		 * ValidationUtils.rejectIfEmpty(result, "designation",
		 * "Designation cannot be empty"); ValidationUtils.rejectIfEmpty(result,
		 * "totalExperience", "Total Experience cannot be empty");
		 */

		if (!result.hasErrors()) {
			// userList.add(user);
			res.setStatus("SUCCESS");
			// res.setResult(userList);
		} else { 
			res.setStatus("FAIL");
			res.setResult(result.getAllErrors());
		}

		return res;
	}

	// save employee
	// load add employee form
	@PostMapping("/insertEmployee")
	public String insertEmployee(@ModelAttribute("insertEmployee") Employee_Foram emp, Model m,
			BindingResult result) {

		 employeeService.addEmployee(emp);
		 m.addAttribute("successMsg","Employee Registered Successfully...!!");
		return "AddEmployee";
	}

	// get all employee data
	@GetMapping("/employeeReport")
	public String getAllEmployee(Model m) {
		m.addAttribute("employee", employeeService.getAllEmployee());
		m.addAttribute("title", "Employee Report");
		return "EmployeeReport";
	}

	// load edit employee form
	@GetMapping("/editEmployee/{id}")
	public String loadEditForm(@PathVariable(value = "id") int id, Model m) {
		Employee_Foram emp = employeeService.getEmpById(id);
		System.out.println(emp);
		m.addAttribute("employee", emp);
		m.addAttribute("title", "Edit Employee");
		return "EditEmployee";
	}

	@PostMapping("editEmployee/updateEmployee")
	public String updateEmployee(@ModelAttribute("updateEmployee") Employee_Foram emp) {
		employeeService.updateEmp(emp);
		return "redirect:/employeeReport";
	}

	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable int id) {
		employeeService.deleteEmp(id);
		return "redirect:/employeeReport";
	}
}

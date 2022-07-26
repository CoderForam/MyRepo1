package com.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.dao.Employee_ForamDao;
import com.demo.model.Employee_Foram;


@Service
public class Employee_ForamService {

	@Autowired
	Employee_ForamDao employeeDao;
	
	//add employee
		public void addEmployee(Employee_Foram emp) {
			employeeDao.addEmployee(emp);
		}
		
		// get all employee
		public List<Employee_Foram> getAllEmployee() {
			return employeeDao.getAllEmployee();
		}
		
		// get employee by id
		public Employee_Foram getEmpById(int id) {
			return employeeDao.getEmpById(id);
		}
		
		//update employee
		public void updateEmp(Employee_Foram emp) {
			employeeDao.updateEmp(emp);
		}
		
		// delete employee
		public void deleteEmp(int id) {
			employeeDao.deleteEmp(id);
		}
}

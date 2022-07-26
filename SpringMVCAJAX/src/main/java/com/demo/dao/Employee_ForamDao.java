package com.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.demo.model.Employee_Foram;

@Component
public class Employee_ForamDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	//add employee
	@Transactional
	public void addEmployee(Employee_Foram emp) {
		hibernateTemplate.save(emp);
	}
	
	// get all employee
	public List<Employee_Foram> getAllEmployee() {
		return hibernateTemplate.loadAll(Employee_Foram.class);
	}
	
	// get employee by id
	public Employee_Foram getEmpById(int id) {
		return hibernateTemplate.get(Employee_Foram.class, id);
	}
	
	//update employee
	@Transactional
	public void updateEmp(Employee_Foram emp) {
		hibernateTemplate.update(emp);
	}
	
	// delete employee
	@Transactional
	public void deleteEmp(int id) {
		hibernateTemplate.delete(hibernateTemplate.load(Employee_Foram.class, id));
	}
}
